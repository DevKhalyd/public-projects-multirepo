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
