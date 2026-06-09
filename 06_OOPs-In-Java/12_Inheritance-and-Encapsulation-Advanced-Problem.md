# Inheritance and Encapsulation Advanced Problem

## Corporate Payroll Management System

---

# Problem Statement

Design a Corporate Payroll System that demonstrates both:

```text
Encapsulation
+
Inheritance
```

The system should model employees working in a company.

Requirements:

### Employee (Parent Class)

Store:

```text
Employee ID
Employee Name
Base Salary
```

Rules:

- Base Salary must be private.
- Salary should not be directly accessible.
- Use getters and setters for controlled access.
- Salary cannot be negative.

---

### Manager (Child Class)

A Manager receives:

```text
Base Salary
+
Performance Bonus
```

Formula:

```text
Total Salary =
Base Salary + Bonus
```

---

### Intern (Child Class)

An Intern receives:

```text
Monthly Stipend
```

Formula:

```text
Total Salary =
Base Salary
```

---

### Goal

Demonstrate:

```text
Encapsulation
    ↓
Protect Salary Data

Inheritance
    ↓
Reuse Employee Features

Polymorphic Behavior
    ↓
Different Salary Calculations
```

---

# Understanding the Design

## Class Diagram

```text
                    Employee
         --------------------------------
         - employeeId
         - employeeName
         - baseSalary (private)
         --------------------------------
         + getSalary()
         + setSalary()
         + calculatePay()
         --------------------------------
                     ▲
                     │
         ┌───────────┴───────────┐
         │                       │
         ▼                       ▼

      Manager                 Intern

   + bonus                + stipend

   calculatePay()         calculatePay()
```

---

# Why Encapsulation?

Suppose salary is public:

```java
employee.salary = -50000;
```

Problem:

```text
Invalid Salary
```

To prevent this:

```java
private double baseSalary;
```

Now salary can only be modified through:

```java
setBaseSalary()
```

which performs validation.

---

# Why Inheritance?

Every employee has:

```text
Employee ID
Employee Name
Base Salary
```

Instead of repeating code:

```text
Manager
Intern
Developer
Tester
```

all inherit from:

```text
Employee
```

---

# Solution

## Employee Class

```java
class Employee {

    private int employeeId;
    private String employeeName;
    private double baseSalary;

    public Employee(
            int employeeId,
            String employeeName,
            double baseSalary) {

        this.employeeId = employeeId;
        this.employeeName = employeeName;

        setBaseSalary(baseSalary);
    }

    public int getEmployeeId() {

        return employeeId;
    }

    public String getEmployeeName() {

        return employeeName;
    }

    public double getBaseSalary() {

        return baseSalary;
    }

    public void setBaseSalary(
            double baseSalary) {

        if(baseSalary >= 0) {

            this.baseSalary = baseSalary;
        }
    }

    public double calculatePay() {

        return baseSalary;
    }

    public void displayInfo() {

        System.out.println(
                "Employee ID : "
                + employeeId);

        System.out.println(
                "Employee Name : "
                + employeeName);
    }
}
```

---

## Manager Class

```java
class Manager extends Employee {

    private double bonus;

    public Manager(
            int employeeId,
            String employeeName,
            double baseSalary,
            double bonus) {

        super(
                employeeId,
                employeeName,
                baseSalary);

        this.bonus = bonus;
    }

    @Override
    public double calculatePay() {

        return getBaseSalary() + bonus;
    }
}
```

---

## Intern Class

```java
class Intern extends Employee {

    public Intern(
            int employeeId,
            String employeeName,
            double stipend) {

        super(
                employeeId,
                employeeName,
                stipend);
    }

    @Override
    public double calculatePay() {

        return getBaseSalary();
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Manager manager =
                new Manager(
                        101,
                        "Sanjay",
                        80000,
                        15000);

        Intern intern =
                new Intern(
                        201,
                        "Rahul",
                        15000);

        System.out.println(
                "MANAGER DETAILS");

        manager.displayInfo();

        System.out.println(
                "Monthly Salary : "
                + manager.calculatePay());

        System.out.println();

        System.out.println(
                "INTERN DETAILS");

        intern.displayInfo();

        System.out.println(
                "Monthly Salary : "
                + intern.calculatePay());
    }
}
```

