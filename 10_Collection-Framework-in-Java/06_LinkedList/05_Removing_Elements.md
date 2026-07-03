# Removing Elements from a LinkedList in Java

## Introduction

After learning how to add elements to a `LinkedList`, the next important operation is **removing elements**.

Java provides several methods to remove elements from a LinkedList. You can remove an element:

* From the beginning
* From the end
* From a specific index
* By specifying the element value
* By removing all elements

Since LinkedList stores data as connected nodes, removing an element usually involves updating the links between nodes rather than shifting elements like an ArrayList.

This makes LinkedList an efficient choice when frequent deletions are required.

---

# Learning Objectives

After completing this topic, you will be able to:

* Remove elements using different methods.
* Remove an element by index.
* Remove an element by value.
* Remove the first element.
* Understand how LinkedList updates its node references.
* Identify common mistakes while deleting elements.

---

# Problem Statement

Suppose you are developing a **Student Attendance System**.

Students may:

* Leave the class.
* Cancel their registration.
* Be removed from a waiting list.

Your application should efficiently remove students from different positions in the list.

LinkedList provides several methods to perform these operations.

---

# Methods Used to Remove Elements

| Method                    | Description                                           |
| ------------------------- | ----------------------------------------------------- |
| `remove()`                | Removes the first element                             |
| `remove(int index)`       | Removes the element at the specified index            |
| `remove(Object object)`   | Removes the first occurrence of the specified element |
| `removeFirst()`           | Removes the first element                             |
| `removeLast()`            | Removes the last element                              |
| `removeFirstOccurrence()` | Removes the first matching element                    |
| `removeLastOccurrence()`  | Removes the last matching element                     |
| `clear()`                 | Removes all elements                                  |

---

# 1. Using `remove()`

The `remove()` method removes the **first element** from the LinkedList.

## Syntax

```java
linkedList.remove();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");

        fruits.remove();

        System.out.println(fruits);
    }
}
```

---

## Output

```text
[Banana, Mango]
```

---

## Step-by-Step Explanation

Initially

```text
Apple → Banana → Mango
```

After executing

```java
fruits.remove();
```

Result

```text
Banana → Mango
```

The first node is removed.

The second node becomes the new head of the LinkedList.

---

## Internal Working

Before

```text
Head
 |

 v

+-----------+     +------------+     +-----------+
| Apple | -----> | Banana | -----> | Mango |
+-----------+     +------------+     +-----------+
```

After

```text
Head
 |

 v

+------------+     +-----------+
| Banana | -----> | Mango |
+------------+     +-----------+
```

Only the head reference changes.

No remaining elements are shifted.

---

# 2. Using `remove(int index)`

This method removes the element at a specified index.

## Syntax

```java
linkedList.remove(index);
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> cities = new LinkedList<>();

        cities.add("Chennai");
        cities.add("Coimbatore");
        cities.add("Madurai");
        cities.add("Salem");

        cities.remove(2);

        System.out.println(cities);
    }
}
```

---

## Output

```text
[Chennai, Coimbatore, Salem]
```

---

## Step-by-Step Explanation

Before removal

```text
Chennai → Coimbatore → Madurai → Salem
```

Remove element at index **2**

```text
Madurai
```

After removal

```text
Chennai → Coimbatore → Salem
```

The node containing **Madurai** is disconnected from the LinkedList.

---

## Internal Working

Before

```text
Head

 |

 v

+----------+     +--------------+     +-----------+     +---------+
| Chennai | --> | Coimbatore | --> | Madurai | --> | Salem |
+----------+     +--------------+     +-----------+     +---------+
```

After

```text
Head

 |

 v

+----------+     +--------------+     +---------+
| Chennai | --> | Coimbatore | --> | Salem |
+----------+     +--------------+     +---------+
```

The previous node is directly linked to the next node.

---

# 3. Using `remove(Object object)`

This method removes the **first occurrence** of the specified object.

## Syntax

```java
linkedList.remove(object);
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> colors = new LinkedList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Blue");

        colors.remove("Blue");

        System.out.println(colors);
    }
}
```

---

## Output

```text
[Red, Green, Blue]
```

---

## Explanation

Only the **first occurrence** of `"Blue"` is removed.

Before

```text
Red → Blue → Green → Blue
```

After

```text
Red → Green → Blue
```

The second `"Blue"` remains in the list.

---

## Internal Working

Java traverses the LinkedList from the beginning.

```text
Red

↓

Blue  ← Match Found

↓

Green

↓

Blue
```

