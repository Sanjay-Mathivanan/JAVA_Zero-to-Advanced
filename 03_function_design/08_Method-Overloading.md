# Method Overloading in Java

## Introduction

In real-world applications, a method may need to perform the same task using different types or amounts of information.

For example:

- Display only a user's name
- Display name and age
- Display name, age, and grade
- Display complete profile information

Creating different method names for every variation would make programs difficult to maintain.

Java solves this problem using:

```text
Method Overloading
```

Method overloading allows multiple methods to have the same name while accepting different parameters.

---

# What is Method Overloading?

## Definition

Method Overloading is the process of creating multiple methods with the same name but different parameter lists.

The compiler identifies which method to execute based on:

- Number of parameters
- Datatype of parameters
- Order of parameters

---

# Why Method Overloading?

Without overloading:

```java
displayName();
displayNameAndAge();
displayNameAgeAndGrade();
displayFullDetails();
```

Problems:

- Too many method names
- Difficult maintenance
- Poor readability

With overloading:

```java
displayDetails();
displayDetails(name);
displayDetails(name, age);
displayDetails(name, age, grade);
```

Cleaner and easier to understand.

---

# Real-World Analogy

Think of a customer support hotline.

```text
Customer Calls
       ↓
Press 1 → Balance Inquiry
Press 2 → Loan Details
Press 3 → Card Services
```

Same phone number.

Different responses based on input.

Similarly:

```text
DisplayDetails()
```

is the same method name.

Different versions execute depending on arguments supplied.

---

# Method Overloading Syntax

```java
methodName(parameterList)
methodName(parameterList)
methodName(parameterList)
```

Example:

```java
public static void display() { }

public static void display(String name) { }

public static void display(String name, int age) { }
```

---

# Rules for Method Overloading

Methods must differ in at least one of:

## 1. Number of Parameters

```java
display()
display(String name)
display(String name, int age)
```

---

## 2. Datatype of Parameters

```java
display(int age)

display(String name)
```

---

## 3. Order of Parameters

```java
display(String name, int age)

display(int age, String name)
```

---

# Invalid Overloading

Changing only return type does NOT overload methods.

Wrong:

```java
public static int display() {
    return 10;
}

public static double display() {
    return 20;
}
```

Compiler Error.

---

# First Overloading Example

```java
public class Main {

    public static void main(String[] args) {

        display();

        display("Manish");

        display("Manish", 27);

    }

    public static void display() {

        System.out.println("No Information");

    }

    public static void display(String name) {

        System.out.println(name);

    }

    public static void display(String name,
                               int age) {

        System.out.println(
                name + " " + age);

    }
}
```

---

# Output

```text
No Information
Manish
Manish 27
```

---

# Understanding the PrepInsta Example

The program contains five methods having the same name:

```java
DisplayDetails()
```

but different parameter lists.

---

# Complete Program

```java
public class Main {

    public static void main(String[] args) {

        String name = "Manish";
        int age = 27;
        char grade = 'A';
        double height = 179.5;

        DisplayDetails(name, age, grade, height);

        DisplayDetails(name, age, grade);

        DisplayDetails(name, age);

        DisplayDetails(name);

        DisplayDetails();
    }

    public static void DisplayDetails(
            String userName,
            int userAge,
            char grade,
            double height) {

        System.out.println(
                "Complete Details");
    }

    public static void DisplayDetails(
            String userName,
            int userAge,
            char grade) {

        System.out.println(
                "Name Age Grade");
    }

    public static void DisplayDetails(
            String userName,
            int userAge) {

        System.out.println(
                "Name Age");
    }

    public static void DisplayDetails(
            String userName) {

        System.out.println(
                "Name");
    }

    public static void DisplayDetails() {

        System.out.println(
                "No Information");
    }
}
```

---

# Output

```text
Complete Details
Name Age Grade
Name Age
Name
No Information
```

---

# How Compiler Chooses Methods

When Java sees:

