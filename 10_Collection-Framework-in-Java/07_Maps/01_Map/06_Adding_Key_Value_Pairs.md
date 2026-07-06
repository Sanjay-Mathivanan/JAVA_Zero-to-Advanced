# Adding Key-Value Pairs to a Map

## Introduction

After creating a `Map`, the next step is to store data inside it.

In Java, data is added to a Map using the **`put()`** method. Each entry consists of a **key** and a **value**.

The `put()` method is one of the most frequently used methods of the Map interface because it allows us to insert new entries and update existing ones.

---

# Learning Objectives

After completing this topic, you will be able to:

* Add entries to a Map.
* Understand the `put()` method.
* Learn how duplicate keys are handled.
* Understand how duplicate values are stored.
* Add different types of key-value pairs.
* Visualize how entries are stored internally.

---

# Problem Statement

Suppose you are developing a **Student Management System**.

Each student has:

* Student ID
* Student Name

Example

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

The application should store these records efficiently using a Map.

---

# The `put()` Method

The `put()` method inserts a new key-value pair into a Map.

## Syntax

```java
map.put(key, value);
```

Where:

* `key` → Unique identifier
* `value` → Data associated with the key

---

# Example 1: Adding Student Records

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Priya");

        System.out.println(students);
    }
}
```

---

# Output

```text
{101=Sanjay, 102=Rahul, 103=Priya}
```

---

# Step-by-Step Explanation

```java
Map<Integer, String> students = new HashMap<>();
```

Creates an empty HashMap.

---

```java
students.put(101, "Sanjay");
```

Adds

```text
101 → Sanjay
```

---

```java
students.put(102, "Rahul");
```

Adds

```text
102 → Rahul
```

---

```java
students.put(103, "Priya");
```

Adds

```text
103 → Priya
```

---

# Internal Working

Initially

```text
Map

Empty
```

After first insertion

```text
101 → Sanjay
```

After second insertion

```text
101 → Sanjay

102 → Rahul
```

After third insertion

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

---

# Example 2: Adding Product Prices

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Double> products = new HashMap<>();

        products.put("Laptop", 55000.00);
        products.put("Mouse", 650.00);
        products.put("Keyboard", 1200.00);

        System.out.println(products);
    }
}
```

---

# Output

```text
{Laptop=55000.0, Mouse=650.0, Keyboard=1200.0}
```

---

# Example 3: Duplicate Keys

Consider the following program.

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");

        students.put(101, "Rahul");

        System.out.println(students);
    }
}
```

---

# Output

```text
{101=Rahul}
```

---

# Why Did This Happen?

The key **101** already exists.

When the second `put()` is executed,

```java
students.put(101, "Rahul");
```

Java replaces the old value.

Diagram

```text
Before

101 → Sanjay

        │

        ▼

After

101 → Rahul
```

A Map never stores duplicate keys.

---

# Example 4: Duplicate Values

Duplicate values are allowed.

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Sanjay");

        System.out.println(students);
    }
}
```

---

# Output

```text
{101=Sanjay, 102=Rahul, 103=Sanjay}
```

Only keys must be unique.

Values may be repeated.

---

# Example 5: Adding `null`

For `HashMap`

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(null, "Unknown");

        students.put(101, null);

        System.out.println(students);
    }
}
```

---

# Output

```text
{null=Unknown, 101=null}
```

> **Note:** `HashMap` allows one `null` key and multiple `null` values. Other Map implementations may have different rules.

---

# Adding Different Data Types

## Integer → String

```java
Map<Integer, String> students = new HashMap<>();
```

---

## String → Integer

```java
Map<String, Integer> marks = new HashMap<>();
```

---

## String → Double

```java
Map<String, Double> products = new HashMap<>();
```

---

## Integer → Custom Object

```java
Map<Integer, Student> studentMap = new HashMap<>();
```

---

# Memory Representation

Suppose we execute

```java
students.put(101, "Sanjay");
students.put(102, "Rahul");
students.put(103, "Priya");
```

Conceptually, the Map contains:

```text
+----------------------------+
| Key : 101                  |
| Value : Sanjay             |
+----------------------------+

+----------------------------+
| Key : 102                  |
| Value : Rahul              |
+----------------------------+

+----------------------------+
| Key : 103                  |
| Value : Priya              |
+----------------------------+
```

---

# Program Flow

```text
Create Map

      │

      ▼

Call put(key, value)

      │

      ▼

Does Key Already Exist?

      │
 ┌────┴────┐
 │         │
No        Yes
 │         │
 ▼         ▼

Add     Replace
Entry   Old Value

      │

      ▼

Map Updated
```

---

# Common Mistakes

## Assuming Duplicate Keys Are Stored

Incorrect

```java
students.put(101, "Sanjay");
students.put(101, "Rahul");
```

Only one entry remains.

---

## Forgetting Generics

Incorrect

```java
Map map = new HashMap();
```

Correct

```java
Map<Integer, String> map = new HashMap<>();
```

---

## Confusing Keys with Values

Remember:

* Key identifies the entry.
* Value stores the associated information.

---

# Best Practices

* Always use meaningful and unique keys.
* Use Generics for type safety.
* Choose the correct Map implementation.
* Avoid mutable objects as keys.
* Check whether replacing an existing value is intended.

---

# Interview Questions

1. Which method is used to add entries to a Map?
2. What is the syntax of the `put()` method?
3. What happens when a duplicate key is inserted?
4. Can duplicate values be stored?
5. Does `put()` return a value?
6. Can `HashMap` store `null` keys?
7. Can `HashMap` store `null` values?
8. Can custom objects be stored as values?
9. Why are duplicate keys not allowed?
10. What is the difference between a key and a value?

---

# Practice Programs

1. Store student IDs and names.
2. Store employee IDs and salaries.
3. Store product names and prices.
4. Demonstrate duplicate key replacement.
5. Demonstrate duplicate values.
6. Store `null` values in a `HashMap`.
7. Create a phone directory using a Map.
8. Store country codes and country names.
9. Store roll numbers and marks.
10. Store custom `Student` objects in a Map.

---

# Key Takeaways

* The `put()` method is used to add key-value pairs to a Map.
* Keys must be unique.
* Duplicate keys replace existing values.
* Duplicate values are allowed.
* `HashMap` allows one `null` key and multiple `null` values.
* Maps can store primitive wrapper types, strings, and custom objects.

---

# Conclusion

The `put()` method is the primary way to insert data into a Map. Understanding how keys, values, duplicate keys, duplicate values, and `null` values are handled is essential for working with all Map implementations. Mastering this operation provides a strong foundation for the next topics, such as retrieving, updating, and removing entries from a Map.
