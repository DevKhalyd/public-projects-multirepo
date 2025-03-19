# Clean Architecture

Clean Architecture provides a way to structure applications that separate the different components of an application into modules, each with a well-defined purpose. The main idea behind Clean Architecture is to separate the application into three main layers: the presentation layer, the domain layer, and the data layer.

![Clean Architecture Code Overview](assets/ca_overview.png)

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

## Extras Folders

**core:** The core folder is a fundamental module housing key components like utils, routes, network, services, validators, translators and styles. Its content can be tailored by developers to improve code cleanliness and adapt to evolving project needs, ensuring simplicity, modularity, and ease of maintenance.

**shared:** The shared folder, it is like features folder but for common feature in our application, like payment feature, shared pages, shared widgets, abd others.

Reference Article: https://medium.com/@yamen.abd98/clean-architecture-in-flutter-mvvm-bloc-dio-79b1615530e1

![Clean Architecture Code Overview](assets/ca_code_overview.png)

# MVVM and Clean Architecture

TODO: Define how MVVM works along with CA,take same reference