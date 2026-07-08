# Adding Elements to a TreeMap

## The `put()` Method

You insert entries using **`put(key, value)`**. The `TreeMap` immediately finds the correct sorted location for the key:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, String> glossary = new TreeMap<>();

        // Inserting alphabetically scrambled words
        glossary.put("C", "Cherry");
        glossary.put("A", "Apple");
        glossary.put("B", "Banana");

        // Printed keys will be alphabetically sorted
        System.out.println(glossary); // Output: {A=Apple, B=Banana, C=Cherry}
    }
}
```

---

## Overwriting Values

Just like HashMap, if you put a key that already exists, it updates the value:

```java
glossary.put("A", "Avocado"); // Updates Apple to Avocado
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
