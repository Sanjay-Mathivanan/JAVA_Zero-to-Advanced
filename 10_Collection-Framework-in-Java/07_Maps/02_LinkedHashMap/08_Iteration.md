# Iterating Through a LinkedHashMap

## Preserving Order During Traversal

When you loop through a `LinkedHashMap`, Java traverses the internal doubly linked list. This guarantees that elements are printed in the exact order they were inserted:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("Apples", 50);
        items.put("Bananas", 30);
        items.put("Oranges", 20);

        // entrySet iteration - guaranteed insertion order
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // Output:
        // Apples -> 50
        // Bananas -> 30
        // Oranges -> 20
    }
}
```

---

## Other Traversal Loops

* **KeySet iteration**: `for (String key : items.keySet())` (traverses keys in order).
* **Lambda iteration**: `items.forEach((key, val) -> ...)` (runs in order).

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
