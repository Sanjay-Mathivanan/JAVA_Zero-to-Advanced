# Abstract Class in Java

## Introduction

So far we have learned:

```text
Class
Inheritance
Encapsulation
Polymorphism
Upcasting & Downcasting
```

Now we move to one of the most important OOP concepts:

```text
Abstract Classes
```

Abstract Classes help us create:

```text
Common Design Rules
```

for all child classes.

Instead of forcing every class to create methods independently, we define a blueprint and let child classes provide their own implementation.

---

# Real-World Example

Consider a company.

Every employee must:

```text
Work
```

But the way they work differs.

```text
Developer → Writes Code

Tester → Tests Software

Manager → Manages Team
```

We know:

```text
Every Employee Works
```

But we don't know exactly HOW.

This is where an Abstract Class is useful.

---

# What is an Abstract Class?

An Abstract Class is a class that cannot be instantiated directly.

It is designed to:

```text
Be Inherited
```

by other classes.

---

# Definition

An Abstract Class is a partially implemented class that may contain:

```text
Abstract Methods
+
Normal Methods
+
Variables
+
Constructors
```

---

# Syntax

```java
abstract class ClassName {

}
```

Example:

```java
abstract class Employee {

}
```

---

# What is an Abstract Method?

An Abstract Method is a method that:

```text
Has No Body
```

Syntax:

```java
abstract void work();
```

---

Example:

```java
abstract class Employee {

    abstract void work();
}
```

No implementation exists.

Child classes must implement it.

---

# Why Do We Need Abstract Classes?

Suppose we create:

```text
Dog

Cat

Cow
```

All animals make sounds.

But:

```text
Dog → Bark

Cat → Meow

Cow → Moo
```

We know:

```text
Every Animal Has Sound
```

But we don't know the exact sound.

Therefore:

```java
abstract void sound();
```

---

# First Abstract Class Program

## Parent Class

```java
abstract class Animal {

    abstract void sound();
}
```

---

## Child Class

```java
class Dog extends Animal {

    @Override
    void sound() {

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

        Dog dog = new Dog();

        dog.sound();
    }
}
```

---

# Output

```text
Dog Barks
```

---

# Why Can't We Create an Abstract Object?

Wrong:

```java
Animal animal =
        new Animal();
```

Output:

```text
Compile Time Error
```

Reason:

```text
Abstract Classes
Cannot Be Instantiated
```

---

# Correct Approach

```java
Animal animal =
        new Dog();
```

This is:

```text
Upcasting
+
Runtime Polymorphism
```

---

# Abstract Class with Multiple Child Classes

## Parent

```java
abstract class Animal {

    abstract void sound();
}
```

---

## Dog

```java
class Dog extends Animal {

    void sound() {

        System.out.println(
                "Dog Barks");
    }
}
```

---

## Cat

```java
class Cat extends Animal {

    void sound() {

        System.out.println(
                "Cat Meows");
    }
}
```

---

## Cow

```java
class Cow extends Animal {

    void sound() {

        System.out.println(
                "Cow Moos");
    }
}
```

---

## Main

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

# Abstract Class + Normal Methods

Abstract classes can contain:

```text
Implemented Methods
```

also.

---

Example:

```java
abstract class Animal {

    abstract void sound();

    public void sleep() {

        System.out.println(
                "Sleeping...");
    }
}
```

---

Child:

```java
class Dog extends Animal {

    void sound() {

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

        Dog dog =
                new Dog();

        dog.sound();

        dog.sleep();
    }
}
```

---

# Output

```text
Dog Barks

Sleeping...
```

---

# Abstract Class with Constructor

Many beginners think:

```text
Abstract Class
Cannot Have Constructor
```

Wrong.

Abstract classes can have constructors.

---

Example

```java
abstract class Animal {

    public Animal() {

        System.out.println(
                "Animal Constructor");
    }
}
```

---

Child

```java
class Dog extends Animal {

    public Dog() {

        System.out.println(
                "Dog Constructor");
    }
}
```

---

Main

```java
public class Main {

    public static void main(String[] args) {

        Dog dog =
                new Dog();
    }
}
```

---

# Output

```text
Animal Constructor

Dog Constructor
```

---

# Internal Working

```text
Create Dog Object
       │
       ▼

Animal Constructor
       │
       ▼

Dog Constructor
```

---

# Employee Example

## Parent

```java
abstract class Employee {

    protected String name;

    public Employee(
            String name) {

        this.name = name;
    }

    abstract void work();
}
```

