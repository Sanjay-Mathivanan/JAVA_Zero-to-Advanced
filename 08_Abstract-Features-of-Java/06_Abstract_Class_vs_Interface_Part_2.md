# Abstract Class vs Interface in Java (Part 2)

> **Chapter 08 - Abstract Features of Java**

---

# 9. Final Methods

## Abstract Class

An Abstract Class **can contain final methods**.

A **final method** means:

- It **can be inherited**
- It **cannot be overridden** by child classes

### Why?

Sometimes the parent class wants to provide a fixed implementation that every child class must use.

---

## Example

```java
abstract class Animal {

    final void sleep() {

        System.out.println("Animals sleep at night.");

    }

    abstract void sound();

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

        dog.sleep();

        dog.sound();

    }

}
```

---

## Output

```
Animals sleep at night.
Dog Barks
```

---

## Can We Override a Final Method?

```java
class Dog extends Animal {

    @Override
    void sleep() {

        System.out.println("Sleeping");

    }

}
```

### Output

```
Compilation Error
```

---

## Interface

Interfaces **cannot have final methods**.

Why?

Every method inside an interface is meant to be implemented or overridden by implementing classes (except static/default/private methods).

A final method would prevent overriding, which goes against the purpose of an interface.

---

# Difference

| Abstract Class | Interface |
|----------------|-----------|
| Final methods allowed | Final methods not allowed |

---

# 10. Inheritance

This is one of the biggest differences.

---

## Abstract Class

Uses the **extends** keyword.

### Syntax

```java
class Dog extends Animal {

}
```

---

### Example

```java
abstract class Animal {

    abstract void sound();

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog Barks");

    }

}
```

Hierarchy

```
Animal

   ▲

   │

 Dog
```

---

## Interface

Uses the **implements** keyword.

### Syntax

```java
class Dog implements Animal {

}
```

---

### Example

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
```

Hierarchy

```
Animal Interface

        ▲

        │

      Dog
```

---

# Why Different Keywords?

**extends**

means

> "is-a"

Example

```
Dog IS-A Animal
```

---

**implements**

means

> "follows the contract"

Example

```
Dog

implements

Animal Interface
```

---

# 11. Multiple Inheritance

## Abstract Class

Java **does not allow** multiple inheritance using classes.

Example

```java
class A {

}

class B {

}

class C extends A, B {

}
```

### Output

```
Compilation Error
```

---

## Why?

Because of the **Diamond Problem**.

---

### Diamond Problem

```
        A

      /   \

     B     C

      \   /

        D
```

Suppose

```
A

has

show()
```

Both

```
B

and

C

override show()
```

Now

```
D
```

inherits both.

Question:

Which

```
show()
```

should Java execute?

```
B.show()

or

C.show()
```

Java cannot decide.

To avoid confusion,

Java does not support multiple class inheritance.

---

## Interface

Interfaces support multiple inheritance.

Example

```java
interface Camera {

    void click();

}

interface Music {

    void play();

}

class Mobile implements Camera, Music {

    @Override
    public void click() {

        System.out.println("Photo Captured");

    }

    @Override
    public void play() {

        System.out.println("Music Playing");

    }

}

public class Main {

    public static void main(String[] args) {

        Mobile mobile = new Mobile();

        mobile.click();

        mobile.play();

    }

}
```

---

## Output

```
Photo Captured
Music Playing
```

---

# Why Is This Allowed?

Interfaces originally contained only abstract methods.

There was no implementation.

Therefore,

there was no ambiguity.

---

# Diagram

```
Camera

      ▲

      │

      │

Mobile

      │

      ▼

Music
```

One class

can implement

multiple interfaces.

---

# 12. Main Purpose

## Abstract Class

Main purpose:

```
Code Reuse
```

Example

```
Vehicle

start()

stop()

fuelTank
```

Every child class reuses this code.

---

## Interface

Main purpose:

```
Contract
```

Example

```
Printable

↓

print()
```

Every class that implements

```
Printable
```

must provide

```
print()
```

---

# Real-World Example

## Abstract Class

```
Vehicle

│

├── Engine

├── Fuel Tank

├── start()

└── stop()
```

Every vehicle shares these features.

---

## Interface

```
GPS

│

├── Car

├── Bike

├── Drone

