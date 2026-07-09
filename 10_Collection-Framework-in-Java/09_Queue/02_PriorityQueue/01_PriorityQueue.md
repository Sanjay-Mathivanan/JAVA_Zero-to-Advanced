# PriorityQueue in Java

## Introduction

While standard queues process elements in first-in, first-out (FIFO) order, many applications require elements to be processed based on **priority**—such as prioritizing emergency patients in a hospital, scheduling operating system tasks by priority, or sorting files by size.

To solve this, Java provides **`PriorityQueue`**. A `PriorityQueue` sorts its elements according to their natural ordering (ascending by default) or by a custom `Comparator` provided at creation time.

---

## Why PriorityQueue?

If you try to use an `ArrayList` to manage prioritized tasks, you must search the list for the highest-priority element every time you serve one:

* **ArrayList Search Complexity**: `O(N)` linear time. Finding the priority element becomes slower as the collection grows.
* **PriorityQueue Solution**: A `PriorityQueue` retrieves the highest-priority element in **constant time (`O(1)`)** and restructures itself in **logarithmic time (`O(log N)`)** during insertion and deletion.

---

## Priority Processing (Not FIFO)

A `PriorityQueue` does not follow the FIFO rule. The head of the queue is always the **least element** (for min-priority queues) or the **greatest element** (for max-priority queues) according to the specified sorting rule:

```text
Enqueue: [95]  [80]  [90] ──> Priority Queue ──> Head: [80] (Lowest value is served first)
```

---

## Creating a PriorityQueue

### 1. Basic Initialization (Natural Ascending Order)
```java
import java.util.PriorityQueue;
import java.util.Queue;

Queue<Integer> numbers = new PriorityQueue<>();
```

### 2. Custom Comparator Initialization (Descending Order)
```java
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

Queue<Integer> descendingNumbers = new PriorityQueue<>(Collections.reverseOrder());
```

---

## Common Methods

| Method | Description | Time Complexity |
| :--- | :--- | :---: |
| **`offer(E e)`** | Inserts the element into the priority queue. | `O(log N)` |
| **`poll()`** | Retrieves and removes the highest-priority element (head). | `O(log N)` |
| **`peek()`** | Retrieves, but does not remove, the head element. | `O(1)` |
| **`remove(Object o)`** | Removes a specific element. | `O(N)` |

---

## Complete Programs

### Example: Priority Task Scheduler
```java
import java.util.PriorityQueue;
import java.util.Queue;

class Task implements Comparable<Task> {
    String name;
    int priority; // Lower values mean higher priority

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return name + " (P" + priority + ")";
    }
}

public class PriorityQueueDemo {
    public static void main(String[] args) {
        Queue<Task> taskQueue = new PriorityQueue<>();

        // 1. Insert tasks with varying priorities
        taskQueue.offer(new Task("Write Report", 3));
        taskQueue.offer(new Task("Fix Production Bug", 1));
        taskQueue.offer(new Task("Code Review", 2));

        // 2. Poll tasks (processed by priority rank)
        System.out.println("Processing Queue:");
        while (!taskQueue.isEmpty()) {
            System.out.println("Processing: " + taskQueue.poll());
        }
        // Output:
        // Processing: Fix Production Bug (P1)
        // Processing: Code Review (P2)
        // Processing: Write Report (P3)
    }
}
```

---

## Best Practices

* **Implement Comparable/Comparator**: Ensure custom objects stored in a `PriorityQueue` implement `Comparable` (or pass a `Comparator` to the constructor). If you do not, the queue will throw a `ClassCastException` on insertion.
* **Do Not Iterate for Order**: Iterating over a `PriorityQueue` using a `for-each` loop **does not guarantee sorted order**. The queue only guarantees that `poll()` returns the highest-priority element. To retrieve elements in sorted order, call `poll()` sequentially until the queue is empty.

---

## Common Mistakes

* **Adding Nulls**: `PriorityQueue` does not allow null elements (throws `NullPointerException` because it must compare elements).
* **Modifying Priorities Post-Insertion**: Do not modify an object's priority fields after adding it to the queue. If you do, the internal heap tree will not re-align automatically, corrupting the queue's sorting structure.

---

## Key Takeaways

* `PriorityQueue` organizes elements by priority rather than insertion order.
* It uses a binary heap structure, providing `O(log N)` insertion and removal.
* Iterating over the queue directly does not display elements in sorted order; they must be retrieved using `poll()`.

---

**Back to Queues Home:** [Queues Index](../README.md)
