# Comparison Between Map and List in Java

# Introduction

Both **Map** and **List** are important parts of the Java Collection Framework, but they serve different purposes.

A **List** stores a collection of elements in a sequential order, whereas a **Map** stores data as **key-value pairs**.

Understanding the differences between them helps developers choose the correct data structure based on the application's requirements.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand the difference between Map and List.
* Identify when to use a List.
* Identify when to use a Map.
* Compare their internal structures.
* Choose the appropriate collection for real-world applications.

---

# Problem Statement

Suppose you are developing two applications:

### Application 1

A music playlist.

```text id="kjxg7h"
Song 1

Song 2

Song 3

Song 4
```

The order of songs is important.

A **List** is the best choice.

---

### Application 2

A student database.

```text id="aj75r7"
101 → Sanjay

102 → Rahul

103 → Priya
```

Searching is performed using the Student ID.

A **Map** is the best choice.

---

# What is a List?

A List stores elements in a sequence.

Example

```text id="9zhs6e"
Apple

Banana

Orange

Mango
```

Each element has an index.

```text id="0vjlwm"
0 → Apple

1 → Banana

2 → Orange

3 → Mango
```

---

# What is a Map?

A Map stores information as key-value pairs.

Example

```text id="fvonx5"
101 → Sanjay

102 → Rahul

103 → Priya
```

Each key identifies one value.

---

# Internal Representation

## List

```text id="7uzwwn"
Index

0 → Apple

1 → Banana

2 → Orange

3 → Mango
```

---

## Map

```text id="hjlwmv"
Key

101 → Sanjay

102 → Rahul

103 → Priya
```

---

# Major Differences

| Feature          | List                          | Map                       |
| ---------------- | ----------------------------- | ------------------------- |
| Stores           | Values                        | Key-Value Pairs           |
| Access           | Index                         | Key                       |
| Duplicate Values | Allowed                       | Allowed                   |
| Duplicate Keys   | Not Applicable                | Not Allowed               |
| Ordering         | Maintains Order               | Depends on Implementation |
| Null Values      | Allowed                       | Depends on Implementation |
| Search           | By Index or Sequential Search | By Key                    |
| Package          | `java.util`                   | `java.util`               |
| Generic Syntax   | `List<E>`                     | `Map<K,V>`                |

---

# Syntax Comparison

## List

```java id="4kvvw5"
List<String> fruits = new ArrayList<>();
```

---

## Map

```java id="0l7st7"
Map<Integer, String> students = new HashMap<>();
```

---

# Adding Data

## List

```java id="j7xjms"
fruits.add("Apple");
fruits.add("Banana");
```

Result

```text id="k3nyuh"
Apple

Banana
```

---

## Map

```java id="tlr5t0"
students.put(101, "Sanjay");
students.put(102, "Rahul");
```

Result

```text id="g5lhmn"
101 → Sanjay

102 → Rahul
```

---

# Retrieving Data

## List

```java id="vn8vrk"
fruits.get(1);
```

Output

```text id="a53kuo"
Banana
```

---

## Map

```java id="r0nyiu"
students.get(102);
```

Output

```text id="88ofv4"
Rahul
```

---

# Searching

## List

Searching requires checking elements one by one.

```text id="0nmhqr"
Apple

↓

Banana

↓

Orange
```

---

## Map

Searching uses a key.

```text id="ukjlwm"
Key = 102

↓

Rahul
```

Searching is generally faster in a `HashMap`.

---

# Duplicate Data

## List

Duplicate elements are allowed.

Example

```text id="jlwm76"
Apple

Apple

Orange
```

---

## Map

Duplicate keys are not allowed.

Example

```text id="5vz7ny"
101 → Sanjay

101 → Rahul
```

Final result

```text id="qkrj1v"
101 → Rahul
```

The old value is replaced.

---

# Ordering

## List

Always maintains insertion order.

```text id="3m1a8w"
Java

Python

C++

Go
```

---

## Map

Ordering depends on the implementation.

| Implementation | Order               |
| -------------- | ------------------- |
| HashMap        | No Guaranteed Order |
| LinkedHashMap  | Insertion Order     |
| TreeMap        | Sorted Order        |

---

# Real-World Applications

## List

