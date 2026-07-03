# Abstract Class vs Interface in Java (Part 1)

> **Chapter 08 - Abstract Features of Java**

---

# Introduction

One of the most frequently asked Java interview questions is:

> **What is the difference between an Abstract Class and an Interface?**

Although both are used to achieve **abstraction**, they are designed for different purposes.

- **Abstract Class** → Used for **code reuse** and **partial implementation**.
- **Interface** → Used to define a **contract** that classes must follow.

Understanding when to use each is an important skill for Java developers.

---

# Why Do We Need Both?

Suppose we are developing a **Vehicle Management System**.

We have different vehicles:

- Car
- Bike
- Bus

All vehicles have some common features:

- Start Engine
- Stop Engine
- Fuel Tank

But every vehicle starts differently.

Here we can use an **Abstract Class**.

Now suppose we also want every vehicle to support:

- GPS
- Bluetooth

Not every vehicle belongs to the same family, but they all provide these features.

Here we use an **Interface**.

---

# Comparison Table

| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| Keyword | `abstract class` | `interface` |
| Object Creation | ❌ Not Allowed | ❌ Not Allowed |
| Constructor | ✅ Yes | ❌ No |
| Instance Variables | ✅ Yes | ❌ No |
| Constants | ✅ Yes | ✅ (`public static final`) |
| Abstract Methods | ✅ Yes | ✅ Yes |
| Concrete Methods | ✅ Yes | ✅ Default & Static Methods |
| Static Methods | ✅ Yes | ✅ Yes |
| Final Methods | ✅ Yes | ❌ No |
| Inheritance | `extends` | `implements` |
| Multiple Inheritance | ❌ No | ✅ Yes |
| Main Purpose | Code Reuse | Define a Contract |

---

# 1. Keyword

## Abstract Class

An Abstract Class is declared using the **`abstract class`** keyword.

### Syntax

```java
abstract class Animal {

}
```

### Example

```java
abstract class Animal {

    abstract void sound();

}
```

---

## Interface

An Interface is declared using the **`interface`** keyword.

### Syntax

```java
interface Animal {

}
```

### Example

```java
interface Animal {

    void sound();

}
```

---

## Difference

```
Abstract Class

abstract class Animal

↓

Used for inheritance


Interface

interface Animal

↓

Used for contract
```

---

# 2. Object Creation

## Can We Create an Object of an Abstract Class?

No.

### Example

```java
abstract class Animal {

}

public class Main {

    public static void main(String[] args) {

        Animal obj = new Animal();

    }

}
```

### Output

```
Compilation Error

Animal is abstract;
cannot be instantiated.
```

### Why?

An Abstract Class is only a **blueprint**.

It contains incomplete information.

---

## Can We Create an Object of an Interface?

No.

### Example

```java
interface Animal {

}

public class Main {

    public static void main(String[] args) {

        Animal obj = new Animal();

    }

}
```

### Output

```
Compilation Error
```

---

## Memory Diagram

```
Wrong

Animal obj = new Animal();

        ❌

No Object Created
```

---

# 3. Constructor

## Abstract Class

An Abstract Class **can have constructors**.

### Why?

The constructor initializes the common data of child classes.

### Example

```java
abstract class Animal {

    Animal() {

        System.out.println("Animal Constructor");

    }

}

class Dog extends Animal {

    Dog() {

        System.out.println("Dog Constructor");

    }

}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

    }

}
```

### Output

```
Animal Constructor
Dog Constructor
```

---

### Program Flow

```
new Dog()

     │

     ▼

Animal()

     │

     ▼

Dog()

     │

     ▼

Object Created
```

---

## Interface

Interfaces **cannot have constructors**.

### Why?

Because an interface cannot create objects.

Without an object,

a constructor has no purpose.

### Wrong Example

```java
interface Animal {

    Animal() {

    }

}
```

### Output

```
Compilation Error
```

---

# Difference

| Abstract Class | Interface |
|----------------|-----------|
| Constructor Allowed | ✅ Yes |
| Constructor Allowed | ❌ No |

---

# 4. Instance Variables

## Abstract Class

An Abstract Class can contain instance variables.

### Example

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

### Output

```
Mammal
```

---

### Memory Diagram

```
Dog Object

+-------------------+

type = Mammal

+-------------------+
```

---

## Interface

Interfaces cannot contain normal instance variables.

Example

```java
interface Animal {

    int age = 10;

}
```

Compiler converts this into

```java
public static final int age = 10;
```

It becomes a constant.

---

# Difference

```
Abstract Class

String name;

Instance Variable

---------------------

Interface

int AGE = 10;

↓

public static final
```

---

# 5. Constants

## Abstract Class

Can contain constants.

```java
abstract class Demo {

    static final int VALUE = 100;

}
```

---

## Interface

Every variable is automatically

```
public

static

final
```

Example

```java
interface Demo {

    int VALUE = 100;

}
```

Compiler converts it into

```java
public static final int VALUE = 100;
```

---

### Example

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

### Output

```
50000
```

---

## Why?

Interfaces are designed to define behavior,

not store object data.

Therefore,

their variables are constants.

---

# 6. Abstract Methods

## Abstract Class

Can contain abstract methods.

Example

```java
abstract class Animal {

    abstract void sound();

}
```

Child classes must implement the method.

---

### Example Program

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

### Output

```
Dog Barks
```

---

## Interface

Methods are abstract by default.

```java
interface Animal {

    void sound();

}
```

Compiler converts it into

```java
public abstract void sound();
```

---

### Example Program

```java
interface Animal {

    void sound();

}

class Dog implements Animal {

    @Override
    public void sound() {

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

### Output

```
Dog Barks
```

---

# 7. Concrete Methods

## Abstract Class

Can contain normal methods.

```java
abstract class Animal {

    void eat() {

        System.out.println("Eating");

    }

}
```

Child classes inherit this method directly.

---

## Interface

Before Java 8,

interfaces could not contain concrete methods.

From Java 8,

they can contain

- Default Methods
- Static Methods

### Example

```java
interface Animal {

    default void eat() {

        System.out.println("Eating");

    }

}
```

---

### Output

```
Eating
```

---

# 8. Static Methods

## Abstract Class

```java
abstract class Demo {

    static void show() {

        System.out.println("Static Method");

    }

}

public class Main {

    public static void main(String[] args) {

        Demo.show();

    }

}
```

### Output

```
Static Method
```

---

## Interface

Java 8 introduced static methods in interfaces.

```java
interface Demo {

    static void show() {

        System.out.println("Static Method");

    }

}

public class Main {

    public static void main(String[] args) {

        Demo.show();

    }

}
```

### Output

```
Static Method
```

---

# Part 1 Summary

| Feature Covered | Status |
|-----------------|--------|
| Keyword | ✅ |
| Object Creation | ✅ |
| Constructor | ✅ |
| Instance Variables | ✅ |
| Constants | ✅ |
| Abstract Methods | ✅ |
| Concrete Methods | ✅ |
| Static Methods | ✅ |

---

# What's Next?

In **Part 2**, we will cover:

- Final Methods
- `extends` vs `implements`
- Multiple Inheritance
- Diamond Problem
- Main Purpose (Code Reuse vs Contract)
- Real-world Examples
- Decision Tree (When to Use What?)
- Common Mistakes
- Best Practices
- 30+ Interview Questions
- Practice Programs
- Concept Map
- Summary and Conclusion
