# Lambda Expressions in Java

> **Chapter 09 - Advanced Java Class Concepts**

---

# Introduction

Lambda Expressions were introduced in **Java 8** and are one of the biggest improvements to the Java programming language.

Before Java 8, implementing interfaces with only one method required creating a separate class or using an Anonymous Inner Class.

This resulted in a lot of unnecessary code.

Lambda Expressions make Java code:

- Shorter
- Cleaner
- Easier to read
- Easier to maintain

Today, Lambda Expressions are used extensively in:

- Collections Framework
- Stream API
- Multithreading
- Event Handling
- Functional Programming
- Spring Framework
- Hibernate
- Android Development

---

# Problem Statement

Suppose we have an interface.

```java
interface Greeting {

    void sayHello();

}
```

Before Java 8,

we had to write

```java
class Student implements Greeting {

    @Override
    public void sayHello() {

        System.out.println("Hello");

    }

}
```

or

```java
Greeting g = new Greeting() {

    @Override
    public void sayHello() {

        System.out.println("Hello");

    }

};
```

Both approaches require a lot of code.

Since the interface contains only **one method**, Java 8 introduced Lambda Expressions.

---

# Why Do We Need Lambda Expressions?

Suppose we only want to tell Java

```
Print Hello
```

Instead of writing

```
Create Class

↓

Create Object

↓

Override Method

↓

Call Method
```

We can simply write

```java
() -> System.out.println("Hello");
```

---

# Real-World Analogy

Imagine ordering food.

Old Method

```
Walk to Restaurant

↓

Read Menu

↓

Place Order

↓

Wait

↓

Collect Food
```

New Method

```
Open App

↓

Click Order

↓

Done
```

Lambda Expressions remove unnecessary steps.

---

# Definition

A Lambda Expression is an anonymous function that provides the implementation of a functional interface.

It has:

- No name
- No return type declaration
- No access modifier
- Can take parameters
- Can return values

---

# Requirements

Lambda Expressions work only with

```
Functional Interfaces
```

A Functional Interface contains exactly

```
ONE

Abstract Method
```

Example

```java
@FunctionalInterface
interface Demo {

    void show();

}
```

---

# Basic Syntax

```java
(parameters) -> expression
```

or

```java
(parameters) -> {

    statements;

}
```

---

# Structure

```
(parameter)

      │

      ▼

      ->

      │

      ▼

Implementation
```

---

# First Lambda Program

```java
@FunctionalInterface
interface Greeting {

    void sayHello();

}

public class Main {

    public static void main(String[] args) {

        Greeting g = () -> System.out.println("Hello Java");

        g.sayHello();

    }

}
```

---

# Output

```
Hello Java
```

---

# Explanation

Instead of

```java
class Student implements Greeting
```

Java creates the implementation automatically.

---

# Execution Flow

```
Greeting Interface

        │

        ▼

Lambda Expression

        │

        ▼

Object Created

        │

        ▼

sayHello()

        │

        ▼

Print

Hello Java
```

---

# Memory Representation

```
Stack

+------------------+
| g                |
+--------|---------+
         |
         ▼

Heap

+----------------------+
| Lambda Object        |
| sayHello()           |
+----------------------+
```

---

# Lambda Without Parameters

```java
@FunctionalInterface
interface Message {

    void display();

}

public class Main {

    public static void main(String[] args) {

        Message m = () -> System.out.println("Welcome");

        m.display();

    }

}
```

---

# Output

```
Welcome
```

---

# Lambda With One Parameter

```java
@FunctionalInterface
interface Square {

    void printSquare(int number);

}

public class Main {

    public static void main(String[] args) {

        Square s = number -> System.out.println(number * number);

        s.printSquare(5);

    }

}
```

---

# Output

```
25
```

---

# Lambda With Multiple Parameters

```java
@FunctionalInterface
interface Addition {

    int add(int a, int b);

}

public class Main {

    public static void main(String[] args) {

        Addition sum = (a, b) -> a + b;

        System.out.println(sum.add(10, 20));

    }

}
```

---

# Output

```
30
```

---

# Lambda Returning Value

```java
@FunctionalInterface
interface Multiply {

    int multiply(int a, int b);

}

public class Main {

    public static void main(String[] args) {

        Multiply m = (a, b) -> {

            return a * b;

        };

        System.out.println(m.multiply(4, 5));

    }

}
```

---

# Output

```
20
```

---

# Different Syntax Variations

### With Braces

```java
(a, b) -> {

    return a + b;

}
```

### Without Braces

```java
(a, b) -> a + b
```

---

### With Parameter Type

```java
(int a, int b) -> a + b
```

---

### Without Parameter Type

```java
(a, b) -> a + b
```

---

### Single Parameter

```java
number -> number * number
```

---

### Zero Parameter

```java
() -> System.out.println("Hello")
```

---

# Rules

✅ Works only with Functional Interfaces.

✅ Can have zero parameters.

✅ Can have one parameter.

✅ Can have multiple parameters.

✅ Can return values.

---

# Advantages

- Less code
- Better readability
- Easier maintenance
- Functional programming support
- Better collection processing
- Stream API support

---

# Limitations

- Works only with Functional Interfaces.
- Cannot replace every anonymous class.
- Harder to debug in complex scenarios.

---

# Common Mistakes

### Wrong

```java
(a,b)->{

a+b;

}
```

Missing return.

Correct

```java
(a,b)->{

return a+b;

}
```

---

### Wrong

```java
()->

```

Missing implementation.

---

# Best Practices

- Keep Lambda Expressions short.
- Avoid complex logic.
- Use meaningful variable names.
- Prefer method references when possible.
- Use built-in Functional Interfaces.

---

# Key Takeaways (Part 1)

- Lambda Expressions were introduced in Java 8.
- They reduce boilerplate code.
- They work only with Functional Interfaces.
- They can accept parameters.
- They can return values.
- They improve readability and maintainability.
