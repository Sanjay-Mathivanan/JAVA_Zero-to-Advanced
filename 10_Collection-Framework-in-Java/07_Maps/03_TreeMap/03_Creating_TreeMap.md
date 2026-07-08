# Creating a TreeMap

## Basic Declaration

Declare using the parent interfaces (`Map`, `SortedMap`, or `NavigableMap`):

```java
import java.util.Map;
import java.util.TreeMap;

Map<Integer, String> grades = new TreeMap<>();
```

---

## Defining Custom Comparators

By default, `TreeMap` sorts keys according to their natural order. You can customize the sorting order by passing a `Comparator` to the constructor:

```java
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

// Sorts keys in descending order
Map<Integer, String> descendingMap = new TreeMap<>(Collections.reverseOrder());
```

### Example: Custom Case-Insensitive String Comparator:
```java
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Ignores uppercase/lowercase differences when sorting strings
        Map<String, String> glossary = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        glossary.put("apple", "Fruit A");
        glossary.put("Banana", "Fruit B");

        System.out.println(glossary); // Output: {apple=Fruit A, Banana=Fruit B}
    }
}
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
