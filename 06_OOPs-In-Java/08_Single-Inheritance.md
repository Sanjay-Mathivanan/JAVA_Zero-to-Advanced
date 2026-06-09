# Single Inheritance in Java

## Introduction

Inheritance is one of the most important concepts in Object-Oriented Programming (OOP).

In the previous chapter, we learned that inheritance creates an:

```text
IS-A Relationship
```

between classes.

The simplest form of inheritance is:

```text
Single Inheritance
```

---

# What is Single Inheritance?

Single Inheritance occurs when:

```text
One Child Class
inherits from
One Parent Class
```

Diagram:

```text
Parent Class
      │
      ▼
 Child Class
```

---

# Real-World Examples

```text
Person
   │
   ▼
Student
```

Student IS-A Person.

---

```text
Vehicle
   │
   ▼
Car
```

Car IS-A Vehicle.

---

```text
Animal
   │
   ▼
Dog
```

Dog IS-A Animal.

---

# Why Use Single Inheritance?

Without inheritance:

```java
class Dog {

    public void eat() {
        System.out.println("Eating");
    }
}

class Cat {

    public void eat() {
        System.out.println("Eating");
    }
}
```

Problem:

```text
Duplicate Code
```

---

Using inheritance:

```java
class Animal {

    public void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}
```

Now the code is reused.

---

# Syntax

```java
class Parent {

}

class Child extends Parent {

}
```

Example:

```java
class Animal {

}

class Dog extends Animal {

}
```

---

# First Single Inheritance Program

## Parent Class

```java
class Animal {

    public void eat() {

        System.out.println(
                "Animal is Eating");

    }
}
```

---

## Child Class

```java
class Dog extends Animal {

}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();
    }
}
```

---

# Output

```text
Animal is Eating
```

---

# Understanding the Flow

```text
Dog Object Created
       │
       ▼

eat() Called
       │
       ▼

Method Not Found in Dog
       │
       ▼

Search Parent Class
       │
       ▼

Method Found
       │
       ▼

Execute Method
```

---

# Memory Representation

```text
Dog Object
----------------

Inherited Methods

eat()

----------------
```

---

# Example with Variables

## Parent Class

```java
class Person {

    String name = "Sanjay";

}
```

---

## Child Class

```java
class Student extends Person {

}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

        System.out.println(
                student.name);
    }
}
```

---

# Output

```text
Sanjay
```

---

# Example with Methods and Variables

## Parent Class

```java
class Person {

    String name = "Sanjay";

    public void display() {

        System.out.println(
                "Name : " + name);
    }
}
```

---

## Child Class

```java
class Student extends Person {

}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

        student.display();
    }
}
```

---

# Output

```text
Name : Sanjay
```

---

# Real-World Example: Vehicle System

## Parent Class

```java
class Vehicle {

    public void start() {

        System.out.println(
                "Vehicle Started");
    }

    public void stop() {

        System.out.println(
                "Vehicle Stopped");
    }
}
```

---

## Child Class

```java
class Car extends Vehicle {

}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.start();
        car.stop();
    }
}
```

---

# Output

```text
Vehicle Started
Vehicle Stopped
```

---

# Constructor Example

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

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
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

# Why Parent Constructor Executes First?

Execution Flow:

```text
Create Dog Object
        │
        ▼

Call Animal Constructor
        │
        ▼

Call Dog Constructor
        │
        ▼

Object Ready
```

---

# Student Management Example

## Parent Class

```java
class Person {

    protected String name;

    public Person(String name) {

        this.name = name;
    }

    public void displayPerson() {

        System.out.println(
                "Name : " + name);
    }
}
```

---

## Child Class

```java
class Student extends Person {

    private int rollNo;

    public Student(
            String name,
            int rollNo) {

        super(name);

        this.rollNo = rollNo;
    }

    public void displayStudent() {

        displayPerson();

        System.out.println(
                "Roll No : "
                + rollNo);
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student(
                        "Sanjay",
                        23);

        student.displayStudent();
    }
}
```

---

# Output

```text
Name : Sanjay
Roll No : 23
```

---

# Advantages of Single Inheritance

## Code Reusability

Methods written once can be reused.

---

## Reduced Duplication

Avoids repeating code.

---

## Better Organization

Common functionality stays in parent class.

---

## Easier Maintenance

Changes in parent class affect all child classes.

---

# Common Mistakes

## Forgetting extends

Wrong:

```java
class Dog {

}
```

No inheritance.

---

Correct:

```java
class Dog extends Animal {

}
```

---

## Private Variables Access

Wrong:

```java
private String name;
```

Direct access from child class is not allowed.

---

Use:

```java
protected
```

or

```java
Getter Methods
```

---

## Wrong Relationship

Wrong:

```java
class Engine extends Car {

}
```

Engine is not a Car.

Use Composition instead.

---

# Single Inheritance Diagram

```text
Animal
   │
   ▼
Dog
```

---

```text
Person
   │
   ▼
Student
```

---

```text
Vehicle
   │
   ▼
Car
```

---

# Single Inheritance vs Multilevel Inheritance

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

Chain of inheritance.

---

# Interview Questions

## What is Single Inheritance?

A type of inheritance where one child class inherits from one parent class.

---

## Which Keyword Is Used?

```java
extends
```

---

## What Relationship Does It Represent?

```text
IS-A Relationship
```

---

## Can a Child Class Access Parent Methods?

Yes.

---

## Which Constructor Executes First?

Parent Constructor.

---

# Practice Challenges

## Challenge 1

Create:

```text
Animal
Dog
```

Use single inheritance.

---

## Challenge 2

Create:

```text
Person
Student
```

Display inherited data.

---

## Challenge 3

Create:

```text
Vehicle
Bike
```

Reuse methods.

---

## Challenge 4

Create:

```text
Employee
Manager
```

Use constructor inheritance.

---

## Challenge 5

Create:

```text
Shape
Circle
```

Reuse parent methods.

---

# Concept Map

```text
Single Inheritance
        │
        ▼
   One Parent
        │
        ▼
    One Child
        │
        ▼
  Code Reuse
        │
        ▼
  Better Design
```

---

# Key Takeaways

- Single Inheritance means one child class inherits from one parent class.
- Java uses the `extends` keyword.
- It represents an IS-A relationship.
- Child classes can use parent methods and variables.
- Parent constructors execute before child constructors.
- Single inheritance promotes code reuse and maintainability.

---

# Conclusion

Single Inheritance is the simplest and most commonly used form of inheritance in Java. It allows a child class to inherit properties and behaviors from a parent class, reducing code duplication and improving program organization. Understanding Single Inheritance is essential before learning Multilevel Inheritance, Hierarchical Inheritance, and Runtime Polymorphism.
