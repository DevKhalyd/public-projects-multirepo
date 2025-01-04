# Code Clean Principles

Clean code is code that is easy to read, understand, and maintain. It follows a set of principles that are designed to make the code more readable, testable, and less error-prone. Some of the key principles of clean code include:

- Clarity: The code should be easy to read and understand.
- Simplicity: The code should be as simple as possible, avoiding unnecessary complexity.
- Comments: Comments should be used sparingly and only when necessary to explain complex or non-obvious code.
- **Naming: Variables, functions, and classes should have meaningful and descriptive names.**
- Formatting: The code should be consistently formatted to improve readability.
- Functionality: The code should be organized into small, single-purpose functions and classes.
- **Error handling: The code should handle errors in a consistent and predictable way.**
- Testing: The code should be testable and have a high test coverage.
- Reusability: The code should be designed to be reusable and modular.
- **Performance: The code should be designed to be efficient and performant.**

## Keep it Small

You should design and implement small, focused components that serve a specific purpose, rather than large, monolithic components that try to do everything. This can help to improve the maintainability and scalability of the system by making it easier to understand, test, and modify individual components.


## Pure Functions

A pure function is a specific type of function that meets the following criteria:

- It takes some input, known as arguments, and returns a value or output.
- It does not cause any observable side effects, such as modifying the state of the system or interacting with external resources.
- Given the same input, it will always return the same output.
- It does not depend on any state or variables that are outside of its scope.
- Pure functions are considered to be more predictable and easier to test, as their behavior is determined solely by the input they receive and their internal logic.

They also make it easier to reason about the behavior of a program, since the output of a pure function is not affected by any external factors. Pure functions are often used in functional programming, where they are considered a key principle. They are also useful in concurrent and parallel programming, as they are less prone to race conditions and other concurrency-related issues.

## Avoid Passing Nulls Booleans

Passing nulls or Booleans can lead to unexpected behavior and difficult-to-debug errors in a program. Here are some ways to avoid passing nulls or Booleans in system architecture:

- Use Optionals or Maybe types instead of nulls to indicate the absence of a value. 

- This makes it clear when a value is missing and prevents null reference exceptions.

- Use a default value for function arguments instead of allowing them to be null or 
Boolean. This eliminates the need to check for null or Boolean values and reduces the potential for errors.

- Use the Null Object pattern to replace null values with a special object that has a defined behavior. This eliminates the need to check for null values and makes the code more readable.
- Use the Ternary operator (?:) instead of if-else statements when working with Booleans. This can make the code more concise and easier to read.
Use the assert function to check the validity of function arguments and throw an exception if they are invalid.

## Keep Tests Independent

Keeping tests independent helps ensures that the tests are reliable, repeatable, and easy to maintain. When tests are independent, a change in one test will not affect the results of other tests.

Here are some ways to keep tests independent in system architecture:

- Use dependency injection to decouple the test code from the application code. This allows the tests to be run without the need to instantiate the application objects directly.
- Use mocks or stubs to isolate the test from external dependencies such as databases, APIs, or other services.
- Use test data that is self-contained and does not rely on external data or state.
- Use a test framework that supports running tests in parallel, so that the tests can be run independently of each other.
- Use test-driven development (TDD), which involves writing tests before writing the application code. This ensures that the tests are independent and that the code is written with testability in mind.
Avoid global state and shared mutable state as it may cause unexpected results.

## Avoid Hasty Abstractions

Creating abstractions is an important part of software development, but creating too many abstractions or creating them too early can lead to unnecessary complexity and make the code harder to understand and maintain.

Here are some ways to avoid hasty abstractions in system architecture:

- Understand the problem that needs to be solved before creating an abstraction.
- Start with a simple solution and only create an abstraction when it becomes clear that the solution is becoming too complex.
- Use code refactoring techniques to simplify the code before creating an abstraction.
- Avoid creating abstractions for the sake of creating abstractions.
- Use established design patterns and practices when creating abstractions, but do not force them into the code.
- Use automated testing to ensure that the abstraction does not introduce new bugs or break existing functionality.
- Create abstraction in a way that it’s easy to test, debug, and reason about.

