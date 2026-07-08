# Iterating Through a TreeMap

## Sorted Traversal

When iterating through a `TreeMap`, Java performs an **in-order traversal** of the underlying binary tree. This guarantees that elements are accessed in ascending sorted key order:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> scores = new TreeMap<>();
        scores.put(90, "Rahul");
        scores.put(75, "Arun");
        scores.put(85, "Priya");

        // Iteration displays elements sorted by key
        for (Map.Entry<Integer, String> entry : scores.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        // Output:
        // 75 -> Arun
        // 85 -> Priya
        // 90 -> Rahul
    }
}
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
