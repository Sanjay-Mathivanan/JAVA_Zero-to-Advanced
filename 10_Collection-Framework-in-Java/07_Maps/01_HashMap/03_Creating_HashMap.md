# Creating a HashMap in Java

## Basic Initialization

To declare a `HashMap`, specify the types for both keys and values using generics:

```java
import java.util.HashMap;
import java.util.Map;

// Generic format: Map<KeyType, ValueType> map = new HashMap<>();
Map<String, Integer> studentGrades = new HashMap<>();
```

Always use the parent `Map` interface type for the reference variable rather than the concrete implementation `HashMap` to allow switching implementations later if needed:

* **Good Practice**: `Map<String, Integer> map = new HashMap<>();`
* **Bad Practice**: `ArrayList` / `HashMap` concrete variables directly e.g. `HashMap<String, Integer> map = new HashMap<>();`

---

## Type Constraints: Primitives vs. Wrappers

Generics do not support primitive types directly. If you need key-value maps of primitive values (like `int` or `double`), use their wrapper class equivalents:

| Primitive Type | Generic Wrapper Type |
| :--- | :--- |
| `int` | `Integer` |
| `double` | `Double` |
| `char` | `Character` |
| `boolean` | `Boolean` |

```java
// Correct: Autoboxing automatically handles conversion
Map<Integer, Double> measurements = new HashMap<>();
measurements.put(1, 98.6); 
```

---

## HashMap Constructors

`HashMap` provides four constructors:

1. **Default Constructor**: Sets initial capacity to 16 and load factor to 0.75.
   ```java
   Map<String, String> map = new HashMap<>();
   ```
2. **Initial Capacity Constructor**: Specifies the starting capacity. Use when the amount of data is known to prevent costly rehashing.
   ```java
   Map<String, String> map = new HashMap<>(100);
   ```
3. **Capacity & Load Factor Constructor**:
   ```java
   Map<String, String> map = new HashMap<>(100, 0.8f);
   ```
4. **Copy Constructor**: Imports elements from an existing map.
   ```java
   Map<String, String> map = new HashMap<>(existingMap);
   ```

---

**Back to HashMap Home:** [HashMap Index](README.md)
