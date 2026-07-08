# Time Complexity of HashMap Operations

## Performance Overview

Because `HashMap` jumps directly to a bucket slot using hashing calculations, it provides fast lookup and insertion times.

Here is the time complexity breakdown for the most common operations:

| Operation | Average Time Complexity | Worst-Case Time Complexity |
| :--- | :---: | :---: |
| **`put()`** (Insert) | ⚡ $\mathcal{O}(1)$ | $\mathcal{O}(\log N)$ or $\mathcal{O}(N)$ |
| **`get()`** (Lookup) | ⚡ $\mathcal{O}(1)$ | $\mathcal{O}(\log N)$ or $\mathcal{O}(N)$ |
| **`remove()`** (Delete) | ⚡ $\mathcal{O}(1)$ | $\mathcal{O}(\log N)$ or $\mathcal{O}(N)$ |
| **`containsKey()`** | ⚡ $\mathcal{O}(1)$ | $\mathcal{O}(\log N)$ or $\mathcal{O}(N)$ |
| **`containsValue()`** | 🐢 $\mathcal{O}(N)$ | $\mathcal{O}(N)$ |

---

## Why does Worst-Case happen?

The worst-case scenario occurs when there are **excessive Hash Collisions** (e.g. if many keys hash to the same bucket). 
* In Java 7, lookups in that bucket drop to $\mathcal{O}(N)$ because the JVM must scan a long linked list.
* In Java 8+, the bucket is converted to a tree, ensuring that worst-case search complexity is kept to **$\mathcal{O}(\log N)$**.

---

## Why is `containsValue()` Slow?

While the map indexes keys to find their corresponding bucket, it **does not index values**. To find a value, the JVM must scan through every single node in every bucket, running in linear $\mathcal{O}(N)$ time.

---

**Back to HashMap Home:** [HashMap Index](README.md)