After finding the first matching node:

* The node is removed.
* References are updated.
* Traversal stops.

---

# 4. Using `removeFirst()`

The `removeFirst()` method removes the first node from the LinkedList.

## Syntax

```java
linkedList.removeFirst();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> names = new LinkedList<>();

        names.add("Sanjay");
        names.add("Rahul");
        names.add("Arun");

        names.removeFirst();

        System.out.println(names);
    }
}
```

---

## Output

```text
[Rahul, Arun]
```

---

## Step-by-Step Explanation

Before

```text
Sanjay → Rahul → Arun
```

After

```text
Rahul → Arun
```

The first node is deleted.

The second node becomes the new head.

---

## Difference Between `remove()` and `removeFirst()`

| Method          | Description               |
| --------------- | ------------------------- |
| `remove()`      | Removes the first element |
| `removeFirst()` | Removes the first element |

Both methods perform the same operation.

The difference is mainly in readability.

`removeFirst()` clearly indicates that the first node is being removed.

---

# Program Flow

```text
Create LinkedList

        │

        ▼

Choose Remove Method

        │

        ▼

Locate Target Node

        │

        ▼

Update Node References

        │

        ▼

Decrease List Size

        │

        ▼

Display Updated LinkedList
```

---

# Common Mistakes

## Removing from an Empty LinkedList

```java
LinkedList<String> list = new LinkedList<>();

list.remove();
```

This throws a `NoSuchElementException`.

---

## Using an Invalid Index

```java
list.remove(10);
```

If the index does not exist, Java throws an `IndexOutOfBoundsException`.

---

## Assuming All Duplicate Elements Are Removed

```java
list.remove("Java");
```

Only the **first occurrence** is removed.

Remaining duplicates stay in the list.

---

# Best Practices

* Check whether the LinkedList is empty before removing elements.
* Validate indexes before using `remove(index)`.
* Use `remove(Object)` when the element value is known.
* Use `removeFirst()` when the intention is to remove the first node.
* Handle exceptions appropriately in production applications.

---
# 5. Using `removeLast()`

The `removeLast()` method removes the **last element** from the LinkedList.

## Syntax

```java
linkedList.removeLast();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> subjects = new LinkedList<>();

        subjects.add("Java");
        subjects.add("Python");
        subjects.add("C++");

        subjects.removeLast();

        System.out.println(subjects);
    }
}
```

---

## Output

```text
[Java, Python]
```

---

## Step-by-Step Explanation

Before removal

```text
Java → Python → C++
```

After removal

```text
Java → Python
```

The last node is removed, and the second last node becomes the new tail of the LinkedList.

---

## Internal Working

Before

```text
Head

 |

 v

+--------+     +----------+     +------+
| Java | ----> | Python | ----> | C++ |
+--------+     +----------+     +------+
```

After

```text
Head

 |

 v

+--------+     +----------+
| Java | ----> | Python |
+--------+     +----------+
```

The reference of the new last node is updated to `null`.

---

# 6. Using `removeFirstOccurrence()`

This method removes the **first occurrence** of the specified element.

## Syntax

```java
linkedList.removeFirstOccurrence(element);
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> colors = new LinkedList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Blue");

        colors.removeFirstOccurrence("Blue");

        System.out.println(colors);
    }
}
```

---

## Output

```text
[Red, Green, Blue]
```

---

## Explanation

Before

```text
Red → Blue → Green → Blue
```

After

```text
Red → Green → Blue
```

Only the first matching node is removed.

---

# 7. Using `removeLastOccurrence()`

This method removes the **last occurrence** of the specified element.

## Syntax

```java
linkedList.removeLastOccurrence(element);
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<String> colors = new LinkedList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Blue");

        colors.removeLastOccurrence("Blue");

        System.out.println(colors);
    }
}
```

---

## Output

```text
[Red, Blue, Green]
```

---

## Explanation

Before

```text
Red → Blue → Green → Blue
```

After

```text
Red → Blue → Green
```

Only the last matching element is removed.

---

# 8. Using `clear()`

The `clear()` method removes **all elements** from the LinkedList.

## Syntax

```java
linkedList.clear();
```

---

## Example

```java
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> numbers = new LinkedList<>();

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        numbers.clear();

        System.out.println(numbers);
    }
}
```

---

## Output

```text
[]
```

---

## Internal Working

Before

```text
10 → 20 → 30
```

After

```text
Head → null

Tail → null

Size = 0
```