```java
DisplayDetails("Manish");
```

Compiler searches:

```java
DisplayDetails(String)
```

and executes that version.

---

When Java sees:

```java
DisplayDetails("Manish",27);
```

Compiler searches:

```java
DisplayDetails(String,int)
```

and executes that version.

---

# Internal Working

## Call 1

```java
DisplayDetails();
```

Compiler matches:

```java
public static void DisplayDetails()
```

---

## Call 2

```java
DisplayDetails("Manish");
```

Compiler matches:

```java
public static void DisplayDetails(
        String userName)
```

---

## Call 3

```java
DisplayDetails("Manish",27);
```

Compiler matches:

```java
public static void DisplayDetails(
        String userName,
        int userAge)
```

---

# Method Resolution Flow

```text
Method Call
      ↓
Compiler Checks Name
      ↓
Compiler Checks Parameters
      ↓
Matching Method Found
      ↓
Method Executes
```

---

# Memory Representation

Consider:

```java
DisplayDetails("Manish",27);
```

Stack Memory:

```text
Stack
--------------------
DisplayDetails()
userName → Manish
userAge → 27
--------------------
main()
--------------------
```

After execution:

```text
Stack
--------------------
main()
--------------------
```

Method frame is removed.

---

# Compile-Time Polymorphism

Method Overloading is called:

```text
Compile-Time Polymorphism
```

because the compiler decides which method to execute before the program runs.

---

# Overloading vs Overriding

| Feature | Overloading | Overriding |
|-----------|-----------|-----------|
| Same Class | Yes | Not Required |
| Inheritance | Not Required | Required |
| Parameters | Must Differ | Must Remain Same |
| Compile Time | Yes | No |
| Runtime | No | Yes |

---

# Real-World Use Cases

## Calculator

```java
add(int a, int b)

add(double a, double b)

add(int a, int b, int c)
```

---

## Print Service

```java
print()

print(String text)

print(String text, int copies)
```

---

## Login System

```java
login(email)

login(email,password)

login(email,password,otp)
```

---

# Common Mistakes

## Same Parameters

Wrong:

```java
display(String name)

display(String username)
```

Compiler Error.

Parameter names do not matter.

---

## Only Return Type Changed

Wrong:

```java
int display()

double display()
```

Compiler Error.

---

## Ambiguous Methods

Wrong:

```java
display(int a, double b)

display(double a, int b)
```

Some calls may confuse compiler.

---

# Concept Map

```text
Method Overloading
        │
        ├── Same Method Name
        │
        ├── Different Parameters
        │
        ├── Compile-Time Resolution
        │
        ├── Code Reusability
        │
        └── Compile-Time Polymorphism
```

---

# Interview Questions

## What is Method Overloading?

Creating multiple methods with the same name but different parameter lists.

---

## Can methods be overloaded by changing return type only?

No.

---

## Why is method overloading used?

To improve readability and flexibility.

---

## Is method overloading compile-time or runtime polymorphism?

Compile-time polymorphism.

---

## Can static methods be overloaded?

Yes.

---

# Practice Challenges

## Challenge 1

Create overloaded methods:

```java
area(int side)

area(int length, int breadth)
```

---

## Challenge 2

Create overloaded methods:

```java
print()

print(String message)

print(String message, int times)
```

---

## Challenge 3

Create overloaded methods for:

```java
add(int,int)

add(double,double)

add(int,int,int)
```

---

# Key Takeaways

- Method overloading allows multiple methods with the same name.
- Parameter list must differ.
- Return type alone cannot overload methods.
- Java resolves overloaded methods during compilation.
- Method overloading improves readability and maintainability.
- It is the first example of compile-time polymorphism.

---

# Conclusion

Method Overloading is a powerful feature that enables developers to create flexible and reusable code using a single method name. Instead of creating many differently named methods, Java allows the same method name to handle different kinds of input. Understanding method overloading is essential before learning inheritance, polymorphism, and object-oriented programming concepts.
