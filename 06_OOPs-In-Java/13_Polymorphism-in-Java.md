# Polymorphism in Java

## Introduction

Polymorphism is one of the four pillars of Object-Oriented Programming (OOP).

The word Polymorphism comes from:

```text
Poly  = Many

Morph = Forms
```

Meaning:

```text
One Thing
Can Take Many Forms
```

In Java, polymorphism allows the same method or object reference to behave differently depending on the situation.

---

# Real-World Example

Think about a person.

```text
At Home      → Son

At College   → Student

At Office    → Employee
```

Same person.

Different behavior.

This is Polymorphism.

---

# Definition

Polymorphism means:

```text
One Interface
Multiple Implementations
```

or

```text
One Method
Multiple Behaviors
```

---

# Why Do We Need Polymorphism?

Without polymorphism:

```java
Dog dog = new Dog();
Cat cat = new Cat();
Cow cow = new Cow();
```

Need separate code for each object.

With polymorphism:

```java
Animal animal;
```

One reference can handle many objects.

---

# Types of Polymorphism

Java supports two types:

```text
1. Compile-Time Polymorphism
       ↓
   Method Overloading

2. Runtime Polymorphism
       ↓
   Method Overriding
```

---

# Polymorphism Overview

```text
Polymorphism
      │
      ├── Compile Time
      │        │
      │        ▼
      │   Method Overloading
      │
      └── Runtime
               │
               ▼
       Method Overriding
```

---

# 1. Compile-Time Polymorphism

Achieved using:

```java
Method Overloading
```

---

## Example

```java
class Calculator {

    public int add(
            int a,
            int b) {

        return a + b;
    }

    public int add(
            int a,
            int b,
            int c) {

        return a + b + c;
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Calculator calc =
                new Calculator();

        System.out.println(
                calc.add(10,20));

        System.out.println(
                calc.add(10,20,30));
    }
}
```

---

## Output

```text
30
60
```

---

# Why is it Called Compile-Time?

Java decides:

```text
Which Method To Execute
```

during compilation.

---

# Method Selection

```java
calc.add(10,20);
```

Java finds:

```java
add(int,int)
```

before execution.

---

# 2. Runtime Polymorphism

Achieved using:

```java
Method Overriding
```

and

```java
Parent Reference
Child Object
```

---

# Example

## Parent Class

```java
class Animal {

    public void sound() {

        System.out.println(
                "Animal Sound");
    }
}
```

---

## Child Class

```java
class Dog extends Animal {

    @Override
    public void sound() {

        System.out.println(
                "Dog Barks");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Animal animal =
                new Dog();

        animal.sound();
    }
}
```

---

## Output

```text
Dog Barks
```

---

# Why?

Reference:

```java
Animal animal
```

Object:

```java
new Dog()
```

At runtime Java checks:

```text
Actual Object Type
```

and executes:

```java
Dog.sound()
```

---

# Understanding Parent Reference Child Object

This is the heart of runtime polymorphism.

```java
Animal animal =
        new Dog();
```

---

## Visualization

```text
Animal Reference
        │
        ▼

    Dog Object
```

---

Reference Type:

```java
Animal
```

Actual Object:

```java
Dog
```

---

# More Examples

## Dog Class

```java
class Dog extends Animal {

    @Override
    public void sound() {

        System.out.println(
                "Dog Barks");
    }
}
```

---

## Cat Class

```java
class Cat extends Animal {

    @Override
    public void sound() {

        System.out.println(
                "Cat Meows");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Animal animal;

        animal = new Dog();
        animal.sound();

        animal = new Cat();
        animal.sound();
    }
}
```

---

## Output

```text
Dog Barks
Cat Meows
```

---

# Internal Working

When:

```java
animal.sound();
```

Java checks:

```text
Reference Type?
    Animal

Actual Object?
    Dog
```

Result:

```text
Execute Dog.sound()
```

---

# Real-World Example

## Employee System

Parent:

```java
class Employee {

    public void work() {

        System.out.println(
                "Employee Working");
    }
}
```