All node references are removed, making the LinkedList empty.

---

# Complete Internal Working of Removal

Whenever a remove operation is performed, Java follows these general steps:

1. Locate the node to be removed.
2. Identify the previous and next nodes.
3. Update the references.
4. Disconnect the removed node.
5. Decrease the size of the LinkedList.

Example

Before

```text
10 → 20 → 30 → 40
```

Remove **30**

```text
10 → 20 ------> 40
```

The node containing **30** is disconnected from the chain.

---

# Program Flow

```text
Start

   │

   ▼

Create LinkedList

   │

   ▼

Choose Remove Method

   │

   ▼

Locate Required Node

   │

   ▼

Update References

   │

   ▼

Decrease List Size

   │

   ▼

Display Updated LinkedList

   │

   ▼

End
```

---

# Comparison of Removal Methods

| Method                    | Removes                    |
| ------------------------- | -------------------------- |
| `remove()`                | First element              |
| `remove(int index)`       | Element at the given index |
| `remove(Object)`          | First matching object      |
| `removeFirst()`           | First element              |
| `removeLast()`            | Last element               |
| `removeFirstOccurrence()` | First matching occurrence  |
| `removeLastOccurrence()`  | Last matching occurrence   |
| `clear()`                 | All elements               |

---

# Common Exceptions

| Exception                   | Cause                                                                                               |
| --------------------------- | --------------------------------------------------------------------------------------------------- |
| `NoSuchElementException`    | Removing from an empty LinkedList using methods like `remove()`, `removeFirst()`, or `removeLast()` |
| `IndexOutOfBoundsException` | Using an invalid index                                                                              |
| `NullPointerException`      | Calling methods on an uninitialized LinkedList reference                                            |

---

# Common Mistakes

### Confusing `remove(index)` and `remove(object)`

```java
LinkedList<Integer> numbers = new LinkedList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(1);
```

This removes the element at **index 1**, not the value `1`.

---

### Forgetting to Check if the List is Empty

```java
list.removeFirst();
```

Always check:

```java
if (!list.isEmpty()) {
    list.removeFirst();
}
```

---

### Assuming `clear()` Deletes the LinkedList Object

Incorrect understanding:

```text
LinkedList object is deleted.
```

Correct understanding:

The object still exists, but all its elements are removed.

---

# Best Practices

* Check `isEmpty()` before removing elements.
* Validate indexes before using `remove(index)`.
* Use `remove(Object)` when the value is known.
* Use `clear()` when all elements need to be removed.
* Write meaningful exception handling for robust applications.

---

# Interview Questions

1. What is the difference between `remove()` and `removeFirst()`?
2. How does `removeLast()` work internally?
3. What is the purpose of `remove(Object)`?
4. Explain `removeFirstOccurrence()` with an example.
5. Explain `removeLastOccurrence()` with an example.
6. What does `clear()` do?
7. Which exception occurs when removing from an empty LinkedList?
8. What happens internally when a node is removed?
9. Why doesn't LinkedList shift elements during deletion?
10. Which removal method would you use to delete all elements?

---

# Practice Programs

1. Remove the first element from a LinkedList.
2. Remove the last element.
3. Remove an element using its index.
4. Remove a city name by value.
5. Remove duplicate values using `removeFirstOccurrence()`.
6. Remove the last occurrence of a number.
7. Create a menu-driven LinkedList deletion program.
8. Clear an entire LinkedList.
9. Remove employee objects from a LinkedList.
10. Build a waiting list application where users can leave the queue.

---

# Key Takeaways

* LinkedList provides multiple methods for removing elements.
* Removing nodes updates references instead of shifting elements.
* `remove()` and `removeFirst()` remove the first element.
* `removeLast()` removes the last element.
* `remove(Object)` removes the first matching object.
* `removeFirstOccurrence()` and `removeLastOccurrence()` are useful when duplicate values exist.
* `clear()` removes all elements but does not delete the LinkedList object.
* Proper exception handling makes LinkedList operations safer.

---

# Conclusion

Removing elements is one of the major advantages of using a LinkedList. Since elements are connected using references, deleting a node only requires updating the links between neighboring nodes, making the operation efficient compared to array-based data structures. Java provides a variety of removal methods to handle different scenarios, allowing developers to choose the most suitable approach based on the application's requirements.

In the next chapter, we will learn how to **access and retrieve elements** from a LinkedList using methods such as `get()`, `getFirst()`, `getLast()`, `peek()`, `element()`, and related retrieval operations.
