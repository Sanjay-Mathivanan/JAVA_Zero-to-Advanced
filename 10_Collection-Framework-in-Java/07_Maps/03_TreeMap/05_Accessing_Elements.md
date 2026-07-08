# Accessing Elements in a TreeMap

## Standard Retrieval

Retrieving elements uses the standard **`get(key)`** method:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> codes = new TreeMap<>();
        codes.put(100, "Success");

        System.out.println(codes.get(100)); // Output: Success
    }
}
```

---

## Null Key Restriction

> [!WARNING]
> **TreeMap does not permit null keys.**
> Attempting to insert or access a null key throws a `NullPointerException` because the map must compare keys to navigate the binary tree:

```java
// Throws NullPointerException!
codes.put(null, "Failure"); 
```

*(Null values are permitted).*

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
