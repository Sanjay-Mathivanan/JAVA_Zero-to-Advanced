# Accessing Elements in a LinkedList

## Introduction

After adding and removing elements from a `LinkedList`, the next important operation is **accessing or retrieving elements**.

Accessing means reading the data stored inside the LinkedList without modifying it.

Java provides several methods to access elements from different positions, such as:

* First element
* Last element
* Any element using its index

Understanding these methods helps you retrieve data efficiently and choose the right method for different situations.

---

# Learning Objectives

After completing this topic, you will be able to:

* Access elements using different LinkedList methods.
* Retrieve the first and last elements.
* Access elements using an index.
* Understand how LinkedList searches for an element internally.
* Know when to use each access method.

---

# Problem Statement

Suppose you are developing a **Train Reservation System**.

Passengers are stored in a LinkedList.

The application should be able to:

* Display the first passenger.
* Display the last passenger.
* Display the passenger at a specific position.
* Retrieve passenger information without deleting it.

LinkedList provides built-in methods to perform these operations.

---

# Why Do We Need to Access Elements?

In real-world applications, we often need to read data without changing it.

Examples include:

* Viewing the first song in a playlist.
* Displaying the current task.
* Showing the first customer in a queue.
* Reading student details.
* Viewing browser history.

Access methods allow us to retrieve this information safely.

---

# Methods Used to Access Elements

| Method           | Description                                   |
| ---------------- | --------------------------------------------- |
| `get(int index)` | Returns the element at the specified index    |
| `getFirst()`     | Returns the first element                     |
| `getLast()`      | Returns the last element                      |
| `peek()`         | Returns the first element without removing it |
| `peekFirst()`    | Returns the first element without removing it |
| `peekLast()`     | Returns the last element without removing it  |
| `element()`      | Returns the first element                     |

> In this chapter (Part 1), we will focus on `get()`, `getFirst()`, and `getLast()`.

---

# 1. Using `get(int index)`

The `get()` method returns the element stored at the specified index.

Unlike an `ArrayList`, LinkedList cannot directly jump to an index. It must traverse the nodes until it reaches the required position.

---

## Syntax

```java
linkedList.get(index);
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Chennai");
        cities.add("Coimbatore");
        cities.add("Madurai");
        cities.add("Salem");

        System.out.println(cities.get(2));
    }
}
```

---

## Output

```text
Madurai
```

---

## Step-by-Step Explanation

LinkedList

```text
Index

0 → Chennai

1 → Coimbatore

2 → Madurai

3 → Salem
```

The statement

```java
cities.get(2);
```

returns

```text
Madurai
```

---

## Internal Working

LinkedList starts searching from the beginning.

```text
Head

 │

 ▼

Chennai

 │

 ▼

Coimbatore

 │

 ▼

Madurai   ← Found

 │

 ▼

Salem
```

Java traverses node by node until it reaches index **2**.

---

# Time Complexity of `get()`

| Operation    | Time Complexity |
| ------------ | --------------- |
| `get(index)` | O(n)            |

### Why O(n)?

Since LinkedList stores elements as nodes connected through references, it cannot directly access an element by index.

It must visit each node until the required position is found.

---

# 2. Using `getFirst()`

The `getFirst()` method returns the first element of the LinkedList.

It does **not** remove the element.

---

## Syntax

```java
linkedList.getFirst();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> students = new LinkedList<>();

        students.add("Sanjay");
        students.add("Rahul");
        students.add("Arun");

        System.out.println(students.getFirst());
    }
}
```

---

## Output

```text
Sanjay
```

---

## Step-by-Step Explanation

LinkedList

```text
Sanjay → Rahul → Arun
```

The first node contains

```text
Sanjay
```

The method returns

```text
Sanjay
```

The LinkedList remains unchanged.

---

## Internal Working

```text
Head

 │

 ▼

+-----------+     +----------+     +---------+
| Sanjay | ----> | Rahul | ----> | Arun |
+-----------+     +----------+     +---------+
```

`getFirst()` simply returns the data stored in the **head node**.

No traversal is required.

---

# Time Complexity of `getFirst()`

| Operation    | Time Complexity |
| ------------ | --------------- |
| `getFirst()` | O(1)            |

Since the head node is directly available, Java retrieves the first element immediately.

---

# 3. Using `getLast()`

The `getLast()` method returns the last element of the LinkedList.

It does **not** remove the element.

---

## Syntax

