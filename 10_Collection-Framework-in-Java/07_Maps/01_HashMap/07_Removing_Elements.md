# Removing Elements from a HashMap

## The `remove()` Method

To remove a key-value entry, pass the key to the **`remove(key)`** method. If the key exists, it removes the pair and returns the deleted value:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> fruits = new HashMap<>();
        fruits.put("A", "Apple");
        fruits.put("B", "Banana");

        // 1. Remove by Key
        fruits.remove("B"); 
        System.out.println(fruits); // Output: {A=Apple}
    }
}
```

---

## Conditional Removal

You can also use a two-argument version of `remove(key, value)` to remove an entry **only if both key and value match**:

```java
// B is mapped to Banana, not Mango. This call is ignored:
fruits.remove("B", "Mango"); 
```

---

## Clear the Map: `clear()`

To empty the entire map at once, use `clear()`. The size of the map becomes 0:

```java
fruits.clear();
System.out.println("Size: " + fruits.size()); // Size: 0
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