---

# Output

```text
MANAGER DETAILS

Employee ID : 101
Employee Name : Sanjay
Monthly Salary : 95000.0

INTERN DETAILS

Employee ID : 201
Employee Name : Rahul
Monthly Salary : 15000.0
```

---

# Step-by-Step Execution

## Step 1

Create Manager

```java
Manager manager =
        new Manager(
                101,
                "Sanjay",
                80000,
                15000);
```

Object:

```text
Manager
----------------

ID = 101

Name = Sanjay

Base Salary = 80000

Bonus = 15000

----------------
```

---

## Step 2

Create Intern

```java
Intern intern =
        new Intern(
                201,
                "Rahul",
                15000);
```

Object:

```text
Intern
----------------

ID = 201

Name = Rahul

Stipend = 15000

----------------
```

---

## Step 3

Manager Salary Calculation

```java
calculatePay()
```

returns:

```text
80000 + 15000
```

Result:

```text
95000
```

---

## Step 4

Intern Salary Calculation

```java
calculatePay()
```

returns:

```text
15000
```

---

# Memory Representation

```text
Manager Object

--------------------------------

employeeId = 101

employeeName = Sanjay

baseSalary = 80000

bonus = 15000

--------------------------------
```

---

```text
Intern Object

--------------------------------

employeeId = 201

employeeName = Rahul

baseSalary = 15000

--------------------------------
```

---

# Where is Encapsulation Used?

```java
private double baseSalary;
```

Protected Data:

```text
Salary
```

Cannot be accessed directly:

```java
manager.baseSalary
```

Not Allowed.

Access only through:

```java
getBaseSalary()

setBaseSalary()
```

---

# Where is Inheritance Used?

```java
class Manager
        extends Employee
```

```java
class Intern
        extends Employee
```

Inherited Members:

```text
Employee ID

Employee Name

Base Salary

displayInfo()
```

---

# Real-World Benefits

## Security

Salary data is protected.

---

## Reusability

Common employee code written once.

---

## Flexibility

New employee types can be added.

Example:

```text
Developer
Tester
HR
TeamLead
```

---

## Maintainability

Changes in Employee class automatically affect all child classes.

---

# Enhanced Version Challenge

Add:

```text
Developer
```

Rule:

```text
Base Salary
+
Project Bonus
```

---

Add:

```text
Sales Executive
```

Rule:

```text
Base Salary
+
Commission
```

---

# Interview Questions

## Why is baseSalary private?

To enforce encapsulation and prevent direct modification.

---

## Why use getters instead of public variables?

To control and validate access.

---

## Why inherit Manager from Employee?

Because:

```text
Manager IS-A Employee
```

---

## What principle is achieved by overriding calculatePay()?

```text
Runtime Polymorphism
```

---

## What relationship exists between Manager and Employee?

```text
IS-A Relationship
```

---

# Concept Map

```text
Encapsulation
      │
      ▼
Private Data
      │
      ▼
Getters / Setters
      │
      ▼
Employee
      │
      ▼
Inheritance
      │
      ├── Manager
      └── Intern
               │
               ▼
       Different Payroll Rules
```

---

# Key Takeaways

- Encapsulation protects sensitive salary information.
- Inheritance removes duplicate code.
- Manager and Intern inherit Employee features.
- Salary calculations differ through method overriding.
- Real-world payroll systems use these exact OOP principles.
- This problem combines Encapsulation, Inheritance, and Polymorphism.

---

# Conclusion

This Corporate Payroll Management System is a practical example of combining Encapsulation and Inheritance. The Employee class protects sensitive data through private fields and controlled access methods, while Manager and Intern classes reuse common functionality and implement their own payroll logic. This design is scalable, maintainable, secure, and closely resembles real-world enterprise software architecture.
