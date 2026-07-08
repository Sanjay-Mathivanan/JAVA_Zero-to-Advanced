# ArrayList in Java: Methods Part 1

## Introduction

After understanding how to initialize an `ArrayList`, the next step is learning how to perform basic CRUD operations on it. This guide covers the first part of the most commonly used methods of the `ArrayList` class, detailing how to add, retrieve, update, and search for elements.

---

## ArrayList Methods: Part 1 Summary

| Method | Return Type | Purpose |
| :--- | :--- | :--- |
| `add(E e)` | `boolean` | Appends element `e` to the end of the list. |
| `add(int index, E element)`| `void` | Inserts `element` at the specified 0-based index. |
| `get(int index)` | `E` | Retrieves the element at the specified index. |
| `set(int index, E element)` | `E` | Replaces the element at the index with `element`. |
| `size()` | `int` | Returns the total number of elements in the list. |
| `contains(Object o)` | `boolean` | Returns `true` if the list contains `o`. |
| `isEmpty()` | `boolean` | Returns `true` if the list has a size of 0. |

---

## 1. Adding Elements (`add`)

### Appending to the End:
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        
        System.out.println(fruits); // Output: [Apple, Banana]
    }
}
```

### Inserting at an Index:
```java
// Inserts "Orange" at index 1, shifting "Banana" to index 2
fruits.add(1, "Orange");
System.out.println(fruits); // Output: [Apple, Orange, Banana]
```

---

## 2. Retrieving and Updating (`get` & `set`)

### Getting Elements:
```java
String item = fruits.get(1);
System.out.println("Item at index 1: " + item); // Output: Orange
```

### Setting Elements (Replacing):
```java
// Replaces index 1 with "Mango"
fruits.set(1, "Mango"); 
System.out.println(fruits); // Output: [Apple, Mango, Banana]
```

---

## 3. Querying the List (`size` & `contains`)

### Checking size and emptiness:
```java
System.out.println("Size: " + fruits.size()); // Size: 3
System.out.println("Is empty: " + fruits.isEmpty()); // Is empty: false
```

### Checking for existence:
```java
boolean hasApple = fruits.contains("Apple");
System.out.println("Contains Apple? " + hasApple); // true
```

---

## Key Takeaways

* `add()` appends elements to the end in $\mathcal{O}(1)$ time.
* Inserting at an index (`add(index, element)`) shifts subsequent elements, taking $\mathcal{O}(N)$ time.
* `get()` and `set()` operate in constant time ($\mathcal{O}(1)$) due to direct index calculation on the underlying array.
* Use `size()` to dynamically fetch the element count instead of caching it manually.

---

**Back to Module Home:** [Collection Framework Index](../README.md)
