# Accessing Elements in a TreeMap

## The `get()` Method

Retrieval is identical to standard maps:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> scores = new TreeMap<>();
        scores.put(1, "Gold");
        scores.put(2, "Silver");

        System.out.println(scores.get(1)); // Output: Gold
    }
}
```

---

## Null Key Warning

> [!WARNING]
> **TreeMap does not allow `null` keys.**
> If you try to insert or fetch a `null` key, Java throws a `NullPointerException` because it cannot compare `null` with other values:

```java
// Throws NullPointerException!
scores.put(null, "Bronze"); 
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
