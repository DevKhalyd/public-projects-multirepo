using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using WebAppMVC.Web.Models;

namespace WebAppMVC.Web.Controllers;

public class HomeController : Controller
{
    private readonly ILogger<HomeController> _logger;
    private static List<TodoItem> _todos = new List<TodoItem>
    {
        new TodoItem { Id = 1, Title = "Learn ASP.NET Core", Description = "Study MVC pattern and Razor views", IsCompleted = false },
        new TodoItem { Id = 2, Title = "Build a Todo App", Description = "Create a simple todo application", IsCompleted = false },
        new TodoItem { Id = 3, Title = "Deploy to Azure", Description = "Learn how to deploy applications", IsCompleted = false }
    };
    private static int _nextId = 4;

    public HomeController(ILogger<HomeController> logger)
    {
        _logger = logger;
    }

    public IActionResult Index()
    {
        return View(_todos);
    }

    [HttpPost]
    public IActionResult AddTodo(string title, string description)
    {
        if (!string.IsNullOrWhiteSpace(title))
        {
            _todos.Add(new TodoItem 
            { 
                Id = _nextId++, 
                Title = title, 
                Description = description ?? string.Empty,
                IsCompleted = false 
            });
        }
        return RedirectToAction("Index");
    }

    [HttpPost]
    public IActionResult ToggleTodo(int id)
    {
        var todo = _todos.FirstOrDefault(t => t.Id == id);
        if (todo != null)
        {
            todo.IsCompleted = !todo.IsCompleted;
        }
        return RedirectToAction("Index");
    }

    [HttpPost]
    public IActionResult DeleteTodo(int id)
    {
        var todo = _todos.FirstOrDefault(t => t.Id == id);
        if (todo != null)
        {
            _todos.Remove(todo);
        }
        return RedirectToAction("Index");
    }

    public IActionResult Privacy()
    {
        return View();
    }

    [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
    public IActionResult Error()
    {
        return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
    }
}
