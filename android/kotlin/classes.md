# Classes

Classes in Kotlin are declared using the keyword class:

```kt
class Person { /*...*/ }
```


# Constructors

A class in Kotlin has a primary constructor and possibly one or more secondary constructors. The primary constructor is declared in the class header, and it goes after the class name and optional type parameters.

```kt
class Person constructor(firstName: String) { /*...*/ }
```

The primary constructor initializes a class instance and its properties in the class header. The class header can't contain any runnable code. If you want to run some code during object creation, use initializer blocks inside the class body. Initializer blocks are declared with the init keyword followed by curly braces. Write any code that you want to run within the curly braces.

During the initialization of an instance, the initializer blocks are executed in the same order as they appear in the class body, interleaved with the property initializers:

```kt
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    
    init {
        println("First initializer block that prints $name")
    }
    
    val secondProperty = "Second property: ${name.length}".also(::println)
    
    init {
        println("Second initializer block that prints ${name.length}")
    }
}

// Primary constructor parameters can be used in the initializer blocks. They can also be used in property initializers declared in the class body:

class Customer(name: String) {
    val customerKey = name.uppercase()
}

```
