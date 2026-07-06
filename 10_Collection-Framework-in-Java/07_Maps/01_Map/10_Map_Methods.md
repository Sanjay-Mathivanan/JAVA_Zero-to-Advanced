# Map Methods in Java

## Introduction

The **Map** interface provides several built-in methods to perform operations such as adding, retrieving, updating, removing, and checking key-value pairs.

Instead of writing custom logic for every operation, Java provides ready-made methods that make working with Maps simple and efficient.

This chapter introduces the most commonly used Map methods with examples.

---

# Learning Objectives

After completing this chapter, you will be able to:

* Understand commonly used Map methods.
* Add and retrieve key-value pairs.
* Check whether keys and values exist.
* Determine the size of a Map.
* Check whether a Map is empty.
* Insert entries only when keys are absent.

---

# Problem Statement

Suppose a **Student Management System** stores student records in a Map.

```text id="eh8jdf"
101 → Sanjay

102 → Rahul

103 → Priya
```

The application should be able to:

* Count the number of students.
* Check whether the Map is empty.
* Find a student using the ID.
* Verify whether a student exists.
* Add new students safely.

Java provides built-in methods to perform all these operations.

---

# Commonly Used Map Methods (Part 1)

| Method            | Purpose                                      |
| ----------------- | -------------------------------------------- |
| `size()`          | Returns the number of entries                |
| `isEmpty()`       | Checks whether the Map is empty              |
| `containsKey()`   | Checks whether a key exists                  |
| `containsValue()` | Checks whether a value exists                |
| `get()`           | Retrieves the value using a key              |
| `getOrDefault()`  | Retrieves a value or returns a default value |
| `put()`           | Adds or updates an entry                     |
| `putIfAbsent()`   | Adds an entry only if the key is absent      |

---

# 1. `size()`

Returns the total number of key-value pairs stored in the Map.

## Syntax

```java
map.size();
```

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

        System.out.println(students.size());

    }

}
```

### Output

```text
3
```

---

# 2. `isEmpty()`

Checks whether the Map contains any entries.

## Syntax

```java
map.isEmpty();
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        System.out.println(students.isEmpty());

        students.put(101, "Sanjay");

        System.out.println(students.isEmpty());

    }

}
```

### Output

```text
true

false
```

---

# 3. `containsKey()`

Checks whether a specified key exists.

## Syntax

```java
map.containsKey(key);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.containsKey(101));

        System.out.println(students.containsKey(200));

    }

}
```

### Output

```text
true

false
```

---

# Internal Working

```text
Search Key

101

     │

     ▼

Found?

     │

 ┌───┴───┐
 │       │
Yes      No
 │       │
 ▼       ▼

true   false
```

---

# 4. `containsValue()`

Checks whether a specified value exists in the Map.

## Syntax

```java
map.containsValue(value);
```

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

### Output

```text
true

false
```

---

# 5. `get()`

Retrieves the value associated with the specified key.

## Syntax

```java
map.get(key);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.get(102));

    }

}
```

### Output

```text
Rahul
```

---

## When the Key Doesn't Exist

```java
System.out.println(students.get(500));
```

Output

```text
null
```

---

# Memory Representation

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

# 6. `getOrDefault()`

Returns the associated value if the key exists.

Otherwise, returns a default value.

## Syntax

```java
map.getOrDefault(key, defaultValue);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");

        System.out.println(
                students.getOrDefault(200, "Student Not Found"));

    }

}
```

### Output

```text
Student Not Found
```

---

# Comparison

| Method           | Missing Key Result                  |
| ---------------- | ----------------------------------- |
| `get()`          | `null`                              |
| `getOrDefault()` | Returns the specified default value |

---

# 7. `put()`

Adds a new key-value pair.

If the key already exists, the old value is replaced.

## Syntax

```java
map.put(key, value);
```

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

### Output

```text
{101=Sanjay, 102=Arun}
```

---

# Internal Working

```text
Insert

102 → Rahul

       │

Duplicate Key?

       │

      Yes

       │

Replace Value

       │

102 → Arun
```

---

# 8. `putIfAbsent()`

Adds an entry only if the key does not already exist.

## Syntax

```java
map.putIfAbsent(key, value);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");

        students.putIfAbsent(101, "Rahul");

        students.putIfAbsent(102, "Priya");

        System.out.println(students);

    }

}
```

### Output

```text
{101=Sanjay, 102=Priya}
```

---

# Explanation

The first call

```java
students.putIfAbsent(101, "Rahul");
```

does nothing because key `101` already exists.

The second call

```java
students.putIfAbsent(102, "Priya");
```

adds a new entry because key `102` is not present.

---

# Program Flow

```text
Create Map

      │

      ▼

