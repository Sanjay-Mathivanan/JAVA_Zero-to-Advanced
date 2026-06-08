# Composition in Java

## Introduction

Composition is one of the fundamental concepts of Object-Oriented Programming (OOP).

It represents a:

```text
HAS-A Relationship
```

between classes.

Unlike inheritance, where one class extends another, composition allows one class to contain objects of other classes as its members.

---

# Real-World Example

Consider a Computer.

A Computer has:

```text
Monitor
Keyboard
Motherboard
Processor
```

A Computer is not a Monitor.

A Computer is not a Keyboard.

Instead:

```text
Computer HAS-A Monitor
Computer HAS-A Keyboard
Computer HAS-A Motherboard
```

This is Composition.

---

# Composition vs Inheritance

## Inheritance

```text
Car IS-A Vehicle
Dog IS-A Animal
```

Relationship:

```text
IS-A
```

Example:

```java
class Vehicle {

}

class Car extends Vehicle {

}
```

---

## Composition

```text
Computer HAS-A Monitor
House HAS-A Room
Car HAS-A Engine
```

Relationship:

```text
HAS-A
```

Example:

```java
class Engine {

}

class Car {

    Engine engine;

}
```

---

# Why Use Composition?

Composition helps:

- Reuse code
- Reduce complexity
- Improve flexibility
- Follow real-world design
- Avoid deep inheritance chains

---

# Simple Composition Example

## Engine Class

```java
class Engine {

    public void start() {

        System.out.println(
                "Engine Started");

    }
}
```

---

## Car Class

```java
class Car {

    private Engine engine;

    public Car() {

        engine = new Engine();

    }

    public void startCar() {

        engine.start();

        System.out.println(
                "Car Started");

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        car.startCar();

    }
}
```

---

# Output

```text
Engine Started
Car Started
```

---

# Understanding the Relationship

```text
Car
 │
 └── Engine
```

Car contains an Engine object.

Therefore:

```text
Car HAS-A Engine
```

---

# Internal Working

When:

```java
Car car = new Car();
```

executes,

Java creates:

```text
Car Object
      │
      ▼
Engine Object
```

---

# Memory Representation

```text
Car Object
----------------

engine
   │
   ▼

Engine Object

----------------
```

---

# Composition with Multiple Classes

Real applications use multiple objects.

Example:

```text
Computer
 ├── Monitor
 ├── Keyboard
 └── Motherboard
```

---

# Monitor Class

```java
class Monitor {

    public void display() {

        System.out.println(
                "Display ON");

    }
}
```

---

# Keyboard Class

```java
class Keyboard {

    public void type() {

        System.out.println(
                "Typing...");

    }
}
```

---

# Computer Class

```java
class Computer {

    private Monitor monitor;
    private Keyboard keyboard;

    public Computer() {

        monitor = new Monitor();
        keyboard = new Keyboard();

    }

    public void startComputer() {

        monitor.display();
        keyboard.type();

        System.out.println(
                "Computer Ready");

    }
}
```

---

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        Computer pc =
                new Computer();

        pc.startComputer();

    }
}
```

---

# Output

```text
Display ON
Typing...
Computer Ready
```

---

# Composition Using Constructor Injection

Instead of creating objects inside a class, we can pass them through constructors.

---

## Engine Class

```java
class Engine {

    public void start() {

        System.out.println(
                "Engine Started");

    }
}
```

---

## Car Class

```java
class Car {

    private Engine engine;

    public Car(Engine engine) {

        this.engine = engine;

    }

    public void startCar() {

        engine.start();

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Engine engine =
                new Engine();

        Car car =
                new Car(engine);

        car.startCar();

    }
}
```

---

# Output

```text
Engine Started
```

---

# Real-World Banking Example

## Address Class

```java
class Address {

    private String city;

    public Address(String city) {

        this.city = city;

    }

    public String getCity() {

        return city;

    }
}
```

---

## Customer Class

```java
class Customer {

    private String name;
    private Address address;

    public Customer(
            String name,
            Address address) {

        this.name = name;
        this.address = address;

    }

    public void display() {

        System.out.println(
                name +
                " lives in " +
                address.getCity());

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Address address =
                new Address("Chennai");

        Customer customer =
                new Customer(
                        "Sanjay",
                        address);

        customer.display();

    }
}
```

---

# Output

```text
Sanjay lives in Chennai
```

---

# Composition Diagram

```text
Customer
   │
   ▼
Address
```

Relationship:

```text
Customer HAS-A Address
```

---

# Advantages of Composition

## Code Reusability

The same class can be reused.

Example:

```text
Address
```

can be used by:

```text
Customer
Employee
Student
```

---

## Flexible Design

Objects can be replaced easily.

---

## Better Maintainability

Changes in one class usually do not affect unrelated classes.

---

## Follows Real-World Modeling

Most real-world relationships are:

```text
HAS-A
```

relationships.

---

# Composition vs Aggregation

Composition and Aggregation are similar.

---

## Composition

Strong relationship.

Example:

```text
House HAS-A Room
```

If house is destroyed:

```text
Rooms are also gone.
```

---

## Aggregation

Weak relationship.

Example:

```text
Department HAS-A Teacher
```

If department is removed:

```text
Teacher still exists.
```

---

# Common Mistakes

## Using Inheritance Instead of Composition

Wrong:

```java
class Car extends Engine {

}
```

A Car is not an Engine.

---

Correct:

```java
class Car {

    Engine engine;

}
```

---

## Creating Too Many Dependencies

Avoid unnecessary object nesting.

---

# Interview Questions

## What is Composition?

A design technique where one class contains another class object.

---

## What Relationship Does Composition Represent?

```text
HAS-A
```

relationship.

---

## Difference Between Composition and Inheritance?

| Composition | Inheritance |
|------------|------------|
| HAS-A | IS-A |
| More Flexible | Less Flexible |
| Uses Objects | Uses extends |

---

## Why Prefer Composition Over Inheritance?

Because it provides:

- Better flexibility
- Better maintainability
- Better code reuse

---

# Practice Challenges

## Challenge 1

Create:

```text
Car
Engine
```

using composition.

---

## Challenge 2

Create:

```text
Library
Book
```

using composition.

---

## Challenge 3

Create:

```text
University
Department
```

using composition.

---

## Challenge 4

Create:

```text
Mobile
Battery
```

using composition.

---

## Challenge 5

Create:

```text
House
Room
```

using composition.

---

# Concept Map

```text
Composition
      │
      ▼
HAS-A Relationship
      │
      ├── Car → Engine
      ├── Computer → Monitor
      ├── Customer → Address
      ├── House → Room
      └── Mobile → Battery
```

---

# Key Takeaways

- Composition represents a HAS-A relationship.
- One class contains another class object.
- Composition promotes code reuse.
- Composition is often preferred over inheritance.
- Real-world systems frequently use composition.
- Composition creates flexible and maintainable designs.

---

# Conclusion

Composition is one of the most important design principles in Java. It allows classes to work together through HAS-A relationships rather than relying solely on inheritance. Understanding composition helps build flexible, reusable, and real-world object-oriented applications and is a key skill expected in Java interviews and software development projects.
