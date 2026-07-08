# ArrayList in Java

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

In the previous chapters, we learned:

- Creating an ArrayList
- Constructors
- CRUD Operations
- Traversing
- Sorting
- Searching

In this chapter, we will understand **how ArrayList works internally**.

This is one of the most frequently asked interview topics.

---

# What Happens Internally?

Although we use

```java
ArrayList<String> list = new ArrayList<>();
```

internally,

Java creates an **array**.

```
ArrayList

        │

        ▼

Internal Object Array

+----+----+----+----+----+

NULL NULL NULL NULL NULL

+----+----+----+----+----+
```

ArrayList is actually a **dynamic array**.

---

# Internal Data Structure

The source code of ArrayList contains

```java
transient Object[] elementData;
```

This array stores all the elements.

Whenever we call

```java
add()
```

the element is stored inside

```
elementData[]
```

---

# Initial Capacity

There are two important concepts.

```
Capacity

and

Size
```

Many beginners confuse these terms.

---

# Capacity

Capacity means

> The total number of elements that can currently be stored.

Example

```
Capacity = 10
```

means

```
10 spaces available
```

---

# Size

Size means

> Number of elements actually stored.

Example

```
Capacity = 10

Size = 3
```

Diagram

```
+-----+-----+-----+------+-----+-----+-----+-----+-----+-----+

 A      B      C    NULL  NULL  NULL  NULL  NULL  NULL  NULL

+-----+-----+-----+------+-----+-----+-----+-----+-----+-----+

Capacity = 10

Size = 3
```

---

# Capacity vs Size

| Capacity | Size |
|-----------|------|
| Maximum storage | Current elements |
| Changes after resizing | Changes after add/remove |
| Internal array length | Number of stored objects |

---

# Default Capacity

```java
ArrayList<Integer> list = new ArrayList<>();
```

Initially

```
Size = 0
```

When the first element is inserted,

Java creates an internal array with capacity

```
10
```

---

# Example

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
```

Internal

```
Capacity

10

Size

1
```

---

# Dynamic Resizing

Suppose

Capacity

```
10
```

Current Size

```
10
```

Need to insert

```
11th Element
```

Java automatically creates a larger array.

---

# Growth Formula

From Java 8 onwards,

the new capacity is approximately

```
Old Capacity

+

Old Capacity / 2
```

Formula

```
New Capacity

=

Old Capacity × 1.5
```

---

# Example

Old Capacity

```
10
```

New Capacity

```
15
```

---

Again

```
15

↓

22

↓

33

↓

49

↓

73
```

Capacity keeps increasing automatically.

---

# Resizing Diagram

Before

```
Capacity = 10

+------------------------------------+

A B C D E F G H I J

+------------------------------------+
```

Need one more element

```
K
```

↓

Java creates

```
Capacity = 15
```

↓

Copies all elements

↓

Deletes old array

↓

Stores new element

After

```
+------------------------------------------------+

A B C D E F G H I J K NULL NULL NULL NULL

+------------------------------------------------+
```

---

# Internal Working of add()

Suppose

```java
list.add("Java");
```

Execution

```
add()

      │

      ▼

Check Capacity

      │

      ▼

Space Available?

      │

 ┌────┴────┐

 │         │

YES        NO

 │         │

 ▼         ▼

Store   Resize Array

 │         │

 └────┬────┘

      ▼

Increase Size
```

---

# Why get() is Fast?

Example

```java
list.get(5);
```

ArrayList directly calculates

```
Memory Address

=

Base Address

+

Index × Size
```

Therefore,

```
get()

O(1)
```

Very fast.

---

# Why remove() is Slow?

Example

```
A

B

C

D

E
```

Remove

```
B
```

Remaining elements must shift.

```
A

C

D

E
```

Shifting requires

```
O(n)
```

time.

---

# Why add(index) is Slow?

Example

```
A

B

D

E
```

Insert

```
C
```

at

```
Index 2
```

All remaining elements move one position.

```
A

B

C

D