Choose Method

      │

      ▼

Perform Operation

      │

      ▼

Map Updated

      │

      ▼

Return Result
```

---

# Common Mistakes

### Using `get()` Without Checking for `null`

Always verify whether the returned value is `null` before using it.

---

### Assuming `put()` Only Inserts Data

The `put()` method also updates existing values.

---

### Confusing `containsKey()` and `containsValue()`

* `containsKey()` searches keys.
* `containsValue()` searches values.

---

# Best Practices

* Use `containsKey()` before retrieving uncertain keys.
* Use `getOrDefault()` when a missing key is expected.
* Use `putIfAbsent()` to avoid accidental overwriting.
* Use meaningful key types.
* Prefer the `Map` interface for declarations.

---
# 9. `replace()`

The `replace()` method updates the value of an existing key.

If the key does not exist, nothing happens.

## Syntax

```java
map.replace(key, newValue);
```

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

### Output

```text
{101=Sanjay, 102=Kavin}
```

---

# 10. `replaceAll()`

Updates every value in the Map.

## Syntax

```java
map.replaceAll((key, value) -> newValue);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, Integer> marks = new HashMap<>();

        marks.put("Math", 80);
        marks.put("Science", 90);

        marks.replaceAll((subject, score) -> score + 5);

        System.out.println(marks);

    }

}
```

### Output

```text
{Math=85, Science=95}
```

---

# 11. `remove()`

Removes a key-value pair.

## Syntax

```java
map.remove(key);
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        students.remove(101);

        System.out.println(students);

    }

}
```

### Output

```text
{102=Rahul}
```

---

# 12. `clear()`

Removes all entries from the Map.

## Syntax

```java
map.clear();
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        students.clear();

        System.out.println(students);

    }

}
```

### Output

```text
{}
```

---

# 13. `keySet()`

Returns all keys in the Map.

## Syntax

```java
map.keySet();
```

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

        System.out.println(students.keySet());

    }

}
```

### Output

```text
[101, 102, 103]
```

---

# 14. `values()`

Returns all values stored in the Map.

## Syntax

```java
map.values();
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        System.out.println(students.values());

    }

}
```

### Output

```text
[Sanjay, Rahul]
```

---

# 15. `entrySet()`

Returns all key-value pairs as `Map.Entry` objects.

## Syntax

```java
map.entrySet();
```

## Example

```java
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(101, "Sanjay");
        students.put(102, "Rahul");

        for (Map.Entry<Integer, String> entry : students.entrySet()) {

            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }

    }

}
```

### Output

```text
101 -> Sanjay
102 -> Rahul
```

---

# 16. `forEach()`

Traverses every key-value pair using a lambda expression.

## Syntax

```java
map.forEach((key, value) -> {
    // code
});
```

## Example

```java
students.forEach((id, name) ->
        System.out.println(id + " : " + name));
```

### Output

```text
101 : Sanjay
102 : Rahul
```

---

# 17. `compute()`

Updates the value using a computation.

## Syntax

```java
map.compute(key, (k, v) -> newValue);
```

## Example

```java
Map<String, Integer> marks = new HashMap<>();

marks.put("Math", 80);

marks.compute("Math", (subject, score) -> score + 10);

System.out.println(marks);
```

### Output

```text
{Math=90}
```

---

# 18. `computeIfAbsent()`

Computes a value only if the key is not present.

## Syntax

```java
map.computeIfAbsent(key, k -> value);
```

## Example

```java
Map<Integer, String> students = new HashMap<>();

students.computeIfAbsent(101, k -> "Sanjay");

System.out.println(students);
```

### Output

```text
{101=Sanjay}
```

---

# 19. `computeIfPresent()`

Computes a value only if the key already exists.

## Syntax

```java
map.computeIfPresent(key, (k, v) -> newValue);
```

## Example

```java
Map<Integer, String> students = new HashMap<>();

students.put(101, "Sanjay");

students.computeIfPresent(101, (k, v) -> "Rahul");

System.out.println(students);
```

### Output

```text
{101=Rahul}
```

---

# 20. `merge()`

Merges values associated with a key.

## Syntax

