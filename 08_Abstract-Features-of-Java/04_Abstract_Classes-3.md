# Abstract Classes in Java (Part 3)

> **Chapter 08 - Abstract Features of Java**

---

# Internal JVM Working

Understanding how the JVM handles abstract classes is an important interview topic.

Consider the following example:

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
```

When the Java compiler compiles this program, it creates two class files.

```
Animal.class

Dog.class
```

Although `Animal` is abstract, its `.class` file is still generated.

The compiler marks the class as **abstract** in its metadata.

During object creation, the JVM checks whether the class is abstract.

```
new Dog()

     │

     ▼

Load Dog.class

     │

     ▼

Load Animal.class

     │

     ▼

Initialize Parent

     │

     ▼

Initialize Child

     │

     ▼

Object Created
```

---

# What Happens if We Try to Create an Abstract Object?

```java
Animal animal = new Animal();
```

Compilation Error

```
Animal is abstract;
cannot be instantiated
```

Reason

The compiler itself prevents object creation before the JVM executes the program.

---

# Memory Representation

Example

```java
Animal animal = new Dog();
```

Memory Diagram

```
Stack Memory

+-------------------------+
| animal                  |
+------------|------------+
             |
             ▼

Heap Memory

+-------------------------+
| Dog Object              |
|-------------------------|
| Animal Variables        |
| Dog Variables           |
+-------------------------+
```

Notice

```
Reference Type

Animal

Object Type

Dog
```

---

# Dynamic Method Dispatch

Consider the following example.

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

class Cat extends Animal {

    @Override
    void sound() {

        System.out.println("Cat Meows");

    }

}

public class Main {

    public static void main(String[] args) {

        Animal a;

        a = new Dog();
        a.sound();

        a = new Cat();
        a.sound();

    }

}
```

Output

```
Dog Barks
Cat Meows
```

Execution

```
Animal Reference

        │

        ▼

Dog Object

        │

Call sound()

        ▼

Dog.sound()

-----------------------

Animal Reference

        │

        ▼

Cat Object

        │

Call sound()

        ▼

Cat.sound()
```

The JVM decides which method to execute at runtime.

This is called **Runtime Polymorphism**.

---

# Can an Abstract Class Have Only Concrete Methods?

Yes.

Example

```java
abstract class Vehicle {

    void start() {

        System.out.println("Vehicle Started");

    }

}
```

Although no abstract method exists, the class is still abstract because it is declared using the `abstract` keyword.

---

# Can an Abstract Class Have Only Abstract Methods?

Yes.

Example

```java
abstract class Shape {

    abstract void draw();

    abstract void erase();

}
```

This is also perfectly valid.

---

# Can an Abstract Class Extend Another Abstract Class?

Yes.

Example

```java
abstract class Animal {

    abstract void sound();

}

abstract class Pet extends Animal {

    abstract void play();

}
```

Hierarchy

```
Animal

   ▲

   │

 Pet

   ▲

   │

 Dog
```

---

# Can an Abstract Class Extend a Normal Class?

Yes.

Example

```java
class Person {

    void display() {

        System.out.println("Person");

    }

}

abstract class Employee extends Person {

    abstract void work();

}
```

---

# Can a Normal Class Extend an Abstract Class?

Yes.

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
```

---

# Can an Abstract Class Implement an Interface?

Yes.

Example

```java
interface Animal {

    void sound();

}

abstract class Dog implements Animal {

}
```

The abstract class is not required to implement the interface methods immediately.

Its child classes can implement them later.

---

# Real-World Example

## Banking System

```
                BankAccount

                     ▲

        ┌────────────┼────────────┐

        ▼            ▼            ▼

 SavingsAccount CurrentAccount LoanAccount
```

Common features

- Account Number
- Balance
- Deposit
- Withdraw

Different feature

```
calculateInterest()
```

Each account calculates interest differently.

---

# Complete Program

```java
abstract class BankAccount {

    double balance = 10000;

    void showBalance() {

        System.out.println("Balance: " + balance);

    }

    abstract void calculateInterest();

}

class SavingsAccount extends BankAccount {

    @Override
    void calculateInterest() {

        System.out.println("Interest: 5%");

    }

}

public class Main {

