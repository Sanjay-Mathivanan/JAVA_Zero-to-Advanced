# Nested Classes in Java

> **Chapter 09 - Advanced Java Class Concepts**

---

# Introduction

As Java applications grow larger, we often need classes that are closely related to another class. Instead of creating separate classes for everything, Java allows us to define a class inside another class.

Such classes are called **Nested Classes**.

Nested classes improve code organization, increase encapsulation, and make programs easier to understand and maintain.

Nested classes are widely used in Java libraries, GUI programming, collections, multithreading, and frameworks like Spring and JavaFX.

---

# Problem Statement

Suppose we are developing software for a **College Management System**.

We have a class called:

```
College
```

Every college has:

- Students
- Departments
- Teachers

The `Student` class is meaningful only inside the `College`.

Instead of creating

```
College.java

Student.java
```

we can write

```
College

    └── Student
```

This makes the code more organized.

---

# Why Do We Need Nested Classes?

Imagine a computer.

```
Computer

├── CPU
├── RAM
├── Motherboard
└── Power Supply
```

The CPU exists only as a part of the computer.

Similarly,

```
Outer Class

├── Inner Class
```

The inner class belongs to the outer class.

---

# Real-World Analogy

Think of a university.

```
University

    │

    ├── Student

    ├── Professor

    └── Department
```

Students belong to the university.

They are closely connected.

Instead of treating them as completely separate entities, we keep them together.

Nested classes work in the same way.

---

# Definition

A **Nested Class** is a class declared inside another class.

The outer class is called the **Outer Class**, and the class declared inside it is called the **Nested Class**.

---

# Syntax

```java
class Outer {

    class Inner {

    }

}
```

---

# Basic Structure

```
Outer Class

+----------------------+
| College              |
|                      |
| +----------------+   |
| | Student        |   |
| +----------------+   |
+----------------------+
```

---

# Types of Nested Classes

Java provides four types of nested classes.

```
Nested Classes

│

├── Member Inner Class

├── Static Nested Class

├── Local Inner Class

└── Anonymous Inner Class
```

We will learn each one in detail in the upcoming chapters.

This chapter focuses on understanding what nested classes are.

---

# Simple Example

```java
class College {

    class Student {

        void display() {

            System.out.println("Student belongs to College");

        }

    }

}

public class Main {

    public static void main(String[] args) {

        College college = new College();

        College.Student student = college.new Student();

        student.display();

    }

}
```

---

# Output

```
Student belongs to College
```

---

# Step-by-Step Explanation

### Step 1

Create the outer class.

```java
class College
```

---

### Step 2

Create the nested class.

```java
class Student
```

---

### Step 3

Create the outer class object.

```java
College college = new College();
```

---

### Step 4

Create the inner class object.

```java
College.Student student = college.new Student();
```

Notice that an inner class object requires an outer class object.

---

### Step 5

Call the method.

```java
student.display();
```

---

# Memory Representation

```
Stack Memory

+--------------------------+
| college                  |
| student                  |
+-------------|------------+
              |
              ▼

Heap Memory

+--------------------------+
| College Object           |
|--------------------------|
| Student Object           |
+--------------------------+
```

---

# Program Flow

```
Start

   │

   ▼

Create College Object

   │

   ▼

Create Student Object

   │

   ▼

Call display()

   │

   ▼

Print Message

   │

   ▼

End
```

---

# Why Does an Inner Class Need an Outer Object?

A member inner class automatically has access to the outer class members.

Example:

```java
class College {

    private String name = "ABC College";

    class Student {

        void showCollege() {

            System.out.println(name);

        }

    }

}
```

Output

```
ABC College
```

The inner class can directly access the outer class's private members.

---

# Internal Working

When the compiler compiles an inner class,

it internally creates something similar to

```
College.class

College$Student.class
```

The `$` symbol indicates that `Student` belongs to `College`.

---

# Accessing Outer Class Members

Example

```java
class Employee {

    private int salary = 50000;

    class Details {

        void show() {

            System.out.println(salary);

        }

    }

}

public class Main {

    public static void main(String[] args) {

        Employee employee = new Employee();

        Employee.Details details = employee.new Details();

        details.show();

    }

}
```

---

# Output

```
50000
```

---

# Advantages of Nested Classes

- Better code organization.
- Improves encapsulation.
- Reduces unnecessary classes.
- Makes related classes stay together.
- Can access private members of the outer class.
- Improves readability.
- Useful in GUI programming and event handling.

---

# Disadvantages

- Can make code harder to understand if overused.
- Slightly more complex object creation.
- Tight coupling with the outer class.

---

# Comparison: Normal Class vs Nested Class

| Feature | Normal Class | Nested Class |
|---------|--------------|--------------|
| Location | Separate | Inside another class |
| Access to Outer Members | No | Yes |
| Requires Outer Object | No | Yes (Member Inner Class) |
| Organization | Independent | Closely related |
| Encapsulation | Normal | Better |

---

# Real-World Uses

Nested classes are commonly used in:

- Swing
- JavaFX
- Android Development
- Event Listeners
- Collections Framework
- Builder Design Pattern
- Iterators
- Framework Development

---

# Common Mistakes

## Mistake 1

Trying to create an inner class directly.

❌ Wrong

```java
Student s = new Student();
```

✔ Correct

```java
College c = new College();
College.Student s = c.new Student();
```

---

## Mistake 2

Thinking nested classes are the same as inheritance.

They are different concepts.

Nested classes represent **containment**, not inheritance.

---

# Best Practices

- Use nested classes only when they are logically related to the outer class.
- Avoid making everything an inner class.
- Keep nested classes small and focused.
- Use meaningful names.
- Prefer static nested classes when access to outer instance members is not required.

---

# Interview Questions

### Beginner

1. What is a nested class?
2. Why do we use nested classes?
3. What is the difference between an outer class and an inner class?
4. Can an inner class access private members of the outer class?
5. How do you create an inner class object?

### Intermediate

6. What are the different types of nested classes?
7. Why does a member inner class require an outer class object?
8. What class files are generated by the compiler for nested classes?
9. What is the difference between a nested class and composition?

### Advanced

10. How are nested classes represented in bytecode?
11. When should you use a static nested class instead of a member inner class?
12. How do nested classes improve encapsulation?

---

# Practice Programs

### Easy

- Create a `Car` class with an inner `Engine` class.
- Create a `School` class with an inner `Student` class.

### Medium

- Create a `Library` class with an inner `Book` class.
- Create a `Company` class with an inner `Employee` class.

### Difficult

- Design a banking application using nested classes.
- Create a shopping cart with nested product classes.

---

# Concept Map

```
Nested Classes

        │

        ├── Member Inner Class

        ├── Static Nested Class

        ├── Local Inner Class

        └── Anonymous Inner Class

                │

                ▼

Better Organization

Better Encapsulation

Cleaner Code
```

---

# Key Takeaways

- A nested class is declared inside another class.
- The outer class contains the nested class.
- Nested classes improve organization and encapsulation.
- A member inner class requires an outer class object.
- Inner classes can access private members of the outer class.
- The Java compiler generates separate `.class` files for nested classes.
- Nested classes are widely used in real-world Java applications.

---

# Conclusion

Nested classes allow developers to group closely related classes together, making code cleaner, more maintainable, and better organized. They provide powerful encapsulation by allowing inner classes to access outer class members directly. Understanding nested classes is the foundation for learning **Member Inner Classes**, **Static Nested Classes**, **Local Inner Classes**, and **Anonymous Inner Classes**, which will be covered in the upcoming chapters.
