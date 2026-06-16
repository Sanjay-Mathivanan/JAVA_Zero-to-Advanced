# Abstract Classes in Java (Part 1)

> **Chapter 08 - Abstract Features of Java**

---

# Introduction

An **Abstract Class** is one of the most important concepts in Object-Oriented Programming (OOP). It is used to create a **common blueprint** for a group of related classes.

An abstract class allows us to define:

- Common properties (variables)
- Common behavior (methods with implementation)
- Incomplete behavior (abstract methods)

The child classes inherit the common features and provide their own implementation for the incomplete methods.

In simple words,

> **An Abstract Class is a partially completed class that is meant to be inherited, not instantiated.**

---

# Problem Statement

Suppose you are developing software for a company that manages different types of employees.

The company has:

- Developer
- Tester
- Manager

Every employee has:

- Employee ID
- Employee Name
- Salary

Every employee also has to perform work.

However,

- A Developer writes code.
- A Tester tests software.
- A Manager manages the team.

The common details are the same, but the work is different.

If we write separate classes,

```
Developer

Tester

Manager
```

the common code will be repeated many times.

This violates the **Don't Repeat Yourself (DRY)** principle.

---

# Solution

We create a common parent class.

```
                Employee

          /        |        \

Developer     Tester     Manager
```

The parent class stores the common information.

The child classes implement their own behavior.

This is where **Abstract Classes** become useful.

---

# Real-World Analogy

Imagine a company.

```
Employee

      │

      ├── Developer

      ├── Tester

      └── Manager
```

Every employee

- has an ID
- has a name
- receives a salary

But

their work differs.

Therefore,

```
Employee

knows

WHAT every employee has

but

doesn't know

HOW each employee works.
```

---

# Another Real-World Example

Think about animals.

```
Animal

│

├── Dog

├── Cat

└── Lion
```

Every animal

- eats
- sleeps

But

their sounds differ.

```
Dog

Barks

Cat

Meows

Lion

Roars
```

The common behavior can be placed inside an abstract class.

---

# Why Do We Need Abstract Classes?

Without Abstract Classes

```
Dog

eat()

sleep()

sound()

Cat

eat()

sleep()

sound()

Lion

eat()

sleep()

sound()
```

Notice

```
eat()

sleep()
```

are repeated.

With Abstract Classes

```
Animal

eat()

sleep()

sound()
       ▲
       │
abstract
```

Child classes only implement

```
sound()
```

This reduces code duplication.

---

# Definition

An **Abstract Class** is a class declared using the `abstract` keyword.

It cannot be instantiated.

It is designed to be inherited by other classes.

It may contain:

- Abstract methods
- Normal methods
- Variables
- Constructors
- Static methods
- Final methods

---

# Characteristics

✔ Declared using the `abstract` keyword.

✔ Cannot create objects directly.

✔ Supports inheritance.

✔ Supports partial abstraction.

✔ Can contain constructors.

✔ Can contain variables.

✔ Can contain both abstract and concrete methods.

✔ Child class must implement abstract methods.

---

# Syntax

```java
abstract class Animal {

    abstract void sound();

}
```

---

# Understanding the Syntax

```
abstract class Animal
```

Creates an abstract class.

```
abstract void sound();
```

Creates an abstract method.

Notice

there is

```
NO

method body.
```

---

# What is an Abstract Method?

An abstract method is a method that contains

only

the declaration.

Example

```java
abstract void sound();
```

Wrong

```java
abstract void sound(){

}
```

Abstract methods cannot have a body.

---

# What is a Concrete Method?

A concrete method is a normal method.

Example

```java
void eat(){

    System.out.println("Eating");

}
```

Concrete methods already have implementation.

---

