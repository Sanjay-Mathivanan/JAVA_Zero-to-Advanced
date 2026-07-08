# Time Complexity of HashMap Operations

## Algorithmic Complexity Profile

Because `HashMap` jumps directly to bucket positions using array indexing, it provides fast lookup speeds on average.

Here is the operational complexity matrix:

| Operation | Average Complexity | Worst-Case Complexity |
| :--- | :---: | :---: |
| **`put()`** (Insert) | ⚡ `O(1)` | `O(log N)` or `O(N)` |
| **`get()`** (Lookup) | ⚡ `O(1)` | `O(log N)` or `O(N)` |
| **`remove()`** (Delete) | ⚡ `O(1)` | `O(log N)` or `O(N)` |
| **`containsKey()`** | ⚡ `O(1)` | `O(log N)` or `O(N)` |
| **`containsValue()`** | 🐢 `O(N)` | `O(N)` |

---

## Why Worst-Case Occurs

The worst-case scenario occurs under **high Hash Collision rates** (e.g. if many keys hash to the same bucket index):
* **Prior to Java 8**: Lookup in a collided bucket required traversing a Singly Linked List, taking linear `O(N)` time.
* **Java 8+**: The JVM treeifies long bucket lists into balanced Red-Black Trees when list length exceeds 8, keeping search time to logarithmic **`O(log N)`**.

---

## Why is `containsValue()` Slow?

While the map indexes keys to resolve their buckets instantly, it **does not index values**. To find a value, the JVM must scan through every bucket array slot and traverse every single node link, running in linear `O(N)` time.

---

**Back to HashMap Home:** [HashMap Index](README.md)
