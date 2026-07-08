# TreeMap in Java: Basics and Operations

## Introduction

So far, we have covered `HashMap` (unordered) and `LinkedHashMap` (insertion/access ordered). 

In many applications—like compiling leaderboard statistics, grouping transaction accounts by ID, or cataloging alphabetical products—we need keys to be **automatically sorted**.

To achieve this, Java provides **`TreeMap`**. A `TreeMap` implements the `NavigableMap` interface (which extends `SortedMap`), storing its entries in a self-balancing binary search tree.

---

## TreeMap Characteristics

* **Sorted Order**: Automatically sorts keys in **Natural Ordering** (numerical/alphabetical) or according to a custom **`Comparator`** passed to the constructor.
* **Red-Black Tree backing**: Guaranteed $\mathcal{O}(\log N)$ logarithmic time complexity for `get()`, `put()`, and `remove()` operations.
* **Null Key Restriction**: **Does not allow `null` keys** (throws `NullPointerException` because it must compare keys to sort them). It does permit multiple `null` values.
* **Interface Implementations**: Implements `SortedMap` and `NavigableMap`, which add rich range-based searching APIs.

---

## Syntax and NavigableMap Methods

Because `TreeMap` implements `NavigableMap`, it provides several powerful methods for navigation:

* `firstEntry()` / `lastEntry()`: Retrieves the lowest and highest key entries.
* `headMap(toKey)`: Returns a view of the portion of the map with keys strictly less than `toKey`.
* `tailMap(fromKey)`: Returns a view of the map with keys greater than or equal to `fromKey`.
* `subMap(fromKey, toKey)`: Returns a view of the map with keys ranging from `fromKey` to `toKey`.
* `floorEntry(key)`: Returns the greatest key less than or equal to `key`.
* `ceilingEntry(key)`: Returns the least key greater than or equal to `key`.

### Example: Navigation Operations:
```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, String> scores = new TreeMap<>();
        scores.put(90, "Rahul");
        scores.put(75, "Arun");
        scores.put(85, "Priya");
        scores.put(95, "Kavin");

        // Natural sort order of keys is automatically maintained
        System.out.println("Sorted Map: " + scores); // {75=Arun, 85=Priya, 90=Rahul, 95=Kavin}

        // Navigable Map Operations
        System.out.println("Lowest Score Entry: " + scores.firstEntry()); // 75=Arun
        System.out.println("Highest Score Entry: " + scores.lastEntry()); // 95=Kavin
        System.out.println("Ceiling score for 82: " + scores.ceilingEntry(82)); // 85=Priya
        System.out.println("Floor score for 88: " + scores.floorEntry(88)); // 85=Priya
    }
}
```

---

## Custom Comparator Sorting

If you want to sort keys in a custom order (e.g. descending order), pass a `Comparator` object during initialization:

```java
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Reverse comparator sorts keys in descending order
        Map<Integer, String> scores = new TreeMap<>(Collections.reverseOrder());
        scores.put(90, "Rahul");
        scores.put(75, "Arun");
        scores.put(85, "Priya");

        System.out.println("Descending Order Map: " + scores); // {90=Rahul, 85=Priya, 75=Arun}
    }
}
```

---

## Key Takeaways

* `TreeMap` stores keys in sorted order using natural comparison or a custom `Comparator`.
* Null keys are not allowed; attempting to put a null key throws a `NullPointerException`.
* Navigation methods like `firstEntry()`, `lastEntry()`, `floorEntry()`, and `ceilingEntry()` enable advanced range querying.
* Operations run in $\mathcal{O}(\log N)$ logarithmic time complexity.

---

**Back to Maps Home:** [Map Index](../README.md)
