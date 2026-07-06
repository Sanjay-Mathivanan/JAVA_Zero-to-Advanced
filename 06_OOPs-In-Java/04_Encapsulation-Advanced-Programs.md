# Advanced Encapsulation Practice Challenges

## Introduction

In real-world applications, encapsulation goes far beyond simply adding boilerplate getter and setter methods. It serves as the primary barrier against corrupted data states and enforces core business rules during runtime.

This chapter features five advanced coding challenges that simulate real-world scenarios in banking transactions, academic scoring, payroll calculations, inventory tracking, and hardware state monitoring.

---

## Challenge 1: Bank Account Management System

### Problem Statement
Create a `BankAccount` class with private fields `accountHolder` (String) and `balance` (double).
* Implement a constructor that only accepts initial balances $\ge 0$.
* Expose getters for both fields.
* Implement a `deposit(double amount)` method that increases the balance only if the deposit amount is positive.

### Solution
```java
class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Warning: Initial balance cannot be negative. Defaulting to 0.0");
            this.balance = 0.0;
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Error: Deposit amount must be positive.");
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
        BankAccount account = new BankAccount("Sanjay", 5000);
        account.deposit(2000);

        System.out.println("Holder Name: " + account.getAccountHolder());
        System.out.println("Current Balance: " + account.getBalance());
    }
}
```

### Output:
```text
Holder Name: Sanjay
Current Balance: 7000.0
```

---

## Challenge 2: Student Result System

### Problem Statement
Create a `Student` class with private fields `name` (String) and `marks` (int).
* Enforce validation in `setMarks(int)` so that marks can only range from `0` to `100`.
* Implement a `getGrade()` method returning:
  * `"A"` for marks $\ge 90$
  * `"B"` for marks $\ge 75$
  * `"C"` for marks $\ge 50$
  * `"F"` otherwise.

### Solution
```java
class Student {
    private String name;
    private int marks;

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(int marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Error: Marks must be between 0 and 100.");
        }
    }

    public String getGrade() {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 50) return "C";
        return "F";
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Sanjay");
        student.setMarks(88);

        System.out.println("Grade: " + student.getGrade());
    }
}
```

### Output:
```text
Grade: B
```

---

## Challenge 3: Employee Salary System

### Problem Statement
Create an `Employee` class with private fields `name` (String) and `monthlySalary` (double).
* Implement `setSalary(double)` to reject negative numbers.
* Implement a public getter `getAnnualSalary()` that returns the monthly salary multiplied by 12.

### Solution
```java
class Employee {
    private String name;
    private double monthlySalary;

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double monthlySalary) {
        if (monthlySalary >= 0) {
            this.monthlySalary = monthlySalary;
        } else {
            System.out.println("Error: Monthly salary cannot be negative.");
        }
    }

    public double getAnnualSalary() {
        return monthlySalary * 12;
    }
}

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Sanjay");
        emp.setSalary(50000);

        System.out.println("Annual Salary: " + emp.getAnnualSalary());
    }
}
```

### Output:
```text
Annual Salary: 600000.0
```

---

## Challenge 4: Product Inventory System

### Problem Statement
Create a `Product` class containing private fields `productName`, `price`, and `quantity`.
* Enforce validation so that neither `price` nor `quantity` can be set to negative values.
* Implement a method `inventoryValue()` calculating the total value: $\text{Price} \times \text{Quantity}$.

### Solution
```java
class Product {
    private String productName;
    private double price;
    private int quantity;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        } else {
            System.out.println("Error: Quantity cannot be negative.");
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

        System.out.println("Inventory Value: " + p.inventoryValue());
    }
}
```

### Output:
```text
Inventory Value: 600000.0
```

---

## Challenge 5: Mobile Phone Management System

### Problem Statement
Create a `Mobile` class with private fields `brand`, `model`, and `batteryPercentage`.
* Ensure `batteryPercentage` can only be set within the range `0` to `100`.
* Implement a `display()` method printing the phone details.

### Solution
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

    public void setBatteryPercentage(int batteryPercentage) {
        if (batteryPercentage >= 0 && batteryPercentage <= 100) {
            this.batteryPercentage = batteryPercentage;
        } else {
            System.out.println("Error: Battery percentage must be between 0 and 100.");
        }
    }

    public void display() {
        System.out.println("Brand   : " + brand);
        System.out.println("Model   : " + model);
        System.out.println("Battery : " + batteryPercentage + "%");
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

### Output:
```text
Brand   : Samsung
Model   : S25 Ultra
Battery : 85%
```

---

## Real-World Applications

Encapsulation forms the security layer of professional software architectures:
* **Banking Systems**: Restricting direct adjustments to bank balances.
* **Health Registers**: Validating medical parameters (e.g. blood pressure, age bounds).
* **E-Commerce Checkouts**: Capping quantities, preventing negative checkouts, and securing payment credentials.

---

## Interview Questions (FAQ)

### Why use constructor validation if we have setters?
Having validation in constructors ensures that objects are instantiated correctly from the beginning, rather than created in an invalid state and corrected later.

### Can setters call other private class methods?
Yes. Complex validation checks or logging rules can be factored out into private helper methods and called inside setter methods.

### Can a getter return an unmodifiable version of data?
Yes, for mutable types (like lists, maps, or user-defined objects), it is a best practice to return an unmodifiable view or a clone to prevent external users from mutating fields directly.

---

## Key Takeaways

* Setters serve as gatekeepers, enforcing parameter validation rules.
* Restricting direct access ensures that class invariants (rules like no negative price or marks $> 100$) are always maintained.
* Encapsulation separates what a class does (public API) from how it holds its internal data (private representation).

---

**Back to Module Home:** [Object-Oriented Programming](README.md)
