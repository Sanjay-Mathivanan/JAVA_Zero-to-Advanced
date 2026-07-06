# Overloading and Overriding Practice Challenges

## Introduction

This chapter compiles intermediate and advanced challenges focusing on Method Overloading and Method Overriding. These exercises simulate real-world scenarios in retail checkout operations, device power management, course registration caps, and corporate structures. They are designed to mirror assessments in technical interviews and programming certifications.

---

## Challenge 1: Area Calculator (Method Overloading)

### Problem Statement
Create a utility class `ShapeCalculator` containing overloaded versions of a method `area()`. Implement formulas to calculate:
* The area of a Square (accepting one `int` side).
* The area of a Rectangle (accepting `int` length and `int` breadth).
* The area of a Circle (accepting `double` radius).

### Solution
```java
public class ShapeCalculator {
    public static int area(int side) {
        return side * side;
    }

    public static int area(int length, int breadth) {
        return length * breadth;
    }

    public static double area(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        System.out.println("Square Area = " + area(5));
        System.out.println("Rectangle Area = " + area(10, 20));
        System.out.println("Circle Area = " + area(7.0));
    }
}
```

### Output
```text
Square Area = 25
Rectangle Area = 200
Circle Area = 153.93804002589985
```

---

## Challenge 2: Employee Salary Calculator

### Problem Statement
Create an `Employee` class containing overloaded versions of a method `calculateSalary()`. It must support:
1. Basic salary calculation (accepting `double basic`).
2. Basic salary + bonus calculation (accepting `double basic` and `double bonus`).
3. Basic salary + bonus + incentive (accepting `double basic`, `double bonus`, and `double incentive`).

### Solution
```java
class Employee {
    public double calculateSalary(double basic) {
        return basic;
    }

    public double calculateSalary(double basic, double bonus) {
        return basic + bonus;
    }

    public double calculateSalary(double basic, double bonus, double incentive) {
        return basic + bonus + incentive;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println("Salary 1: " + emp.calculateSalary(50000));
        System.out.println("Salary 2: " + emp.calculateSalary(50000, 5000));
        System.out.println("Salary 3: " + emp.calculateSalary(50000, 5000, 2000));
    }
}
```

### Output
```text
Salary 1: 50000.0
Salary 2: 55000.0
Salary 3: 57000.0
```

---

## Challenge 3: Vehicle Sound System (Method Overriding)

### Problem Statement
Create a parent class `Vehicle` with a method `start()`. Extend this class with subclasses `Car` and `Bike`. Override the `start()` method in the subclasses to output specialized startup logs. Apply upcasting in the main program to demonstrate runtime polymorphism.

### Solution
```java
class Vehicle {
    public void start() {
        System.out.println("Vehicle Started");
    }
}

class Car extends Vehicle {
    @Override
    public void start() {
        System.out.println("Car engine started cleanly.");
    }
}

class Bike extends Vehicle {
    @Override
    public void start() {
        System.out.println("Bike engine started cleanly.");
    }
}

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();
        bike.start();
    }
}
```

### Output
```text
Car engine started cleanly.
Bike engine started cleanly.
```

---

## Challenge 4: University Grading System

### Problem Statement
Design a `GradeCalculator` class. Implement overloaded versions of `calculateGradeScore()` that calculate a total numerical score out of 100 based on:
1. Marks alone (up to 80).
2. Marks + attendance bonus (marks up to 80, attendance up to 10).
3. Marks + attendance bonus + project score (marks up to 80, attendance up to 10, project up to 10).

### Solution
```java
class GradeCalculator {
    public int calculateGradeScore(int marks) {
        return marks;
    }

    public int calculateGradeScore(int marks, int attendance) {
        return marks + attendance;
    }

    public int calculateGradeScore(int marks, int attendance, int project) {
        return marks + attendance + project;
    }
}
```

---

## Challenge 5: Banking Notification System

### Problem Statement
Create a parent class `Notification` with a method `send()`. Build child classes `EmailNotification` and `SMSNotification` that override the `send()` method to issue customized notifications. Demonstrate runtime polymorphism by executing the notifications from a collection or base references.

### Solution
```java
class Notification {
    public void send() {
        System.out.println("Sending standard Notification");
    }
}

class EmailNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending confirmation email...");
    }
}

class SMSNotification extends Notification {
    @Override
    public void send() {
        System.out.println("Sending alert SMS message...");
    }
}

public class Main {
    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();

        email.send();
        sms.send();
    }
}
```

### Output
```text
Sending confirmation email...
Sending alert SMS message...
```

---

## Challenge 6: Shape Area System

