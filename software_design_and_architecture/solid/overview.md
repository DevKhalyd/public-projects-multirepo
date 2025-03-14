# SOLID

## Single Responsibility Principle (SRP)

It should have only one responsibility

Separate classes: ReportGenerator (generates the report) and ReportSaver (saves the report). Each class has its own functionality.

## Open-Closed principle

This means that a class should be extendable without modifying the class itself.

## Liskov Substitution Principle

This means that every subclass or derived class should be substitutable for their base or parent class.

Use bird example with FlyingBird and NonFlyingBird

## Interface Segregation Principle (ISP)

Clients should not be forced to depend on interfaces they do not use

## Dependency Inversion Principle

- High-level modules should not depend on low-level modules. Both should depend on abstractions.
- Abstractions should not depend on details. Details should depend on abstractions.

Good: A ReportGenerator class that depends on an abstraction (e.g., a Database interface). Concrete database classes (e.g., MySQLDatabase, PostgreSQLDatabase) implement the Database interface. 