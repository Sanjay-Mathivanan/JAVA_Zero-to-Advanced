# Advanced Composition Program in Java

## Introduction

In the previous chapter, we learned that Composition represents a:

```text
HAS-A Relationship
```

In this chapter, we will build a small college management system using Composition.

The goal is to understand how multiple classes work together to form a larger system.

---

# Problem Statement

Design a system that models the following relationship:

```text
KGISL College
    │
    └── Department
            │
            └── Student
```

Requirements:

1. A College should contain a Department.
2. A Department should contain a Student.
3. The program should display:
   - College Name
   - Department Opening Date
   - Student Roll Number

---

# Understanding the Solution

Before looking at code, let's understand the relationship.

---

## Real-World Structure

```text
KGISL
  │
  ▼
Department (AIDS)
  │
  ▼
Student (Sanjay)
```

---

## Composition Hierarchy

```text
Student
   ▲
   │
Department HAS-A Student
   ▲
   │
KGISL HAS-A Department
```

---

## Object Creation Flow

```text
Create Student
      ↓
Create Department using Student
      ↓
Create KGISL using Department
      ↓
Access Data Through Objects
```

---

# Visual Representation

```text
KGISL Object
--------------------------------

name = kgisl

dept
  │
  ▼

Department Object
--------------------------------

deptName = AIDS
floor = 6

student
   │
   ▼

Student Object
--------------------------------

name = sanjay
rollNo = 23
regNo = 86

--------------------------------
```

---

# Full Solution

## Main Class

```java
package composition;

public class Main {

    public static void main(String[] args) {

        Students student =
                new Students(
                        "sanjay",
                        23,
                        86);

        Dept dep =
                new Dept(
                        "AIDS",
                        6,
                        student);

        Kgisl college =
                new Kgisl(
                        "kgisl",
                        dep);

        System.out.println(
                college.getName());

        college.getDept()
               .OpeningDate();

        System.out.println(
                college.getDept()
                       .getStudents()
                       .getRollno());

    }
}
```

---

## Student Class

```java
package composition;

public class Students {

    private String stdname;
    private int rollno;
    private int regno;

    public Students(
            String stdname,
            int roll,
            int reg) {

        this.stdname = stdname;
        this.rollno = roll;
        this.regno = reg;
    }

    public String getStdname() {
        return stdname;
    }

    public int getRollno() {
        return rollno;
    }

    public int getRegno() {
        return regno;
    }
}
```

---

## Department Class

```java
package composition;

public class Dept {

    private String deptName;
    private int deptFloor;
    private Students std;

    public Dept(
            String deptName,
            int floor,
            Students std) {

        this.deptName = deptName;
        this.deptFloor = floor;
        this.std = std;
    }

    public String getDeptname() {
        return deptName;
    }

    public int getDeptfloor() {
        return deptFloor;
    }

    public Students getStudents() {
        return std;
    }

    public void OpeningDate() {

        System.out.println(
                "The Opening date is 20th JAN");
    }
}
```

---

## KGISL Class

```java
package composition;

public class Kgisl {

    private String name;
    private Dept dept;

    public Kgisl(
            String name,
            Dept dept) {

        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public Dept getDept() {
        return dept;
    }
}
```

---

# Program Output

```text
kgisl
The Opening date is 20th JAN
23
```

---

# Step-by-Step Execution

## Step 1

Create Student Object

```java
Students student =
        new Students(
                "sanjay",
                23,
                86);
```

Object:

```text
Student
----------------
Name   = sanjay
RollNo = 23
RegNo  = 86
----------------
```

---

## Step 2

Create Department Object

```java
Dept dep =
        new Dept(
                "AIDS",
                6,
                student);
```

Object:

```text
Department
----------------
Name  = AIDS
Floor = 6

Contains
 ↓
Student Object
----------------
```

---

## Step 3

Create College Object

```java
Kgisl college =
        new Kgisl(
                "kgisl",
                dep);
```

Object:

```text
College
----------------
Name = kgisl

Contains
 ↓
Department Object
----------------
```

---

# Understanding This Statement

```java
college.getDept()
       .getStudents()
       .getRollno();
```

Many beginners get confused here.

Let's break it down.

---

## Step 1

```java
college.getDept()
```

Returns:

```text
Department Object
```

---

## Step 2

```java
college.getDept()
       .getStudents()
```

Returns:

```text
Student Object
```

---

## Step 3

```java
college.getDept()
       .getStudents()
       .getRollno();
```

Returns:

```text
23
```

---

# Visual Flow

```text
college
   │
   ▼

Department
   │
   ▼

Student
   │
   ▼

Roll Number
```

---

# Memory Representation

```text
College Object
--------------------------------

name = kgisl

dept
 │
 ▼

Department Object
--------------------------------

name = AIDS
floor = 6

student
 │
 ▼

Student Object
--------------------------------

name = sanjay
rollNo = 23
regNo = 86

--------------------------------
```

---

# Why Composition Is Used Here?

Without Composition:

```text
College would store:

Department Name
Department Floor
Student Name
Student RollNo
Student RegNo
```

Everything would be inside one class.

This becomes difficult to manage.

---

With Composition:

```text
Student Class
      ↓
Department Class
      ↓
College Class
```

Responsibilities are separated.

---

# Real-World Analogy

```text
University
    │
    ▼
Department
    │
    ▼
Student
```

A university manages departments.

A department manages students.

This hierarchy naturally follows:

```text
HAS-A Relationship
```

---

# Key Learning

```text
KGISL HAS-A Department

Department HAS-A Student
```

This is Composition.

---

# Interview Questions

## What relationship does Composition represent?

```text
HAS-A Relationship
```

---

## Is KGISL inheriting Department?

```text
No
```

It contains a Department object.

---

## Is Department inheriting Student?

```text
No
```

It contains a Student object.

---

## Why use Composition?

- Better code organization
- Reusability
- Flexibility
- Real-world modeling

---

# Concept Map

```text
Composition
      │
      ▼
HAS-A Relationship
      │
      ▼
KGISL
  │
  ▼
Department
  │
  ▼
Student
```

---

# Key Takeaways

- Composition represents a HAS-A relationship.
- Objects can contain other objects.
- Complex systems are built from smaller classes.
- Composition promotes modular design.
- Real-world software heavily uses Composition.

---

# Conclusion

This program demonstrates Composition using a College → Department → Student hierarchy. Instead of creating one large class, we divide responsibilities among multiple classes and connect them through object references. This approach makes programs more maintainable, reusable, and aligned with real-world design principles.
