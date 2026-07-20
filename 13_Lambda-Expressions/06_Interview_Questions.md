# Lambda Expressions Interview Questions

## Beginner Questions

### Q1: What is a Lambda Expression in Java?
**Answer:**
A Lambda Expression is an anonymous function (a function with parameters and a body, but without a name or class wrapper) that is used to implement a functional interface. It allows passing behavior as an argument to a method.

### Q2: What is a Functional Interface?
**Answer:**
A Functional Interface is an interface that has **exactly one abstract method**. It can have any number of default and static methods. It is decorated with `@FunctionalInterface` to enforce this rule at compile time.

---

## Intermediate Questions

### Q3: Why do local variables used inside lambda expressions have to be final or effectively final?
**Answer:**
Local variables reside on the stack and are destroyed when their enclosing method returns. Lambdas reside on the heap and can be executed at a later time. To keep the variable accessible, the compiler copies its value. If the variable could be modified, the copy would go out of sync. To prevent this, Java requires captured local variables to be read-only (effectively final).

### Q4: What is the difference between a Lambda Expression and an Anonymous Inner Class?
**Answer:**
1. **Scope**: Anonymous classes create a new scope (where `this` refers to the anonymous class instance). Lambdas are lexically scoped (where `this` refers to the enclosing class instance).
2. **Compilation**: Anonymous inner classes are compiled into separate physical class files (e.g. `Main$1.class`). Lambdas are compiled using `invokedynamic` bytecode instructions, which dynamically bind the lambda behavior without creating extra class files.
3. **Memory**: Anonymous classes allocate memory for a new object instance on every execution. Lambdas are highly optimized by the JVM, often reusing instances.

---

## Advanced Questions

### Q5: How are Lambda Expressions compiled internally under the hood?
**Answer:**
Instead of compiling the lambda into an anonymous inner class, the Java compiler:
1. Generates a private static method inside the enclosing class containing the lambda body's logic.
2. Uses the **`invokedynamic` (Indy)** bytecode instruction to dynamically create a call site.
3. On first execution, the JVM bootstrap method calls `LambdaMetafactory.metafactory()`, which dynamically generates a light class implementer using internal JVM magic (often generating a direct call to the static method). This design avoids class loading overhead and improves startup times.

### Q6: Can a Lambda Expression access non-final instance fields of its enclosing class?
**Answer:**
Yes. A lambda can read and modify instance variables of its enclosing class even if they are not final or effectively final. This is because instance variables reside on the Heap (inside the enclosing object). The lambda implicitly captures a reference to `this` (the enclosing object) rather than copying individual primitive values, so the variables remain alive and accessible.

---

**Back to Module Home:** [Module Index](README.md)
