# Introduction to HashMap in Java

# Introduction

After understanding the **Map** interface, the next step is to learn about its most commonly used implementation: **HashMap**.

A **HashMap** is a class in Java that implements the `Map` interface. It stores data as **key-value pairs** and provides very fast insertion, deletion, and retrieval operations using a technique called **hashing**.

Because of its excellent performance and flexibility, `HashMap` is one of the most frequently used classes in Java applications.

---

# Learning Objectives

After completing this chapter, you will be able to:

* Understand what a HashMap is.
* Learn why HashMap is widely used.
* Understand the relationship between Map and HashMap.
* Identify the characteristics of HashMap.
* Recognize real-world applications of HashMap.

---

# Problem Statement

Suppose you are developing a **College Management System**.

Each student has:

* Student ID
* Student Name

Example

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

Whenever a user enters a Student ID, the application should immediately display the corresponding student name.

A **HashMap** is an ideal choice for this type of application because it provides fast key-based lookup.

---

# What is HashMap?

A **HashMap** is a class that implements the **Map** interface.

It stores data in the form of **key-value pairs**.

Each key is unique and maps to exactly one value.

Example

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

Here,

* **Key** → Student ID
* **Value** → Student Name

---

# Package

The `HashMap` class belongs to the **java.util** package.

```java
import java.util.HashMap;
```

---

# Class Declaration

```java
public class HashMap<K, V>
        extends AbstractMap<K, V>
        implements Map<K, V>, Cloneable, Serializable
```

Where

* `K` → Type of Key
* `V` → Type of Value

---

# Relationship Between Map and HashMap

```text
                 Object
                    │
            Map Interface
                    │
              HashMap Class
```

The `Map` interface defines the operations.

The `HashMap` class provides the implementation.

---

# Why Do We Need HashMap?

Suppose we store student names in an `ArrayList`.

```text
Sanjay

Rahul

Priya
```

To find **Rahul**, the program may need to check multiple elements.

Now consider using a HashMap.

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

Searching becomes simple.

```text
Student ID = 102

↓

Rahul
```

HashMap performs this lookup efficiently.

---

# Key Characteristics of HashMap

* Stores data as key-value pairs.
* Implements the `Map` interface.
* Uses hashing internally.
* Keys must be unique.
* Duplicate values are allowed.
* Allows one `null` key.
* Allows multiple `null` values.
* Does not maintain insertion order.
* Not synchronized (not thread-safe by default).
* Supports Generics.

---

# Syntax

## Creating a HashMap

```java
HashMap<Integer, String> students = new HashMap<>();
```

Recommended approach

```java
Map<Integer, String> students = new HashMap<>();
```

Programming to the interface makes the code more flexible.

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

---

# Output

```text
{101=Sanjay, 102=Rahul, 103=Priya}
```

> **Note:** The order of elements displayed by a `HashMap` is **not guaranteed**.

---

# Internal Representation

Conceptually

```text
HashMap

+---------------------------+

101 → Sanjay

+---------------------------+

102 → Rahul

+---------------------------+

103 → Priya

+---------------------------+
```

Internally, `HashMap` organizes these entries using hashing and buckets.

---

# Real-World Applications

HashMap is widely used in:

* Student Management Systems
* Banking Applications
* Employee Databases
* Product Catalogs
* Phone Directories
* Login Systems
* Shopping Applications
* Inventory Management
* Configuration Storage
* API Response Processing
* Caching Mechanisms

---

# Advantages of HashMap

* Fast insertion.
* Fast retrieval.
* Fast deletion.
* Supports custom objects.
* Dynamic size.
* Easy to use.
* Efficient key-based searching.

---

# Limitations of HashMap

* Does not preserve insertion order.
* Keys must be unique.
* Not synchronized.
* Performance may decrease if many hash collisions occur.

---

# Program Flow

```text
Create HashMap

       │

       ▼

Insert Key-Value Pairs

       │

       ▼

Generate Hash Code

       │

       ▼

Store Entry

       │

       ▼

Retrieve Using Key

       │

       ▼

Return Value
```

---

# Common Mistakes

## Assuming HashMap Maintains Order

Incorrect assumption

```text
HashMap stores entries in insertion order.
```

Correct

HashMap does **not** guarantee any order.

---

## Using Duplicate Keys

```java
students.put(101, "Sanjay");

students.put(101, "Rahul");
```

Result

```text
101 → Rahul
```

The previous value is replaced.

---

## Confusing HashMap with Hashtable

* `HashMap` is **not synchronized**.
* `Hashtable` is synchronized.

---

# Best Practices

* Declare variables using the `Map` interface.
* Use meaningful keys.
* Avoid mutable objects as keys whenever possible.
* Use `HashMap` for fast lookup when ordering is not required.
* Choose `LinkedHashMap` or `TreeMap` if ordering is important.

---

# Interview Questions

1. What is a HashMap?
2. Which interface does HashMap implement?
3. Does HashMap allow duplicate keys?
4. Does HashMap allow duplicate values?
5. Does HashMap maintain insertion order?
6. Is HashMap synchronized?
7. Can HashMap store `null` keys?
8. Can HashMap store `null` values?
9. What technique does HashMap use internally?
10. Give five real-world applications of HashMap.

---

# Practice Programs

1. Create a HashMap of student IDs and names.
2. Store employee IDs and salaries.
3. Store product IDs and prices.
4. Demonstrate duplicate key replacement.
5. Store duplicate values.
6. Store one `null` key.
7. Store multiple `null` values.
8. Compare `HashMap` and `LinkedHashMap`.
9. Compare `HashMap` and `TreeMap`.
10. Build a simple phone directory using HashMap.

---

# Key Takeaways

* `HashMap` is the most commonly used implementation of the `Map` interface.
* It stores data as key-value pairs.
* Keys are unique, while values can be duplicated.
* It uses hashing internally for efficient storage and retrieval.
* It allows one `null` key and multiple `null` values.
* It does not maintain insertion order.
* It is ideal for applications requiring fast key-based access.

---

# Conclusion

`HashMap` is one of the most powerful and frequently used classes in Java. By implementing the `Map` interface and using hashing internally, it provides efficient storage and retrieval of key-value pairs. Understanding the fundamentals of `HashMap` is essential before exploring its constructors, methods, internal working, performance characteristics, and advanced usage in real-world applications.
