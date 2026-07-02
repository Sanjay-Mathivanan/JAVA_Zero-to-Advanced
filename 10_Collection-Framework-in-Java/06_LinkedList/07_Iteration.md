# Iteration in LinkedList

## Introduction

After learning how to create, add, remove, and access elements in a `LinkedList`, the next important concept is **iteration**.

**Iteration** means visiting each element of the LinkedList one by one. It is one of the most common operations because most real-world applications need to process every element stored in the collection.

Java provides multiple ways to iterate through a LinkedList. Each approach has its own advantages and is suitable for different situations.

In this chapter, we will learn the most commonly used iteration techniques with examples and understand how they work internally.

---

# Learning Objectives

After completing this topic, you will be able to:

* Understand what iteration means.
* Traverse every element in a LinkedList.
* Use the enhanced `for` loop.
* Use the traditional `for` loop.
* Use an `Iterator`.
* Understand the internal working of different iteration techniques.
* Choose the appropriate iteration method for different scenarios.

---

# Problem Statement

Suppose you are developing a **Library Management System**.

The library stores all book names in a LinkedList.

The application should be able to:

* Display all books.
* Search through books.
* Print every book one by one.
* Process every record in the collection.

To perform these tasks, the program must iterate through the LinkedList.

---

# What is Iteration?

Iteration is the process of visiting every element stored inside a collection.

Example LinkedList

```text
Apple → Banana → Mango → Orange
```

Iteration means reading the elements in the following order:

```text
Apple

↓

Banana

↓

Mango

↓

Orange
```

Every element is accessed exactly once.

---

# Why Do We Need Iteration?

Iteration is required whenever we need to process all elements in a collection.

Common applications include:

* Displaying all students.
* Printing employee details.
* Searching for an item.
* Calculating totals.
* Processing customer orders.
* Displaying playlists.
* Reading queue elements.
* Exporting reports.

Without iteration, only one element can be accessed at a time.

---

# Ways to Iterate Through a LinkedList

Java provides several ways to traverse a LinkedList.

| Method                 | Description                                          |
| ---------------------- | ---------------------------------------------------- |
| Enhanced `for` Loop    | Simple and beginner-friendly                         |
| Traditional `for` Loop | Access using index                                   |
| `Iterator`             | Standard way to traverse collections                 |
| `ListIterator`         | Forward and backward traversal *(covered in Part 2)* |
| `forEach()`            | Java 8 feature *(covered in Part 2)*                 |
| Lambda Expression      | Functional style *(covered in Part 2)*               |

---

# 1. Using the Enhanced `for` Loop

The enhanced `for` loop (also called the **for-each loop**) is the easiest way to iterate through a LinkedList.

It automatically visits each element without requiring an index.

---

## Syntax

```java
for(DataType variable : linkedList) {

    // Statements
}
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

---

## Output

```text
Apple
Banana
Mango
Orange
```

---

## Step-by-Step Explanation

```java
for (String fruit : fruits)
```

* `String` → Data type of elements.
* `fruit` → Temporary variable.
* `fruits` → LinkedList being traversed.

Each iteration assigns one element to `fruit`.

Iteration 1

```text
fruit = Apple
```

Iteration 2

```text
fruit = Banana
```

Iteration 3

```text
fruit = Mango
```

Iteration 4

```text
fruit = Orange
```

---

## Internal Working

Although it appears simple, Java internally uses an `Iterator`.

Conceptually,

```text
Apple

↓

Banana

↓

Mango

↓

Orange
```

The iterator moves from one node to the next until it reaches the end of the list.

---

# Advantages of the Enhanced `for` Loop

* Easy to read.
* Less code.
* No index management.
* Suitable for read-only traversal.
* Reduces programming errors.

---

# Limitations

* Cannot directly access indexes.
* Not suitable when elements need to be modified during iteration.
* Cannot traverse backward.

---

# 2. Using the Traditional `for` Loop

A LinkedList can also be traversed using a normal `for` loop.

This approach accesses elements using their index.

---

## Syntax

```java
for (int i = 0; i < linkedList.size(); i++) {

    System.out.println(linkedList.get(i));
}
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);

        for (int i = 0; i < numbers.size(); i++) {

            System.out.println(numbers.get(i));
        }
    }
}
```

---

## Output

```text
10
20
30
40
```

---

## Step-by-Step Explanation

Iteration 1

```text
i = 0

numbers.get(0)

Output → 10
```

Iteration 2

```text
i = 1

numbers.get(1)

Output → 20
```

Iteration 3

```text
i = 2

Output → 30
```

Iteration 4

```text
i = 3

Output → 40
```

---

## Internal Working

For every iteration,

```java
numbers.get(i);
```

LinkedList searches from the beginning (or internally from the nearest end) until it reaches the required index.

Example

```text
Index 2

Head

 │

 ▼

10

↓

20

↓

30  ← Found

↓

