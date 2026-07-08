# Adding Elements to a LinkedHashMap

## The `put()` Method

Adding elements uses the **`put(key, value)`** method. Elements are appended to the tail of the internal doubly linked list:

```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> playlist = new LinkedHashMap<>();

        // Adding elements in sequence
        playlist.put("Song A", "Artist X");
        playlist.put("Song B", "Artist Y");
        playlist.put("Song C", "Artist Z");

        System.out.println(playlist); // Output: {Song A=Artist X, Song B=Artist Y, Song C=Artist Z}
    }
}
```

---

## Overwriting Keys and Insertion Order

If you overwrite the value of an existing key, the key **remains at its original position** in the insertion order sequence:

```java
// Overwriting "Song B"
playlist.put("Song B", "New Artist");

// "Song B" remains second in the print order:
System.out.println(playlist); // Output: {Song A=Artist X, Song B=New Artist, Song C=Artist Z}
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
