# Functional Programming

Functional programming is a style of programming where code is written using pure functions, avoiding changing state and mutable data. It emphasizes the use of mathematical functions to process data, which leads to more predictable and bug-resistant code. This approach helps in writing concise, readable, and testable code.

# Memory Management

Memory management involves allocating memory for objects and freeing it after use. Manual Retain-Release (MRR) requires developers to explicitly manage memory using reference counting, provided by the Foundation class NSObject. Automatic Reference Counting (ARC) automates this process by inserting memory management method calls during compilation, though it still uses reference counting. In contrast, Garbage Collection (GC) automatically tracks object ownership and releases unreferenced objects, using a different mechanism than MRR and ARC, and is supported only in the macOS X runtime environment, not on iOS.

Must read:
https://docs.swift.org/swift-book/documentation/the-swift-programming-language/automaticreferencecounting/

# ViewController Lifecycle

The ViewController lifecycle in iOS refers to the sequence of methods called as a view controller transitions between states. It begins with initialization, followed by loading the view, appearing on screen, disappearing, and potentially being deallocated. Key methods include viewDidLoad(), viewWillAppear(), viewDidAppear(), viewWillDisappear(), and viewDidDisappear(). Understanding this lifecycle is crucial for managing resources, updating UI, and handling state changes efficiently in iOS apps.

# Error Handling

Error handling is a crucial programming concept for managing unexpected situations or failures during code execution. It involves anticipating potential issues, detecting when they occur, and responding appropriately. Common techniques include try-catch blocks, throwing and catching exceptions, and using error codes or result objects. Effective error handling improves program robustness, prevents crashes, aids in debugging, and enhances user experience by providing meaningful feedback. It allows developers to gracefully manage issues like invalid inputs, resource unavailability, or network failures, ensuring the program can recover or fail safely when problems arise.

# Concurrency (GCD, async/await)

Concurrency in iOS development refers to executing multiple tasks simultaneously, improving app performance and responsiveness. Grand Central Dispatch (GCD) is a low-level API that manages concurrent operations through queues, while async/await is a modern Swift feature that simplifies asynchronous code. These tools allow developers to perform time-consuming tasks (like network requests or complex calculations) in the background without freezing the UI. By leveraging concurrency, iOS apps can efficiently utilize device resources, handle multiple operations simultaneously, and maintain a smooth user experience even during intensive processing tasks.

Ref: https://roadmap.sh/ios