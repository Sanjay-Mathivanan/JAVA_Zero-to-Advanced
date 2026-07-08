# Updating Elements in a LinkedHashMap

## The `replace()` Method

Updating values is identical to HashMap. Use the **`replace(key, newValue)`** method:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> products = new LinkedHashMap<>();
        products.put("Laptop", 999.99);
        products.put("Phone", 499.99);

        // Update value
        products.replace("Laptop", 1099.99);

        System.out.println(products); // Output: {Laptop=1099.99, Phone=499.99}
    }
}
```

---

## Access-Order Updates

In access-ordered LinkedHashMaps, modifying a key's value via `put()` or `replace()` counts as an access, which **moves the modified entry to the end** of the map.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
