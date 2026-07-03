# Compile-Time Polymorphism in Java

## Introduction

Polymorphism means:

```text
One Thing
Can Have Many Forms
```

Java supports two types of polymorphism:

```text
1. Compile-Time Polymorphism
2. Runtime Polymorphism
```

This chapter focuses on:

```text
Compile-Time Polymorphism
```

which is achieved using:

```text
Method Overloading
```

---

# What is Compile-Time Polymorphism?

Compile-Time Polymorphism occurs when the Java compiler determines:

```text
Which Method Should Execute
```

during compilation.

Because the decision happens before program execution, it is called:

```text
Compile-Time Polymorphism
```

It is also known as:

```text
Static Polymorphism

OR

Early Binding
```

---

# Real-World Example

Imagine a calculator.

```text
Add 2 Numbers
Add 3 Numbers
Add 4 Numbers
```

All operations are called:

```text
add()
```

but perform different tasks.

---

# Understanding Method Overloading

Method Overloading means:

```text
Same Method Name

Different Parameter List
```

---

# Rules of Method Overloading

Methods must differ in:

```text
Number of Parameters
```

or

```text
Data Type of Parameters
```

or

```text
Order of Parameters
```

---

# Valid Overloading Examples

```java
add(int a, int b)
```

```java
add(int a, int b, int c)
```

```java
add(double a, double b)
```

All are valid.

---

# First Compile-Time Polymorphism Program

```java
class Calculator {

    public int add(
            int a,
            int b) {

        return a + b;
    }

    public int add(
            int a,
            int b,
            int c) {

        return a + b + c;
    }
}

public class Main {

    public static void main(String[] args) {

        Calculator calc =
                new Calculator();

        System.out.println(
                calc.add(10,20));

        System.out.println(
                calc.add(10,20,30));
    }
}
```

---

# Output

```text
30
60
```

---

# How Compiler Decides?

When:

```java
calc.add(10,20);
```

Compiler searches:

```java
add(int,int)
```

and selects it.

---

When:

```java
calc.add(10,20,30);
```

Compiler selects:

```java
add(int,int,int)
```

---

# Internal Working

```text
Method Call
      │
      ▼

Compiler Checks Arguments
      │
      ▼

Find Matching Method
      │
      ▼

Generate Bytecode
```

Decision happens before execution.

---

# Example 2: Different Data Types

```java
class Display {

    public void show(int num) {

        System.out.println(
                "Integer : " + num);
    }

    public void show(double num) {

        System.out.println(
                "Double : " + num);
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Display d =
                new Display();

        d.show(10);

        d.show(25.5);
    }
}
```

---

# Output

```text
Integer : 10
Double : 25.5
```

---

# Example 3: Different Parameter Order

```java
class Test {

    public void display(
            int age,
            String name) {

        System.out.println(
                age + " " + name);
    }

    public void display(
            String name,
            int age) {

        System.out.println(
                name + " " + age);
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Test obj = new Test();

        obj.display(21,"Sanjay");

        obj.display("Rahul",22);
    }
}
```

---

# Output

```text
21 Sanjay
Rahul 22
```

---

# Real-World Example

## Employee Payroll System

```java
class Payroll {

    public double salary(
            double basic) {

        return basic;
    }

    public double salary(
            double basic,
            double bonus) {

        return basic + bonus;
    }

    public double salary(
            double basic,
            double bonus,
            double allowance) {

        return basic +
               bonus +
               allowance;
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Payroll payroll =
                new Payroll();

        System.out.println(
                payroll.salary(30000));

        System.out.println(
                payroll.salary(
                        30000,
                        5000));

        System.out.println(
                payroll.salary(
                        30000,
                        5000,
                        2000));
    }
}
```

---

# Output

```text
30000.0
35000.0
37000.0
```

---

# Method Signature

Java identifies overloaded methods using:

```text
Method Name
+
Parameter List
```

This is called:

```text
Method Signature
```

Example:

```java
add(int,int)
```

and

```java
add(int,int,int)
```

have different signatures.

---

# Invalid Method Overloading

Changing only return type is NOT overloading.

Wrong:

```java
public int add(
        int a,
        int b) {

    return a + b;
}

public double add(
        int a,
        int b) {

    return a + b;
}
```

Compiler Error.

Because:

```text
Parameter List Same
```

---

# Memory Representation

```text
Calculator Object

----------------

add(int,int)

add(int,int,int)

add(double,double)

----------------
```

Compiler chooses the correct method.

---

# Advantages of Compile-Time Polymorphism

## Readability

Same method name for similar operations.

---

## Reusability

Avoid creating multiple method names.

---

## Flexibility

Supports multiple input combinations.

---

## Easier Maintenance

Code becomes cleaner.

---

# Constructor Overloading

Constructors can also be overloaded.

```java
class Student {

    public Student() {

        System.out.println(
                "Default Constructor");
    }

    public Student(String name) {

        System.out.println(
                "Name : " + name);
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student s1 =
                new Student();

        Student s2 =
                new Student("Sanjay");
    }
}
```

---

# Output

```text
Default Constructor
Name : Sanjay
```

---

# Compile-Time vs Runtime Polymorphism

| Compile-Time | Runtime |
|-------------|----------|
| Method Overloading | Method Overriding |
| Decided by Compiler | Decided at Runtime |
| Early Binding | Late Binding |
| Faster | Slightly Slower |
| Same Class Mostly | Parent-Child Classes |

---

# Common Mistakes

## Changing Only Return Type

Wrong:

```java
int add()

double add()
```

Not Overloading.

---

## Same Parameter List

Wrong:

```java
add(int,int)

add(int,int)
```

Duplicate method.

---

## Confusing Overloading with Overriding

Overloading:

```java
add(int,int)

add(int,int,int)
```

Different parameters.

---

Overriding:

```java
sound()
```

Same signature.

---

# Interview Questions

## What is Compile-Time Polymorphism?

Polymorphism resolved during compilation.

---

## How is it Achieved?

Using:

```text
Method Overloading
```

---

## What is Another Name?

```text
Static Polymorphism

Early Binding
```

---

## Can Constructors Be Overloaded?

Yes.

---

## Is Changing Return Type Enough?

No.

Parameter list must change.

---

## What is Method Signature?

```text
Method Name
+
Parameter List
```

---

# Practice Challenges

## Challenge 1

Create overloaded methods:

```java
area(int side)

area(int length,int breadth)
```

---

## Challenge 2

Create overloaded methods:

```java
print(int)

print(String)

print(double)
```

---

## Challenge 3

Create overloaded salary methods.

---

## Challenge 4

Create overloaded constructors in a Student class.

---

## Challenge 5

Create a Calculator with:

```java
add()

subtract()

multiply()
```

all overloaded.

---

# Concept Map

```text
Compile-Time Polymorphism
            │
            ▼
     Method Overloading
            │
    ┌───────┼────────┐
    ▼       ▼        ▼

Different Different Different
Count     Type      Order

            │
            ▼

Compiler Chooses Method
            │
            ▼

Early Binding
```

---

# Key Takeaways

- Compile-Time Polymorphism is achieved through Method Overloading.
- The compiler decides which method to call.
- Overloaded methods must differ in parameters.
- Changing only the return type is not valid overloading.
- Constructor overloading is also a form of compile-time polymorphism.
- It is also called Static Polymorphism or Early Binding.

---

# Conclusion

Compile-Time Polymorphism allows Java programs to use the same method name for multiple operations. Through Method Overloading, developers can create cleaner, more readable, and flexible code while enabling the compiler to determine the correct method before execution. It is one of the foundational concepts of Java OOP and an essential interview topic.
