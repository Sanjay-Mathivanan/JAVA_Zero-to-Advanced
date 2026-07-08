# Creating a Hashtable in Java

## Basic Declaration

Declare variables using the parent `Map` interface:

```java
import java.util.Hashtable;
import java.util.Map;

// Map<KeyType, ValueType> map = new Hashtable<>();
Map<String, Integer> balances = new Hashtable<>();
```

---

## Null Value Restriction Warning

> [!WARNING]
> **Hashtable does not allow null keys OR null values.**
> Attempting to insert a null key or null value throws a `NullPointerException` instantly.

```java
// These will throw NullPointerException!
balances.put(null, 500); 
balances.put("Rahul", null);
```

---

## Hashtable Constructors

1. **Default Constructor**: Sets initial capacity to 11 and load factor to 0.75.
   ```java
   Map<String, Integer> map = new Hashtable<>();
   ```
2. **Initial Capacity Constructor**:
   ```java
   Map<String, Integer> map = new Hashtable<>(50);
   ```

---

**Back to HashTable Home:** [HashTable Index](README.md)
