# Inner Classes in Java

## Introduction

An **Inner Class** is a class that is declared inside another class.

The class outside is called the **Outer Class**, and the class inside it is called the **Inner Class**.

Inner classes help organize related classes together and improve code readability.

---

## Why Do We Need Inner Classes?

Suppose we have a **Car**.

A car has an **Engine**.

The Engine is closely related to the Car and is not useful without it.

Instead of creating two separate classes, we can write:

```
Car
 └── Engine
```

This makes the code more organized.

---

## Syntax

```java
class Outer {

    class Inner {

    }

}
```

---

## Example

```java
class Car {

    class Engine {

        void start() {

            System.out.println("Engine Started");

        }

    }

}

public class Main {

    public static void main(String[] args) {

        Car car = new Car();

        Car.Engine engine = car.new Engine();

        engine.start();

    }

}
```

---

## Output

```
Engine Started
```

---

## Explanation

### Step 1

Create the outer class.

```java
class Car
```

### Step 2

Create the inner class.

```java
class Engine
```

### Step 3

Create an object of the outer class.

```java
Car car = new Car();
```

### Step 4

Create an object of the inner class.

```java
Car.Engine engine = car.new Engine();
```

### Step 5

Call the method.

```java
engine.start();
```

Output:

```
Engine Started
```

---

## Memory Diagram

```
Stack

car
engine
  │
  ▼

Heap

+-------------+
| Car Object  |
+-------------+
       │
       ▼
+----------------+
| Engine Object  |
+----------------+
```

---

## Advantages

- Better code organization.
- Improves encapsulation.
- Can access outer class members directly.
- Keeps related classes together.

---

## Disadvantages

- Slightly complex object creation.
- Can make code difficult to read if overused.

---

## Types of Inner Classes

Java has four types of inner (nested) classes:

1. **Member Inner Class**
2. **Static Nested Class**
3. **Local Inner Class**
4. **Anonymous Inner Class**

```
Nested Classes
│
├── Static Nested Class
│
└── Inner Classes
    ├── Member Inner Class
    ├── Local Inner Class
    └── Anonymous Inner Class
```

---

## Key Points

- An Inner Class is a class inside another class.
- The outer class contains the inner class.
- An inner class can access private members of the outer class.
- A Member Inner Class requires an outer class object.
- Inner classes help group related classes together.

---

## Interview Questions

**Q1. What is an Inner Class?**

A class declared inside another class is called an Inner Class.

**Q2. Why are Inner Classes used?**

To improve code organization, encapsulation, and group related classes together.

**Q3. Can an Inner Class access private members of the outer class?**

Yes, it can directly access private variables and methods.

---

## Conclusion

Inner Classes are used when one class is closely related to another class. They improve readability, encapsulation, and maintainability by keeping related classes together. Java provides different types of inner classes for different use cases, such as Member, Local, Anonymous, and Static Nested Classes.
