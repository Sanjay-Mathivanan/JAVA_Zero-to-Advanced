# Iterating Through a HashMap

## Method 1: Iterating Key-Value Pairs (`entrySet`)

The most efficient way to loop through a Map when you need both keys and values is using **`entrySet()`**. It returns a set of Entry objects:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);

        // entrySet loop
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
```

---

## Method 2: Iterating Keys Only (`keySet`)

If you only need the keys of the map, use **`keySet()`**:

```java
for (String key : map.keySet()) {
    System.out.println("Key: " + key);
}
```

---

## Method 3: Iterating Values Only (`values()`)

If you only need the values, use **`values()`**:

```java
for (Integer value : map.values()) {
    System.out.println("Value: " + value);
}
```

---

## Method 4: Java 8 Lambdas (`forEach`)

For a modern, single-line loop, use the `forEach()` method:

```java
map.forEach((key, value) -> System.out.println(key + " -> " + value));
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
