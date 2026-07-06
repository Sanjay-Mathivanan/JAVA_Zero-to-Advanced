# Internal Working of Map in Java

## Introduction

The **Map** interface is designed to store data in the form of **key-value pairs**. From a programmer's perspective, adding and retrieving data is simple using methods like `put()` and `get()`. However, internally, Java performs several operations to store and locate entries efficiently.

Understanding the internal working of a Map helps developers:

* Choose the correct Map implementation.
* Write better and more efficient code.
* Understand interview questions related to Maps.
* Debug issues involving duplicate keys or missing values.

> **Note:** Since `Map` is an interface, it does not have its own internal implementation. The actual internal working depends on the implementation class such as `HashMap`, `LinkedHashMap`, or `TreeMap`. In this chapter, we discuss the general concepts common to Map implementations, with emphasis on `HashMap` because it is the most widely used.

---

# Learning Objectives

After completing this chapter, you will be able to:

* Understand how a Map stores data.
* Learn the concept of key-value pairs.
* Understand `Map.Entry`.
* Learn how entries are stored internally.
* Understand the role of hashing.
* Learn how values are retrieved.

---

# Problem Statement

Suppose we store student records in a Map.

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

When we execute

```java
students.get(102);
```

Java immediately returns:

```text
Rahul
```

How does Java locate the correct value without checking every entry?

To answer this question, we need to understand the internal working of a Map.

---

# Basic Idea

A Map stores information as **key-value pairs**.

Example

```text
Key        Value

101   →   Sanjay

102   →   Rahul

103   →   Priya
```

Each key uniquely identifies its corresponding value.

---

# Map Entry

Internally, every key-value pair is stored as an object called a **Map Entry**.

Conceptually,

```text
Entry

+----------------------+
| Key   : 101          |
| Value : Sanjay       |
+----------------------+
```

Another Entry

```text
+----------------------+
| Key   : 102          |
| Value : Rahul        |
+----------------------+
```

Each entry stores:

* Key
* Value

Some implementations (such as HashMap) also maintain additional information like the hash value and links to other entries.

---

# Map as a Collection of Entries

Conceptually,

```text
Map

│

├── Entry 1

│     101 → Sanjay

│

├── Entry 2

│     102 → Rahul

│

└── Entry 3

      103 → Priya
```

The Map manages these entries internally.

---

# Key-Value Relationship

Each key is associated with exactly one value.

```text
101 ─────────► Sanjay

102 ─────────► Rahul

103 ─────────► Priya
```

Duplicate keys are not allowed because each key represents a unique mapping.

---

# Internal Storage (Conceptual)

Think of a Map as a collection of storage locations.

```text
+----------------------------------+

Entry

101 → Sanjay

+----------------------------------+

Entry

102 → Rahul

+----------------------------------+

Entry

103 → Priya

+----------------------------------+
```

The exact storage structure depends on the implementation.

---

# Role of Hashing

Most Java applications use **HashMap**.

HashMap uses a technique called **hashing**.

Hashing converts a key into a numerical value called a **hash code**.

Example

```text
Key

101

↓

Hash Function

↓

Hash Code

↓

Storage Location
```

Instead of searching every entry one by one, Java directly uses the hash code to determine where the entry should be stored.

---

# What is a Hash Code?

A **hash code** is an integer generated from an object.

Every Java object inherits the `hashCode()` method from the `Object` class.

Example

```java
String name = "Java";

System.out.println(name.hashCode());
```

Output

```text
2301506
```

The exact value depends on the object.

---

# Simplified Storage Process

Suppose we insert

```java
students.put(101, "Sanjay");
```

Conceptually, Java performs the following steps:

```text
Key = 101

      │

      ▼

Generate Hash Code

      │

      ▼

Determine Storage Location

      │

      ▼

Store Entry

101 → Sanjay
```

---

# Adding Another Entry

```java
students.put(102, "Rahul");
```

Conceptually,

```text
102

↓

Hash Code

↓

New Storage Location

↓

102 → Rahul
```

---

# Adding Multiple Entries

```java
students.put(101, "Sanjay");

students.put(102, "Rahul");

students.put(103, "Priya");
```

Conceptually,

```text
Map

+------------------------+

101 → Sanjay

+------------------------+

102 → Rahul

+------------------------+

103 → Priya

+------------------------+
```

---

# Retrieving a Value

When

```java
students.get(102);
```

is executed,

Java does **not** compare every entry one by one.

Instead,

```text
Key

102

↓

Generate Hash Code

↓

Locate Storage Position

↓

Return Rahul
```

