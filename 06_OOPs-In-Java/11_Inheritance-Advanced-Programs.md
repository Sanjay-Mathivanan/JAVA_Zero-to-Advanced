# Advanced Inheritance Programs in Java

## Introduction

Now that we understand:

- Single Inheritance
- Multilevel Inheritance
- Hierarchical Inheritance

it's time to build real-world applications using inheritance.

These programs demonstrate how inheritance is used in professional software systems.

---

# Problem 1: Employee Management System

## Problem Statement

Create:

```text
Employee
   │
   ├── Developer
   └── Manager
```

Requirements:

- Employee should store name and salary.
- Developer should display programming language.
- Manager should display team size.

---

## Class Diagram

```text
Employee
------------------
name
salary
displayInfo()

        ▲
        │
 ┌──────┴──────┐
 │             │
 ▼             ▼

Developer    Manager
language     teamSize
```

---

## Solution

```java
class Employee {

    protected String name;
    protected double salary;

    public Employee(
            String name,
            double salary) {

        this.name = name;
        this.salary = salary;
    }

    public void displayInfo() {

        System.out.println(
                "Name : " + name);

        System.out.println(
                "Salary : " + salary);
    }
}

class Developer extends Employee {

    private String language;

    public Developer(
            String name,
            double salary,
            String language) {

        super(name, salary);

        this.language = language;
    }

    public void displayDeveloper() {

        displayInfo();

        System.out.println(
                "Language : " + language);
    }
}

class Manager extends Employee {

    private int teamSize;

    public Manager(
            String name,
            double salary,
            int teamSize) {

        super(name, salary);

        this.teamSize = teamSize;
    }

    public void displayManager() {

        displayInfo();

        System.out.println(
                "Team Size : "
                + teamSize);
    }
}
```

---

## Output

```text
Name : Sanjay
Salary : 60000.0
Language : Java

Name : Rahul
Salary : 90000.0
Team Size : 12
```

---

# Problem 2: Vehicle Management System

## Problem Statement

Create:

```text
Vehicle
    │
    ├── Car
    ├── Bike
    └── Truck
```

Requirements:

- Vehicle contains brand.
- Child classes contain unique functionality.

---

## Solution

```java
class Vehicle {

    protected String brand;

    public Vehicle(String brand) {

        this.brand = brand;
    }

    public void start() {

        System.out.println(
                brand + " Started");
    }
}

class Car extends Vehicle {

    public Car(String brand) {

        super(brand);
    }

    public void drive() {

        System.out.println(
                "Driving Car");
    }
}

class Bike extends Vehicle {

    public Bike(String brand) {

        super(brand);
    }

    public void ride() {

        System.out.println(
                "Riding Bike");
    }
}

class Truck extends Vehicle {

    public Truck(String brand) {

        super(brand);
    }

    public void loadGoods() {

        System.out.println(
                "Loading Goods");
    }
}
```

---

## Output

```text
Toyota Started
Driving Car

Yamaha Started
Riding Bike

Ashok Leyland Started
Loading Goods
```

---

# Problem 3: College Management System

## Problem Statement

Create:

```text
Person
   │
   ├── Student
   └── Teacher
```

Requirements:

- Person stores name and age.
- Student stores roll number.
- Teacher stores subject.

---

## Solution

```java
class Person {

    protected String name;
    protected int age;

    public Person(
            String name,
            int age) {

        this.name = name;
        this.age = age;
    }

    public void displayPerson() {

        System.out.println(
                "Name : " + name);

        System.out.println(
                "Age : " + age);
    }
}

class Student extends Person {

    private int rollNo;

    public Student(
            String name,
            int age,
            int rollNo) {

        super(name, age);

        this.rollNo = rollNo;
    }

    public void displayStudent() {

        displayPerson();

        System.out.println(
                "Roll No : " + rollNo);
    }
}

class Teacher extends Person {

    private String subject;

    public Teacher(
            String name,
            int age,
            String subject) {

        super(name, age);

        this.subject = subject;
    }

    public void displayTeacher() {

        displayPerson();

        System.out.println(
                "Subject : " + subject);
    }
}
```

---

## Output

```text
Name : Sanjay
Age : 21
Roll No : 23

Name : Kumar
Age : 40
Subject : Java
```

---

# Problem 4: Banking System

## Problem Statement

Create:

```text
Account
    │
    ├── SavingsAccount
    └── CurrentAccount
```

Requirements:

- Store account holder name.
- Store balance.
- Child classes display account type.

---

## Solution

