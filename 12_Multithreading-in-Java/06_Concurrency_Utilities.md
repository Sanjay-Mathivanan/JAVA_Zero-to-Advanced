# Concurrency Utilities in Java

## The Overhead of Raw Threads

In a naive multithreaded application, we spawn a new thread object for every task:
```java
new Thread(task).start();
```

This approach has significant drawbacks:
1. **Thread Creation Costs**: Spawning a thread requires allocating memory for its private Call Stack and coordinating thread creation with the host operating system.
2. **Resource Exhaustion**: If a web server spawns a new thread for every incoming HTTP request under heavy traffic, it can deplete JVM memory, causing an `OutOfMemoryError` or system crash.

To address this, Java 5 introduced the **Executor Framework** (`java.util.concurrent`), which uses **Thread Pools** to manage and reuse thread instances.

---

## Thread Pools and `ExecutorService`

A Thread Pool maintains a queue of tasks and a pool of active worker threads. Worker threads run in the background, pull tasks from the queue, execute them, and return to the pool for reuse.

```text
               Task Queue
Tasks ──> [ Task C ] [ Task B ] [ Task A ]
                 │
                 ▼ (Worker pulls task)
            [ Thread Pool ]
       [ Thread 1 ]   [ Thread 2 ] (Worker Threads execute tasks)
```

### Factory Methods in `Executors`
Use the `Executors` factory class to instantiate thread pools:
* **`newFixedThreadPool(int n)`**: Creates a pool with a fixed number of threads. Excess tasks wait in a queue.
* **`newCachedThreadPool()`**: Creates threads as needed, reusing idle threads. Threads idle for 60 seconds are terminated.
* **`newSingleThreadExecutor()`**: Creates a single worker thread to execute tasks sequentially.

---

## Callable vs. Runnable

The `Callable` interface is a modern alternative to `Runnable` designed for tasks that return a result or throw checked exceptions:

| Feature | `java.lang.Runnable` | `java.util.concurrent.Callable<V>` |
| :--- | :--- | :--- |
| **Method** | `run()` | `call()` |
| **Return Type** | `void` | Parameterized type `V` |
| **Exceptions** | Cannot throw checked exceptions. | Can throw checked exceptions. |

---

## The `Future` Interface

When you submit a `Callable` task to an `ExecutorService`, the service returns a **`Future`** object. The `Future` acts as a placeholder for the result of the asynchronous computation:

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> calculateTask = () -> {
            Thread.sleep(500); // Simulate heavy computation
            return 42;
        };

        // Submit returns a Future immediately without blocking
        Future<Integer> futureResult = executor.submit(calculateTask);

        System.out.println("Doing other operations in main thread...");

        // get() blocks the calling thread until the result is computed
        Integer result = futureResult.get();
        System.out.println("Result received from thread: " + result);

        executor.shutdown(); // Gracefully stops the worker threads
    }
}
```

---

## Best Practices

* **Always Shutdown Executors**: If you do not invoke `executor.shutdown()`, the active worker threads in the pool will prevent the JVM process from exiting.
* **Size Pools Correctly**:
  * **CPU-bound tasks**: Size the pool to match the number of available physical CPU cores: `Runtime.getRuntime().availableProcessors()`.
  * **I/O-bound tasks**: Size the pool larger, as threads will spend time waiting for external I/O operations (network, disk) to complete.

---

## Key Takeaways

* Creating raw threads is expensive; use thread pools to reuse worker threads.
* `ExecutorService` coordinates task execution queues.
* Use `Callable` instead of `Runnable` to return results from threads.
* `Future` represents an asynchronous calculation placeholder, blocking on `get()` until execution completes.

---

**Back to Module Index:** [Module Index](README.md)
