# HashSet Interview Questions and Answers

## Beginner Questions

### Q1: What is the primary difference between List and Set interfaces?
**Answer:**
A `List` maintains insertion order and allows duplicate elements. A `Set` does not guarantee insertion order and rejects duplicate elements.

### Q2: What is the load factor and initial capacity of a HashSet?
**Answer:**
Since `HashSet` is backed by a `HashMap`, it shares the same default initial capacity of **16** and load factor of **0.75** (75%).

---

## Intermediate Questions

### Q3: How does a HashSet determine if an element is a duplicate?
**Answer:**
When you add an element `e`, the backing `HashMap` calculates its hash index using `e.hashCode()`. 
If another element exists in that bucket, it compares them using `equals()`. If `equals()` returns `true`, the element is identified as a duplicate and rejected.

### Q4: What happens if you do not override `hashCode()` and `equals()` for custom objects stored in a HashSet?
**Answer:**
The JVM uses the default implementation in the `Object` class:
* `hashCode()` returns the memory address representation of the object.
* `equals()` returns `true` only if both reference variables point to the exact same object in memory.

This means different object instances containing the exact same data fields will be treated as unique, allowing duplicates to enter the set.

---

## Advanced Questions

### Q5: What is the time complexity of add() and contains() in a HashSet?
**Answer:**
Both operate in **`O(1)` average time**. In the worst-case scenario (many hash collisions where all items fall into a single bucket), the complexity can degrade to **`O(log N)`** (JDK 8+ treeification) or **`O(N)`** (pre-JDK 8).

---

**Back to Sets Home:** [Sets Index](../README.md)