```java
class Account {

    protected String holder;
    protected double balance;

    public Account(
            String holder,
            double balance) {

        this.holder = holder;
        this.balance = balance;
    }

    public void displayAccount() {

        System.out.println(
                holder);

        System.out.println(
                balance);
    }
}

class SavingsAccount
        extends Account {

    public SavingsAccount(
            String holder,
            double balance) {

        super(holder, balance);
    }

    public void accountType() {

        System.out.println(
                "Savings Account");
    }
}

class CurrentAccount
        extends Account {

    public CurrentAccount(
            String holder,
            double balance) {

        super(holder, balance);
    }

    public void accountType() {

        System.out.println(
                "Current Account");
    }
}
```

---

## Output

```text
Sanjay
5000.0
Savings Account

Rahul
10000.0
Current Account
```

---

# Problem 5: University System (Multilevel Inheritance)

## Problem Statement

Create:

```text
Person
   │
   ▼
Student
   │
   ▼
CollegeStudent
```

Requirements:

- Person contains name.
- Student contains roll number.
- CollegeStudent contains department.

---

## Solution

```java
class Person {

    protected String name;

    public Person(String name) {

        this.name = name;
    }
}

class Student extends Person {

    protected int rollNo;

    public Student(
            String name,
            int rollNo) {

        super(name);

        this.rollNo = rollNo;
    }
}

class CollegeStudent
        extends Student {

    private String department;

    public CollegeStudent(
            String name,
            int rollNo,
            String department) {

        super(name, rollNo);

        this.department = department;
    }

    public void display() {

        System.out.println(
                "Name : " + name);

        System.out.println(
                "Roll No : " + rollNo);

        System.out.println(
                "Department : "
                + department);
    }
}
```

---

## Output

```text
Name : Sanjay
Roll No : 23
Department : AIDS
```

---

# Understanding Constructor Chaining

Consider:

```java
CollegeStudent student =
        new CollegeStudent(
                "Sanjay",
                23,
                "AIDS");
```

Execution:

```text
CollegeStudent Constructor
          │
          ▼

Student Constructor
          │
          ▼

Person Constructor
          │
          ▼

Object Created
```

---

# Real-World Inheritance Examples

## Banking

```text
Account
   │
   ├── SavingsAccount
   ├── CurrentAccount
   └── LoanAccount
```

---

## Education

```text
Person
   │
   ├── Student
   ├── Teacher
   └── Principal
```

---

## Transport

```text
Vehicle
   │
   ├── Car
   ├── Bike
   └── Truck
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

# Common Mistakes

## Wrong IS-A Relationship

Wrong:

```java
class Engine extends Car
```

Reason:

```text
Engine is NOT a Car
```

---

Correct:

```text
Car HAS-A Engine
```

Use Composition.

---

## Forgetting super()

Wrong:

```java
public Student() {

}
```

when parent constructor requires parameters.

---

Correct:

```java
super(name);
```

---

## Using Private Variables Directly

Wrong:

```java
System.out.println(name);
```

if name is private.

Use:

```java
protected
```

or

```java
Getter Methods
```

---

# Interview Questions

## What is inheritance?

A mechanism where one class acquires properties and methods of another class.

---

## What keyword is used?

```java
extends
```

---

## What relationship does inheritance represent?

```text
IS-A Relationship
```

---

## Which constructor executes first?

Parent constructor.

---

## What is constructor chaining?

The process where constructors execute from parent to child.

---

# Practice Challenges

## Challenge 1

Create:

```text
Employee
Developer
Tester
Manager
```

Store employee details.

---

## Challenge 2

Create:

```text
Vehicle
Car
Bike
Truck
```

Add different features.

---

## Challenge 3

Create:

```text
Person
Student
Teacher
Principal
```

Display complete information.

---

## Challenge 4

Create:

```text
Account
SavingsAccount
CurrentAccount
LoanAccount
```

Display account types.

---

## Challenge 5

Create:

```text
Animal
Dog
Puppy
```

Demonstrate multilevel inheritance.

---

# Key Takeaways

- Inheritance promotes code reuse.
- Child classes inherit methods and variables from parent classes.
- Use inheritance only for IS-A relationships.
- Constructors execute from parent to child.
- Inheritance reduces duplication and improves maintainability.
- Real-world applications heavily use inheritance.

---

# Conclusion

These advanced inheritance programs demonstrate how inheritance is used in real-world systems such as banking, education, transportation, and employee management. Understanding these patterns will help you design scalable and maintainable Java applications while preparing for interviews and large-scale projects.
