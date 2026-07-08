# Why Do We Need LinkedHashMap?

## The HashMap Limitation

A standard `HashMap` uses hashing index calculations that distribute keys across buckets randomly. If you build an application where the order of items matters—such as displaying a list of recent items, processing a pipeline of events, or building an **LRU (Least Recently Used) Cache**—a `HashMap` is not suitable because it scrambles the order:

```java
// Standard HashMap scrambles order:
Map<String, Integer> map = new HashMap<>();
map.put("First", 1);
map.put("Second", 2);
map.put("Third", 3);

System.out.println(map); // Output might be: {Second=2, Third=3, First=1}
```

---

## The LinkedHashMap Solution

`LinkedHashMap` preserves the exact sequence:

```java
// LinkedHashMap retains order:
Map<String, Integer> map = new LinkedHashMap<>();
map.put("First", 1);
map.put("Second", 2);
map.put("Third", 3);

System.out.println(map); // Output is guaranteed: {First=1, Second=2, Third=3}
```

---

## Real-World Applications

* **LRU Cache Implementation**: Automatically discards elements that haven't been accessed for a long time.
* **Navigation History**: Remembering pages visited in the exact sequence of clicks.
* **Ordered Properties**: Preserving user-input settings configuration keys.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
