# Internal Working of HashMap

# Introduction

One of the biggest reasons behind the popularity of **HashMap** is its excellent performance.

Although using a HashMap is as simple as calling `put()` and `get()`, internally Java performs several operations to store and retrieve data efficiently.

Understanding the internal working of HashMap is very important for:

* Technical Interviews
* Writing efficient Java programs
* Solving performance issues
* Understanding why HashMap is faster than many other collections

---

# Learning Objectives

After completing this chapter, you will be able to understand:

* How HashMap stores data internally
* Bucket Array
* Node Structure
* Hash Function
* Bucket Index Calculation
* Collision
* Treeification (Java 8)
* Resize & Rehashing
* Search Process

---

# Internal Architecture

A HashMap mainly consists of:

```text
HashMap

│

├── Bucket Array

│

└── Nodes (Key-Value Pairs)
```

Every element is stored inside a **Node**.

---

# Bucket Array

A HashMap internally maintains an **array of buckets**.

Default Capacity

```text
16 Buckets
```

Conceptually

```text
Index

0

1

2

3

4

5

...

15
```

Each bucket can store one or more nodes.

---

# Node Structure

Each entry is stored as a **Node**.

Conceptually

```text
+----------------------------+

Hash

Key

Value

Next

+----------------------------+
```

Each node stores:

* Hash Value
* Key
* Value
* Reference to the next node (used during collisions)

---

# Step 1 : Calculate Hash Code

When inserting

```java
map.put(101, "Sanjay");
```

Java first calls

```java
hashCode()
```

Example

```text
Key

101

↓

hashCode()

↓

Hash Value
```

---

# Step 2 : Calculate Bucket Index

The hash value is converted into a bucket index.

Conceptually

```text
Hash Value

↓

Bucket Index

↓

Bucket 5
```

The bucket index determines where the entry should be stored.

---

# Step 3 : Store the Node

If the bucket is empty

```text
Bucket 5

↓

101 → Sanjay
```

The node is stored directly.

---

# Collision

Sometimes two different keys point to the same bucket.

Example

```text
101

↓

Bucket 5
```

```text
205

↓

Bucket 5
```

Both entries need to be stored inside the same bucket.

This situation is called a **Collision**.

---

# Collision Handling

Conceptually

```text
Bucket 5

↓

101 → Sanjay

↓

205 → Rahul

↓

309 → Priya
```

Java stores multiple nodes in the same bucket.

From Java 8 onwards, if many nodes are stored in the same bucket, Java converts them into a **Red-Black Tree** to improve search performance.

---

# Treeification (Java 8)

If too many collisions occur in a bucket,

Java changes

```text
Node

↓

Node

↓

Node

↓

Node
```

into

```text
           Node

          /    \

      Node      Node

      /           \

   Node          Node
```

Benefits

* Faster searching
* Better worst-case performance

---

# Resize

A HashMap automatically increases its capacity when it becomes sufficiently full.

Default values

```text
Capacity = 16

Load Factor = 0.75
```

Threshold

```text
16 × 0.75

=

12
```

When the **13th element** is inserted,

the capacity becomes

```text
32
```

---

# Rehashing

After resizing,

all existing entries are redistributed into the new bucket array.

```text
Old Buckets

↓

Resize

↓

New Buckets

↓

Recalculate Bucket Positions
```

This process is called **Rehashing**.

---

# Search Process

Suppose

```java
map.get(205);
```

Java performs

```text
Key

↓

hashCode()

↓

Bucket Index

↓

Locate Bucket

↓

Compare Keys

↓

Return Value
```

Only the required bucket is searched.

This makes searching very fast.

---

# Insertion Workflow

```text
put(key, value)

        │

        ▼

Generate Hash Code

        │

        ▼

Calculate Bucket Index

        │

        ▼

Bucket Empty?

    ┌────┴────┐

   Yes        No

    │          │

    ▼          ▼

 Store      Collision

 Entry      Handling

        │

        ▼

Map Updated
```

---

# Search Workflow

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

# Performance

| Operation | Average | Worst Case |
| --------- | ------- | ---------- |
| Insert    | O(1)    | O(n)       |
| Search    | O(1)    | O(n)       |
| Delete    | O(1)    | O(n)       |

> Since Java 8, heavy collisions are handled using Red-Black Trees, improving worst-case performance in those buckets.

---

# Best Practices

* Use immutable objects as keys.
* Override both `equals()` and `hashCode()` for custom key classes.
* Specify an initial capacity if you know the approximate number of entries.
* Avoid poor hash functions that cause excessive collisions.

---

# Interview Questions

1. How does HashMap store data internally?
2. What is a bucket?
3. What is a Node?
4. What is hashing?
5. What is a hash collision?
6. How does HashMap handle collisions?
7. What is treeification?
8. What is rehashing?
9. Why does HashMap resize?
10. Why should `equals()` and `hashCode()` be overridden together?

---

# Key Takeaways

* HashMap stores data inside a bucket array.
* Every entry is stored as a Node containing the hash, key, value, and a reference to the next node.
* Hashing determines the bucket where an entry is stored.
* Multiple entries in the same bucket create a collision.
* Java 8 uses Red-Black Trees when collisions become excessive.
* HashMap automatically resizes and rehashes entries when the load factor threshold is exceeded.

---

# Conclusion

The excellent performance of `HashMap` comes from its internal use of hashing, buckets, and efficient collision handling. By understanding concepts such as bucket indexing, node storage, treeification, and rehashing, you gain a deeper understanding of why `HashMap` is one of the most widely used data structures in Java. This knowledge is especially valuable for interviews and for writing high-performance Java applications.
