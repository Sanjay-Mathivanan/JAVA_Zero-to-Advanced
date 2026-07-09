# PriorityQueue Interview Questions and Answers

## Beginner Questions

### Q1: Does PriorityQueue follow FIFO order?
**Answer:**
No. `PriorityQueue` processes elements based on their priority (determined by natural ordering or a custom `Comparator`), not their insertion sequence.

### Q2: What happens if you insert custom objects into a PriorityQueue without implementing Comparable?
**Answer:**
It throws a `ClassCastException` on insertion because the queue must compare elements to sort them in the heap tree.

---

## Intermediate Questions

### Q3: Why does iterating over a PriorityQueue not show elements in sorted order?
**Answer:**
The backing binary heap array is only partially ordered to satisfy the heap property (parent $\le$ children). It does not maintain a fully sorted array. 
To retrieve elements in sorted order, you must call `poll()` sequentially.

### Q4: What is the time complexity of offer() and poll() in a PriorityQueue?
**Answer:**
Both run in **`O(log N)`** logarithmic time because they require sifting elements up or down the depth of the binary heap tree.

---

## Advanced Questions

### Q5: How does heap resizing work in PriorityQueue?
**Answer:**
When the backing array becomes full, the queue resizes itself.
* If the current capacity is small (less than 64), it doubles it (`capacity * 2 + 2`).
* If the current capacity is large (64 or greater), it grows by 50% (`capacity * 1.5`).

---

**Back to Queues Home:** [Queues Index](../README.md)
