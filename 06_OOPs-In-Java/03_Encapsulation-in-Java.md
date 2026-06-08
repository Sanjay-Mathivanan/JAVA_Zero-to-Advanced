# Encapsulation in Java

## Introduction

Encapsulation is one of the four pillars of Object-Oriented Programming (OOP).

The four pillars are:

```text
1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction
```

Encapsulation is the process of:

```text
Binding Data and Methods Together
+
Restricting Direct Access to Data
```

In simple words:

```text
Hide Data
Control Access
```

---

# Real-World Example

Think about an ATM Machine.

You can:

```text
Withdraw Money
Deposit Money
Check Balance
```

But you cannot directly access:

```text
Bank Database
Account Storage
Internal Logic
```

The ATM hides the internal implementation.

This is exactly how Encapsulation works.

---

# Definition

Encapsulation means:

```text
Keeping Variables Private
and
Providing Controlled Access
through Methods
```

---

# Why Do We Need Encapsulation?

Without Encapsulation:

```java
class Student {

    public String name;
    public int age;

}
```

Anyone can modify data.

```java
Student s = new Student();

s.age = -100;
```

Output:

```text
Invalid Data Stored
```

Problem:

```text
No Validation
No Security
No Control
```

---

# Solution: Encapsulation

```java
class Student {

    private String name;
    private int age;

}
```

Now:

```java
Student s = new Student();

s.age = 20;
```

Compiler Error.

Because:

```text
Private Variables
Cannot Be Accessed Directly
```

---

# The Two Rules of Encapsulation

## Rule 1

Make variables:

```java
private
```

---

## Rule 2

Provide:

```java
Getter Methods
Setter Methods
```

---

# What is a Getter?

A getter is used to read data.

Example:

```java
public String getName() {

    return name;

}
```

---

# What is a Setter?

A setter is used to modify data.

Example:

```java
public void setName(String name) {

    this.name = name;

}
```

---

# Simple Example

## Student Class

```java
class Student {

    private String name;

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

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

When:

```java
student.setName("Sanjay");
```

executes:

```text
Parameter
     ↓
Setter Method
     ↓
Private Variable Updated
```

---

When:

```java
student.getName();
```

executes:

```text
Private Variable
      ↓
Getter Method
      ↓
Returned to Caller
```

---

# Visual Representation

```text
Main Class
    │
    ▼

Getter / Setter
    │
    ▼

Private Variables
```

---

# Example with Validation

One major advantage of Encapsulation is validation.

---

## Without Validation

```java
student.age = -10;
```

Invalid value accepted.

---

## With Validation

```java
class Student {

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

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student student =
                new Student();

        student.setAge(-10);

        System.out.println(
                student.getAge());
    }
}
```

---

# Output

```text
0
```

Age is not updated.

---

# Real-World Example

## Bank Account

```java
class BankAccount {

    private double balance;

    public void deposit(
            double amount) {

        if(amount > 0) {

            balance += amount;

        }
    }

    public double getBalance() {

        return balance;

    }
}
```

---

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount();

        account.deposit(5000);

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

# Why Not Make Everything Public?

Bad Design:

```java
class BankAccount {

    public double balance;

}
```

Anyone can do:

```java
account.balance = -100000;
```

This breaks the program.

---

Encapsulation prevents such issues.

---

# Memory Representation

```text
Student Object
--------------------

name = Sanjay
age  = 21

--------------------
```

Direct access:

```text
Not Allowed
```

Access only through:

```text
Getter
Setter
```

---

# Encapsulation Flow

```text
User
  │
  ▼

Setter Method
  │
  ▼

Private Data
  │
  ▼

Getter Method
  │
  ▼

User
```

---

# Advantages of Encapsulation

## Data Security

Variables cannot be modified directly.

---

## Better Validation

Invalid values can be prevented.

---

## Flexibility

Implementation can change without affecting users.

---

## Maintainability

Code becomes easier to manage.

---

## Reusability

Classes become safer to reuse.

---

# Complete Example

```java
class Employee {

    private String name;
    private double salary;

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setSalary(
            double salary) {

        if(salary > 0) {

            this.salary = salary;

        }
    }

    public double getSalary() {

        return salary;

    }
}

public class Main {

    public static void main(String[] args) {

        Employee emp =
                new Employee();

        emp.setName("Sanjay");

        emp.setSalary(50000);

        System.out.println(
                emp.getName());

        System.out.println(
                emp.getSalary());
    }
}
```

---

# Output

```text
Sanjay
50000.0
```

---

# Common Mistakes

## Making Variables Public

Wrong:

```java
public int age;
```

---

Correct:

```java
private int age;
```

---

## No Validation in Setter

Wrong:

```java
public void setAge(int age) {

    this.age = age;

}
```

Allows:

```java
-10
```

---

Correct:

```java
if(age > 0)
```

---

## Getter Returning Wrong Variable

Always verify returned data.

---

# Interview Questions

## What is Encapsulation?

Binding data and methods together while restricting direct access.

---

## How is Encapsulation Achieved?

Using:

```java
private
```

variables and:

```java
Getter / Setter Methods
```

---

## What are Getters?

Methods used to read private data.

---

## What are Setters?

Methods used to modify private data.

---

## Why is Encapsulation Important?

- Security
- Validation
- Maintainability

---

# Practice Challenges

## Challenge 1

Create a Student class with:

```text
name
age
```

Use encapsulation.

---

## Challenge 2

Create a BankAccount class.

Validate deposit amount.

---

## Challenge 3

Create an Employee class.

Prevent negative salary values.

---

## Challenge 4

Create a Product class.

Validate product price.

---

## Challenge 5

Create a Mobile class.

Protect all fields using encapsulation.

---

# Concept Map

```text
Encapsulation
      │
      ▼
Private Variables
      │
      ├── Getter
      │
      └── Setter
               │
               ▼
        Validation
               │
               ▼
         Data Security
```

---

# Key Takeaways

- Encapsulation hides data.
- Variables should be private.
- Getters read data.
- Setters modify data.
- Validation can be added inside setters.
- Encapsulation improves security and maintainability.
- It is one of the four pillars of OOP.

---

# Conclusion

Encapsulation is the practice of protecting object data by restricting direct access and providing controlled access through methods. It improves security, validation, maintainability, and code quality. Nearly every professional Java application uses encapsulation extensively, making it one of the most important OOP concepts to master.
