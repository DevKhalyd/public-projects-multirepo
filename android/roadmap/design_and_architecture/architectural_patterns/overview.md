# Architectural Patterns

Architectural patterns define the high-level structure of a software system, guiding how components interact and organize themselves to achieve scalability, maintainability, and performance.

# MVI

The MVI Model-View-Intent pattern is a reactive architectural pattern, similar to MVVM and MVP, focusing on immutability and handling states in unidirectional cycles. The data flow is unidirectional: Intents update the Model’s state through the ViewModel, and then the View reacts to the new state. This ensures a clear and predictable cycle between logic and the interface.

- Model: Represents the UI state. It is immutable and contains all the necessary information to represent a screen.

- View: Displays the UI state and receives the user’s intentions.

- Intent: The user’s intentions trigger state updates, managed by the ViewModel.

# MVVM

The Model-View-ViewModel (MVVM) pattern is a software architectural pattern commonly used in UI development. It is designed to separate the concerns of an application, making the code more modular, testable, and maintainable.

Components:

- Model: Refers either to a domain model, which represents real state content (an object-oriented approach), or to the data access layer, which represents content.

- View: The view is the structure, layout, and appearance of what a user sees on the screen.

- ViewModel: The view model is an abstraction of the view exposing public properties and commands. The view model has been described as a state of the data in the model.

# MVP

The MVP Model View Presenter pattern is a derivative of the well-known MVC Model View Controller pattern and is one of the most popular patterns for organizing the presentation layer in Android applications.

MVP is divided into three components:

- Model: Responsible for managing the data input to the app. This can often be an Interactor or UseCase, handling the business logic and data operations.

- View: Takes care of updating the graphical part of the application. It acts as a passive view, only receiving data and requesting actions to be performed.

- Presenter: Handles all the logic related to the graphical interface that the View requests. It provides the View with the data it needs to display on the screen.

# MVC


MVC or Model View Controller is a software design pattern commonly used for developing user interfaces that divides the related program logic into three interconnected components.

Components:

- Model: The internal representations of information. This can often be an Interactor or UseCase

- View: The interface that presents information to and accepts it from the user

- Controller: The controller contains logic that updates the model and/or view in response to input from the users of the app.

# Design Patterns

Put its description.