Used for:

* Music Playlists
* Shopping Cart Items
* To-Do Lists
* Student Attendance
* Movie Collections

---

## Map

Used for:

* Phone Books
* Student Records
* Banking Systems
* Employee Databases
* Login Systems
* Product Catalogs

---

# Memory Representation

## List

```text id="kly3hi"
+----------------+

0 → Apple

1 → Banana

2 → Orange

+----------------+
```

---

## Map

```text id="0dkgs8"
+----------------+

101 → Sanjay

102 → Rahul

103 → Priya

+----------------+
```

---

# Performance Comparison

| Operation | List            | HashMap     |
| --------- | --------------- | ----------- |
| Add       | Fast            | Fast        |
| Search    | Sequential      | Fast by Key |
| Update    | By Index        | By Key      |
| Remove    | By Index/Object | By Key      |

> **Note:** The exact performance depends on the specific implementation (for example, `ArrayList`, `LinkedList`, or `HashMap`) and the operation being performed.

---

# When to Use a List

Use a List when:

* Order matters.
* Duplicate elements are allowed.
* Elements are accessed by index.
* Sequential traversal is required.

Examples

* Playlist
* Shopping Cart
* Student Marks List
* Book List

---

# When to Use a Map

Use a Map when:

* Every record has a unique identifier.
* Fast lookup is required.
* Data is stored as key-value pairs.
* Searching by key is frequent.

Examples

* Employee Database
* Phone Book
* Inventory System
* Banking Application

---

# Program Flow

```text id="0a8a5q"
Need Ordered Collection?

        │
   ┌────┴────┐
   │         │
 Yes        No
   │         │
   ▼         ▼

 Use List   Need Key?

               │
          ┌────┴────┐
          │         │
         Yes       No
          │         │
          ▼         ▼

       Use Map   Use List
```

---

# Common Mistakes

## Using a List for Key-Based Search

Incorrect

```text id="7cvzv5"
Student IDs stored in an ArrayList
```

Correct

```text id="d6yl1z"
Student IDs stored as keys in a Map
```

---

## Using a Map When Order Is the Only Requirement

If you only need ordered elements without key-value pairs, a List is usually a better choice.

---

## Confusing Keys with Indexes

A List uses **indexes**.

A Map uses **keys**.

They are not the same.

---

# Best Practices

* Use a List for ordered collections.
* Use a Map for unique key-value relationships.
* Choose the correct implementation (`ArrayList`, `LinkedList`, `HashMap`, `LinkedHashMap`, or `TreeMap`) based on the application's needs.
* Prefer the interface (`List` or `Map`) when declaring variables.

---

# Interview Questions

1. What is the difference between a List and a Map?
2. Does a Map allow duplicate keys?
3. Can a List store duplicate elements?
4. Which collection uses indexes?
5. Which collection stores key-value pairs?
6. Which collection is better for searching by ID?
7. Which Map implementation maintains insertion order?
8. Which collection is suitable for a playlist?
9. When should you use a Map instead of a List?
10. Give three real-world applications of both List and Map.

---

# Practice Programs

1. Store fruits using a List.
2. Store student IDs and names using a Map.
3. Compare retrieval using `get(index)` and `get(key)`.
4. Demonstrate duplicate elements in a List.
5. Demonstrate duplicate key replacement in a Map.
6. Create a shopping cart using a List.
7. Build a phone directory using a Map.
8. Compare `ArrayList` and `HashMap`.
9. Create an employee database using a Map.
10. Design a music playlist using a List.

---

# Key Takeaways

* A List stores values in sequence and accesses them using indexes.
* A Map stores data as key-value pairs and accesses values using keys.
* Lists allow duplicate elements.
* Maps allow duplicate values but not duplicate keys.
* Choose a List for ordered collections and a Map for key-based lookup.
* Selecting the appropriate data structure improves application design and performance.

---

# Conclusion

Although both `List` and `Map` are fundamental parts of the Java Collection Framework, they solve different problems. Lists are ideal for maintaining ordered collections of elements, while Maps are designed for storing and retrieving data using unique keys. Understanding their differences enables developers to choose the right collection for each scenario, resulting in cleaner, more efficient, and easier-to-maintain Java applications.
