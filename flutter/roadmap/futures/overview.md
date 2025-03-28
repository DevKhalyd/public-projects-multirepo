# Future

A feature is used for handling asynchronous operations, such as network requests, reading files, or waiting for a computation to finish.

Future is an object that represents the result of an operation that hasn't completed yet but will return a value at some point in the future.

**Async:**

The async keyword is used to mark a function as asynchronous, meaning it will return a Future. This allows the function to perform long-running tasks without blocking the main thread.

**Await:**

Inside an async function, you can use the await keyword to pause execution until the result of a Future is available.

The await keyword is used inside an async function to pause execution until the Future is completed, and the result is available.


## Flutter is multi-threading

 Flutter can be considered multithreaded in the sense that it supports isolates, which allow for parallel execution in separate threads. However, by default, Flutter runs on a single main thread for UI operations and uses asynchronous programming to handle non-blocking tasks without affecting the UI's responsiveness.

# Single Threaded Event Loop

Dart (and by extension, Flutter) runs on a single main thread.

The asynchronous operations (like fetching data or waiting for an I/O operation) are executed on the same thread, but they don't block the thread while waiting for results.

When you call an asynchronous function (marked with async), Dart does not block the main thread. It schedules the task and allows other tasks to run in the meantime.

Once the asynchronous operation (like awaiting a network request) completes, the result is placed back in the event queue, and the code that follows the await statement is executed.

# Difference between concurrency and parallelism


## Concurrency

Definition: Concurrency is when multiple tasks or processes are executed in overlapping time periods but not necessarily at the same exact time.

Concurrency is more about dealing with many tasks at once by managing them efficiently, even if they're not being executed simultaneously.

Key Aspect: The focus is on managing multiple tasks, potentially using a single core or thread by switching between tasks in an interleaved manner.

Summary: Concurrency is about managing multiple tasks at once, but not necessarily at the same time.

## Parallelism

Parallelism is when multiple tasks or processes are executed at the same time, typically on multiple processors or cores.