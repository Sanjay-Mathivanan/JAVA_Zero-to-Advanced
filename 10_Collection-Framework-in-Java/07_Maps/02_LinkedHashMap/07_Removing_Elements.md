# Removing Elements from a LinkedHashMap

## The `remove(Object key)` Method

The `remove(key)` method deletes the key-value entry from the map and detaches it from the internal doubly linked list by updating adjacent node pointers:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("A", "Apple");
        map.put("B", "Banana");
        map.put("C", "Cherry");

        // Removing key "B"
        map.remove("B");

        System.out.println(map); // Output: {A=Apple, C=Cherry}
    }
}
```

---

## Cleaning the Map: `clear()`

To empty the entire map and reset its size to 0, use `clear()`:

```java
map.clear();
System.out.println("Size after clear: " + map.size()); // 0
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
