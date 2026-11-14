/*
 * Kotlin Coroutines Basics - study notes
 * Source: https://kotlinlang.org/docs/coroutines-basics.html
 *
 * Setup (not included here, add it to your own project):
 *
 *   // build.gradle.kts
 *   repositories { mavenCentral() }
 *   dependencies {
 *       implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.11.0")
 *   }
 *
 * Optional: add the VM option `-Dkotlinx.coroutines.debug` to your run configuration
 * to see coroutine names next to thread names, e.g. "DefaultDispatcher-worker-1 @coroutine#2".
 *
 * Each example is a function. `main()` at the bottom runs them all in order.
 * The expected output is written at the end of each example function.
 * Thread names like "DefaultDispatcher-worker-N" and the order of concurrent lines
 * can change between runs, because the OS decides when threads run.
 */

import kotlin.concurrent.thread
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds
import kotlinx.coroutines.*

/** Set to `true` to run example 11 (50,000 JVM threads). It may use a lot of memory or crash. */
const val RUN_THREAD_DEMO = false

// ---------------------------------------------------------------------------------------------
// 1. Suspending functions
// ---------------------------------------------------------------------------------------------

/**
 * A `suspend` function can pause and resume later. It can only be called from another
 * suspending function (or a coroutine). No concurrency here yet, just the `suspend` keyword.
 */
suspend fun example01SuspendingFunctions() {
    showUserInfo()

    // Expected output:
    // Loading user...
    // Hello world from a suspending function
    // User: John Smith
}

suspend fun showUserInfo() {
    println("Loading user...")
    greetSimple()
    println("User: John Smith")
}

suspend fun greetSimple() {
    println("Hello world from a suspending function")
}

// ---------------------------------------------------------------------------------------------
// 2. Create your first coroutines
// ---------------------------------------------------------------------------------------------

/**
 * To create coroutines you need: a suspending function, a scope (here from `withContext()`),
 * a builder (`launch`), and a dispatcher (`Dispatchers.Default` = shared thread pool).
 *
 * `delay()` suspends the coroutine and releases the thread, unlike `Thread.sleep()`.
 * `withContext()` waits ~1 second for both children before returning (structured concurrency).
 */
suspend fun example02FirstCoroutines() {
    // Runs the code inside this block on a shared thread pool
    withContext(Dispatchers.Default) { // this: CoroutineScope
        this.launch { greetOnThread() }

        // Starts another coroutine
        this.launch {
            println("The CoroutineScope.launch() on the thread: ${Thread.currentThread().name}")
            delay(1.seconds) // Simulates a suspending API call, e.g. a network request
        }

        println("The withContext() on the thread: ${Thread.currentThread().name}")
    }

    // Expected output (order and worker numbers vary between runs):
    // The withContext() on the thread: DefaultDispatcher-worker-1
    // The greet() on the thread: DefaultDispatcher-worker-2
    // The CoroutineScope.launch() on the thread: DefaultDispatcher-worker-3
}

suspend fun greetOnThread() {
    println("The greet() on the thread: ${Thread.currentThread().name}")
    // Suspends for 1 second and releases the thread
    delay(1.seconds)
}

// ---------------------------------------------------------------------------------------------
// 3. Coroutine scope and structured concurrency: coroutineScope()
// ---------------------------------------------------------------------------------------------

/**
 * Coroutines form a parent/child tree. A parent waits for all its children; if a parent fails
 * or is canceled, its children are canceled too.
 *
 * `coroutineScope()` creates the root of a subtree and suspends until the block and every
 * coroutine launched inside it (including grandchildren) complete. With no dispatcher in the
 * context, `launch` uses `Dispatchers.Default`.
 */
suspend fun example03CoroutineScope() {
    // Root of the coroutine subtree
    coroutineScope { // this: CoroutineScope
        this.launch {
            this.launch {
                delay(2.seconds)
                println("Child of the enclosing coroutine completed")
            }
            println("Child coroutine 1 completed")
        }

        this.launch {
            delay(1.seconds)
            println("Child coroutine 2 completed")
        }
    }
    // Runs only after all children in the coroutineScope have completed
    println("Coroutine scope completed")

    // Expected output:
    // Child coroutine 1 completed                    (immediately)
    // Child coroutine 2 completed                    (after ~1 s)
    // Child of the enclosing coroutine completed     (after ~2 s)
    // Coroutine scope completed                      (only after all children finished)
}

// ---------------------------------------------------------------------------------------------
// 4. Extract coroutine builders from the coroutine scope
// ---------------------------------------------------------------------------------------------

