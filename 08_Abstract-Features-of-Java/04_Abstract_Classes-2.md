# Abstract Classes in Java (Part 2)

> **Chapter 08 - Abstract Features of Java**

---

# Constructors in Abstract Classes

One of the most common interview questions is:

> **Can an abstract class have a constructor?**

**Answer:** ✅ Yes.

Even though we cannot create an object of an abstract class directly, it **can have constructors**.

---

# Why Do We Need Constructors in an Abstract Class?

Suppose every employee has:

- Employee ID
- Employee Name

Instead of initializing these variables in every child class, we can initialize them once in the abstract class.

```
            Employee

          Constructor

               ▲

               │

        Developer
        Tester
        Manager
```

---

# Example

```java
abstract class Employee {

    Employee() {

        System.out.println("Employee Constructor");

    }

}

class Developer extends Employee {

    Developer() {

        System.out.println("Developer Constructor");

    }

}

public class Main {

    public static void main(String[] args) {

        Developer dev = new Developer();

    }

}
```

---

# Output

```
Employee Constructor
Developer Constructor
```

---

# Explanation

Although the `Employee` class is abstract, its constructor executes **first** when a child object is created.

Execution order:

```
Create Developer Object

        │

        ▼

Employee Constructor

        │

        ▼

Developer Constructor

        │

        ▼

Object Created
```

---

# Program Flow

```
main()

   │

   ▼

new Developer()

   │

   ▼

Employee()

   │

   ▼

Developer()

   │

   ▼

Object Ready
```

---

# Memory Representation

```
Stack

+----------------+
| dev            |
+-------|--------+
        |
        ▼

Heap

+----------------------+
| Developer Object     |
|----------------------|
| Employee Members     |
| Developer Members    |
+----------------------+
```

---

# Variables in Abstract Classes

Abstract classes can contain variables.

Example

```java
abstract class Animal {

    String type = "Mammal";

}
```

The child class automatically inherits these variables.

---

# Example

```java
abstract class Animal {

    String type = "Mammal";

}

class Dog extends Animal {

    void display() {

        System.out.println(type);

    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.display();

    }

}
```

---

# Output

```
Mammal
```

---

# Concrete Methods

A concrete method is a method with a body.

```java
abstract class Animal {

    void eat() {

        System.out.println("Animal is Eating");

    }

}
```

The child class can use this method directly.

---

# Example

```java
abstract class Animal {

    void eat() {

        System.out.println("Animal is Eating");

    }

    abstract void sound();

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog Barks");

    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.eat();

        dog.sound();

    }

}
```

---

# Output

```
Animal is Eating
Dog Barks
```

---

# Static Methods in Abstract Classes

Abstract classes can contain static methods.

```java
abstract class Animal {

    static void message() {

        System.out.println("Static Method");

    }

}

public class Main {

    public static void main(String[] args) {

        Animal.message();

    }

}
```

---

# Output

```
Static Method
```

---

# Final Methods in Abstract Classes

A final method cannot be overridden.

```java
abstract class Animal {

    final void sleep() {

        System.out.println("Sleeping");

    }

}
```

Child classes inherit this method but cannot change its implementation.

---

# Example

```java
abstract class Animal {

    final void sleep() {

        System.out.println("Sleeping");

    }

}

class Dog extends Animal {

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sleep();

    }

}
```

---

# Output

```
Sleeping
```

---

# Method Overriding

Every abstract method must be implemented by the child class.

```java
abstract class Shape {

    abstract void draw();

}

class Circle extends Shape {

    @Override
    void draw() {

        System.out.println("Drawing Circle");

    }

}
```

---

# Runtime Polymorphism

Abstract classes support runtime polymorphism.

Example

```java
abstract class Animal {

    abstract void sound();

}

class Dog extends Animal {

    @Override
    void sound() {

        System.out.println("Dog Barks");

    }

}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Dog();

        animal.sound();

    }

}
```

---

# Output

```
Dog Barks
```

---

# Internal Working

```
Animal animal = new Dog();

        │

Reference Type = Animal

        │

Object Type = Dog

        │

Method Call

        ▼

Dog.sound()
```

The JVM decides at **runtime** which method to execute.

This is called **Dynamic Method Dispatch**.

---

# Multiple Child Classes

