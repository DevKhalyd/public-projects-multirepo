# Asynchronism

Asynchronism in Android is a practice that defines operations, which can run independently from the main operation without following the program’s linear flow. The Android system uses threads to handle asynchronous processes. These threads function independently, ensuring that complex or time-consuming operations do not interfere with the user interface or other essential parts of the application. Android provides various tools for carrying out asynchronous tasks, such as Handler, ThreadPoolExecutor, IntentService, AsyncTask, and Loader etc. These tools provide ways to execute tasks on different threads and communicate the results back to the main thread.

## Coroutines

Coroutines refer to a concurrency design pattern that you can use on Android to simplify code that executes asynchronously. Coroutines provide a way to write asynchronous, non-blocking code in a natural, sequential manner. The fundamental building blocks of coroutines are suspend functions which are simply functions that can be paused and resumed at later times. They are the key to writing non-blocking asynchronous code and represent a single unit of asynchronous computation. This aspect of coroutines makes them useful for managing long-running tasks that might otherwise block the main thread and cause your application to become unresponsive.

## Threads

In Android, a Thread is a concurrent unit of execution. It has its own call stack, but can share its state with other threads in the same process, i.e., they can share the same memory area. They’re primarily used in Android to perform operations in the background. One important aspect to note is that Android UI operations are not thread-safe, meaning they should always be done on the UI thread. Operations on Threads are typically managed through Handler, Looper and MessageQueue classes. Android also provides high-level constructs like AsyncTask and Loader for managing threads in relation to the UI.

## RxJava

RxJava (Reactive Extensions for the JVM) is a powerful library for composing asynchronous and event-based programs using observable sequences in Java. If you are an Android developer, you might be familiar with callbacks and async tasks to perform long-running operations in the background. However, handling multiple async tasks and nested callbacks can produce code that’s complicated to read and maintain. To alleviate such complexities, RxJava provides tools and methods to create, transform and chain Observable sequences in a clean and declarative manner.

## RxKotlin

RxKotlin is a lightweight language extension to Java for Android development, enabling Android apps to be built using Kotlin with Reactivex. It brings the power of reactive programming paradigm to Kotlin, extending its capabilities for processing asynchronous streams of data. It allows you to express static (e.g., already known) or dynamic (e.g., future unknown) data streams, and perform various operations on them easily. Key concepts of RxKotlin include Observables, Observers and Schedulers. Observables represent the data streams, Observers interact with the data stream, and Schedulers determine on which thread operations are performed. RxKotlin helps manage background tasks, handle asynchronous data streams, and implement complex UIs, among others.

## WorkManager

WorkManager is an Android library introduced by Google to execute tasks in a predictable and reliable manner. It’s designed for tasks that require guaranteed execution, even if the app has been closed or the device restarts. It is backwards compatible up to API 14 and uses JobScheduler for API 23 and above, whilst using a combination of BroadcastReceiver + AlarmManager for APIs 14 and up. Regardless of the device API level, WorkManager works for all Android devices. Three types of work are supported by WorkManager - OneTimeWorkRequest, PeriodicWorkRequest, and DelayedWorkRequest.
