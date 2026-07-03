# Hierarchical Inheritance in Java

## Introduction

Inheritance allows classes to reuse code from other classes.

In the previous chapters, we learned:

```text
Single Inheritance
    ↓
One Parent → One Child

Multilevel Inheritance
    ↓
One Parent → Child → Grandchild
```

Now we will learn:

```text
Hierarchical Inheritance
```

where multiple child classes inherit from a single parent class.

---

# What is Hierarchical Inheritance?

Hierarchical Inheritance occurs when:

```text
One Parent Class
       │
 ┌─────┼─────┐
 │     │     │
 ▼     ▼     ▼
A      B     C
```

Multiple child classes inherit from the same parent class.

---

# Real-World Example

```text
Animal
  │
  ├── Dog
  ├── Cat
  └── Horse
```

All child classes inherit common behavior from Animal.

---

# Why Use Hierarchical Inheritance?

Suppose we have:

```text
Dog
Cat
Horse
```

All animals can:

```text
Eat
Sleep
Breathe
```

Instead of writing these methods repeatedly, we place them inside a parent class.

---

# First Hierarchical Inheritance Program

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

## Child Class 1

```java
class Dog extends Animal {

    public void bark() {

        System.out.println(
                "Dog is Barking");
    }
}
```

---

## Child Class 2

```java
class Cat extends Animal {

    public void meow() {

        System.out.println(
                "Cat is Meowing");
    }
}
```

---

## Child Class 3

```java
class Horse extends Animal {

    public void run() {

        System.out.println(
                "Horse is Running");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Horse horse = new Horse();

        dog.eat();
        dog.bark();

        cat.eat();
        cat.meow();

        horse.eat();
        horse.run();
    }
}
```

---

# Output

```text
Animal is Eating
Dog is Barking

Animal is Eating
Cat is Meowing

Animal is Eating
Horse is Running
```

---

# Understanding the Structure

```text
Animal
  │
  ├── Dog
  ├── Cat
  └── Horse
```

Each child class gets:

```text
eat()
```

from Animal.

Additionally:

```text
Dog    → bark()

Cat    → meow()

Horse  → run()
```

---

# Memory Representation

```text
Dog Object
----------------
eat()
bark()
----------------

Cat Object
----------------
eat()
meow()
----------------

Horse Object
----------------
eat()
run()
----------------
```

---

# Student Example

## Parent Class

```java
class Person {

    public void displayName() {

        System.out.println(
                "I am a Person");
    }
}
```

---

## Student Class

```java
class Student extends Person {

    public void study() {

        System.out.println(
                "Student is Studying");
    }
}
```

---

## Teacher Class

```java
class Teacher extends Person {

    public void teach() {

        System.out.println(
                "Teacher is Teaching");
    }
}
```

---

## Employee Class

```java
class Employee extends Person {

    public void work() {

        System.out.println(
                "Employee is Working");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

        Teacher teacher =
                new Teacher();

        Employee employee =
                new Employee();

        student.displayName();
        student.study();

        teacher.displayName();
        teacher.teach();

        employee.displayName();
        employee.work();
    }
}
```

---

# Output

```text
I am a Person
Student is Studying

I am a Person
Teacher is Teaching

I am a Person
Employee is Working
```

---

# Vehicle Example

```java
class Vehicle {

    public void start() {

        System.out.println(
                "Vehicle Started");
    }
}
```

---

```java
class Car extends Vehicle {

    public void drive() {

        System.out.println(
                "Driving Car");
    }
}
```

---

```java
class Bike extends Vehicle {

    public void ride() {

        System.out.println(
                "Riding Bike");
    }
}
```

---

```java
class Truck extends Vehicle {

    public void load() {

        System.out.println(
                "Loading Goods");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Car car = new Car();
        Bike bike = new Bike();
        Truck truck = new Truck();

        car.start();
        bike.start();
        truck.start();
    }
}
```

---

# Output

```text
Vehicle Started
Vehicle Started
Vehicle Started
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

## Child Classes

```java
class Dog extends Animal {

    public Dog() {

        System.out.println(
                "Dog Constructor");
    }
}
```

```java
class Cat extends Animal {

    public Cat() {

        System.out.println(
                "Cat Constructor");
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        Cat cat = new Cat();
    }
}
```

---

# Output

```text
Animal Constructor
Dog Constructor

Animal Constructor
Cat Constructor
```

---

# Internal Working

When:

```java
Dog dog = new Dog();
```

Java executes:

```text
Animal Constructor
       ↓
Dog Constructor
```

---

When:

```java
Cat cat = new Cat();
```

Java executes:

```text
Animal Constructor
       ↓
Cat Constructor
```

---

# Advantages of Hierarchical Inheritance

## Code Reusability

Common methods are written once.

---

## Reduced Duplication

Avoids repeating code in multiple classes.

---

## Better Organization

Shared functionality stays in one parent class.

---

## Easier Maintenance

Modify parent class once and all child classes benefit.

---

# Real-World Applications

## Banking System

```text
Account
   │
   ├── SavingsAccount
   ├── CurrentAccount
   └── FixedDepositAccount
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

## E-Commerce

```text
Product
   │
   ├── Electronics
   ├── Clothing
   └── Grocery
```

---

# Common Mistakes

## Wrong Relationship

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

# Single vs Multilevel vs Hierarchical

## Single Inheritance

```text
Animal
   │
   ▼
Dog
```

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

---

## Hierarchical Inheritance

```text
        Animal
      /    |    \
    Dog   Cat   Horse
```

---

# Interview Questions

## What is Hierarchical Inheritance?

One parent class inherited by multiple child classes.

---

## Does Java Support Hierarchical Inheritance?

Yes.

---

## What Relationship Does It Represent?

```text
IS-A Relationship
```

---

## Can All Child Classes Access Parent Methods?

Yes.

---

## Can Child Classes Have Their Own Methods?

Yes.

---

# Practice Challenges

## Challenge 1

Create:

```text
Animal
 ├── Dog
 ├── Cat
 └── Cow
```

Add separate methods.

---

## Challenge 2

Create:

```text
Person
 ├── Student
 ├── Teacher
 └── Employee
```

Display different responsibilities.

---

## Challenge 3

Create:

```text
Vehicle
 ├── Car
 ├── Bike
 └── Truck
```

Reuse start() method.

---

## Challenge 4

Create:

```text
Shape
 ├── Circle
 ├── Rectangle
 └── Triangle
```

Add area methods.

---

## Challenge 5

Create:

```text
Account
 ├── SavingsAccount
 ├── CurrentAccount
 └── LoanAccount
```

Display account details.

---

# Concept Map

```text
Hierarchical Inheritance
            │
            ▼
      One Parent
            │
    ┌───────┼───────┐
    ▼       ▼       ▼
 Child1  Child2  Child3
            │
            ▼
       Code Reuse
            │
            ▼
      Better Design
```

---

# Key Takeaways

- Hierarchical Inheritance means one parent class has multiple child classes.
- All child classes inherit common methods and variables.
- Java supports hierarchical inheritance.
- It promotes code reuse and maintainability.
- Child classes can also have their own unique methods.
- Constructor execution always starts from the parent class.

---

# Conclusion

Hierarchical Inheritance is a powerful inheritance model where multiple child classes share a common parent class. It helps eliminate duplicate code, improves maintainability, and accurately models many real-world systems such as employees, vehicles, animals, and banking applications. Understanding hierarchical inheritance is essential before moving to Method Overriding and Runtime Polymorphism.