/**
 * `launch` and `async` are extension functions on `CoroutineScope`. To call them from a separate
 * function, that function needs a `CoroutineScope` receiver.
 *
 * `launchAll()` is NOT `suspend`: it only starts coroutines and returns immediately.
 */
suspend fun example04ExtractBuilders() {
    coroutineScope {
        launchAll()
    }

    // Expected output (usually in this order, but not guaranteed on Dispatchers.Default):
    // 1
    // 2
}

fun CoroutineScope.launchAll() { // this: CoroutineScope
    this.launch { println("1") }
    this.launch { println("2") }
}

/* -- Without the CoroutineScope receiver this does not compile --
fun launchAll() {
    // Compilation error: this is not defined
    this.launch { println("1") }
    this.launch { println("2") }
}
*/

// ---------------------------------------------------------------------------------------------
// 5. CoroutineScope.launch()
// ---------------------------------------------------------------------------------------------

/**
 * `launch` starts a coroutine without blocking the rest of the scope ("fire and forget").
 * Use it when you don't need a result. It returns a `Job` you can use to wait or cancel.
 */
suspend fun example05Launch() {
    withContext(Dispatchers.Default) {
        performBackgroundWork()
    }

    // Expected output:
    // Scope continues
    // Sending notification in background    (after ~100 ms)
}

suspend fun performBackgroundWork() = coroutineScope { // this: CoroutineScope
    // Starts a coroutine that runs without blocking the scope
    this.launch {
        // Suspends to simulate background work
        delay(100.milliseconds)
        println("Sending notification in background")
    }

    // Main coroutine continues while the previous one suspends
    println("Scope continues")
}

// ---------------------------------------------------------------------------------------------
// 6. CoroutineScope.async()
// ---------------------------------------------------------------------------------------------

/**
 * `async` starts a concurrent computation and returns a `Deferred<T>` (a future result).
 * `await()` suspends until the result is ready. Both "downloads" run at the same time,
 * so the total time is ~100 ms, not 150 ms.
 */
suspend fun example06Async() = withContext(Dispatchers.Default) { // this: CoroutineScope
    // Starts downloading the first page
    val firstPage = this.async {
        delay(50.milliseconds)
        "First page"
    }

    // Starts downloading the second page in parallel
    val secondPage = this.async {
        delay(100.milliseconds)
        "Second page"
    }

    // Awaits both results and compares them
    val pagesAreEqual = firstPage.await() == secondPage.await()
    println("Pages are equal: $pagesAreEqual")

    // Expected output:
    // Pages are equal: false
}

// ---------------------------------------------------------------------------------------------
// 7. runBlocking()
// ---------------------------------------------------------------------------------------------

/**
 * `runBlocking` creates a scope and BLOCKS the current thread until its coroutines finish.
 * Only use it to bridge from non-suspending code to suspending code when there is no other
 * option, e.g. implementing a third-party interface you can't change.
 */
fun example07RunBlocking() {
    println("Read item: ${MyRepository.readItem()}")

    // Expected output:
    // Read item: 4    (after ~100 ms)
}

// A third-party interface you can't change
interface Repository {
    fun readItem(): Int
}

object MyRepository : Repository {
    override fun readItem(): Int {
        // Bridges to a suspending function
        return runBlocking {
            myReadItem()
        }
    }
}

suspend fun myReadItem(): Int {
    delay(100.milliseconds)
    return 4
}

// ---------------------------------------------------------------------------------------------
// 8. Coroutine dispatchers: passing a dispatcher to launch()
// ---------------------------------------------------------------------------------------------

/**
 * A dispatcher decides which thread(s) a coroutine runs on. Coroutines inherit the dispatcher
 * from their parent unless you pass one explicitly. A coroutine can suspend on one thread and
 * resume on another, but values written before suspending are still visible after resuming.
 */
suspend fun example08LaunchWithDispatcher() {
    runWithDispatcher()

    // Expected output (worker number varies):
    // Running on DefaultDispatcher-worker-1
}

suspend fun runWithDispatcher() = coroutineScope { // this: CoroutineScope
    this.launch(Dispatchers.Default) {
        println("Running on ${Thread.currentThread().name}")
    }
}

// ---------------------------------------------------------------------------------------------
// 9. Coroutine dispatchers: withContext() for a whole block
// ---------------------------------------------------------------------------------------------

/**
 * `withContext(Dispatchers.Default)` runs everything in the block on that dispatcher.
 * `Dispatchers.Default` is meant for CPU-intensive work like these sums.
 */
