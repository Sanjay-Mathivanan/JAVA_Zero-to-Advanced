# Advanced Method Overloading and Method Overriding Challenges

## Introduction

In previous chapters, we learned:

- Method Overloading
- Method Overriding
- Constructors
- Classes and Objects
- Inheritance Basics

This chapter combines all of these concepts into practical challenges.

These are similar to questions asked in:

- Java Interviews
- University Labs
- Coding Assessments
- OOP Projects

---

# Challenge 1: Area Calculator (Method Overloading)

## Problem Statement

Create multiple versions of an `area()` method.

Calculate:

```text
Square Area
Rectangle Area
Circle Area
```

using the same method name.

---

## Solution

```java
public class Main {

    public static int area(int side) {

        return side * side;
    }

    public static int area(
            int length,
            int breadth) {

        return length * breadth;
    }

    public static double area(
            double radius) {

        return Math.PI *
                radius *
                radius;
    }

    public static void main(String[] args) {

        System.out.println(
                "Square Area = "
                + area(5));

        System.out.println(
                "Rectangle Area = "
                + area(10, 20));

        System.out.println(
                "Circle Area = "
                + area(7.0));
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

# Challenge 2: Employee Salary Calculator

## Problem Statement

Overload a method called:

```java
calculateSalary()
```

Cases:

```text
Basic Salary

Basic + Bonus

Basic + Bonus + Incentive
```

---

## Solution

```java
class Employee {

    public double calculateSalary(
            double basic) {

        return basic;
    }

    public double calculateSalary(
            double basic,
            double bonus) {

        return basic + bonus;
    }

    public double calculateSalary(
            double basic,
            double bonus,
            double incentive) {

        return basic +
                bonus +
                incentive;
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();

        System.out.println(
                emp.calculateSalary(50000));

        System.out.println(
                emp.calculateSalary(
                        50000,
                        5000));

        System.out.println(
                emp.calculateSalary(
                        50000,
                        5000,
                        2000));
    }
}
```

### Output

```text
50000.0
55000.0
57000.0
```

---

# Challenge 3: Vehicle Sound System (Method Overriding)

## Problem Statement

Create:

```text
Vehicle
Car
Bike
Truck
```

Override:

```java
start()
```

---

## Solution

```java
class Vehicle {

    public void start() {

        System.out.println(
                "Vehicle Started");
    }
}

class Car extends Vehicle {

    @Override
    public void start() {

        System.out.println(
                "Car Started");
    }
}

class Bike extends Vehicle {

    @Override
    public void start() {

        System.out.println(
                "Bike Started");
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
Car Started
Bike Started
```

---

# Challenge 4: University Grading System

## Problem Statement

Overload:

```java
calculateGrade()
```

for:

```text
Marks Only

Marks + Attendance

Marks + Attendance + Project
```

---

## Solution

```java
class GradeCalculator {

    public int calculateGrade(
            int marks) {

        return marks;
    }

    public int calculateGrade(
            int marks,
            int attendance) {

        return marks + attendance;
    }

    public int calculateGrade(
            int marks,
            int attendance,
            int project) {

        return marks +
                attendance +
                project;
    }
}
```

---

# Challenge 5: Banking Notification System

## Problem Statement

Create:

```text
Notification
EmailNotification
SMSNotification
```

Override:

```java
send()
```

---

## Solution

```java
class Notification {

    public void send() {

        System.out.println(
                "Sending Notification");
    }
}

class EmailNotification
        extends Notification {

    @Override
    public void send() {

        System.out.println(
                "Sending Email");
    }
}

class SMSNotification
        extends Notification {

    @Override
    public void send() {

        System.out.println(
                "Sending SMS");
    }
}

public class Main {

    public static void main(String[] args) {

        Notification email =
                new EmailNotification();

        Notification sms =
                new SMSNotification();

        email.send();
        sms.send();
    }
}
```

### Output

```text
Sending Email
Sending SMS
```

---

# Challenge 6: Shape Area System

## Problem Statement

Combine:

```text
Method Overloading
Method Overriding
```

Create:

```text
Shape
Rectangle
Circle
```

---

## Solution

```java
class Shape {

    public void area() {

        System.out.println(
                "Shape Area");
    }
}

class Rectangle
        extends Shape {

    @Override
    public void area() {

        System.out.println(
                "Rectangle Area");
    }
}

class Circle
        extends Shape {

    @Override
    public void area() {

        System.out.println(
                "Circle Area");
    }
}
```

---

# Challenge 7: Calculator Application

## Problem Statement

Create overloaded methods:

```java
add()
```

Support:

```text
2 Numbers
3 Numbers
Double Values
```

---

## Solution

```java
class Calculator {

    public int add(
            int a,
            int b) {

        return a + b;
    }

    public int add(
            int a,
            int b,
            int c) {

        return a + b + c;
    }

    public double add(
            double a,
            double b) {

        return a + b;
    }
}
```

---

# Challenge 8: Employee Hierarchy

## Problem Statement

Create:

```text
Employee
Manager
Developer
Tester
```

Override:

```java
work()
```

---

## Solution

```java
class Employee {

    public void work() {

        System.out.println(
                "Employee Working");
    }
}

class Manager extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Managing Team");
    }
}

