# VIPER

VIPER (View, Interactor, Presenter, Entity, Router) is an architectural pattern for iOS applications that adheres to clean architecture principles. It breaks down app components into five distinct roles:

**View:** Displays information and sends user actions to the Presenter.

**Interactor:** Contains business logic and data manipulation.

**Presenter:** Mediates between View and Interactor, formats data for display.

**Entity:** Represents basic model objects used by the Interactor.

**Router:** Handles navigation logic between modules.

VIPER aims to create a clear separation of concerns, improving testability and maintainability. It’s particularly useful for large, complex applications where scalability is crucial.