40
```

Unlike an ArrayList, LinkedList cannot directly jump to an index.

---

# Time Complexity

| Operation | Complexity |
| --------- | ---------- |
| `get(i)`  | O(n)       |

Therefore,

```java
for(int i=0; i<list.size(); i++)
```

may become inefficient for large LinkedLists because `get(i)` is executed repeatedly.

---

# 3. Using an `Iterator`

An `Iterator` is the standard way to traverse collections in Java.

It allows elements to be visited one by one.

Unlike the enhanced `for` loop, an `Iterator` provides additional methods such as checking whether more elements are available.

---

## Syntax

```java
Iterator<DataType> iterator = linkedList.iterator();

while (iterator.hasNext()) {

    System.out.println(iterator.next());
}
```

---

## Example

```java
import java.util.Iterator;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> subjects = new LinkedList<>();

        subjects.add("Java");
        subjects.add("Python");
        subjects.add("C++");

        Iterator<String> iterator = subjects.iterator();

        while (iterator.hasNext()) {

            System.out.println(iterator.next());
        }
    }
}
```

---

## Output

```text
Java
Python
C++
```

---

## Step-by-Step Explanation

```java
Iterator<String> iterator = subjects.iterator();
```

Creates an iterator for the LinkedList.

---

```java
iterator.hasNext()
```

Checks whether another element exists.

Returns:

```text
true
```

or

```text
false
```

---

```java
iterator.next();
```

Returns the current element and automatically moves to the next node.

---

## Internal Working

Initially

```text
Iterator

   │

   ▼

Java → Python → C++
```

After calling

```java
iterator.next();
```

```text
Iterator

         │

         ▼

Java → Python → C++
```

The first element (`Java`) is returned.

The iterator then moves to the next node (`Python`).

This process continues until all nodes have been visited.

---

# Program Flow

```text
Create LinkedList

        │

        ▼

Choose Iteration Method

        │

        ▼

Visit First Node

        │

        ▼

Read Current Element

        │

        ▼

Move to Next Node

        │

        ▼

Repeat Until End

        │

        ▼

Iteration Complete
```

---

# Internal Working Summary

| Method                 | How It Works                                      |
| ---------------------- | ------------------------------------------------- |
| Enhanced `for` Loop    | Internally uses an `Iterator`                     |
| Traditional `for` Loop | Calls `get(index)` repeatedly                     |
| `Iterator`             | Moves node by node using `hasNext()` and `next()` |


# 4. Using `ListIterator`

A `ListIterator` is a special type of iterator used with **List** implementations such as `ArrayList` and `LinkedList`.

Unlike a normal `Iterator`, a `ListIterator` can:

* Traverse in the forward direction.
* Traverse in the backward direction.
* Access the next and previous elements.
* Add, update, and remove elements during iteration.

---

## Syntax

```java
ListIterator<DataType> iterator = linkedList.listIterator();
```

---

## Example

```java
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> courses = new LinkedList<>();

        courses.add("Java");
        courses.add("Python");
        courses.add("C++");

        ListIterator<String> iterator = courses.listIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

## Output

```text
Java
Python
C++
```

---

## Reverse Traversal

One of the biggest advantages of `ListIterator` is backward traversal.

```java
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> courses = new LinkedList<>();

        courses.add("Java");
        courses.add("Python");
        courses.add("C++");

        ListIterator<String> iterator = courses.listIterator(courses.size());

        while (iterator.hasPrevious()) {
            System.out.println(iterator.previous());
        }
    }
}
```

---

## Output

```text
C++
Python
Java
```

---

## Internal Working

Forward traversal

```text
Java → Python → C++
         ↑
     Iterator
```

Backward traversal

```text
Java ← Python ← C++
         ↑
     Iterator
```

The iterator can move in both directions.

---

# Important Methods of `ListIterator`

| Method          | Description                         |
| --------------- | ----------------------------------- |
| `hasNext()`     | Checks if a next element exists     |
| `next()`        | Returns the next element            |
| `hasPrevious()` | Checks if a previous element exists |
| `previous()`    | Returns the previous element        |
| `add()`         | Inserts an element                  |
| `remove()`      | Removes the current element         |
| `set()`         | Replaces the current element        |

---

# 5. Using `forEach()` Method

Java 8 introduced the `forEach()` method for iterating through collections.

It executes the specified action for every element in the LinkedList.

---

## Syntax

```java
linkedList.forEach(element -> {

    // Statements

});
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

        cities.forEach(city -> System.out.println(city));
    }
}
```

---

## Output

```text
Chennai
Coimbatore
Madurai
```

---

## Explanation

Each element is automatically passed to the lambda expression.

Example

```text
city = Chennai

↓

city = Coimbatore

↓

city = Madurai
```

---

# 6. Using Lambda Expression

Lambda expressions make iteration shorter and more readable.

