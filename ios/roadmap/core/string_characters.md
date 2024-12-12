# String Characters

Strings are sequences of characters. In Swift, strings are represented by the `String` type. Strings can be created by enclosing characters in double quotes.

```swift
let message = "Hello, World!"
```

# Working with Characters

You can access individual characters in a string by iterating over the string's characters property. The `characters` property returns a collection of characters.

```swift
let message = "Hello, World!"

for character in message.characters {
    print(character)
}

let catCharacters: [Character] = ["C", "a", "t", "!", "🐱"]
let catString = String(catCharacters)
print(catString)
```

# String Interpolation

String interpolation is a way to construct a new String value from a mix of constants, variables, literals, and expressions by including their values inside a string literal. You can use string interpolation in both single-line and multiline string literals. Each item that you insert into the string literal is wrapped in a pair of parentheses, prefixed by a backslash (\):

```swift
let name = "John"
let age = 25

let message = "Hello, my name is \(name) and I am \(age) years old."
print(message)
```

# Unicode

Unicode is an international standard for encoding, representing, and processing text in different writing systems. It enables you to represent almost any character from any language in a standardized form, and to read and write those characters to and from an external source such as a text file or web page. Swift’s String and Character types are fully Unicode-compliant, as described in this section.

# Accessing and Modifying a String

You access and modify a string through its methods and properties, or by using subscript syntax.

