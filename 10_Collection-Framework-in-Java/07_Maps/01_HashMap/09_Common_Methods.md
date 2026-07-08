# Common Query Methods in HashMap

## 1. Key Existence Check: `containsKey(Object key)`

To check if a specific key is stored in the map:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> cache = new HashMap<>();
        cache.put("session_id", "XYZ123");

        if (cache.containsKey("session_id")) {
            System.out.println("Session key exists.");
        }
    }
}
```

---

## 2. Value Existence Check: `containsValue(Object value)`

To check if a specific value exists:

```java
if (cache.containsValue("XYZ123")) {
    System.out.println("Session value exists.");
}
```

> [!IMPORTANT]
> **Performance Complexity Difference:**
> * `containsKey()` is incredibly fast, running in constant time (`O(1)`).
> * `containsValue()` is slow, running in linear time (`O(N)`), because the JVM must search through every bucket sequentially.

---

## 3. Size Queries: `size()` & `isEmpty()`

* **`size()`**: Returns the total number of entries.
* **`isEmpty()`**: Returns `true` if the map has 0 elements.

```java
System.out.println("Total items: " + cache.size()); // 1
System.out.println("Is empty? " + cache.isEmpty()); // false
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
