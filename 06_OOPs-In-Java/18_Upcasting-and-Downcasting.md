# Upcasting and Downcasting in Java

## Introduction

Upcasting and Downcasting are important concepts in:

```text
Inheritance
+
Runtime Polymorphism
```

Many Java interview questions revolve around:

```java
Parent reference = Child object;
```

To understand Runtime Polymorphism deeply, you must understand:

```text
Upcasting
Downcasting
```

---

# Prerequisites

Before learning this topic, you should know:

```text
Inheritance

Method Overriding

Runtime Polymorphism

Parent Reference Child Object
```

---

# Real-World Analogy

Imagine:

```text
Animal
   │
   ▼
Dog
```

Every Dog is an Animal.

But every Animal is NOT a Dog.

Example:

```text
Dog IS-A Animal
```

Therefore:

```java
Animal animal =
        new Dog();
```

is valid.

This is called:

```text
Upcasting
```

---

# What is Upcasting?

Upcasting means:

```text
Converting Child Object
into Parent Reference
```

Syntax:

```java
Parent ref =
        new Child();
```

---

# First Upcasting Example

## Parent Class

```java
class Animal {

    public void eat() {

        System.out.println(
                "Animal Eating");
    }
}
```

---

## Child Class

```java
class Dog extends Animal {

    public void bark() {

        System.out.println(
                "Dog Barking");
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

        animal.eat();
    }
}
```

---

# Output

```text
Animal Eating
```

---

# Understanding the Statement

```java
Animal animal =
        new Dog();
```

---

Reference Type:

```text
Animal
```

Object Type:

```text
Dog
```

---

Visualization:

```text
Animal Reference
        │
        ▼

      Dog Object
```

---

# Why is Upcasting Allowed?

Because:

```text
Every Dog
IS-A
Animal
```

Java guarantees:

```text
Dog contains everything
Animal has.
```

---

# Automatic Upcasting

Upcasting happens automatically.

Example:

```java
Dog dog =
        new Dog();

Animal animal =
        dog;
```

No cast required.

---

# What Can Be Accessed?

Consider:

```java
Animal animal =
        new Dog();
```

Available:

```java
animal.eat();
```

Not Available:

```java
animal.bark();
```

Compiler Error.

---

# Why?

Reference Type:

```text
Animal
```

determines accessible members.

---

# Example

```java
class Animal {

    public void eat() {

        System.out.println(
                "Eating");
    }
}

class Dog extends Animal {

    public void bark() {

        System.out.println(
                "Barking");
    }
}
```

---

Main:

```java
public class Main {

    public static void main(String[] args) {

        Animal animal =
                new Dog();

        animal.eat();

        // animal.bark();
    }
}
```

---

# Output

```text
Eating
```

---

# Runtime Polymorphism Example

```java
class Animal {

    public void sound() {

        System.out.println(
                "Animal Sound");
    }
}
```

---

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

Main:

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

# Important Rule

Methods:

```text
Runtime → Object Type
```

Variables:

```text
Compile Time → Reference Type
```

---

# What is Downcasting?

Downcasting means:

```text
Converting Parent Reference
Back Into Child Reference
```

Syntax:

```java
Child ref =
        (Child) parentRef;
```

---

# Why Downcasting?

Suppose:

```java
Animal animal =
        new Dog();
```

We want access to:

```java
bark()
```

which belongs to Dog.

Need:

```java
Dog dog =
        (Dog) animal;
```

---

# First Downcasting Example

```java
class Animal {

    public void eat() {

        System.out.println(
                "Eating");
    }
}
```

---

```java
class Dog extends Animal {

    public void bark() {

        System.out.println(
                "Barking");
    }
}
```

---

Main:

```java
public class Main {

    public static void main(String[] args) {

        Animal animal =
                new Dog();

        Dog dog =
                (Dog) animal;

        dog.bark();
    }
}
```

---

# Output

```text
Barking
```

---

# Internal Working

Step 1

```java
Animal animal =
        new Dog();
```

```text
Animal Ref
     │
     ▼

Dog Object
```

---

Step 2

```java
Dog dog =
        (Dog) animal;
```

```text
Dog Ref
    │
    ▼

Dog Object
```

---

# Memory Diagram

```text
Before Downcasting

Animal Ref
      │
      ▼

Dog Object
```

---

```text
After Downcasting

Animal Ref ──┐
             │
             ▼

         Dog Object

             ▲
             │

Dog Ref ─────┘
```

