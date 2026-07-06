# Features of Map in Java

## Introduction

The **Map** interface is one of the most powerful components of the Java Collection Framework. It provides an efficient way to store and retrieve data using **key-value pairs**.

Understanding the features of a Map helps developers choose the right data structure for applications such as student management systems, banking systems, inventory management, phone books, and caching.

This chapter explains the important features of the `Map` interface with examples and real-world scenarios.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand the important features of a Map.
* Learn how keys and values are stored.
* Understand uniqueness of keys.
* Learn about duplicate values.
* Understand dynamic storage.
* Learn how different Map implementations behave.
* Identify the advantages of using a Map.

---

# Problem Statement

Suppose you are building an **Employee Management System**.

Each employee has a unique Employee ID.

Example

```text
1001 → John

1002 → David

1003 → Alice
```

The application should:

* Store employees efficiently.
* Retrieve employee details quickly.
* Prevent duplicate Employee IDs.
* Allow duplicate employee names.

The Map interface provides these features naturally.

---

# Feature 1: Stores Data as Key-Value Pairs

Unlike a List that stores only values, a Map stores both a **key** and a **value**.

Example

```text
Roll Number → Student Name

101 → Sanjay

102 → Rahul

103 → Priya
```

Every entry contains two parts:

* Key
* Value

---

# ASCII Diagram

```text
+----------------------+
| Key | Value          |
+----------------------+
|101  | Sanjay         |
|102  | Rahul          |
|103  | Priya          |
+----------------------+
```

---

# Feature 2: Keys Must Be Unique

One of the most important features of a Map is that **duplicate keys are not allowed**.

Example

```text
101 → Sanjay

101 → Rahul
```

The second value replaces the first one.

Final result

```text
101 → Rahul
```

Only one value can exist for a particular key.

---

# Feature 3: Duplicate Values Are Allowed

Unlike keys, values may be duplicated.

Example

```text
101 → Sanjay

102 → Rahul

103 → Sanjay
```

Here,

* Keys are different.
* Values are the same.

This is completely valid.

---

# Feature 4: Fast Lookup Using Keys

The main advantage of a Map is quick retrieval using a key.

Example

```text
Search Key

↓

102

↓

Result

Rahul
```

Instead of searching every element one by one, the Map directly finds the associated value.

---

# Feature 5: Dynamic Size

A Map automatically grows and shrinks as entries are added or removed.

Initially

```text
Map

Empty
```

After inserting entries

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

The size increases automatically.

No manual resizing is required.

---

# Feature 6: One Key Maps to One Value

Each key is associated with exactly one value.

Example

```text
1001

↓

Laptop
```

A key cannot point to multiple values simultaneously.

---

# Feature 7: Values Can Be Any Object

A Map can store different types of values.

Examples

```text
Integer → String

String → Double

Integer → Student

String → Employee
```

Example declarations

```java
Map<Integer, String> students;

Map<String, Double> products;

Map<Integer, Student> studentRecords;
```

---

# Feature 8: Generic Support

The Map interface supports Generics.

Example

```java
Map<Integer, String> students;
```

Benefits

* Type safety
* Compile-time checking
* No explicit casting
* Cleaner code

---

# Feature 9: Multiple Implementations

Java provides several implementations of the Map interface.

| Implementation | Feature                    |
| -------------- | -------------------------- |
| HashMap        | Fast access, no ordering   |
| LinkedHashMap  | Maintains insertion order  |
| TreeMap        | Maintains sorted order     |
| Hashtable      | Thread-safe implementation |

Each implementation is designed for different requirements.

---

# Feature 10: Stores Objects as Keys and Values

A Map is not limited to primitive wrapper classes.

It can store custom objects.

Example

```java
Map<Integer, Student> students;
```

Here,

* Key = Integer
* Value = Student Object

---

# Feature 11: Does Not Implement Collection

The Map interface belongs to the Java Collection Framework but **does not extend the Collection interface**.

Reason

Collections store individual elements.

Example

