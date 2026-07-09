# Internal Working of ArrayDeque

## Circular Array Backing

An `ArrayDeque` stores elements in a circular array buffer:

```java
transient Object[] elements; // Must be a power of 2
transient int head;          // Pointer to head index
transient int tail;          // Pointer to next available tail index
```

---

## 1. Circular Bitwise Pointer Math

Rather than moving array elements when elements are added or removed, `ArrayDeque` uses bitwise mask arithmetic to wrap pointers around the array boundaries.

For a table capacity $N$ (where $N$ is always a power of 2, like 8), the mask is $N-1$ (7, or `0111` in binary).

### Head Pre-Decrement:
When you call `addFirst(e)`:
```java
head = (head - 1) & (elements.length - 1);
elements[head] = e;
```

### Tail Post-Increment:
When you call `addLast(e)`:
```java
elements[tail] = e;
tail = (tail + 1) & (elements.length - 1);
```

```text
Circular Array Slots (Capacity: 8):
Index:   [0]   [1]   [2]   [3]   [4]   [5]   [6]   [7]
Data:   [ C ] [ D ] [   ] [   ] [   ] [   ] [ A ] [ B ]
                     ^                     ^
                    Tail                  Head
```

---

## 2. Array Expansion (Resizing)

When `head == tail`, the circular array is completely full.

```text
Full Array State:
Index:   [0]   [1]   [2]   [3]   [4]   [5]   [6]   [7]
Data:   [ A ] [ B ] [ C ] [ D ] [ E ] [ F ] [ G ] [ H ]
                                 ^
                             Head & Tail
```

When this happens, the queue triggers a double-capacity expansion:
1. It allocates a new array of double the capacity (e.g. $8 \rightarrow 16$).
2. It copies elements from `head` to the end of the array.
3. It copies elements from the beginning of the array to `head`.
4. It resets `head` to `0` and `tail` to the old capacity (e.g. 8).

---

## Time Complexities

* **`addFirst()` / `addLast()`**: `O(1)` amortized (constant time, unless resizing occurs).
* **`pollFirst()` / `pollLast()`**: `O(1)` constant time.
* **`peekFirst()` / `peekLast()`**: `O(1)` constant time.

---

**Back to Queues Home:** [Queues Index](../README.md)
