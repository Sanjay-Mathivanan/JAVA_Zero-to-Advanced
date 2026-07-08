# Adding Elements to a LinkedHashMap

## The `put()` Method

Adding entries is exactly identical to HashMap using the **`put(key, value)`** method:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> playlist = new LinkedHashMap<>();

        // Adding songs in order
        playlist.put("Song A", "Artist X");
        playlist.put("Song B", "Artist Y");
        playlist.put("Song C", "Artist Z");

        // Elements are printed in the exact order they were put()
        System.out.println(playlist); // Output: {Song A=Artist X, Song B=Artist Y, Song C=Artist Z}
    }
}
```

---

## Overwriting and Insertion Order

If you overwrite an existing key's value, the key **remains at its original position** in the insertion order; it does not jump to the end:

```java
playlist.put("Song B", "New Artist"); // Overwrites "Song B"

// "Song B" is still second in order
System.out.println(playlist); // Output: {Song A=Artist X, Song B=New Artist, Song C=Artist Z}
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
