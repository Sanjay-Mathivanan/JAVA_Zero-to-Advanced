# Getters and Setters in Java

## Introduction

In the previous chapter, we learned that class variables are often declared using the:

```java
private
```

access modifier.

Example:

```java
private String model;
```

Since private variables cannot be accessed directly outside the class, Java provides special methods called:

- Getters
- Setters

These methods allow controlled access to private data while maintaining security and validation.

---

# Why Do We Need Getters and Setters?

Consider the following class:

```java
public class Student {

    private String name;

}
```

Now suppose we create an object:

```java
Student student = new Student();
```

Trying to access the variable directly:

```java
student.name = "Sanjay";
```

Produces:

```text
Compilation Error
```

Because:

```java
name
```

is private.

---

# The Problem

Without getters and setters:

```text
Outside classes cannot access private variables.
```

This is intentional because:

```text
Data must be protected.
```

---

# Solution

Use:

```text
Setter
```

to store data.

Use:

```text
Getter
```

to retrieve data.

---

# What is a Setter?

## Definition

A setter is a method used to assign or update the value of a private variable.

---

# Setter Syntax

```java
public void setVariableName(DataType value) {

    this.variableName = value;

}
```

Example:

```java
public void setName(String name) {

    this.name = name;

}
```

---

# What is a Getter?

## Definition

A getter is a method used to retrieve the value of a private variable.

---

# Getter Syntax

```java
public DataType getVariableName() {

    return variableName;

}
```

Example:

```java
public String getName() {

    return name;

}
```

---

# Real-World Analogy

Think of a bank account.

```text
Bank Account Balance
        ↓
Private Information
```

You cannot directly modify the balance.

Instead:

```text
Deposit Money
Withdraw Money
Check Balance
```

These operations act like:

```text
Setters
Getters
```

providing controlled access.

---

# Basic Example

## Student Class

```java
public class Student {

    private String name;

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }
}
```

---

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student = new Student();

        student.setName("Sanjay");

        System.out.println(
                student.getName());

    }
}
```

---

# Output

```text
Sanjay
```

---

# Internal Working

### Step 1

Object Creation

```java
Student student =
        new Student();
```

Memory:

```text
Heap
------------
name = null
------------
```

---

### Step 2

Setter Called

```java
student.setName("Sanjay");
```

Assignment:

```java
this.name = "Sanjay";
```

Memory:

```text
Heap
------------
name = Sanjay
------------
```

---

### Step 3

Getter Called

```java
student.getName();
```

Returns:

```text
Sanjay
```

---

# Understanding the this Keyword

Consider:

```java
public void setName(String name) {

    this.name = name;

}
```

There are two variables:

### Method Parameter

```java
name
```

### Instance Variable

```java
this.name
```

Visualization:

```text
Parameter
---------
name = Sanjay

Instance Variable
-----------------
this.name = null
```

After assignment:

```text
this.name = Sanjay
```

---

# Memory Representation

Before Setter:

```text
Stack
-----------------
name = Sanjay
-----------------

Heap
-----------------
name = null
-----------------
```

After Setter:

```text
Heap
-----------------
name = Sanjay
-----------------
```

---

# Example: Student Age Validation

Without validation:

```java
student.setAge(-10);
```

Invalid data enters the system.

---

# Using Validation in Setter

```java
public class Student {

    private int age;

    public void setAge(int age) {

        if(age > 0) {

            this.age = age;

        }
    }

    public int getAge() {

        return age;

    }
}
```

---

# Main Program

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

        student.setAge(21);

        System.out.println(
                student.getAge());

    }
}
```

---

# Output

```text
21
```

---

# Why Validation is Important

Suppose:

```java
student.setAge(-50);
```

Without validation:

```text
Invalid Data Stored
```

With validation:

```text
Invalid Data Rejected
```

---

# Cellphone Example

## Class

```java
public class Cellphone {

    private String model;

    public void setModel(String model) {

        String validModel =
                model.toLowerCase();

        if(validModel.equals("nord")
           || validModel.equals("7pro")) {

            this.model = model;

        } else {

            this.model = "unknown";

        }
    }

    public String getModel() {

        return this.model;

    }
}
```

---

# Main Program

```java
public class Main {

    public static void main(String[] args) {

        Cellphone phone =
                new Cellphone();

        phone.setModel("8max");

        System.out.println(
                phone.getModel());

    }
}
```

---

# Output

```text
unknown
```

---

# Why Output is Unknown?

Input:

```java
8max
```

Validation:

```java
equals("nord")
```

False.

```java
equals("7pro")
```

False.

Stored:

```java
unknown
```

---

# Valid Input Example

```java
phone.setModel("Nord");
```

Output:

```text
Nord
```

---

# Advanced Example

## Bank Account Class

```java
public class BankAccount {

    private double balance;

    public void setBalance(double balance) {

        if(balance >= 0) {

            this.balance = balance;

        }
    }

    public double getBalance() {

        return balance;

    }
}
```

---

# Main Program

```java
public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount();

        account.setBalance(5000);

        System.out.println(
                account.getBalance());

    }
}
```

---

# Output

```text
5000.0
```

---

# Benefits of Getters and Setters

## Data Protection

```text
Private Variables
```

cannot be accessed directly.

---

## Validation

Invalid data can be prevented.

---

## Better Maintenance

Internal implementation can change without affecting other classes.

---

## Encapsulation

Supports Object-Oriented Programming principles.

---

# Getter vs Setter

| Getter | Setter |
|----------|----------|
| Retrieves Data | Updates Data |
| Returns Value | Usually Returns Nothing |
| Starts with get | Starts with set |
| Read Operation | Write Operation |

---

# Common Mistakes

## Forgetting this Keyword

Wrong:

```java
name = name;
```

No assignment happens.

Correct:

```java
this.name = name;
```

---

## Direct Variable Access

Wrong:

```java
student.name = "Sanjay";
```

Correct:

```java
student.setName("Sanjay");
```

---

## No Validation

Wrong:

```java
this.age = age;
```

May store invalid values.

---

# Concept Map

```text
Class
 │
 ├── Private Variables
 │
 ├── Getter
 │      ↓
 │   Retrieve Data
 │
 └── Setter
        ↓
     Update Data
```

---

# Interview Questions

## What is a getter?

A method used to retrieve the value of a private variable.

---

## What is a setter?

A method used to update the value of a private variable.

---

## Why use private variables?

To protect data from direct access.

---

## What is encapsulation?

Binding data and methods together while restricting direct access.

---

## Why use validation inside setters?

To prevent invalid data from entering the system.

---

# Practice Challenges

## Challenge 1

Create a Car class with:

```java
model
color
```

and getters/setters.

---

## Challenge 2

Create an Employee class with:

```java
name
salary
```

Add salary validation.

---

## Challenge 3

Create a BankAccount class that prevents negative balances.

---

## Challenge 4

Create a Laptop class with:

```java
brand
ram
processor
```

and getters/setters.

---

# Key Takeaways

- Getters retrieve private data.
- Setters update private data.
- Private variables improve security.
- Setters can validate input.
- Getters and setters support encapsulation.
- They are fundamental to Object-Oriented Programming.

---

# Conclusion

Getters and setters provide controlled access to private variables and are one of the most widely used features in Java. They help protect data, enforce validation, and support encapsulation. Mastering getters and setters is essential before learning constructors, inheritance, and advanced OOP concepts.
