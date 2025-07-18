using Microsoft.Extensions.Diagnostics.HealthChecks;

namespace WebApp.Api.HealthChecks;

public class ApiHealthCheck : IHealthCheck
{
    public Task<HealthCheckResult> CheckHealthAsync(HealthCheckContext context, CancellationToken cancellationToken = default)
    {
        try
        {
            // Simulate checking various components of your API
            var isHealthy = CheckApiComponents();
            
            if (isHealthy)
            {
                return Task.FromResult(HealthCheckResult.Healthy("API is running smoothly", new Dictionary<string, object>
                {
                    ["timestamp"] = DateTime.UtcNow,
                    ["version"] = "1.0.0",
                    ["environment"] = Environment.GetEnvironmentVariable("ASPNETCORE_ENVIRONMENT") ?? "Production",
                    ["uptime"] = GetUptime()
                }));
            }
            else
            {
                return Task.FromResult(HealthCheckResult.Unhealthy("API has issues"));
            }
        }
        catch (Exception ex)
        {
            return Task.FromResult(HealthCheckResult.Unhealthy("API health check failed", ex));
        }
    }

    private bool CheckApiComponents()
    {
        return true;
    }

    private string GetUptime()
    {
        var startTime = DateTime.UtcNow.AddHours(-2); // Simulate 2 hours uptime
        var uptime = DateTime.UtcNow - startTime;
        return $"{uptime.Days}d {uptime.Hours}h {uptime.Minutes}m {uptime.Seconds}s";
    }
}