```java
map.merge(key, value,
          (oldValue, newValue) -> mergedValue);
```

## Example

```java
Map<String, Integer> fruits = new HashMap<>();

fruits.put("Apple", 5);

fruits.merge("Apple", 3, Integer::sum);

System.out.println(fruits);
```

### Output

```text
{Apple=8}
```

---

# Comparison of Important Map Methods

| Method               | Purpose                         | Return Type           |
| -------------------- | ------------------------------- | --------------------- |
| `size()`             | Number of entries               | `int`                 |
| `isEmpty()`          | Checks whether the Map is empty | `boolean`             |
| `containsKey()`      | Checks key existence            | `boolean`             |
| `containsValue()`    | Checks value existence          | `boolean`             |
| `get()`              | Retrieves value                 | Value                 |
| `getOrDefault()`     | Retrieves value or default      | Value                 |
| `put()`              | Adds or updates entry           | Previous value        |
| `putIfAbsent()`      | Adds only if key is absent      | Previous value        |
| `replace()`          | Updates value                   | Previous value        |
| `replaceAll()`       | Updates all values              | `void`                |
| `remove()`           | Removes entry                   | Removed value         |
| `clear()`            | Removes all entries             | `void`                |
| `keySet()`           | Returns all keys                | `Set<K>`              |
| `values()`           | Returns all values              | `Collection<V>`       |
| `entrySet()`         | Returns all entries             | `Set<Map.Entry<K,V>>` |
| `forEach()`          | Traverses Map                   | `void`                |
| `compute()`          | Computes new value              | Value                 |
| `computeIfAbsent()`  | Computes if key absent          | Value                 |
| `computeIfPresent()` | Computes if key exists          | Value                 |
| `merge()`            | Combines values                 | Value                 |

---

# Program Flow

```text
Create Map
      │
      ▼
Add Entries
      │
      ▼
Retrieve / Update / Remove
      │
      ▼
Traverse Entries
      │
      ▼
Clear Map (Optional)
      │
      ▼
End
```

---

# Common Mistakes

### Using `get()` Without Checking for `null`

Always verify that the returned value is not `null` before using it.

---

### Assuming `replace()` Inserts New Keys

`replace()` only updates existing keys.

---

### Confusing `keySet()` and `values()`

* `keySet()` returns only keys.
* `values()` returns only values.

---

### Modifying a Map While Iterating Incorrectly

When iterating through a Map, avoid directly modifying it unless using the appropriate iterator methods or safe APIs.

---

# Best Practices

* Use `entrySet()` when both keys and values are required.
* Use `containsKey()` before accessing uncertain keys.
* Prefer `getOrDefault()` over manual `null` checks.
* Use `putIfAbsent()` to prevent accidental overwriting.
* Choose the appropriate Map implementation based on your requirements.
* Declare variables using the `Map` interface.

---

# Interview Questions

1. Which method returns the number of entries in a Map?
2. What is the difference between `get()` and `getOrDefault()`?
3. What does `putIfAbsent()` do?
4. What is the difference between `replace()` and `put()`?
5. Which method returns all keys?
6. Which method returns all values?
7. Why is `entrySet()` preferred for iteration?
8. What is the purpose of `computeIfAbsent()`?
9. What does the `merge()` method do?
10. Which Map method removes all entries?

---

# Practice Programs

1. Display all keys using `keySet()`.
2. Display all values using `values()`.
3. Traverse a Map using `entrySet()`.
4. Use `forEach()` with lambda expressions.
5. Update values using `replace()`.
6. Remove entries using `remove()`.
7. Demonstrate `computeIfAbsent()`.
8. Demonstrate `computeIfPresent()`.
9. Use `merge()` to combine values.
10. Build a menu-driven Map application using multiple methods.

---

# Key Takeaways

* The `Map` interface provides a rich set of methods for managing key-value pairs.
* `entrySet()` is the most efficient way to iterate over both keys and values.
* `compute()` and `merge()` simplify value updates.
* `putIfAbsent()` helps prevent accidental overwriting.
* Choosing the appropriate method improves code readability and performance.

---

# Conclusion

The methods provided by the `Map` interface make it easy to perform common operations such as insertion, retrieval, updating, removal, traversal, and bulk processing. By understanding when and how to use these methods, you can build efficient and maintainable Java applications. Mastering these APIs is essential before moving on to specific implementations such as `HashMap`, `LinkedHashMap`, and `TreeMap`, where the behavior and performance of these methods become even more important.