E
```

Time Complexity

```
O(n)
```

---

# Time Complexity Table

| Operation | Complexity |
|------------|------------|
| add() | O(1) Average |
| add(index) | O(n) |
| get() | O(1) |
| set() | O(1) |
| contains() | O(n) |
| remove() | O(n) |
| indexOf() | O(n) |
| lastIndexOf() | O(n) |
| clear() | O(n) |

---

# ArrayList vs Array

| Array | ArrayList |
|--------|-----------|
| Fixed Size | Dynamic Size |
| Primitive + Objects | Objects Only |
| Faster | Slightly Slower |
| No Built-in Methods | Many Methods |
| Manual Resizing | Automatic Resizing |

---

# ArrayList vs LinkedList

| ArrayList | LinkedList |
|------------|------------|
| Uses Dynamic Array | Uses Doubly Linked List |
| Fast Random Access | Slow Random Access |
| Slow Insert/Delete | Fast Insert/Delete |
| Less Memory | More Memory |
| Better for Reading | Better for Frequent Modifications |

---

# ArrayList vs Vector

| ArrayList | Vector |
|------------|--------|
| Not Synchronized | Synchronized |
| Faster | Slower |
| Preferred Today | Legacy Class |
| Better Performance | Thread Safe |

---

# When Should We Use ArrayList?

Use ArrayList when

- Frequent reading
- Random access
- Less insertion/deletion
- Dynamic storage required

Examples

- Student List
- Product List
- Contact List
- Shopping Cart
- Movie List

---

# When Should We Avoid ArrayList?

Avoid when

- Frequent insertion
- Frequent deletion
- Thread safety required

Use

```
LinkedList

or

Vector
```

depending on the requirement.

---

# Real-World Applications

ArrayList is widely used in

- Banking Applications
- Hospital Management Systems
- Student Records
- E-Commerce Websites
- Employee Management
- Product Catalog
- Online Booking Systems
- Music Playlists
- Chat Applications

---

# Common Mistakes

### Mistake 1

Using

```java
ArrayList<int>
```

Wrong.

Correct

```java
ArrayList<Integer>
```

---

### Mistake 2

Ignoring

```
IndexOutOfBoundsException
```

Always check the index.

---

### Mistake 3

Using ArrayList for frequent insertions.

Better choice

```
LinkedList
```

---

# Best Practices

- Always use Generics.
- Prefer the `List` interface.

```java
List<String> list = new ArrayList<>();
```

- Use `ensureCapacity()` when the approximate size is known.
- Use `trimToSize()` to reduce memory usage.
- Avoid unnecessary resizing.

---

# Interview Questions

## Beginner

1. What is ArrayList?
2. Which package contains ArrayList?
3. Difference between Array and ArrayList?

---

## Intermediate

4. Difference between Capacity and Size?
5. Why is ArrayList dynamic?
6. Why is get() O(1)?
7. Why is remove() O(n)?

---

## Advanced

8. Explain internal working of ArrayList.
9. Explain dynamic resizing.
10. Explain growth formula.
11. Difference between ArrayList and LinkedList.
12. Difference between ArrayList and Vector.
13. Why is ArrayList not synchronized?
14. What happens when capacity becomes full?
15. Explain ArrayList memory representation.

---

# Practice Programs

## Easy

- Create an ArrayList of integers.
- Add 10 elements.
- Print all elements.

---

## Medium

- Remove duplicate elements.
- Find maximum and minimum.
- Reverse an ArrayList.

---

## Hard

- Implement a Student Management System using ArrayList.
- Create an Employee Database.
- Store Product Details using ArrayList.

---

# Concept Map

```
                    ArrayList

                        │

        ┌───────────────┼────────────────┐

        ▼               ▼                ▼

     Dynamic        Random Access      Resizing

        │               │                │

     Capacity        get() O(1)      1.5x Growth

        │

        ▼

     Internal Array

        │

        ▼

Automatic Memory Management
```

---

# Chapter Summary

In this chapter, you learned:

- Internal implementation of ArrayList
- Capacity vs Size
- Default Capacity
- Dynamic Resizing
- Growth Formula
- Time Complexity
- Internal Memory Representation
- ArrayList vs Array
- ArrayList vs LinkedList
- ArrayList vs Vector
- Best Practices
- Real-world Applications

---

# Final Key Takeaways

- **ArrayList** is implemented using a **dynamic array**.
- It automatically resizes when capacity is exceeded.
- **Capacity** and **Size** are different concepts.
- Random access (`get()`) is **O(1)**.
- Insertion and deletion in the middle are **O(n)**.
- ArrayList is best for applications with **frequent reads** and **less frequent modifications**.
- Understanding its internal working helps in choosing the right collection for different scenarios.

---

# Conclusion

ArrayList is one of the most powerful and widely used classes in the Java Collection Framework. It provides dynamic storage, fast random access, and a rich set of built-in methods, making it suitable for a wide range of applications. However, knowing its internal implementation, resizing mechanism, and performance characteristics is essential for writing efficient Java programs and performing well in technical interviews.