---

Child:

```java
class Developer extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Writing Code");
    }
}
```

---

Child:

```java
class Tester extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Testing Software");
    }
}
```

---

Main:

```java
Employee emp;

emp = new Developer();
emp.work();

emp = new Tester();
emp.work();
```

---

Output:

```text
Writing Code
Testing Software
```

---

# Memory Representation

```text
Animal animal
      │
      ▼

  Dog Object
```

Method Call:

```text
animal.sound()
```

Java checks:

```text
Actual Object
```

not

```text
Reference Type
```

for overridden methods.

---

# Dynamic Method Dispatch

Runtime polymorphism is also called:

```text
Dynamic Method Dispatch
```

because method selection happens during execution.

---

# Advantages of Polymorphism

## Flexibility

One reference can manage multiple objects.

---

## Reusability

Write generic code.

---

## Maintainability

Add new classes with minimal changes.

---

## Scalability

Large applications become easier to manage.

---

# Example: Payment System

```text
Payment
   │
   ├── UPI
   ├── CreditCard
   └── NetBanking
```

All override:

```java
pay()
```

One reference:

```java
Payment payment;
```

can process all payment types.

---

# Compile-Time vs Runtime Polymorphism

| Compile-Time | Runtime |
|-------------|----------|
| Method Overloading | Method Overriding |
| Decided During Compilation | Decided During Execution |
| Faster | Slightly Slower |
| Same Class Usually | Parent-Child Classes |
| Static Binding | Dynamic Binding |

---

# Common Mistakes

## Confusing Overloading and Overriding

Overloading:

```java
add(int,int)

add(int,int,int)
```

Different parameters.

---

Overriding:

```java
sound()
```

Same method signature.

---

## Forgetting Parent Reference

Wrong:

```java
Dog dog =
        new Dog();
```

Not demonstrating polymorphism.

---

Correct:

```java
Animal animal =
        new Dog();
```

---

# Interview Questions

## What is Polymorphism?

One object or method behaving in multiple forms.

---

## How Many Types Exist?

```text
Compile-Time
Runtime
```

---

## Which Concept Achieves Compile-Time Polymorphism?

```text
Method Overloading
```

---

## Which Concept Achieves Runtime Polymorphism?

```text
Method Overriding
```

---

## What is Dynamic Method Dispatch?

Runtime selection of overridden methods.

---

## Why Use Parent Reference Child Object?

To achieve runtime polymorphism.

---

# Practice Challenges

## Challenge 1

Create:

```text
Animal
Dog
Cat
Cow
```

Override:

```java
sound()
```

---

## Challenge 2

Create:

```text
Employee
Developer
Tester
Manager
```

Override:

```java
work()
```

---

## Challenge 3

Create:

```text
Vehicle
Car
Bike
Truck
```

Override:

```java
start()
```

---

## Challenge 4

Create:

```text
Payment
UPI
CreditCard
NetBanking
```

Override:

```java
pay()
```

---

## Challenge 5

Create a Shape hierarchy.

Override:

```java
area()
```

---

# Concept Map

```text
Polymorphism
      │
      ├── Compile Time
      │       │
      │       ▼
      │  Method Overloading
      │
      └── Runtime
              │
              ▼
      Method Overriding
              │
              ▼
 Parent Reference
 Child Object
```

---

# Key Takeaways

- Polymorphism means one thing taking many forms.
- Java supports compile-time and runtime polymorphism.
- Method Overloading provides compile-time polymorphism.
- Method Overriding provides runtime polymorphism.
- Runtime polymorphism uses parent reference child object.
- Dynamic Method Dispatch occurs at runtime.
- Polymorphism improves flexibility and scalability.

---

# Conclusion

Polymorphism is one of the most powerful features of Java. It allows developers to write flexible, reusable, and maintainable code by enabling a single interface to support multiple implementations. Understanding polymorphism is essential before learning Abstract Classes, Interfaces, and advanced design patterns used in enterprise Java applications.