```text
Apple

Banana

Orange
```

Maps store related information.

Example

```text
101 → Apple

102 → Banana
```

---

# Feature 12: Null Handling

Different Map implementations handle `null` differently.

| Implementation | Null Keys                      | Null Values      |
| -------------- | ------------------------------ | ---------------- |
| HashMap        | One Allowed                    | Multiple Allowed |
| LinkedHashMap  | One Allowed                    | Multiple Allowed |
| TreeMap        | Not Allowed (Natural Ordering) | Allowed          |
| Hashtable      | Not Allowed                    | Not Allowed      |

---

# Feature 13: Easy Data Retrieval

Instead of remembering indexes, values are retrieved using meaningful keys.

Example

```text
Username

↓

Password
```

This makes applications easier to design and maintain.

---

# Feature 14: Widely Used in Real Applications

Maps are commonly used in:

* Banking Systems
* Phone Books
* Student Records
* Employee Databases
* Login Systems
* Shopping Applications
* Inventory Management
* Dictionary Applications
* API Responses
* Configuration Files
* Caching Mechanisms

---

# Feature Summary

| Feature                  | Description                     |
| ------------------------ | ------------------------------- |
| Key-Value Storage        | Stores data in pairs            |
| Unique Keys              | Duplicate keys are not allowed  |
| Duplicate Values         | Allowed                         |
| Fast Lookup              | Search using keys               |
| Dynamic Size             | Grows and shrinks automatically |
| Generic Support          | Yes                             |
| Multiple Implementations | Yes                             |
| Custom Objects           | Supported                       |
| Ordered Storage          | Depends on implementation       |
| Thread Safety            | Depends on implementation       |

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

Retrieve Value

      │

      ▼

Update or Remove Entry
```

---

# Common Mistakes

## Using Duplicate Keys

Incorrect

```text
101 → Sanjay

101 → Rahul
```

Only the last value is retained.

---

## Assuming Keys Can Be Null Everywhere

Not every Map implementation allows `null` keys.

Always check the implementation before using `null`.

---

## Choosing the Wrong Map Implementation

Use:

* `HashMap` for fast lookup.
* `LinkedHashMap` for insertion order.
* `TreeMap` for sorted keys.

---

# Best Practices

* Use meaningful and unique keys.
* Declare variables using the `Map` interface.
* Use Generics for type safety.
* Choose the correct implementation based on application requirements.
* Avoid mutable objects as keys whenever possible.

---

# Interview Questions

1. What are the main features of the Map interface?
2. Why are duplicate keys not allowed?
3. Can duplicate values exist in a Map?
4. Which Map implementation maintains insertion order?
5. Which Map implementation stores keys in sorted order?
6. Does Map support Generics?
7. Can custom objects be stored in a Map?
8. Does Map implement the Collection interface?
9. Which Map implementation allows one `null` key?
10. Why is Map preferred for searching by unique identifiers?

---

# Practice Programs

1. Create a Map of employee IDs and names.
2. Store product IDs and prices.
3. Demonstrate duplicate value storage.
4. Show how duplicate keys replace previous values.
5. Create a Map using custom objects.
6. Compare different Map implementations.
7. Store country codes and country names.
8. Build a simple phone book.
9. Store roll numbers and marks.
10. Create a login system using username-password pairs.

---

# Key Takeaways

* A Map stores data as key-value pairs.
* Keys are unique, while values may be duplicated.
* Maps provide fast lookup using keys.
* The size of a Map changes dynamically.
* Different implementations provide different ordering and performance characteristics.
* Maps support Generics and custom objects.
* Choosing the correct Map implementation improves application performance.

---

# Conclusion

The `Map` interface offers several powerful features that make it ideal for storing and retrieving related data efficiently. Its support for unique keys, dynamic sizing, generic types, and multiple implementations makes it one of the most versatile data structures in Java. Understanding these features will help you effectively use `HashMap`, `LinkedHashMap`, `TreeMap`, and other Map implementations in real-world applications.
