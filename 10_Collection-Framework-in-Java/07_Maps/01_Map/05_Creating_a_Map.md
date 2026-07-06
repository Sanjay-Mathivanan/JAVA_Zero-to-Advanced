# Creating a Map in Java

## Introduction

Before storing key-value pairs, we must first create a **Map** object.

Since **Map** is an interface, it cannot be instantiated directly. Instead, we create objects of one of its implementing classes such as `HashMap`, `LinkedHashMap`, or `TreeMap`.

This chapter explains different ways of creating a Map and choosing the appropriate implementation.

---

# Learning Objectives

After completing this topic, you will be able to:

* Create a Map in Java.
* Understand why Map objects cannot be created directly.
* Create different Map implementations.
* Use Generics with Map.
* Understand the relationship between the Map interface and its implementations.

---

# Problem Statement

Suppose you are developing a **Library Management System**.

Each book has:

* Book ID
* Book Name

Example

```text
101 → Java Programming

102 → Python Basics

103 → Data Structures
```

To store these records efficiently, we first need to create a Map.

---

# Why Can't We Create a Map Directly?

The `Map` type is an **interface**.

Interfaces only define **what operations are available**.

They do not provide complete implementations.

Therefore, the following code is incorrect.

```java
Map<Integer, String> books = new Map<>();
```

Compilation Error

```text
Cannot instantiate the type Map
```

Instead, Java requires us to create an object of a class that implements the Map interface.

---

# Creating a HashMap

The most common implementation is **HashMap**.

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

    }
}
```

Explanation

* `Map` → Interface
* `HashMap` → Implementation
* `Integer` → Key Type
* `String` → Value Type

Initially

```text
Map

Empty
```

---

# Creating a LinkedHashMap

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new LinkedHashMap<>();

    }
}
```

Use this implementation when insertion order must be preserved.

---

# Creating a TreeMap

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new TreeMap<>();

    }
}
```

TreeMap automatically stores keys in sorted order.

---

# Creating a Hashtable

```java
import java.util.Hashtable;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new Hashtable<>();

    }
}
```

Hashtable is synchronized and thread-safe.

---

# Generic Syntax

The general syntax for creating a Map is:

```java
Map<KeyType, ValueType> map = new Implementation<>();
```

Example

```java
Map<String, Integer> marks = new HashMap<>();
```

Here:

* Key Type → `String`
* Value Type → `Integer`

---

# Using Different Data Types

## Integer → String

```java
Map<Integer, String> students = new HashMap<>();
```

Example

```text
101 → Sanjay

102 → Rahul
```

---

## String → Integer

```java
Map<String, Integer> marks = new HashMap<>();
```

Example

```text
Math → 95

Science → 91
```

---

## String → Double

```java
Map<String, Double> products = new HashMap<>();
```

Example

```text
Laptop → 55000.00

Mouse → 650.00
```

---

## Integer → Custom Object

Suppose we have a `Student` class.

```java
Map<Integer, Student> studentMap = new HashMap<>();
```

Example

```text
101 → Student Object

102 → Student Object
```

---

# Using the Diamond Operator

Instead of writing

```java
Map<Integer, String> students = new HashMap<Integer, String>();
```

Java 7 introduced the **Diamond Operator (`<>`)**.

```java
Map<Integer, String> students = new HashMap<>();
```

Advantages

* Cleaner code
* Less repetition
* Better readability

---

# Memory Representation

Example

```java
Map<Integer, String> students = new HashMap<>();
```

Initially

```text
students

↓

Empty Map
```

After entries are added

```text
students

↓

101 → Sanjay

102 → Rahul

103 → Priya
```

---

# Choosing the Right Implementation

| Requirement              | Recommended Implementation |
| ------------------------ | -------------------------- |
| Fast lookup              | HashMap                    |
| Maintain insertion order | LinkedHashMap              |
| Automatically sort keys  | TreeMap                    |
| Thread-safe operations   | Hashtable                  |

---

# Program Flow

```text
Import Required Classes

        │

        ▼

Choose Map Implementation

        │

        ▼

Declare Map Reference

        │

        ▼

Create Object

        │

        ▼

Ready to Store Key-Value Pairs
```

---

# Complete Example Program

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        System.out.println("Map Created Successfully");

    }
}
```

---

# Output

```text
Map Created Successfully
```

---

# Step-by-Step Explanation

```java
Map<Integer, String> students
```

Declares a reference variable of type `Map`.

---

```java
new HashMap<>()
```

Creates a new `HashMap` object.

---

```java
Map<Integer, String> students = new HashMap<>();
```

The reference variable points to the newly created HashMap object.

---

# Internal Working

```text
Map Reference

      │

      ▼

+-------------------+
|    HashMap        |
|                   |
|   Empty Entries   |
+-------------------+
```

After storing entries

```text
+---------------------------+
|101 → Sanjay               |
|102 → Rahul                |
|103 → Priya                |
+---------------------------+
```

---

# Common Mistakes

## Trying to Instantiate Map

Incorrect

```java
Map<Integer, String> map = new Map<>();
```

Correct

```java
Map<Integer, String> map = new HashMap<>();
```

---

## Not Using Generics

Incorrect

```java
Map map = new HashMap();
```

Correct

```java
Map<Integer, String> map = new HashMap<>();
```

---

## Choosing the Wrong Implementation

* Use `HashMap` for general-purpose applications.
* Use `LinkedHashMap` when insertion order matters.
* Use `TreeMap` when sorted keys are required.
* Use `Hashtable` only when thread safety is necessary.

---

# Best Practices

* Declare variables using the `Map` interface.
* Use Generics for type safety.
* Prefer the Diamond Operator (`<>`).
* Select the implementation based on application requirements.
* Use meaningful key and value types.

---

# Interview Questions

1. Can we create an object of the Map interface?
2. Why can't interfaces be instantiated?
3. Which class is most commonly used to implement Map?
4. What is the purpose of the Diamond Operator?
5. Why should we declare variables using the Map interface?
6. Which implementation maintains insertion order?
7. Which implementation sorts keys automatically?
8. Which implementation is thread-safe?
9. What is the syntax for creating a Map?
10. Why are Generics important when creating a Map?

---

# Practice Programs

1. Create a HashMap of student IDs and names.
2. Create a LinkedHashMap of product IDs and names.
3. Create a TreeMap of country codes and country names.
4. Create a Hashtable of usernames and passwords.
5. Create a Map using custom objects.
6. Demonstrate the Diamond Operator.
7. Compare different Map implementations.
8. Print a message after creating a Map.
9. Create Maps using different key-value data types.
10. Build a simple employee record Map.

---

# Key Takeaways

* The `Map` interface cannot be instantiated directly.
* Objects are created using classes such as `HashMap`, `LinkedHashMap`, `TreeMap`, or `Hashtable`.
* Generics provide type safety.
* The Diamond Operator (`<>`) makes code cleaner.
* Different Map implementations serve different purposes.
* Choosing the correct implementation improves performance and maintainability.

---

# Conclusion

Creating a Map is the first step toward storing key-value pairs efficiently in Java. By understanding how to instantiate different Map implementations and when to use each one, developers can build scalable and maintainable applications. In the next chapter, we will learn how to **add key-value pairs to a Map** using methods such as `put()` and related operations.
