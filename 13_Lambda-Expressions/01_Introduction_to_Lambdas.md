# Introduction to Lambda Expressions in Java

## The Paradigm Shift: Imperative vs. Functional

Before Java 8, Java was almost purely **Imperative** and object-oriented. To pass behavior to a method (e.g. a thread task or a sorting comparator), you had to wrap it inside an object (often an Anonymous Inner Class). This resulted in highly verbose "boilerplate" code:

```java
// Legacy Imperative Approach (Anonymous Class)
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running in thread...");
    }
};
```

Java 8 introduced **Functional Programming** paradigms using **Lambda Expressions**. A Lambda Expression is an anonymous function—a function without a name, return type, or class wrapper—that can be passed around as data:

```java
// Functional Approach (Lambda Expression)
Runnable r = () -> System.out.println("Running in thread...");
```

---

## Lambda Syntax

The basic syntax of a Lambda Expression consists of three parts:

```text
 (parameters)    ->     { body }
 └─────┬────┘    │      └───┬──┘
   Arguments   Arrow    Code block
```

### Syntax Configurations

#### 1. Single Statement (Expression Body)
If the body has only one statement, curly braces, semicolons, and the `return` keyword are optional:
```java
(int a, int b) -> a + b
```

#### 2. Multiple Statements (Block Body)
If the body has multiple lines of code, you must enclose them in curly braces, use semicolons, and explicitly write the `return` keyword:
```java
(int a, int b) -> {
    int sum = a + b;
    return sum;
}
```

#### 3. Single Parameter (No Parenthesis)
If a lambda accepts exactly one parameter, the parenthesis around the parameter can be omitted:
```java
name -> System.out.println("Hello " + name)
```

---

## Type Inference

The Java compiler determines the types of lambda parameters automatically based on the context in which the lambda is declared (the target type). This mechanism is called **Type Inference**.

```java
// Explicit Parameter Types
BinaryOperator<Integer> add1 = (Integer x, Integer y) -> x + y;

// Inferred Parameter Types (Types are omitted, compiler infers they are Integers)
BinaryOperator<Integer> add2 = (x, y) -> x + y;
```

---

## Key Takeaways

* Lambda expressions introduce functional programming to Java, reducing boilerplate code.
* A lambda consists of parameters, the arrow operator (`->`), and a body.
* The Java compiler uses type inference to determine parameter types from the context.

---

**Back to Module Home:** [Module Index](README.md)
