# Introduction to Hashtable in Java

## What is a Hashtable?

A **Hashtable** is a legacy class in Java that stores key-value pairs. 

It is very similar to `HashMap`, but with one major difference: **it is synchronized**. This means it is safe to use in multi-threaded programs (where multiple threads access the map at the same time).

```text
HashMap:      Multiple threads access ──> ❌ Can cause corruption (Not Thread-Safe)
Hashtable:    Multiple threads access ──> ✅ Monitor Lock active (Thread-Safe)
```

---

## Key Rules

* **Thread-Safe**: All public methods are synchronized, preventing concurrent access corruption.
* **No Null Keys or Values**: **Does not allow null keys or null values**. If you put null, Java throws a `NullPointerException`.
* **Legacy Class**: Introduced in Java 1.0. It was later retrofitted to implement the `Map` interface in Java 1.2.
* **Unordered**: Does not guarantee any specific order of keys.

---

**Back to HashTable Home:** [HashTable Index](README.md)
