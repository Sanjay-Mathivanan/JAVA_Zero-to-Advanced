# Removing Entries from a Map

# Introduction

After adding and updating data in a `Map`, there are situations where some entries are no longer required.

For example:

* Removing a student who has graduated.
* Deleting a cancelled order.
* Removing an inactive user.
* Deleting an unavailable product.

Java provides several methods to remove entries safely from a Map.

The most commonly used methods are:

* `remove(key)`
* `remove(key, value)`
* `clear()`

This chapter explains each method with complete examples.

---

# Learning Objectives

After completing this topic, you will be able to:

* Remove entries from a Map.
* Use the `remove()` method.
* Remove entries conditionally.
* Remove all entries using `clear()`.
* Understand the difference between `remove()` and `clear()`.

---

# Problem Statement

Suppose a student management system stores the following records:

```text
101 → Sanjay

102 → Rahul

103 → Priya

104 → Kavin
```

If student **102** leaves the college, that record should be removed from the Map.

---

# Removing an Entry Using `remove(key)`

The simplest way to remove an entry is by specifying its key.

## Syntax

```java
map.remove(key);
```

---

# Example Program

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Priya");

        students.remove(102);

        System.out.println(students);

    }

}
```

---

# Output

```text
{101=Sanjay, 103=Priya}
```

The entry with key **102** has been removed.

---

# Step-by-Step Explanation

Initially

```text
101 → Sanjay

102 → Rahul

103 → Priya
```

Execute

```java
students.remove(102);
```

Result

```text
101 → Sanjay

103 → Priya
```

---

# Internal Working

```text
Map

101 → Sanjay

102 → Rahul

103 → Priya

        │

Remove Key = 102

        │

        ▼

101 → Sanjay

103 → Priya
```

---

# Return Value of `remove(key)`

The method returns:

* Removed value, if the key exists.
* `null`, if the key does not exist.

Example

```java
String removed = students.remove(102);

System.out.println(removed);
```

Output

```text
Rahul
```

---

# Removing a Non-Existing Key

```java
System.out.println(students.remove(500));
```

Output

```text
null
```

No exception is thrown.

---

# Removing Using `remove(key, value)`

Sometimes we want to remove an entry only if both the key and value match.

## Syntax

```java
map.remove(key, value);
```

---

# Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        boolean removed = students.remove(102, "Rahul");

        System.out.println(removed);

        System.out.println(students);

    }

}
```

---

# Output

```text
true

{101=Sanjay}
```

---

# Failed Removal

```java
students.remove(102, "Kavin");
```

Output

```text
false
```

Reason:

The key exists, but the value does not match.

---

# Removing All Entries Using `clear()`

The `clear()` method removes every entry from the Map.

## Syntax

```java
map.clear();
```

---

# Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");
        students.put(103, "Priya");

        students.clear();

        System.out.println(students);

    }

}
```

---

# Output

```text
{}
```

The Map becomes empty.

---

# Checking Whether the Map Is Empty

```java
students.clear();

System.out.println(students.isEmpty());
```

Output

```text
true
```

---

# Removing Entries of Different Types

## Integer → String

```java
Map<Integer, String> students = new HashMap<>();

students.remove(101);
```

---

## String → Double

```java
Map<String, Double> products = new HashMap<>();

products.remove("Laptop");
```

---

## Integer → Custom Object

```java
Map<Integer, Student> studentMap = new HashMap<>();

studentMap.remove(101);
```

---

# Memory Representation

Before removal

```text
+---------------------------+
|101 → Sanjay               |
+---------------------------+

+---------------------------+
|102 → Rahul                |
+---------------------------+

+---------------------------+
|103 → Priya                |
+---------------------------+
```

After

```java
students.remove(102);
```

```text
+---------------------------+
|101 → Sanjay               |
+---------------------------+

+---------------------------+
|103 → Priya                |
+---------------------------+
```

---

# Comparison of Removal Methods

| Method               | Description                         | Return Type             |
| -------------------- | ----------------------------------- | ----------------------- |
| `remove(key)`        | Removes entry using key             | Removed value or `null` |
| `remove(key, value)` | Removes only if key and value match | `boolean`               |
| `clear()`            | Removes all entries                 | `void`                  |

---

# Program Flow

```text
Create Map

      │

      ▼

Choose Remove Method

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

Remove   No Change

      │

      ▼

Updated Map
```

---

# Common Mistakes

## Assuming `remove()` Throws an Exception

Incorrect assumption

```text
Removing a missing key causes an error.
```

Correct

`remove()` simply returns `null`.

---

## Using the Wrong Value

```java
students.remove(102, "Arun");
```

If the stored value is `"Rahul"`, nothing is removed.

---

## Forgetting `clear()`

Some beginners remove every entry individually.

Instead, use

```java
map.clear();
```

---

# Best Practices

* Use `remove(key)` for normal deletion.
* Use `remove(key, value)` when validation is required.
* Use `clear()` to remove every entry.
* Check `isEmpty()` after clearing the Map if necessary.
* Verify key existence using `containsKey()` when appropriate.

---

# Interview Questions

1. Which method removes an entry using its key?
2. What does `remove(key)` return?
3. What happens if the key does not exist?
4. What is the purpose of `remove(key, value)`?
5. What does `remove(key, value)` return?
6. Which method removes all entries from a Map?
7. Does `clear()` delete the Map object?
8. How do you check whether a Map is empty?
9. Can custom objects be removed from a Map?
10. What is the difference between `remove()` and `clear()`?

---

# Practice Programs

1. Remove a student using Student ID.
2. Remove a product using Product ID.
3. Demonstrate conditional removal.
4. Remove all entries from a Map.
5. Display the removed value.
6. Check whether a Map is empty after `clear()`.
7. Remove employee records.
8. Build a menu-driven delete operation.
9. Remove custom objects from a Map.
10. Compare `remove()` and `clear()`.

---

# Key Takeaways

* `remove(key)` removes an entry using its key.
* `remove(key)` returns the removed value or `null`.
* `remove(key, value)` removes an entry only when both match.
* `clear()` removes all entries from the Map.
* `isEmpty()` checks whether the Map contains any entries.
* Removing entries is an essential operation for maintaining dynamic data.

---

# Conclusion

Removing entries is an important part of managing data stored in a Map. Java provides flexible methods to delete individual entries, perform conditional removal, or clear the entire Map. Choosing the appropriate removal method helps keep your applications clean, efficient, and easy to maintain. In the next chapter, we will explore the various **Map utility methods** such as `size()`, `isEmpty()`, `keySet()`, `values()`, and `entrySet()`.
