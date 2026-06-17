# Abstract Class vs Interface in Java

> **Chapter 08 - Abstract Features of Java**

---

# Introduction

Both **Abstract Classes** and **Interfaces** are used to achieve **abstraction** in Java. They help define a common structure for multiple classes, but they are used in different situations.

Understanding the difference between them is one of the most important Java interview topics.

---

# Why Do We Need Them?

Suppose we are developing a payment application.

All payment methods have a common operation:

- Make Payment

Different payment methods are:

- Credit Card
- UPI
- Net Banking

We need a common design.

This can be achieved using either an **Abstract Class** or an **Interface**, depending on the requirement.

---

# Abstract Class

An **Abstract Class** is a class declared using the `abstract` keyword.

It can contain:

- Abstract methods
- Concrete methods
- Constructors
- Variables
- Static methods
- Final methods

Example:

```java
abstract class Animal {

    abstract void sound();

    void eat() {
        System.out.println("Animal is eating");
    }
}
```

---

# Interface

An **Interface** is a blueprint of a class.

It mainly defines **what a class should do**, not **how it should do it**.

Example:

```java
interface Animal {

    void sound();

}
```

---

# Comparison Table

| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| Keyword | `abstract class` | `interface` |
| Object Creation | ❌ Not Allowed | ❌ Not Allowed |
| Constructor | ✅ Yes | ❌ No |
| Instance Variables | ✅ Yes | ❌ No |
| Constants | ✅ Yes | ✅ (`public static final`) |
| Abstract Methods | ✅ Yes | ✅ Yes |
| Concrete Methods | ✅ Yes | ✅ Default & Static Methods |
| Static Methods | ✅ Yes | ✅ Yes |
| Final Methods | ✅ Yes | ❌ No |
| Inheritance | `extends` | `implements` |
| Multiple Inheritance | ❌ No | ✅ Yes |
| Main Purpose | Code Reuse | Define a Contract |

---

# Syntax

## Abstract Class

```java
abstract class Animal {

    abstract void sound();

}
```

## Interface

```java
interface Animal {

    void sound();

}
```

---

# Example Using Abstract Class

```java
abstract class Animal {

    abstract void sound();

    void eat() {

        System.out.println("Animal is Eating");

    }

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog Barks");

    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
        dog.sound();

    }

}
```

### Output

```
Animal is Eating
Dog Barks
```

---

# Example Using Interface

```java
interface Animal {

    void sound();

}

class Dog implements Animal {

    @Override
    public void sound() {

        System.out.println("Dog Barks");

    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sound();

    }

}
```

### Output

```
Dog Barks
```

---

# Memory Representation

## Abstract Class

```
Animal Reference
       │
       ▼
+----------------+
| Dog Object     |
+----------------+
```

## Interface

```
Animal Reference
       │
       ▼
+----------------+
| Dog Object     |
+----------------+
```

---

# Key Differences

## 1. Constructors

### Abstract Class

```java
abstract class A {

    A() {

        System.out.println("Constructor");

    }

}
```

✔ Allowed

### Interface

Constructors are **not allowed**.

---

## 2. Variables

### Abstract Class

```java
int age = 20;
```

Normal instance variables are allowed.

### Interface

```java
int AGE = 20;
```

Automatically becomes:

```java
public static final int AGE = 20;
```

---

## 3. Inheritance

### Abstract Class

```java
class Dog extends Animal {

}
```

Uses **extends**.

---

### Interface

```java
class Dog implements Animal {

}
```

Uses **implements**.

---

## 4. Multiple Inheritance

Abstract Class

```java
class C extends A {

}
```

Only one class can be extended.

Interface

```java
class C implements A, B {

}
```

A class can implement multiple interfaces.

---

## 5. Code Reuse

Abstract Class

✔ Provides shared implementation.

Interface

✔ Provides a common contract.

---

# When to Use an Abstract Class?

Use an Abstract Class when:

- Classes are closely related.
- Common code needs to be shared.
- Constructors are required.
- Instance variables are required.
- Partial implementation is needed.

Example:

```
Vehicle

├── Car

├── Bike

└── Bus
```

---

# When to Use an Interface?

Use an Interface when:

- Different classes need the same capability.
- Multiple inheritance is required.
- Only behavior (contract) is needed.

Example:

```
Flyable

├── Bird

├── Airplane

└── Drone
```

---

# Advantages

## Abstract Class

- Code reuse
- Partial abstraction
- Constructors allowed
- Common implementation

## Interface

- Multiple inheritance
- Loose coupling
- Flexible design
- Easy to extend

---

# Real-World Example

### Abstract Class

```
Vehicle

├── Engine

├── Fuel Tank

└── start()
```

All vehicles share common implementation.

---

### Interface

```
Printable

├── Printer

├── PDF Generator

└── Report Generator
```

Different classes follow the same contract.

---

# Common Mistakes

### Mistake 1

Using an Interface when common implementation is needed.

### Mistake 2

Using an Abstract Class just to declare one method.

### Mistake 3

Trying to instantiate either.

```java
new Animal();
```

❌ Compilation Error

---

# Best Practices

- Use **Abstract Classes** for **code reuse**.
- Use **Interfaces** for **contracts**.
- Prefer Interfaces for loosely coupled applications.
- Prefer Abstract Classes when child classes share state and implementation.

---

# Interview Questions

### Beginner

1. What is an Abstract Class?
2. What is an Interface?
3. Can we create objects of either?

### Intermediate

4. Difference between Abstract Class and Interface?
5. Why does Java support multiple interfaces but not multiple class inheritance?
6. Can an Abstract Class implement an Interface?

### Advanced

7. When would you choose an Abstract Class over an Interface?
8. Can an Interface extend another Interface?
9. Can an Abstract Class contain only concrete methods?

---

# Quick Revision

| Use Abstract Class When | Use Interface When |
|--------------------------|--------------------|
| Need common code | Need common behavior |
| Need constructors | Need multiple inheritance |
| Need instance variables | Need loose coupling |
| Related classes | Unrelated classes |

---

# Key Takeaways

- **Abstract Class** provides **partial implementation** and supports code reuse.
- **Interface** provides a **contract** that implementing classes must follow.
- Abstract Classes use `extends`.
- Interfaces use `implements`.
- A class can extend only one abstract class but can implement multiple interfaces.

---

# Conclusion

Both Abstract Classes and Interfaces are powerful tools for achieving abstraction in Java. Choose an **Abstract Class** when classes share common state and behavior, and choose an **Interface** when you want to define a common capability that multiple unrelated classes can implement. Selecting the right one leads to cleaner, more maintainable, and scalable Java applications.
