# TreeSet Interview Questions and Answers

## Beginner Questions

### Q1: Does TreeSet allow duplicate elements?
**Answer:**
No. Like all `Set` implementations, `TreeSet` rejects duplicate elements.

### Q2: What happens if you add null to a TreeSet?
**Answer:**
It throws a `NullPointerException` because the map must compare the new element with existing elements to place it in the correct sorted position.

---

## Intermediate Questions

### Q3: What is the time complexity of add(), remove(), and contains() in a TreeSet?
**Answer:**
All basic operations run in **`O(log N)`** logarithmic time in both average and worst-case scenarios, because it uses a balanced Red-Black Binary Search Tree internally.

### Q4: How does TreeSet determine if two custom elements are duplicates?
**Answer:**
`TreeSet` uses the element's **`compareTo()`** (or `compare()`) method to check for duplicates. If `compareTo(a, b)` returns `0`, they are considered identical, and the duplicate is rejected. It does not use `hashCode()` or `equals()`.

---

## Advanced Questions

### Q5: What is a NavigableSet?
**Answer:**
`NavigableSet` is a sub-interface of `SortedSet` implemented by `TreeSet`. It adds utility methods to search for closest matches, such as:
* `floor(e)`: returns the greatest element $\le e$.
* `ceiling(e)`: returns the least element $\ge e$.
* `lower(e)`: returns the greatest element $< e$.
* `higher(e)`: returns the least element $> e$.

---

**Back to Sets Home:** [Sets Index](../README.md)
