# Stack Interview Questions and Answers

## Beginner Questions

### Q1: What is the LIFO principle?
**Answer:**
LIFO stands for **Last-In, First-Out**. The last element added to the stack is the first one to be removed.

### Q2: What is the difference between pop() and peek() methods?
**Answer:**
* `pop()` returns and removes the element at the top of the stack.
* `peek()` returns the element at the top of the stack without removing it.

---

## Intermediate Questions

### Q3: Why is java.util.Stack considered legacy, and what is its recommended alternative?
**Answer:**
`Stack` extends `Vector`, which synchronizes every method call. This introduces unnecessary locking overhead in single-threaded applications. 
The recommended alternative is **`ArrayDeque`**, which implements the `Deque` interface and is unsynchronized.

### Q4: What does the search() method return?
**Answer:**
The `search(Object o)` method returns the 1-based distance from the top of the stack if the element is found. If the element is not found, it returns `-1`.

---

## Advanced Questions

### Q5: Explain how the Call Stack handles recursive methods.
**Answer:**
When a method is called, the JVM pushes an activation record (or stack frame) containing local variables and parameters onto the Call Stack. 
If the method calls itself recursively, a new stack frame is pushed for each nested call. When a frame exits, it is popped off the stack, returning execution to the previous frame. If there is no base case, the stack continues to grow until it throws a `StackOverflowError`.

---

**Back to Stacks Home:** [Stacks Index](../README.md)
