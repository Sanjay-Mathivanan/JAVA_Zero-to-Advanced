# Advanced Encapsulation Programs in Java

## Introduction

In the previous chapter, we learned:

- What is Encapsulation
- Private Variables
- Getters
- Setters
- Data Hiding

In this chapter, we will build real-world programs using Encapsulation.

These examples demonstrate:

```text
Data Protection
Validation
Controlled Access
Real-World Modeling
```

---

# Problem 1: Bank Account Management System

## Problem Statement

Create a Bank Account class.

Requirements:

- Account Holder Name
- Account Balance
- Balance cannot be negative
- Allow deposits
- Display account details

---

## Solution

```java
class BankAccount {

    private String accountHolder;
    private double balance;

    public BankAccount(
            String accountHolder,
            double balance) {

        this.accountHolder = accountHolder;

        if(balance >= 0) {
            this.balance = balance;
        }
    }

    public void deposit(double amount) {

        if(amount > 0) {
            balance += amount;
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}

public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount(
                        "Sanjay",
                        5000);

        account.deposit(2000);

        System.out.println(
                account.getAccountHolder());

        System.out.println(
                account.getBalance());
    }
}
```

---

## Output

```text
Sanjay
7000.0
```

---

# Problem 2: Student Result System

## Problem Statement

Create a Student class.

Requirements:

- Student Name
- Marks
- Marks must be between 0 and 100
- Display Grade

---

## Solution

```java
class Student {

    private String name;
    private int marks;

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {

        if(marks >= 0 && marks <= 100) {
            this.marks = marks;
        }
    }

    public String getGrade() {

        if(marks >= 90)
            return "A";

        if(marks >= 75)
            return "B";

        if(marks >= 50)
            return "C";

        return "F";
    }
}

public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Sanjay");
        student.setMarks(88);

        System.out.println(
                student.getGrade());
    }
}
```

---

## Output

```text
B
```

---

# Problem 3: Employee Salary System

## Problem Statement

Create an Employee class.

Requirements:

- Employee Name
- Salary
- Salary cannot be negative
- Display Annual Salary

---

## Solution

```java
class Employee {

    private String name;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {

        if(salary > 0) {
            this.salary = salary;
        }
    }

    public double getAnnualSalary() {

        return salary * 12;
    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp = new Employee();

        emp.setName("Sanjay");
        emp.setSalary(50000);

        System.out.println(
                emp.getAnnualSalary());
    }
}
```

---

## Output

```text
600000.0
```

---

# Problem 4: Product Inventory System

## Problem Statement

Create a Product class.

Requirements:

- Product Name
- Product Price
- Product Quantity
- Price and Quantity cannot be negative
- Calculate Inventory Value

Formula:

```text
Inventory Value = Price × Quantity
```

---

## Solution

```java
class Product {

    private String productName;
    private double price;
    private int quantity;

    public void setProductName(
            String productName) {

        this.productName = productName;
    }

    public void setPrice(double price) {

        if(price > 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {

        if(quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public double inventoryValue() {

        return price * quantity;
    }
}

public class Main {

    public static void main(String[] args) {

        Product p = new Product();

        p.setProductName("Laptop");
        p.setPrice(60000);
        p.setQuantity(10);

        System.out.println(
                p.inventoryValue());
    }
}
```

---

## Output

```text
600000.0
```

---

# Problem 5: Mobile Phone Management System

## Problem Statement

Create a Mobile class.

Requirements:

- Brand
- Model
- Battery Percentage
- Battery must be between 0 and 100
- Display Mobile Information

---

## Solution

```java
class Mobile {

    private String brand;
    private String model;
    private int batteryPercentage;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBatteryPercentage(
            int batteryPercentage) {

        if(batteryPercentage >= 0 &&
           batteryPercentage <= 100) {

            this.batteryPercentage =
                    batteryPercentage;
        }
    }

    public void display() {

        System.out.println(
                "Brand : " + brand);

        System.out.println(
                "Model : " + model);

        System.out.println(
                "Battery : "
                + batteryPercentage + "%");
    }
}

public class Main {

    public static void main(String[] args) {

        Mobile mobile = new Mobile();

        mobile.setBrand("Samsung");
        mobile.setModel("S25 Ultra");
        mobile.setBatteryPercentage(85);

        mobile.display();
    }
}
```

---

## Output

```text
Brand : Samsung
Model : S25 Ultra
Battery : 85%
```

---

# What We Learned

## Encapsulation Features Used

```text
Private Variables
Getter Methods
Setter Methods
Validation
Data Hiding
Controlled Access
```

---

# Real-World Applications

```text
Banking Software
Hospital Management Systems
College Management Systems
E-Commerce Applications
Mobile Applications
ERP Systems
```

All of them heavily use Encapsulation.

---

# Interview Questions

## Why make variables private?

To protect data from direct modification.

---

## Where should validation be written?

Inside setter methods.

---

## Can encapsulation prevent invalid data?

Yes.

Example:

```java
salary < 0
marks > 100
battery > 100
```

can all be prevented.

---

## Is Encapsulation only about getters and setters?

No.

It is about:

```text
Data Hiding
+
Controlled Access
```

Getters and Setters are one way to achieve it.

---

# Key Takeaways

- Encapsulation protects object data.
- Variables should usually be private.
- Validation should be performed inside setters.
- Getters provide controlled reading.
- Setters provide controlled writing.
- Encapsulation improves security and maintainability.

---

# Conclusion

These advanced encapsulation programs demonstrate how private variables, getters, setters, and validation work together to create safe and reliable software. Encapsulation is one of the most widely used OOP concepts in professional Java development and forms the foundation for secure and maintainable applications.
