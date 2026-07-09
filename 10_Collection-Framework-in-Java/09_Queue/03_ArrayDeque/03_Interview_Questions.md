# ArrayDeque Interview Questions and Answers

## Beginner Questions

### Q1: What does Deque stand for?
**Answer:**
Deque stands for **Double-Ended Queue**. It is a linear collection that supports element insertion and removal at both ends.

### Q2: Does ArrayDeque allow null elements?
**Answer:**
No. `ArrayDeque` throws a `NullPointerException` if you try to add a null element, as `null` is used by queue retrieval methods to signal that the queue is empty.

---

## Intermediate Questions

### Q3: Why is ArrayDeque preferred over Stack?
**Answer:**
* The legacy `Stack` class extends `Vector`, making all its operations synchronized. This introduces unnecessary synchronization overhead.
* `ArrayDeque` is unsynchronized and faster, and it enforces stack LIFO boundaries using the `Deque` interface methods `push()` and `pop()`.

### Q4: What is the time complexity of addFirst() and addLast() in ArrayDeque?
**Answer:**
Both operate in **`O(1)` amortized time**. Resizing the backing array takes `O(N)` time, but this occurs infrequently.

---

## Advanced Questions

### Q5: How does ArrayDeque check if it is full?
**Answer:**
`ArrayDeque` checks for capacity limits when `head == tail`. When this condition is met, the circular array has filled all available slots, triggering double-capacity expansion.

---

**Back to Queues Home:** [Queues Index](../README.md)
