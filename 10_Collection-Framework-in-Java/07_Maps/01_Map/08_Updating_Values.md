# Updating Values in a Map

# Introduction

After storing key-value pairs in a `Map`, there are situations where the value associated with an existing key needs to be changed.

For example:

* Updating an employee's salary.
* Changing a student's marks.
* Updating a product price.
* Modifying a customer's address.

Java provides multiple methods to update values stored in a Map, including:

* `put()`
* `replace()`
* `replace(key, oldValue, newValue)`
* `replaceAll()`

This chapter explains each method with examples and their internal working.

---

# Learning Objectives

After completing this topic, you will be able to:

* Update existing values in a Map.
* Understand how the `put()` method updates values.
* Use the `replace()` method.
* Use conditional replacement.
* Update all values using `replaceAll()`.
* Understand the difference between `put()` and `replace()`.

---

# Problem Statement

Suppose you are developing a **Product Management System**.

Initially, products are stored as:

```text
101 → Laptop

102 → Mouse

103 → Keyboard
```

Later, the product name or price needs to be updated.

Instead of removing and inserting the entry again, Java provides methods for updating values directly.

---

# 1. Updating Using `put()`

The `put()` method not only inserts new entries but also updates the value if the key already exists.

## Syntax

```java
map.put(key, newValue);
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

        students.put(102, "Arun");

        System.out.println(students);
    }
}
```

---

# Output

```text
{101=Sanjay, 102=Arun}
```

---

# Explanation

Initially

```text
101 → Sanjay

102 → Rahul
```

After

```java
students.put(102, "Arun");
```

The value is updated.

```text
101 → Sanjay

102 → Arun
```

The key remains unchanged.

---

# Internal Working

```text
Search Key

102

      │

      ▼

Key Found?

      │
      ▼

Replace Old Value

Rahul

      │

      ▼

Arun
```

---

# 2. Updating Using `replace()`

The `replace()` method updates the value **only if the key already exists**.

## Syntax

```java
map.replace(key, newValue);
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

        students.replace(102, "Kavin");

        System.out.println(students);
    }
}
```

---

# Output

```text
{101=Sanjay, 102=Kavin}
```

---

# What If the Key Doesn't Exist?

```java
students.replace(200, "John");
```

Nothing happens because key **200** does not exist.

Output

```text
{101=Sanjay, 102=Rahul}
```

---

# Difference Between `put()` and `replace()`

| Method      | Existing Key  | Missing Key       |
| ----------- | ------------- | ----------------- |
| `put()`     | Updates value | Creates new entry |
| `replace()` | Updates value | Does nothing      |

---

# 3. Conditional Update Using `replace()`

Java also provides a conditional version of `replace()`.

The value is updated **only if both the key and the existing value match**.

## Syntax

```java
map.replace(key, oldValue, newValue);
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

        boolean updated = students.replace(102, "Rahul", "Kavin");

        System.out.println(updated);
        System.out.println(students);
    }
}
```

---

# Output

```text
true

{101=Sanjay, 102=Kavin}
```

---

# Failed Update

```java
students.replace(102, "Arun", "Kavin");
```

Output

```text
false
```

Reason:

The current value is not `"Arun"`.

---

# 4. Updating All Values Using `replaceAll()`

The `replaceAll()` method updates every value in the Map.

## Syntax

```java
map.replaceAll((key, value) -> newValue);
```

---

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> marks = new HashMap<>();

        marks.put("Math", 80);
        marks.put("Science", 90);
        marks.put("English", 75);

        marks.replaceAll((subject, score) -> score + 5);

        System.out.println(marks);
    }
}
```

---

# Output

```text
{Math=85, Science=95, English=80}
```

Every student's score is increased by **5 marks**.

---

# Updating Different Data Types

## String Values

```java
Map<Integer, String> students = new HashMap<>();

students.replace(101, "Rahul");
```

---

## Integer Values

```java
Map<String, Integer> marks = new HashMap<>();

