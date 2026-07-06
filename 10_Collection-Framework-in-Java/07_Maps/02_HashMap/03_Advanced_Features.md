# Advanced Features of HashMap

# Introduction

After understanding how `HashMap` works internally, the next step is to learn the advanced concepts that help write efficient and optimized Java programs.

These topics are commonly asked in Java interviews and are useful when building real-world applications.

---

# Learning Objectives

After completing this chapter, you will be able to understand:

* Initial Capacity
* Load Factor
* Resize Operation
* Rehashing
* `hashCode()` and `equals()`
* Fail-Fast Iterator
* Time Complexity
* Performance Tips
* Best Practices

---

# Initial Capacity

A `HashMap` internally starts with a fixed number of buckets.

Default Initial Capacity

```text
16
```

You can specify your own capacity.

```java
Map<Integer, String> map = new HashMap<>(64);
```

### Why specify the capacity?

If you know that thousands of records will be inserted, providing a larger initial capacity reduces resizing operations and improves performance.

---

# Load Factor

The **Load Factor** determines when the HashMap should resize.

Default Load Factor

```text
0.75
```

Threshold Formula

```text
Threshold = Capacity × Load Factor
```

Example

```text
Capacity = 16

Load Factor = 0.75

Threshold = 12
```

When the 13th element is inserted, HashMap resizes.

---

# Resize Operation

When the threshold is exceeded,

```text
16 Buckets

↓

32 Buckets
```

The bucket array size doubles automatically.

This operation is called **Resizing**.

---

# Rehashing

After resizing,

every existing entry is redistributed into the new bucket array.

```text
Old Buckets

↓

Resize

↓

Recalculate Bucket Index

↓

Store in New Buckets
```

This process is called **Rehashing**.

Although rehashing is expensive, it does not happen frequently.

---

# hashCode() and equals()

These two methods are extremely important when custom objects are used as keys.

## hashCode()

Returns an integer hash value.

Example

```java
String name = "Java";

System.out.println(name.hashCode());
```

HashMap uses this value to determine the bucket.

---

## equals()

Determines whether two keys are logically equal.

Example

```java
student1.equals(student2)
```

If two keys are equal, HashMap treats them as the same key.

---

# Why Override Both Methods?

If custom objects are used as keys,

always override both:

* `hashCode()`
* `equals()`

Incorrect implementation may lead to:

* Duplicate logical keys
* Retrieval failures
* Incorrect search results

---

# Fail-Fast Iterator

HashMap iterators are **Fail-Fast**.

If the HashMap is structurally modified while iterating,

Java throws

```text
ConcurrentModificationException
```

Example

```java
for (Integer key : map.keySet()) {

    map.put(200, "New");

}
```

This causes an exception because the collection is modified during iteration.

---

# Time Complexity

| Operation     | Average Case | Worst Case |
| ------------- | ------------ | ---------- |
| put()         | O(1)         | O(n)       |
| get()         | O(1)         | O(n)       |
| remove()      | O(1)         | O(n)       |
| containsKey() | O(1)         | O(n)       |

> Java 8 reduces the impact of heavy collisions by converting long collision chains into Red-Black Trees.

---

# Null Handling

| Feature              | Supported |
| -------------------- | --------- |
| One Null Key         | ✅ Yes     |
| Multiple Null Values | ✅ Yes     |

Example

```java
map.put(null, "Unknown");

map.put(101, null);
```

---

# Performance Tips

* Use immutable objects as keys.
* Override `equals()` and `hashCode()` correctly.
* Specify an initial capacity if the expected size is known.
* Avoid creating unnecessary HashMaps.
* Choose meaningful key objects.

---

# When Should You Use HashMap?

Choose `HashMap` when:

* Fast lookup is required.
* Ordering is not important.
* Frequent insertions and deletions occur.
* Data is identified by unique keys.

Do **not** use `HashMap` when:

* Insertion order must be preserved.
* Keys need to remain sorted.
* Thread safety is required.

---

# HashMap vs Other Implementations

| Feature            | HashMap    | LinkedHashMap            | TreeMap         |
| ------------------ | ---------- | ------------------------ | --------------- |
| Ordering           | No         | Insertion Order          | Sorted          |
| Search Speed       | Fast       | Fast                     | Slightly Slower |
| Internal Structure | Hash Table | Hash Table + Linked List | Red-Black Tree  |
| Null Key           | Yes        | Yes                      | No              |

---

# Best Practices

* Program using the `Map` interface.
* Use immutable key objects.
* Avoid mutable fields inside key classes.
* Select an appropriate initial capacity.
* Prefer `HashMap` for general-purpose key-value storage.

---

# Common Mistakes

### Using Mutable Keys

Changing a key after inserting it into a HashMap can make it impossible to retrieve the value.

---

### Forgetting to Override `hashCode()`

Overriding `equals()` without `hashCode()` breaks the HashMap contract.

---

### Assuming HashMap Maintains Order

`HashMap` does **not** guarantee insertion order.

Use `LinkedHashMap` if order matters.

---

# Interview Questions

1. Why is the default capacity of HashMap 16?
2. Why is the default load factor 0.75?
3. What is resizing?
4. What is rehashing?
5. What is the purpose of `hashCode()`?
6. Why should `equals()` and `hashCode()` be overridden together?
7. What is a Fail-Fast Iterator?
8. Why does `ConcurrentModificationException` occur?
9. When should you use HashMap instead of TreeMap?
10. What are the best practices for using HashMap?

---

# Practice Programs

1. Create a HashMap with a custom initial capacity.
2. Demonstrate automatic resizing.
3. Create a custom key class by overriding `equals()` and `hashCode()`.
4. Demonstrate a `ConcurrentModificationException`.
5. Compare the performance of HashMap and TreeMap.
6. Store immutable objects as keys.
7. Experiment with different load factors.
8. Compare default and custom constructors.
9. Measure insertion time for large datasets.
10. Build a simple cache using HashMap.

---

# Key Takeaways

* The default initial capacity of a HashMap is **16**.
* The default load factor is **0.75**.
* HashMap automatically resizes and rehashes entries when the threshold is exceeded.
* `hashCode()` determines the bucket, while `equals()` confirms key equality.
* Iterators are Fail-Fast and detect structural modifications.
* Proper key design and capacity selection improve HashMap performance.

---

# Conclusion

`HashMap` is one of the most optimized and widely used data structures in Java. Understanding advanced topics such as load factor, resizing, rehashing, `hashCode()`, `equals()`, and Fail-Fast iterators enables you to write efficient, scalable, and interview-ready Java programs. With the Map fundamentals and HashMap-specific concepts covered, you now have a strong foundation for exploring other Map implementations like `LinkedHashMap` and `TreeMap`.
