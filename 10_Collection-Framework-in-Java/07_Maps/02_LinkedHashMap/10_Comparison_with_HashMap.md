# LinkedHashMap vs. HashMap

## Comparison Table

| Feature | `HashMap` | `LinkedHashMap` |
| :--- | :--- | :--- |
| **Ordering** | ❌ None (Unordered) | ✅ Insertion / Access Order |
| **Internal Model** | Hashing bucket table | Hashing buckets + Doubly linked list |
| **Memory Cost** | Low | Higher (Stores `before` & `after` pointers per entry) |
| **Time Complexity** | ⚡ $\mathcal{O}(1)$ average | ⚡ $\mathcal{O}(1)$ average |

---

## Performance Considerations

* **Overhead**: `LinkedHashMap` is slightly slower than `HashMap` during insertions and deletions because it must maintain the doubly linked list pointers (`before`/`after`).
* **Iteration**: `LinkedHashMap` is faster to iterate through because it travels directly along the linked nodes, bypassing empty slots in the hashing buckets array.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
