# Advanced Constructor Challenges in Java

## Introduction

In real-world applications, constructors are rarely used only to assign values.

They often:

- Validate data
- Initialize complex objects
- Work with multiple constructors
- Support business logic

This chapter contains advanced constructor challenges that simulate real-world scenarios.

---

# Challenge 1: Student Management System

## Problem Statement

Create a Student class with:

```text
name
rollNumber
marks
```

Requirements:

- Initialize using constructor
- Display student details
- Calculate grade

---

## Solution

```java
class Student {

    private String name;
    private int rollNumber;
    private int marks;

    public Student(
            String name,
            int rollNumber,
            int marks) {

        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public char getGrade() {

        if(marks >= 90)
            return 'A';

        if(marks >= 75)
            return 'B';

        if(marks >= 50)
            return 'C';

        return 'F';
    }

    public void display() {

        System.out.println("Name : " + name);
        System.out.println("Roll : " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + getGrade());
    }
}

public class Main {

    public static void main(String[] args) {

        Student student =
                new Student(
                        "Sanjay",
                        101,
                        88);

        student.display();
    }
}
```

### Output

```text
Name : Sanjay
Roll : 101
Marks: 88
Grade: B
```

---

# Challenge 2: Bank Account with Validation

## Problem Statement

Create a BankAccount class.

Requirements:

- Account Number
- Holder Name
- Balance

If balance is negative:

```text
Store 0
```

---

## Solution

```java
class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;

    public BankAccount(
            String accountNumber,
            String holderName,
            double balance) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;

        if(balance >= 0) {

            this.balance = balance;

        } else {

            this.balance = 0;

        }
    }

    public void display() {

        System.out.println(
                "Account Number : "
                + accountNumber);

        System.out.println(
                "Holder Name : "
                + holderName);

        System.out.println(
                "Balance : "
                + balance);
    }
}

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(
                        "ACC1001",
                        "Sanjay",
                        -500);

        account.display();
    }
}
```

### Output

```text
Account Number : ACC1001
Holder Name : Sanjay
Balance : 0.0
```

---

# Challenge 3: Constructor Overloading in Employee System

## Problem Statement

Create an Employee class.

Provide:

```java
Employee()
```

and

```java
Employee(String name,
         String department)
```

---

## Solution

```java
class Employee {

    String name;
    String department;

    public Employee() {

        this.name = "Unknown";
        this.department = "Not Assigned";

    }

    public Employee(
            String name,
            String department) {

        this.name = name;
        this.department = department;
    }

    public void display() {

        System.out.println(
                name +
                " - " +
                department);
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp1 =
                new Employee();

        Employee emp2 =
                new Employee(
                        "Sanjay",
                        "IT");

        emp1.display();
        emp2.display();
    }
}
```

### Output

```text
Unknown - Not Assigned
Sanjay - IT
```

---

# Challenge 4: Laptop Inventory System

## Problem Statement

Create a Laptop class.

Properties:

```text
Brand
Processor
RAM
Price
```

Requirements:

- Constructor Initialization
- Display Specifications
- Display Price Category

---

## Solution

```java
class Laptop {

    String brand;
    String processor;
    int ram;
    double price;

    public Laptop(
            String brand,
            String processor,
            int ram,
            double price) {

        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.price = price;
    }

    public void display() {

        System.out.println(
                brand + " "
                + processor + " "
                + ram + "GB");
    }

    public void priceCategory() {

        if(price > 80000) {

            System.out.println(
                    "Premium Laptop");

        } else {

            System.out.println(
                    "Budget Laptop");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Laptop laptop =
                new Laptop(
                        "Dell",
                        "i7",
                        16,
                        90000);

        laptop.display();

        laptop.priceCategory();
    }
}
```

### Output

```text
Dell i7 16GB
Premium Laptop
```

---

# Challenge 5: University Course Registration System

## Problem Statement

Create a Course class.

Requirements:

```text
Course Name
Course Code
Maximum Seats
Enrolled Students
```

Rules:

```text
Enrolled Students
cannot exceed
Maximum Seats
```

---

## Solution

```java
class Course {

    private String courseName;
    private String courseCode;
    private int maxSeats;
    private int enrolledStudents;

    public Course(
            String courseName,
            String courseCode,
            int maxSeats,
            int enrolledStudents) {

        this.courseName = courseName;
        this.courseCode = courseCode;
        this.maxSeats = maxSeats;

        if(enrolledStudents <= maxSeats) {

            this.enrolledStudents =
                    enrolledStudents;

        } else {

            this.enrolledStudents =
                    maxSeats;
        }
    }

    public void display() {

        System.out.println(
                "Course : "
                + courseName);

        System.out.println(
                "Code : "
                + courseCode);

        System.out.println(
                "Seats : "
                + enrolledStudents
                + "/"
                + maxSeats);
    }
}

public class Main {

    public static void main(String[] args) {

        Course javaCourse =
                new Course(
                        "Java Programming",
                        "CS201",
                        60,
                        75);

        javaCourse.display();
    }
}
```

### Output

```text
Course : Java Programming
Code : CS201
Seats : 60/60
```

---

# Challenge 6: Car Showroom System

## Problem Statement

Create a Car class.

Requirements:

- Constructor Initialization
- Constructor Overloading
- Price Validation
- Display Car Details

---

## Solution

```java
class Car {

    String brand;
    String model;
    double price;

    public Car() {

        brand = "Unknown";
        model = "Unknown";
        price = 0;

    }

    public Car(
            String brand,
            String model,
            double price) {

        this.brand = brand;
        this.model = model;

        if(price > 0) {

            this.price = price;

        } else {

            this.price = 0;
        }
    }

    public void display() {

        System.out.println(
                brand +
                " " +
                model +
                " ₹" +
                price);
    }
}

public class Main {

    public static void main(String[] args) {

        Car car1 = new Car();

        Car car2 =
                new Car(
                        "Hyundai",
                        "Creta",
                        1500000);

        car1.display();

        car2.display();
    }
}
```

### Output

```text
Unknown Unknown ₹0.0
Hyundai Creta ₹1500000.0
```

---

# Concepts Practiced

```text
Constructors
      │
      ├── Initialization
      │
      ├── Validation
      │
      ├── Constructor Overloading
      │
      ├── Encapsulation
      │
      ├── Object Creation
      │
      └── Business Logic
```

---

# Interview Questions

### Why use constructors for validation?

To ensure invalid objects are never created.

---

### Can constructors call methods?

Yes.

---

### Can constructors be overloaded?

Yes.

---

### Can a constructor be private?

Yes.

Used in Singleton Design Pattern.

---

### What is constructor chaining?

Calling one constructor from another constructor using:

```java
this(...)
```

---

# Key Takeaways

- Constructors initialize objects.
- Constructors can validate input.
- Constructor overloading provides flexibility.
- Real-world applications often contain business logic inside constructors.
- Constructors help create reliable objects from the beginning.

---

# Conclusion

These advanced constructor challenges demonstrate how constructors are used in real-world software development. Instead of merely assigning values, constructors often enforce rules, validate data, and ensure that every object starts in a valid state. Mastering these patterns is essential before moving to inheritance, composition, and advanced object-oriented design.
