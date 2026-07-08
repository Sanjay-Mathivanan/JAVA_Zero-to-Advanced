# HashMap vs. Hashtable in Java

## Introduction

Both `HashMap` and `Hashtable` store data in key-value pairs, but they belong to different generations of Java collections.

---

## Comparison Table

| Feature | `HashMap` | `Hashtable` |
| :--- | :--- | :--- |
| **Thread Safety** | ❌ No (Not synchronized) | ✅ Yes (Synchronized methods) |
| **Null Key/Value** | ✅ Yes (Allowed) | ❌ No (Throws `NullPointerException`) |
| **Performance** | ⚡ Fast (No sync locks) | 🐢 Slow (Locking overhead) |
| **Legacy Status** | Modern collection (Java 1.2) | Legacy class (Java 1.0) |

---

## Which one should I choose?

* **Always prefer `HashMap`** for single-threaded applications because it has no synchronization lock overhead.
* For multi-threaded applications, do **not** use `Hashtable` either. Instead, use the modern **`ConcurrentHashMap`** class from `java.util.concurrent`, which provides thread safety without locking the entire table object.

---

**Back to HashMap Home:** [HashMap Index](README.md)
