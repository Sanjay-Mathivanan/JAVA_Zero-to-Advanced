# Multilevel Inheritance in Java

## Introduction

Inheritance allows one class to inherit properties and methods from another class.

In the previous chapter, we learned:

```text
Single Inheritance
```

where:

```text
One Parent
     ↓
One Child
```

Now we will learn:

```text
Multilevel Inheritance
```

which creates a chain of inheritance.

---

# What is Multilevel Inheritance?

Multilevel Inheritance occurs when:

```text
Class C inherits from Class B

Class B inherits from Class A
```

Diagram:

```text
Class A
   │
   ▼
Class B
   │
   ▼
Class C
```

This forms an inheritance chain.

---

# Real-World Example

```text
LivingThing
      │
      ▼
Animal
      │
      ▼
Dog
```

Dog inherits:

- Dog Features
- Animal Features
- LivingThing Features

---

# Why Use Multilevel Inheritance?

Suppose we have:

```text
LivingThing
```

All living things can:

```text
Breathe
```

Animals can:

```text
Eat
```

Dogs can:

```text
Bark
```

Instead of writing the same code repeatedly, we can reuse it through inheritance.

---

# First Multilevel Inheritance Program

## Parent Class

```java
class LivingThing {

    public void breathe() {

        System.out.println(
                "Breathing...");
    }
}
```

---

## Child Class

```java
class Animal extends LivingThing {

    public void eat() {

        System.out.println(
                "Eating...");
    }
}
```

---

## Grandchild Class

```java
class Dog extends Animal {

    public void bark() {

        System.out.println(
                "Barking...");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.breathe();
        dog.eat();
        dog.bark();
    }
}
```

---

# Output

```text
Breathing...
Eating...
Barking...
```

---

# Understanding the Flow

```text
Dog
 │
 ▼
Animal
 │
 ▼
LivingThing
```

Dog can access:

```text
Dog Methods
Animal Methods
LivingThing Methods
```

---

# Memory Representation

```text
Dog Object

--------------------------------

Inherited From LivingThing

breathe()

--------------------------------

Inherited From Animal

eat()

--------------------------------

Dog Methods

bark()

--------------------------------
```

---

# Student Example

## Person Class

```java
class Person {

    public void displayName() {

        System.out.println(
                "Name : Sanjay");
    }
}
```

---

## Student Class

```java
class Student extends Person {

    public void displayRollNo() {

        System.out.println(
                "Roll No : 23");
    }
}
```

---

## CollegeStudent Class

```java
class CollegeStudent extends Student {

    public void displayDepartment() {

        System.out.println(
                "Department : AIDS");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        CollegeStudent student =
                new CollegeStudent();

        student.displayName();
        student.displayRollNo();
        student.displayDepartment();
    }
}
```

---

# Output

```text
Name : Sanjay
Roll No : 23
Department : AIDS
```

---

# Constructor Example

Understanding constructor execution order is important.

---

## Parent Class

```java
class Animal {

    public Animal() {

        System.out.println(
                "Animal Constructor");
    }
}
```

---

## Child Class

```java
class Dog extends Animal {

    public Dog() {

        System.out.println(
                "Dog Constructor");
    }
}
```

---

## Grandchild Class

```java
class Puppy extends Dog {

    public Puppy() {

        System.out.println(
                "Puppy Constructor");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Puppy puppy =
                new Puppy();
    }
}
```

---

# Output

```text
Animal Constructor
Dog Constructor
Puppy Constructor
```

---

# Constructor Execution Flow

```text
Create Puppy Object
        │
        ▼

Animal Constructor
        │
        ▼

Dog Constructor
        │
        ▼

Puppy Constructor
```

Java always executes constructors from top to bottom.

---

# Vehicle Example

## Vehicle

```java
class Vehicle {

    public void start() {

        System.out.println(
                "Vehicle Started");
    }
}
```

---

## Car

```java
class Car extends Vehicle {

    public void drive() {

        System.out.println(
                "Driving Car");
    }
}
```

---

## SportsCar

```java
class SportsCar extends Car {

    public void turboMode() {

        System.out.println(
                "Turbo Mode Activated");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        SportsCar car =
                new SportsCar();

        car.start();
        car.drive();
        car.turboMode();
    }
}
```

---

# Output

```text
Vehicle Started
Driving Car
Turbo Mode Activated
```

---

# Accessing Parent Members

Example:

```java
class A {

    int x = 10;
}
```

```java
class B extends A {

}
```

```java
class C extends B {

}
```

Main:

```java
public class Main {

    public static void main(String[] args) {

        C obj = new C();

        System.out.println(obj.x);
    }
}
```

Output:

```text
10
```

The variable travels through the inheritance chain.

---

# Advantages of Multilevel Inheritance

## Code Reusability

Write code once and reuse it across multiple levels.

---

## Better Organization

Common functionality stays in higher-level classes.

---

## Reduced Duplication

Avoid repeated methods and variables.

---

## Easier Maintenance

Changes in parent classes automatically affect descendants.

---

# Common Mistakes

## Creating Unnecessary Levels

Bad:

```text
A
↓
B
↓
C
↓
D
↓
E
↓
F
```

Too many levels make code difficult to maintain.

---

## Using Inheritance for HAS-A Relationships

Wrong:

```java
class Engine extends Car
```

Engine is not a Car.

Use Composition.

---

Correct:

```text
Car HAS-A Engine
```

---

# Single vs Multilevel Inheritance

## Single Inheritance

```text
Animal
   │
   ▼
Dog
```

One Parent → One Child

---

## Multilevel Inheritance

```text
Animal
   │
   ▼
Dog
   │
   ▼
Puppy
```

Inheritance Chain

---

# Interview Questions

## What is Multilevel Inheritance?

A type of inheritance where a class inherits from another inherited class.

---

## Example?

```text
Animal
   │
   ▼
Dog
   │
   ▼
Puppy
```

---

## Which Constructor Executes First?

Top-level parent constructor.

---

## Can the Last Class Access Methods from the First Class?

Yes.

---

## Does Java Support Multilevel Inheritance?

Yes.

---

# Practice Challenges

## Challenge 1

Create:

```text
LivingThing
Animal
Dog
```

and access methods from all classes.

---

## Challenge 2

Create:

```text
Person
Student
CollegeStudent
```

and display inherited information.

---

## Challenge 3

Create:

```text
Vehicle
Car
SportsCar
```

and reuse methods.

---

## Challenge 4

Print constructor execution order in a multilevel hierarchy.

---

## Challenge 5

Create:

```text
Employee
Manager
SeniorManager
```

and demonstrate inherited methods.

---

# Concept Map

```text
Multilevel Inheritance
          │
          ▼
      Class A
          │
          ▼
      Class B
          │
          ▼
      Class C
          │
          ▼
      Code Reuse
          │
          ▼
      Less Duplication
```

---

# Key Takeaways

- Multilevel Inheritance creates an inheritance chain.
- A child class can become a parent for another class.
- The lowest class inherits members from all ancestor classes.
- Constructors execute from top-level parent to child.
- Java fully supports multilevel inheritance.
- It improves code reuse and maintainability.

---

# Conclusion

Multilevel Inheritance extends the idea of inheritance by creating a chain of parent-child relationships. This allows deeper code reuse and better organization of common functionality. Understanding multilevel inheritance is essential before learning Hierarchical Inheritance, Method Overriding, Runtime Polymorphism, and Abstract Classes.
