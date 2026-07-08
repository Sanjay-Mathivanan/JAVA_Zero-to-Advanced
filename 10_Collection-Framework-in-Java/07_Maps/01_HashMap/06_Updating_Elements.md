# Updating Elements in a HashMap

## Overwriting with `put()`

You can update a value by calling `put()` again with the same key. The map replaces the old value with the new one:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> prices = new HashMap<>();
        prices.put("Laptop", 999.99);

        // Put will overwrite the old value
        prices.put("Laptop", 1099.99); 
    }
}
```

---

## Updating via `replace()`

The `replace()` method behaves differently: it only updates the key **if it is already present** in the map. If the key is missing, it is ignored:

```java
// Updates Laptop because it exists
prices.replace("Laptop", 1150.00); 

// Ignored because Phone does not exist (does not insert it)
prices.replace("Phone", 500.00); 

System.out.println(prices); // Output: {Laptop=1150.00}
```

---

## Conditional Replacement

You can also use `replace(K key, V oldValue, V newValue)` to update a key **only if its current value matches** `oldValue`:

```java
// Replaces Laptop only if current value is 1150.00 (returns true)
boolean replaced = prices.replace("Laptop", 1150.00, 1200.00);
System.out.println("Was Laptop replaced? " + replaced); // true
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
