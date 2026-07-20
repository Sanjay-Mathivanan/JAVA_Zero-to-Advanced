# Thread Synchronization in Java

## Race Conditions

A **Race Condition** occurs in multithreaded programs when multiple threads concurrently read and write to a shared variable, and the final value depends on the execution order (interleaving) of the threads.

### Example: Non-Atomic Increment
The increment statement `count++` looks like a single operation, but it is compiled into three distinct steps:
1. **Read** the current value of `count`.
2. **Increment** the value by 1.
3. **Write** the updated value back to memory.

```text
Thread A: Read count (0) ──> Increment (1) ──────────────────────> Write count (1)
Thread B: ──────────> Read count (0) ──> Increment (1) ──> Write count (1)
(Result: count is 1 instead of expected 2!)
```

---

## Synchronization

To prevent race conditions, Java uses **Synchronization** (Mutual Exclusion) to ensure that only one thread can access a critical section of code at a time. This is done using the **`synchronized`** keyword, which is backed by internal **Monitor Locks** (intrinsics).

### 1. Synchronized Methods
When a thread enters a synchronized instance method, it automatically acquires the monitor lock associated with the **object instance (`this`)**:

```java
public class Counter {
    private int count = 0;

    // Locks on the 'this' instance
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
```

If the method is `static`, the thread acquires the monitor lock associated with the **class metadata object (`Counter.class`)**.

### 2. Synchronized Blocks
Instead of locking the entire method, you can lock only the critical section. This is preferred because it reduces thread contention and improves performance:

```java
public class BlockCounter {
    private int count = 0;
    private final Object lock = new Object(); // Dedicated lock object

    public void increment() {
        // Only this section is serialized
        synchronized (lock) {
            count++;
        }
    }
}
```

---

## The `volatile` Keyword

In modern hardware, physical processors have multi-level cache memories (L1, L2, L3). To speed up execution, threads copy heap variables into processor core caches. If Thread A modifies a variable, the updated value may remain in its core cache, making it invisible to Thread B reading from its own core cache.

```text
[ Thread A ] ──> [ L1 Cache: flag=true ] ──x (Delay writing to Main Memory)
[ Thread B ] ──> [ L1 Cache: flag=false ] <── [ Main Memory: flag=false ]
```

Declaring a variable **`volatile`** solves this issue by ensuring **Memory Visibility**:
1. All write operations to a volatile variable are written directly to the physical main memory immediately.
2. All read operations read directly from the main memory, bypassing the processor caches.

```java
public class SharedFlag {
    // Ensuring visibility across CPU cores
    private volatile boolean running = true;

    public void stop() {
        running = false; // Immediately visible to reader threads
    }

    public boolean isRunning() {
        return running;
    }
}
```

### Volatile is Not Atomic!
* **Visibility**: `volatile` guarantees that threads read the most up-to-date value.
* **No Atomicity**: It does **not** lock code sections. Operations like `count++` on a volatile variable are still subject to race conditions because they are not atomic. Use `synchronized` or `java.util.concurrent.atomic` classes for atomic operations.

---

## Key Takeaways

* Race conditions occur when threads share mutable state without synchronization.
* The `synchronized` keyword uses monitor locks to serialize access to critical sections.
* `volatile` ensures memory visibility across CPU caches but does not provide atomicity.

---

**Back to Module Index:** [Module Index](README.md)
