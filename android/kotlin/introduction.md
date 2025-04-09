# Introduction

Kotlin took inspiration from many programming languages, including (but not limited to) Java, Scala, C# and Groovy. One of the main ideas behind Kotlin is being pragmatic, i.e., being a programming language useful for day-to-day development, which helps the users get the job done via its features and its tools.

Kotlin is a multiplatform, statically typed, general-purpose programming language. Currently, as of version 
1.9
1.9 , it supports compilation to the following platforms.

- JVM (Java Virtual Machine)
- JS (JavaScript)
- Native (native binaries for various architectures)


# Syntax and Grammar

## When Expression

```kt
fun describe(obj: Any): String =
    when (obj) {
        1          -> "One"
        "Hello"    -> "Greeting"
        is Long    -> "Long"
        !is String -> "Not a string"
        else       -> "Unknown"
    }
```


## Ranges

```kt
val x = 10
val y = 9
if (x in 1..y+1) {
    println("fits in range")
}
```

# Idioms

Ref: https://kotlinlang.org/docs/idioms.html

# Conditions and loops

## If

In Kotlin, if is an expression: it returns a value. Therefore, there is no ternary operator (condition ? then : else) because ordinary if works fine in this role.

```kt
var max = a
if (a < b) max = b

// With else
if (a > b) {
    max = a
} else {
    max = b
}

// As expression
max = if (a > b) a else b

// You can also use `else if` in expressions:
val maxLimit = 1
val maxOrLimit = if (maxLimit > a) maxLimit else if (a > b) a else b

println("max is $max")
// max is 3
println("maxOrLimit is $maxOrLimit")
// maxOrLimit is 3

// Branches of an if expression can be blocks. In this case, the last expression is the value of a block:

val max = if (a > b) {
    print("Choose a")
    a
} else {
    print("Choose b")
    b
}
```

## When expressions and statements

when is a conditional expression that runs code based on multiple possible values or conditions. It is similar to the switch statement in Java, C, and similar languages. For example:

```kotlin
val x = 2
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    else -> print("x is neither 1 nor 2")
}
// x == 2
```

If your when expression doesn't have a subject, you must have an else branch or the compiler throws an error. The else branch is evaluated when none of the other branch conditions are satisfied:

```kt
when {
    a > b -> "a is greater than b"
    a < b -> "a is less than b"
    else -> "a is equal to b"
}
```

When expressions and statements offer different ways to simplify your code, handle multiple conditions, and perform type checks.

You can define a common behavior for multiple cases by combining their conditions in a single line with a comma:

```kt
when (x) {
    0, 1 -> print("x == 0 or x == 1")
    else -> print("otherwise")
}

// You can use arbitrary expressions (not only constants) as branch conditions:

when (x) {
    s.toInt() -> print("s encodes x")
    else -> print("s does not encode x")
}
```

You can also check whether a value is or isn't contained in a range or collection via the in or !in keywords:

```kt
when (x) {
    in 1..10 -> print("x is in the range")
    in validNumbers -> print("x is valid")
    !in 10..20 -> print("x is outside the range")
    else -> print("none of the above")
}

// Additionally, you can check that a value is or isn't a particular type via the is or !is keywords. Note that, due to smart casts, you can access the member functions and properties of the type without any additional checks.

fun hasPrefix(x: Any) = when(x) {
    is String -> x.startsWith("prefix")
    else -> false
}
```

## Guard conditions in when expressions

Ref: https://kotlinlang.org/docs/control-flow.html#guard-conditions-in-when-expressions