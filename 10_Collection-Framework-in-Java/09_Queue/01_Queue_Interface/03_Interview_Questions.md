# Queue Interface Interview Questions and Answers

## Beginner Questions

### Q1: What is the FIFO principle in standard Queues?
**Answer:**
FIFO stands for **First-In, First-Out**. The first element added to the queue is the first one to be removed.

### Q2: What is the difference between offer() and add() methods in a Queue?
**Answer:**
* `add(e)` throws an `IllegalStateException` if the queue is full (capacity restricted).
* `offer(e)` returns `false` if the element cannot be added due to capacity limits.

---

## Intermediate Questions

### Q3: Why should we prefer ArrayDeque over LinkedList as a Queue?
**Answer:**
`ArrayDeque` is faster and more memory-efficient.
* `LinkedList` allocates a new `Node` wrapper object for every element added, creating garbage collection overhead.
* `ArrayDeque` stores elements in a continuous array, reuses slots using circular indexing, and avoids node allocation overhead.

### Q4: Why does Queue peek() return null?
**Answer:**
`peek()` returns `null` if the queue is currently empty. This is why inserting `null` values into a `Queue` is discouraged, as it makes it impossible to distinguish between a `null` element and an empty queue.

---

## Advanced Questions

### Q5: How do the circular index pointer shifts work in an ArrayDeque?
**Answer:**
`ArrayDeque` uses bitwise mask arithmetic to handle circular transitions. When the pointer crosses the end of the array, it wraps around to the beginning using:
```java
head = (head - 1) & (elements.length - 1)
```
This is why `ArrayDeque` capacity must always be a power of 2.

---

**Back to Queues Home:** [Queues Index](../README.md)