marks.replace("Math", 95);
```

---

## Double Values

```java
Map<String, Double> products = new HashMap<>();

products.replace("Laptop", 60000.00);
```

---

## Custom Objects

```java
Map<Integer, Student> students = new HashMap<>();

students.replace(101, new Student("Sanjay", 95));
```

---

# Memory Representation

Before update

```text
+--------------------------+
|101 → Sanjay              |
+--------------------------+

+--------------------------+
|102 → Rahul               |
+--------------------------+
```

After

```java
students.replace(102, "Arun");
```

```text
+--------------------------+
|101 → Sanjay              |
+--------------------------+

+--------------------------+
|102 → Arun                |
+--------------------------+
```

Only the value changes.

The key remains the same.

---

# Program Flow

```text
Create Map

      │

      ▼

Search Key

      │

      ▼

Key Exists?

  ┌────┴────┐
  │         │
 Yes       No
  │         │
  ▼         ▼

Update   Ignore or
Value    Create Entry
          (put())

      │

      ▼

Map Updated
```

---

# Comparison of Update Methods

| Method                             | Updates Existing Key   | Creates New Entry | Returns                  |
| ---------------------------------- | ---------------------- | ----------------- | ------------------------ |
| `put()`                            | Yes                    | Yes               | Previous value or `null` |
| `replace(key, value)`              | Yes                    | No                | Previous value or `null` |
| `replace(key, oldValue, newValue)` | Yes (if value matches) | No                | `boolean`                |
| `replaceAll()`                     | Updates all entries    | No                | `void`                   |

---

# Common Mistakes

## Assuming `replace()` Creates a New Entry

Incorrect assumption:

```text
replace() inserts new keys.
```

Correct:

`replace()` only works if the key already exists.

---

## Forgetting That `put()` Can Update Values

Many beginners think `put()` only inserts data.

It also replaces the value when the key already exists.

---

## Using the Wrong Old Value

```java
students.replace(102, "Arun", "Kavin");
```

If the current value is `"Rahul"`, the update fails.

---

# Best Practices

* Use `replace()` when the key must already exist.
* Use `put()` when insertion and updating are both acceptable.
* Use conditional `replace()` for safe updates.
* Use `replaceAll()` for bulk modifications.
* Verify keys using `containsKey()` before updating uncertain entries.

---

# Interview Questions

1. Which method is commonly used to update values in a Map?
2. Does `put()` insert or update?
3. What is the difference between `put()` and `replace()`?
4. When does `replace()` fail?
5. What does `replace(key, oldValue, newValue)` return?
6. What is the purpose of `replaceAll()`?
7. Can `replace()` create a new key?
8. Which method updates every value in a Map?
9. How can you safely update a value only when the old value matches?
10. Which update method would you choose for bulk modifications?

---

# Practice Programs

1. Update a student's name using `put()`.
2. Update a product price using `replace()`.
3. Demonstrate conditional replacement.
4. Increase all marks using `replaceAll()`.
5. Update employee salaries.
6. Modify values in a phone directory.
7. Update custom objects stored in a Map.
8. Compare `put()` and `replace()`.
9. Build a menu-driven update application.
10. Demonstrate bulk updates using lambda expressions.

---

# Key Takeaways

* `put()` inserts new entries and updates existing values.
* `replace()` updates values only when the key exists.
* Conditional `replace()` updates only when both the key and old value match.
* `replaceAll()` updates every value in the Map.
* Choosing the correct update method improves code readability and prevents unintended modifications.

---

# Conclusion

Updating values is an essential operation when working with Maps. Java provides multiple update methods to handle different scenarios, ranging from simple value replacement to conditional updates and bulk modifications. Understanding these methods allows developers to write safer, more efficient, and more maintainable applications. In the next chapter, we will explore **removing key-value pairs from a Map** using methods such as `remove()` and `clear()`.
