# HashSet in Java

## Introduction

In programming, we often need to store a collection of elements where **duplicates are not allowed**—such as a list of unique email addresses, user IDs, or active IP addresses.

The Java Collection Framework (JCF) provides the `Set` interface to represent a collection of unique elements, and **`HashSet`** is its most popular implementation. A `HashSet` uses a hash table internally (backed by a `HashMap` instance) to store elements, providing constant-time performance for basic operations.

---

## Why HashSet?

If we use a standard `ArrayList` to keep a list of unique items, we must call `list.contains(item)` before every insertion to check for duplicates:

* **ArrayList Check Complexity**: `O(N)` linear time. As the list grows, checking for duplicates becomes slower.
* **HashSet Solution**: A `HashSet` checks for duplicates using hashing index lookups in **constant time (`O(1)`)**. This makes it the ideal collection for managing large amounts of unique data.

---

## Features of HashSet

* **No Duplicates**: Duplicate elements are rejected automatically.
* **Unordered**: Does not guarantee any specific iteration order of elements.
* **Allows Nulls**: Permits **exactly one null element**.
* **Non-Synchronized**: It is not thread-safe.
* **Hashing Backed**: Performance of basic operations (`add`, `remove`, `contains`) remains constant at `O(1)` average time.

---

## Creating a HashSet

### Basic Initialization
Declare set reference variables using the parent `Set` interface type:

```java
import java.util.HashSet;
import java.util.Set;

// Generic format: Set<Type> setName = new HashSet<>();
Set<String> uniqueUsernames = new HashSet<>();
```

Always use Wrapper classes instead of primitive types (e.g., `Set<Integer>` instead of primitive types).

---

## Common Methods

| Method | Description | Time Complexity |
| :--- | :--- | :---: |
| **`add(E e)`** | Adds the element if it is not already present. Returns `true` if inserted. | `O(1)` average |
| **`remove(Object o)`** | Removes the element from the set if present. | `O(1)` average |
| **`contains(Object o)`** | Returns `true` if the set contains the specified element. | `O(1)` average |
| **`size()`** | Returns the number of elements in the set. | `O(1)` |
| **`isEmpty()`** | Returns `true` if the set contains 0 elements. | `O(1)` |
| **`clear()`** | Removes all elements from the set. | `O(N)` |

---

## Iterating Through a HashSet

### 1. Using For-Each Loop
```java
for (String username : uniqueUsernames) {
    System.out.println(username);
}
```

### 2. Using an Iterator
```java
import java.util.Iterator;

Iterator<String> iterator = uniqueUsernames.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### 3. Using Java 8 Lambda (`forEach()`)
```java
uniqueUsernames.forEach(username -> System.out.println(username));
```

---

## Complete Programs

### Example: Storing and Querying Unique Student Roll Numbers
```java
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<Integer> rollNumbers = new HashSet<>();

        // 1. Adding elements
        System.out.println("Adding 101: " + rollNumbers.add(101)); // true
        System.out.println("Adding 102: " + rollNumbers.add(102)); // true
        System.out.println("Adding 101 (Duplicate): " + rollNumbers.add(101)); // false

        // 2. Querying elements
        System.out.println("Contains 102? " + rollNumbers.contains(102)); // true
        System.out.println("Contains 103? " + rollNumbers.contains(103)); // false

        // 3. Removing elements
        rollNumbers.remove(102);
        System.out.println("Size after removal: " + rollNumbers.size()); // 1

        // 4. Traversing
        System.out.println("Remaining Roll Numbers:");
        for (Integer roll : rollNumbers) {
            System.out.println(roll);
        }
    }
}
```

---

## Best Practices

* **Pre-size HashSet**: If you know how many elements you will store, set the initial capacity in the constructor to avoid rehashing:
  ```java
  Set<String> set = new HashSet<>(100);
  ```
* **Override `equals()` and `hashCode()`**: When storing custom objects (like `Student` or `Employee`), always override these methods. If you don't, Java will use default memory-address comparisons, allowing duplicate objects to be added.

---

## Common Mistakes

* **Assuming Order**: Do not write code that assumes elements remain in their insertion sequence. Iteration order can change when the set is resized.
* **Mutable Keys**: Avoid changing an object's properties after adding it to a `HashSet`. If the properties that calculate `hashCode()` change, the object will get lost inside the set buckets, making it impossible to find or remove.

---

## Key Takeaways

* `HashSet` is designed for unique element storage with fast lookup (`O(1)` average time).
* It does not maintain any insertion or sorted order.
* Uniqueness of custom objects requires correctly overriding `equals()` and `hashCode()`.

---

**Back to Sets Home:** [Sets Index](../README.md)
