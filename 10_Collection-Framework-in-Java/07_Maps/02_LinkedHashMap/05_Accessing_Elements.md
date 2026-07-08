# Accessing Elements in a LinkedHashMap

## The `get()` Method

You access elements using **`get(key)`**:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("One", "Apple");
        map.put("Two", "Banana");

        System.out.println(map.get("One")); // Output: Apple
    }
}
```

---

## Access-Ordering Mode (LRU Cache Behavior)

If you instantiate `LinkedHashMap` using the constructor with the `accessOrder` argument set to `true`, accessing any key shifts its entry to the end (tail) of the map:

```java
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        // Third argument 'true' enables access-ordering
        LinkedHashMap<String, String> cache = new LinkedHashMap<>(16, 0.75f, true);
        cache.put("A", "Apple");
        cache.put("B", "Banana");
        cache.put("C", "Cherry");

        // Access "A"
        cache.get("A"); 

        // "A" is moved to the end because it was accessed!
        System.out.println(cache); // Output: {B=Banana, C=Cherry, A=Apple}
    }
}
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
