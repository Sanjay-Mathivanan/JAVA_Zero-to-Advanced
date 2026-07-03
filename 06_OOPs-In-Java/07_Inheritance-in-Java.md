# Inheritance in Java

## Introduction

Inheritance is one of the four pillars of Object-Oriented Programming (OOP).

The four pillars are:

```text
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction
```

Inheritance allows one class to acquire the properties and behaviors of another class.

---

# Definition

Inheritance is a mechanism where one class inherits the fields and methods of another class.

Relationship:

```text
IS-A Relationship
```

Examples:

```text
Dog IS-A Animal

Car IS-A Vehicle

Student IS-A Person
```

---

# Why Do We Need Inheritance?

Without inheritance:

```java
class Dog {

    String name;

    public void eat() {

        System.out.println("Eating");

    }
}

class Cat {

    String name;

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

# Solution

Create a common parent class.

```java
class Animal {

    String name;

    public void eat() {

        System.out.println("Eating");

    }
}
```

Then:

```java
class Dog extends Animal {

}

class Cat extends Animal {

}
```

Now both classes reuse code.

---

# Parent Class and Child Class

Inheritance involves two classes:

## Parent Class

Also called:

```text
Superclass
Base Class
```

Example:

```java
class Animal {

}
```

---

## Child Class

Also called:

```text
Subclass
Derived Class
```

Example:

```java
class Dog extends Animal {

}
```

---

# Syntax

```java
class ChildClass extends ParentClass {

}
```

Example:

```java
class Dog extends Animal {

}
```

---

# First Inheritance Program

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

# Internal Working

```text
Dog Object Created
        ↓
Dog Searches eat()
        ↓
Not Found in Dog
        ↓
Checks Animal
        ↓
Method Found
        ↓
Execute Method
```

---

# Memory Representation

```text
Dog Object

----------------

Inherited From Animal

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

# Real-World Example

## Parent Class

```java
class Vehicle {

    public void start() {

        System.out.println(
                "Vehicle Started");

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

    }
}
```

---

# Output

```text
Vehicle Started
```

---

# Understanding extends

The keyword:

```java
extends
```

means:

```text
Inherit Properties and Methods
from Parent Class
```

Example:

```java
class Car extends Vehicle {

}
```

Meaning:

```text
Car IS-A Vehicle
```

---

# Types of Inheritance in Java

## 1. Single Inheritance

```text
Animal
   │
   ▼
Dog
```

---

## Example

```java
class Animal {

}

class Dog extends Animal {

}
```

---

# 2. Multilevel Inheritance

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

## Example

```java
class Animal {

}

class Dog extends Animal {

}

class Puppy extends Dog {

}
```

---

# Program

```java
class Animal {

    public void eat() {

        System.out.println("Eating");

    }
}

class Dog extends Animal {

}

class Puppy extends Dog {

}
```

Main:

```java
public class Main {

    public static void main(String[] args) {

        Puppy puppy =
                new Puppy();

        puppy.eat();

    }
}
```

Output:

```text
Eating
```

---

# 3. Hierarchical Inheritance

```text
           Animal
         /        \
       Dog       Cat
```

---

## Example

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

---

# Output

```text
Dog → eat()

Cat → eat()
```

---

# Java Does NOT Support Multiple Inheritance Using Classes

Not Allowed:

```java
class A {

}

class B {

}

class C extends A, B {

}
```

Compiler Error.

---

# Why?

Java avoids:

```text
Diamond Problem
```

This is handled later using Interfaces.

---

# Constructor and Inheritance

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
Dog Object Created
        ↓
Animal Constructor
        ↓
Dog Constructor
```

Parent initialization happens first.

---

# Inheritance Hierarchy Diagram

```text
Object
  │
  ▼
Animal
  │
  ▼
Dog
```

Every class in Java indirectly inherits from:

```java
Object
```

---

# Advantages of Inheritance

## Code Reusability

Write once, use many times.

---

## Reduced Duplication

Avoid repeated code.

---

## Easier Maintenance

Changes in parent class automatically affect children.

---

## Supports Polymorphism

Inheritance is the foundation of method overriding.

---

# Real-World Examples

```text
Person
   │
   ├── Student
   ├── Teacher
   └── Employee
```

---

```text
Vehicle
   │
   ├── Car
   ├── Bike
   └── Truck
```

---

```text
Animal
   │
   ├── Dog
   ├── Cat
   └── Horse
```

---

# Common Mistakes

## Wrong Relationship

Wrong:

```java
class Engine extends Car {

}
```

Engine is not a Car.

Use Composition.

---

Correct:

```java
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

# Inheritance vs Composition

| Inheritance | Composition |
|------------|------------|
| IS-A | HAS-A |
| Dog IS-A Animal | Car HAS-A Engine |
| Uses extends | Uses Objects |
| Tight Relationship | Flexible Relationship |

---

# Interview Questions

## What is Inheritance?

A mechanism where one class acquires properties and methods of another class.

---

## Which Keyword Is Used?

```java
extends
```

---

## What Relationship Does Inheritance Represent?

```text
IS-A Relationship
```

---

## Does Java Support Multiple Inheritance with Classes?

No.

---

## Which Constructor Executes First?

Parent Constructor.

---

## What Are the Advantages of Inheritance?

- Code Reuse
- Reduced Duplication
- Easier Maintenance
- Supports Polymorphism

---

# Practice Challenges

## Challenge 1

Create:

```text
Person
Student
```

Use inheritance.

---

## Challenge 2

Create:

```text
Vehicle
Car
Bike
```

Reuse methods from Vehicle.

---

## Challenge 3

Create:

```text
Animal
Dog
Puppy
```

Implement multilevel inheritance.

---

## Challenge 4

Create:

```text
Employee
Manager
Developer
Tester
```

Implement hierarchical inheritance.

---

## Challenge 5

Print constructor execution order in inheritance.

---

# Concept Map

```text
Inheritance
      │
      ▼
IS-A Relationship
      │
      ├── Single
      ├── Multilevel
      └── Hierarchical
                │
                ▼
          Code Reuse
                │
                ▼
           Polymorphism
```

---

# Key Takeaways

- Inheritance represents an IS-A relationship.
- Child classes inherit fields and methods from parent classes.
- Java uses the extends keyword for inheritance.
- Parent constructors execute before child constructors.
- Java supports Single, Multilevel, and Hierarchical inheritance.
- Multiple inheritance through classes is not supported.
- Inheritance promotes code reuse and maintainability.

---

# Conclusion

Inheritance is one of the most powerful features of Object-Oriented Programming. It allows classes to reuse existing functionality, reduce duplication, and create logical relationships between objects. Understanding inheritance is essential before moving to advanced concepts such as Method Overriding, Runtime Polymorphism, Abstract Classes, and Interfaces.
