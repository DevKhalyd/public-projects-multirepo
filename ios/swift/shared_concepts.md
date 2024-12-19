# Collection Types

Swift provides three primary collection types, known as arrays, sets, and dictionaries, for storing collections of values. Arrays are ordered collections of values. Sets are unordered collections of unique values. Dictionaries are unordered collections of key-value associations.

# Control Tranfer Statements

Control transfer statements change the order in which your code is executed, by transferring control from one piece of code to another. Swift has five control transfer statements:

- continue

- break

- fallthrough

- return

- throw


# Fallthrough

In Swift, switch statements don't fall through the bottom of each case and into the next one. That is, the entire switch statement completes its execution as soon as the first matching case is completed. By contrast, C requires you to insert an explicit break statement at the end of every switch case to prevent fallthrough. Avoiding default fallthrough means that Swift switch statements are much more concise and predictable than their counterparts in C, and thus they avoid executing multiple switch cases by mistake.

If you need C-style fallthrough behavior, you can opt in to this behavior on a case-by-case basis with the fallthrough keyword. The example below uses fallthrough to create a textual description of a number.

```swift
let integerToDescribe = 5
var description = "The number \(integerToDescribe) is"
switch integerToDescribe {
case 2, 3, 5, 7, 11, 13, 17, 19:
    description += " a prime number, and also"
    fallthrough
default:
    description += " an integer."
}
print(description)
// Prints "The number 5 is a prime number, and also an integer."
```

# Labeled Statements

In Swift, you can nest loops and conditional statements inside other loops and conditional statements to create complex control flow structures. However, loops and conditional statements can both use the break statement to end their execution prematurely. Therefore, it’s sometimes useful to be explicit about which loop or conditional statement you want a break statement to terminate. Similarly, if you have multiple nested loops, it can be useful to be explicit about which loop the continue statement should affect.

To achieve these aims, you can mark a loop statement or conditional statement with a statement label. With a conditional statement, you can use a statement label with the break statement to end the execution of the labeled statement. With a loop statement, you can use a statement label with the break or continue statement to end or continue the execution of the labeled statement.

A labeled statement is indicated by placing a label on the same line as the statement’s introducer keyword, followed by a colon. Here’s an example of this syntax for a while loop, although the principle is the same for all loops and switch statements:


```swift
<#label name#>: while <#condition#> {
   <#statements#>
}
```

Example:

```swift
gameLoop: while square != finalSquare {
    diceRoll += 1
    if diceRoll == 7 { diceRoll = 1 }
    switch square + diceRoll {
    case finalSquare:
        // diceRoll will move us to the final square, so the game is over
        break gameLoop
    case let newSquare where newSquare > finalSquare:
        // diceRoll will move us beyond the final square, so roll again
        continue gameLoop
    default:
        // this is a valid move, so find out its effect
        square += diceRoll
        square += board[square]
    }
}
print("Game over!")
```

# Early Exit

A guard statement, like an if statement, executes statements depending on the Boolean value of an expression. You use a guard statement to require that a condition must be true in order for the code after the guard statement to be executed. Unlike an if statement, a guard statement always has an else clause — the code inside the else clause is executed if the condition isn’t true.

Example:

```swift
func greet(person: [String: String]) {
    guard let name = person["name"] else {
        return
    }


    print("Hello \(name)!")


    guard let location = person["location"] else {
        print("I hope the weather is nice near you.")
        return
    }


    print("I hope the weather is nice in \(location).")
}


greet(person: ["name": "John"])
// Prints "Hello John!"
// Prints "I hope the weather is nice near you."
greet(person: ["name": "Jane", "location": "Cupertino"])
// Prints "Hello Jane!"
// Prints "I hope the weather is nice in Cupertino."
```

# Deferred Actions

Unlike control-flow constructs like if and while, which let you control whether part of your code is executed or how many times it gets executed, defer controls when a piece of code is executed. You use a defer block to write code that will be executed later, when your program reaches the end of the current scope. For example:

```swift
var score = 1
if score < 10 {
    defer {
        print(score)
    }
    score += 5
}
// Prints "6"
```

The code inside of the defer always runs, regardless of how the program exits that scope. That includes code like an early exit from a function, breaking out of a for loop, or throwing an error. This behavior makes defer useful for operations where you need to guarantee a pair of actions happen — like manually allocating and freeing memory, opening and closing low-level file descriptors, and beginning and ending transactions in a database — because you can write both actions next to each other in your code. For example, the following code gives a temporary bonus to the score, by adding and subtracting 100 inside a chunk of code:

```swift
var score = 3
if score < 100 {
    score += 100
    defer {
        score -= 100
    }
    // Other code that uses the score with its bonus goes here.
    print(score)
}
// Prints "103"
```

If you write more than one defer block in the same scope, the first one you specify is the last one to run. For example:

```swift
if score < 10 {
    defer {
        print(score)
    }
    defer {
        print("The score is:")
    }
    score += 5
}
// Prints "The score is:"
// Prints "6"
```

If your program stops running — for example, because of a runtime error or a crash — deferred code doesn’t execute. However, deferred code does execute after an error is thrown; for information about using defer with error handling, see Specifying Cleanup Actions.

# Checking API Availability

Swift has built-in support for checking API availability, which ensures that you don’t accidentally use APIs that are unavailable on a given deployment target.

The compiler uses availability information in the SDK to verify that all of the APIs used in your code are available on the deployment target specified by your project. Swift reports an error at compile time if you try to use an API that isn’t available. Example:

```swift
if #available(iOS 10, macOS 10.12, *) {
    // Use iOS 10 APIs on iOS, and use macOS 10.12 APIs on macOS
} else {
    // Fall back to earlier iOS and macOS APIs
}

// or

// They do the same thing
if #available(iOS 10, *) {
} else {
    // Fallback code
}


if #unavailable(iOS 10) {
    // Fallback code
}

```


Continue: https://docs.swift.org/swift-book/documentation/the-swift-programming-language/controlflow/#Checking-API-Availability

