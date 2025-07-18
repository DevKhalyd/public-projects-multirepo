using Microsoft.Extensions.Diagnostics.HealthChecks;
using System.Text.Json;
using WebApp.Api.HealthChecks;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
// Learn more about configuring OpenAPI at https://aka.ms/aspnet/openapi
builder.Services.AddOpenApi();

// Add health checks
builder.Services.AddHealthChecks()
    .AddCheck<ApiHealthCheck>("api_health_check")
    .AddCheck("memory", () =>
    {
        var allocatedBytes = GC.GetTotalMemory(false);
        var memoryMB = allocatedBytes / 1024 / 1024;
        
        return memoryMB < 512 
            ? HealthCheckResult.Healthy($"Memory usage: {memoryMB} MB")
            : HealthCheckResult.Degraded($"High memory usage: {memoryMB} MB");
    })
    .AddCheck("disk_space", () =>
    {
        var drives = DriveInfo.GetDrives().Where(d => d.IsReady);
        var hasLowSpace = drives.Any(d => d.AvailableFreeSpace < 1_000_000_000); // Less than 1GB
        
        return hasLowSpace 
            ? HealthCheckResult.Degraded("Low disk space detected")
            : HealthCheckResult.Healthy("Sufficient disk space available");
    });

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.MapOpenApi();
}

app.UseHttpsRedirection();

// Health check endpoints
app.MapHealthChecks("/healthcheck", new Microsoft.AspNetCore.Diagnostics.HealthChecks.HealthCheckOptions
{
    ResponseWriter = async (context, report) =>
    {
        context.Response.ContentType = "application/json";
        
        var response = new
        {
            status = report.Status.ToString(),
            timestamp = DateTime.UtcNow,
            totalDuration = report.TotalDuration.TotalMilliseconds,
            checks = report.Entries.Select(entry => new
            {
                name = entry.Key,
                status = entry.Value.Status.ToString(),
                description = entry.Value.Description,
                duration = entry.Value.Duration.TotalMilliseconds,
                data = entry.Value.Data
            })
        };
        
        await context.Response.WriteAsync(JsonSerializer.Serialize(response, new JsonSerializerOptions
        {
            WriteIndented = true,
            PropertyNamingPolicy = JsonNamingPolicy.CamelCase
        }));
    }
});

// Simple health check endpoint
app.MapHealthChecks("/health");

// Detailed health check for monitoring systems
app.MapGet("/healthcheck/detailed", async (IServiceProvider serviceProvider) =>
{
    var healthCheckService = serviceProvider.GetRequiredService<HealthCheckService>();
    var report = await healthCheckService.CheckHealthAsync();
    
    return Results.Json(new
    {
        status = report.Status.ToString(),
        timestamp = DateTime.UtcNow,
        totalDuration = report.TotalDuration.TotalMilliseconds,
        apiInfo = new
        {
            name = "WebApp.Api",
            version = "1.0.0",
            environment = Environment.GetEnvironmentVariable("ASPNETCORE_ENVIRONMENT") ?? "Production",
            machineName = Environment.MachineName,
            osVersion = Environment.OSVersion.ToString(),
            processorCount = Environment.ProcessorCount
        },
        checks = report.Entries.Select(entry => new
        {
            name = entry.Key,
            status = entry.Value.Status.ToString(),
            description = entry.Value.Description,
            duration = entry.Value.Duration.TotalMilliseconds,
            data = entry.Value.Data,
            exception = entry.Value.Exception?.Message
        })
    }, new JsonSerializerOptions
    {
        WriteIndented = true,
        PropertyNamingPolicy = JsonNamingPolicy.CamelCase
    });
})
.WithName("GetDetailedHealthCheck");

var summaries = new[]
{
    "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
};

app.MapGet("/weatherforecast", () =>
{
    var forecast =  Enumerable.Range(1, 5).Select(index =>
        new WeatherForecast
        (
            DateOnly.FromDateTime(DateTime.Now.AddDays(index)),
            Random.Shared.Next(-20, 55),
            summaries[Random.Shared.Next(summaries.Length)]
        ))
        .ToArray();
    return forecast;
})
.WithName("GetWeatherForecast");

app.Run();

record WeatherForecast(DateOnly Date, int TemperatureC, string? Summary)
{
    public int TemperatureF => 32 + (int)(TemperatureC / 0.5556);
}
