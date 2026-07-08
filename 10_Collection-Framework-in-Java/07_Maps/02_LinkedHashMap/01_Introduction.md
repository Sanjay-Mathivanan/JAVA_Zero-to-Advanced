# Introduction to LinkedHashMap in Java

## What is a LinkedHashMap?

A **LinkedHashMap** is a subclass of `HashMap` that **preserves the insertion order** of elements.

If you insert entries into a standard `HashMap`, they appear in a random, unpredictable order when you print it. A `LinkedHashMap` fixes this by linking all of its entries together using a internal doubly linked list.

```text
HashMap (Random Order):     [Banana]  [Orange]  [Apple]
LinkedHashMap (Ordered):    [Apple] ──> [Banana] ──> [Orange] (Order is preserved)
```

---

## Key Rules

* **Ordered**: Iterates keys in the exact order they were inserted.
* **HashMap Performance**: Retains fast $\mathcal{O}(1)$ average lookups and updates.
* **Allows Nulls**: Permits one null key and multiple null values.
* **Memory Footprint**: Slightly higher memory overhead than HashMap due to keeping extra node link references.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
