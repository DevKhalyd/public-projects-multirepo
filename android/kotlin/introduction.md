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