```java
linkedList.getLast();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> programmingLanguages = new LinkedList<>();

        programmingLanguages.add("Java");
        programmingLanguages.add("Python");
        programmingLanguages.add("C++");

        System.out.println(programmingLanguages.getLast());
    }
}
```

---

## Output

```text
C++
```

---

## Step-by-Step Explanation

Before retrieval

```text
Java → Python → C++
```

The last node contains

```text
C++
```

The method returns

```text
C++
```

The LinkedList remains unchanged.

---

## Internal Working

```text
Head

 │

 ▼

+--------+     +----------+     +------+
| Java | ----> | Python | ----> | C++ |
+--------+     +----------+     +------+

                                   ▲

                                 Tail
```

`getLast()` accesses the data stored in the **tail node**.

---

# Time Complexity of `getLast()`

| Operation   | Time Complexity |
| ----------- | --------------- |
| `getLast()` | O(1)            |

Since LinkedList maintains a reference to the tail node, retrieving the last element is a constant-time operation.

---

# Memory Representation

Suppose the LinkedList contains:

```text
10 → 20 → 30 → 40
```

Memory representation

```text
Address 120

+--------------+
|10 | 350 |
+--------------+

Address 350

+--------------+
|20 | 890 |
+--------------+

Address 890

+--------------+
|30 | 470 |
+--------------+

Address 470

+---------------+
|40 | null |
+---------------+
```

The nodes are connected through references rather than being stored in consecutive memory locations.

---

# Internal Working Summary

| Method       | Internal Process                                             |
| ------------ | ------------------------------------------------------------ |
| `get(index)` | Traverses the LinkedList until the required index is reached |
| `getFirst()` | Returns the data stored in the head node                     |
| `getLast()`  | Returns the data stored in the tail node                     |

---

# Program Flow

```text
Create LinkedList

        │

        ▼

Choose Access Method

        │

        ▼

Locate Required Node

        │

        ▼

Read Data

        │

        ▼

Return Element

        │

        ▼

LinkedList Remains Unchanged
```

---
# 4. Using `peek()`

The `peek()` method returns the **first element** of the LinkedList without removing it.

Unlike `getFirst()`, the `peek()` method **does not throw an exception** when the LinkedList is empty. Instead, it returns `null`.

---

## Syntax

```java
linkedList.peek();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> queue = new LinkedList<>();

        queue.add("Customer 1");
        queue.add("Customer 2");
        queue.add("Customer 3");

        System.out.println(queue.peek());
    }
}
```

---

## Output

```text
Customer 1
```

---

## Internal Working

```text
Head

 │

 ▼

+-------------+     +-------------+     +-------------+
| Customer 1 | --> | Customer 2 | --> | Customer 3 |
+-------------+     +-------------+     +-------------+
```

The method simply returns the data stored in the **head node**.

No element is removed.

---

# Empty LinkedList Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        System.out.println(list.peek());
    }
}
```

---

## Output

```text
null
```

---

# 5. Using `peekFirst()`

The `peekFirst()` method returns the first element without removing it.

If the LinkedList is empty, it returns `null`.

---

## Syntax

```java
linkedList.peekFirst();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(100);
        numbers.add(200);
        numbers.add(300);

        System.out.println(numbers.peekFirst());
    }
}
```

---

## Output

```text
100
```

---

## Explanation

```text
100 → 200 → 300
```

The first element is returned.

The LinkedList remains unchanged.

---

# 6. Using `peekLast()`

The `peekLast()` method returns the last element without removing it.

If the LinkedList is empty, it returns `null`.

---

## Syntax

```java
linkedList.peekLast();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> languages = new LinkedList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        System.out.println(languages.peekLast());
    }
}
```

---

## Output

```text
C++
```

---

## Explanation

```text
Java → Python → C++
```

The last node is accessed.

No element is removed.

---

# 7. Using `element()`

The `element()` method returns the **first element** of the LinkedList.

Unlike `peek()`, it throws a `NoSuchElementException` if the LinkedList is empty.

---

## Syntax

```java
linkedList.element();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Chennai");
        cities.add("Coimbatore");
        cities.add("Madurai");

        System.out.println(cities.element());
    }
}
```

---

## Output

```text
Chennai
```

---

# Empty LinkedList Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        System.out.println(cities.element());
    }
}
```

---

## Output

```text
Exception in thread "main"
java.util.NoSuchElementException
```

---

