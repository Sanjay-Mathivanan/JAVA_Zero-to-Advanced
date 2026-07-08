# Removing Elements from a HashMap

## The `remove(Object key)` Method

The `remove(key)` method deletes the key-value entry from the map and returns the value that was removed (or `null` if the key was absent):

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> servers = new HashMap<>();
        servers.put("ServerA", "Active");
        servers.put("ServerB", "Inactive");

        // 1. Remove by key
        String removedValue = servers.remove("ServerB");
        System.out.println("Removed Value: " + removedValue); // Inactive
        System.out.println(servers); // Output: {ServerA=Active}
    }
}
```

---

## Conditional Removal

You can also use a two-argument version: `remove(Object key, Object value)`. This deletes the entry **only if the key is currently mapped to that exact value**:

```java
// ServerA is active. This call is ignored because the value does not match:
boolean removed = servers.remove("ServerA", "Inactive"); 
System.out.println("Was ServerA removed? " + removed); // false
```

---

## Clearing the Map: `clear()`

To empty the entire map and reset its size to 0, use `clear()`:

```java
servers.clear();
System.out.println("Size after clear: " + servers.size()); // 0
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