---

## Developer

```java
class Developer
        extends Employee {

    public Developer(
            String name) {

        super(name);
    }

    @Override
    void work() {

        System.out.println(
                name +
                " is Writing Code");
    }
}
```

---

## Tester

```java
class Tester
        extends Employee {

    public Tester(
            String name) {

        super(name);
    }

    @Override
    void work() {

        System.out.println(
                name +
                " is Testing");
    }
}
```

---

## Main

```java
public class Main {

    public static void main(String[] args) {

        Employee emp;

        emp = new Developer(
                "Sanjay");

        emp.work();

        emp = new Tester(
                "Rahul");

        emp.work();
    }
}
```

---

# Output

```text
Sanjay is Writing Code

Rahul is Testing
```

---

# Memory Representation

```text
Employee Reference
        │
        ▼

Developer Object

----------------

work()

----------------
```

Method executed:

```java
Developer.work()
```

using Runtime Polymorphism.

---

# Rules of Abstract Classes

## Rule 1

Abstract class can contain:

```java
abstract methods
```

---

## Rule 2

Abstract class can contain:

```java
normal methods
```

---

## Rule 3

Abstract class can have:

```java
constructors
```

---

## Rule 4

Cannot create object directly.

Wrong:

```java
new Animal();
```

---

## Rule 5

Child class must implement all abstract methods.

Otherwise:

```java
Child class must also be abstract.
```

---

# Abstract Class vs Normal Class

| Normal Class | Abstract Class |
|--------------|----------------|
| Can Create Object | Cannot Create Object |
| May Have Methods | May Have Abstract + Normal Methods |
| No Restriction | Designed For Inheritance |
| Fully Implemented | Partially Implemented |

---

# Abstract Class vs Interface

| Abstract Class | Interface |
|---------------|------------|
| Can Have Variables | Constants Only (Traditionally) |
| Can Have Constructors | No Constructors |
| Partial Abstraction | Complete Abstraction (Traditionally) |
| Uses extends | Uses implements |

---

# Real-World Applications

## Banking

```text
Account
   │
   ├── SavingsAccount
   ├── CurrentAccount
   └── LoanAccount
```

---

## Employee Management

```text
Employee
   │
   ├── Developer
   ├── Tester
   └── Manager
```

---

## Payment Systems

```text
Payment
   │
   ├── UPI
   ├── CreditCard
   └── NetBanking
```

---

# Common Mistakes

## Creating Object

Wrong:

```java
Animal animal =
        new Animal();
```

---

## Not Implementing Method

Wrong:

```java
class Dog extends Animal {

}
```

Compiler Error.

---

Correct:

```java
@Override
void sound() {

}
```

---

# Interview Questions

## What is an Abstract Class?

A class that cannot be instantiated and is intended to be inherited.

---

## What is an Abstract Method?

A method without implementation.

---

## Can Abstract Classes Have Constructors?

Yes.

---

## Can Abstract Classes Have Normal Methods?

Yes.

---

## Can We Create Objects?

No.

---

## Why Use Abstract Classes?

To define common rules and behavior for child classes.

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

Use abstract methods.

---

## Challenge 2

Create:

```text
Employee
Developer
Tester
Manager
```

Implement work().

---

## Challenge 3

Create:

```text
Vehicle
Car
Bike
Truck
```

Implement start().

---

## Challenge 4

Create:

```text
Shape
Circle
Rectangle
Triangle
```

Implement area().

---

## Challenge 5

Create:

```text
Payment
UPI
CreditCard
```

Implement pay().

---

# Concept Map

```text
Abstract Class
        │
        ▼
Cannot Create Object
        │
        ▼
Abstract Methods
        │
        ▼
Child Classes
        │
        ▼
Method Implementation
        │
        ▼
Runtime Polymorphism
```

---

# Key Takeaways

- Abstract Classes provide partial implementation.
- Abstract Methods have no body.
- Abstract Classes cannot be instantiated.
- Child classes must implement abstract methods.
- Abstract Classes support constructors and normal methods.
- Runtime Polymorphism commonly uses abstract classes.
- Abstract Classes help create scalable application designs.

---

# Conclusion

Abstract Classes provide a powerful mechanism for defining common behavior while forcing child classes to implement specific functionality. They sit between normal classes and interfaces, offering both implementation and abstraction. Abstract Classes are widely used in enterprise applications, frameworks, and system design to create reusable and maintainable software architectures.
