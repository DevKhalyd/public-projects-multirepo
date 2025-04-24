# Structures and classes

Structures and classes are general-purpose, flexible constructs that become the building blocks of your program’s code. You define properties and methods to add functionality to your structures and classes using the same syntax you use to define constants, variables, and functions.

Unlike other programming languages, Swift doesn’t require you to create separate interface and implementation files for custom structures and classes. In Swift, you define a structure or class in a single file, and the external interface to that class or structure is automatically made available for other code to use.

# Comparing Structures and Classes

Structures and classes in Swift have many things in common. Both can:

- Define properties to store values

- Define methods to provide functionality

- Define subscripts to provide access to their values using subscript syntax

- Define initializers to set up their initial state

- Be extended to expand their functionality beyond a default implementation

- Conform to protocols to provide standard functionality of a certain kind

Classes have additional capabilities that structures don’t have:

- Inheritance enables one class to inherit the characteristics of another.

- Type casting enables you to check and interpret the type of a class instance at runtime.

- Deinitializers enable an instance of a class to free up any resources it has assigned.

- Reference counting allows more than one reference to a class instance.

The additional capabilities that classes support come at the cost of increased complexity. As a general guideline, prefer structures because they’re easier to reason about, and use classes when they’re appropriate or necessary. In practice, this means most of the custom types you define will be structures and enumerations.

Ref: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/classesandstructures#Comparing-Structures-and-Classes

# Definition Syntax

Structures and classes have a similar definition syntax. You introduce structures with the struct keyword and classes with the class keyword. Both place their entire definition within a pair of braces:

```swift
struct SomeStructure {
    // structure definition goes here
}
class SomeClass {
    // class definition goes here
}
```

# Classes Are Reference Types

Unlike value types, reference types are not copied when they’re assigned to a variable or constant, or when they’re passed to a function. Rather than a copy, a reference to the same existing instance is used.

Here’s an example, using the VideoMode class defined above:

```swift
let tenEighty = VideoMode()
tenEighty.resolution = hd
tenEighty.interlaced = true
tenEighty.name = "1080i"
tenEighty.frameRate = 25.0
```

This example declares a new constant called tenEighty and sets it to refer to a new instance of the VideoMode class. The video mode is assigned a copy of the HD resolution of 1920 by 1080 from before. It’s set to be interlaced, its name is set to "1080i", and its frame rate is set to 25.0 frames per second.


Next, tenEighty is assigned to a new constant, called alsoTenEighty, and the frame rate of alsoTenEighty is modified:

```swift
let alsoTenEighty = tenEighty
alsoTenEighty.frameRate = 30.0

```

Ref: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/classesandstructures/#Definition-Syntax
