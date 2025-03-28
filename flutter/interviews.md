# What are the interfaces in dart?

- Interface defines a contract. It specifies a set of methods (and sometimes properties) that a class must implement.
- Think of it as a blueprint or a set of rules that a class must follow.
- Interfaces allow for polymorphism, meaning you can treat different objects in a uniform way as long as they adhere to the same interface.

# What is an enum in dart?

It is used in programming to create a fixed list of possible values, making code more readable and reducing the chances of using invalid values.

# Class Modifiers

abstract:
Defines a class that cannot be instantiated.
Used to create blueprints for other classes or to define interfaces (especially with abstract interface).
Can contain abstract methods (no implementation) and concrete methods.

base:
Indicates a class intended to be extended within its own package.
Provides a controlled way to create base classes, limiting extension outside the package.

final:
Prevents a class from being extended.
Ensures the class's implementation remains unchanged.

interface:
Defines a contract that classes can implement.
abstract interface is used to create interfaces that contain only abstract methods.
Allows for polymorphism.

sealed:
Restricts which classes can extend a sealed class.
All allowed subclasses must be declared in the same library as the sealed class.
Enables exhaustive switch statements, ensuring all possible subclasses are handled.

# What are the flavors in flutter?

In Flutter, flavors refer to different configurations of the same app, typically used to customize the app for various environments or use cases. These flavors allow you to build different versions of the app (e.g., a production version, a development version, or a staging version) using the same codebase but with different settings, like API endpoints, app names, themes, or icons.

For example, you might have:

- Development flavor: Configured to use test APIs and have debug tools enabled.

- Staging flavor: Set up to test with staging servers, closer to production but not final.

- Production flavor: The final version that will be released to the app store with optimized settings.

# Mixins and Extensions, what are the differences?


## Mixin

To share behavior across multiple classes.

Used On: Classes that mix in additional behavior.

Example: Adding shared behavior across many classes.

## Extension

To add functionality to an existing class.

Use On: A specific class, type, or object.

Example: Extending String or List with utility methods.


# What are some strategies for optimizing the performance of a complex Flutter app?

- Minimize widget rebuilds: Use const constructors, shouldRebuild for AnimatedBuilder, and ValueListenableBuilder.

- Efficient list rendering: Use ListView.builder for large lists.

- Avoid excessive overdraw: Use Opacity wisely and avoid redundant layers.

- Profile your app: Use Flutter’s performance tools like the DevTools suite to identify bottlenecks.

Basically follow good practices for Flutter and programming in general.

# How to check memory leaks in the Flutter app and what are the ways to avoid memory leaks?

Use the Dart DevTools memory profiler to identify and analyze memory usage. Avoid memory leaks by:

Properly disposing of controllers: Always call dispose for controllers, animation objects, and other resources.
Avoiding circular references: Ensure that your objects are not inadvertently holding references to each other.

# What are the best practices for making Flutter apps accessible to users with disabilities?

**Use semantic widgets:** Use widgets like Semantics to provide accessible labels and roles.

**Ensure contrast and readability:** Use high-contrast colors and readable font sizes.

**Support screen readers:** Test with screen readers and provide meaningful descriptions.

**Keyboard navigation:** Ensure your app can be navigated using a keyboard or other assistive devices.

# What is BuildContext?

In Flutter, BuildContext is an immutable reference to a widget’s location in the widget tree. It is used to find information about the widget’s position and properties, access inherited widgets, navigate between screens, and more.
   
# Do more research

- Dio HTTP client package (Just an overview)
- Research about the version in git and apps for Android and iOS