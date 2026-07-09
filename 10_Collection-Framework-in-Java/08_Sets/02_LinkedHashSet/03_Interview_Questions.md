# LinkedHashSet Interview Questions and Answers

## Beginner Questions

### Q1: What is the main difference between HashSet and LinkedHashSet?
**Answer:**
* `HashSet` does not maintain any element ordering.
* `LinkedHashSet` preserves the **insertion order** of elements using a doubly linked list.

### Q2: Does LinkedHashSet allow duplicate elements?
**Answer:**
No. Like all `Set` implementations, `LinkedHashSet` rejects duplicate elements.

---

## Intermediate Questions

### Q3: How is LinkedHashSet implemented internally in Java?
**Answer:**
`LinkedHashSet` extends `HashSet` but calls a package-private constructor `super(initialCapacity, loadFactor, true)` which instantiates a **`LinkedHashMap`** internally instead of a standard `HashMap`.

### Q4: Which is faster to iterate: HashSet or LinkedHashSet?
**Answer:**
`LinkedHashSet` is generally faster to iterate. 
* `HashSet` iteration time is proportional to its capacity (it must scan every bucket index, including empty slots).
* `LinkedHashSet` iteration time is proportional to its size (it traverses the doubly linked list, skipping empty bucket slots entirely).

---

**Back to Sets Home:** [Sets Index](../README.md)
