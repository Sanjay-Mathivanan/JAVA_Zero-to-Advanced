# Introduction to Map in Java

## Introduction

A **Map** is one of the most important data structures in the Java Collection Framework. Unlike collections such as `ArrayList` and `LinkedList`, which store only values, a `Map` stores data in the form of **key-value pairs**.

Each key in a Map is unique and is associated with exactly one value. This makes Maps ideal for applications where data needs to be searched quickly using a unique identifier.

The `Map` is an **interface** available in the `java.util` package and is implemented by classes such as `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable`.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand what a Map is.
* Learn how a Map stores data.
* Understand the concept of key-value pairs.
* Identify the characteristics of a Map.
* Know where Maps are used in real-world applications.
* Understand the difference between a Map and a List.

---

# Problem Statement

Suppose you are developing a **Student Management System**.

Each student has:

* Student ID
* Student Name

Example:

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

If the user wants to find the student whose ID is **102**, searching through a list one by one is inefficient.

Instead, a **Map** allows us to directly retrieve the student using the Student ID as the key.

---

# Why Do We Need a Map?

Collections like `ArrayList` and `LinkedList` are useful for storing lists of objects.

However, many applications require data to be stored using a unique identifier.

Examples include:

* Student ID → Student Name
* Employee ID → Employee Details
* Username → Password
* Product ID → Product Information
* Country Code → Country Name
* Word → Meaning

In these situations, using a Map is much more efficient.

---

# What is a Map?

A **Map** is a data structure that stores data as **key-value pairs**.

Each key is unique.

Each key is associated with one value.

Example:

```text
Key          Value

101   →   Sanjay

102   →   Rahul

103   →   Priya
```

Think of a dictionary.

```text
Word          Meaning

Apple   →   A fruit

Java    →   Programming Language

Car     →   Vehicle
```

Here,

* Word = Key
* Meaning = Value

---

# Real-Life Analogy

Imagine a contact list on your mobile phone.

```text
Name             Phone Number

Sanjay     →     9876543210

Rahul      →     9123456780

Priya      →     9988776655
```

You search using the person's name and immediately get the phone number.

This is exactly how a Map works.

---

# Package

The Map interface belongs to the `java.util` package.

```java
import java.util.Map;
```

---

# Basic Syntax

A Map stores two data types:

* Key
* Value

General syntax:

```java
Map<KeyType, ValueType> map;
```

Example:

```java
Map<Integer, String> students;
```

Here,

* `Integer` → Key
* `String` → Value

---

# Key Characteristics of Map

* Stores data as key-value pairs.
* Keys must be unique.
* Values can be duplicated.
* Each key maps to only one value.
* Provides fast searching using keys.
* Part of the Java Collection Framework.
* Implemented by multiple classes.

---

# Map Hierarchy

```text
                Iterable
                    │
               Collection
                    │
        (Map is NOT part of Collection)
                    │
                  Map
                    │
     ┌──────────────┼──────────────┐
     │              │              │
 HashMap      LinkedHashMap     TreeMap
                    │
               Hashtable
```

> **Note:** Although Map belongs to the Java Collection Framework, it **does not extend the `Collection` interface**. It is a separate interface designed specifically for storing key-value pairs.

---

# Key-Value Representation

```text
+-----------------------+
| Key | Value |
+-----------------------+
|101  | Sanjay |
|102  | Rahul  |
|103  | Priya  |
+-----------------------+
```

---

# Memory Representation

Conceptually, a Map stores entries like this:

```text
Map

+----------------------------+
| Key : 101                  |
| Value : Sanjay             |
+----------------------------+

+----------------------------+
| Key : 102                  |
| Value : Rahul              |
+----------------------------+

+----------------------------+
| Key : 103                  |
| Value : Priya              |
+----------------------------+
```

---

# Real-World Applications

Maps are widely used in:

* Student Management Systems
* Employee Management Systems
* Banking Applications
* Phone Book Applications
* E-commerce Websites
* Dictionary Applications
* Configuration Files
* Caching Systems
* Login Authentication
* Database Indexing

---

# Common Implementations of Map

| Implementation  | Description                               |
| --------------- | ----------------------------------------- |
| `HashMap`       | Fast insertion and retrieval, no ordering |
| `LinkedHashMap` | Maintains insertion order                 |
| `TreeMap`       | Stores entries in sorted order            |
| `Hashtable`     | Thread-safe implementation                |

---

# Program Flow

```text
Create Map

      │

      ▼

Insert Key-Value Pair

      │

      ▼

Store Entry

      │

      ▼

Search Using Key

      │

      ▼

Retrieve Corresponding Value
```

---

# Common Mistakes

### Assuming Keys Can Be Duplicated

Incorrect:

```text
101 → Sanjay

101 → Rahul
```

A Map does not allow duplicate keys.

The second value replaces the first.

---

### Confusing Keys and Values

Remember:

* Key identifies the data.
* Value stores the actual information.

---

### Thinking Map Is a Collection

A Map belongs to the Java Collection Framework but **does not implement the `Collection` interface**.

---

# Best Practices

* Choose meaningful keys.
* Ensure keys are unique.
* Use immutable objects as keys whenever possible.
* Select the correct Map implementation based on your requirements.
* Prefer Generics for type safety.

---

# Interview Questions

1. What is a Map in Java?
2. What is the difference between a Map and a List?
3. Can a Map store duplicate keys?
4. Can a Map store duplicate values?
5. Which package contains the Map interface?
6. Does Map extend the Collection interface?
7. Name four implementations of the Map interface.
8. What is a key-value pair?
9. Give three real-world applications of Map.
10. Why is a Map preferred over a List for searching by key?

---

# Practice Programs

1. Create a Map of student IDs and names.
2. Store country codes and country names.
3. Create a phone book using a Map.
4. Store employee IDs and salaries.
5. Create a dictionary using key-value pairs.
6. Store product IDs and prices.
7. Store usernames and passwords.
8. Create a Map of roll numbers and marks.
9. Print all key-value pairs.
10. Display a value using a given key.

---

# Key Takeaways

* A Map stores data as key-value pairs.
* Keys are unique, while values can be duplicated.
* Maps are ideal for fast searching using a key.
* The Map interface belongs to the `java.util` package.
* Common implementations include `HashMap`, `LinkedHashMap`, `TreeMap`, and `Hashtable`.
* Maps are widely used in real-world applications such as phone books, banking systems, and student management systems.

---

# Conclusion

The `Map` interface is one of the most powerful components of the Java Collection Framework. It provides an efficient way to store and retrieve data using unique keys, making it suitable for applications that require quick lookups. Understanding the basics of Map is essential before exploring specific implementations such as `HashMap`, `LinkedHashMap`, and `TreeMap`.
