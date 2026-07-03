# Method Overloading Challenge

## Introduction

In this challenge, we will apply the concept of Method Overloading to calculate the area of different geometric shapes.

Instead of creating separate method names such as:

```java
squareArea()
rectangleArea()
triangleArea()
```

we will use the same method name:

```java
area()
```

with different parameter lists.

This demonstrates one of the most practical uses of Method Overloading.

---

# Problem Statement

Create a program that calculates the area of:

1. Square
2. Rectangle
3. Triangle

using overloaded methods.

---

# Requirements

## Step 1

Declare the following variables:

```java
int length;
int breadth;
double height;
```

These variables will store the dimensions of different shapes.

---

## Step 2

Declare the following variables to store results:

```java
double sqArea;
double rectArea;
double triArea;
```

---

## Step 3

Create the following overloaded methods:

### Square

```java
area(int length)
```

Calculates:

```text
Area = side × side
```

---

### Rectangle

```java
area(int length, int breadth)
```

Calculates:

```text
Area = length × breadth
```

---

### Triangle

```java
area(int breadth, double height)
```

Calculates:

```text
Area = ½ × breadth × height
```

---

# Understanding the Overloading

Notice all methods have the same name:

```java
area()
```

The compiler differentiates them using:

```text
Number of Parameters
Datatype of Parameters
```

---

# Visual Representation

```text
area()
   │
   ├── area(int)
   │        ↓
   │      Square
   │
   ├── area(int,int)
   │        ↓
   │     Rectangle
   │
   └── area(int,double)
            ↓
         Triangle
```

---

# Complete Program

```java
public class Main {

    public static void main(String[] args) {

        int length = 10;
        int breadth = 5;
        double height = 8.0;

        double sqArea = area(length);

        double rectArea = area(length, breadth);

        double triArea = area(breadth, height);

        System.out.println("Square Area = " + sqArea);

        System.out.println("Rectangle Area = " + rectArea);

        System.out.println("Triangle Area = " + triArea);
    }

    public static double area(int length) {

        return length * length;

    }

    public static double area(
            int length,
            int breadth) {

        return length * breadth;

    }

    public static double area(
            int breadth,
            double height) {

        return 0.5 * breadth * height;

    }
}
```

---

# Output

```text
Square Area = 100.0
Rectangle Area = 50.0
Triangle Area = 20.0
```

---

# Step-by-Step Execution

## Square Area

Method Call:

```java
area(10)
```

Compiler selects:

```java
area(int length)
```

Calculation:

```text
10 × 10 = 100
```

---

## Rectangle Area

Method Call:

```java
area(10,5)
```

Compiler selects:

```java
area(int length,int breadth)
```

Calculation:

```text
10 × 5 = 50
```

---

## Triangle Area

Method Call:

```java
area(5,8.0)
```

Compiler selects:

```java
area(int breadth,double height)
```

Calculation:

```text
0.5 × 5 × 8

= 20
```

---

# Internal Working

When Java encounters:

```java
area(10);
```

Compiler searches:

```java
area(int)
```

and executes that method.

---

When Java encounters:

```java
area(10,5);
```

Compiler searches:

```java
area(int,int)
```

and executes that method.

---

When Java encounters:

```java
area(5,8.0);
```

Compiler searches:

```java
area(int,double)
```

and executes that method.

---

# Method Resolution Flow

```text
Method Call
      ↓
Compiler Reads Method Name
      ↓
Compiler Reads Arguments
      ↓
Matching Signature Found
      ↓
Method Executes
```

---

# Memory Representation

For:

```java
double sqArea = area(10);
```

Stack Memory:

```text
Stack
---------------------
area()
length → 10
---------------------
main()
---------------------
```

After execution:

```text
Stack
---------------------
main()
---------------------
```

Returned value:

```text
100
```

stored in:

```java
sqArea
```

---

# Why Method Overloading is Useful

Without Overloading:

```java
squareArea()

rectangleArea()

triangleArea()
```

With Overloading:

```java
area()

area()

area()
```

Benefits:

- Cleaner code
- Easier maintenance
- Better readability
- Logical grouping of related operations

---

# Challenge Extension

Add another overloaded method:

```java
area(double radius)
```

to calculate the area of a circle.

Formula:

```text
π × r²
```

---

# Challenge Extension 2

Create overloaded methods for:

```java
perimeter(int side)

perimeter(int length,int breadth)

perimeter(double radius)
```

---

# Common Mistakes

## Changing Only Return Type

Wrong:

```java
double area(int side)

int area(int side)
```

Compiler Error.

---

## Same Parameters

Wrong:

```java
area(int side)

area(int length)
```

Compiler Error.

Parameter names do not matter.

---

## Wrong Formula

Triangle:

Correct:

```java
0.5 * breadth * height
```

Wrong:

```java
breadth * height
```

---

# Interview Questions

## What is Method Overloading?

Using the same method name with different parameter lists.

---

## How does Java identify overloaded methods?

Using:

- Number of parameters
- Datatype of parameters
- Order of parameters

---

## Can methods be overloaded by changing return type only?

No.

---

## What type of polymorphism is method overloading?

Compile-Time Polymorphism.

---

# Key Takeaways

- Method overloading allows multiple methods with the same name.
- Parameter list must be different.
- Java resolves overloaded methods during compilation.
- Overloading improves readability and code organization.
- Related operations can be grouped under a single method name.

---

# Conclusion

This challenge demonstrates a practical use of Method Overloading by calculating the areas of multiple geometric shapes using the same method name. By changing the parameter list, Java automatically selects the appropriate method during compilation. Understanding this concept is essential before moving to advanced object-oriented programming topics such as inheritance, overriding, and polymorphism.
