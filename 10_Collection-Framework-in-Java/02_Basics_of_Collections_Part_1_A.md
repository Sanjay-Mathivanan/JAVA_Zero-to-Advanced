# Basics of Collections in Java (Part 1 - A)

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

After learning about the **Collection Framework**, the next step is understanding how to perform basic operations on collections.

Java provides a special utility class called **Collections** that contains many ready-made methods to manipulate collection objects.

Using the `Collections` class, we can easily perform operations like:

- Sorting
- Searching
- Reversing
- Finding Maximum
- Finding Minimum
- Shuffling
- Swapping

Instead of writing our own algorithms, Java provides optimized methods.

---

# Learning Objectives

After completing this chapter, you will learn:

- What is the Collections Utility Class?
- Difference between Collection and Collections
- Sorting Collections
- Searching Collections
- Reverse Sorting
- Using Iterator
- Best Practices
- Real-world Applications

---

# Problem Statement

Suppose we have the marks of students.

```
23

3

2

1
```

We want to

- Sort the marks
- Search for a mark
- Print them in reverse order

Without the Collections class,

we need to write our own sorting and searching algorithms.

Java already provides these operations through the **Collections Utility Class**.

---

# Real-World Analogy

Imagine a librarian arranging books.

Without any tools,

the librarian has to manually

- arrange books
- search books
- organize books

This takes time.

Now imagine a smart machine that automatically

- sorts books
- searches books
- arranges books

The **Collections Utility Class** acts like this smart machine.

---

# What is the Collections Utility Class?

The **Collections** class belongs to the package

```java
java.util
```

It provides utility methods to perform operations on collection objects.

It is a **final utility class**, so we cannot create its object.

---

# Definition

> **Collections** is a utility class that provides static methods for performing operations such as sorting, searching, reversing, shuffling, and swapping on Collection objects.

---

# Collection vs Collections

Many beginners get confused between these two terms.

| Collection | Collections |
|------------|-------------|
| Interface | Utility Class |
| Stores a group of objects | Performs operations on collections |
| Parent interface of List, Queue, Set | Contains static methods |
| Example: List, Set | Example: sort(), reverse(), binarySearch() |

---

# Collections Class Methods

Some commonly used methods are:

| Method | Purpose |
|---------|----------|
| sort() | Sort elements |
| binarySearch() | Search an element |
| reverseOrder() | Reverse sorting |
| reverse() | Reverse elements |
| shuffle() | Random order |
| max() | Largest element |
| min() | Smallest element |
| swap() | Swap two elements |
| fill() | Replace all elements |
| frequency() | Count occurrences |

---

# Packages Required

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
```

---

# Classes Used

## List

Stores ordered elements.

```
10

20

30
```

---

## ArrayList

Dynamic implementation of List.

```
ArrayList

↓

Dynamic Size
```

---

## Collections

Provides utility methods.

```
sort()

search()

reverse()
```

---

## Iterator

Traverses elements one by one.

```
10

↓

20

↓

30
```

---

# Example Program (Your Program)

```java
package Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Demo {

    public static void main(String[] args) {

        List<Integer> newList = new ArrayList<>();

        newList.add(1);
        newList.add(3);
        newList.add(2);
        newList.add(23);

        Collections.sort(newList);

        Iterator<Integer> it = newList.iterator();

        while (it.hasNext()) {

            System.out.println("Array List Value : " + it.next());

        }

        int search = Collections.binarySearch(newList, 1);

        System.out.println("Element found at index : " + search);

        Collections.sort(newList, Collections.reverseOrder());

        Iterator<Integer> it1 = newList.iterator();

        while (it1.hasNext()) {

            System.out.println("Reverse Array Value : " + it1.next());

        }

    }

}
```

---

# Output

```
Array List Value : 1
Array List Value : 2
Array List Value : 3
Array List Value : 23

Element found at index : 0

Reverse Array Value : 23
Reverse Array Value : 3
Reverse Array Value : 2
Reverse Array Value : 1
```

---

# Program Explanation

## Step 1

Create a List.

```java
List<Integer> newList = new ArrayList<>();
```

A dynamic ArrayList object is created.

Initially

```
List

↓

Empty
```

---

## Step 2

Insert Elements

```java
newList.add(1);
newList.add(3);
newList.add(2);
newList.add(23);
```

Current List

```
+-----+-----+-----+------+
|  1  |  3  |  2  |  23  |
+-----+-----+-----+------+
```

---

## Step 3

Sort Elements

```java
Collections.sort(newList);
```

Java internally sorts the list in ascending order.

Result

```
+-----+-----+-----+------+
|  1  |  2  |  3  |  23  |
+-----+-----+-----+------+
```

---

# How sort() Works

```java
Collections.sort(newList);
```

This method arranges elements in **ascending order**.

Syntax

```java
Collections.sort(collectionName);
```

---

# Example 1

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(40);
numbers.add(20);
numbers.add(10);
numbers.add(30);

Collections.sort(numbers);

System.out.println(numbers);
```

### Output

```
[10, 20, 30, 40]
```

---

# Example 2 (Sorting Strings)

```java
ArrayList<String> fruits = new ArrayList<>();

fruits.add("Orange");
fruits.add("Apple");
fruits.add("Banana");

Collections.sort(fruits);

System.out.println(fruits);
```

### Output

```
[Apple, Banana, Orange]
```

---

# Why Sorting is Important?

Sorting helps in

- Faster searching
- Better display
- Easy data processing

Example

```
Marks

90

80

100

70
```

After Sorting

```
70

80

90

100
```

It becomes easier to analyze.

---

# Memory Representation

```
Stack Memory

+-----------------------+
| newList               |
+-----------|-----------+
            |
            ▼

Heap Memory

+-----------------------+
| ArrayList Object      |
|-----------------------|
| 1                     |
| 2                     |
| 3                     |
| 23                    |
+-----------------------+
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

Add Elements

   │

   ▼

Sort Elements

   │

   ▼

Print Elements

   │

   ▼

Continue...

(Searching and Reverse Sorting in Part 1-B)
```

---

# Common Mistakes

## Mistake 1

Using raw types.

Wrong

```java
List list = new ArrayList();
```

Correct

```java
List<Integer> list = new ArrayList<>();
```

---

## Mistake 2

Forgetting to import Collections.

```java
Collections.sort(list);
```

Without

```java
import java.util.Collections;
```

Compilation Error occurs.

---

# Best Practices

- Always use Generics.
- Prefer the `List` interface instead of the `ArrayList` class for variable declarations.
- Keep collection elements of the same type.
- Sort only when required because sorting has a time cost.

---

# Key Takeaways

- `Collections` is a utility class.
- It contains only static methods.
- `sort()` arranges elements in ascending order.
- Collections work with objects, not primitive data types.
- Using Generics improves type safety.

---

# What's Next?

In **Part 1-B**, we will learn:

- Iterator
- hasNext()
- next()
- binarySearch()
- reverseOrder()
- Descending Sorting
- More Example Programs
- Internal Working
- Time Complexity
- Interview Questions
