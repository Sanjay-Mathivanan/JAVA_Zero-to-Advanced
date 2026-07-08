# Removing Elements from a TreeMap

## The `remove()` Method

Use **`remove(key)`** to delete a key-value entry. This triggers internal tree balancing operations (rotations/recoloring) to maintain the tree invariants:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
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

**Back to TreeMap Home:** [TreeMap Index](README.md)
