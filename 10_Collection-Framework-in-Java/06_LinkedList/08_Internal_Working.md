# Internal Working of LinkedList in Java

## Introduction

Understanding how a `LinkedList` works internally is very important for every Java programmer.

Most developers know how to use methods like `add()`, `remove()`, and `get()`, but very few understand what actually happens inside the JVM when these methods are executed.

A good understanding of the internal working helps you:

* Choose the correct data structure.
* Write efficient programs.
* Improve performance.
* Crack Java interviews.
* Debug programs more effectively.

This chapter explains the internal implementation of Java's `LinkedList` in a simple and beginner-friendly manner.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand how Java stores LinkedList elements.
* Learn the internal node structure.
* Understand how nodes are connected.
* Learn the role of Head and Tail references.
* Understand memory representation.
* Visualize how the first node is created.

---

# Problem Statement

Suppose you are developing a **Music Playlist Application**.

Songs are continuously added and removed.

Questions that may arise include:

* Where are the songs stored?
* How are the songs connected?
* How does Java know which song comes next?
* Why doesn't LinkedList shift elements like an ArrayList?

To answer these questions, we must understand the internal working of LinkedList.

---

# Why Do We Need to Know the Internal Working?

Many beginners learn only the syntax.

Example:

```java
LinkedList<String> names = new LinkedList<>();

names.add("Ram");
names.add("Sam");
```

The above code works correctly.

But internally Java performs many operations such as:

* Creating nodes.
* Allocating memory.
* Connecting nodes.
* Updating references.
* Maintaining the list size.

Knowing these operations helps you understand why LinkedList behaves differently from an ArrayList.

---

# How Java Implements LinkedList

Java's `LinkedList` is implemented as a **Doubly Linked List**.

Each element is stored inside a **Node**.

Every node contains three fields:

1. Previous Node Reference
2. Data
3. Next Node Reference

Conceptually, the internal node class looks like this:

```java
private static class Node<E> {

    E item;

    Node<E> next;

    Node<E> prev;

}
```

> **Note:** The actual implementation inside the Java Development Kit (JDK) contains additional details, but the above structure represents the core idea.

---

# Why Does Java Use a Doubly Linked List?

A **Singly Linked List** stores only the reference to the next node.

```text
10 → 20 → 30 → 40
```

A **Doubly Linked List** stores both previous and next references.

```text
null ← 10 ⇄ 20 ⇄ 30 ⇄ 40 → null
```

Because every node knows both its previous and next nodes:

* Forward traversal becomes easy.
* Backward traversal becomes possible.
* Insertion becomes efficient.
* Deletion becomes efficient.

This is why Java uses a **Doubly Linked List** instead of a Singly Linked List.

---

# Structure of a Node

Every node contains three parts.

```text
+--------------------------------------+
| Previous | Data | Next |
+--------------------------------------+
```

Example

```text
+---------------------------+
|  null | Java |  Node2 |
+---------------------------+
```

Another node

```text
+-----------------------------+
| Node1 | Python | Node3 |
+-----------------------------+
```

Last node

```text
+--------------------------+
| Node2 | C++ | null |
+--------------------------+
```

---

# Visual Representation of a Doubly Linked List

Suppose the LinkedList contains

```text
Java
Python
C++
JavaScript
```

Internally it looks like this.

```text
null
  │
  ▼

+---------+---------+---------+
| Prev    | Java    | Next ---+----------------------+
+---------+---------+---------+                      |
                                                     ▼
                                          +---------+-----------+---------+
                                          | Prev <--+ Python    | Next ---+------------+
                                          +---------+-----------+---------+            |
                                                                                       ▼
                                                                          +---------+-------+---------+
                                                                          | Prev <--+ C++   | Next ---+----------+
                                                                          +---------+-------+---------+          |
                                                                                                                 ▼
                                                                                                  +---------+-------------+------+
                                                                                                  | Prev <--+ JavaScript | null |
                                                                                                  +---------+-------------+------+
```

