# HashMap Comparisons and Interview Questions

## Introduction

Sorting out the differences between Map implementations is a key test in Java developer interviews. This guide compares `HashMap` against `Hashtable`, `LinkedHashMap`, and `TreeMap`, and answers top interview questions.

---

## HashMap vs. Hashtable

These two classes both store key-value pairs, but represent old synchronized vs. modern collection paradigms:

| Feature | `HashMap` | `Hashtable` |
| :--- | :--- | :--- |
| **Thread Safety** | ❌ No (Not synchronized) | ✅ Yes (Synchronized methods) |
| **Null Keys/Values** | ✅ Yes (One null key, multiple null values)| ❌ No (Throws `NullPointerException`) |
| **Performance** | ⚡ Fast (No synchronization overhead) | 🐢 Slow (Locking overhead) |
| **Iterator Type** | Fail-Fast (Throws `ConcurrentModificationException`) | Fail-Safe (Enumeration is fail-safe) |
| **Introduction** | Java 1.2 | Legacy class (Java 1.0) |

---

## HashMap vs. LinkedHashMap vs. TreeMap

| Feature | `HashMap` | `LinkedHashMap` | `TreeMap` |
| :--- | :--- | :--- | :--- |
| **Internal Structure** | Hash Table | Hash Table + Doubly Linked List | Red-Black Tree |
| **Key Ordering** | ❌ None (Unordered) | ✅ Insertion Order | ✅ Sorted (Natural/Custom Comparator)|
| **Null Key Allowed?** | ✅ Yes (Exactly one) | ✅ Yes (Exactly one) | ❌ No (Throws `NullPointerException`) |
| **Lookup Complexity** | ⚡ $\mathcal{O}(1)$ average | ⚡ $\mathcal{O}(1)$ average | 🐢 $\mathcal{O}(\log N)$ |

---

## Top Technical Interview Q&As

### Q1: How does HashMap handle key collisions internally?
**Answer:**
When two keys hash to the same bucket index, it is a collision. In Java, this is resolved using **Chaining**:
* Prior to Java 8, colliding nodes were appended to a Singly Linked List at that bucket index ($\mathcal{O}(N)$ lookup).
* In Java 8+, if the list length at a bucket exceeds **8**, the nodes are converted to a **Red-Black Tree** ($\mathcal{O}(\log N)$ lookup).

### Q2: Why must you override both `hashCode()` and `equals()` when using custom objects as keys?
**Answer:**
If you override only one:
* Overriding only `equals()`: Two equal student objects will have different hash codes, so they will map to different buckets, and `map.get()` will return `null`.
* Overriding only `hashCode()`: Different equal objects map to the same bucket, but the traversal fails because `equals()` returns `false`.

### Q3: What is the load factor and when does resizing happen?
**Answer:**
The load factor (default `0.75`) represents the percentage of table capacity that must be full before resizing. Resizing occurs when $\text{size} > \text{Capacity} \times \text{Load Factor}$. The capacity is doubled, and all keys are rehashed.

---

## Key Takeaways

* Use **`HashMap`** as your default map choice for fast, unordered lookups.
* Use **`LinkedHashMap`** when you need to preserve key insertion ordering.
* Use **`TreeMap`** when you need keys sorted in natural or custom comparator order.
* Never use the legacy `Hashtable` class; use `ConcurrentHashMap` for multithreaded applications.

---

**Back to Maps Home:** [Map Index](../README.md)
