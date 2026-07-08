# ArrayList in Java: Traversal and Sorting

## Introduction

After mastering basic CRUD operations, the next step is **traversal** (visiting every element sequentially) and **sorting/searching** data elements stored inside an `ArrayList`.

---

## 1. Traversing an ArrayList

Java provides five different ways to traverse list elements:

### Method A: Enhanced `for-each` Loop (Simplest and most common):
```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

### Method B: Iterator (Safe for removing elements during loop):
Using standard loops to remove elements while traversing causes a `ConcurrentModificationException`. The `Iterator` interface provides a safe `remove()` method:
```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        Iterator<String> it = fruits.iterator();
        while (it.hasNext()) {
            String fruit = it.next();
            if ("Banana".equals(fruit)) {
                it.remove(); // Safe removal
            }
        }
        System.out.println(fruits); // Output: [Apple, Orange]
    }
}
```

### Method C: Java 8 `forEach` (Concise Lambda style):
```java
fruits.forEach(fruit -> System.out.println(fruit));
// Or using method reference:
fruits.forEach(System.out::println);
```

---

## 2. Sorting and Searching

### Sorting Elements (`Collections.sort`):
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(40);
        numbers.add(10);
        numbers.add(30);

        Collections.sort(numbers); // Ascending sort
        System.out.println("Sorted: " + numbers); // [10, 30, 40]
    }
}
```

### Searching Elements (`Collections.binarySearch`):
> [!IMPORTANT]
> The list must be sorted in ascending order before executing binary search.

```java
int index = Collections.binarySearch(numbers, 30);
System.out.println("Index of 30: " + index); // 1
```

---

## Traversal Options Matrix

| Traversal Method | Read-Only | Allows Element Removal | Directional Support |
| :--- | :---: | :---: | :--- |
| **Traditional `for` loop**| ✅ Yes | ❌ Dangerous (causes index shifts) | Forward / Backward |
| **Enhanced `for-each`**| ✅ Yes | ❌ Throws `ConcurrentModificationException` | Forward only |
| **`Iterator`** | ✅ Yes | ✅ Yes (via `iterator.remove()`) | Forward only |
| **`ListIterator`** | ✅ Yes | ✅ Yes (allows add/set/remove) | Bidirectional (Forward/Backward) |
| **`forEach()` (Lambda)** | ✅ Yes | ❌ Throws `ConcurrentModificationException` | Forward only |

---

## Key Takeaways

* For simple read-only prints, use the enhanced `for-each` loop or `forEach()` lambdas.
* Use `Iterator` if you need to delete elements safely during traversal.
* Use `ListIterator` if you need to travel bidirectionally (using `hasPrevious()` and `previous()`).
* Always sort list elements before performing binary searches.

---

**Back to Module Home:** [Collection Framework Index](../README.md)
