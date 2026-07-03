# Collections Framework in Java (Part 2)

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

In **Part 1**, we learned:

- What is a Collection?
- What is the Collection Framework?
- Why Arrays are not enough?
- Iterable Interface
- Collection Interface
- Common Collection Methods

In this chapter, we will learn the complete **Collection Framework Hierarchy** and understand the purpose of each interface before learning individual collection classes.

---

# Complete Collection Framework Hierarchy

```
                          Iterable
                              │
                              ▼
                        Collection
          ┌─────────────┼─────────────┐
          ▼             ▼             ▼
        List          Queue          Set
          │             │             │
          ▼             ▼             ▼
   ArrayList     PriorityQueue      HashSet
   LinkedList    ArrayDeque         LinkedHashSet
   Vector                           TreeSet
   Stack

                  Map (Separate Hierarchy)
                      │
          ┌───────────┼────────────┐
          ▼           ▼            ▼
      HashMap   LinkedHashMap   TreeMap
```

---

# Understanding the Hierarchy

The Collection Framework is divided into two major parts.

```
Collection

and

Map
```

The **Collection** interface stores individual objects.

The **Map** interface stores data in **Key-Value pairs**.

Example

```
Collection

↓

Apple

Banana

Orange
```

```
Map

↓

101 → Rahul

102 → Arun

103 → Priya
```

---

# Collection Interface

The Collection interface is the **root interface** of almost every collection.

It defines the basic operations for storing and manipulating objects.

```
Collection

│

├── List

├── Queue

└── Set
```

---

# List Interface

## Definition

The **List** interface stores data in an **ordered sequence**.

It allows:

- Duplicate elements
- Null values
- Index-based access

---

## Characteristics

- Ordered
- Duplicate values allowed
- Multiple null values allowed
- Index starts from 0

---

## Real-World Example

Think of a classroom attendance register.

```
1 Rahul

2 Arun

3 Priya

4 Kavin
```

The order is important.

---

## Example Program

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Apple");
        list.add("Banana");
        list.add("Apple");

        System.out.println(list);

    }

}
```

---

## Output

```
[Apple, Banana, Apple]
```

Duplicates are allowed.

---

# Queue Interface

## Definition

A Queue stores elements using the **FIFO (First In First Out)** principle.

```
First Enter

↓

First Exit
```

---

## Real-World Example

Standing in a ticket counter queue.

```
Rahul

↓

Arun

↓

Priya

↓

Counter
```

Rahul entered first,

so Rahul leaves first.

---

## Queue Diagram

```
Front

↓

10

20

30

40

↑

Rear
```

---

## Example Program

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);

        queue.offer(20);

        queue.offer(30);

        System.out.println(queue);

    }

}
```

---

## Output

```
[10, 20, 30]
```

---

# Deque Interface

## Definition

Deque stands for

```
Double Ended Queue
```

Insertion and deletion can happen from both ends.

---

## Diagram

```
Front

↓

10

20

30

↑

Rear
```

Both

```
Front

and

Rear
```

can insert and remove elements.

---

## Example Program

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(10);

        deque.addLast(20);

        deque.addFirst(5);

        System.out.println(deque);

    }

}
```

---

## Output

```
[5, 10, 20]
```

---

# Set Interface

## Definition

A Set stores **unique elements**.

Duplicate values are not allowed.

---

## Characteristics

- No duplicates
- At most one null value (depends on implementation)
- No index

---

## Real-World Example

Student Roll Numbers.

```
101

102

103

104
```

Each roll number must be unique.

---

## Example Program

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("Java");

        set.add("Python");

        set.add("Java");

        System.out.println(set);

    }

}
```

---

## Output

```
[Java, Python]
```

Duplicate value is ignored.

---

# SortedSet Interface

## Definition

SortedSet stores elements in **sorted order**.

It is implemented by **TreeSet**.

---

## Example

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        SortedSet<Integer> numbers = new TreeSet<>();

        numbers.add(40);

        numbers.add(10);

        numbers.add(30);

        numbers.add(20);

        System.out.println(numbers);

    }

}
```

---

## Output

```
[10, 20, 30, 40]
```

Automatically sorted.

---

# NavigableSet

NavigableSet extends SortedSet.

It provides methods like

```
higher()

lower()

