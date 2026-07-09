# ArrayDeque in Java

## Introduction

In some scenarios, you need to add or remove elements from **both ends** of a queue—for example, managing browser history navigation (forward and back) or implementing a card sorting game.

To address this, Java provides the **`Deque`** (Double-Ended Queue) interface, and its most efficient implementation is **`ArrayDeque`**. An `ArrayDeque` uses a circular array buffer that dynamically expands as elements are added.

---

## Why ArrayDeque?

`ArrayDeque` is highly versatile: it can act as a standard **FIFO Queue**, a **Double-Ended Queue (Deque)**, or a **LIFO Stack**:

* **Stack Performance**: `ArrayDeque` is significantly faster than the legacy `Stack` class because it is not synchronized.
* **Queue Performance**: It is faster than `LinkedList` because it stores elements in a contiguous array rather than allocating individual node objects.

---

## The Deque Principle

A Deque supports insertion, deletion, and inspection operations at both the **head** (front) and **tail** (back):

```text
       Insert/Remove Head <── [Head]  [ ]  [ ]  [ ]  [Tail] ──> Insert/Remove Tail
```

---

## Creating an ArrayDeque

### 1. Declaring as a Queue (FIFO Queue)
```java
import java.util.ArrayDeque;
import java.util.Queue;

Queue<String> fifoQueue = new ArrayDeque<>();
```

### 2. Declaring as a Deque (Double-Ended Queue)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<String> doubleEndedQueue = new ArrayDeque<>();
```

### 3. Declaring as a Stack (LIFO Stack)
```java
import java.util.ArrayDeque;
import java.util.Deque;

Deque<String> lifoStack = new ArrayDeque<>();
```

---

## Common Methods

Because it is a double-ended queue, `ArrayDeque` provides dedicated methods for both ends:

### Double-Ended Operations:
| Operation | Head (Front) | Tail (Back) |
| :--- | :---: | :---: |
| **Insert** | `addFirst(e)` / `offerFirst(e)` | `addLast(e)` / `offerLast(e)` |
| **Remove** | `removeFirst()` / `pollFirst()` | `removeLast()` / `pollLast()` |
| **Examine**| `getFirst()` / `peekFirst()` | `getLast()` / `peekLast()` |

### Stack Operations:
* **`push(e)`**: Adds an element to the head (equivalent to `addFirst(e)`).
* **`pop()`**: Removes and returns the head element (equivalent to `removeFirst()`).

---

## Complete Programs

### Example: Using ArrayDeque as a Stack and Deque
```java
import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {
    public static void main(String[] args) {
        // 1. Using Deque for double-ended operations
        Deque<String> deque = new ArrayDeque<>();
        deque.addLast("Middle");
        deque.addFirst("Front");
        deque.addLast("Back");

        System.out.println("Deque View: " + deque); // [Front, Middle, Back]
        System.out.println("Polled Head: " + deque.pollFirst()); // Front
        System.out.println("Polled Tail: " + deque.pollLast()); // Back

        // 2. Using Deque as a Stack (LIFO)
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Card A");
        stack.push("Card B");

        System.out.println("Stack View: " + stack); // [Card B, Card A]
        System.out.println("Popped: " + stack.pop()); // Card B
    }
}
```

---

## Best Practices

* **Use ArrayDeque for Stacks**: Never use the legacy `java.util.Stack` class because its methods are synchronized, creating unnecessary overhead. Use `ArrayDeque` instead.
* **Specify Initial Capacity**: If you know the maximum size, set it in the constructor to avoid array resizing:
  ```java
  Deque<String> deque = new ArrayDeque<>(100);
  ```

---

## Common Mistakes

* **Stack Method Names**: When using `ArrayDeque` as a Stack, use `push()` and `pop()` rather than `offer()` and `poll()` to keep the LIFO stack behavior clear in your code.
* **No Null Elements**: `ArrayDeque` does not allow null elements (throws `NullPointerException` because `null` is used by methods like `poll()` to indicate the queue is empty).

---

## Key Takeaways

* `ArrayDeque` implements the `Deque` interface, supporting double-ended operations.
* It is the recommended implementation for Stacks and standard FIFO Queues.
* It performs basic operations in `O(1)` constant time.

---

**Back to Queues Home:** [Queues Index](../README.md)
