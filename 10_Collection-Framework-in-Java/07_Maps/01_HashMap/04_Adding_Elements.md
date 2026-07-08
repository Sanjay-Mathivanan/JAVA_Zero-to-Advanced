# Adding Elements to a HashMap

## The `put()` Method

To add elements (key-value pairs) to a HashMap, use the **`put(key, value)`** method:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> userAges = new HashMap<>();

        // Adding entries
        userAges.put("Rahul", 21);
        userAges.put("Arun", 20);

        System.out.println(userAges); // Output: {Arun=20, Rahul=21}
    }
}
```

---

## Overwriting Existing Keys

If you call `put()` with a key that is already in the map, it will update that key with the new value:

```java
userAges.put("Rahul", 21);
userAges.put("Rahul", 25); // Updates Rahul's age from 21 to 25

System.out.println(userAges); // Output: {Rahul=25, Arun=20}
```

---

## The `putIfAbsent()` Method

If you want to add a pair **only if the key is not already present**, use `putIfAbsent()`:

```java
// Rahul already exists, so this call will be ignored
userAges.putIfAbsent("Rahul", 30); 

// Priya does not exist, so she will be added
userAges.putIfAbsent("Priya", 22);

System.out.println(userAges); // Output: {Rahul=25, Arun=20, Priya=22}
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
