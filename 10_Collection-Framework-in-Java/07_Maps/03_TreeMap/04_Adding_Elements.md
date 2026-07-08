# Adding Elements to a TreeMap

## The `put()` Method

When you call **`put(key, value)`**, the map traverses the internal binary tree to find the correct sorted position for the new key:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> directory = new TreeMap<>();

        // Inserting elements in random order
        directory.put("C", "Charlie");
        directory.put("A", "Alpha");
        directory.put("B", "Bravo");

        // The printed output is sorted by key
        System.out.println(directory); // Output: {A=Alpha, B=Bravo, C=Charlie}
    }
}
```

---

## Overwriting Keys

Overwriting a value uses the same key:

```java
directory.put("A", "New Alpha");
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