suspend fun example09WithContextDispatcher() = withContext(Dispatchers.Default) { // this: CoroutineScope
    println("Running withContext block on ${Thread.currentThread().name}")

    val one = this.async {
        println("First calculation starting on ${Thread.currentThread().name}")
        val sum = (1L..500_000L).sum()
        delay(200L)
        println("First calculation done on ${Thread.currentThread().name}")
        sum
    }

    val two = this.async {
        println("Second calculation starting on ${Thread.currentThread().name}")
        val sum = (500_001L..1_000_000L).sum()
        println("Second calculation done on ${Thread.currentThread().name}")
        sum
    }

    // Waits for both calculations and prints the result
    println("Combined total: ${one.await() + two.await()}")

    // Expected output (the middle lines vary in order and worker numbers; the first
    // calculation may resume on a different worker after `delay()`):
    // Running withContext block on DefaultDispatcher-worker-1
    // First calculation starting on DefaultDispatcher-worker-2
    // Second calculation starting on DefaultDispatcher-worker-3
    // Second calculation done on DefaultDispatcher-worker-3
    // First calculation done on DefaultDispatcher-worker-2
    // Combined total: 500000500000
    //
    // First sum  (1..500_000)         = 125000250000
    // Second sum (500_001..1_000_000) = 375000250000
}

// ---------------------------------------------------------------------------------------------
// 10. Comparing coroutines and JVM threads: 50,000 coroutines
// ---------------------------------------------------------------------------------------------

/**
 * Coroutines aren't bound to a thread. While suspended in `delay()` they don't hold a thread,
 * so 50,000 of them share a small thread pool and use roughly 500 MB in total.
https://kotlinlang.org/docs/coroutines-basics.html#comparing-coroutines-and-jvm-threads */
suspend fun example10ManyCoroutines() {
    withContext(Dispatchers.Default) {
        printPeriods()
    }
    println()

    // Expected output (after ~5 seconds, all at once):
    // ..................................................  (50,000 periods on one line)
}

suspend fun printPeriods() = coroutineScope { // this: CoroutineScope
    // Launches 50,000 coroutines that each wait five seconds, then print a period
    repeat(50_000) {
        this.launch {
            delay(5.seconds)
            print(".")
        }
    }
}

// ---------------------------------------------------------------------------------------------
// 11. Comparing coroutines and JVM threads: 50,000 threads
// ---------------------------------------------------------------------------------------------

/**
 * Same idea with OS threads. Each thread gets its own stack (usually a few MB), and the
 * kernel switches between them. 50,000 threads can need up to ~100 GB of stack memory,
 * vs ~500 MB for 50,000 coroutines. The JVM typically handles only a few thousand threads.
 *
 * WARNING: depending on your OS, JDK and settings this may throw
 * `OutOfMemoryError: unable to create native thread` or slow down a lot. Disabled by default,
 * see [RUN_THREAD_DEMO].
 */
fun example11ManyThreads() {
    repeat(50_000) {
        thread {
            Thread.sleep(5000L)
            print(".")
        }
    }
}

// ---------------------------------------------------------------------------------------------
// Entry point
// ---------------------------------------------------------------------------------------------

suspend fun main() {
    println("=== 1. Suspending functions ===")
    example01SuspendingFunctions()

    println("\n=== 2. First coroutines (withContext + launch) ===")
    example02FirstCoroutines()

    println("\n=== 3. coroutineScope and structured concurrency ===")
    example03CoroutineScope()

    println("\n=== 4. Extracting builders with a CoroutineScope receiver ===")
    example04ExtractBuilders()

    println("\n=== 5. CoroutineScope.launch() ===")
    example05Launch()

    println("\n=== 6. CoroutineScope.async() ===")
    example06Async()

    println("\n=== 7. runBlocking() ===")
    example07RunBlocking()

    println("\n=== 8. Passing a dispatcher to launch() ===")
    example08LaunchWithDispatcher()

    println("\n=== 9. withContext() with a dispatcher ===")
    example09WithContextDispatcher()

    println("\n=== 10. 50,000 coroutines ===")
    example10ManyCoroutines()

    if (RUN_THREAD_DEMO) {
        println("\n=== 11. 50,000 JVM threads ===")
        example11ManyThreads()
    }
}

/*
 * Key takeaways
 * - Suspending a coroutine (e.g. `delay()`) does not block its thread; the thread runs other work.
 * - Structured concurrency: a parent coroutine waits for its children, and canceling or failing
 *   a parent cancels its children.
 * - `launch` returns a `Job` (no result); `async` returns a `Deferred<T>`, read it with `await()`.
 * - `coroutineScope()` and `withContext()` suspend until everything inside them completes.
 * - `runBlocking` blocks the thread; use it only to bridge from non-suspending code.
 * - `Dispatchers.Default` is a shared pool with as many threads as CPU cores (minimum 2).
 * - Coroutines are much lighter than threads: millions can run in one process.
 */
