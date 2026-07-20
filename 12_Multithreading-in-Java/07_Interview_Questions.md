# Multithreading Interview Questions

## Beginner Questions

### Q1: What is the difference between a Process and a Thread?
**Answer:**
* A **Process** is an independent executing instance of a program with its own dedicated memory space allocated by the operating system.
* A **Thread** is a lightweight execution path within a process. Threads sharing the same process share its heap memory but maintain private call stacks.

### Q2: What is the difference between start() and run() methods of a Thread?
**Answer:**
* `start()` is used to spawn a new thread. It creates a private execution call stack and invokes `run()` asynchronously.
* Calling `run()` directly does not spawn a new thread; it executes the method synchronously in the current thread stack.

---

## Intermediate Questions

### Q3: What is a deadlock and how can we prevent it?
**Answer:**
A **Deadlock** is a situation where two or more threads are blocked forever, each waiting for a lock held by the other:
```text
Thread A holds Lock 1, waits for Lock 2.
Thread B holds Lock 2, waits for Lock 1.
(Both are blocked indefinitely!)
```
**Prevention Strategies**:
* **Lock Ordering**: Always acquire locks in a consistent, predefined order across all threads.
* **Lock Timeout**: Use `ReentrantLock.tryLock(timeout)` to break waiting states if locks cannot be acquired in a specified time.

### Q4: Why must wait() and notify() be called from a synchronized context?
**Answer:**
These methods require the calling thread to release or lock the object's monitor. If the thread does not hold the monitor lock (which is acquired using a `synchronized` block/method), the JVM throws an `IllegalMonitorStateException` to prevent race conditions during state transitions.

### Q5: What is the difference between sleep() and wait()?
**Answer:**
* **`sleep()`**: Declared in the `Thread` class. It pauses the thread for a specified time but **does not release** any acquired monitor locks.
* **`wait()`**: Declared in the `Object` class. It pauses the thread indefinitely (or until timed out) and **releases** the acquired monitor lock, allowing other threads to enter the synchronized block.

---

## Advanced Questions

### Q6: What is a Spurious Wakeup, and how do we protect against it?
**Answer:**
A spurious wakeup occurs when a thread is woken up from its waiting state without any `notify()` or `notifyAll()` being invoked.
To protect against it, **always check waiting conditions in a `while` loop** instead of an `if` block, ensuring the thread re-verifies the condition before proceeding:
```java
// Correct protection pattern:
while (!condition) {
    wait();
}
```

### Q7: What is ThreadLocal and when should it be used?
**Answer:**
`ThreadLocal` provides thread-local variables. Each thread accessing a `ThreadLocal` variable maintains an independent, isolated copy of the variable.
**Use Case**: Used to store thread-confined, non-thread-safe state (e.g. database transactions or user session contexts) without using synchronization locks.

---

**Back to Module Index:** [Module Index](README.md)
