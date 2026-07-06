# Accessing Values in a Map

# Introduction

After storing key-value pairs in a Map, the next important operation is **retrieving values**.

Unlike a `List`, where elements are accessed using an **index**, a `Map` retrieves values using their **keys**.

Java provides several methods for accessing values stored in a Map, such as:

* `get()`
* `getOrDefault()`
* `containsKey()`
* `containsValue()`

Understanding these methods helps developers safely retrieve data without unnecessary errors.

---

# Learning Objectives

After completing this topic, you will be able to:

* Access values using keys.
* Understand the `get()` method.
* Use `getOrDefault()` for safe retrieval.
* Check whether a key exists.
* Check whether a value exists.
* Handle missing keys correctly.

---

# Problem Statement

Suppose you are developing a **Student Management System**.

The records are stored as:

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

When the user enters:

```text
Student ID = 102
```

The application should display:

```text
Rahul
```

To perform this operation, we need methods that retrieve values using keys.

---

# 1. Accessing Values Using `get()`

The `get()` method returns the value associated with the specified key.

## Syntax

```java
map.get(key);
```

---

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Priya");

        System.out.println(students.get(102));

    }
}
```

---

# Output

```text
Rahul
```

---

# Step-by-Step Explanation

```java
students.get(102);
```

Java performs the following steps:

1. Searches for key `102`.
2. Finds the matching entry.
3. Returns the associated value.

```text
102

↓

Rahul
```

---

# Internal Working

```text
Map

101 → Sanjay

102 → Rahul

103 → Priya

        │

Search Key = 102

        │

        ▼

Return Rahul
```

---

# Accessing a Non-Existing Key

Example

```java
System.out.println(students.get(105));
```

---

# Output

```text
null
```

The key does not exist, so `get()` returns `null`.

---

# 2. Using `getOrDefault()`

The `getOrDefault()` method returns:

* the value if the key exists
* a default value if the key does not exist

---

## Syntax

```java
map.getOrDefault(key, defaultValue);
```

---

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.getOrDefault(105, "Student Not Found"));

    }
}
```

---

# Output

```text
Student Not Found
```

---

# Why Use `getOrDefault()`?

Instead of receiving

```text
null
```

you receive a meaningful message.

This helps prevent unnecessary `null` checks.

---

# 3. Checking a Key Using `containsKey()`

Sometimes we need to verify whether a key exists before retrieving its value.

The `containsKey()` method returns:

* `true`
* `false`

---

## Syntax

```java
map.containsKey(key);
```

---

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.containsKey(102));

        System.out.println(students.containsKey(200));

    }
}
```

---

# Output

```text
true

false
```

---

# Explanation

```text
Key = 102

↓

Found

↓

true
```

```text
Key = 200

↓

Not Found

↓

false
```

---

# 4. Checking a Value Using `containsValue()`

This method checks whether a particular value exists inside the Map.

---

## Syntax

```java
map.containsValue(value);
```

---

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.containsValue("Rahul"));

        System.out.println(students.containsValue("Kavin"));

    }
}
```

---

# Output

```text
true

false
```

---

# Accessing Different Data Types

## Integer → String

```java
Map<Integer, String> students = new HashMap<>();

System.out.println(students.get(101));
```

---

## String → Double

```java
Map<String, Double> products = new HashMap<>();

System.out.println(products.get("Laptop"));
```

---

## Integer → Custom Object

```java
Map<Integer, Student> studentMap = new HashMap<>();

Student student = studentMap.get(101);
```

---

# Memory Representation

Suppose the Map contains

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

Searching

```java
students.get(102);
```

Conceptually

```text
+----------------------------+
|101 → Sanjay                |
+----------------------------+

+----------------------------+
|102 → Rahul                 |
+----------------------------+
          ▲
          │
     Requested Key

+----------------------------+
|103 → Priya                 |
+----------------------------+
```

---

# Comparison of Access Methods

| Method            | Purpose                    | Return Type     |
| ----------------- | -------------------------- | --------------- |
| `get()`           | Retrieves value using key  | Value or `null` |
| `getOrDefault()`  | Retrieves value or default | Value           |
| `containsKey()`   | Checks key existence       | `boolean`       |
| `containsValue()` | Checks value existence     | `boolean`       |

---

# Program Flow

```text
Create Map

      │

      ▼

Store Entries

      │

      ▼

Access Using Key

      │

      ▼

Key Exists?

   ┌────┴────┐
   │         │
 Yes        No
   │         │
   ▼         ▼

Return     Return
Value   null/default
```

---

# Common Mistakes

## Assuming `get()` Throws an Exception

Incorrect assumption:

```text
Missing key causes an exception.
```

Correct:

`get()` simply returns `null`.

---

## Using `containsValue()` Instead of `containsKey()`

Incorrect

```java
map.containsValue(101);
```

Correct

```java
map.containsKey(101);
```

---

## Forgetting to Handle `null`

```java
String name = students.get(200);
```

Always verify that the returned value is not `null` before using it.

---

# Best Practices

* Use `get()` when the key is guaranteed to exist.
* Use `getOrDefault()` for safer retrieval.
* Use `containsKey()` before accessing uncertain keys.
* Avoid unnecessary `containsValue()` calls because searching values is generally slower than searching keys.
* Choose meaningful key types.

---

# Interview Questions

1. Which method retrieves a value from a Map?
2. What happens if the key does not exist?
3. What is the difference between `get()` and `getOrDefault()`?
4. What does `containsKey()` return?
5. What does `containsValue()` return?
6. Can `get()` return `null`?
7. Which method is safer when a key may not exist?
8. Why is searching by key usually faster than searching by value?
9. Can custom objects be retrieved using `get()`?
10. When should `containsKey()` be used?

---

# Practice Programs

1. Retrieve student names using IDs.
2. Use `getOrDefault()` to display a default message.
3. Check whether an employee ID exists.
4. Check whether a product exists in a Map.
5. Retrieve product prices.
6. Store and retrieve custom objects.
7. Build a phone book using `get()`.
8. Display country names using country codes.
9. Demonstrate `containsKey()` and `containsValue()`.
10. Create a menu-driven search application using Map.

---

# Key Takeaways

* `get()` retrieves a value using its key.
* `get()` returns `null` if the key is absent.
* `getOrDefault()` returns a default value when the key is missing.
* `containsKey()` checks whether a key exists.
* `containsValue()` checks whether a value exists.
* Accessing values by key is one of the primary advantages of using a Map.

---

# Conclusion

Retrieving values is one of the most common operations performed on a Map. Java provides multiple methods to access data safely and efficiently, allowing developers to handle both existing and missing keys gracefully. Mastering these methods is essential for building robust applications that rely on fast key-based lookups. In the next chapter, we will learn how to **update existing values in a Map**.