└── Mobile
```

Different devices support GPS.

They are unrelated classes,

but they follow the same contract.

---

# Decision Tree

```
Need common code?

       │

      YES

       │

       ▼

Abstract Class

-------------------------

Need common behavior?

       │

      YES

       │

       ▼

Interface
```

---

# Real-World Scenario

Suppose we are building a payment application.

```
Payment

↓

Credit Card

UPI

Net Banking
```

If all payment methods share

- transaction ID
- amount
- validation

use

```
Abstract Class
```

If all payment methods only promise

```
pay()
```

use

```
Interface
```

---

# Quick Comparison

| Requirement | Choose |
|-------------|--------|
| Share code | Abstract Class |
| Share behavior | Interface |
| Need constructor | Abstract Class |
| Need instance variables | Abstract Class |
| Need multiple inheritance | Interface |
| Need loose coupling | Interface |

---

# Common Mistakes

## Mistake 1

Using an Abstract Class when only one method is needed.

Better choice

```
Interface
```

---

## Mistake 2

Using an Interface to store object state.

Interfaces should not store instance data.

---

## Mistake 3

Trying to extend multiple classes.

```java
class C extends A, B
```

Compilation Error.

---

## Mistake 4

Forgetting to implement interface methods.

```java
class Dog implements Animal{

}
```

Compilation Error.

---

# Best Practices

✔ Use **Abstract Classes** when classes are closely related.

✔ Use **Interfaces** when classes are unrelated but should follow the same behavior.

✔ Prefer Interfaces for loose coupling.

✔ Prefer Abstract Classes for code reuse.

✔ Keep Abstract Classes focused on shared implementation.

✔ Keep Interfaces focused on behavior.

---

# Interview Questions

## Beginner

1. What is an Abstract Class?
2. What is an Interface?
3. Can we create objects of them?
4. Which keyword is used for inheritance?

---

## Intermediate

5. Difference between `extends` and `implements`?
6. Why can't Interfaces have constructors?
7. Why can an Abstract Class have constructors?
8. Why does Java not support multiple class inheritance?

---

## Advanced

9. Explain the Diamond Problem.
10. Why does Java allow multiple Interfaces?
11. Abstract Class vs Interface?
12. When should you use each?
13. Can an Abstract Class implement an Interface?
14. Can an Interface extend another Interface?
15. Explain with a real-world example.

---

# Practice Programs

## Easy

- Create an `Animal` Abstract Class.
- Create an `Animal` Interface.

---

## Medium

- Build a Vehicle Management System using an Abstract Class.
- Build a Payment System using an Interface.

---

## Hard

- Design a Banking System using both Abstract Classes and Interfaces.
- Create an E-Commerce application where:
  - Abstract Class stores common product information.
  - Interface defines payment methods.

---

# Concept Map

```
                 Abstraction

                      │

        ┌─────────────┴─────────────┐

        ▼                           ▼

 Abstract Class                Interface

        │                           │

  Code Reuse                 Contract

        │                           │

 Concrete + Abstract        Abstract Methods

 Constructors               Multiple Inheritance

 Instance Variables         Constants

        │                           │

        └─────────────┬─────────────┘

                      ▼

            Better Software Design
```

---

# Summary

| Use Abstract Class When... | Use Interface When... |
|-----------------------------|------------------------|
| Classes are closely related | Classes are unrelated |
| Common implementation exists | Only behavior is common |
| Constructors are needed | Multiple inheritance is needed |
| Instance variables are required | Loose coupling is required |
| Code reuse is important | Flexibility is important |

---

# Final Key Takeaways

- **Abstract Class** provides **partial implementation** and supports **code reuse**.
- **Interface** defines a **contract** that implementing classes must follow.
- Abstract Classes use **`extends`**.
- Interfaces use **`implements`**.
- Java allows **single inheritance** for classes but **multiple inheritance** through interfaces.
- Use **Abstract Classes** when sharing state and implementation.
- Use **Interfaces** when defining common behavior across unrelated classes.

---

# Conclusion

Both Abstract Classes and Interfaces are essential tools for designing flexible and maintainable Java applications. An **Abstract Class** is the best choice when related classes share common data and behavior, while an **Interface** is ideal for defining capabilities that multiple unrelated classes can implement.

Choosing the right one depends on your design requirements. Understanding this distinction is crucial for Java development, enterprise frameworks like Spring, and technical interviews.
