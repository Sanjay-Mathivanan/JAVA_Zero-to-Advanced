# Updating Elements in a LinkedHashMap

## Standard Updates

Like HashMap, you can update values using **`replace(key, newValue)`**:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> prices = new LinkedHashMap<>();
        prices.put("Laptop", 999.99);
        prices.put("Phone", 499.99);

        // Update Laptop
        prices.replace("Laptop", 1099.99);

        System.out.println(prices); // Output: {Laptop=1099.99, Phone=499.99}
    }
}
```

---

## Access-Order Modification Behavior

In access-ordered LinkedHashMaps, modifying a key's value counts as an access. This means calling `replace()` or `put()` on an existing key **moves the updated entry to the end** (tail) of the map.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
