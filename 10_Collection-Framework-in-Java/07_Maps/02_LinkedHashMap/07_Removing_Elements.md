# Removing Elements from a LinkedHashMap

## The `remove()` Method

Use **`remove(key)`** to delete a key-value entry. This also removes the node from the internal doubly linked list, preserving the correct traversal sequence for the remaining elements:

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

## Clear the Map: `clear()`

To empty the entire map at once, use `clear()`:

```java
map.clear();
System.out.println("Size: " + map.size()); // Size: 0
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
