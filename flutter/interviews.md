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