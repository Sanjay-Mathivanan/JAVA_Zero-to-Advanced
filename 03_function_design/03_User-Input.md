# User Input and Console Interaction in Java

## Introduction

Most real-world applications require interaction with users.

Examples:
- ATM machines
- Login systems
- Calculator apps
- Online forms
- Banking software
- Student management systems

Without user input, programs become static and cannot process dynamic data.

Java provides multiple ways to read user input from the keyboard, files, or external sources.

The most commonly used method for beginners is:

```java
Scanner
```

from the:

```java
java.util
```

package.

---

# What is User Input?

## Definition

User input is data entered by the user during program execution.

The data may include:
- Numbers
- Characters
- Strings
- Decimal values
- Boolean values

---

# Why User Input is Important

Without input:
- Programs always produce fixed output
- Logic becomes non-interactive
- Real-world problem solving becomes impossible

User input allows:
- Dynamic execution
- Decision making
- Runtime calculations
- Personalized program behavior

---

# Real-World Analogy

Think about a calculator application.

The calculator waits for:
- first number
- second number
- operation

Only after receiving input can it generate output.

Similarly, Java programs often pause execution and wait for user data.

---

# Ways to Read Input in Java

| Method | Description |
|---|---|
| Scanner | Most commonly used |
| BufferedReader | Faster input handling |
| Console | Secure console input |
| Command Line Arguments | Input from terminal |
| GUI Input | Input through graphical forms |

For beginners, Scanner is the best starting point.

---

# Scanner Class in Java

## Definition

Scanner is a predefined Java class used to read input from:
- Keyboard
- Files
- Strings
- Streams

---

# Importing Scanner

Before using Scanner, import it:

```java
import java.util.Scanner;
```

---

# Why Import is Needed

Scanner belongs to:

```text
java.util package
```

Java must know where the Scanner class exists.

---

# Creating Scanner Object

## Syntax

```java
Scanner variableName = new Scanner(System.in);
```

---

# Example

```java
Scanner sc = new Scanner(System.in);
```

---

# Understanding the Syntax

| Part | Meaning |
|---|---|
| Scanner | Class name |
| sc | Object name |
| new | Creates object |
| System.in | Standard keyboard input |

---

# Internal Working of Scanner

```text
Keyboard Input
      ↓
System.in Stream
      ↓
Scanner Object
      ↓
Input Processing
      ↓
Java Variables
```

---

# First User Input Program

## Example

```java
import java.util.Scanner;

public class UserInputExample {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");

        String name = sc.nextLine();

        System.out.println("Welcome " + name);

    }
}
```

---

# Sample Output

```text
Enter your name: Sanjay
Welcome Sanjay
```

---

# Step-by-Step Explanation

## Step 1

```java
import java.util.Scanner;
```

Imports Scanner class.

---

## Step 2

```java
Scanner sc = new Scanner(System.in);
```

Creates Scanner object.

---

## Step 3

```java
String name = sc.nextLine();
```

Reads complete line input.

---

## Step 4

```java
System.out.println()
```

Displays output.

---

# Memory Representation

```text
Stack Memory
-------------------------
sc → Scanner Object
name → "Sanjay"
-------------------------

Heap Memory
-------------------------
Scanner Object
-------------------------
```

---

# Common Scanner Methods

| Method | Reads |
|---|---|
| nextInt() | Integer |
| nextDouble() | Double |
| nextFloat() | Float |
| nextLong() | Long |
| next() | Single word |
| nextLine() | Entire line |
| nextBoolean() | Boolean value |

---

# Reading Integer Input

## Example

```java
import java.util.Scanner;

public class IntegerInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");

        int age = sc.nextInt();

        System.out.println("Age is " + age);

    }
}
```

---

# Sample Output

```text
Enter age: 21
Age is 21
```

---

# Reading Double Input

## Example

```java
import java.util.Scanner;

public class DoubleInput {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter salary: ");

        double salary = sc.nextDouble();

        System.out.println("Salary is " + salary);

    }
}
```

---

# Sample Output

```text
Enter salary: 50000.75
Salary is 50000.75
```

---

# next() vs nextLine()

This is one of the most confusing beginner topics.

---

# next()

