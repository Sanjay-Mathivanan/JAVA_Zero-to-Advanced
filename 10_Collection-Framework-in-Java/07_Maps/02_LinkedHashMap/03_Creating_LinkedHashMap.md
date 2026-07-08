# Creating a LinkedHashMap

## Step 1: Import the Class

Import the classes from the `java.util` package:

```java
import java.util.LinkedHashMap;
import java.util.Map;
```

---

## Step 2: Declaration Syntax

```java
Map<KeyType, ValueType> mapName = new LinkedHashMap<>();
```

### Example: Creating an Ordered Contact List:
```java
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Key is String (Name), Value is String (Phone)
        Map<String, String> contacts = new LinkedHashMap<>();
        
        System.out.println("Initialized LinkedHashMap: " + contacts); // Output: {}
    }
}
```

---

## Access-Ordering Mode Constructor

`LinkedHashMap` provides a special constructor to order elements based on how recently they were **accessed** (read or written), rather than when they were inserted:

```java
// Parameters: initial capacity, load factor, accessOrder (true)
LinkedHashMap<String, Integer> lruCache = new LinkedHashMap<>(16, 0.75f, true);
```

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
