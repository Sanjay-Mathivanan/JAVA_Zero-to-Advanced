# LinkedHashSet in Java

## Introduction

While `HashSet` is extremely fast (`O(1)` average time), it does not maintain any insertion order. If you iterate through a `HashSet`, elements appear in an unpredictable, random sequence.

To address this limitation, Java provides **`LinkedHashSet`**. A `LinkedHashSet` extends `HashSet` and implements the `Set` interface, using a doubly linked list running through all its entries to maintain their insertion order.

---

## Why LinkedHashSet?

If you are building an application where entries must remain unique but their sequence is important—such as a **Task Scheduling Order**, a **Most Recently Visited Pages List**, or a **Playlist Sorter**—`LinkedHashSet` is the ideal collection:

```java
// Standard HashSet (Unordered)
Set<String> hashSet = new HashSet<>();
hashSet.add("First");
hashSet.add("Second");
System.out.println(hashSet); // Output might be: [Second, First]

// LinkedHashSet (Insertion Order Preserved)
Set<String> linkedSet = new LinkedHashSet<>();
linkedSet.add("First");
linkedSet.add("Second");
System.out.println(linkedSet); // Output is guaranteed: [First, Second]
```

---

## Features of LinkedHashSet

* **No Duplicates**: Duplicate elements are rejected automatically.
* **Insertion Order**: Iteration returns elements in the exact order they were inserted.
* **Allows Nulls**: Permits **exactly one null element**.
* **Constant Time Operations**: basic operations (`add`, `remove`, `contains`) run in `O(1)` average time.
* **Higher Memory Footprint**: Uses more memory than `HashSet` to store the doubly linked node pointers (`before` and `after`).

---

## Creating a LinkedHashSet

### Basic Initialization
```java
import java.util.LinkedHashSet;
import java.util.Set;

// Generic format: Set<Type> setName = new LinkedHashSet<>();
Set<String> taskQueue = new LinkedHashSet<>();
```

Always use Wrapper classes instead of primitive types.

---

## Common Methods

| Method | Description | Time Complexity |
| :--- | :--- | :---: |
| **`add(E e)`** | Adds the element to the tail of the list if not present. | `O(1)` average |
| **`remove(Object o)`** | Removes the element and updates linked list pointers. | `O(1)` average |
| **`contains(Object o)`** | Returns `true` if the element exists. | `O(1)` average |
| **`size()`** | Returns the count of elements. | `O(1)` |
| **`clear()`** | Removes all entries. | `O(N)` |

---

## Iterating Through a LinkedHashSet

Traversing a `LinkedHashSet` always yields elements in their exact insertion order:

```java
// Using For-Each Loop
for (String task : taskQueue) {
    System.out.println("Processing: " + task);
}
```

---

## Complete Programs

### Example: Maintaining a Unique List of Visited URLs in Order
```java
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        Set<String> visitedUrls = new LinkedHashSet<>();

        // 1. Visited pages sequence
        visitedUrls.add("homepage.com");
        visitedUrls.add("profile.com");
        visitedUrls.add("settings.com");
        visitedUrls.add("homepage.com"); // Duplicate entry ignored

        // 2. Traversal order check
        System.out.println("Browser History (Unique & Ordered):");
        for (String url : visitedUrls) {
            System.out.println(url);
        }
        // Output matches insertion order:
        // homepage.com
        // profile.com
        // settings.com
    }
}
```

---

## Best Practices

* **Prefer HashSet by default**: Use `HashSet` instead of `LinkedHashSet` unless you specifically need insertion order, to avoid the memory overhead of the doubly linked list.
* **Initial Capacity Bounds**: Set the initial capacity if you know the maximum size to prevent rehashing:
  ```java
  Set<String> set = new LinkedHashSet<>(50);
  ```

---

## Common Mistakes

* **Assuming Sorting**: `LinkedHashSet` preserves **insertion order**, not alphabetical or numeric sorted order. (Use `TreeSet` if sorting is required).
* **Element Modifications**: Modifying properties of an object stored in the set can corrupt the internal hash buckets, making it impossible to find.

---

## Key Takeaways

* `LinkedHashSet` maintains uniqueness while preserving insertion sequence.
* It uses a doubly linked list running through hash buckets.
* Higher memory overhead than `HashSet` due to storing node pointer links.

---

**Back to Sets Home:** [Sets Index](../README.md)
