# Inter-Thread Communication in Java

## Cooperation Mechanisms

In concurrent systems, threads often need to coordinate their actions. For example, a worker thread should wait until a reader thread loads a file into memory.

Java provides thread cooperation using three final methods inherited by all classes from the **`Object`** class:
* **`wait()`**: Causes the current thread to release its monitor lock and enter the `WAITING` (or `TIMED_WAITING`) state until another thread invokes `notify()` or `notifyAll()` on the same object.
* **`notify()`**: Wakes up a single thread that is waiting on this object's monitor.
* **`notifyAll()`**: Wakes up all threads that are waiting on this object's monitor.

---

## Critical Rule: Synchronized Context Only

You **must** call `wait()`, `notify()`, and `notifyAll()` from within a **synchronized block or method**. 

If you call these methods on an object without holding its monitor lock, the JVM will throw an **`IllegalMonitorStateException`** at runtime.

```java
public class ConditionDemo {
    private final Object lock = new Object();

    public void doWait() throws InterruptedException {
        // Calling wait() directly here throws IllegalMonitorStateException
        // lock.wait(); 

        synchronized (lock) {
            lock.wait(); // Safe: Caller holds the monitor lock
        }
    }
}
```

---

## The Producer-Consumer Design Pattern

The Producer-Consumer pattern is a classic multithreading coordinator model. It uses a shared queue:
1. **Producers** insert items into the queue. If the queue is full, they call `wait()`.
2. **Consumers** retrieve items from the queue. If the queue is empty, they call `wait()`.
3. When a producer inserts an item, it calls `notify()` to wake up any waiting consumers.
4. When a consumer removes an item, it calls `notify()` to wake up any waiting producers.

```mermaid
graph LR
    Producer["Producer Thread"] -->|inserts / wait if full| Queue["Shared Buffer Queue"]
    Queue -->|retrieves / wait if empty| Consumer["Consumer Thread"]
```

### Complete Compilable Program
```java
import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 2;

    public synchronized void produce(int value) throws InterruptedException {
        // Use a loop to check conditions to protect against spurious wakeups
        while (queue.size() == CAPACITY) {
            System.out.println("Buffer is FULL. Producer waiting...");
            wait(); // Releases lock, enters WAITING state
        }

        queue.offer(value);
        System.out.println("Produced: " + value);
        
        notify(); // Wakes up consumer threads
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Buffer is EMPTY. Consumer waiting...");
            wait(); // Releases lock, enters WAITING state
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);

        notify(); // Wakes up producer threads
        return value;
    }
}

public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer();

        // Producer Thread
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(100); // Simulate production delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(150); // Simulate consumption delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

---

## Key Takeaways

* `wait()`, `notify()`, and `notifyAll()` belong to the `Object` class, not `Thread`.
* They must be called from within a synchronized context to avoid `IllegalMonitorStateException`.
* Always use a `while` loop rather than an `if` block to verify conditions before calling `wait()`, protecting your program from spurious wakeups.

---

**Back to Module Index:** [Module Index](README.md)
