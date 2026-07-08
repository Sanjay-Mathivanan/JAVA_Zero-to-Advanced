# Internal Working of Hashtable

## Hashing and Buckets

Similar to `HashMap`, a `Hashtable` uses an array of buckets. When you add a key-value entry, the JVM calculates the key's index using a hashing formula and places it in the corresponding bucket.

---

## Method-Level Synchronization

The key structural difference between `Hashtable` and `HashMap` is **Synchronization**. 

In the `Hashtable` source code, almost every public method declaration contains the **`synchronized`** keyword:

```java
// Conceptual view of Hashtable.java:
public synchronized V put(K key, V value) { ... }
public synchronized V get(Object key) { ... }
public synchronized V remove(Object key) { ... }
```

### How the Lock works:
1. When Thread 1 calls `put()`, it acquires an object-level monitor lock on the entire `Hashtable` instance.
2. Any other thread attempting to call `put()`, `get()`, or `remove()` is blocked and must wait.
3. Once Thread 1 exits the method, the lock is released, and the next waiting thread in line can proceed.

This monitor lock prevents data race conditions but creates a performance bottleneck under high concurrent request loads.

---

**Back to HashTable Home:** [HashTable Index](README.md)
