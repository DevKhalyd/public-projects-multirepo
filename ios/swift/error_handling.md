# Error Handliong

Error handling is the process of responding to and recovering from error conditions in your program. Swift provides first-class support for throwing, catching, propagating, and manipulating recoverable errors at runtime.


# Representing and Throwing Errors

In Swift, errors are represented by values of types that conform to the Error protocol. This empty protocol indicates that a type can be used for error handling.

Swift enumerations are particularly well suited to modeling a group of related error conditions, with associated values allowing for additional information about the nature of an error to be communicated. For example, here’s how you might represent the error conditions of operating a vending machine inside a game:

```swift

enum VendingMachineError: Error {
    case invalidSelection
    case insufficientFunds(coinsNeeded: Int)
    case outOfStock
}

// Example

throw VendingMachineError.insufficientFunds(coinsNeeded: 5)
```

# Propagating Errors Using Throwing Functions

To indicate that a function, method, or initializer can throw an error, you write the throws keyword in the function’s declaration after its parameters. A function marked with throws is called a throwing function. If the function specifies a return type, you write the throws keyword before the return arrow (->).

```swift
func canThrowErrors() throws -> String

func cannotThrowErrors() -> String
```

# Handling Errors Using Do-Catch

You use a do-catch statement to handle errors by running a block of code. If an error is thrown by the code in the do clause, it’s matched against the catch clauses to determine which one of them can handle the error.

```swift
do {
    try <#expression#>
    <#statements#>
} catch <#pattern 1#> {
    <#statements#>
} catch <#pattern 2#> where <#condition#> {
    <#statements#>
} catch <#pattern 3#>, <#pattern 4#> where <#condition#> {
    <#statements#>
} catch {
    <#statements#>
}

// Example

var vendingMachine = VendingMachine()
vendingMachine.coinsDeposited = 8
do {
    try buyFavoriteSnack(person: "Alice", vendingMachine: vendingMachine)
    print("Success! Yum.")
} catch VendingMachineError.invalidSelection {
    print("Invalid Selection.")
} catch VendingMachineError.outOfStock {
    print("Out of Stock.")
} catch VendingMachineError.insufficientFunds(let coinsNeeded) {
    print("Insufficient funds. Please insert an additional \(coinsNeeded) coins.")
} catch {
    print("Unexpected error: \(error).")
}
// Prints "Insufficient funds. Please insert an additional 2 coins."
```

In the above example, the buyFavoriteSnack(person:vendingMachine:) function is called in a try expression, because it can throw an error. If an error is thrown, execution immediately transfers to the catch clauses, which decide whether to allow propagation to continue. If no pattern is matched, the error gets caught by the final catch clause and is bound to a local error constant. If no error is thrown, the remaining statements in the do statement are executed.

The catch clauses don’t have to handle every possible error that the code in the do clause can throw. If none of the catch clauses handle the error, the error propagates to the surrounding scope. However, the propagated error must be handled by some surrounding scope. In a nonthrowing function, an enclosing do-catch statement must handle the error. In a throwing function, either an enclosing do-catch statement or the caller must handle the error. If the error propagates to the top-level scope without being handled, you’ll get a runtime error.

# Converting Errors to Optional Values

You use try? to handle an error by converting it to an optional value. If an error is thrown while evaluating the try? expression, the value of the expression is nil. For example, in the following code x and y have the same value and behavior:

```swift

func someThrowingFunction() throws -> Int {
    // ...
}

let x = try? someThrowingFunction()

let y: Int?
do {
    y = try someThrowingFunction()
} catch {
    y = nil
}
```
Ref: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/errorhandling

# Disabling Error Propagation

Sometimes you know a throwing function or method won’t, in fact, throw an error at runtime. On those occasions, you can write try! before the expression to disable error propagation and wrap the call in a runtime assertion that no error will be thrown. If an error actually is thrown, you’ll get a runtime error.

```swift
let photo = try! loadImage(atPath: "./Resources/John Appleseed.jpg")
```
