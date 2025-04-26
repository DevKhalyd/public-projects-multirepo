# Inheritance

All classes in Kotlin have a common superclass, Any, which is the default superclass for a class with no supertypes declared:

```kt
class Example // Implicitly inherits from Any
```

By default, Kotlin classes are final – they can't be inherited. To make a class inheritable, mark it with the open keyword:


```kt
open class Base // Class is open for inheritance
```

To declare an explicit supertype, place the type after a colon in the class header:


```kt
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```

If the derived class has no primary constructor, then each secondary constructor has to initialize the base type using the super keyword or it has to delegate to another constructor which does. Note that in this case different secondary constructors can call different constructors of the base type:

```kt
class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}
```

# Overriding methods

Kotlin requires explicit modifiers for overridable members and overrides:

```kt
open class Shape {
    open fun draw() { /*...*/ }
    fun fill() { /*...*/ }
}

class Circle() : Shape() {
    override fun draw() { /*...*/ }
}
```

The override modifier is required for Circle.draw(). If it's missing, the compiler will complain. If there is no open modifier on a function, like Shape.fill(), declaring a method with the same signature in a subclass is not allowed, either with override or without it. The open modifier has no effect when added to members of a final class – a class without an open modifier.

A member marked override is itself open, so it may be overridden in subclasses. If you want to prohibit re-overriding, use final:


```kt
open class Rectangle() : Shape() {
    final override fun draw() { /*...*/ }
}
```

# Overriding properties

The overriding mechanism works on properties in the same way that it does on methods. Properties declared on a superclass that are then redeclared on a derived class must be prefaced with override, and they must have a compatible type. Each declared property can be overridden by a property with an initializer or by a property with a get method:

Ref: https://kotlinlang.org/docs/inheritance.html#overriding-properties