# Constructor Challenges in Java

## Introduction

Constructors are used to initialize objects when they are created.

These challenges will help you practice:

- Object Creation
- Constructor Design
- Parameterized Constructors
- Constructor Overloading
- Default Values
- Real-World Modeling

---

# Challenge 1: Student Constructor

## Problem Statement

Create a `Student` class with:

```text
name
age
```

Initialize both values using a constructor.

### Expected Output

```text
Name : Sanjay
Age  : 21
```

---

## Solution

```java
class Student {

    String name;
    int age;

    public Student(String name, int age) {

        this.name = name;
        this.age = age;

    }
}

public class Main {

    public static void main(String[] args) {

        Student student =
                new Student("Sanjay", 21);

        System.out.println(
                "Name : " + student.name);

        System.out.println(
                "Age  : " + student.age);
    }
}
```

---

# Challenge 2: Car Constructor

## Problem Statement

Create a `Car` class with:

```text
brand
model
price
```

Initialize values using a constructor.

---

## Solution

```java
class Car {

    String brand;
    String model;
    double price;

    public Car(
            String brand,
            String model,
            double price) {

        this.brand = brand;
        this.model = model;
        this.price = price;

    }
}
```

---

# Challenge 3: Mobile Constructor

## Problem Statement

Create a `Mobile` class with:

```text
model
ram
storage
```

Initialize all properties through a constructor.

---

## Solution

```java
class Mobile {

    String model;
    int ram;
    int storage;

    public Mobile(
            String model,
            int ram,
            int storage) {

        this.model = model;
        this.ram = ram;
        this.storage = storage;

    }
}
```

---

# Challenge 4: Employee Constructor

## Problem Statement

Create an Employee object with:

```text
name
department
salary
```

using a parameterized constructor.

---

## Solution

```java
class Employee {

    String name;
    String department;
    double salary;

    public Employee(
            String name,
            String department,
            double salary) {

        this.name = name;
        this.department = department;
        this.salary = salary;

    }
}
```

---

# Challenge 5: Book Constructor

## Problem Statement

Create a Book class with:

```text
title
author
price
```

Initialize using constructor.

---

## Solution

```java
class Book {

    String title;
    String author;
    double price;

    public Book(
            String title,
            String author,
            double price) {

        this.title = title;
        this.author = author;
        this.price = price;

    }
}
```

---

# Challenge 6: Bank Account Constructor

## Problem Statement

Create a BankAccount class with:

```text
accountNumber
holderName
balance
```

Initialize through constructor.

---

## Solution

```java
class BankAccount {

    String accountNumber;
    String holderName;
    double balance;

    public BankAccount(
            String accountNumber,
            String holderName,
            double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;

    }
}
```

---

# Challenge 7: Constructor Overloading

## Problem Statement

Create a Student class with:

### Constructor 1

```java
Student()
```

### Constructor 2

```java
Student(String name)
```

---

## Solution

```java
class Student {

    String name;

    public Student() {

        name = "Unknown";

    }

    public Student(String name) {

        this.name = name;

    }
}
```

---

# Challenge 8: Laptop Constructor

## Problem Statement

Create a Laptop class with:

```text
brand
processor
ram
```

and initialize using constructor.

---

## Solution

```java
class Laptop {

    String brand;
    String processor;
    int ram;

    public Laptop(
            String brand,
            String processor,
            int ram) {

        this.brand = brand;
        this.processor = processor;
        this.ram = ram;

    }
}
```

---

# Challenge 9: Circle Constructor

## Problem Statement

Create a Circle class with:

```text
radius
```

Initialize radius using constructor and create a method that returns area.

Formula:

```text
Area = π × r²
```

---

## Solution

```java
class Circle {

    double radius;

    public Circle(double radius) {

        this.radius = radius;

    }

    public double area() {

        return Math.PI *
                radius *
                radius;

    }
}
```

---

# Challenge 10: Rectangle Constructor

## Problem Statement

Create a Rectangle class with:

```text
length
breadth
```

Initialize using constructor and create a method to calculate area.

---

## Solution

```java
class Rectangle {

    int length;
    int breadth;

    public Rectangle(
            int length,
            int breadth) {

        this.length = length;
        this.breadth = breadth;

    }

    public int area() {

        return length * breadth;

    }
}
```

---

# Challenge Difficulty Progression

```text
Student
   ↓
Car
   ↓
Mobile
   ↓
Employee
   ↓
Book
   ↓
BankAccount
   ↓
Constructor Overloading
   ↓
Laptop
   ↓
Circle
   ↓
Rectangle
```

---

# Concepts Practiced

```text
Constructors
      │
      ├── Object Creation
      │
      ├── Initialization
      │
      ├── this Keyword
      │
      ├── Parameter Passing
      │
      └── Constructor Overloading
```

---

# Interview Questions

### Why do we use constructors?

To initialize objects during creation.

---

### Can a constructor return a value?

No.

---

### Can constructors be overloaded?

Yes.

---

### What is constructor overloading?

Creating multiple constructors with different parameter lists.

---

### When is a constructor executed?

Automatically when an object is created.

---

# Key Takeaways

- Constructors initialize objects.
- Constructor names must match class names.
- Constructors do not have return types.
- Parameterized constructors allow custom initialization.
- Constructor overloading improves flexibility.
- Constructors are a core part of Object-Oriented Programming.

---

# Conclusion

These challenges provide practical experience with constructors and object initialization. Mastering constructors is essential because nearly every Java application creates and initializes objects. A strong understanding of constructors prepares you for advanced OOP concepts such as inheritance, polymorphism, and object lifecycle management.
