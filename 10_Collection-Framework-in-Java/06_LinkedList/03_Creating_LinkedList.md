# Creating a LinkedList in Java

## Introduction

After understanding **what a LinkedList is** and **why we use it**, the next step is learning how to create and initialize a `LinkedList` in Java.

The Java Collection Framework provides the **LinkedList** class in the `java.util` package. It can store objects of any data type and automatically grows or shrinks as elements are added or removed.

This chapter explains different ways to create a LinkedList with simple examples.

---

# Learning Objectives

After completing this topic, you will be able to:

* Import the `LinkedList` class.
* Create an empty LinkedList.
* Create LinkedLists for different data types.
* Use Generics with LinkedList.
* Initialize a LinkedList with existing collections.
* Understand type safety in LinkedList.

---

# Problem Statement

Suppose you are developing a **Library Management System** where books are added and removed regularly.

Before storing book information, you first need to create a LinkedList that can hold the book names.

Similarly, every Java application using LinkedList starts by creating a LinkedList object.

---

# Importing the LinkedList Class

Before using LinkedList, import it from the `java.util` package.

```java
import java.util.LinkedList;
```

Alternatively,

```java
import java.util.*;
```

imports all classes available in the `java.util` package.

---

# Syntax

## Creating an Empty LinkedList

```java
LinkedList<DataType> listName = new LinkedList<>();
```

### Explanation

* `LinkedList` → Collection class.
* `DataType` → Type of elements stored.
* `listName` → Variable name.
* `new LinkedList<>()` → Creates a new LinkedList object.

---

# Why Do We Use Generics?

Generics provide **type safety**.

Without Generics:

```java
LinkedList list = new LinkedList();
```

Any type of object can be inserted.

Example:

```text
10
"Java"
25.5
true
```

This may lead to runtime errors.

With Generics:

```java
LinkedList<String> names = new LinkedList<>();
```

Only `String` objects can be stored.

Trying to insert an integer will produce a compile-time error.

---

# Creating an Empty LinkedList

## Example 1

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();

        System.out.println(fruits);
    }
}
```

---

# Output

```text
[]
```

---

# Explanation

* A new LinkedList is created.
* No elements are added.
* Printing the list displays an empty collection.

---

# Creating a LinkedList of Integers

## Example 2

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        System.out.println(numbers);
    }
}
```

---

# Output

```text
[]
```

---

# Creating a LinkedList of Double Values

## Example 3

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Double> prices = new LinkedList<>();

        System.out.println(prices);
    }
}
```

---

# Output

```text
[]
```

---

# Creating a LinkedList of Characters

## Example 4

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Character> grades = new LinkedList<>();

        System.out.println(grades);
    }
}
```

---

# Output

```text
[]
```

---

# Creating a LinkedList of Custom Objects

LinkedList can also store user-defined objects.

Suppose we have a `Student` class.

## Student.java

```java
public class Student {

    String name;

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
```

---

## Main.java

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Student> students = new LinkedList<>();

        students.add(new Student("Sanjay"));
        students.add(new Student("Rahul"));

        System.out.println(students);
    }
}
```

---

# Output

```text
[Sanjay, Rahul]
```

---

# Creating a LinkedList from Another Collection

A LinkedList can be created using an existing collection.

```java
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> languages = new ArrayList<>();

        languages.add("Java");
        languages.add("Python");
        languages.add("C++");

        LinkedList<String> list = new LinkedList<>(languages);

        System.out.println(list);
    }
}
```

---

# Output

```text
[Java, Python, C++]
```

---

# Internal Working

When the following statement is executed:

```java
LinkedList<String> cities = new LinkedList<>();
```

Java creates an empty LinkedList.

Initially,

```text
Head → null

Tail → null

Size = 0
```

No nodes exist.

---

# After Adding the First Element

Suppose we execute:

```java
cities.add("Chennai");
```

The LinkedList becomes:

```text
Head
 |

 v

+-------------+
| Chennai | • |
+-------------+
        |
      null
```

Both **Head** and **Tail** point to the same node.

---

# After Adding More Elements

```java
cities.add("Coimbatore");
cities.add("Madurai");
```

Structure:

```text
Head
 |

 v

+-----------+     +--------------+     +-----------+
| Chennai | ----> | Coimbatore | ----> | Madurai |
+-----------+     +--------------+     +-----------+
                                            |
                                           null
```

Each new node is connected through references.

---

# Memory Representation

```text
Address 120

+------------------+
| Chennai | 450 |
+------------------+

Address 450

+----------------------+
| Coimbatore | 810 |
+----------------------+

Address 810

+----------------+
| Madurai | null |
+----------------+
```

Nodes can occupy different memory locations.

---

# Program Flow

```text
Import LinkedList

        │

        ▼

Create LinkedList Object

        │

        ▼

Initially Empty

        │

        ▼

Add Elements

        │

        ▼

Nodes Are Created

        │

        ▼

Nodes Are Connected

        │

        ▼

LinkedList Ready for Use
```

---

# Common Mistakes

## Forgetting the Import Statement

```java
LinkedList<String> list = new LinkedList<>();
```

Without importing `java.util.LinkedList`, the program will not compile.

---

## Not Using Generics

Incorrect:

```java
LinkedList list = new LinkedList();
```

Correct:

```java
LinkedList<String> list = new LinkedList<>();
```

---

## Mixing Different Data Types

```java
LinkedList<Integer> numbers = new LinkedList<>();

numbers.add("Java");
```

This causes a compile-time error.

---

# Best Practices

* Always use Generics.
* Use meaningful variable names.
* Import only the required classes when possible.
* Store one type of object in a single LinkedList.
* Follow Java naming conventions.

---

# Interview Questions

1. Which package contains the LinkedList class?
2. How do you create an empty LinkedList?
3. Why are Generics used with LinkedList?
4. Can LinkedList store custom objects?
5. Can a LinkedList be created from another collection?
6. What is the initial size of a newly created LinkedList?
7. What do the head and tail point to in an empty LinkedList?
8. Can LinkedList store duplicate values?
9. Can LinkedList store null values?
10. Why should raw LinkedList types be avoided?

---

# Practice Programs

1. Create an empty LinkedList of integers.
2. Create a LinkedList of student names.
3. Create a LinkedList of decimal numbers.
4. Create a LinkedList of custom `Employee` objects.
5. Convert an `ArrayList` into a `LinkedList`.
6. Print an empty LinkedList.
7. Create a LinkedList containing city names.
8. Store Boolean values in a LinkedList.
9. Create multiple LinkedLists with different data types.
10. Create a LinkedList using another collection.

---

# Key Takeaways

* The `LinkedList` class belongs to the `java.util` package.
* A LinkedList is created using the `new` keyword.
* Generics ensure type safety.
* LinkedList can store primitive wrapper classes, strings, and custom objects.
* A LinkedList can also be initialized using another collection.
* Initially, a new LinkedList contains no nodes.

---

# Conclusion

Creating a LinkedList in Java is simple and forms the foundation for working with the Collection Framework. By using Generics, importing the correct package, and understanding how nodes are created internally, developers can build flexible and efficient applications. In the next chapter, we will learn how to **add elements to a LinkedList** using different methods such as `add()`, `addFirst()`, `addLast()`, and indexed insertion.