# Difference Between `peek()` and `element()`

| Feature               | `peek()`       | `element()`                     |
| --------------------- | -------------- | ------------------------------- |
| Returns First Element | Yes            | Yes                             |
| Removes Element       | No             | No                              |
| Empty LinkedList      | Returns `null` | Throws `NoSuchElementException` |

---

# Comparison of Access Methods

| Method        | Returns          | Removes Element | Empty List Behavior         |
| ------------- | ---------------- | --------------- | --------------------------- |
| `get(index)`  | Element at index | No              | `IndexOutOfBoundsException` |
| `getFirst()`  | First element    | No              | `NoSuchElementException`    |
| `getLast()`   | Last element     | No              | `NoSuchElementException`    |
| `peek()`      | First element    | No              | `null`                      |
| `peekFirst()` | First element    | No              | `null`                      |
| `peekLast()`  | Last element     | No              | `null`                      |
| `element()`   | First element    | No              | `NoSuchElementException`    |

---

# Program Flow

```text
Create LinkedList

       │

       ▼

Choose Access Method

       │

       ▼

Is LinkedList Empty?

       │
   ┌───┴────┐
   │        │
  Yes      No
   │        │
   ▼        ▼

Return    Locate Required
null or      Node
Exception      │
               ▼
          Return Data
               │
               ▼
      LinkedList Unchanged
```

---

# Common Mistakes

## 1. Accessing an Invalid Index

```java
LinkedList<String> list = new LinkedList<>();

list.add("Java");

System.out.println(list.get(5));
```

Result:

```text
IndexOutOfBoundsException
```

---

## 2. Calling `getFirst()` on an Empty LinkedList

```java
LinkedList<String> list = new LinkedList<>();

System.out.println(list.getFirst());
```

Result:

```text
NoSuchElementException
```

---

## 3. Confusing `peek()` with `remove()`

Incorrect assumption:

```text
peek() removes the first element.
```

Correct:

`peek()` only returns the first element.

The LinkedList remains unchanged.

---

## 4. Assuming `get()` Is as Fast as ArrayList

`get(index)` in LinkedList traverses the nodes one by one.

Therefore, it is slower than `ArrayList` for random access.

---

# Best Practices

* Use `get(index)` only when index-based access is required.
* Use `getFirst()` and `getLast()` for direct access to the first and last elements.
* Use `peek()` when you want to avoid exceptions on an empty LinkedList.
* Check `isEmpty()` before calling methods that may throw exceptions.
* Choose the access method based on your application's requirements.

---

# Interview Questions

1. What is the difference between `get()` and `peek()`?
2. Explain the working of `getFirst()`.
3. Explain the working of `getLast()`.
4. Why is `get(index)` slower in LinkedList?
5. What is the difference between `peek()` and `element()`?
6. Which method returns `null` for an empty LinkedList?
7. Which methods throw `NoSuchElementException`?
8. Does `peek()` remove the first element?
9. Which method is suitable for safely reading the first element?
10. Why does LinkedList require traversal for index-based access?

---

# Practice Programs

1. Retrieve the first element using `getFirst()`.
2. Retrieve the last element using `getLast()`.
3. Access an element using `get(index)`.
4. Display the first element using `peek()`.
5. Compare `peek()` and `element()` on an empty LinkedList.
6. Create a menu-driven program to access LinkedList elements.
7. Display the first and last employee names.
8. Access custom `Student` objects stored in a LinkedList.
9. Read all city names using different access methods.
10. Build a queue viewer using `peek()`.

---

# Key Takeaways

* `get(index)` retrieves an element at a specified position.
* `getFirst()` and `getLast()` return the first and last elements efficiently.
* `peek()`, `peekFirst()`, and `peekLast()` return elements without removing them and return `null` if the list is empty.
* `element()` behaves like `peek()` but throws an exception for an empty LinkedList.
* Choosing the correct access method improves both readability and reliability.

---

# Conclusion

Accessing elements is a fundamental LinkedList operation used in almost every Java application. Java provides multiple methods to retrieve elements depending on the required position and the desired behavior when the list is empty. Understanding the differences between `get()`, `getFirst()`, `getLast()`, `peek()`, and `element()` helps developers write cleaner, safer, and more efficient code.

In the next chapter, we will learn how to **iterate through a LinkedList** using different techniques such as the enhanced `for` loop, `Iterator`, `ListIterator`, and `forEach()` method.