---

# Head and Tail References

A LinkedList maintains two important references.

* **Head** → Points to the first node.
* **Tail** → Points to the last node.

Example

```text
Head

 │

 ▼

Java ⇄ Python ⇄ C++ ⇄ JavaScript

                            ▲

                            │

                          Tail
```

These references help Java quickly access the first and last elements.

---

# Memory Representation

Unlike arrays, LinkedList nodes are **not stored in consecutive memory locations**.

Example

```text
Address 900

+------------------------------+
| Prev : null                  |
| Data : Java                  |
| Next : Address 250           |
+------------------------------+

Address 250

+------------------------------+
| Prev : Address 900           |
| Data : Python                |
| Next : Address 700           |
+------------------------------+

Address 700

+------------------------------+
| Prev : Address 250           |
| Data : C++                   |
| Next : null                  |
+------------------------------+
```

Although the addresses are different, the nodes remain connected through references.

---

# Creating the First Node

Initially

```java
LinkedList<String> languages = new LinkedList<>();
```

The LinkedList is empty.

```text
Head → null

Tail → null

Size = 0
```

---

Now execute

```java
languages.add("Java");
```

Java creates a new node.

```text
+---------------------------+
| Prev | Java | Next |
+---------------------------+
```

Since this is the first node,

* Previous = `null`
* Next = `null`

---

The LinkedList becomes

```text
Head

 │

 ▼

+---------------------------+
| null | Java | null |
+---------------------------+

 ▲
 │

Tail
```

Both **Head** and **Tail** point to the same node because only one node exists.

---

# Adding the Second Node

Now execute

```java
languages.add("Python");
```

A second node is created.

```text
Head

 │

 ▼

+-----------------------------+
| null | Java | Node2 |
+-----------------------------+

               ⇅

+-------------------------------+
| Node1 | Python | null |
+-------------------------------+

                           ▲

                           │

                         Tail
```

Java performs the following operations internally:

1. Creates a new node.
2. Sets the previous reference of the new node.
3. Updates the next reference of the old tail.
4. Moves the Tail reference to the new node.
5. Increases the size of the LinkedList.

---

# Internal State After Adding Two Nodes

| Property | Value  |
| -------- | ------ |
| Head     | Java   |
| Tail     | Python |
| Size     | 2      |

---

# ASCII Diagram

```text
Head

 │

 ▼

null ← Java ⇄ Python → null

                ▲

                │

              Tail
```

---

# Important Points

* Every element is stored inside a node.
* Every node has three fields.
* Nodes are connected using references.
* Head always points to the first node.
* Tail always points to the last node.
* Nodes may be stored anywhere in memory.
* Java internally maintains the size of the LinkedList.
* Java's LinkedList implementation is based on a Doubly Linked List.
# Adding Nodes Internally

Whenever a new element is inserted into a LinkedList, Java creates a **new node** and connects it with the existing nodes by updating their references.

Internally, the JDK uses helper methods (conceptually) such as:

* `linkFirst(E e)`
* `linkLast(E e)`
* `linkBefore(E e, Node<E> successor)`

These methods are part of Java's internal implementation and are **not called directly by programmers**. They help the LinkedList maintain the correct connections between nodes.

---

# Adding a Node at the Beginning

Suppose the LinkedList contains:

```text
Head

 │

 ▼

null ← Java ⇄ Python ⇄ C++ → null

                           ▲
                           │
                         Tail
```

Now execute

```java
list.addFirst("C");
```

A new node is created.

```text
null ← C ⇄ Java ⇄ Python ⇄ C++ → null
```

### Internal Steps

1. Create a new node.
2. Set its `next` reference to the current head.
3. Set its `previous` reference to `null`.
4. Update the old head's `previous` reference.
5. Move the `head` reference to the new node.
6. Increase the size of the LinkedList.

---

# Adding a Node at the End

