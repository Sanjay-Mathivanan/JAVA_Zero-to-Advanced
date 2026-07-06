# Introduction and Creation of HashMap in Java

# Introduction

After learning the **Map** interface, the next step is to understand **HashMap**, the most commonly used implementation of `Map`.

A `HashMap` is designed to store data as **key-value pairs** and provides **very fast insertion, retrieval, and deletion**. It is widely used in real-world Java applications because of its excellent performance.

Unlike the previous chapter, this section focuses only on **HashMap-specific concepts**.

---

# Learning Objectives

After completing this chapter, you will be able to:

* Understand what a HashMap is.
* Learn why HashMap is widely used.
* Create a HashMap using different constructors.
* Understand initial capacity and load factor.
* Learn the characteristics of HashMap.
* Know when to choose HashMap over other Map implementations.

---

# What is HashMap?

A **HashMap** is a class in the `java.util` package that implements the **Map** interface.

It stores data as **key-value pairs** and internally uses **hashing** to provide fast access to data.

Example

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

---

# Why HashMap?

Choose a `HashMap` when:

* Fast lookup is important.
* Fast insertion is required.
* Fast deletion is required.
* Ordering of elements is **not** important.
* Each record has a unique key.

Examples:

* Student records
* Employee database
* Product catalog
* Phone directory
* Inventory management

---

# Important Characteristics

* Implements the `Map` interface.
* Uses hashing internally.
* Stores data as key-value pairs.
* Keys must be unique.
* Duplicate values are allowed.
* Allows **one null key**.
* Allows **multiple null values**.
* Does **not** maintain insertion order.
* Not synchronized (not thread-safe).

---

# Creating a HashMap

## Recommended Syntax

```java
import java.util.HashMap;
import java.util.Map;

Map<Integer, String> students = new HashMap<>();
```

Using the `Map` interface makes your code more flexible.

---

# HashMap Constructors

## 1. Default Constructor

```java
HashMap<Integer, String> map = new HashMap<>();
```

Creates an empty HashMap with:

* Default Initial Capacity = **16**
* Default Load Factor = **0.75**

---

## 2. Constructor with Initial Capacity

```java
HashMap<Integer, String> map = new HashMap<>(32);
```

Useful when you know approximately how many entries will be stored.

This reduces unnecessary resizing.

---

## 3. Constructor with Capacity and Load Factor

```java
HashMap<Integer, String> map = new HashMap<>(32, 0.75f);
```

Allows you to customize:

* Initial Capacity
* Load Factor

---

## 4. Constructor Using Another Map

```java
Map<Integer, String> map1 = new HashMap<>();

Map<Integer, String> map2 = new HashMap<>(map1);
```

Creates a new HashMap containing all entries from another Map.

---

# Initial Capacity

Initial Capacity is the number of buckets created when the HashMap is initialized.

Default value:

```text
16
```

If many elements are expected, specifying a larger initial capacity can improve performance by reducing the number of resize operations.

---

# Load Factor

The **Load Factor** determines when the HashMap should increase its capacity.

Default value:

```text
0.75
```

Resize occurs when:

```text
Number of Entries >

Capacity × Load Factor
```

Example:

```text
Capacity = 16

Load Factor = 0.75

Threshold = 16 × 0.75 = 12
```

When the 13th element is inserted, the HashMap resizes.

---

# Null Handling

| Feature     | Supported  |
| ----------- | ---------- |
| Null Key    | ✅ One      |
| Null Values | ✅ Multiple |

Example

```java
Map<Integer, String> map = new HashMap<>();

map.put(null, "Unknown");

map.put(101, null);
```

---

# Time Complexity

| Operation | Average Case |
| --------- | ------------ |
| Insert    | O(1)         |
| Search    | O(1)         |
| Delete    | O(1)         |

> These are average-case complexities. Internal implementation details and worst-case behavior are covered in the **Internal Working** chapter.

---

# When Should You Use HashMap?

Use `HashMap` when:

* Data is identified using unique keys.
* Ordering is not required.
* High performance is important.
* Fast lookups are needed.

Avoid `HashMap` when:

* You need insertion order → Use `LinkedHashMap`.
* You need sorted keys → Use `TreeMap`.
* You need thread safety → Consider `ConcurrentHashMap` or `Hashtable` (depending on requirements).

---

# Simple Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Priya");

        System.out.println(students);

    }
}
```

### Output

```text
{101=Sanjay, 102=Rahul, 103=Priya}
```

> The output order is **not guaranteed** because `HashMap` does not maintain insertion order.

---

# Comparison with Other Map Implementations

| Feature            | HashMap | LinkedHashMap     | TreeMap         |
| ------------------ | ------- | ----------------- | --------------- |
| Ordering           | ❌ No    | ✅ Insertion Order | ✅ Sorted Order  |
| Search Performance | Fast    | Fast              | Slightly Slower |
| Null Key           | Yes     | Yes               | No              |
| Null Values        | Yes     | Yes               | Yes             |

---

# Best Practices

* Prefer `Map<K, V>` as the reference type.
* Choose an appropriate initial capacity when the expected size is known.
* Use immutable objects as keys whenever possible.
* Use `HashMap` when ordering is not important.

---

# Interview Questions

1. What is HashMap?
2. Which interface does HashMap implement?
3. Why is HashMap faster than many other collections for lookups?
4. What is the default initial capacity of a HashMap?
5. What is the default load factor?
6. Does HashMap maintain insertion order?
7. Can HashMap store a null key?
8. Can HashMap store multiple null values?
9. When should you use HashMap?
10. When should you choose LinkedHashMap or TreeMap instead?

---

# Key Takeaways

* `HashMap` is the most commonly used implementation of the `Map` interface.
* It provides fast insertion, retrieval, and deletion using hashing.
* It allows one `null` key and multiple `null` values.
* It does not maintain insertion order.
* Understanding its constructors, initial capacity, and load factor prepares you for learning its internal architecture.

---

# Conclusion

`HashMap` is the default choice for most key-value storage requirements in Java because of its speed and flexibility. While using a `HashMap` is straightforward, understanding its constructors, capacity, and load factor helps you write more efficient applications. The next chapter explores the **internal working of HashMap**, including buckets, hashing, collisions, resizing, and performance.
