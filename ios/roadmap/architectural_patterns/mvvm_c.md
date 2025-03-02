# MVVM-C

MVVM-C (Model-View-ViewModel-Coordinator) is an extension of the MVVM architectural pattern that adds a Coordinator component to manage navigation flow and app structure. In this pattern:

Model, View, and ViewModel retain their roles from MVVM.

Coordinator: Handles navigation logic and flow between different screens or modules of the app.

The Coordinator pattern decouples view controllers from each other, centralizing navigation logic. This approach simplifies view controllers, improves modularity, and makes it easier to change or reuse flows within the app. Coordinators can be nested for complex navigation hierarchies.