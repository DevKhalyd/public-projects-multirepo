# Ternary Conditional Operator

The ternary conditional operator is a special operator with three parts, which takes the form question ? answer1 : answer2. It’s a shortcut for evaluating one of two expressions based on whether question is true or false. If question is true, it evaluates answer1 and returns its value; otherwise, it evaluates answer2 and returns its value. 

Here’s an example of the ternary conditional operator in action:

```swift
let contentHeight = 40
let hasHeader = true
let rowHeight = contentHeight + (hasHeader ? 50 : 20)
// rowHeight is equal to 90
```
# Nil-Coalescing Operator

Example:

```swift
let defaultColorName = "red"
var userDefinedColorName: String?   // defaults to nil
var colorNameToUse = userDefinedColorName ?? defaultColorName
// userDefinedColorName is nil, so colorNameToUse is set to the default of "red"
```

# Range Operators

Swift includes several range operators, which are shortcuts for expressing a range of values.

## Closed Range Operator

Example:

```swift
for index in 1...5 {
    print("\(index) times 5 is \(index * 5)")
}
```

## Half-Open Range Operator

Example:

```swift
let names = ["Anna", "Alex", "Brian", "Jack"]
let count = names.count
for i in 0..<count {
    print("Person \(i + 1) is called \(names[i])")
}
```

## One-Sided Ranges

Example:

```swift
for name in names[2...] {
    print(name)
}
```

