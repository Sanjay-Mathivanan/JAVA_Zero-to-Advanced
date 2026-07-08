# LinkedHashMap Interview Questions and Answers

## Beginner Questions

### Q1: What is the main difference between HashMap and LinkedHashMap?
**Answer:**
`HashMap` does not maintain any element order. `LinkedHashMap` maintains elements in the exact order they were inserted.

### Q2: Does LinkedHashMap consume more memory than HashMap?
**Answer:**
Yes, because each entry node in a `LinkedHashMap` stores two additional pointer references (`before` and `after`) to maintain the doubly linked list structure.

---

## Intermediate Questions

### Q3: What is access-ordering in LinkedHashMap?
**Answer:**
Access-ordering is a mode enabled via a special constructor. When set to `true`, accessing any entry (via `get()` or `put()`) moves that entry to the end (tail) of the map. This is used to build LRU caches.

### Q4: How do you build a simple LRU cache using LinkedHashMap?
**Answer:**
By subclassing `LinkedHashMap` with `accessOrder = true` and overriding the `removeEldestEntry(Map.Entry eldest)` method to return `true` when the map size exceeds the cache capacity limit.

---

**Back to LinkedHashMap Home:** [LinkedHashMap Index](README.md)
