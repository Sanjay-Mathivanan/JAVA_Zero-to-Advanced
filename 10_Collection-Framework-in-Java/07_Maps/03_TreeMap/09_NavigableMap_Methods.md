# NavigableMap Methods in TreeMap

## Introduction

Because `TreeMap` implements the **`NavigableMap`** interface, it provides range-querying and closest-match search methods that do not exist in standard maps.

---

## 1. Extreme Boundaries

Retrieving the absolute first and last entries in sorted order:

* **`firstKey()` / `lastKey()`**: Returns the lowest and highest keys.
* **`firstEntry()` / `lastEntry()`**: Returns the lowest and highest key-value pairs.

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(10, "A");
        scores.put(20, "B");
        scores.put(30, "C");
        scores.put(40, "D");

        System.out.println("Lowest Key: " + scores.firstKey()); // 10
        System.out.println("Highest Key: " + scores.lastKey()); // 40
    }
}
```

---

## 2. Floor & Ceiling (Closest Bounds)

These methods search for closest matches if the exact key is not in the map:

* **`floorKey(K key)`**: Returns the greatest key **less than or equal to** the target.
* **`ceilingKey(K key)`**: Returns the least key **greater than or equal to** the target.

```java
// Exact key 25 does not exist:
System.out.println("Floor of 25: " + scores.floorKey(25));     // 20 (closest low)
System.out.println("Ceiling of 25: " + scores.ceilingKey(25)); // 30 (closest high)
```

---

## 3. Higher & Lower (Strict Bounds)

These methods search for strictly higher or lower keys, ignoring exact matches:

* **`lowerKey(K key)`**: Returns the greatest key strictly less than the target.
* **`higherKey(K key)`**: Returns the least key strictly greater than the target.

```java
System.out.println("Lower than 20: " + scores.lowerKey(20));   // 10
System.out.println("Higher than 20: " + scores.higherKey(20)); // 30
```

---

## 4. Sub-Map Range Slicing

You can slice portions of a map using submap operations:

* **`subMap(fromKey, toKey)`**: Returns keys between `fromKey` (inclusive) and `toKey` (exclusive).
* **`headMap(toKey)`**: Returns keys less than `toKey`.
* **`tailMap(fromKey)`**: Returns keys greater than or equal to `fromKey`.

```java
// Returns entries from 20 (inclusive) to 40 (exclusive)
System.out.println("SubMap: " + scores.subMap(20, 40)); // {20=B, 30=C}
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
