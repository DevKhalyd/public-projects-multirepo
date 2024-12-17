# Basic Interfaces

UIKit Basic Interfaces refer to the fundamental user interface elements provided by the UIKit framework for creating standard iOS app layouts. These include navigation bars (UINavigationBar) for hierarchical navigation, tab bars (UITabBar) for switching between app sections, toolbars (UIToolbar) for displaying action buttons, and status bars for system information. Basic interfaces also encompass common screen layouts like list views (UITableView), grid layouts (UICollectionView), and scroll views (UIScrollView) for handling content that exceeds screen size. Mastering these basic interfaces ensures developers can create consistent, platform-native app experiences that users find familiar and intuitive, while providing a solid foundation for more complex UI designs.

- UINavigationBar
- UITabBar
- UIToolBar
- UITableView
- UICollectionView

# Storyboards

A storyboard is a visual representation of the user interface of an iOS application, showing screens of content and the connections between those screens. A storyboard is composed of a sequence of scenes, each of which represents a view controller and its views; scenes are connected by segue objects, which represent a transition between two view controllers.

Xcode provides a visual editor for storyboards, where you can lay out and design the user interface of your application by adding views such as buttons, table views, and text views onto scenes. In addition, a storyboard enables you to connect a view to its controller object, and to manage the transfer of data between view controllers. Using storyboards is the recommended way to design the user interface of your application because they enable you to visualize the appearance and flow of your user interface on one canvas.

# Xibs

UIKit Xibs (XML Interface Builder files) are resource files used to design individual view hierarchies or custom views in iOS development. Unlike Storyboards, which can represent an entire app’s interface, Xibs typically focus on smaller, reusable UI components or single view controllers. They offer a visual way to create and layout UI elements, set up constraints, and configure properties without writing code. Xibs are particularly useful for creating custom table view cells, reusable views, or view controllers that need to be instantiated programmatically.

# Navigation

Navigation helps users easily find their way around an app and locate the information they need, minimizing confusion. Utilizing familiar navigation patterns can simplify complex interactions while preserving the app’s unique character. Learn best practices and common pitfalls when working with tab bars, modals, and other navigation elements.

# View Transitions

UIKit View Transitions provide mechanisms for animating changes between different views or view states within an iOS app. These transitions can be used for presenting or dismissing view controllers, switching between views in a container, or updating the content of a single view. UIKit offers built-in transition styles like push, fade, and flip, as well as the ability to create custom transitions using animation controllers. Developers can use UIView.transition(with:duration:options:animations:completion:) for simple view changes or implement UIViewControllerAnimatedTransitioning for more complex, custom transitions between view controllers.