# Creating a LinkedHashMap

## Basic Declaration

Like `HashMap`, declare variables using the parent `Map` interface:

```java
import java.util.LinkedHashMap;
import java.util.Map;

// Map<KeyType, ValueType> map = new LinkedHashMap<>();
Map<String, String> contacts = new LinkedHashMap<>();
```

Ensure you use Wrapper types instead of primitives for keys and values.

---

## LinkedHashMap Constructors

1. **Default Constructor**: Sets initial capacity to 16, load factor to 0.75, and insertion-order mode.
   ```java
   Map<String, String> map = new LinkedHashMap<>();
   ```
2. **Initial Capacity Constructor**:
   ```java
   Map<String, String> map = new LinkedHashMap__(32);
   ```
3. **Access-Order Constructor**:
   If the third argument is set to `true`, the map uses **access-order** instead of insertion-order:
   ```java
   LinkedHashMap<String, String> map = new LinkedHashMap<>(16, 0.75f, true);
   ```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
