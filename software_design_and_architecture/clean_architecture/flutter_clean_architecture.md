# Layers

- Domain
- Data
- Presentation

# Domain Layer

This is the heart of your application.

It contains:

- Entities: Business objects (e.g., User, Product, NumberTrivia). These are pure Dart classes, free from framework dependencies.

- Use Cases (Interactors): Business logic operations (e.g., GetUserData, PlaceOrder, GetConcreteNumberTrivia). They orchestrate entities and repositories.

- Repositories (Interfaces): Abstract definitions of data access. They define what data operations are possible, not how they're implemented.

This layer knows nothing about the outside world.

# Data Layer

Handles data retrieval and manipulation.

- Models: Data transfer objects (DTOs) that map to external data sources (e.g., JSON from an API).

- Data Sources: Classes that interact with external data (e.g., API calls, database queries).

- Repositories (Implementations): Concrete implementations of the repository interfaces defined in the domain layer. They use data sources to fetch and process data.

Note:

- Entities are about "what" the business objects are and "how" they behave within the application's domain.

- Models are about "how" data is transferred between the application and external sources.

- Often, data from a model is used to create or update an entity.

Therefore the entity is the core business object, and the model is the data structure that transfers data to and from external sources.
 
# Presentation Layer

Handles the UI and user interactions.

Handles the UI and user interactions.
It contains:
- UI Components (Widgets): Flutter widgets that display data and handle user input.
- State Management (Bloc, Cubit, Provider, Riverpod): Manages the UI state and interacts with use cases.
- Dependency Injection: Injects use cases into the presentation layer.
