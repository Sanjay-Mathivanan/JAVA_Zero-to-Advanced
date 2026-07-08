# Adding Elements to a HashMap

## The `put(K key, V value)` Method

To insert an entry into a `HashMap`, use the `put()` method. 

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();

        // put returns null if the key was not present
        Integer res1 = inventory.put("Apples", 50); 
        System.out.println("Returned value: " + res1); // Output: null

        System.out.println(inventory); // Output: {Apples=50}
    }
}
```

---

## Overwriting Keys and Return Values

If the key already exists, `put()` replaces the value and **returns the old value**:

```java
// Overwriting existing key
Integer oldValue = inventory.put("Apples", 75); 

System.out.println("Old Value: " + oldValue); // Output: 50
System.out.println("Updated Map: " + inventory); // Output: {Apples=75}
```

---

## Safe Insertion: `putIfAbsent(K key, V value)`

To insert a key-value pair only if the key is not already in the map (preventing overwrites), use `putIfAbsent()`:

```java
// Apples already exists, so this call is ignored and returns the current value 75
Integer currentVal = inventory.putIfAbsent("Apples", 100); 
System.out.println("Current Value returned: " + currentVal); // 75

// Bananas is not present, so it is inserted and returns null
inventory.putIfAbsent("Bananas", 30); 

System.out.println(inventory); // Output: {Apples=75, Bananas=30}
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