### Problem Statement
Combine method overriding and method overloading in a single model. Create a parent class `Shape` with a default `area()` method. Extend this class with subclasses `Rectangle` and `Circle`, overriding the `area()` method to display specific calculations.

### Solution
```java
class Shape {
    public void area() {
        System.out.println("Shape Area");
    }
}

class Rectangle extends Shape {
    @Override
    public void area() {
        System.out.println("Rectangle Area");
    }
}

class Circle extends Shape {
    @Override
    public void area() {
        System.out.println("Circle Area");
    }
}
```

---

## Challenge 7: Calculator Application

### Problem Statement
Write a `Calculator` class demonstrating method overloading. Overload the `add()` method to support adding two `int` variables, three `int` variables, and two `double` variables.

### Solution
```java
class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }
}
```

---

## Challenge 8: Employee Hierarchy

### Problem Statement
Create a parent class `Employee` with a method `work()`. Build subclasses `Manager`, `Developer`, and `Tester`. Override `work()` in each subclass to describe their respective work assignments.

### Solution
```java
class Employee {
    public void work() {
        System.out.println("Employee is working...");
    }
}

class Manager extends Employee {
    @Override
    public void work() {
        System.out.println("Managing team schedules and deliveries.");
    }
}

class Developer extends Employee {
    @Override
    public void work() {
        System.out.println("Writing and review software code.");
    }
}

class Tester extends Employee {
    @Override
    public void work() {
        System.out.println("Testing code modules and generating reports.");
    }
}
```

---

## Challenge 9: Food Ordering System

### Problem Statement
Create a class `FoodOrder` with overloaded methods `order()` supporting:
1. Ordering a single item.
2. Ordering two items.
3. Ordering three items.

### Solution
```java
class FoodOrder {
    public void order(String item1) {
        System.out.println("Ordered: " + item1);
    }

    public void order(String item1, String item2) {
        System.out.println("Ordered: " + item1 + ", " + item2);
    }

    public void order(String item1, String item2, String item3) {
        System.out.println("Ordered: " + item1 + ", " + item2 + ", " + item3);
    }
}
```

---

## Challenge 10: Smart Device System

### Problem Statement
Create a base class `Device` with a method `powerOn()`. Build subclasses `Laptop`, `Mobile`, and `SmartWatch`, overriding the method to display customized power-on logic.

### Solution
```java
class Device {
    public void powerOn() {
        System.out.println("Device powered on.");
    }
}

class Laptop extends Device {
    @Override
    public void powerOn() {
        System.out.println("Laptop loading bios and OS boot...");
    }
}

class Mobile extends Device {
    @Override
    public void powerOn() {
        System.out.println("Mobile activating home launcher...");
    }
}

class SmartWatch extends Device {
    @Override
    public void powerOn() {
        System.out.println("SmartWatch loading watch face...");
    }
}

public class Main {
    public static void main(String[] args) {
        Device laptop = new Laptop();
        Device mobile = new Mobile();
        Device watch = new SmartWatch();

        laptop.powerOn();
        mobile.powerOn();
        watch.powerOn();
    }
}
```

### Output
```text
Laptop loading bios and OS boot...
Mobile activating home launcher...
SmartWatch loading watch face...
```

---

## Summary of Practice Challenges

| Challenge Index | Concept Implemented |
| :--- | :--- |
| **Challenges 1, 2, 4, 7, 9** | **Method Overloading**: Same names, different signatures (Compile-Time). |
| **Challenges 3, 5, 6, 8, 10** | **Method Overriding**: Parent-child override relationships (Runtime). |

---

## Interview Questions (FAQ)

### What is method overloading?
Method overloading is defining multiple methods in the same class with the same name but different parameters (by number, order, or data type).

### What is method overriding?
Method overriding is redefining a method in a child subclass that already exists in the parent superclass, maintaining the exact same name, return type, and parameter list.

### Can static methods be overridden in Java?
No, static methods belong to the class, not instance objects, and cannot be overridden. Redeclaring a parent's static method in a subclass is known as **Method Hiding**.

### Why is method overriding referred to as runtime polymorphism?
Because the decision of which overriding method to execute is determined at runtime by the JVM based on the actual object type in Heap memory, rather than the reference variable data type.

---

## Key Takeaways

* Overloading is determined at compile-time; overriding is determined at runtime.
* Overriding requires a subclass-superclass inheritance structure.
* Standardized signatures and `@Override` annotation prevent typo bugs in overrides.
* Methods marked `final` or `private` cannot be overridden.

---

**Back to Module Home:** [Building Blocks of Java](README.md)
