# Internal Working of TreeMap

## The BST Architecture

A `TreeMap` does not use Hashing or bucket index arrays. It stores elements inside nodes organized in a **Binary Search Tree (BST)**.

Each node contains:
* Reference to the **Left Child** node.
* Reference to the **Right Child** node.
* Reference to the **Parent** node.
* Key-Value data pair.
* Node color (Red or Black).

```text
       [Parent Node: 20]
         /          \
  [Left: 10]      [Right: 30]
```

### The Node Class definition:
```java
static final class Entry<K,V> implements Map.Entry<K,V> {
    K key;
    V value;
    Entry<K,V> left;
    Entry<K,V> right;
    Entry<K,V> parent;
    boolean color = BLACK; // Red-Black tree color flag
}
```

---

## The Logarithmic Search Path: $\mathcal{O}(\log N)$

When looking up a key (e.g. searching for `30`):
1. Start at the **Root** node (20).
2. Compare target `30` with `20`. Since `30 > 20`, branch **Right**.
3. Locate `30` at the right child.

Because the depth of a balanced tree grows logarithmically with the number of elements, search operations are guaranteed to run in **$\mathcal{O}(\log N)$** time. 

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
