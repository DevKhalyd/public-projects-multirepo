# Constants and Variables

Constants and variables associate a name (such as maximumNumberOfLoginAttempts or welcomeMessage) with a value of a particular type (such as the number 10 or the string "Hello"). The value of a constant can’t be changed once it’s set, whereas a variable can be set to a different value in the future.

Constants and variables must be declared before they’re used. You declare constants with the let keyword and variables with the var keyword. Here’s an example of how constants and variables can be used to track the number of login attempts a user has made:


```swift
// Constants
let maximumNumberOfLoginAttempts = 10
// Variables
var currentLoginAttempt = 0
```

You can declare multiple constants or multiple variables on a single line, separated by commas:

```swift
var x = 0.0, y = 0.0, z = 0.0
```

# Type Annotations

You can provide a type annotation when you declare a constant or variable, to be clear about the kind of values the constant or variable can store. Write a type annotation by placing a colon after the constant or variable name, followed by a space, followed by the name of the type to use.

This example provides a type annotation for a variable called welcomeMessage, to indicate that the variable can store String values:

```swift
var welcomeMessage: String
welcomeMessage = "Hello"
```

# Naming Constants and Variables

Constant and variable names can contain almost any character, including Unicode characters:

```swift
let π = 3.14159
let 你好 = "你好世界"
let 🐶🐮 = "dogcow"
```
Constant and variable names can’t contain whitespace characters, mathematical symbols, arrows, private-use Unicode scalar values, or line- and box-drawing characters. Nor can they begin with a number, although numbers may be included elsewhere within the name.

## Note

If you need to give a constant or variable the same name as a reserved Swift keyword, surround the keyword with backticks (`) when using it as a name. However, avoid using keywords as names unless you have absolutely no choice.

# Printing Constants and Variables

You can print the current value of a constant or variable with the print(_:separator:terminator:) function:

```swift
print(welcomeMessage)
// Prints "Hello"
print("The current value of welcomeMessage is \(welcomeMessage)")
```

# Comments

Use comments to include nonexecutable text in your code, as a note or reminder to yourself. Comments are ignored by the Swift compiler when your code is compiled.

```swift
// This is a comment.
/* This is also a comment
but is written over multiple lines. */
```

# Semicolons

Unlike many other languages, Swift doesn’t require you to write a semicolon (;) after each statement in your code, although you can do so if you wish. However, semicolons are required if you want to write multiple separate statements on a single line:

```swift
let cat = "🐱"; print(cat
```

# Integers

Integers are whole numbers with no fractional component, such as 42 and -23. Integers are either signed (positive, zero, or negative) or unsigned (positive or zero).

Swift provides signed and unsigned integers in 8, 16, 32, and 64-bit forms. These integers follow a naming convention similar to C, in that an 8-bit unsigned integer is of type UInt8, and a 32-bit signed integer is of type Int32. Like all types in Swift, these integer types have capitalized names.

# Integer Bounds

You can access the minimum and maximum values of each integer type with its min and max properties:

```swift
let minValue = UInt8.min // minValue is equal to 0, and is of type UInt8
let maxValue = UInt8.max // maxValue is equal to 255, and is of type UInt8
```

# Int

In most cases, you don’t need to pick a specific size of integer to use in your code. Swift provides an additional integer type, Int, which has the same size as the current platform’s native word size:

On a 32-bit platform, Int is the same size as Int32.

On a 64-bit platform, Int is the same size as Int64.

Unless you need to work with a specific size of integer, always use Int for integer values in your code. This aids code consistency and interoperability. Even on 32-bit platforms, Int can store any value between -2,147,483,648 and 2,147,483,647, and is large enough for many integer ranges.

# Floating-Point Numbers

Double represents a 64-bit floating-point number.

Float represents a 32-bit floating-point number.

Note

Double has a precision of at least 15 decimal digits, whereas the precision of Float can be as little as 6 decimal digits. The appropriate floating-point type to use depends on the nature and range of values you need to work with in your code. In situations where either type would be appropriate, Double is preferred.


# Numeric Literals

Integer literals can be written as:

A decimal number, with no prefix

A binary number, with a 0b prefix

An octal number, with a 0o prefix

A hexadecimal number, with a 0x prefix

All of these integer literals have a decimal value of 17:

```swift
let decimalInteger = 17
let binaryInteger = 0b10001       // 17 in binary notation
let octalInteger = 0o21           // 17 in octal notation
let hexadecimalInteger = 0x11     // 17 in hexadecimal notation
```

Continue: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/thebasics/#Type-Aliases




