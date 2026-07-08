# ArrayList in Java 

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

One of the most commonly used classes in the Java Collection Framework is **ArrayList**.

Whenever we need to store multiple objects that can grow or shrink dynamically, **ArrayList** is the preferred choice.

Unlike arrays, an ArrayList **does not have a fixed size**. It automatically increases its capacity whenever new elements are added.

Because of its flexibility, ArrayList is widely used in Java applications such as:

- Student Management System
- Employee Management System
- E-Commerce Applications
- Banking Applications
- Hospital Management Systems
- Online Shopping Cart
- Library Management System

---

# Learning Objectives

After completing this chapter, you will understand:

- What is ArrayList?
- Why do we need ArrayList?
- Features of ArrayList
- Characteristics
- Internal Working
- Constructors
- Creating an ArrayList
- Generic ArrayList
- Basic Operations
- Array vs ArrayList

---

# Problem Statement

Suppose we are developing a Student Management System.

Initially,

```
Student 1

Student 2

Student 3
```

are stored in an array.

```java
String students[] = new String[3];
```

After some time,

a new student joins.

```
Student 4
```

But the array is already full.

```
+---------+---------+---------+

Student1 Student2 Student3

+---------+---------+---------+

Capacity = 3

Need to Add

Student4

❌ Cannot Add
```

Now we have to

- Create a new array
- Copy old data
- Insert the new value

This process is inefficient.

---

# Solution

Java provides

```
ArrayList
```

which automatically increases its size.

```
ArrayList

↓

Add Elements

↓

Automatically Grows

↓

No Need to Create New Array
```

---

# Real-World Analogy

Imagine a classroom.

### Array

A classroom has exactly **30 chairs**.

```
30 Chairs

↓

31st Student

↓

Cannot Sit
```

A bigger classroom is required.

---

### ArrayList

Imagine a smart classroom.

Whenever a new student arrives,

new chairs are automatically added.

```
30 Chairs

↓

31st Student

↓

New Chair Added Automatically
```

This is exactly how **ArrayList** behaves.

---

# What is ArrayList?

An **ArrayList** is a class available in the Java Collection Framework.

It stores data dynamically.

Unlike arrays,

its size automatically increases whenever needed.

---

# Definition

> **ArrayList** is a resizable array implementation of the **List** interface that stores objects in insertion order and allows duplicate elements.

---

# Package

```java
import java.util.ArrayList;
```

---

# Hierarchy of ArrayList

```
              Iterable

                  │

                  ▼

             Collection

                  │

                  ▼

                 List

                  │

                  ▼

             ArrayList
```

---

# Why Do We Need ArrayList?

Arrays have many limitations.

- Fixed size
- Difficult insertion
- Difficult deletion

ArrayList solves these problems.

Advantages include:

- Dynamic Size
- Easy Insertion
- Easy Deletion
- Built-in Methods
- Easy Traversal

---

# Features of ArrayList

## 1. Dynamic Size

ArrayList automatically grows whenever needed.

---

## 2. Ordered Collection

Elements are stored in insertion order.

Example

```
10

20

30
```

Output

```
10

20

30
```

---

## 3. Allows Duplicate Elements

Example

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");

list.add("Java");
```

Output

```
Java

Java
```

Duplicates are allowed.

---

## 4. Allows Null Values

Example

```java
ArrayList<String> list = new ArrayList<>();

list.add(null);

list.add("Java");
```

Output

```
null

Java
```

---

## 5. Index-Based Access

Every element has an index.

```
Index

0

1

2

3
```

Example

```
Apple

Banana

Orange

Mango
```

---

# Characteristics

- Dynamic
- Ordered
- Duplicate values allowed
- Null values allowed
- Fast random access
- Stores objects only

---

# Array vs ArrayList

| Array | ArrayList |
|--------|-----------|
| Fixed Size | Dynamic Size |
| Stores Primitive & Objects | Stores Objects |
| No Built-in Methods | Many Built-in Methods |
| Difficult Insertion | Easy Insertion |
| Difficult Deletion | Easy Deletion |
| Length Property | size() Method |

---

# Internal Working

Internally,

ArrayList uses an array.

```
ArrayList

        │

        ▼

