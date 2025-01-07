# Overview

There are many software design principles that aim to guide the development of software in a way that makes it easy to understand, maintain, and extend. Some of the most common design principles include:

- SOLID principles (Single Responsibility Principle, Open/Closed Principle, Liskov - Substitution Principle, Interface Segregation Principle, and Dependency Inversion - Principle)
- DRY (Don’t Repeat Yourself)
- YAGNI (You Ain’t Gonna Need It)
- KISS (Keep It Simple, Stupid)
- LoD (Law of Demeter)
- Composition over Inheritance
- Encapsulate What Varies
- Hollywood Principle
- Program Against Abstractions

## Composition over Inheritance

Composition over inheritance is a programming principle that suggests that it is better to use composition, a mechanism for assembling objects, to create complex objects, rather than using inheritance, which is a mechanism for creating new classes based on existing ones.

Inheritance is a powerful mechanism for creating reusable code, but it can also lead to tightly coupled, hard-to-maintain code. This is because inherited classes are tightly bound to their parent classes and any changes made to the parent class will affect all of its child classes. This makes it hard to change or extend the code without affecting the entire class hierarchy.

## Encapsulate What Varies

Encapsulate what varies is a programming principle that suggests that code should be organized in such a way that the parts that are likely to change in the future are isolated from the parts that are unlikely to change. This is accomplished by creating interfaces and classes that separate the varying parts of the code from the stable parts.

Encapsulating what varies allows for more flexibility in the code. When changes are needed, they can be made to the encapsulated parts without affecting the rest of the code. This makes it easier to understand, test, and maintain the code.

## Program Against Abstractions

Programming against abstractions is a programming principle that suggests that code should be written in such a way that it is not tied to specific implementations, but rather to abstractions. This is accomplished by defining interfaces or abstract classes that define the behavior of a group of related classes without specifying their implementation.

Programming against abstractions allows for more flexibility in the code. When changes are needed, they can be made to the implementation of the abstractions without affecting the code that uses them. This makes it easier to understand, test, and maintain the code.

## Hollywood Principle

The Hollywood Principle is a software development principle that states: “Don’t call us, we’ll call you.” It suggests that high-level components should dictate the flow of control in an application, rather than low-level components.

This principle is often used in the context of inversion of control (IoC) and dependency injection. In traditional software development, low-level components are responsible for creating and managing the high-level components that they depend on. With IoC, the high-level components dictate the flow of control, and the low-level components are created and managed by a separate mechanism.

