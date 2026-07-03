# Setters in Java

## Introduction

In the previous chapter, we learned about Getter methods.

Getters are used to:

```text
Read Data
```

But what if we want to:

```text
Modify Data
Update Data
Validate Data
```

For that purpose, Java uses:

```text
Setter Methods
```

Setter methods are an important part of:

```text
Encapsulation
```

and help us safely modify private variables.

---

# What is a Setter?

A Setter is a public method used to modify the value of a private variable.

---

# Simple Definition

```text
Setter
   ↓
Used to Write or Update Data
```

---

# Why Do We Need Setters?

Consider:

```java
class Student {

    private String name;

}
```

Main Method:

```java
Student s = new Student();

s.name = "Sanjay";
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

Private variables cannot be modified directly from outside the class.

---

# Solution

Use a Setter Method.

```java
public void setName(String name) {

    this.name = name;

}
```

Now:

```java
student.setName("Sanjay");
```

works correctly.

---

# Syntax of Setter

```java
public void setVariableName(DataType value) {

    this.variableName = value;

}
```

---

# Example

Variable:

```java
private String name;
```

Setter:

```java
public void setName(String name) {

    this.name = name;

}
```

---

# First Setter Program

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

# Visual Representation

```text
Main Class
      │
      ▼

setName("Sanjay")
      │
      ▼

Private Variable

name = Sanjay
```

---

# Understanding this Keyword

Consider:

```java
private String name;
```

Setter:

```java
public void setName(String name) {

    this.name = name;

}
```

---

## What is Happening?

Parameter:

```java
name
```

Object Variable:

```java
this.name
```

Assignment:

```java
this.name = name;
```

Meaning:

```text
Object Variable
       =
Parameter Value
```

---

# Without this Keyword

Wrong:

```java
public void setName(String name) {

    name = name;

}
```

Nothing changes.

Because Java gets confused between:

```text
Parameter name
Object name
```

---

# Correct Version

```java
this.name = name;
```

---

# Example with Multiple Setters

```java
class Student {

    private String name;
    private int age;

    public void setName(String name) {

        this.name = name;

    }

    public void setAge(int age) {

        this.age = age;

    }

    public String getName() {

        return name;

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

        student.setName("Sanjay");
        student.setAge(21);

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

# Why Setters Are Powerful?

The biggest advantage of setters is:

```text
Validation
```

---

# Example Without Validation

```java
student.setAge(-50);
```

Age becomes:

```text
-50
```

Invalid data.

---

# Example With Validation

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

        student.setAge(-50);

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

Age remains unchanged.

---

# Real-World Example

## Bank Account

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

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

## Main Class

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

# Naming Convention

Setter methods usually follow:

```text
set + VariableName
```

Examples:

| Variable | Setter |
|-----------|----------|
| name | setName() |
| age | setAge() |
| salary | setSalary() |
| balance | setBalance() |

---

# Memory Representation

```text
Student Object
-------------------

name = Sanjay
age  = 21

-------------------
```

Modification:

```text
setName()
setAge()
```

Access:

```text
getName()
getAge()
```

---

# Getter vs Setter

| Getter | Setter |
|----------|----------|
| Reads Data | Writes Data |
| Returns Value | Usually void |
| getName() | setName() |
| Used for Access | Used for Modification |

---

# Complete Example

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

    public String getName() {

        return name;

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

## Forgetting this Keyword

Wrong:

```java
name = name;
```

---

Correct:

```java
this.name = name;
```

---

## No Validation

Wrong:

```java
this.age = age;
```

Allows invalid values.

---

Correct:

```java
if(age > 0)
```

---

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

Use setters for modification.

---

# Interview Questions

## What is a Setter?

A method used to modify private variables.

---

## Why Do We Use Setters?

To safely update object data.

---

## What is the Return Type of a Setter?

Usually:

```java
void
```

---

## Why Add Validation in Setters?

To prevent invalid data.

---

## What is the Naming Convention for Setters?

```text
set + VariableName
```

Example:

```java
setName()
setAge()
setSalary()
```

---

# Practice Challenges

## Challenge 1

Create a Student class with:

```text
name
age
```

and implement setters.

---

## Challenge 2

Create a Product class with:

```text
price
quantity
```

and validate values.

---

## Challenge 3

Create an Employee class.

Prevent negative salary values.

---

## Challenge 4

Create a BankAccount class.

Allow deposits only if amount > 0.

---

## Challenge 5

Create a Mobile class.

Validate battery percentage between:

```text
0 - 100
```

---

# Concept Map

```text
Encapsulation
      │
      ▼
Private Variables
      │
      ▼
Setter Methods
      │
      ▼
Modify Data
      │
      ▼
Validation
      │
      ▼
Data Protection
```

---

# Key Takeaways

- Setters are used to modify private variables.
- Setters are part of encapsulation.
- Setters usually return void.
- Validation is commonly added inside setters.
- Setters improve security and maintainability.
- Setter naming convention is setVariableName().

---

# Conclusion

Setter methods provide controlled access for modifying private variables. They are a core component of encapsulation and allow validation, security, and flexibility while maintaining clean object-oriented design. Nearly every Java application uses setters to safely update object data.
