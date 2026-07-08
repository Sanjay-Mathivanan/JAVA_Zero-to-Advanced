# Accessing Elements in a HashMap

## The `get(Object key)` Method

To retrieve a value associated with a key, use the `get()` method. If the key is not found, `get()` returns `null`:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dict = new HashMap<>();
        dict.put("Java", "A programming language");

        // 1. Existing key lookup
        String definition = dict.get("Java");
        System.out.println("Java definition: " + definition); // A programming language

        // 2. Missing key lookup
        String missing = dict.get("Python");
        System.out.println("Python definition: " + missing); // null
    }
}
```

---

## Safe Retrieval: `getOrDefault(Object key, V defaultValue)`

To prevent `NullPointerException` errors when working with potentially missing keys, use `getOrDefault()`. It returns a specified fallback value if the key is absent:

```java
// Python is missing, so it returns the default "Definition not found"
String pythonDef = dict.getOrDefault("Python", "Definition not found");

System.out.println("Python: " + pythonDef); // Output: Definition not found
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
