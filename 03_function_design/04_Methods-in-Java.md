# Methods in Java

## Introduction

Methods are reusable blocks of code that perform a specific task.

Instead of writing the same code multiple times, we can place that code inside a method and call it whenever needed.

Methods help in:

- Code reusability
- Better organization
- Easier debugging
- Improved readability
- Modular programming

---

# Real-World Analogy

Think of a washing machine.

```text
Press Start Button
        ↓
Washing Process Begins
        ↓
Clothes Get Cleaned
```

You do not manually wash every cloth.

Similarly, a method performs a task whenever it is called.

---

# What is a Method?

A method is a named block of code that executes only when it is called.

Example:

```java
public static void greet() {
    System.out.println("Welcome to Java");
}
```

The method above prints a message whenever it is called.

---

# General Syntax

```java
accessModifier static returnType methodName(parameters) {

    // method body

}
```

Example:

```java
public static void greet() {

    System.out.println("Hello");

}
```

---

# Components of a Method

```java
public static void greet()
```

| Part | Purpose |
|--------|----------|
| public | Accessible everywhere |
| static | Belongs to class |
| void | Returns nothing |
| greet | Method name |
| () | Parameter list |

---

# Method Execution Flow

```text
Program Starts
      ↓
main() Executes
      ↓
Method Call Found
      ↓
Control Transfers To Method
      ↓
Method Executes
      ↓
Returns Back To Caller
```

---

# Example 1: Simple Method

```java
public class Main {

    public static void main(String[] args) {

        greet();

    }

    public static void greet() {

        System.out.println("Welcome to Java");

    }
}
```

### Output

```text
Welcome to Java
```

---

# Why Methods are Needed

Without methods:

```java
System.out.println("Welcome");
System.out.println("Welcome");
System.out.println("Welcome");
```

With methods:

```java
greet();
greet();
greet();
```

Less code and easier maintenance.

---

# Methods with Parameters

## What are Parameters?

Parameters are variables that receive values when a method is called.

```java
public static void greet(String name)
```

Here:

```java
name
```

is a parameter.

---

# Example 2: Method with Parameter

```java
public class Main {

    public static void main(String[] args) {

        greet("Sanjay");
        greet("Rahul");

    }

    public static void greet(String name) {

        System.out.println("Welcome " + name);

    }
}
```

### Output

```text
Welcome Sanjay
Welcome Rahul
```

---

# Internal Memory Flow

Method Call:

```java
greet("Sanjay");
```

Memory:

```text
Stack Memory

main()
    ↓
greet()
    ↓
name → "Sanjay"
```

After execution:

```text
greet() removed from stack
```

---

# Example 3: Rectangle Perimeter Method

This is the first concept from the PrepInsta example.

```java
public class Main {

    public static void main(String[] args) {

        perimeterOfRect(10, 20);
        perimeterOfRect(20, 30);

    }

    public static void perimeterOfRect(int length, int breadth) {

        double perimeter = 2 * (length + breadth);

        System.out.println("Perimeter = " + perimeter);

    }
}
```

### Output

```text
Perimeter = 60.0
Perimeter = 100.0
```

---

# Step-by-Step Execution

First Call:

```java
perimeterOfRect(10,20);
```

Parameter Assignment:

```text
length = 10
breadth = 20
```

Calculation:

```text
2 × (10 + 20)

2 × 30

60
```

---

# Method Call Stack

```text
main()
   ↓
perimeterOfRect(10,20)
   ↓
Calculate
   ↓
Print
   ↓
Return to main()
```

---

# Methods That Return Values

Sometimes a method must send a result back.

For this purpose we use:

```java
return
```

---

# Example 4: Calculate Speed

Formula:

```text
Speed = Distance / Time
```

Program:

```java
public class Main {

    public static void main(String[] args) {

        double speed = speedOfObject(100, 20);

        System.out.println(speed);

    }

    public static double speedOfObject(double distance,
                                       double time) {

        double speed = distance / time;

        return speed;

    }
}
```

### Output

```text
5.0
```

---

# What Happens Internally?

```text
main()
    ↓
speedOfObject(100,20)
    ↓
100 / 20
    ↓
5
    ↓
return 5
    ↓
stored in speed variable
```

---

# Understanding Return

```java
return speed;
```

Meaning:

```text
Send speed value back
to the calling method
```

---

# Example 5: Conditional Return

This is adapted from the PrepInsta example.

```java
public static double speedOfObject(double distance,
                                   double time) {

    if(distance == 100) {

        return distance / time;

    }

    return Double.NaN;

}
```

---

# What is Double.NaN?

NaN means:

```text
Not a Number
```

Used when a valid numeric answer cannot be produced.

Example:

```java
double result = Double.NaN;

System.out.println(result);
```

Output:

```text
NaN
```

---

# Full PrepInsta Example (Final Version)

```java
public class Main {

    public static void main(String[] args) {

        perimeterOfRect(10,20);
        perimeterOfRect(20,30);

        double topSpeed =
                speedOfObject(100,20);

        double x = 40 * topSpeed;

        System.out.println(x);
    }

    public static void perimeterOfRect(
            int length,
            int breadth) {

        double perimeter =
                2 * (length + breadth);

        System.out.println(
                "Perimeter = " + perimeter);
    }

    public static double speedOfObject(
            double distance,
            double time) {

        if(distance == 100) {

            return distance / time;

        }

        return Double.NaN;
    }
}
```

### Output

```text
Perimeter = 60.0
Perimeter = 100.0
200.0
```

---

# Types of Methods

## 1. No Parameters, No Return

```java
public static void greet()
```

---

## 2. Parameters, No Return

```java
public static void greet(String name)
```

---

## 3. No Parameters, Return Value

```java
public static int getAge()
```

---

## 4. Parameters and Return Value

```java
public static int add(int a, int b)
```

---

# Concept Map

```text
Methods
│
├── Method Declaration
│
├── Method Call
│
├── Parameters
│
├── Arguments
│
├── Return Value
│
└── Reusability
```

---

# Common Mistakes

## Missing Method Call

Wrong:

```java
greet;
```

Correct:

```java
greet();
```

---

## Missing Return

Wrong:

```java
public static int add() {

}
```

Compiler Error.

---

## Return Type Mismatch

Wrong:

```java
public static int add() {

    return "Hello";

}
```

---

# Interview Questions

### What is a method?

A reusable block of code that performs a specific task.

### Difference between parameter and argument?

Parameter:
```java
(int a)
```

Argument:
```java
add(10)
```

### What does return do?

Returns a value back to the caller.

### Why are methods important?

They improve reusability, readability, and maintainability.

---

# Practice Challenges

1. Create a method to calculate area of a rectangle.
2. Create a method that returns the square of a number.
3. Create a method that checks whether a number is even.
4. Create a method that returns the maximum of two numbers.
5. Create a method that converts Celsius to Fahrenheit.

---

# Key Takeaways

- Methods are reusable code blocks.
- Methods execute only when called.
- Parameters receive data.
- Arguments supply data.
- Return sends results back.
- Java uses stack memory for method execution.
- Methods improve code organization and maintenance.

---

# Conclusion

Methods are one of the most important building blocks in Java. They allow developers to divide large problems into smaller reusable units, making programs easier to understand, maintain, and scale. Understanding method declaration, method calling, parameters, return values, and execution flow is essential before learning advanced topics such as method overloading, recursion, and object-oriented programming.
