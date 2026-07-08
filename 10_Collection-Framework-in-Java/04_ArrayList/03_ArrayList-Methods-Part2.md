# ArrayList in Java: Methods Part 2

## Introduction

In the previous guide, we covered basic additions, retrievals, and updates. This chapter covers the second part of ArrayList operations—including element removals, resizing optimizations, conversions to primitive arrays, and list cleanups.

---

## ArrayList Methods: Part 2 Summary

| Method | Return Type | Purpose |
| :--- | :--- | :--- |
| `remove(int index)` | `E` | Removes and returns the element at the specified index. |
| `remove(Object o)` | `boolean` | Removes the first occurrence of `o` from the list. |
| `clear()` | `void` | Removes all elements from the list, resetting size to 0. |
| `clone()` | `Object` | Returns a shallow copy of the `ArrayList` instance. |
| `toArray()` | `Object[]` | Converts the list into a standard primitive/object array. |
| `ensureCapacity(int min)`| `void` | Increases the capacity to guarantee it holds at least `min`. |
| `trimToSize()` | `void` | Trims the capacity to equal the current active size. |

---

## 1. Removing Elements (`remove` & `clear`)

### Removing by Index:
When you remove by index, all subsequent elements are shifted left to close the gap. This is an $\mathcal{O}(N)$ operation:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        fruits.remove(1); // Removes "Banana" at index 1
        System.out.println(fruits); // Output: [Apple, Orange]
    }
}
```

### Removing by Object Value:
Removes the first matching instance (using `equals()` comparison):
```java
fruits.remove("Apple"); // Returns true
System.out.println(fruits); // Output: [Orange]
```

### Clearing the List:
```java
fruits.clear(); // Resets list size to 0
System.out.println(fruits); // Output: []
```

---

## 2. Dynamic Memory Optimization (`ensureCapacity` & `trimToSize`)

* **`ensureCapacity(int minCapacity)`**: If you know you are about to add 10,000 elements, calling `ensureCapacity(10000)` beforehand allocates the internal array space in a single step, preventing multiple expensive array-copy resizing iterations.
* **`trimToSize()`**: If an ArrayList has a capacity of 100 elements, but only holds 5 elements, calling `trimToSize()` shrinks the internal array to a size of 5, reclaiming unused memory slots on the heap.

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(100); // Capacity: 100
        list.add(10);
        list.add(20);

        list.trimToSize(); // Internal array capacity is reduced from 100 to 2
    }
}
```

---

## 3. Converting to standard arrays (`toArray`)

The `toArray()` method converts the collection into a standard array:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");

        // Convert to String array
        String[] arr = list.toArray(new String[0]);
        System.out.println("Array Length: " + arr.length); // 2
    }
}
```

---

## Key Takeaways

* Removing elements by index or value requires shifting elements left, operating in $\mathcal{O}(N)$ time.
* Use `ensureCapacity()` before batch inserts to optimize memory allocations.
* Use `trimToSize()` to release unused array slots back to the heap.
* `toArray()` creates a separate, independent array copy representing the current collection elements.

---

**Back to Module Home:** [Collection Framework Index](../README.md)