This is why searching in a `HashMap` is generally very fast.

---

# Internal Retrieval Process

```text
User

↓

get(102)

↓

Generate Hash Code

↓

Locate Entry

↓

Compare Key

↓

Return Value
```

---

# Why Keys Must Be Unique

Consider

```java
students.put(101, "Sanjay");

students.put(101, "Rahul");
```

Both entries use the same key.

Java treats this as an update.

Result

```text
101 → Rahul
```

The old value is replaced because a Map allows only one value for each key.

---

# Memory Representation

Conceptually,

```text
Map

│

├───────────────┐

│ Key : 101     │

│ Value : Sanjay│

└───────────────┘

│

├───────────────┐

│ Key : 102     │

│ Value : Rahul │

└───────────────┘

│

└───────────────┐

  Key : 103

  Value : Priya

└───────────────┘
```

---

# Program Flow

```text
Create Map

      │

      ▼

Insert Entry

      │

      ▼

Generate Hash Code

      │

      ▼

Store Entry

      │

      ▼

Search Using Key

      │

      ▼

Generate Hash Code

      │

      ▼

Locate Entry

      │

      ▼

Return Value
```

---

# Buckets in a HashMap

One of the most important concepts behind the internal working of a `HashMap` is the **Bucket**.

A bucket is simply a storage location where one or more entries are kept.

When a key is inserted,

1. Java calculates the hash code.
2. The hash code determines the bucket.
3. The entry is stored inside that bucket.

Conceptually

```text
             HashMap

        +----------------------+
Bucket0 |                      |
        +----------------------+
Bucket1 | 101 → Sanjay         |
        +----------------------+
Bucket2 |                      |
        +----------------------+
Bucket3 | 102 → Rahul          |
        +----------------------+
Bucket4 | 103 → Priya          |
        +----------------------+
```

The actual bucket index is calculated internally by Java.

---

# What is a Hash Collision?

Sometimes two different keys generate the same bucket index.

This situation is called a **Hash Collision**.

Example

```text
Key A

↓

Hash Code

↓

Bucket 3
```

```text
Key B

↓

Hash Code

↓

Bucket 3
```

Both keys need to be stored in the same bucket.

---

# Collision Representation

```text
Bucket 3

↓

+----------------------+

101 → Sanjay

↓

205 → Rahul

↓

309 → Priya

+----------------------+
```

Multiple entries can exist inside the same bucket.

Java handles collisions automatically.

---

# How Java Handles Collisions

When a collision occurs,

Java:

* does not discard the new entry.
* stores both entries inside the same bucket.
* compares keys whenever retrieval is performed.

Conceptually

```text
Bucket

↓

Entry 1

↓

Entry 2

↓

Entry 3
```

From Java 8 onwards, if many entries accumulate in a bucket, Java may internally organize them more efficiently to improve lookup performance.

---

# Updating an Existing Entry

Suppose

```java
students.put(101, "Sanjay");
```

Later

```java
students.put(101, "Rahul");
```

Internal steps

```text
Search Key

↓

101 Found

↓

Replace Value

↓

Rahul
```

Result

```text
101 → Rahul
```

No duplicate key is created.

---

# Removing an Entry

Suppose

```java
students.remove(102);
```

Java performs

```text
Generate Hash Code

↓

Locate Bucket

↓

Find Matching Key

↓

Remove Entry
```

After removal

```text
101 → Sanjay

103 → Priya
```

---

# Searching for a Value

Suppose

```java
students.get(103);
```

Internal working

```text
Key = 103

↓

Generate Hash Code

↓

Locate Bucket

↓

Compare Keys

↓

Return Value
```

Searching by key is much faster than searching every entry sequentially.

---

# Internal Workflow

```text
put(key, value)

        │

        ▼

Generate Hash Code

        │

        ▼

Find Bucket

        │

        ▼

Key Exists?

   ┌────┴─────┐
   │          │
  Yes        No
   │          │
   ▼          ▼

Update      Add Entry
Value

        │

        ▼

Map Updated
```

---

# Retrieval Workflow

```text
get(key)

    │

    ▼

Generate Hash Code

    │

    ▼

Find Bucket

    │

    ▼

Compare Keys

    │

    ▼

Return Value
```

---

# Removal Workflow

```text
remove(key)

      │

      ▼

Generate Hash Code

      │

      ▼

Locate Bucket

      │

      ▼

Find Entry

      │

      ▼

Delete Entry
```

---

# Internal Working of Different Map Implementations

## HashMap

