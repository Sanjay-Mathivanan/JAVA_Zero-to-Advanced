08_Abstract-Features-of-Java/
└── 01_Interfaces.md

# Interfaces in Java

> **Chapter:** 08 - Abstract Features of Java

---

# Introduction

Interfaces are one of the most important concepts in Java. They provide a way to achieve **100% abstraction**, enable **multiple inheritance**, and define a **contract** that classes must follow.

Almost every enterprise Java application uses interfaces extensively. Popular frameworks like **Spring**, **Hibernate**, **JDBC**, and **Servlet API** are built around interfaces.

Learning interfaces thoroughly is essential for writing scalable, maintainable, and loosely coupled applications.

---

# Problem Statement

Suppose we are building software for different payment systems.

- Credit Card
- UPI
- Net Banking
- PayPal

Every payment method performs a payment, but each one implements the payment process differently.

Without interfaces, each class becomes tightly coupled, making future expansion difficult.

We need a common contract that all payment methods follow.

This is exactly what an interface provides.

---

# Why Do We Need Interfaces?

Imagine a TV.

You press the Power button.

You don't know whether the TV uses Samsung hardware, LG hardware, or Sony hardware.

You only know:

```
Power Button
      │
      ▼
 TV Turns ON
```

The button defines **what** should happen.

The TV internally decides **how** it happens.

An interface works in the same way.

It specifies:

```
WHAT to do
```

Not

```
HOW to do it
```

---

# Real World Analogy

Imagine different vehicles.

```
             Vehicle Rules

                  │
     ┌────────────┼─────────────┐
     ▼            ▼             ▼

    Car         Bike          Bus

start()       start()       start()

```

Every vehicle must start.

But every vehicle starts differently.

The rule is common.

Implementation differs.

---

# Definition

An Interface is a blueprint of a class that contains abstract methods, constants, and (since Java 8+) default and static methods.

It defines a contract that implementing classes must follow.

---

# Key Characteristics

- Supports abstraction
- Supports multiple inheritance
- Cannot be instantiated
- Variables are public static final
- Methods are public abstract by default
- Class implements interface
- Interface extends interface

---

# Syntax

```java
interface Animal {

    void sound();

}
```

Implementation

```java
class Dog implements Animal {

    public void sound() {
        System.out.println("Dog Barks");
    }

}
```

---

# Basic Structure

```
Interface

+----------------------+
| Animal               |
+----------------------+
| sound()              |
+----------------------+

          ▲
          │ implements

+----------------------+
| Dog                  |
+----------------------+
| sound()              |
+----------------------+
```

---

# First Example

```java
interface Animal {

    void sound();

}

class Dog implements Animal {

    public void sound() {
        System.out.println("Dog Barks");
    }

}

public class Main {

    public static void main(String[] args) {

        Dog obj = new Dog();

        obj.sound();

    }

}
```

---

# Output

```
Dog Barks
```

---

# Code Explanation

## Step 1

Create interface

```java
interface Animal
```

This creates an interface named Animal.

---

## Step 2

Declare abstract method

```java
void sound();
```

Notice there is no method body.

Only declaration.

---

## Step 3

Implement interface

```java
class Dog implements Animal
```

Dog promises Java that it will implement every abstract method.

---

## Step 4

Provide implementation

```java
public void sound()
```

Actual working is written here.

---

## Step 5

Create object

```java
Dog obj = new Dog();
```

Memory is allocated.

---

## Step 6

Call method

```java
obj.sound();
```

Output

```
Dog Barks
```

---

# Internal Working

Compilation

```
Interface
      │
      ▼

Compiler checks

Does Dog implement sound() ?

        │
     Yes ▼

Compilation Successful
```

If not,

```
Compilation Error
```

---

# Memory Representation

```
Stack Memory

+---------------------+
| obj                 |
| ----------          |
|      |              |
+------|--------------+
       |
       ▼

Heap Memory

+---------------------+
| Dog Object          |
| sound()             |
+---------------------+
```

---

# Program Flow

```
main()

   │

   ▼

Create Dog Object

   │

   ▼

Call sound()

   │

   ▼

Dog.sound()

   │

   ▼

Print

Dog Barks
```

---

# Interface Variables

Every variable inside an interface is

```
public
static
final
```

automatically.

Example

```java
interface College {

    int FEES = 50000;

}
```

Compiler converts it into

```java
public static final int FEES = 50000;
```

---

# Example

```java
interface College {

    int FEES = 50000;

}

public class Main {

    public static void main(String[] args) {

        System.out.println(College.FEES);

    }

}
```

Output

```
50000
```

---

# Can We Modify It?

```java
College.FEES = 60000;
```

Compiler Error

Because

```
final variable
```

cannot change.

---

# Interface Methods

By default

```
public abstract
```

Example

```java
interface Shape {

    void draw();

}
```

Compiler converts

```java
public abstract void draw();
```

---

# Example

```java
interface Shape {

    void draw();

}

class Circle implements Shape {

    public void draw() {

        System.out.println("Drawing Circle");

    }

}

public class Main {

    public static void main(String[] args) {

        Shape obj = new Circle();

        obj.draw();

    }

}
```

Output

```
Drawing Circle
```

---

# Why Public?

Because every implementing class should access the method.

Reducing visibility causes an error.

Wrong

```java
void draw()
```

Correct

```java
public void draw()
```

---

# Multiple Interface Implementation

Java does not allow

```
Multiple Class Inheritance
```

But it allows

```
Multiple Interface Inheritance
```

Example

```
Interface A

Interface B

        │

        ▼

      Class C
```

---

# Example

```java
interface Camera {

    void click();

}

interface Music {

    void play();

}

class Mobile implements Camera, Music {

    public void click() {

        System.out.println("Photo Captured");

    }

    public void play() {

        System.out.println("Playing Music");

    }

}

public class Main {

    public static void main(String[] args) {

        Mobile obj = new Mobile();

        obj.click();

        obj.play();

    }

}
```

---

# Output

```
Photo Captured

Playing Music
```

---

# Internal Working

```
              Camera

               ▲

               │

Mobile ---------------- Music

```

One class

implements

multiple interfaces.

---

# Why Multiple Interfaces?

Suppose

```
Printable

Scannable

Faxable
```

Modern printer supports all three.

```
                Printer

            implements

 Printable
 Scannable
 Faxable
```

This is possible only through interfaces.

---

# Interface Inheritance

Interfaces inherit using

```
extends
```

Example

```java
interface A{

}

interface B extends A{

}
```

Here

```
A

▲

|

B
```

B inherits A.

---

# Example

```java
interface Animal {

    void eat();

}

interface Dog extends Animal {

    void bark();

}

class Labrador implements Dog {

    public void eat() {

        System.out.println("Eating");

    }

    public void bark() {

        System.out.println("Barking");

    }

}

public class Main {

    public static void main(String[] args) {

        Labrador obj = new Labrador();

        obj.eat();

        obj.bark();

    }

}
```

---

# Output

```
Eating

Barking
```

---

# Concept Map

```
Interface

│

├── Abstract Methods

├── Constants

├── Default Methods

├── Static Methods

├── Private Methods

├── Functional Interface

├── Marker Interface

└── Multiple Inheritance
```

---

# Key Takeaways (Part 1)

- Interface defines a contract.
- Interfaces achieve abstraction.
- Variables are `public static final`.
- Methods are `public abstract` by default.
- Classes use `implements`.
- Interfaces use `extends`.
- One class can implement multiple interfaces.
- Interfaces promote loose coupling and better design.
