# Internal Working of Stack

## The Backing Vector Array

In Java, the `Stack` class extends **`Vector`**. It stores elements internally in a resizable object array:

```java
// Inherited fields from Vector:
protected Object[] elementData;
protected int elementCount;
```

---

## 1. Push Operation (`push()`)

When you push an element:
1. The JVM checks if the array capacity needs to grow.
2. The element is appended at the current `elementCount` index:
   ```java
   elementData[elementCount] = item;
   elementCount++;
   ```

```text
Push operation index layout:
Index:   [0]   [1]   [2]   [3]   [4]
Data:   [ A ] [ B ] [   ] [   ] [   ]
                     ^
                elementCount (Next insertion index)
```

---

## 2. Pop Operation (`pop()`)

When you pop an element:
1. It retrieves the element at the top index: `elementCount - 1`.
2. It removes the reference at that index to allow garbage collection.
3. It decrements the `elementCount` pointer.

```text
Pop operation index layout:
Index:   [0]   [1]   [2]   [3]
Data:   [ A ] [ B ] [ C ] [   ]
                     ^
                elementCount - 1 (Top of the stack)
```

---

## 3. Method Synchronization

Because `Stack` extends `Vector`, almost every method is synchronized using the `synchronized` keyword:

```java
public synchronized E peek() { ... }
public synchronized E pop() { ... }
```

This ensures thread safety but degrades performance because only one thread can access the stack at a time.

---

## Time Complexities

* **`push()`**: `O(1)` amortized (constant time, unless resizing occurs).
* **`pop()`**: `O(1)` constant time.
* **`peek()`**: `O(1)` constant time.
* **`search()`**: `O(N)` linear time (requires scanning the array).

---

**Back to Stacks Home:** [Stacks Index](../README.md)