Current LinkedList

```text
Java ⇄ Python ⇄ C++
```

Execute

```java
list.addLast("JavaScript");
```

Result

```text
Java ⇄ Python ⇄ C++ ⇄ JavaScript
```

### Internal Steps

1. Create a new node.
2. Set its `previous` reference to the current tail.
3. Set its `next` reference to `null`.
4. Update the current tail's `next` reference.
5. Move the `tail` reference to the new node.
6. Increase the LinkedList size.

---

# Adding a Node in the Middle

Current LinkedList

```text
Java ⇄ C++ ⇄ Python
```

Execute

```java
list.add(1, "HTML");
```

Before

```text
Java ⇄ C++ ⇄ Python
```

After

```text
Java ⇄ HTML ⇄ C++ ⇄ Python
```

### Internal Steps

1. Traverse to the required position.
2. Create a new node.
3. Connect the new node to its previous node.
4. Connect the new node to its next node.
5. Update neighboring node references.
6. Increase the LinkedList size.

---

# Removing Nodes Internally

When a node is removed, Java does **not shift** the remaining elements.

Instead, it updates the references of the neighboring nodes.

Internally, Java uses a helper method similar to:

```text
unlink(Node<E> node)
```

---

## Removing the First Node

Before

```text
Head

 │

 ▼

Java ⇄ Python ⇄ C++
```

Execute

```java
list.removeFirst();
```

After

```text
Head

 │

 ▼

Python ⇄ C++
```

### Internal Steps

1. Store the second node.
2. Remove the first node's references.
3. Make the second node the new head.
4. Set the new head's `previous` reference to `null`.
5. Decrease the LinkedList size.

---

## Removing the Last Node

Before

```text
Java ⇄ Python ⇄ C++
```

Execute

```java
list.removeLast();
```

After

```text
Java ⇄ Python
```

### Internal Steps

1. Store the second-last node.
2. Disconnect the last node.
3. Make the second-last node the new tail.
4. Set its `next` reference to `null`.
5. Decrease the LinkedList size.

---

## Removing a Middle Node

Before

```text
Java ⇄ HTML ⇄ Python ⇄ C++
```

Remove

```text
Python
```

After

```text
Java ⇄ HTML ⇄ C++
```

Only the neighboring nodes are reconnected.

No other nodes are moved.

---

# Traversing the LinkedList

Traversal means visiting every node one by one.

Example

```text
Java ⇄ Python ⇄ C++ ⇄ HTML
```

Traversal order

```text
Java

↓

Python

↓

C++

↓

HTML
```

Java follows the `next` reference until it reaches the last node.

---

# How `get(index)` Works

Suppose the LinkedList is

```text
Index

0  1   2   3

A  B   C   D
```

Execute

```java
list.get(2);
```

Java traverses the nodes until index **2** is reached.

```text
Head

 │

 ▼

A

↓

B

↓

C  ← Found

↓

D
```

Unlike an ArrayList, LinkedList cannot directly access an element by index.

---

# Time Complexity Analysis

| Operation       | Time Complexity |
| --------------- | --------------- |
| `addFirst()`    | O(1)            |
| `addLast()`     | O(1)            |
| `add(index)`    | O(n)            |
| `removeFirst()` | O(1)            |
| `removeLast()`  | O(1)            |
| `remove(index)` | O(n)            |
| `get(index)`    | O(n)            |
| `contains()`    | O(n)            |
| Iteration       | O(n)            |

---

# Why Is `get(index)` Slower?

Suppose the LinkedList contains 1000 nodes.

To access

```java
list.get(700);
```

Java must traverse hundreds of nodes before reaching index **700**.

This is why random access is slower than in an ArrayList.

---

# Memory Usage

Each node stores:

* Previous reference
* Actual data
* Next reference

Example

```text
+--------------------------------+
| Previous | Data | Next |
+--------------------------------+
```

