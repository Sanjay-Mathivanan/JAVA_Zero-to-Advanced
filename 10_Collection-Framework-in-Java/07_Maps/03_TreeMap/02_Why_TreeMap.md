# Why Do We Need TreeMap?

## The Ordering Problem

Standard `HashMap` has no order, and `LinkedHashMap` only maintains insertion sequence. 

Suppose we build a **School Grading System** where we want to catalog students by their score ranges, or an **E-Commerce Price Directory** where products must be fetched in ascending price points. 

If we use a `HashMap`, we have to extract all keys, put them in a list, and sort them manually. 

A `TreeMap` does this automatically:

```java
// Keys are sorted automatically as you insert them:
Map<Integer, String> scores = new TreeMap<>();
scores.put(95, "Amit");
scores.put(80, "Rahul");
scores.put(90, "Priya");

System.out.println(scores); // Output is sorted by Key: {80=Rahul, 90=Priya, 95=Amit}
```

---

## Real-World Applications

* **Financial Ledgers**: Sorting transactions by timestamps.
* **Range Searching**: Finding all users whose age is between 20 and 30.
* **System Log Sorters**: Cataloging system events by priority keys.

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
