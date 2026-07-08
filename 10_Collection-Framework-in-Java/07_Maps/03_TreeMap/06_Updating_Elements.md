# Updating Elements in a TreeMap

## The `replace()` Method

Use **`replace(key, newValue)`** to update values:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new TreeMap<>();
        inventory.put("Apples", 50);
        inventory.put("Bananas", 30);

        // Update value
        inventory.replace("Apples", 45);

        System.out.println(inventory); // Output: {Apples=45, Bananas=30}
    }
}
```

---

## Behavior Notes

Modifying a value in a `TreeMap` **does not change the sorted position of the key**, because the sorting sequence is determined purely by the key itself, not the value.

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
