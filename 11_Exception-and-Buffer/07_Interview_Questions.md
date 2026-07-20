# Exception and Buffer Interview Questions

## Beginner Questions

### Q1: What is the base class for all exceptions and errors in Java?
**Answer:**
`java.lang.Throwable` is the superclass of all errors and exceptions. Only objects that inherit from `Throwable` can be thrown by the JVM or via the `throw` statement.

### Q2: What is the difference between final, finally, and finalize?
**Answer:**
* **`final`**: A keyword modifier used to make a variable constant, prevent a method from being overridden, or prevent a class from being inherited.
* **`finally`**: A block used in try-catch structures that is guaranteed to execute for resource cleanup.
* **`finalize()`**: A protected method in `java.lang.Object` invoked by the garbage collector before reclaiming an object's memory (deprecated since Java 9).

---

## Intermediate Questions

### Q3: What happens if an exception is thrown in a `finally` block?
**Answer:**
If an exception is thrown in a `finally` block, it shadows (discards) any exception that was previously thrown in the `try` or `catch` blocks. The new exception propagates up the call stack. This issue is resolved in Java 7+ using the **try-with-resources** statement, where exceptions thrown during closure are added as suppressed exceptions instead.

### Q4: Why is `StringBuilder` preferred over `StringBuffer` in local methods?
**Answer:**
`StringBuffer` has synchronized methods, which means it acquires thread locks for every operation. When working within a local method, variables are stack-confined and cannot be accessed by other threads. Using `StringBuilder` avoids this synchronization overhead, making string operations faster.

### Q5: How does try-with-resources automatically close resources?
**Answer:**
The compiler automatically generates a hidden `finally` block. Inside this block, the compiler inserts calls to the resource's `close()` method, enclosing them in null checks and try-catch blocks to capture suppressed exceptions.

---

## Advanced Questions

### Q6: Can we catch `Error` in a try-catch block?
**Answer:**
Yes. Since `Error` inherits from `Throwable`, you can catch it using `catch (Error e)`. However, **this is highly discouraged**. Errors (like `OutOfMemoryError`) represent fatal VM depletion states where the application cannot reliably recover.

### Q7: If `String` is immutable, how is it concatenated using the `+` operator internally?
**Answer:**
Since Java 5, string concatenations (like `s1 + s2`) are compiled into `StringBuilder.append()` calls:
```java
// What you write:
String s = a + b;

// What the compiler generates:
String s = new StringBuilder().append(a).append(b).toString();
```
Starting from Java 9, the compiler utilizes `invokedynamic` with `StringConcatFactory` to optimize this further, avoiding object allocation overheads when possible.

---

**Back to Module Home:** [Module Index](README.md)
