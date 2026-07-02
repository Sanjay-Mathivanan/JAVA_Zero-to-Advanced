# Introduction to LinkedList in Java

## What is a LinkedList?

A **LinkedList** is a linear data structure provided by the Java Collection Framework that stores elements as a sequence of **nodes**. Unlike an ArrayList, the elements are **not stored in contiguous memory locations**. Instead, every node contains the actual data and a reference (link) to the next node.

This design allows LinkedList to insert and remove elements efficiently without shifting other elements.

Java provides the `LinkedList` class in the `java.util` package.

---

## Learning Objectives

After completing this topic, you will be able to:

* Understand what a LinkedList is.
* Learn how LinkedList stores data.
* Identify the main characteristics of LinkedList.
* Understand the advantages and limitations of LinkedList.
* Know when LinkedList should be used.
* Differentiate between LinkedList and normal arrays at a basic level.

---

## Problem Statement

Suppose you are maintaining a list of students. New students join frequently, and some students leave the course regularly.

If an array or an ArrayList is used, inserting or deleting students from the middle requires shifting many elements, which reduces performance.

A LinkedList solves this problem by connecting elements through links, allowing elements to be inserted or removed without shifting the remaining elements.

---

## Why Do We Need LinkedList?

Arrays and ArrayLists work well when elements are mostly accessed by their index.

However, in many real-world applications:

* Elements are frequently inserted.
* Elements are frequently removed.
* Data size changes dynamically.
* Memory does not need to be continuous.

Examples include:

* Music playlists
* Browser history
* Undo and Redo operations
* Train coaches
* Task scheduling
* Navigation systems

In such situations, LinkedList becomes a better choice.

---

## Definition

A **LinkedList** is a dynamic linear data structure where each element is stored inside a **node**.

Each node contains:

1. The actual data.
2. A reference to the next node.

Because nodes are connected using references, they can exist anywhere in memory.

---

## Real-Life Analogy

Imagine a treasure hunt.

Each clue tells you:

* The current location.
* The location of the next clue.

You cannot directly jump to the fifth clue.

Instead, you must follow the clues one by one.

A LinkedList works in exactly the same way.

---

## Key Characteristics

* Dynamic size.
* Maintains insertion order.
* Allows duplicate elements.
* Allows null values.
* Stores elements using nodes.
* Efficient insertion and deletion.
* Slower random access compared to ArrayList.

---

## Package

```java
import java.util.LinkedList;
```

---

## Basic Declaration

```java
LinkedList<String> names = new LinkedList<>();
```

---

## Internal Structure

Every node stores two things:

* Data
* Reference to the next node

```
+------+      +------+      +------+      +------+
| Ram  | ---> | Sam  | ---> | Tom  | ---> | John |
+------+      +------+      +------+      +------+
```

---

## Node Representation

Conceptually, a node looks like this:

```
-------------------------
| Data | Next Reference |
-------------------------
```

Example:

```
--------------------
| 25 | ----------+ |
-------------------- |
                     v
               --------------------
               | 40 | ----------+ |
               -------------------- |
                                    v
                              --------------------
                              | 60 |   null       |
                              --------------------
```

---

## Memory Representation

Unlike arrays, LinkedList nodes are not stored next to each other.

Example:

```
Memory

Address 500
+-------------+
| Data : A    |
| Next : 900  |
+-------------+

Address 900
+-------------+
| Data : B    |
| Next : 250  |
+-------------+

Address 250
+-------------+
| Data : C    |
| Next : null |
+-------------+
```

Even though the addresses are different, the nodes remain connected through references.

---

## How LinkedList Works

Suppose we insert the following values:

```
10
20
30
40
```

The structure becomes:

```
Head
 |
 v

+----+     +----+     +----+     +----+
|10  | --> |20  | --> |30  | --> |40  |
+----+     +----+     +----+     +----+
```

When a new element is inserted:

```
Insert 25

Before

10 -> 20 -> 30 -> 40

After

10 -> 20 -> 25 -> 30 -> 40
```

Only the links change.

The existing elements are not shifted.

---

## Advantages of LinkedList

* Dynamic memory allocation.
* Fast insertion.
* Fast deletion.
* No shifting of elements.
* Easy implementation of queues and stacks.
* Suitable for applications with frequent modifications.

---

## Limitations of LinkedList

* More memory usage because every node stores a reference.
* Slower searching.
* Random access is not supported efficiently.
* Traversal must start from the beginning.

---

## Common Applications

LinkedList is widely used in:

* Music playlist management
* Browser history
* Undo and Redo functionality
* Image viewer navigation
* Train reservation systems
* Task scheduling
* LRU Cache implementation
* Graph algorithms
* Queue implementation
* Stack implementation

---

## Program Flow

```
Create LinkedList

        |

Insert Nodes

        |

Nodes Connected Using References

        |

Traverse One by One

        |

Insert/Delete Whenever Required

        |

Display Elements
```

---

## LinkedList at a Glance

| Feature            | Description           |
| ------------------ | --------------------- |
| Package            | `java.util`           |
| Dynamic Size       | Yes                   |
| Duplicate Elements | Allowed               |
| Null Values        | Allowed               |
| Ordered            | Yes                   |
| Random Access      | Slow                  |
| Insert/Delete      | Fast                  |
| Memory Usage       | Higher than ArrayList |

---

## Common Mistakes

* Expecting LinkedList to provide fast index-based access.
* Using LinkedList when searching is the primary operation.
* Assuming nodes are stored continuously in memory.
* Forgetting that each node stores an additional reference.

---

## Best Practices

* Use LinkedList when insertions and deletions are frequent.
* Prefer ArrayList when frequent random access is required.
* Use Generics to maintain type safety.
* Choose the appropriate collection based on the application's requirements.

---

## Interview Questions

1. What is a LinkedList?
2. Why is LinkedList considered a dynamic data structure?
3. How are elements stored in a LinkedList?
4. What does each node contain?
5. Why is insertion faster in LinkedList?
6. Why is searching slower in LinkedList?
7. Can LinkedList store duplicate values?
8. Can LinkedList store null values?
9. Which package contains the LinkedList class?
10. Give some real-world applications of LinkedList.

---

## Key Takeaways

* LinkedList stores elements as interconnected nodes.
* Each node contains data and a reference to the next node.
* Elements are not stored in contiguous memory.
* Insertions and deletions are efficient.
* Searching and random access are slower than ArrayList.
* LinkedList is best suited for applications where data changes frequently.

---

## Conclusion

LinkedList is one of the most important data structures in the Java Collection Framework. It provides a flexible way to store and manage data by connecting elements through references instead of storing them in continuous memory. Understanding LinkedList is essential before learning advanced collections such as Doubly LinkedList concepts, Queue, Deque, Stack, and other linked data structures used in real-world software development.
