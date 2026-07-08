# Basic Operations on a LinkedList in Java

## Introduction

Once you have initialized a LinkedList, you need to know how to perform standard CRUD operations—adding new nodes, retrieving elements, and deleting elements from the list.

Since a LinkedList is backed by nodes rather than an array, insertions and deletions at either the beginning or end of the list are extremely fast ($\mathcal{O}(1)$), while index-based access requires sequential traversal ($\mathcal{O}(N)$).

---

## 1. Adding Elements

Java provides multiple methods to insert elements at different positions:

* `add(E e)`: Appends the element to the end of the list.
* `add(int index, E element)`: Inserts the element at a specific 0-based index.
* `addFirst(E e)`: Inserts the element at the beginning (index 0).
* `addLast(E e)`: Appends the element to the end of the list (identical to `add()`).

```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        
        list.add("Coimbatore");       // [Coimbatore]
        list.addFirst("Chennai");     // [Chennai, Coimbatore]
        list.addLast("Madurai");      // [Chennai, Coimbatore, Madurai]
        list.add(1, "Salem");         // [Chennai, Salem, Coimbatore, Madurai]
        
        System.out.println(list);     // [Chennai, Salem, Coimbatore, Madurai]
    }
}
```

---

## 2. Accessing Elements

Retrieving elements from a LinkedList can be done using indexing or queue-like polling routines. 

> [!WARNING]
> Accessing by index (`get(index)`) forces the JVM to traverse nodes sequentially. Avoid using `get(index)` in loop iterations; use iterators or enhanced loops instead.

| Method | Return Target | Empty List Behavior |
| :--- | :--- | :--- |
| `get(int index)` | Element at index | Throws `IndexOutOfBoundsException` |
| `getFirst()` | First element | Throws `NoSuchElementException` |
| `getLast()` | Last element | Throws `NoSuchElementException` |
| `peek()` / `peekFirst()` | First element | Returns `null` |
| `peekLast()` | Last element | Returns `null` |
| `element()` | First element | Throws `NoSuchElementException` |

```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");

        System.out.println(list.getFirst()); // Apple
        System.out.println(list.get(1));     // Banana
        System.out.println(list.peekLast()); // Banana
    }
}
```

---

## 3. Removing Elements

Removing elements from a LinkedList involves updating node pointers to bypass the deleted element. No physical element shifting occurs.

| Method | Description | Empty List Behavior |
| :--- | :--- | :--- |
| `remove()` / `removeFirst()` | Removes the head element | Throws `NoSuchElementException` |
| `removeLast()` | Removes the tail element | Throws `NoSuchElementException` |
| `remove(int index)` | Removes element at index | Throws `IndexOutOfBoundsException` |
| `remove(Object o)` | Removes first occurrence of `o` | Returns `false` |
| `clear()` | Flushes all nodes | Resets size to 0 |

```java
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Red");
        list.add("Blue");
        list.add("Green");

        list.removeFirst(); // Removes "Red"
        list.remove(1);     // Removes "Green" (new index 1)
        
        System.out.println(list); // [Blue]
        
        list.clear(); // Empties list
    }
}
```

---

## Key Takeaways

* Adding elements at both ends is $\mathcal{O}(1)$, while inserting at an index requires traversing to that index first.
* Accessing elements using `peek()` methods is safer than `getFirst()` because they return `null` instead of throwing exceptions when the list is empty.
* Removing elements updates pointer variables, making modifications fast and efficient compared to array shifting.

---

**Back to Module Home:** [Collection Framework Index](../README.md)
