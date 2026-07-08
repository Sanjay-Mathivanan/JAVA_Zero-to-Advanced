# Accessing Elements in a HashMap

## The `get()` Method

To fetch a value from the map, pass its unique key to the **`get(key)`** method:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> capitals = new HashMap<>();
        capitals.put("India", "New Delhi");
        capitals.put("Japan", "Tokyo");

        // 1. Accessing existing key
        String capital = capitals.get("India");
        System.out.println("Capital of India: " + capital); // Output: New Delhi

        // 2. Accessing non-existing key
        String unknown = capitals.get("USA");
        System.out.println("Capital of USA: " + unknown); // Output: null
    }
}
```

---

## Preventing Nulls: `getOrDefault()`

If a key is not present, `get()` returns `null`. This can cause a `NullPointerException` if you try to perform actions on the output.

To prevent this, use **`getOrDefault(key, defaultValue)`**, which returns a custom default fallback value instead of `null`:

```java
// USA is not in the map, so it returns "Not Specified"
String result = capitals.getOrDefault("USA", "Not Specified");

System.out.println("Capital of USA: " + result); // Output: Not Specified
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