Compared to an ArrayList, LinkedList uses more memory because every node stores two additional references.

---

# Internal Algorithm (Simplified)

```text
Create LinkedList

       │

       ▼

Create Node

       │

       ▼

Connect Previous Reference

       │

       ▼

Connect Next Reference

       │

       ▼

Update Head or Tail (if required)

       │

       ▼

Increase or Decrease Size

       │

       ▼

Operation Completed
```

---

# Program Flow

```text
Start

   │

   ▼

Create LinkedList

   │

   ▼

Perform Operation

   │

   ▼

Create / Remove Node

   │

   ▼

Update References

   │

   ▼

Update Head/Tail

   │

   ▼

Update Size

   │

   ▼

Finish
```

---

# LinkedList vs ArrayList (Internal Working)

| Feature                | LinkedList         | ArrayList     |
| ---------------------- | ------------------ | ------------- |
| Internal Structure     | Doubly Linked List | Dynamic Array |
| Memory Layout          | Non-contiguous     | Contiguous    |
| Random Access          | Slow               | Fast          |
| Insertion at Beginning | Fast               | Slow          |
| Deletion at Beginning  | Fast               | Slow          |
| Memory Usage           | Higher             | Lower         |
| Element Shifting       | Not Required       | Required      |

---

# Common Mistakes

## Assuming Elements Are Stored Continuously

Incorrect:

```text
10 20 30 40
```

Correct:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Each element is stored in a separate node connected through references.

---

## Using `get(index)` Frequently

```java
for (int i = 0; i < list.size(); i++) {

    System.out.println(list.get(i));

}
```

This repeatedly traverses the LinkedList and becomes inefficient for large datasets.

---

## Thinking Nodes Are Shifted

When an element is removed, LinkedList only updates references.

No shifting occurs.

---

# Best Practices

* Use LinkedList when insertions and deletions are frequent.
* Avoid repeated index-based access.
* Prefer `Iterator` or enhanced `for` loop for traversal.
* Choose ArrayList when fast random access is required.
* Understand the internal implementation before selecting a collection.

---

# Interview Questions

1. Why is Java's LinkedList implemented as a Doubly Linked List?
2. What fields are stored inside each node?
3. What is the purpose of the `head` reference?
4. What is the purpose of the `tail` reference?
5. Why doesn't LinkedList shift elements during insertion?
6. How does Java insert a node in the middle?
7. Why is `get(index)` slower than in an ArrayList?
8. Why does LinkedList consume more memory?
9. Explain the internal working of `removeFirst()`.
10. When should LinkedList be preferred over ArrayList?

---

# Practice Programs

1. Draw the node structure of a LinkedList.
2. Explain how `addFirst()` works internally.
3. Explain how `removeLast()` works internally.
4. Compare LinkedList and ArrayList using a table.
5. Create a program to demonstrate node insertion.
6. Create a program to demonstrate node deletion.
7. Traverse a LinkedList using an `Iterator`.
8. Measure the performance of `get(index)` on a large LinkedList.
9. Build a simple playlist using LinkedList.
10. Explain the complete lifecycle of a node using diagrams.

---

# Key Takeaways

* Java implements LinkedList as a **Doubly Linked List**.
* Every node stores the previous reference, data, and next reference.
* `head` points to the first node, while `tail` points to the last node.
* Adding and removing elements involves updating references rather than shifting elements.
* Random access is slower because traversal is required.
* LinkedList uses more memory than ArrayList due to additional references.
* Understanding the internal working helps in selecting the right collection and writing efficient Java programs.

---

# Conclusion

The internal implementation of `LinkedList` is based on a **Doubly Linked List**, where each element is stored as an individual node connected through previous and next references. This design enables efficient insertions and deletions while sacrificing fast random access. Understanding how nodes are created, connected, traversed, and removed provides a deeper understanding of the Java Collection Framework and helps developers make informed decisions when choosing between `LinkedList` and other collection classes.
