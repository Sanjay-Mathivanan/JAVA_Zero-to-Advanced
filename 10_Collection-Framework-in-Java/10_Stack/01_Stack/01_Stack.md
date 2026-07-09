# Stack in Java

## Introduction

In programming, we frequently encounter tasks that require processing elements in reverse order of their arrival—such as reversing a string, performing an undo operation in a text editor, or navigating back through browser history.

The Java Collection Framework (JCF) provides the **`Stack`** class to represent a collection designed for Last-In, First-Out (LIFO) operations.

---

## What is a Stack?

A **Stack** is a linear data structure that models a real-world stack of physical items (like a stack of dinner plates or books). You can only place new elements at the top of the stack and remove elements from the top.

---

## Why Do We Need Stack?

A `Stack` enforces strict sequential access rules. It prevents random access to elements in the middle of the collection. This is useful for tracking execution states:
* **JVM Call Stack**: The JVM uses a stack to manage method calls, local variables, and execution frames.
* **Undo/Redo History**: Text editors push user changes onto a stack to support undo actions.

---

## The LIFO Principle

A stack operates on the **Last-In, First-Out (LIFO)** principle:

```text
Push (add) ──> [ Top Node: C ] ──> Pop (remove)
               [ Node B      ]
               [ Bottom Node: A ]
```

The last element pushed onto the stack is the first one popped off.

---

## Creating a Stack

### Basic Initialization
```java
import java.util.Stack;

// Generic format: Stack<Type> stackName = new Stack<>();
Stack<Integer> stack = new Stack<>();
```

Always use Wrapper classes instead of primitive types.

---

## Common Methods

The `Stack` class provides five dedicated methods:

| Method | Description | Time Complexity |
| :--- | :--- | :---: |
| **`push(E item)`** | Pushes the element onto the top of the stack. | `O(1)` |
| **`pop()`** | Removes and returns the element at the top of the stack. | `O(1)` |
| **`peek()`** | Returns the element at the top without removing it. | `O(1)` |
| **`isEmpty()`** | Returns `true` if the stack contains 0 elements. | `O(1)` |
| **`search(Object o)`** | Returns the 1-based distance of the element from the top. Returns `-1` if not found. | `O(N)` |

---

## Complete Example Programs

### Example: Basic Stack Operations
```java
import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        Stack<String> libraryStack = new Stack<>();

        // 1. Push elements
        libraryStack.push("Book A");
        libraryStack.push("Book B");
        libraryStack.push("Book C");

        System.out.println("Stack: " + libraryStack); // [Book A, Book B, Book C]

        // 2. Peek top
        System.out.println("Top Book: " + libraryStack.peek()); // Book C

        // 3. Search element (1-based index from the top)
        System.out.println("Distance of Book A from top: " + libraryStack.search("Book A")); // 3
        System.out.println("Distance of Book C from top: " + libraryStack.search("Book C")); // 1

        // 4. Pop elements
        System.out.println("Popped: " + libraryStack.pop()); // Book C
        System.out.println("Popped: " + libraryStack.pop()); // Book B

        System.out.println("Remaining Stack: " + libraryStack); // [Book A]
    }
}
```

---

## Best Practices

* **Prefer Deque for Stacks**: Although `java.util.Stack` is a standard class, it extends the legacy `Vector` class, meaning all its operations are synchronized. This adds unnecessary overhead. The official Java documentation recommends using **`ArrayDeque`** as a Stack instead:
  ```java
  import java.util.ArrayDeque;
  import java.util.Deque;
  
  Deque<String> stack = new ArrayDeque<>();
  ```
* **Check for Empty Stack**: Always call `isEmpty()` before calling `pop()` or `peek()` to avoid throwing an `EmptyStackException`.

---

## Common Mistakes

* **Random Element Modification**: Avoid calling `add(index, element)` or `get(index)` on a `Stack`. While these inherited methods are technically available because `Stack` extends `Vector`, using them violates the stack data structure design.
* **StackOverflowError**: In recursive algorithms, failing to define a base case will cause the JVM execution stack to overflow, throwing a `StackOverflowError`.

---

## Key Takeaways

* `Stack` is a LIFO data structure.
* Core methods are `push()`, `pop()`, and `peek()`.
* Java recommends using `ArrayDeque` for stack implementations in modern code to avoid the synchronization overhead of `Vector`.

---

## Conclusion

The stack data structure is fundamental to computer science, from local variable memory allocation to parsing expressions. Understanding how to use the LIFO principle is essential for writing algorithmic solutions.

---

**Back to Stacks Home:** [Stacks Index](../README.md)
