# Updating Elements in a TreeMap

## Standard Updates

Like other map implementations, you can update values using **`replace(key, newValue)`**:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stock = new TreeMap<>();
        stock.put("Apples", 50);

        // Update Apples
        stock.replace("Apples", 45);

        System.out.println(stock); // Output: {Apples=45}
    }
}
```

---

## Behavior Notes

Modifying a value in a `TreeMap` **does not change the sorted position of the key**, because sorting is determined by the key itself, not the value.

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
