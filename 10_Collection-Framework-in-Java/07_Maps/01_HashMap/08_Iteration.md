# Iterating Through a HashMap

## Method 1: Iterating Entries (`entrySet()`)

The most efficient way to loop when you need both keys and values is using `entrySet()`. It returns a set of Entry objects, avoiding redundant map lookups:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> stock = new HashMap<>();
        stock.put("ItemA", 100);
        stock.put("ItemB", 250);

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
```

---

## Method 2: Iterating Keys Only (`keySet()`)

If you only need the keys:

```java
for (String key : stock.keySet()) {
    System.out.println("Key: " + key);
}
```

> [!CAUTION]
> Avoid calling `map.get(key)` inside a `keySet()` loop to retrieve values. Doing so triggers a redundant search calculation for every element. Use `entrySet()` instead.

---

## Method 3: Iterating Values Only (`values()`)

If you only need the values:

```java
for (Integer value : stock.values()) {
    System.out.println("Value: " + value);
}
```

---

## Method 4: Java 8 Lambdas (`forEach()`)

```java
stock.forEach((key, value) -> System.out.println(key + " -> " + value));
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
