# Collections Framework in Java (Part 1 - B)

> **Chapter 10 - Collection Framework in Java**

---

# Collection Framework Architecture

The Java Collection Framework follows a hierarchical structure.

Instead of providing a single class for storing data, Java organizes different data structures into interfaces and classes.

The architecture looks like this.

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
```

Each interface has a specific purpose.

- **Iterable** → Used to traverse elements.
- **Collection** → Root interface of the Collection Framework.
- **List** → Stores ordered elements.
- **Queue** → Stores elements in FIFO order.
- **Set** → Stores unique elements.

---

# Iterable Interface

The **Iterable** interface is the top-most interface in the Collection Framework hierarchy.

It allows objects to be traversed one by one.

Without `Iterable`, the enhanced `for-each` loop would not work.

---

## Syntax

```java
public interface Iterable<T>
```

---

## Main Method

```java
iterator()
```

It returns an **Iterator** object.

---

## Example

```java
import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Rahul");
        names.add("Arun");
        names.add("Priya");

        for(String name : names){

            System.out.println(name);

        }

    }

}
```

---

## Output

```
Rahul
Arun
Priya
```

---

## Program Explanation

### Step 1

Create an ArrayList.

```java
ArrayList<String> names = new ArrayList<>();
```

---

### Step 2

Insert elements.

```java
add()
```

---

### Step 3

Traverse using

```java
for-each
```

Internally,

the loop uses

```
iterator()
```

---

# Collection Interface

The **Collection** interface is the root interface of almost every collection class.

It defines common operations like

- Adding
- Removing
- Searching
- Clearing
- Checking size

Almost every collection class implements this interface.

---

# Collection Interface Hierarchy

```
Collection

      │

      ├── List

      ├── Queue

      └── Set
```

---

# Common Methods of Collection Interface

| Method | Description |
|---------|-------------|
| add() | Adds an element |
| remove() | Removes an element |
| contains() | Checks whether an element exists |
| size() | Returns total elements |
| isEmpty() | Checks whether collection is empty |
| clear() | Removes all elements |

---

# Method 1 : add()

Adds an element into the collection.

Example

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");

list.add("Python");
```

Output

```
Java

Python
```

---

# Method 2 : remove()

Removes an element.

Example

```java
list.remove("Python");
```

Remaining

```
Java
```

---

# Method 3 : contains()

Checks whether an element exists.

Example

```java
System.out.println(list.contains("Java"));
```

Output

```
true
```

---

# Method 4 : size()

Returns the total number of elements.

Example

```java
System.out.println(list.size());
```

Output

```
2
```

---

# Method 5 : isEmpty()

Checks whether the collection is empty.

Example

```java
System.out.println(list.isEmpty());
```

Output

```
false
```

---

# Method 6 : clear()

Removes all elements.

Example

```java
list.clear();
```

Collection becomes

```
Empty
```

---

# First Collection Program

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

# Line-by-Line Explanation

### Import Statement

```java
import java.util.ArrayList;
```

Imports the `ArrayList` class.

---

### Create Object

```java
ArrayList<String> fruits = new ArrayList<>();
```

Creates an empty dynamic list.

---

### Add Elements

```java
fruits.add("Apple");
```

Stores "Apple" in the list.

Similarly,

```java
fruits.add("Banana");
```

and

```java
fruits.add("Orange");
```

store additional elements.

---

### Print Collection

```java
System.out.println(fruits);
```

Displays all stored elements.

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

# Memory Representation

```
Stack Memory

+--------------------+
| fruits             |
+---------|----------+
          |
          ▼

Heap Memory

+------------------------------+
| ArrayList Object             |
|------------------------------|
| Apple                        |
| Banana                       |
| Orange                       |
+------------------------------+
```

The reference variable **fruits** is stored in the **Stack Memory**, while the actual `ArrayList` object is created in the **Heap Memory**.

---

# Array vs Collection

| Array | Collection |
|--------|------------|
| Fixed Size | Dynamic Size |
| Stores Primitive & Objects | Stores Objects |
| Difficult Insertion | Easy Insertion |
| Difficult Deletion | Easy Deletion |
| Manual Searching | Built-in Methods |
| Less Flexible | Highly Flexible |
| Not Growable | Automatically Resizes |

---

# Why Collections Are Better Than Arrays?

Suppose we have an array.

```
10

20

30
```

Need to insert

```
25
```

Result

```
10

20

25

30
```

In an array,

elements must be shifted manually.

---

Using an `ArrayList`,

Java handles this automatically.

```
ArrayList

↓

add(25)

↓

Automatically Resizes

↓

Insertion Completed
```

---

# Real-World Applications

Collections are used in almost every Java application.

Examples include:

- Banking Systems
- Student Management Systems
- E-Commerce Websites
- Inventory Management
- Hospital Management
- Library Management
- Online Shopping Carts
- Chat Applications
- Social Media Platforms

---

# Advantages of Using Collections

- Dynamic memory allocation
- Easy insertion and deletion
- Built-in searching methods
- Built-in sorting methods
- Reusable data structures
- Better performance
- Less code
- Better readability
- Generic programming support

---

# Common Mistakes

## Mistake 1

Forgetting to import the package.

```java
ArrayList<String> list = new ArrayList<>();
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

Collections store **objects**, not primitive types.

---

## Mistake 3

Accessing an invalid index.

```java
list.get(10);
```

Output

```
IndexOutOfBoundsException
```

---

# Best Practices

- Use **Generics** for type safety.
- Choose the correct collection based on the requirement.
- Avoid storing unnecessary duplicate data.
- Use enhanced `for` loops or iterators for traversal.
- Prefer the `Collection` interface for programming to an interface rather than a specific implementation.

---

# Key Takeaways

- `Iterable` is the top-most interface.
- `Collection` is the root interface for most collection classes.
- `List`, `Queue`, and `Set` extend the `Collection` interface.
- Collections provide dynamic storage.
- Collections offer built-in methods such as `add()`, `remove()`, `contains()`, `size()`, `clear()`, and `isEmpty()`.
- Collections are easier to use and more flexible than arrays.

---

# Summary

In this chapter, you learned:

- The architecture of the Java Collection Framework.
- The purpose of the `Iterable` interface.
- The role of the `Collection` interface.
- Common methods available in the Collection interface.
- How to create and use an `ArrayList`.
- The differences between Arrays and Collections.
- Memory representation and execution flow of a simple Collection program.

This foundation prepares you for learning individual collection interfaces like **List**, **Queue**, **Set**, and **Map** in the upcoming chapters.