class Developer extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Writing Code");
    }
}

class Tester extends Employee {

    @Override
    public void work() {

        System.out.println(
                "Testing Software");
    }
}
```

---

# Challenge 9: Food Ordering System

## Problem Statement

Overload:

```java
order()
```

Support:

```text
One Item

Two Items

Three Items
```

---

## Solution

```java
class FoodOrder {

    public void order(
            String item1) {

        System.out.println(
                item1);
    }

    public void order(
            String item1,
            String item2) {

        System.out.println(
                item1 + ", " + item2);
    }

    public void order(
            String item1,
            String item2,
            String item3) {

        System.out.println(
                item1 + ", " +
                item2 + ", " +
                item3);
    }
}
```

---

# Challenge 10: Smart Device System

## Problem Statement

Create:

```text
Device
Laptop
Mobile
SmartWatch
```

Override:

```java
powerOn()
```

---

## Solution

```java
class Device {

    public void powerOn() {

        System.out.println(
                "Device Powered On");
    }
}

class Laptop extends Device {

    @Override
    public void powerOn() {

        System.out.println(
                "Laptop Booting");
    }
}

class Mobile extends Device {

    @Override
    public void powerOn() {

        System.out.println(
                "Mobile Starting");
    }
}

class SmartWatch
        extends Device {

    @Override
    public void powerOn() {

        System.out.println(
                "SmartWatch Activated");
    }
}

public class Main {

    public static void main(String[] args) {

        Device laptop =
                new Laptop();

        Device mobile =
                new Mobile();

        Device watch =
                new SmartWatch();

        laptop.powerOn();
        mobile.powerOn();
        watch.powerOn();
    }
}
```

### Output

```text
Laptop Booting
Mobile Starting
SmartWatch Activated
```

---

# Challenge Summary

```text
Challenge 1  → Overloading
Challenge 2  → Overloading
Challenge 3  → Overriding
Challenge 4  → Overloading
Challenge 5  → Overriding
Challenge 6  → Overriding
Challenge 7  → Overloading
Challenge 8  → Overriding
Challenge 9  → Overloading
Challenge 10 → Overriding
```

---

# Interview Questions

### What is Method Overloading?

Same method name with different parameters.

---

### What is Method Overriding?

Redefining a parent class method inside a child class.

---

### Which supports Compile-Time Polymorphism?

```text
Method Overloading
```

---

### Which supports Runtime Polymorphism?

```text
Method Overriding
```

---

### Is inheritance required for overloading?

```text
No
```

---

### Is inheritance required for overriding?

```text
Yes
```

---

# Key Takeaways

- Overloading improves flexibility.
- Overriding customizes parent behavior.
- Overloading is compile-time polymorphism.
- Overriding is runtime polymorphism.
- Both are core OOP concepts.
- Frequently asked in Java interviews.

---

# Conclusion

Method Overloading and Method Overriding are two of the most powerful features of Java. These challenges demonstrate how they are used in real-world applications such as banking systems, employee management systems, device management, and academic software. Mastering these concepts is essential for writing scalable and reusable object-oriented programs.