```java
abstract class Animal {

    abstract void sound();

}

class Dog extends Animal {

    void sound() {

        System.out.println("Dog Barks");

    }

}

class Cat extends Animal {

    void sound() {

        System.out.println("Cat Meows");

    }

}

public class Main {

    public static void main(String[] args) {

        Animal a1 = new Dog();

        Animal a2 = new Cat();

        a1.sound();

        a2.sound();

    }

}
```

---

# Output

```
Dog Barks
Cat Meows
```

---

# Real-World Example

```
           Vehicle

               ▲

     -------------------

     │        │        │

    Car      Bus     Bike
```

Common methods:

- start()
- stop()

Different implementations:

- drive()

---

# Abstract Class vs Normal Class

| Feature | Abstract Class | Normal Class |
|---------|---------------|--------------|
| Object Creation | ❌ No | ✅ Yes |
| Abstract Methods | ✅ Yes | ❌ No |
| Concrete Methods | ✅ Yes | ✅ Yes |
| Constructors | ✅ Yes | ✅ Yes |
| Variables | ✅ Yes | ✅ Yes |

---

# Abstract Class vs Interface

| Abstract Class | Interface |
|----------------|-----------|
| Uses `extends` | Uses `implements` |
| Constructors | Yes | No |
| Instance Variables | Yes | No |
| Partial Abstraction | Yes | Traditionally Complete |
| Multiple Inheritance | No | Yes |

---

# Common Mistakes

## Mistake 1

Trying to instantiate an abstract class.

```java
Animal a = new Animal();
```

❌ Compilation Error

---

## Mistake 2

Not implementing abstract methods.

```java
class Dog extends Animal {

}
```

❌ Compilation Error

---

## Mistake 3

Using `final` with an abstract method.

```java
final abstract void show();
```

❌ Invalid.

A method cannot be both `final` and `abstract`.

---

# Best Practices

- Use abstract classes when multiple related classes share common code.
- Put common implementation inside concrete methods.
- Declare only required methods as abstract.
- Prefer interfaces when unrelated classes need a common contract.

---

# Interview Questions

### Beginner

1. What is an abstract class?
2. Can we create an object of an abstract class?
3. Can an abstract class have constructors?
4. Can it have variables?

### Intermediate

5. Can an abstract class have static methods?
6. Can it have final methods?
7. What is the difference between an abstract method and a concrete method?
8. Why do we use abstract classes?

### Advanced

9. Explain runtime polymorphism using abstract classes.
10. Abstract Class vs Interface?
11. Can an abstract class contain only concrete methods?
12. Can a child class remain abstract?

---

# Practice Programs

### Easy

- Create an abstract class `Vehicle` with a `start()` method.
- Create `Dog` and `Cat` classes from `Animal`.

### Medium

- Create an abstract `Employee` class with `calculateSalary()`.
- Build a `Shape` hierarchy (`Circle`, `Rectangle`).

### Difficult

- Design a banking system using abstract classes.
- Create a payment system with `CreditCard`, `UPI`, and `NetBanking` classes extending an abstract `Payment` class.

---

# Concept Map

```
                 Abstract Class

                        │

      ┌─────────────────┼─────────────────┐

      ▼                 ▼                 ▼

 Abstract Methods   Concrete Methods   Variables

      │                 │                 │

      └─────────────────┼─────────────────┘

                        ▼

                  Child Classes

                        ▼

             Method Overriding

                        ▼

             Runtime Polymorphism
```

---

# Key Takeaways

- Abstract classes **cannot be instantiated**.
- They can contain **constructors**, **variables**, **static methods**, **final methods**, and **concrete methods**.
- Child classes must implement all abstract methods unless they are also abstract.
- Abstract classes promote **code reuse** and **partial abstraction**.
- They are ideal when multiple related classes share common behavior but require different implementations.

---

# Summary

An Abstract Class acts as a **common base class** for related objects. It provides shared implementation while allowing child classes to define specific behavior. It is one of the core OOP concepts in Java and is widely used in framework design, API development, and enterprise applications.

---

# Conclusion

Abstract Classes bridge the gap between complete implementation and complete abstraction. They help developers write reusable, maintainable, and extensible code by placing common functionality in a parent class while leaving specific behavior to subclasses. Understanding Abstract Classes is essential before moving on to advanced topics like **Interfaces, Polymorphism, Design Patterns, and Framework Development**.
