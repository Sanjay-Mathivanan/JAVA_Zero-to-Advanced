# LinkedHashMap in Java: Basics and Operations

## Introduction

A `HashMap` is highly efficient ($\mathcal{O}(1)$ average complexity) but **does not maintain any key order**. If you insert entries, they are hashed to buckets randomly. 

In some applications—such as caching algorithms (like LRU caches), log processors, or wizard flow charts—preserving **key insertion order** or **key access order** is required. 

To solve this, Java provides **`LinkedHashMap`**. A `LinkedHashMap` extends `HashMap` and implements the `Map` interface, maintaining a doubly linked list running through all its entries.

---

## LinkedHashMap Characteristics

* **Ordered**: Maintains a doubly linked list running through its elements, preserving either **insertion order** or **access order**.
* **HashMap Performance**: Retains fast lookup, insertion, and deletion speeds ($\mathcal{O}(1)$).
* **Null Support**: Permits one null key and multiple null values.
* **Memory Footprint**: Slightly higher memory overhead than a standard `HashMap` because each entry contains extra pointers (`before` and `after`) to maintain the list links.

---

## Syntax and Basic Operations

### 1. Creating and Using a LinkedHashMap:
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Creates a LinkedHashMap preserving insertion order
        Map<String, String> items = new LinkedHashMap<>();
        items.put("One", "Apple");
        items.put("Two", "Banana");
        items.put("Three", "Orange");

        // Iteration prints elements in the exact order they were inserted
        for (Map.Entry<String, String> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // Output:
        // One -> Apple
        // Two -> Banana
        // Three -> Orange
    }
}
```

---

## Access-Order Mode (LRU Cache Foundation)

`LinkedHashMap` provides a special constructor that lets you change the list ordering from **Insertion-Order** to **Access-Order**:

```java
public LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder)
```

If `accessOrder` is set to `true`, referencing a key using `get()` or `put()` moves that key-value entry automatically to the **tail** (end) of the doubly linked list. The least-recently-accessed elements remain at the **head** (start), which forms the basis for implementing an **LRU (Least Recently Used) Cache**:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Third argument "true" enables access-order mode
        LinkedHashMap<String, Integer> cache = new LinkedHashMap<>(16, 0.75f, true);
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        // Access "A"
        cache.get("A"); // Moves "A" to the end (tail)

        System.out.println(cache); // Output: {B=2, C=3, A=1}
    }
}
```

---

## Key Takeaways

* `LinkedHashMap` preserves key ordering by maintaining a doubly linked list through all entries.
* By default, it orders elements based on **insertion order**.
* By setting `accessOrder = true` in the constructor, the list orders elements based on **access order** (least-recently-accessed at head, most-recently-accessed at tail).
* Lookup, insertion, and deletion run in constant $\mathcal{O}(1)$ time.

---

**Back to Maps Home:** [Map Index](../README.md)
