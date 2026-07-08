# HashMap Interview Questions and Answers

## Beginner Questions

### Q1: What is the default initial capacity and load factor of a HashMap?
**Answer:**
The default initial capacity is **16** (always a power of 2) and the default load factor is **0.75** (75%).

### Q2: What happens if you add a duplicate key to a HashMap?
**Answer:**
The new value replaces the old value associated with that key, and the `put()` method returns the old value.

---

## Intermediate Questions

### Q3: How is key bucket collision handled internally?
**Answer:**
Java resolves collisions using **Chaining**:
* **Prior to Java 8**: Colliding keys were stored as nodes in a Singly Linked List at that bucket index ($\mathcal{O}(N)$ worst-case lookup).
* **Java 8+**: If a bucket's list size exceeds **8** and the overall map capacity is at least **64**, the list is treeified into a balanced **Red-Black Tree** ($\mathcal{O}(\log N)$ worst-case lookup).

### Q4: Why must you override both `hashCode()` and `equals()` when using custom objects as keys?
**Answer:**
* `hashCode()` determines which bucket index the key maps to. If two equal keys return different hash codes, they will map to different buckets, and `get()` will return `null`.
* `equals()` resolves collisions within a bucket. If different keys map to the same bucket, `equals()` is called to find the matching key.

---

## Advanced Questions

### Q5: What is the Load Factor, and how does resizing work?
**Answer:**
The load factor (default `0.75`) represents the percentage of table capacity that must be full before resizing. Resizing occurs when $\text{size} > \text{Capacity} \times \text{Load Factor}$. The capacity is doubled, and all keys are rehashed.

---

**Back to HashMap Home:** [HashMap Index](README.md)
