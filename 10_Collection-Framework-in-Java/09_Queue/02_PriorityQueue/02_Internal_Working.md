# Internal Working of PriorityQueue

## The Binary Heap Backing

A `PriorityQueue` is backed by a **Binary Heap** (specifically, a min-heap by default). A binary heap is a balanced binary tree that satisfies the **heap property**: the parent node is always less than or equal to its children:

```text
          [ 10 (Root) ]
           /         \
       [ 20 ]       [ 30 ]
       /    \
     [ 40 ] [ 50 ]
```

---

## Array Representation

Rather than using pointers, a binary heap is stored in a single flat array:

| Index | `[0]` | `[1]` | `[2]` | `[3]` | `[4]` |
| :---: | :---: | :---: | :---: | :---: | :---: |
| **Node**| `10` (Root) | `20` (Left) | `30` (Right) | `40` | `55` |

### Child/Parent Index Math:
For any element at index `i`:
* **Parent Index**: `(i - 1) / 2`
* **Left Child Index**: `2 * i + 1`
* **Right Child Index**: `2 * i + 2`

Using this math, the JVM navigates the tree structure without the memory overhead of node object references.

---

## Queue Operations and Rebalancing

### 1. Insertion (`offer()`) - Sift-Up
When you add a new element:
1. The element is appended to the next available index at the end of the array.
2. The queue performs a **sift-up** operation: it compares the new element with its parent.
3. If the element is smaller than its parent, they are swapped.
4. This continues up the tree until the heap property is restored.

### 2. Extraction (`poll()`) - Sift-Down
When you remove the highest-priority element (root):
1. The root element at index `[0]` is removed.
2. The last element in the array is moved to the root position index `[0]`.
3. The queue performs a **sift-down** operation: it compares the new root with its children.
4. If it is larger than either child, it is swapped with the smaller of the two children.
5. This continues down the tree until the heap property is restored.

---

## Time Complexities

* **`peek()`**: `O(1)` (returns the element at index `[0]`).
* **`offer()`**: `O(log N)` (requires at most a sift-up path equal to the tree depth).
* **`poll()`**: `O(log N)` (requires at most a sift-down path equal to the tree depth).
* **`remove(object)`**: `O(N)` (requires searching the flat array for the element first).

---

**Back to Queues Home:** [Queues Index](../README.md)
