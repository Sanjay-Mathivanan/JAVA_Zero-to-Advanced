# Getters in Java

## Introduction

In the previous chapter, we learned about Encapsulation.

One of the main goals of encapsulation is:

```text
Protect Object Data
```

When variables are declared as:

```java
private
```

they cannot be accessed directly from outside the class.

To read private data safely, Java uses:

```text
Getter Methods
```

---

# What is a Getter?

A Getter is a public method used to retrieve (read) the value of a private variable.

---

# Simple Definition

```text
Getter
   ↓
Used to Read Data
```

---

# Why Do We Need Getters?

Consider:

```java
class Student {

    private String name;

}
```

Main Method:

```java
Student s = new Student();

System.out.println(s.name);
```

Output:

```text
Compiler Error
```

Why?

Because:

```java
name
```

is private.

Private variables cannot be accessed outside the class.

---

# Solution

Use a Getter Method.

```java
public String getName() {

    return name;

}
```

Now:

```java
System.out.println(
        student.getName());
```

works correctly.

---

# Syntax of Getter

```java
public DataType getVariableName() {

    return variableName;

}
```

---

# Example

Variable:

```java
private String name;
```

Getter:

```java
public String getName() {

    return name;

}
```

---

# Simple Program

## Student Class

```java
class Student {

    private String name = "Sanjay";

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
student.getName();
```

executes:

```text
Main Method
      │
      ▼

getName()
      │
      ▼

Returns name
      │
      ▼

Output
```

---

# Visual Representation

```text
Main Class
      │
      ▼

Getter Method
      │
      ▼

Private Variable
```

---

# Example with Multiple Variables

```java
class Student {

    private String name = "Sanjay";
    private int age = 21;

    public String getName() {

        return name;

    }

    public int getAge() {

        return age;

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

        System.out.println(
                student.getName());

        System.out.println(
                student.getAge());
    }
}
```

---

# Output

```text
Sanjay
21
```

---

# Real-World Example

## Bank Account

```java
class BankAccount {

    private double balance = 5000;

    public double getBalance() {

        return balance;

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        BankAccount account =
                new BankAccount();

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

# Why Not Make Variables Public?

Wrong:

```java
public double balance;
```

Anyone can access:

```java
account.balance = -1000;
```

This breaks security.

---

Correct:

```java
private double balance;
```

Read using:

```java
getBalance()
```

---

# Naming Convention

Getter methods usually follow:

```text
get + VariableName
```

Examples:

| Variable | Getter |
|-----------|----------|
| name | getName() |
| age | getAge() |
| salary | getSalary() |
| balance | getBalance() |

---

# Boolean Getters

For boolean variables:

```java
private boolean active;
```

Getter:

```java
public boolean isActive() {

    return active;

}
```

---

# Example

```java
class User {

    private boolean active = true;

    public boolean isActive() {

        return active;

    }
}
```

Output:

```text
true
```

---

# Getter Without Setter

Sometimes data should only be read.

Example:

```java
class Employee {

    private int employeeId = 101;

    public int getEmployeeId() {

        return employeeId;

    }
}
```

No setter provided.

This makes the value read-only.

---

# Memory Representation

```text
Student Object
----------------

name = Sanjay
age  = 21

----------------
```

Direct Access:

```text
Not Allowed
```

Access Through:

```text
getName()
getAge()
```

---

# Advantages of Getters

## Data Protection

Private variables remain protected.

---

## Controlled Access

Only selected values are exposed.

---

## Read-Only Support

Can expose data without allowing modification.

---

## Better Encapsulation

Improves security and maintainability.

---

# Common Mistakes

## Returning Wrong Variable

Wrong:

```java
public String getName() {

    return age;

}
```

---

## Forgetting Return Statement

Wrong:

```java
public String getName() {

}
```

Compiler Error.

---

## Direct Variable Access

Wrong:

```java
student.name;
```

if name is private.

Use:

```java
student.getName();
```

---

# Interview Questions

## What is a Getter?

A method used to read private data.

---

## Why Do We Use Getters?

To access private variables safely.

---

## Can a Class Have Only Getters?

Yes.

This creates read-only access.

---

## What is the Naming Convention for Getters?

```text
get + VariableName
```

Example:

```java
getName()
getAge()
getSalary()
```

---

## What is a Boolean Getter Called?

Usually:

```java
isActive()
isAvailable()
isLoggedIn()
```

---

# Practice Challenges

## Challenge 1

Create a Student class with:

```text
name
age
```

and implement getters.

---

## Challenge 2

Create a BankAccount class with:

```text
balance
accountNumber
```

and implement getters.

---

## Challenge 3

Create an Employee class with:

```text
salary
department
```

and implement getters.

---

## Challenge 4

Create a Product class with:

```text
productName
price
```

and implement getters.

---

## Challenge 5

Create a Mobile class with:

```text
brand
model
batteryPercentage
```

and implement getters.

---

# Concept Map

```text
Encapsulation
      │
      ▼
Private Variables
      │
      ▼
Getter Methods
      │
      ▼
Read Data Safely
```

---

# Key Takeaways

- Getters are used to read private variables.
- Getters improve encapsulation.
- Getter methods return data.
- Getter naming convention is getVariableName().
- Boolean getters often use isVariableName().
- Getters help create secure and maintainable code.

---

# Conclusion

Getter methods are an essential part of encapsulation. They provide controlled access to private data while maintaining security and flexibility. Almost every professional Java application uses getters to expose object information safely and consistently.