ceiling()

floor()
```

These methods help navigate through sorted elements.

---

# Map Interface

Unlike List, Queue, and Set,

Map is **not** part of the Collection interface.

```
Collection

↓

Stores Objects

-----------------

Map

↓

Stores

Key → Value
```

---

## Example

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer,String> students = new HashMap<>();

        students.put(101,"Rahul");

        students.put(102,"Arun");

        students.put(103,"Priya");

        System.out.println(students);

    }

}
```

---

## Output

```
{101=Rahul, 102=Arun, 103=Priya}
```

---

# Why Map is Separate?

Collection stores

```
Object
```

Map stores

```
Key

↓

Value
```

Therefore,

Java keeps it in a separate hierarchy.

---

# Collection Hierarchy Summary

```
Collection

│

├── List

│      │

│      ├── ArrayList

│      ├── LinkedList

│      ├── Vector

│      └── Stack

│

├── Queue

│      │

│      ├── PriorityQueue

│      └── ArrayDeque

│

└── Set

       │

       ├── HashSet

       ├── LinkedHashSet

       └── TreeSet

----------------------------

Map

│

├── HashMap

├── LinkedHashMap

└── TreeMap
```

---

# Comparison Table

| Feature | List | Queue | Set | Map |
|----------|------|--------|-----|-----|
| Ordered | ✅ Yes | ✅ Yes | Depends | Depends |
| Duplicate Elements | ✅ Yes | ✅ Yes | ❌ No | Keys ❌, Values ✅ |
| Index Based | ✅ Yes | ❌ No | ❌ No | ❌ No |
| Null Allowed | ✅ Yes | Depends | Depends | Depends |
| Main Purpose | Store Ordered Data | FIFO Processing | Store Unique Data | Store Key-Value Pairs |

---

# When to Use Which?

## Use List

When order matters.

Examples:

- Student List
- Product List
- Shopping Cart

---

## Use Queue

When FIFO processing is needed.

Examples:

- Printer Queue
- Ticket Booking
- Task Scheduling

---

## Use Set

When duplicate values should not exist.

Examples:

- Email IDs
- Roll Numbers
- Usernames

---

## Use Map

When data must be stored as

```
Key

↓

Value
```

Examples:

- Employee ID → Name
- Product ID → Price
- Roll Number → Student Name

---

# Best Practices

- Choose the correct collection based on the requirement.
- Prefer interfaces (`List`, `Set`, `Queue`, `Map`) instead of concrete classes in variable declarations.
- Use Generics for type safety.
- Avoid unnecessary duplicate data.
- Use `TreeSet` or `TreeMap` when sorting is required.

---

# Common Mistakes

❌ Using List when uniqueness is required.

❌ Using Set when insertion order is important.

❌ Using Queue when random access is needed.

❌ Confusing Map with Collection.

---

# Interview Questions

### Beginner

1. What is the Collection Framework?
2. What is the Collection interface?
3. Why is Map not part of Collection?
4. Difference between List and Set?

### Intermediate

5. Difference between Queue and Deque?
6. Difference between HashSet and TreeSet?
7. Difference between ArrayList and LinkedList?
8. Explain the Collection hierarchy.

### Advanced

9. Why was the Collection Framework introduced?
10. Explain the architecture of the Collection Framework.
11. When would you use List over Set?
12. Why does Map have a separate hierarchy?

---

# Concept Map

```
                Java Collection Framework

                        │

        ┌───────────────┴───────────────┐

        ▼                               ▼

   Collection                          Map

        │

 ┌──────┼─────────┐

 ▼      ▼         ▼

List   Queue     Set

 │       │         │

 ▼       ▼         ▼

ArrayList PriorityQueue HashSet

LinkedList ArrayDeque   LinkedHashSet

Vector                 TreeSet

Stack
```

---

# Summary

In this chapter, you learned:

- The complete Collection Framework hierarchy.
- The purpose of List, Queue, Deque, Set, and Map.
- The characteristics of each interface.
- Basic programs using different interfaces.
- Comparison between different collection types.
- Best practices and common interview questions.

This completes the **Introduction to the Java Collection Framework**. In the next chapter, we will begin with the **List Interface** and then explore **ArrayList**, **LinkedList**, **Vector**, and **Stack** in detail.
