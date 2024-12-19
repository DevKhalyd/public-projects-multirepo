# Navigation Stacks

iOS 16 introduced a new concept of navigating through SiwftUI apps: NavigationStack. NavigationStack is data-driven, meaning that you specify navigationDestinations for each data type (models) that your app supports. These destinations are defined once for each NavigationStack and are valid throughout the app. Navigation itself is handled through the NavigationLink View, which allows setting a label and a value (your model).


# NavigationLink

NavigationLink is a SwiftUI component used to create navigation hierarchies within an app. It enables developers to define navigation paths between views, typically within a NavigationView. When tapped, a NavigationLink pushes a new view onto the navigation stack. It can be configured with a destination view and optional label, allowing for customizable navigation buttons or entire rows in lists to become navigable. NavigationLink supports programmatic navigation through bindings, enabling dynamic navigation based on app state.

# Presenting / Dismissing views

SwiftUI offers several methods for presenting and dismissing views, providing flexible options for modal presentations and navigation. Sheets can be presented using the .sheet() modifier, allowing full or partial screen overlays. For alerts and action sheets, .alert() and .actionSheet() modifiers are used. Popovers are created with the .popover() modifier, typically for iPad interfaces. Full-screen covers use the .fullScreenCover() modifier.

To dismiss these presented views, SwiftUI uses the @Environment(.presentationMode) property wrapper, allowing views to dismiss themselves. For navigation-based presentations, NavigationLink handles showing new views, while the .navigationBarItems() modifier can add dismiss functionality. These tools enable developers to create diverse and interactive user interfaces with smooth transitions between different view states.
