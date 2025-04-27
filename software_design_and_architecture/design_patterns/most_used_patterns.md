# Most Used Patterns

A list of most used patterns by me.

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

- Facade pattern

- State pattern

- Singleton Pattern

- Factory Pattern

- Observable Pattern

- Composite Pattern

- Facade Pattern

- Strategy pattern

Ref: https://www.youtube.com/watch?v=QelshnY1DNk&list=PLbzlGTWnTHu0R19HJ3cbwuy7MBBDCNo59

- Strangler Pattern (Architectural Patterns (Review it))

GPT Session: https://chatgpt.com/c/680da305-1198-8013-be14-f4c11fec718d