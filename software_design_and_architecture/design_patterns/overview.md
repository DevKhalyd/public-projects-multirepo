# GoF Design Patterns

The Gang of Four (GoF) design patterns are a set of design patterns for object-oriented software development that were first described in the book “Design Patterns: Elements of Reusable Object-Oriented Software” by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides (also known as the Gang of Four).

The GoF design patterns are divided into three categories: Creational, Structural and Behavioral.

- Creational Patterns
- Structural Patterns
- Behavioral Patterns

Design patterns are categorized into Creational, Structural, and Behavioral patterns based on their purpose. Here's a breakdown:

## Creational Patterns (How objects are created)

These patterns deal with object creation mechanisms, enhancing flexibility and reuse.

- Singleton: Ensures a class has only one instance and provides a global access point.

- Factory Method: Defines an interface for creating an object but lets subclasses alter the type.

```dart
// Step 1: Define an abstract class with a factory constructor
abstract class Shape {
  void draw();

  // Factory constructor inside the abstract class
  factory Shape(String type) {
    if (type == "circle") {
      return Circle();
    } else if (type == "square") {
      return Square();
    } else {
      throw Exception("Invalid shape type: $type");
    }
  }
}

// Step 2: Concrete classes implementing the abstract class
class Circle implements Shape {
  @override
  void draw() {
    print("Drawing a Circle");
  }
}

class Square implements Shape {
  @override
  void draw() {
    print("Drawing a Square");
  }
}

// Step 3: Usage
void main() {
  Shape shape1 = Shape("circle"); // Factory constructor returns a Circle
  shape1.draw(); // Output: Drawing a Circle

  Shape shape2 = Shape("square"); // Factory constructor returns a Square
  shape2.draw(); // Output: Drawing a Square
}
```

- Builder: Separates object construction from its representation, allowing step-by-step creation.

- Prototype: Creates objects by copying an existing instance (cloning).

```dart
// Step 1: Define the Prototype Interface
abstract class Prototype {
  Prototype clone();
}

// Step 2: Concrete Class Implementing Clone Method
class Player implements Prototype {
  String name;
  int score;

  Player(this.name, this.score);

  // Copy constructor using clone method
  @override
  Player clone() {
    return Player(name, score);
  }

  void display() {
    print("Player: $name, Score: $score");
  }
}

// Step 3: Usage
void main() {
  // Create original object
  Player original = Player("John", 100);
  original.display(); // Output: Player: John, Score: 100

  // Clone the object
  Player copy = original.clone();
  copy.display(); // Output: Player: John, Score: 100

  // Modify the cloned object
  copy.name = "Alice";
  copy.score = 200;

  // Display again to verify cloning worked
  original.display(); // Output: Player: John, Score: 100
  copy.display(); // Output: Player: Alice, Score: 200
}
```

## Structural Patterns (How objects and classes are composed)

These patterns focus on class and object composition to form larger structures efficiently.

- Bridge: Separates abstraction from implementation, allowing them to evolve independently.

```dart
// Step 1: Define the Renderer interface (Implementation)
abstract class Renderer {
  void render(String shape);
}

// Step 2: Concrete Implementations of Renderer
class VectorRenderer implements Renderer {
  @override
  void render(String shape) {
    print("Drawing $shape as a vector graphic");
  }
}

class RasterRenderer implements Renderer {
  @override
  void render(String shape) {
    print("Drawing $shape as a raster image");
  }
}

// Step 3: Define the Abstract Shape class (Abstraction)
abstract class Shape {
  final Renderer renderer;

  Shape(this.renderer);

  void draw();
}

// Step 4: Concrete Shapes (Refined Abstraction)
class Circle extends Shape {
  Circle(Renderer renderer) : super(renderer);

  @override
  void draw() {
    renderer.render("Circle");
  }
}

class Square extends Shape {
  Square(Renderer renderer) : super(renderer);

  @override
  void draw() {
    renderer.render("Square");
  }
}

// Step 5: Usage
void main() {
  // Use Vector Renderer
  Renderer vectorRenderer = VectorRenderer();
  Shape circle = Circle(vectorRenderer);
  circle.draw(); // Output: Drawing Circle as a vector graphic

  // Use Raster Renderer
  Renderer rasterRenderer = RasterRenderer();
  Shape square = Square(rasterRenderer);
  square.draw(); // Output: Drawing Square as a raster image
}
```

- Composite: Treats individual objects and compositions of objects uniformly.

- Decorator: Dynamically adds behavior to objects without altering their structure.

- Facade: Provides a simplified interface to a complex system.

Many APIs provide facades to simplify working with underlying services.

- Proxy: Acts as a placeholder for another object to control access.


## Behavioral Patterns (How objects interact and communicate)

These patterns focus on communication between objects and how responsibilities are distributed.


- Chain of Responsibility: Passes requests along a chain of handlers until one handles it.

The Chain of Responsibility is a behavioral design pattern that allows you to pass a request along a chain of handlers until it is handled. Each handler in the chain either processes the request or passes it to the next handler in the chain. This pattern is useful when you need to allow multiple objects to handle a request, without knowing which one will ultimately handle it.

- Observer: Establishes a one-to-many dependency where changes in one object notify dependents.

- State: Allows an object to alter its behavior when its internal state changes.

- Iterator: Provides a way to traverse collections without exposing their details.

- Visitor: Adds new operations to existing object structures without modifying them.

# POSA Patterns

POSA (Pattern-Oriented Software Architecture) is a set of design patterns for developing software systems that can scale and adapt to changing requirements. These patterns were first described in the book “Patterns of Scalable, Reliable Services” by Kevin Hoffman.

POSA patterns are divided into four categories:

- Partitioning Patterns
- Placement Patterns
- Routing Patterns
- Federation Patterns