Both references point to the same object.

---

# Unsafe Downcasting

Example:

```java
Animal animal =
        new Animal();

Dog dog =
        (Dog) animal;
```

---

# Result

```text
Runtime Error

ClassCastException
```

---

# Why?

Actual Object:

```text
Animal
```

Cannot become:

```text
Dog
```

---

# Safe Downcasting Using instanceof

Before downcasting:

```java
if(animal instanceof Dog)
```

check object type.

---

Example:

```java
Animal animal =
        new Dog();

if(animal instanceof Dog) {

    Dog dog =
            (Dog) animal;

    dog.bark();
}
```

---

# Output

```text
Barking
```

---

# Real-World Example

## Employee System

Parent:

```java
class Employee {

    public void work() {

        System.out.println(
                "Working");
    }
}
```

---

Child:

```java
class Developer
        extends Employee {

    public void code() {

        System.out.println(
                "Coding");
    }
}
```

---

Main:

```java
Employee emp =
        new Developer();

Developer dev =
        (Developer) emp;

dev.code();
```

---

# Output

```text
Coding
```

---

# Upcasting vs Downcasting

| Upcasting | Downcasting |
|------------|------------|
| Child → Parent | Parent → Child |
| Automatic | Manual |
| Safe | May Cause Exception |
| No Cast Needed | Cast Required |
| Commonly Used | Used When Needed |

---

# Visual Comparison

## Upcasting

```text
Dog
 │
 ▼
Animal
```

Code:

```java
Animal animal =
        new Dog();
```

---

## Downcasting

```text
Animal
 │
 ▼
Dog
```

Code:

```java
Dog dog =
        (Dog) animal;
```

---

# Why Upcasting is Important?

Almost all Runtime Polymorphism uses:

```java
Parent ref =
        new Child();
```

Examples:

```java
Animal a =
        new Dog();

Vehicle v =
        new Car();

Employee e =
        new Manager();
```

This is Upcasting.

---

# Common Mistakes

## Calling Child Methods

Wrong:

```java
Animal a =
        new Dog();

a.bark();
```

Compiler Error.

---

Correct:

```java
Dog d =
        (Dog) a;

d.bark();
```

---

## Unsafe Downcasting

Wrong:

```java
Animal a =
        new Animal();

Dog d =
        (Dog) a;
```

Runtime Error.

---

Correct:

```java
if(a instanceof Dog)
```

---

# Interview Questions

## What is Upcasting?

Converting a child object into a parent reference.

---

## What is Downcasting?

Converting a parent reference back into a child reference.

---

## Is Upcasting Automatic?

Yes.

---

## Is Downcasting Automatic?

No.

Explicit cast required.

---

## Which One Is Safer?

```text
Upcasting
```

---

## Which Exception Occurs During Invalid Downcasting?

```text
ClassCastException
```

---

## Why Use Downcasting?

To access child-specific methods.

---

# Practice Challenges

## Challenge 1

Create:

```text
Animal
Dog
```

Demonstrate Upcasting.

---

## Challenge 2

Perform Downcasting and call child methods.

---

## Challenge 3

Create:

```text
Vehicle
Car
```

Use Runtime Polymorphism.

---

## Challenge 4

Use instanceof before downcasting.

---

## Challenge 5

Create:

```text
Employee
Developer
```

and demonstrate safe casting.

---

# Concept Map

```text
Inheritance
      │
      ▼
Runtime Polymorphism
      │
      ▼
Parent Reference
      │
      ▼
Child Object
      │
      ▼
Upcasting
      │
      ▼
Access Parent Features
      │
      ▼
Downcasting
      │
      ▼
Access Child Features
```

---

# Key Takeaways

- Upcasting converts a child object into a parent reference.
- Upcasting is automatic and safe.
- Downcasting converts a parent reference back into a child reference.
- Downcasting requires explicit casting.
- Invalid downcasting causes `ClassCastException`.
- Use `instanceof` before downcasting.
- Runtime Polymorphism heavily depends on upcasting.
- Downcasting allows access to child-specific behavior.

---

# Conclusion

Upcasting and Downcasting are essential concepts in Java inheritance and runtime polymorphism. Upcasting enables flexible and reusable code by allowing parent references to manage child objects, while downcasting allows access to child-specific functionality when needed. Understanding both concepts is crucial for mastering Java OOP and performing well in technical interviews.
