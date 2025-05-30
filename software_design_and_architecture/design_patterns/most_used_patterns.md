# Most Used Patterns

A list of most used patterns in my day to day.

## Adapter pattern

The Adapter Pattern lets you wrap an existing class with a new interface so it works in a system that expects something different.

(Think: "This plug doesn’t fit my socket... lemme add an adapter!")

Example:

```dart
// Old class that we cannot modify
class OldPrinter {
  void printDocument(String doc) {
    print('Printing document: $doc');
  }
}

// New interface expected by the system
abstract class ModernPrinter {
  void printFile(String fileName);
}

// Adapter: makes OldPrinter fit ModernPrinter
class PrinterAdapter implements ModernPrinter {
  final OldPrinter _oldPrinter;

  PrinterAdapter(this._oldPrinter);

  @override
  void printFile(String fileName) {
    _oldPrinter.printDocument(fileName);
  }
}

// Client code (expects ModernPrinter)
void main() {
  OldPrinter oldPrinter = OldPrinter();
  ModernPrinter printer = PrinterAdapter(oldPrinter);

  printer.printFile('resume.pdf');
}
```

**Summary**

- The Adapter Pattern does NOT modify the old class.
- It wraps it inside a new class (the Adapter) to make it compatible with a new expected interface.
- It doesn't necessarily add new behavior (although it can), it mainly translates or maps the old behavior into what the new system expects.

"I don't care how ugly the old thing is. I'll dress it up so it looks the way you want."

**Super simple mental image:**

Old console cable ➔ HDMI adapter ➔ Modern TV

Continue with:

## Facade pattern

The Facade Pattern provides a simplified interface to a complex subsystem.

- It’s about hiding complexity behind a clean, easy-to-use interface.

Example:

- You press "Power", and the remote turns on the TV, the speakers, switches HDMI input, etc.

- All that complexity is hidden — you just hit a button.

```dart

// Diferent systems
class Amplifier {
  void on() => print('Amplifier on');
  void setVolume(int level) => print('Volume set to $level');
}

class DVDPlayer {
  void on() => print('DVD Player on');
  void play(String movie) => print('Playing movie: $movie');
}

class Projector {
  void on() => print('Projector on');
  void setInput(String source) => print('Projector input set to $source');
}

// Facade
class HomeTheaterFacade {
  final Amplifier amp;
  final DVDPlayer dvd;
  final Projector projector;

  HomeTheaterFacade(this.amp, this.dvd, this.projector);

  void watchMovie(String movie) {
    print('Get ready to watch a movie...');
    amp.on();
    amp.setVolume(10);

    projector.on();
    projector.setInput('DVD');

    dvd.on();
    dvd.play(movie);
  }
}
```

## State pattern

The State Pattern allows an object to change its behavior when its internal state changes, as if it had multiple classes in one.

You encapsulate state-specific behavior in separate classes and delegate behavior to the current state.

Example:

- Think of a video game character:

- When it's in Idle state, it does nothing.

- When in Attack state, it swings a sword.

- When in Dead state, it's unresponsive.

```dart
abstract class OrderState {
  void next(OrderContext context);
  void cancel(OrderContext context);
}
```

```dart
class PendingState implements OrderState {
  @override
  void next(OrderContext context) {
    print('Order is now PROCESSING');
    context.setState(ProcessingState());
  }

  @override
  void cancel(OrderContext context) {
    print('Order cancelled from PENDING state');
    context.setState(CancelledState());
  }
}

class ProcessingState implements OrderState {
  @override
  void next(OrderContext context) {
    print('Order is now SHIPPED');
    context.setState(ShippedState());
  }

  @override
  void cancel(OrderContext context) {
    print('Order cancelled from PROCESSING state');
    context.setState(CancelledState());
  }
}

class ShippedState implements OrderState {
  @override
  void next(OrderContext context) {
    print('Order is now DELIVERED');
    context.setState(DeliveredState());
  }

  @override
  void cancel(OrderContext context) {
    print('Cannot cancel. Order already shipped.');
  }
}

class DeliveredState implements OrderState {
  @override
  void next(OrderContext context) {
    print('Order already delivered. No further transitions.');
  }

  @override
  void cancel(OrderContext context) {
    print('Cannot cancel. Order already delivered.');
  }
}

class CancelledState implements OrderState {
  @override
  void next(OrderContext context) {
    print('Order was cancelled. Cannot proceed.');
  }

  @override
  void cancel(OrderContext context) {
    print('Order already cancelled.');
  }
}
```

```dart
class OrderContext {
  OrderState _state;

  OrderContext(this._state);

  void setState(OrderState state) {
    _state = state;
  }

  void next() => _state.next(this);
  void cancel() => _state.cancel(this);
}

// Use

void main() {
  final order = OrderContext(PendingState());

  order.next();   // Pending → Processing
  order.next();   // Processing → Shipped
  order.cancel(); // Cannot cancel. Already shipped.
  order.next();   // Shipped → Delivered
  order.next();   // Already delivered
}

```

## Singleton Pattern

The Singleton Pattern ensures that a class has only one instance, and provides a global point of access to it.

Example:

```dart
class Logger {
  Logger._internal(); // private constructor

  static final Logger _instance = Logger._internal();

  factory Logger() {
    return _instance;
  }

  void log(String message) {
    print('[LOG]: $message');
  }
}

// Usage

void main() {
  final logger1 = Logger();
  final logger2 = Logger();

  logger1.log('App started');
  logger2.log('Fetching data');

  print(identical(logger1, logger2)); // true ✅ only one instance
}
```

Powerful — but don’t overuse it (especially in business logic)

## Factory Pattern

The Factory Pattern is sleek, clean, and one of the most flexible creational patterns out there.

It’s like the "smart constructor" of your OOP toolbox

The Factory Pattern defines an interface for creating objects, but lets subclasses or logic decide which class to instantiate.

```dart

// instead
final animal = Dog();

// do
final animal = AnimalFactory.create('dog');


// Implementation

class AnimalFactory {
  static Animal create(String type) {
    switch (type.toLowerCase()) {
      case 'dog':
        return Dog();
      case 'cat':
        return Cat();
      default:
        throw Exception('Unknown animal type: $type');
    }
  }
}

// usage

void main() {
  final animal1 = AnimalFactory.create('dog');
  final animal2 = AnimalFactory.create('cat');

  animal1.speak(); // Woof!
  animal2.speak(); // Meow!
}
```

## Observable Pattern

- Composite Pattern

- Strategy pattern

- Strangler Pattern (Architectural Patterns (Review it))

- Service Locator

Ref: https://www.youtube.com/watch?v=QelshnY1DNk&list=PLbzlGTWnTHu0R19HJ3cbwuy7MBBDCNo59


GPT Session: https://chatgpt.com/c/680da305-1198-8013-be14-f4c11fec718d