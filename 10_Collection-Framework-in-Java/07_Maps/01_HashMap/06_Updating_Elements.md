# Updating Elements in a HashMap

## Updating with `put()`

As learned earlier, you can update a key's value by calling `put()` again with the same key. This simply overwrites the old value:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Laptop", 999.99);

        // Overwriting value
        prices.put("Laptop", 1099.99); 
        System.out.println(prices); // Output: {Laptop=1099.99}
    }
}
```

---

## The `replace()` Method

Java also provides a dedicated **`replace(key, newValue)`** method. 

Unlike `put()`, which creates a new key if it is missing, `replace()` only updates the key **if it already exists** in the map:

```java
// Updates Laptop because it is already present
prices.replace("Laptop", 1150.00); 

// Will do nothing because Phone is not in the map
prices.replace("Phone", 500.00); 

System.out.println(prices); // Output: {Laptop=1150.00}
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