# Complete Example

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

        Dog dog = new Dog();

        dog.sound();

    }

}
```

---

# Output

```
Dog Barks
```

---

# Step-by-Step Explanation

## Step 1

Create an abstract class.

```java
abstract class Animal
```

This class cannot create objects.

---

## Step 2

Declare an abstract method.

```java
abstract void sound();
```

This tells every child class,

"You must implement this method."

---

## Step 3

Create child class.

```java
class Dog extends Animal
```

Dog inherits Animal.

---

## Step 4

Override method.

```java
void sound()
```

Dog provides the implementation.

---

## Step 5

Create object.

```java
Dog dog = new Dog();
```

Notice

we create

```
Dog

Object
```

NOT

```
Animal

Object
```

---

## Step 6

Call method.

```java
dog.sound();
```

Output

```
Dog Barks
```

---

# Program Flow

```
Start

 │

 ▼

Load Animal Class

 │

 ▼

Load Dog Class

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

 │

 ▼

End
```

---

# Memory Representation

```
Stack Memory

+----------------------+
| dog                  |
+----------|-----------+
           |
           ▼

Heap Memory

+----------------------+
| Dog Object           |
|----------------------|
| sound()              |
+----------------------+
```

Notice

```
Animal Object

DOES NOT EXIST
```

because

Abstract Classes cannot be instantiated.

---

# Can We Create an Object?

Wrong

```java
Animal a = new Animal();
```

Compiler Error

```
Animal is abstract;

cannot be instantiated.
```

---

# Why Can't We Create Objects?

Imagine a building blueprint.

```
Blueprint

      │

      ▼

House
```

Can we live inside

the blueprint?

No.

The blueprint is only a design.

Similarly,

```
Abstract Class

is

only

a blueprint.
```

---

# Internal Working

When Java compiles

```java
abstract class Animal
```

the compiler marks it as

```
ABSTRACT
```

During object creation,

the JVM checks

```
Is this class abstract?
```

If

```
YES
```

Object creation is rejected.

---

# ASCII Diagram

```
           Animal

     +----------------+

     | abstract class |

     +----------------+

          ▲

          │

     extends

          │

 +----------------+

 | Dog            |

 +----------------+

          │

          ▼

     Dog Object
```

---

# Rules of Abstract Classes

### Rule 1

Use the `abstract` keyword.

```java
abstract class Animal
```

---

### Rule 2

Cannot create objects.

Wrong

```java
new Animal();
```

---

### Rule 3

Can contain constructors.

---

### Rule 4

Can contain variables.

---

### Rule 5

Can contain normal methods.

---

### Rule 6

Can contain abstract methods.

---

### Rule 7

If a child class does not implement all abstract methods,

it must also be declared as abstract.

Example

```java
abstract class Dog extends Animal{

}
```

---

# Advantages

- Reduces code duplication.
- Promotes code reuse.
- Supports partial abstraction.
- Provides a common structure.
- Improves maintainability.
- Makes code easier to understand.

---

# Disadvantages

- Cannot create objects.
- Java supports only single inheritance.
- Slightly more complex than normal classes.

---

# Common Mistakes

### Mistake 1

Creating an object.

❌ Wrong

```java
Animal a = new Animal();
```

---

### Mistake 2

Forgetting to override abstract methods.

```java
class Dog extends Animal{

}
```

Compilation Error.

---

### Mistake 3

Giving a body to an abstract method.

❌ Wrong

```java
abstract void sound(){

}
```

---

# Best Practices

- Use abstract classes when multiple related classes share common code.
- Keep only common functionality in the abstract class.
- Use meaningful abstract method names.
- Do not make every class abstract unnecessarily.

---

# Key Takeaways (Part 1)

- An Abstract Class is declared using the `abstract` keyword.
- It cannot be instantiated.
- It acts as a blueprint for child classes.
- It can contain both abstract and concrete methods.
- Child classes must implement abstract methods.
- It helps reduce code duplication and improve code reuse.

---

# What's Next?

In **Part 2**, we will learn:

- Constructors in Abstract Classes
- Variables in Abstract Classes
- Concrete Methods
- Static Methods
- Final Methods
- Method Overriding
- Runtime Polymorphism
- Multiple Child Classes
- Complete Real-World Programs
- Memory Diagrams
- Internal JVM Working