    public static void main(String[] args) {

        SavingsAccount account = new SavingsAccount();

        account.showBalance();

        account.calculateInterest();

    }

}
```

Output

```
Balance: 10000.0
Interest: 5%
```

---

# Comparison Table

## Abstract Class vs Concrete Class

| Feature | Abstract Class | Concrete Class |
|---------|----------------|----------------|
| Object Creation | ❌ No | ✅ Yes |
| Abstract Methods | ✅ Allowed | ❌ Not Allowed |
| Concrete Methods | ✅ Yes | ✅ Yes |
| Constructors | ✅ Yes | ✅ Yes |
| Variables | ✅ Yes | ✅ Yes |
| Inheritance | ✅ Yes | ✅ Yes |

---

## Abstract Class vs Interface

| Abstract Class | Interface |
|----------------|-----------|
| Uses `extends` | Uses `implements` |
| Can have constructors | No constructors |
| Instance variables allowed | Only constants |
| Supports partial abstraction | Traditionally complete abstraction |
| Single inheritance | Multiple inheritance |

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

Declaring an abstract method as `private`.

```java
private abstract void show();
```

❌ Invalid because child classes cannot override private methods.

---

## Mistake 4

Using both `final` and `abstract`.

```java
final abstract void show();
```

❌ Invalid.

Reason:

- `abstract` means "must override."
- `final` means "cannot override."

These are opposite concepts.

---

# Best Practices

- Use abstract classes when classes have a strong "is-a" relationship.
- Place common logic in concrete methods.
- Declare only essential methods as abstract.
- Avoid creating unnecessary abstract classes.
- Prefer interfaces when unrelated classes need a common contract.

---

# Interview Questions

## Beginner

1. What is an abstract class?
2. Why can't we create its object?
3. Can it contain constructors?
4. Can it contain variables?
5. Can it contain static methods?

---

## Intermediate

6. Difference between abstract class and interface?
7. Can an abstract class have only concrete methods?
8. Can an abstract class have no abstract methods?
9. Can one abstract class extend another?
10. Can an abstract class implement an interface?

---

## Advanced

11. Explain Dynamic Method Dispatch.
12. How does the JVM handle abstract classes?
13. What class files are generated?
14. Why can't abstract methods be final?
15. When should you use an abstract class instead of an interface?

---

# Practice Programs

## Easy

- Create an abstract class `Shape` with `draw()`.
- Create `Circle` and `Rectangle`.

---

## Medium

- Create an abstract `Employee` class with `calculateSalary()`.
- Create `Developer` and `Tester`.

---

## Hard

- Design a Hospital Management System using abstract classes.
- Design an E-commerce Payment System with different payment methods.

---

# Concept Map

```
                 Abstract Class

                        │

        ┌───────────────┼───────────────┐

        ▼               ▼               ▼

 Abstract Methods  Concrete Methods  Constructors

        │               │               │

        └───────────────┼───────────────┘

                        ▼

                  Child Classes

                        ▼

              Method Overriding

                        ▼

            Runtime Polymorphism

                        ▼

                Code Reusability
```

---

# Complete Chapter Summary

An Abstract Class is a blueprint for related classes.

It provides:

- Common variables
- Common methods
- Abstract methods for child classes
- Constructors
- Static methods
- Final methods

Child classes inherit common functionality while implementing their own specific behavior.

---

# Key Takeaways

- Abstract classes are declared using the `abstract` keyword.
- Objects cannot be created directly.
- They support **partial abstraction**.
- They can contain abstract and concrete methods.
- Constructors are allowed.
- Variables are allowed.
- Static and final methods are allowed.
- Child classes must implement abstract methods.
- Abstract classes promote code reuse and runtime polymorphism.

---

# Conclusion

Abstract Classes are one of the core pillars of Object-Oriented Programming in Java. They provide a balance between complete implementation and complete abstraction by allowing shared code and enforcing essential behavior through abstract methods. They are widely used in enterprise applications, frameworks, and API design because they make code reusable, maintainable, and extensible.

With this chapter completed, you now have a strong foundation in **Abstract Classes**, **Interfaces**, and **Inner Classes**, which prepares you for advanced Java topics such as Generics, Collections, Exception Handling, Multithreading, and Design Patterns.