Reads:
```text
Only one word
```

Stops reading at space.

## Example

```java
String name = sc.next();
```

Input:
```text
John Wick
```

Output:
```text
John
```

---

# nextLine()

Reads:
```text
Entire line
```

## Example

```java
String name = sc.nextLine();
```

Input:
```text
John Wick
```

Output:
```text
John Wick
```

---

# Comparison Table

| Method | Reads Space? |
|---|---|
| next() | No |
| nextLine() | Yes |

---

# Common Input Problem

## Problem Example

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();

String name = sc.nextLine();
```

---

# What Happens?

`nextInt()` leaves newline character in input buffer.

Then:
```java
nextLine()
```

reads the leftover newline instead of actual input.

---

# Internal Buffer Problem

```text
User enters:
25↵

nextInt() reads:
25

Remaining in buffer:
↵

nextLine() reads:
↵
```

---

# Solution

Add extra:

```java
sc.nextLine();
```

---

# Correct Version

```java
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
sc.nextLine();

String name = sc.nextLine();
```

---

# User Input Flow Diagram

```text
User Types Data
       ↓
Keyboard Buffer
       ↓
System.in Stream
       ↓
Scanner Reads Input
       ↓
Data Stored in Variables
       ↓
Program Uses Data
```

---

# Multiple Inputs Example

```java
import java.util.Scanner;

public class StudentDetails {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter marks: ");
        double marks = sc.nextDouble();

        System.out.println("Student Details");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Marks: " + marks);

    }
}
```

---

# Sample Output

```text
Enter name: Sanjay
Enter age: 21
Enter marks: 89.5

Student Details
Name: Sanjay
Age: 21
Marks: 89.5
```

---

# Common Beginner Mistakes

## 1. Forgetting Import Statement

Wrong:

```java
Scanner sc = new Scanner(System.in);
```

Without import:
```java
import java.util.Scanner;
```

Compiler error occurs.

---

## 2. Using Wrong Input Method

Wrong:

```java
int age = sc.nextLine();
```

Reason:
`nextLine()` returns String.

---

## 3. Confusing next() and nextLine()

Very common issue among beginners.

---

## 4. Ignoring Buffer Problem

Occurs after:
- nextInt()
- nextDouble()
- nextFloat()

---

# Best Practices

- Use meaningful variable names
- Close Scanner when finished
- Use nextLine() carefully
- Validate user input
- Handle invalid input safely

---

# Closing Scanner

## Syntax

```java
sc.close();
```

---

# Why Close Scanner?

Releases system resources.

---

# Example

```java
Scanner sc = new Scanner(System.in);

System.out.println("Hello");

sc.close();
```

---

# Concept Map

```text
User Input
    ↓
Scanner Class
    ↓
Input Methods
    ├── nextInt()
    ├── nextDouble()
    ├── next()
    └── nextLine()
           ↓
Variables
           ↓
Processing
           ↓
Output
```

---

# Interview Questions

## 1. What is Scanner in Java?

A predefined class used for reading input.

---

## 2. Which package contains Scanner?

```text
java.util
```

---

## 3. Difference between next() and nextLine()?

- next() reads one word
- nextLine() reads entire line

---

## 4. Why does nextLine() sometimes skip input?

Because newline character remains in buffer.

---

## 5. What is System.in?

Standard input stream connected to keyboard.

---

# Practice Challenges

## Challenge 1

Take two integers from user and print sum.

---

## Challenge 2

Read full name using nextLine().

---

## Challenge 3

Build simple calculator using Scanner.

---

## Challenge 4

Read student details:
- name
- age
- department
- marks

and display formatted output.

---

# Key Takeaways

- User input makes programs interactive.
- Scanner is the most common input class.
- System.in connects program to keyboard.
- next() and nextLine() behave differently.
- Input buffer handling is important.
- Different Scanner methods read different datatypes.

---

# Conclusion

User input handling is one of the most fundamental skills in Java programming.

Almost every real-world application depends on dynamic user interaction.

Understanding:
- Scanner
- input methods
- buffer handling
- datatype reading

helps build:
- interactive programs
- calculators
- form systems
- console applications
- backend services

Mastering user input is the first step toward developing complete real-world Java applications.
