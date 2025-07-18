# WebApp Solution

A comprehensive C# web application solution built with .NET 9.0.

## What is a Solution?

A **Solution** in .NET is a container that organizes one or more related projects. It's defined by a `.sln` file and serves as:

- A logical grouping of related projects
- A way to manage dependencies between projects
- A unit for building, testing, and deploying multiple projects together
- A workspace for development tools like Visual Studio and VS Code

In this solution, we have two complementary web projects that can work together to provide a complete web application experience.

## Project Architecture

This solution consists of two main projects:

### 1. WebApp.Api
**Type:** ASP.NET Core Web API  
**Port:** HTTPS: 7041, HTTP: 5247  
**Purpose:** Backend API service

#### Key Features:

- RESTful API endpoints
- OpenAPI/Swagger documentation support
- Minimal API architecture
- JSON-based data exchange

#### Configuration:

- Target Framework: .NET 9.0
- Nullable reference types enabled
- Implicit usings enabled
- Microsoft.AspNetCore.OpenApi package for API documentation

#### Typical Use Cases:

- Serves data to frontend applications
- Provides business logic and data processing
- Can be consumed by mobile apps, SPAs, or other services
- Stateless operations with JSON responses

### 2. WebAppMVC.Web
**Type:** ASP.NET Core MVC Web Application  
**Port:** HTTPS: 7262, HTTP: 5178  
**Purpose:** Frontend web application with server-side rendering

#### Key Features:
- Model-View-Controller (MVC) pattern
- Server-side HTML rendering
- Bootstrap CSS framework integration
- jQuery and validation libraries
- Static file serving (CSS, JS, images)

#### Structure:
- **Controllers/**: Handle HTTP requests and coordinate between models and views
- **Models/**: Data structures and business logic
- **Views/**: HTML templates with Razor syntax
- **wwwroot/**: Static web assets (CSS, JavaScript, images)

#### Configuration:
- Target Framework: .NET 9.0
- Controllers with Views support
- Static assets pipeline
- Exception handling and HSTS for production

## How Projects Interact

### Current Architecture
Currently, both projects are **independent** and run on different ports:
- API runs on port 7041 (HTTPS) / 5247 (HTTP)
- MVC Web runs on port 7262 (HTTPS) / 5178 (HTTP)

### Potential Integration Patterns

#### 1. **API-First Architecture**
The MVC web application can consume the API:
```
User → WebAppMVC.Web (UI) → WebApp.Api (Data/Logic) → Database
```

#### 2. **Microservices Pattern**
Both projects can serve different client types:
```
Web Browser → WebAppMVC.Web (HTML/CSS/JS)
Mobile App  → WebApp.Api (JSON)
SPA         → WebApp.Api (JSON)
```

#### 3. **Backend for Frontend (BFF)**
The MVC app acts as a BFF, aggregating API calls:
```
Browser → WebAppMVC.Web → Multiple APIs (including WebApp.Api)
```

## Getting Started

### Prerequisites
- .NET 9.0 SDK
- Visual Studio Code or Visual Studio
- Terminal/Command Prompt

### Running the Projects

#### Option 1: Run Individual Projects
```bash
# Run the API
cd WebApp.Api
dotnet run

# Run the MVC Web App (in another terminal)
cd WebAppMVC.Web
dotnet run
```

#### Option 2: Run from Solution Level
```bash
# Build entire solution
dotnet build WebAppSolution.sln

# Run specific project
dotnet run --project WebApp.Api
dotnet run --project WebAppMVC.Web
```

### Accessing the Applications

- **API**: https://localhost:7041 (includes OpenAPI/Swagger documentation)
- **Web App**: https://localhost:7262 (opens automatically in browser)

## Development Workflow

1. **Solution Management**: Use the `.sln` file to manage both projects together
2. **Dependency Management**: Add NuGet packages to individual projects as needed
3. **Shared Libraries**: Create additional class library projects for shared code
4. **Configuration**: Use `appsettings.json` files for environment-specific settings
5. **Testing**: Add test projects to the solution for unit and integration testing

## Next Steps

To enhance this solution, consider:

1. **Add Project References**: Make WebAppMVC.Web consume WebApp.Api
2. **Shared Models**: Create a shared class library for common data models
3. **Authentication**: Implement identity and authorization across both projects
4. **Database Integration**: Add Entity Framework Core for data persistence
5. **Testing Projects**: Add unit and integration test projects
6. **Docker Support**: Containerize both applications for deployment

## Technology Stack

- **.NET 9.0**: Latest .NET framework
- **ASP.NET Core**: Web framework for both API and MVC
- **OpenAPI**: API documentation and testing
- **Bootstrap**: CSS framework for responsive design
- **jQuery**: JavaScript library for client-side interactions