Instead of writing multiple lines of code, the required operation is written directly inside the lambda.

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.forEach(number -> {

            System.out.println(number * 2);

        });
    }
}
```

---

## Output

```text
20
40
60
```

---

## Explanation

Every number is multiplied by **2** before printing.

Original list

```text
10

20

30
```

Displayed output

```text
20

40

60
```

The actual LinkedList remains unchanged.

---

# Program Flow

```text
Create LinkedList

        │

        ▼

Choose Iteration Method

        │

        ▼

Visit Current Node

        │

        ▼

Process Data

        │

        ▼

Move to Next (or Previous) Node

        │

        ▼

Repeat Until Traversal Ends

        │

        ▼

Program Ends
```

---

# Comparison of Iteration Techniques

| Technique              | Forward | Backward | Modify Elements  | Easy to Use |
| ---------------------- | ------- | -------- | ---------------- | ----------- |
| Enhanced `for` Loop    | Yes     | No       | No               | Excellent   |
| Traditional `for` Loop | Yes     | No       | Limited          | Good        |
| `Iterator`             | Yes     | No       | Yes (`remove()`) | Excellent   |
| `ListIterator`         | Yes     | Yes      | Yes              | Excellent   |
| `forEach()`            | Yes     | No       | No               | Excellent   |
| Lambda Expression      | Yes     | No       | No               | Excellent   |

---

# Which Iteration Method Should You Choose?

| Situation                      | Recommended Method      |
| ------------------------------ | ----------------------- |
| Simple traversal               | Enhanced `for` Loop     |
| Index-based processing         | Traditional `for` Loop  |
| Safe collection traversal      | `Iterator`              |
| Forward and backward traversal | `ListIterator`          |
| Java 8 functional programming  | `forEach()` with Lambda |

---

# Common Mistakes

## Using `get(i)` Repeatedly in a Large LinkedList

```java
for (int i = 0; i < list.size(); i++) {

    System.out.println(list.get(i));
}
```

Since `get(i)` requires traversal, this approach is inefficient for large LinkedLists.

---

## Forgetting `hasNext()`

Incorrect

```java
iterator.next();
```

Correct

```java
if (iterator.hasNext()) {

    System.out.println(iterator.next());

}
```

Always check `hasNext()` before calling `next()`.

---

## Modifying a LinkedList Inside an Enhanced `for` Loop

Incorrect

```java
for (String item : list) {

    list.remove(item);

}
```

This may throw a `ConcurrentModificationException`.

Use an `Iterator` instead.

---

## Using `previous()` Without Checking

Incorrect

```java
iterator.previous();
```

Always check

```java
iterator.hasPrevious();
```

before calling `previous()`.

---

# Best Practices

* Use the enhanced `for` loop for simple read-only traversal.
* Prefer `Iterator` when elements need to be removed safely during iteration.
* Use `ListIterator` when both forward and backward traversal are required.
* Use `forEach()` and lambda expressions for concise and readable Java 8+ code.
* Avoid repeated `get(index)` calls on large LinkedLists.

---

# Interview Questions

1. What is iteration in Java?
2. What are the different ways to iterate through a LinkedList?
3. What is the difference between `Iterator` and `ListIterator`?
4. Why is the enhanced `for` loop considered beginner-friendly?
5. Can `Iterator` traverse backward?
6. Which iterator supports backward traversal?
7. What is the purpose of the `forEach()` method?
8. What are lambda expressions?
9. Why is repeated `get(index)` inefficient for LinkedList?
10. When would you choose `ListIterator` over `Iterator`?

---

# Practice Programs

1. Print all student names using an enhanced `for` loop.
2. Traverse a LinkedList using a traditional `for` loop.
3. Display employee names using an `Iterator`.
4. Traverse a LinkedList in reverse using `ListIterator`.
5. Print all elements using `forEach()`.
6. Multiply every number by 5 using a lambda expression.
7. Remove even numbers using an `Iterator`.
8. Display all city names in reverse order.
9. Compare the outputs of different iteration methods.
10. Create a menu-driven program demonstrating all iteration techniques.

---

# Key Takeaways

* Iteration means visiting every element in a collection.
* Java provides multiple ways to iterate through a LinkedList.
* The enhanced `for` loop is simple and suitable for read-only traversal.
* `Iterator` is useful for safe traversal and element removal.
* `ListIterator` supports both forward and backward traversal.
* `forEach()` and lambda expressions provide modern and concise iteration.
* Choose the iteration technique based on the application's requirements.

---

# Conclusion

Iteration is one of the most frequently used operations in the Java Collection Framework. A LinkedList can be traversed using multiple techniques, each designed for specific scenarios. Understanding the strengths and limitations of each approach helps developers write efficient, readable, and maintainable Java programs. By selecting the appropriate iteration method, you can improve both the performance and clarity of your applications.

In the next chapter, we will explore **Searching and Updating Elements in a LinkedList**, including methods such as `contains()`, `indexOf()`, `lastIndexOf()`, `set()`, and related operations.