Internal Array

+----+----+----+----+

10

20

30

40

+----+----+----+----+
```

When the array becomes full,

Java creates a larger array.

---

# Dynamic Growth

```
Capacity = 10

↓

11th Element Added

↓

Create Bigger Array

↓

Copy Old Elements

↓

Add New Element
```

This happens automatically.

---

# Constructors

## Constructor 1

Creates an empty ArrayList.

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

## Constructor 2

Creates an ArrayList with initial capacity.

```java
ArrayList<Integer> list = new ArrayList<>(20);
```

Capacity becomes

```
20
```

---

## Constructor 3

Creates an ArrayList from another collection.

```java
ArrayList<String> newList = new ArrayList<>(oldList);
```

---

# Generic ArrayList

Generics make collections type-safe.

Example

```java
ArrayList<String> names = new ArrayList<>();
```

Only

```
String
```

objects can be stored.

---

# Why Generics?

Wrong

```java
ArrayList list = new ArrayList();

list.add("Java");

list.add(10);
```

Different data types are stored.

Correct

```java
ArrayList<String> list = new ArrayList<>();
```

Only Strings are allowed.

---

# First ArrayList Program

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");

        fruits.add("Banana");

        fruits.add("Orange");

        System.out.println(fruits);

    }

}
```

---

# Output

```
[Apple, Banana, Orange]
```

---

# Program Explanation

### Step 1

Import

```java
import java.util.ArrayList;
```

Imports the ArrayList class.

---

### Step 2

Create an ArrayList.

```java
ArrayList<String> fruits = new ArrayList<>();
```

Initially,

```
Empty List
```

---

### Step 3

Insert elements.

```java
fruits.add("Apple");
```

Stores

```
Apple
```

Similarly,

```java
fruits.add("Banana");
fruits.add("Orange");
```

store the remaining elements.

---

### Step 4

Print the list.

```java
System.out.println(fruits);
```

Displays

```
[Apple, Banana, Orange]
```

---

# Memory Representation

```
Stack Memory

+----------------------+
| fruits               |
+----------|-----------+
           |
           ▼

Heap Memory

+---------------------------+
| ArrayList Object          |
|---------------------------|
| Apple                     |
| Banana                    |
| Orange                    |
+---------------------------+
```

---

# Program Flow

```
Start

   │

   ▼

Create ArrayList

   │

   ▼

Add Apple

   │

   ▼

Add Banana

   │

   ▼

Add Orange

   │

   ▼

Print List

   │

   ▼

End
```

---

# Real-World Applications

ArrayList is used in:

- Student Management Systems
- Banking Applications
- Online Shopping Cart
- Product Catalog
- Employee Management
- Hospital Records
- Movie Booking Systems
- Contact Management

---

# Common Mistakes

## Mistake 1

Forgetting to import ArrayList.

```java
ArrayList<String> list;
```

Without

```java
import java.util.ArrayList;
```

Compilation Error occurs.

---

## Mistake 2

Using primitive data types.

Wrong

```java
ArrayList<int> list;
```

Correct

```java
ArrayList<Integer> list;
```

---

## Mistake 3

Using raw types.

Wrong

```java
ArrayList list = new ArrayList();
```

Correct

```java
ArrayList<String> list = new ArrayList<>();
```

---

# Best Practices

- Always use Generics.
- Use meaningful variable names.
- Prefer the `List` interface when declaring variables.

Example

```java
List<String> list = new ArrayList<>();
```

instead of

```java
ArrayList<String> list = new ArrayList<>();
```

---

# Key Takeaways

- ArrayList is a dynamic array.
- It implements the List interface.
- It maintains insertion order.
- Duplicate values are allowed.
- Null values are allowed.
- It stores objects, not primitive data types.
- It automatically increases its capacity.

---

# What's Next?

In **02_ArraList**, we will cover:

- add()
- add(index, element)
- get()
- set()
- size()
- contains()
- isEmpty()
- indexOf()
- lastIndexOf()
- Multiple Example Programs
- Internal Working
- Time Complexity
- Memory Diagrams
- Interview Questions
