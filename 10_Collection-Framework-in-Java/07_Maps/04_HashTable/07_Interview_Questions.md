# Hashtable Interview Questions and Answers

## Beginner Questions

### Q1: Is Hashtable synchronized?
**Answer:**
Yes. All public methods in `Hashtable` are synchronized, making it thread-safe for concurrent multi-threaded access.

### Q2: Does Hashtable allow null keys or values?
**Answer:**
No. Attempting to insert a null key or value throws a `NullPointerException`.

---

## Intermediate Questions

### Q3: Why is Hashtable considered legacy and obsolete?
**Answer:**
Because it locks the entire object instance during operations, creating a thread execution bottleneck. Modern programs use `ConcurrentHashMap` for synchronized access.

### Q4: How do you make a HashMap thread-safe without using Hashtable?
**Answer:**
You can wrap it using `Collections.synchronizedMap()`:
```java
Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
```

---

**Back to HashTable Home:** [HashTable Index](README.md)
