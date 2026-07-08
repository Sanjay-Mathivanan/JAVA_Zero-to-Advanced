# NavigableMap Methods in TreeMap

## Introduction

Since `TreeMap` implements the **`NavigableMap`** interface, it provides powerful range-querying methods that do not exist in standard maps.

---

## Key Range Methods

Suppose we have a map of numeric IDs to user profiles:

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(10, "A");
        scores.put(20, "B");
        scores.put(30, "C");
        scores.put(40, "D");

        // 1. Extreme Boundaries
        System.out.println("First key: " + scores.firstKey()); // 10
        System.out.println("Last key: " + scores.lastKey()); // 40

        // 2. Ceiling & Floor (Equal or next closest)
        System.out.println("Ceiling for 25: " + scores.ceilingKey(25)); // 30 (nearest high)
        System.out.println("Floor for 25: " + scores.floorKey(25)); // 20 (nearest low)

        // 3. Higher & Lower (Strictly higher or lower)
        System.out.println("Higher than 20: " + scores.higherKey(20)); // 30
        System.out.println("Lower than 20: " + scores.lowerKey(20)); // 10
    }
}
```

---

## Sub-Map Range Slicing

You can slice portions of a map using submap operations:

```java
// Returns keys from 20 (inclusive) to 40 (exclusive)
System.out.println("SubMap: " + scores.subMap(20, 40)); // {20=B, 30=C}
```

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
