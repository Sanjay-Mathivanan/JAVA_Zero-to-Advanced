# Classes and Objects in Java

## Introduction

Everything in the real world can be represented using:

```text
Objects
```

Examples:

```text
Car
Mobile Phone
Student
Employee
Laptop
Bank Account
```

Each object has:

```text
Properties (Data)
+
Behaviors (Actions)
```

Example:

```text
Mobile Phone

Properties
-----------
Model
Color
RAM
Processor

Behaviors
-----------
Call
Message
Play Music
Take Photo
```

Java uses:

```text
Class
```

to create such objects.

Classes are the foundation of Object-Oriented Programming (OOP).

---

# What is a Class?

## Definition

A class is a blueprint or template used to create objects.

Think of a class as a design plan.

---

# Real-World Analogy

### House Blueprint

```text
Blueprint
    ↓
Many Houses
```

A blueprint describes:

```text
Rooms
Doors
Windows
Kitchen
```

but it is not an actual house.

Similarly:

```text
Class
```

describes an object but is not the object itself.

---

# What is an Object?

## Definition

An object is an instance of a class.

Example:

```text
Class
-----
Cellphone

Objects
--------
OnePlus
Apple
Samsung
```

---

# Class and Object Relationship

```text
Class
  ↓
Creates
  ↓
Objects
```

Example:

```java
Cellphone phone1 = new Cellphone();

Cellphone phone2 = new Cellphone();
```

Here:

```text
Cellphone
```

is the class.

```text
phone1
phone2
```

are objects.

---

# Why Classes Are Needed

Without classes:

```text
Data becomes difficult to organize.
```

Example:

```java
String model;
String color;
int ram;
String processor;
```

Managing many phones becomes difficult.

Using classes:

```java
Cellphone phone1;
Cellphone phone2;
Cellphone phone3;
```

Everything remains organized.

---

# Basic Class Syntax

```java
public class ClassName {

    // Variables

    // Methods

}
```

Example:

```java
public class Student {

    String name;
    int age;

}
```

---

# Understanding the Cellphone Class

```java
public class Cellphone {

    private int ram;
    private int noOfCameras;
    private String model;
    private String colour;
    private String processor;

}
```

---

# Instance Variables

These variables belong to every object.

```java
private int ram;

private String model;
```

Every phone object gets its own copy.

---

# Memory Representation

Object Creation:

```java
Cellphone onePlus =
        new Cellphone();
```

Memory:

```text
Stack Memory
--------------------
onePlus
     │
     ▼
Heap Memory
--------------------
ram = 0
model = null
colour = null
processor = null
--------------------
```

---

# What Does new Mean?

```java
new Cellphone()
```

Creates an object in:

```text
Heap Memory
```

and returns its reference.

---

# Creating Objects

```java
Cellphone onePlus =
        new Cellphone();

Cellphone apple =
        new Cellphone();
```

Memory:

```text
Heap

Object 1
---------
OnePlus

Object 2
---------
Apple
```

Each object has separate data.

---

# Encapsulation

Notice:

```java
private String model;
```

The keyword:

```java
private
```

means:

```text
Accessible only inside the class
```

Outside classes cannot access it directly.

Wrong:

```java
onePlus.model = "Nord";
```

Compiler Error.

---

# Why Private Variables?

To protect data.

Example:

Without validation:

```java
model = "xyz123";
```

Any value can be stored.

Using private variables and methods:

```java
Validation becomes possible.
```

---

# Setter Method

A setter updates data.

Example:

```java
public void setModel(String model)
```

Purpose:

```text
Store model safely
```

---

# Setter Implementation

```java
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
```

---

# Understanding this Keyword

```java
this.model = model;
```

Left Side:

```java
this.model
```

Class variable.

Right Side:

```java
model
```

Method parameter.

---

# Visualization

```text
Parameter
---------
model = nord

Class Variable
--------------
this.model
```

Assignment:

```text
this.model = model
```

---

# Getter Method

A getter retrieves data.

Example:

```java
public String getModel() {

    return this.model;

}
```

Purpose:

```text
Read model safely
```

---

# Complete Cellphone Class

```java
public class Cellphone {

    private int ram;
    private int noOfCameras;
    private String model;
    private String colour;
    private String processor;

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

# Main Class

```java
public class Main {

    public static void main(String[] args) {

        Cellphone onePlus =
                new Cellphone();

        Cellphone apple =
                new Cellphone();

        onePlus.setModel("8max");

        System.out.println(
                "The phone model is "
                + onePlus.getModel());
    }
}
```

---

# Program Execution

## Step 1

Create Object

```java
Cellphone onePlus =
        new Cellphone();
```

---

## Step 2

Call Setter

```java
onePlus.setModel("8max");
```

---

## Step 3

Validation

```java
8max
```

Converted:

```java
8max
```

Check:

```java
equals("nord")
```

False.

Check:

```java
equals("7pro")
```

False.

---

## Step 4

Store:

```java
this.model = "unknown";
```

---

## Step 5

Getter Called

```java
onePlus.getModel();
```

Returns:

```java
unknown
```

---

# Output

```text
The phone model is unknown
```

---

# Valid Input Example

```java
onePlus.setModel("Nord");
```

Output:

```text
The phone model is Nord
```

---

# Advanced Example

```java
public class Student {

    private String name;
    private int age;

    public void setName(String name) {

        this.name = name;

    }

    public String getName() {

        return this.name;

    }

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

Usage:

```java
Student student =
        new Student();

student.setName("Sanjay");

student.setAge(21);

System.out.println(
        student.getName());

System.out.println(
        student.getAge());
```

Output:

```text
Sanjay
21
```

---

# Class vs Object

| Class | Object |
|---------|---------|
| Blueprint | Real Instance |
| Logical Entity | Physical Entity |
| Created Once | Created Multiple Times |
| No Memory for Data | Occupies Memory |

---

# Common Mistakes

## Accessing Private Variables Directly

Wrong:

```java
phone.model = "Nord";
```

Correct:

```java
phone.setModel("Nord");
```

---

## Forgetting Object Creation

Wrong:

```java
Cellphone phone;

phone.setModel("Nord");
```

Runtime Error.

---

## Forgetting new

Wrong:

```java
Cellphone phone;
```

Correct:

```java
Cellphone phone =
        new Cellphone();
```

---

# Concept Map

```text
Object-Oriented Programming
           │
           ▼
        Class
           │
           ▼
        Object
           │
    ┌──────┴──────┐
    │             │
 Properties    Methods
    │             │
 Data         Behavior
```

---

# Interview Questions

## What is a class?

A blueprint used to create objects.

---

## What is an object?

An instance of a class.

---

## What does new do?

Creates an object in heap memory.

---

## Why use private variables?

To protect data and enforce validation.

---

## What is a setter?

A method used to update data.

---

## What is a getter?

A method used to retrieve data.

---

## What is encapsulation?

Binding data and methods together while restricting direct access.

---

# Practice Challenges

1. Create a Car class.
2. Create a Student class.
3. Create a BankAccount class.
4. Create an Employee class.
5. Add validation using setters.

---

# Key Takeaways

- Classes are blueprints.
- Objects are instances of classes.
- Objects are created using `new`.
- Data is stored in heap memory.
- Private variables protect data.
- Getters and setters provide controlled access.
- Classes form the foundation of OOP.

---

# Conclusion

Classes and Objects are the building blocks of Java's Object-Oriented Programming model. A class defines the structure and behavior of an object, while objects represent real-world entities created from that blueprint. Understanding classes, objects, encapsulation, getters, and setters is essential before moving to constructors, inheritance, and advanced OOP concepts.
