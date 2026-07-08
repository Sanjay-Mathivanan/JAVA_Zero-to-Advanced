# TreeMap Interview Questions and Answers

## Beginner Questions

### Q1: Does TreeMap preserve insertion order?
**Answer:**
No. `TreeMap` sorts elements by key order (alphabetical or numerical), not by the sequence you put them in. (Use `LinkedHashMap` to preserve insertion order).

### Q2: Can you put null keys in a TreeMap?
**Answer:**
No. Keys must be compared to sort the tree. Since `null` cannot be compared, putting a null key throws a `NullPointerException`.

---

## Intermediate Questions

### Q3: What is the time complexity of put() and get() in a TreeMap?
**Answer:**
Guaranteed **`O(log N)`** logarithmic complexity, because it traverses parent-child links in a balanced binary tree.

### Q4: How do you sort keys in custom order in a TreeMap?
**Answer:**
By passing a custom `Comparator` object to the `TreeMap` constructor during instantiation.

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
