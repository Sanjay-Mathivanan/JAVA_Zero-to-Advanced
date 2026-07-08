# Why Do We Need TreeMap?

## The Key Sorting Problem

A standard `HashMap` is unordered, and `LinkedHashMap` only maintains insertion sequence. 

If you are building an application where keys must be kept sorted—such as a **School Grading System** where students must be listed alphabetically, or a **Financial Ledger** sorting transactions by timestamp—sorting manually is inefficient.

A `TreeMap` solves this by keeping elements sorted automatically:

```java
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // TreeMap maintains keys in natural order
        Map<Integer, String> scores = new TreeMap<>();
        scores.put(95, "Amit");
        scores.put(80, "Rahul");
        scores.put(90, "Priya");

        System.out.println(scores); // Output: {80=Rahul, 90=Priya, 95=Amit}
    }
}
```

---

## Real-World Applications

* **Timelines and Event Log Sorters**: Cataloging events sequentially by Unix timestamp keys.
* **Score Leaderboards**: Automatically ranking players by numeric scores.
* **Range Searches**: Fetching all keys within specific numeric or alphabetic bounds.

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
