# Basic Operations on a HashMap in Java

## Introduction

Once you have initialized a `HashMap`, you need to manage its data entries. This guide explains how to perform core Map operations—adding key-value pairs, querying keys and values, removing entries, and iterating through the map.

---

## 1. Core CRUD Operations

Java provides straightforward methods for manipulating HashMap entries:

* `put(K key, V value)`: Inserts a key-value pair. If the key already exists, it overrides the old value and returns it.
* `putIfAbsent(K key, V value)`: Inserts the pair only if the key is not already mapped to a value.
* `get(Object key)`: Retrieves the value mapped to `key`, or returns `null` if the key is absent.
* `getOrDefault(Object key, V defaultValue)`: Returns the value for the key, or `defaultValue` if the key is absent.
* `replace(K key, V newValue)`: Updates the value for the specified key only if currently mapped.
* `remove(Object key)`: Removes the entry corresponding to the specified key.

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> contacts = new HashMap<>();

        // 1. Insertion (put)
        contacts.put("Rahul", "9876543210");
        contacts.put("Arun", "9944332211");
        contacts.putIfAbsent("Rahul", "1111122222"); // Will not overwrite

        // 2. Retrieval (get)
        System.out.println("Rahul's Phone: " + contacts.get("Rahul")); // 9876543210
        System.out.println("Unknown Contact: " + contacts.getOrDefault("John", "Not Found")); // Not Found

        // 3. Update (replace)
        contacts.replace("Arun", "8888899999");

        // 4. Removal (remove)
        contacts.remove("Arun");
    }
}
```

---

## 2. Querying Map State

To check state variables or check if specific keys/values are stored:

| Method | Return Type | Description |
| :--- | :--- | :--- |
| `containsKey(Object key)` | `boolean` | Evaluates if the map contains the specified key ($\mathcal{O}(1)$ average complexity). |
| `containsValue(Object val)`| `boolean` | Evaluates if the map has one or more keys mapped to `val` ($\mathcal{O}(N)$ complexity). |
| `size()` | `int` | Returns the total number of active key-value entries. |
| `isEmpty()` | `boolean` | Returns `true` if the entry count is 0. |

---

## 3. Iterating Through a HashMap

There are three primary ways to traverse the elements in a `HashMap`:

### Method A: Iterating Key-Value Entries (`entrySet` - Most Efficient):
```java
// entrySet returns a Set of Map.Entry objects
for (Map.Entry<String, String> entry : contacts.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
```

### Method B: Iterating Keys Only (`keySet`):
```java
for (String name : contacts.keySet()) {
    System.out.println("Name: " + name + ", Phone: " + contacts.get(name)); // DANGER: get() in loop adds redundant lookup cost
}
```

### Method C: Java 8 `forEach` (Concise style):
```java
contacts.forEach((name, phone) -> System.out.println(name + " -> " + phone));
```

---

## Key Takeaways

* Use `put()` to insert or overwrite; use `putIfAbsent()` to prevent overwriting existing keys.
* `getOrDefault()` is a safe way to retrieve values, preventing potential `NullPointerException` errors.
* `containsKey()` operates in constant time ($\mathcal{O}(1)$), while `containsValue()` requires scanning all bucket entries ($\mathcal{O}(N)$).
* Always prefer `entrySet()` over `keySet()` when both keys and values are needed in a loop to avoid redundant map lookups.

---

**Back to Maps Home:** [Map Index](../README.md)
