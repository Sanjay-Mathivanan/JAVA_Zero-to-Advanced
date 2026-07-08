# TreeMap vs. HashMap

## Comparison Table

| Feature | `HashMap` | `TreeMap` |
| :--- | :--- | :--- |
| **Ordering** | ❌ None (Unordered) | ✅ Sorted Keys (Ascending natural order) |
| **Internal Model** | Hashing bucket table | Red-Black Binary Search Tree |
| **Null Key Allowed?**| ✅ Yes (One key) | ❌ No (Throws `NullPointerException`) |
| **Time Complexity** | ⚡ $\mathcal{O}(1)$ average | 🐢 $\mathcal{O}(\log N)$ guaranteed |
| **Memory Cost** | Low | High (Parent/child references per node) |

---

## When to Choose Which?

* **Use `HashMap` by default** for most lookup tasks because constant time lookup $\mathcal{O}(1)$ is faster than $\mathcal{O}(\log N)$ tree traversal.
* **Use `TreeMap` only when** you need keys to be sorted, or you need to perform range queries (e.g. fetching keys between value boundaries using `subMap()`).

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
