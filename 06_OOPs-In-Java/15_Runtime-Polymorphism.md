# Runtime Polymorphism in Java

## Introduction

In the previous chapter, we learned:

```text
Compile-Time Polymorphism
      ↓
Method Overloading
```

where the compiler decides which method to execute.

Now we will learn:

```text
Runtime Polymorphism
```

where the decision is made while the program is running.

Runtime Polymorphism is one of the most powerful concepts in Object-Oriented Programming.

---

# What is Runtime Polymorphism?

Runtime Polymorphism occurs when:

```text
Method Execution Decision
is made during Runtime
```

instead of compilation.

It is achieved using:

```text
Method Overriding
+
Inheritance
+
Parent Reference Child Object
```

---

# Another Names

Runtime Polymorphism is also called:

```text
Dynamic Polymorphism

or

Late Binding

or

Dynamic Method Dispatch
```

---

# Real-World Example

Imagine a Remote Control.

```text
Remote
   │
   ├── TV
   ├── AC
   └── Music System
```

Same button:

```text
powerOn()
```

Different behavior.

---

# Understanding Method Overriding

Method Overriding occurs when:

A child class provides its own implementation of a method already present in the parent class.

---

# Rules for Method Overriding

The method must have:

```text
Same Method Name

Same Parameters

Same Return Type
```

---

# First Runtime Polymorphism Program

## Parent Class

```java
class Animal {

    public void sound() {

        System.out.println(
                "Animal Makes Sound");
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

# Output

```text
Dog Barks
```

---

# Why Dog Method Executes?

Reference:

```java
Animal animal
```

Object:

```java
new Dog()
```

Java checks:

```text
Actual Object Type
```

during execution.

Since the object is Dog:

```java
Dog.sound()
```

runs.

---

# Internal Working

```text
Animal animal =
        new Dog();

animal.sound();

        │
        ▼

Reference Type
Animal

        │
        ▼

Actual Object
Dog

        │
        ▼

Execute Dog.sound()
```

---

# Parent Reference Child Object

This is the foundation of Runtime Polymorphism.

```java
Animal animal =
        new Dog();
```

---

## Diagram

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

# Multiple Child Classes Example

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

## Cow Class

```java
class Cow extends Animal {

    @Override
    public void sound() {

        System.out.println(
                "Cow Moos");
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

        animal = new Cow();
        animal.sound();
    }
}
```

---

# Output

```text
Dog Barks

Cat Meows

Cow Moos
```

---

# Real-World Example

## Employee System

### Parent Class

```java
class Employee {

    public void work() {

        System.out.println(
                "Employee Working");
    }
}
```

---

### Developer Class

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

### Tester Class

```java
class Tester extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Testing Application");
    }
}
```

---

### Main Class

```java
public class Main {

    public static void main(String[] args) {

        Employee emp;

        emp = new Developer();
        emp.work();

        emp = new Tester();
        emp.work();
    }
}
```

---

# Output

```text
Writing Code

Testing Application
```

---

# Memory Representation

```text
Employee emp
      │
      ▼

Developer Object

-----------------

work()

-----------------
```

Method Call:

```java
emp.work();
```

Java checks:

```text
Actual Object Type
```

and executes:

```java
Developer.work()
```

---

# Dynamic Method Dispatch

Runtime Polymorphism is also called:

```text
Dynamic Method Dispatch
```

because method selection happens dynamically during execution.

---

# Constructor and Runtime Polymorphism

Constructors cannot be overridden.

Wrong:

```java
class A {

    public A() {

    }
}

class B extends A {

    @Override
    public B() {

    }
}
```

Compiler Error.

---

# Why?

Constructors are not inherited.

Therefore:

```text
No Overriding
```

---

# Variables and Runtime Polymorphism

Methods are polymorphic.

Variables are not.

Example:

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";
}
```

---

```java
Animal animal =
        new Dog();

System.out.println(
        animal.name);
```

Output:

```text
Animal
```

Because variables use:

```text
Reference Type
```

not object type.

---

# Method Example

```java
animal.sound();
```

Output:

```text
Dog Barks
```

Methods use:

```text
Actual Object Type
```

---

# Runtime vs Compile-Time Polymorphism

| Runtime | Compile-Time |
|----------|----------|
| Method Overriding | Method Overloading |
| Decided During Execution | Decided During Compilation |
| Dynamic Binding | Static Binding |
| Requires Inheritance | Doesn't Require Inheritance |
| More Flexible | Faster |

---

# Advantages of Runtime Polymorphism

## Flexibility

One reference can handle many objects.

---

## Reusability

Common interfaces for different implementations.

---

## Scalability

New child classes can be added easily.

---

## Loose Coupling

Programs become easier to maintain.

---

# Banking Example

```text
Account
   │
   ├── SavingsAccount
   ├── CurrentAccount
   └── LoanAccount
```

Each class overrides:

```java
calculateInterest()
```

One reference:

```java
Account account;
```

can handle all account types.

---

# Common Mistakes

## Forgetting Inheritance

Wrong:

```java
class Dog {

}
```

No inheritance.

---

## Different Parameters

Wrong:

```java
sound(int x)
```

Not overriding.

It becomes overloading.

---

## Missing Parent Reference

Wrong:

```java
Dog dog =
        new Dog();
```

No runtime polymorphism demonstrated.

---

Correct:

```java
Animal animal =
        new Dog();
```

---

# Interview Questions

## What is Runtime Polymorphism?

Method execution decision made during runtime.

---

## How is it achieved?

```text
Method Overriding
```

---

## What is Dynamic Method Dispatch?

Runtime selection of overridden methods.

---

## What is the most important syntax?

```java
Parent ref =
        new Child();
```

---

## Can Constructors Be Overridden?

No.

---

## Are Variables Polymorphic?

No.

Only methods participate in runtime polymorphism.

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
Shape
Circle
Rectangle
Triangle
```

Override:

```java
area()
```

---

## Challenge 5

Create:

```text
Account
SavingsAccount
CurrentAccount
```

Override:

```java
calculateInterest()
```

---

# Concept Map

```text
Runtime Polymorphism
          │
          ▼
    Method Overriding
          │
          ▼
      Inheritance
          │
          ▼
 Parent Reference
 Child Object
          │
          ▼
 Dynamic Method Dispatch
          │
          ▼
  Execute Child Method
```

---

# Key Takeaways

- Runtime Polymorphism is achieved through Method Overriding.
- The method is selected during execution.
- Parent Reference Child Object is required.
- Java uses Dynamic Method Dispatch.
- Methods are polymorphic, variables are not.
- Constructors cannot be overridden.
- Runtime Polymorphism improves flexibility and scalability.

---

# Conclusion

Runtime Polymorphism is one of the most powerful features of Java. It allows a single parent reference to interact with multiple child objects while executing the correct overridden method at runtime. This enables flexible, scalable, and maintainable software design and forms the foundation of many enterprise-level Java applications.
