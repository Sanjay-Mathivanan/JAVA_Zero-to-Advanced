# Accessing Elements in a LinkedHashMap

## Standard Retrieval

Retrieving elements uses the standard **`get(key)`** method:

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

When you initialize a `LinkedHashMap` with the `accessOrder` parameter set to `true`, accessing any key shifts its entry to the tail (end) of the doubly linked list:

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

        // "A" is moved to the end of the entry chain
        System.out.println(cache); // Output: {B=Banana, C=Cherry, A=Apple}
    }
}
```

This behavior is useful for implementing caching mechanisms, as the least recently used elements remain at the head of the list.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
