# MVP

The Model-View-Presenter (MVP) architectural pattern is a derivative of the Model-View-Controller (MVC) pattern, designed to improve separation of concerns and testability in iOS applications.

In MVP:

**Model:** Represents the data and business logic.

**View:** Responsible for displaying data and capturing user inputs. It’s typically passive and doesn’t contain business logic.

**Presenter:** Acts as an intermediary between Model and View. It retrieves data from the Model, formats it for the View, and reacts to user inputs from the View.

MVP reduces the responsibilities of the View compared to MVC, making the UI layer thinner and more easily testable. The Presenter contains the presentation logic and is usually paired with a specific View, facilitating unit testing of the user interface logic without needing to interact with the UI components directly.