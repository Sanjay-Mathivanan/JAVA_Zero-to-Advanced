# Constructors in Java

## Introduction

In the previous chapters, we learned:

- Classes
- Objects
- Getters and Setters

When an object is created, Java automatically initializes its variables with default values.

Example:

```java
Student student = new Student();
```

After creation:

```text
name = null
age = 0
salary = 0.0
```

However, in real-world applications we usually want objects to start with meaningful values immediately.

Java provides:

```java
Constructors
```

for this purpose.

---

# What is a Constructor?

## Definition

A constructor is a special method that is automatically executed when an object is created.

Its primary purpose is:

```text
Initialize Object State
```

---

# Real-World Analogy

Imagine buying a new mobile phone.

Without initialization:

```text
Phone Created
Model = null
RAM = 0
Color = null
```

Not useful.

With initialization:

```text
Phone Created
Model = Nord
RAM = 12GB
Color = Black
```

A constructor performs this setup automatically.

---

# Why Do We Need Constructors?

Without Constructors:

```java
Student student = new Student();

student.setName("Sanjay");
student.setAge(21);
```

With Constructors:

```java
Student student =
        new Student("Sanjay", 21);
```

Cleaner and more efficient.

---

# Constructor Characteristics

A constructor:

- Has the same name as the class
- Has no return type
- Executes automatically
- Can accept parameters
- Can be overloaded

---

# Constructor Syntax

```java
public ClassName() {

}
```

Example:

```java
public class Student {

    public Student() {

        System.out.println(
                "Constructor Called");

    }
}
```

---

# First Constructor Example

```java
public class Student {

    public Student() {

        System.out.println(
                "Student Object Created");

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

    }
}
```

---

# Output

```text
Student Object Created
```

---

# Internal Working

Object Creation:

```java
new Student();
```

Steps:

```text
Allocate Memory
       ↓
Call Constructor
       ↓
Initialize Object
       ↓
Return Reference
```

---

# Memory Representation

```java
Student student =
        new Student();
```

Stack:

```text
student
   │
   ▼
```

Heap:

```text
Student Object
```

Constructor executes immediately after memory allocation.

---

# Default Constructor

If no constructor is written, Java automatically provides one.

Example:

```java
public class Student {

}
```

Java creates:

```java
public Student() {

}
```

behind the scenes.

This is called:

```text
Default Constructor
```

---

# Example

```java
public class Student {

    String name;
    int age;

}
```

Main:

```java
Student student =
        new Student();

System.out.println(student.name);
System.out.println(student.age);
```

Output:

```text
null
0
```

---

# No-Argument Constructor

A constructor without parameters.

Example:

```java
public class Student {

    String name;

    public Student() {

        name = "Unknown";

    }
}
```

---

# Main Program

```java
Student student =
        new Student();

System.out.println(student.name);
```

Output:

```text
Unknown
```

---

# Parameterized Constructor

A constructor that accepts values during object creation.

---

# Example

```java
public class Student {

    String name;
    int age;

    public Student(
            String name,
            int age) {

        this.name = name;
        this.age = age;

    }
}
```

---

# Main Program

```java
Student student =
        new Student(
                "Sanjay",
                21);

System.out.println(
        student.name);

System.out.println(
        student.age);
```

---

# Output

```text
Sanjay
21
```

---

# Understanding this Keyword

Constructor:

```java
public Student(
        String name,
        int age) {

    this.name = name;
    this.age = age;

}
```

Left Side:

```java
this.name
```

Instance Variable

Right Side:

```java
name
```

Parameter

Assignment:

```text
Parameter Value
       ↓
Instance Variable
```

---

# Constructor Execution Flow

```text
new Student(
    "Sanjay",
    21)
        ↓
Constructor Called
        ↓
name = Sanjay
age = 21
        ↓
Object Ready
```

---

# Example Using Mobile Class

```java
public class Mobile {

    private String model;
    private int ram;

    public Mobile(
            String model,
            int ram) {

        this.model = model;
        this.ram = ram;

    }

    public String getModel() {

        return model;

    }
}
```

---

# Main Program

```java
public class Main {

    public static void main(String[] args) {

        Mobile phone =
                new Mobile(
                        "Nord",
                        12);

        System.out.println(
                phone.getModel());

    }
}
```

---

# Output

```text
Nord
```

---

# Constructor Overloading

A class can contain multiple constructors.

Example:

```java
public class Student {

    String name;
    int age;

    public Student() {

        name = "Unknown";
        age = 0;

    }

    public Student(
            String name,
            int age) {

        this.name = name;
        this.age = age;

    }
}
```

---

# Main Program

```java
Student s1 =
        new Student();

Student s2 =
        new Student(
                "Sanjay",
                21);
```

Output:

```text
s1 → Unknown, 0

s2 → Sanjay, 21
```

---

# Constructor vs Method

| Constructor | Method |
|------------|---------|
| Same name as class | Any valid name |
| No return type | Must have return type |
| Executes automatically | Called explicitly |
| Initializes objects | Performs operations |

---

# Common Mistakes

## Adding Return Type

Wrong:

```java
public void Student() {

}
```

This becomes a method, not a constructor.

---

## Different Name

Wrong:

```java
public student() {

}
```

Class name:

```java
Student
```

Must match exactly.

---

## Forgetting this Keyword

Wrong:

```java
name = name;
```

No assignment occurs.

Correct:

```java
this.name = name;
```

---

# Real-World Applications

Constructors are used in:

- Banking Systems
- Student Management Systems
- E-Commerce Applications
- Mobile Apps
- Enterprise Software

Whenever objects need initial values.

---

# Concept Map

```text
Class
  │
  ▼
Constructor
  │
  ├── Default Constructor
  │
  ├── No-Argument Constructor
  │
  ├── Parameterized Constructor
  │
  └── Constructor Overloading
```

---

# Interview Questions

## What is a constructor?

A special method used to initialize objects.

---

## Does a constructor have a return type?

No.

---

## When is a constructor executed?

Automatically when an object is created.

---

## Can constructors be overloaded?

Yes.

---

## What is a default constructor?

A constructor automatically provided by Java when no constructor is defined.

---

## Difference between constructor and method?

Constructors initialize objects and execute automatically, whereas methods perform operations and must be called explicitly.

---

# Practice Challenges

## Challenge 1

Create a Car class with:

```java
brand
model
price
```

Initialize using a constructor.

---

## Challenge 2

Create an Employee class with:

```java
name
salary
department
```

using a parameterized constructor.

---

## Challenge 3

Create a BankAccount class with constructor overloading.

---

## Challenge 4

Create a Laptop class and initialize all properties through a constructor.

---

# Key Takeaways

- Constructors initialize objects.
- Constructor name must match class name.
- Constructors have no return type.
- Constructors execute automatically.
- Parameterized constructors allow custom initialization.
- Constructor overloading provides flexibility.
- Constructors are fundamental to Object-Oriented Programming.

---

# Conclusion

Constructors are one of the most important building blocks of Java's Object-Oriented Programming model. They ensure that objects are properly initialized at the moment of creation. Understanding constructors, parameterized constructors, and constructor overloading is essential before moving to advanced topics such as inheritance, polymorphism, and object lifecycle management.
