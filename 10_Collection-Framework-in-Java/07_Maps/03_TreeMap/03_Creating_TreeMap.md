# Creating a TreeMap

## Step 1: Import the Class

Import the classes from `java.util`:

```java
import java.util.Map;
import java.util.TreeMap;
```

---

## Step 2: Declaration Syntax

```java
Map<KeyType, ValueType> mapName = new TreeMap<>();
```

### Example: Creating a Sorted Price Directory:
```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Automatically sorts keys (Integer prices) in ascending order
        Map<Integer, String> items = new TreeMap<>();
        items.put(50, "Book");
        items.put(10, "Pen");
        items.put(30, "Eraser");

        System.out.println(items); // Output: {10=Pen, 30=Eraser, 50=Book}
    }
}
```

---

## Sorting in Descending Order

If you want the keys sorted in descending order, pass a Comparator during creation:

```java
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

Map<Integer, String> descendingMap = new TreeMap<>(Collections.reverseOrder());
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