* Uses hashing.
* No ordering is maintained.
* Very fast lookup.
* Allows one `null` key.
* Allows multiple `null` values.

---

## LinkedHashMap

Internally similar to `HashMap`.

Additionally maintains links between entries.

Conceptually

```text
Hash Table

↓

101 → Sanjay

↓

102 → Rahul

↓

103 → Priya
```

Because of these links,

* insertion order is preserved.
* traversal follows insertion order.

---

## TreeMap

TreeMap does not use hashing.

Instead it stores entries inside a self-balancing tree.

Conceptually

```text
           102

         /     \

      101      103

                \

                104
```

Because of this structure,

* keys remain sorted.
* searching is efficient.
* insertion order is not preserved.

---

## Hashtable

Hashtable is similar to HashMap but

* synchronized
* thread-safe
* does not allow `null` keys
* does not allow `null` values

---

# Comparison of Internal Working

| Feature     | HashMap    | LinkedHashMap            | TreeMap        | Hashtable  |
| ----------- | ---------- | ------------------------ | -------------- | ---------- |
| Storage     | Hash Table | Hash Table + Linked List | Red-Black Tree | Hash Table |
| Ordering    | No         | Insertion Order          | Sorted Order   | No         |
| Search      | Very Fast  | Very Fast                | Fast           | Fast       |
| Null Key    | Yes        | Yes                      | No             | No         |
| Null Values | Yes        | Yes                      | Yes            | No         |
| Thread Safe | No         | No                       | No             | Yes        |

---

# Memory Representation

```text
Map

+----------------------------------+

Bucket 0

↓

101 → Sanjay

+----------------------------------+

Bucket 1

↓

102 → Rahul

↓

205 → Priya

+----------------------------------+

Bucket 2

↓

305 → Kavin

+----------------------------------+
```

---

# Common Mistakes

## Assuming Duplicate Keys Are Stored

Incorrect

```text
101 → Sanjay

101 → Rahul
```

Correct

```text
101 → Rahul
```

The second value replaces the first.

---

## Thinking Every Map Works the Same Way

Different implementations have different internal structures.

* HashMap → Hash Table
* LinkedHashMap → Hash Table + Linked List
* TreeMap → Red-Black Tree

---

## Confusing Buckets with Entries

A bucket is a storage location.

An entry is a key-value pair stored inside a bucket.

---

# Best Practices

* Use immutable objects as keys whenever possible.
* Choose `HashMap` for fast lookup.
* Choose `LinkedHashMap` when insertion order matters.
* Choose `TreeMap` when sorted keys are required.
* Choose `Hashtable` only when synchronization is required.
* Avoid creating unnecessary collisions by using well-designed key objects.

---

# Interview Questions

1. How does a Map store data internally?
2. What is a `Map.Entry`?
3. What is a bucket?
4. What is hashing?
5. What is a hash collision?
6. How does Java handle collisions?
7. Why are duplicate keys not allowed?
8. Which Map implementation uses a tree?
9. Which implementation maintains insertion order?
10. Which implementation is synchronized?
11. What is the difference between `HashMap` and `TreeMap` internally?
12. Why is searching in a `HashMap` usually fast?

---

# Practice Programs

1. Insert multiple entries into a HashMap.
2. Demonstrate duplicate key replacement.
3. Retrieve values using `get()`.
4. Remove entries using `remove()`.
5. Compare HashMap and LinkedHashMap output.
6. Compare HashMap and TreeMap ordering.
7. Demonstrate `null` keys in HashMap.
8. Demonstrate sorted keys in TreeMap.
9. Create a custom key class and store objects in a HashMap.
10. Build a simple phone directory using Map.

---

# Key Takeaways

* A Map stores data as key-value pairs.
* Each entry is stored internally as a `Map.Entry`.
* HashMap uses hashing and buckets.
* A bucket may contain multiple entries due to collisions.
* Duplicate keys update existing values instead of creating new entries.
* LinkedHashMap maintains insertion order.
* TreeMap stores keys in sorted order using a Red-Black Tree.
* Hashtable is synchronized and thread-safe.
* Understanding internal working helps write efficient Java programs and prepares you for technical interviews.

---

# Conclusion

Although using a `Map` in Java is simple from a programmer's perspective, several internal operations take place behind the scenes. Java calculates hash codes, determines bucket locations, handles collisions, updates existing entries, and retrieves values efficiently. Different Map implementations achieve these operations using different data structures, such as hash tables, linked lists, and Red-Black Trees. A solid understanding of these concepts will help you choose the right implementation, optimize performance, and confidently answer Map-related interview questions.

