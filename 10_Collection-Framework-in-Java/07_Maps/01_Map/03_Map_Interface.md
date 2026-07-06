# Map Interface in Java

## Introduction

The **Map** interface is one of the most important interfaces in the Java Collection Framework. It is designed to store data in the form of **key-value pairs**, where each **key is unique** and maps to exactly one value.

Unlike `List`, `Set`, and `Queue`, the `Map` interface **does not extend the `Collection` interface**. Instead, it is a separate interface that provides methods specifically for managing key-value mappings.

The `Map` interface serves as the foundation for classes such as `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable`.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand what the Map interface is.
* Learn the characteristics of the Map interface.
* Understand why Map does not extend the Collection interface.
* Identify the common implementations of Map.
* Learn the basic syntax of the Map interface.

---

# Problem Statement

Suppose you are building an **Online Shopping System**.

Each product has:

* Product ID
* Product Name

Example

```text
1001 → Laptop

1002 → Mouse

1003 → Keyboard
```

The Product ID should always point to the correct product.

This type of relationship is represented using the **Map interface**.

---

# What is the Map Interface?

The **Map** interface stores data as **key-value pairs**.

Each entry consists of:

* One unique key
* One corresponding value

Example

```text
Key        Value

101   →   Sanjay

102   →   Rahul

103   →   Priya
```

A key acts like an identifier, while the value stores the associated information.

---

# Package

The Map interface belongs to the **java.util** package.

```java
import java.util.Map;
```

---

# Declaration

```java
public interface Map<K, V>
```

Where:

* `K` → Type of the Key
* `V` → Type of the Value

---

# Generic Syntax

```java
Map<KeyType, ValueType> map;
```

Example

```java
Map<Integer, String> students;
```

Here,

* `Integer` represents the key.
* `String` represents the value.

---

# Creating a Map Reference

Since `Map` is an interface, objects cannot be created directly.

Incorrect

```java
Map<Integer, String> map = new Map<>();
```

This results in a compilation error because interfaces cannot be instantiated.

Correct

```java
Map<Integer, String> map = new HashMap<>();
```

Another example

```java
Map<String, Double> products = new TreeMap<>();
```

The reference type is `Map`, while the object belongs to a class implementing the interface.

---

# Why Use the Interface Instead of the Class?

Instead of writing

```java
HashMap<Integer, String> students = new HashMap<>();
```

prefer

```java
Map<Integer, String> students = new HashMap<>();
```

Advantages:

* Supports **programming to an interface**.
* Improves flexibility.
* Makes changing implementations easier.

Example

Today

```java
Map<Integer, String> map = new HashMap<>();
```

Later

```java
Map<Integer, String> map = new TreeMap<>();
```

Only the implementation changes; the rest of the code remains the same.

---

# Characteristics of the Map Interface

* Stores data as key-value pairs.
* Keys must be unique.
* Values can be duplicated.
* Each key maps to only one value.
* Keys are used to retrieve values.
* Belongs to the Java Collection Framework.
* Does not extend the `Collection` interface.
* Supports Generics.

---

# Map Hierarchy

```text
                    Object
                       │
                  Map Interface
                       │
      ┌────────────┬─────────────┬─────────────┐
      │            │             │             │
   HashMap   LinkedHashMap    TreeMap    Hashtable
```

---

# Why Doesn't Map Extend Collection?

Collections such as `List` and `Set` store **individual elements**.

Example

```text
Apple

Banana

Orange
```

A Map stores **two related objects** together.

Example

```text
101 → Apple

102 → Banana
```

Because of this difference, Java provides a separate interface for Maps.

---

# Key-Value Pair Representation

```text
+---------------------------+
| Key | Value               |
+---------------------------+
|101  | Sanjay              |
|102  | Rahul               |
|103  | Priya               |
+---------------------------+
```

Each row is called a **Map Entry**.

---

# Common Map Implementations

| Implementation  | Description                              |
| --------------- | ---------------------------------------- |
| `HashMap`       | Stores entries without maintaining order |
| `LinkedHashMap` | Maintains insertion order                |
| `TreeMap`       | Maintains keys in sorted order           |
| `Hashtable`     | Thread-safe implementation               |

---

# Common Methods of the Map Interface

| Method            | Purpose                         |
| ----------------- | ------------------------------- |
| `put()`           | Adds a key-value pair           |
| `get()`           | Retrieves the value using a key |
| `remove()`        | Removes a key-value pair        |
| `containsKey()`   | Checks whether a key exists     |
| `containsValue()` | Checks whether a value exists   |
| `keySet()`        | Returns all keys                |
| `values()`        | Returns all values              |
| `entrySet()`      | Returns all key-value pairs     |
| `size()`          | Returns the number of entries   |
| `isEmpty()`       | Checks whether the map is empty |
| `clear()`         | Removes all entries             |

---

# Real-World Applications

The Map interface is used in:

* Banking Systems
* Student Management Systems
* Employee Databases
* Inventory Management
* Login Authentication
* Phone Books
* Dictionary Applications
* Caching
* Configuration Management
* E-commerce Platforms

---

# Program Flow

```text
Create Map Reference

        │

        ▼

Choose Implementation

        │

        ▼

Store Key-Value Pairs

        │

        ▼

Retrieve Values Using Keys

        │

        ▼

Update or Remove Entries

        │

        ▼

Display Results
```

---

# Common Mistakes

## Trying to Create a Map Object

Incorrect

```java
Map<Integer, String> map = new Map<>();
```

Correct

```java
Map<Integer, String> map = new HashMap<>();
```

---

## Using Duplicate Keys

Incorrect

```text
101 → Sanjay

101 → Rahul
```

The second value replaces the first.

---

## Confusing Keys with Values

Remember:

* Key identifies the data.
* Value stores the actual information.

---

# Best Practices

* Declare variables using the `Map` interface.
* Choose the implementation based on project requirements.
* Use meaningful and unique keys.
* Prefer Generics for type safety.
* Use immutable objects as keys whenever possible.

---

# Interview Questions

1. What is the Map interface?
2. Why does Map not extend the Collection interface?
3. Can we create an object of the Map interface?
4. Why should we declare a Map using the interface type?
5. What are the major implementations of Map?
6. What is the purpose of Generics in Map?
7. Can Map contain duplicate keys?
8. Can Map contain duplicate values?
9. What is a key-value pair?
10. Name five methods available in the Map interface.

---

# Practice Programs

1. Declare a Map using different implementations.
2. Store student IDs and names.
3. Store product IDs and prices.
4. Retrieve values using keys.
5. Check whether a key exists.
6. Display all keys.
7. Display all values.
8. Remove an entry from a Map.
9. Compare `HashMap` and `TreeMap`.
10. Build a simple phone directory.

---

# Key Takeaways

* `Map` is an interface in the `java.util` package.
* It stores data as key-value pairs.
* Keys are unique, while values can be duplicated.
* The Map interface cannot be instantiated directly.
* `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable` are common implementations.
* Programming to the `Map` interface improves flexibility and maintainability.

---

# Conclusion

The `Map` interface provides a flexible and efficient way to store related data using key-value pairs. By separating the interface from its implementations, Java allows developers to switch between different Map implementations with minimal code changes. Understanding the Map interface is the first step toward mastering powerful classes like `HashMap`, `LinkedHashMap`, and `TreeMap`, which are widely used in real-world Java applications.
