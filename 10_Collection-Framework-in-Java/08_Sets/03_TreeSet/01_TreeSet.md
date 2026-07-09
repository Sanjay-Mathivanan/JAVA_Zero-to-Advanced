# TreeSet in Java

## Introduction

While `HashSet` (unordered) and `LinkedHashSet` (insertion-ordered) offer fast performance, they do not sort elements.

To store elements in sorted order, Java provides **`TreeSet`**. A `TreeSet` implements the `NavigableSet` interface (which extends `SortedMap`/`SortedSet`) and is backed by a `TreeMap` instance. It automatically sorts elements as they are inserted.

---

## Why TreeSet?

If you are building an application where elements must remain unique and be sorted automatically—such as a **High Score Leaderboard**, a **Case-Insensitive Glossary**, or a **Price Catalog**—`TreeSet` is the ideal collection:

```java
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> scores = new TreeSet<>();
        scores.add(95);
        scores.add(80);
        scores.add(90);

        System.out.println(scores); // Output is sorted automatically: [80, 90, 95]
    }
}
```

---

## Features of TreeSet

* **No Duplicates**: Duplicate elements are rejected automatically.
* **Auto-Sorted**: Elements are sorted in ascending natural order (or custom order using a `Comparator`).
* **No Null Elements**: **Does not allow null elements** (throws `NullPointerException` because it must compare elements to sort them).
* **Guaranteed Complexity**: backed by a Red-Black Tree, basic operations (`add`, `remove`, `contains`) run in **`O(log N)`** logarithmic time.

---

## Creating a TreeSet

### Basic Initialization (Natural Order)
```java
import java.util.Set;
import java.util.TreeSet;

Set<String> words = new TreeSet<>();
```

### Initialization with Custom Comparator (Descending Order)
```java
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

SortedSet<Integer> descendingScores = new TreeSet<>(Collections.reverseOrder());
```

---

## Common and Navigable Methods

Since `TreeSet` implements `NavigableSet`, it provides several utility methods for range queries:

| Method | Description | Time Complexity |
| :--- | :--- | :---: |
| **`first()`** | Returns the lowest element currently in the set. | `O(1)` or `O(log N)` |
| **`last()`** | Returns the highest element currently in the set. | `O(log N)` |
| **`floor(E e)`** | Returns the greatest element $\le$ the target. | `O(log N)` |
| **`ceiling(E e)`** | Returns the least element $\ge$ the target. | `O(log N)` |
| **`subSet(from, to)`**| Returns a view of the portion of the set between the bounds. | `O(log N)` |

---

## Iterating Through a TreeSet

Iterating through a `TreeSet` returns elements in ascending sorted order:

```java
// Using For-Each Loop
for (Integer score : scores) {
    System.out.println("Score: " + score);
}
```

---

## Complete Programs

### Example: Sorted Registry and Range Slicing
```java
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Integer> ages = new TreeSet<>();
        ages.add(25);
        ages.add(40);
        ages.add(18);
        ages.add(30);

        // 1. Sorted output check
        System.out.println("Sorted Ages: " + ages); // [18, 25, 30, 40]

        // 2. Navigable methods
        System.out.println("Lowest Age: " + ages.first()); // 18
        System.out.println("Highest Age: " + ages.last()); // 40
        System.out.println("Age floor for 29: " + ages.floor(29)); // 25 (nearest low)
        System.out.println("Age ceiling for 29: " + ages.ceiling(29)); // 30 (nearest high)

        // 3. Sub-Set range slicing
        System.out.println("Ages between 20 and 35: " + ages.subSet(20, 35)); // [25, 30]
    }
}
```

---

## Best Practices

* **Override `Comparable`**: Any custom class stored in a `TreeSet` (e.g., `Student`) **must implement the `Comparable` interface** (or you must provide an external `Comparator` to the constructor). If you do not, inserting the object will throw a `ClassCastException`.
* **Prefer HashSet by default**: Use `HashSet` instead of `TreeSet` unless sorting is required, as `HashSet` has faster operations (`O(1)` vs `O(log N)`).

---

## Common Mistakes

* **Adding Nulls**: Inserting a `null` value into a `TreeSet` throws a `NullPointerException` because `null` cannot be compared to other elements.
* **Inconsistent Comparator**: Ensure your custom `Comparator` or `compareTo()` implementation is consistent with `equals()`. If `compare(a, b) == 0` but `a.equals(b) == false`, the set will reject `b` as a duplicate, violating the set interface contract.

---

## Key Takeaways

* `TreeSet` keeps elements sorted automatically.
* backed by a Red-Black Tree, providing guaranteed `O(log N)` performance.
* Does not permit null elements.

---

**Back to Sets Home:** [Sets Index](../README.md)
