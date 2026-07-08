# LinkedHashMap vs. HashMap

## Comparison Table

| Feature | `HashMap` | `LinkedHashMap` |
| :--- | :--- | :--- |
| **Ordering** | ❌ None (Unordered) | ✅ Insertion or Access Order |
| **Internal Model** | Hashing bucket table | Hashing buckets + Doubly linked list |
| **Memory Cost** | Low | Higher (Stores `before` & `after` pointers per entry) |
| **Time Complexity** | ⚡ $\mathcal{O}(1)$ average | ⚡ $\mathcal{O}(1)$ average |

---

## Performance Notes

* **Lookup & Insertion Speed**: Both have $\mathcal{O}(1)$ average lookup times, but `LinkedHashMap` is slightly slower in practice due to the overhead of updating doubly-linked pointers during insertions and accesses.
* **Iteration Speed**: `LinkedHashMap` can be faster to iterate through because it loops directly along the linked entries list, bypassing empty slots in the hashing buckets array.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
