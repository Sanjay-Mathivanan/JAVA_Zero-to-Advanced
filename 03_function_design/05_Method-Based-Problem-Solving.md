# Method-Based Problem Solving in Java

## Introduction

Learning method syntax is only the first step.

The real power of methods becomes visible when solving practical programming problems.

In this chapter, we will use methods to:

- Break large problems into smaller tasks
- Reuse logic
- Improve readability
- Separate calculations from display operations
- Build modular programs

The following examples demonstrate how multiple methods can work together to solve a problem.

---

# Problem Statement

Given:

- Student Name
- Student Marks

Create a program that:

1. Calculates the student's grade
2. Returns the grade
3. Displays student information

---

# Why Use Multiple Methods?

Without methods:

```java
Everything would be written inside main()
```

Problems:

- Hard to read
- Difficult to debug
- Poor code reuse

With methods:

```text
main()
   ↓
gradeCalculator()
   ↓
displayDetails()
```

Each method has a specific responsibility.

---

# Complete Program

```java
public class Main {

    public static void main(String[] args) {

        String studentName = "Manish Agarwal";
        int studentMarks = 84;

        char studentGrade =
                gradeCalculator(studentMarks);

        displayDetails(studentName,
                       studentGrade);
    }

    public static char gradeCalculator(int marks) {

        char grade;

        if (marks > 90 && marks <= 100) {

            grade = 'S';

        } else if (marks > 80 && marks <= 90) {

            grade = 'A';

        } else if (marks > 70 && marks <= 80) {

            grade = 'B';

        } else {

            grade = 'F';

        }

        return grade;
    }

    public static void displayDetails(
            String name,
            char studentGrade) {

        System.out.println(
            "The Student Name is: "
            + name
            + " He Scored a Grade: "
            + studentGrade);
    }
}
```

---

# Output

```text
The Student Name is: Manish Agarwal He Scored a Grade: A
```

---

# Breaking the Program into Smaller Problems

Instead of understanding the entire program at once, let's understand each method separately.

---

# Challenge 1: Calculate Student Grade

## Problem

Create a method that receives marks and returns a grade.

---

## Solution

```java
public static char gradeCalculator(int marks) {

    if(marks > 90 && marks <= 100) {
        return 'S';
    }

    return 'A';
}
```

---

## Method Signature

```java
public static char gradeCalculator(int marks)
```

### Meaning

| Part | Description |
|--------|-------------|
| public | Accessible everywhere |
| static | Belongs to class |
| char | Returns character |
| gradeCalculator | Method name |
| int marks | Parameter |

---

# Internal Working

Input:

```java
84
```

Execution:

```text
84 > 90 ?
     ↓ No

84 > 80 ?
     ↓ Yes

Grade = A
```

Return:

```text
A
```

---

# Challenge 2: Display Student Information

## Problem

Create a method that receives:

- Student Name
- Student Grade

and displays them.

---

## Solution

```java
public static void displayDetails(
        String name,
        char grade) {

    System.out.println(
            "Name: " + name);

    System.out.println(
            "Grade: " + grade);
}
```

---

# Output

```text
Name: Manish Agarwal
Grade: A
```

---

# Why Return Grade Instead of Printing?

Bad Design:

```java
gradeCalculator()
```

prints directly.

Problem:

```text
Cannot reuse result later
```

Good Design:

```java
return grade;
```

Benefits:

```text
Store result
Reuse result
Pass to other methods
```

---

# Data Flow Between Methods

```text
studentMarks
      ↓
gradeCalculator()
      ↓
returns 'A'
      ↓
studentGrade
      ↓
displayDetails()
      ↓
Output
```

---

# Stack Memory During Execution

## Step 1

```java
main()
```

Stack:

```text
main()
```

---

## Step 2

```java
gradeCalculator(84)
```

Stack:

```text
gradeCalculator()
main()
```

---

## Step 3

Method finishes

```text
main()
```

gradeCalculator removed.

---

## Step 4

```java
displayDetails(...)
```

Stack:

```text
displayDetails()
main()
```

---

## Step 5

Program Ends

```text
Stack Empty
```

---

# Execution Trace

## Step 1

```java
studentMarks = 84
```

---

## Step 2

```java
gradeCalculator(84)
```

returns:

```text
A
```

---

## Step 3

```java
studentGrade = 'A'
```

---

## Step 4

```java
displayDetails(...)
```

called.

---

## Step 5

Student details printed.

---

# Program Flow Diagram

```text
Program Start
      ↓
main()
      ↓
Create Name
      ↓
Create Marks
      ↓
gradeCalculator()
      ↓
Return Grade
      ↓
displayDetails()
      ↓
Print Result
      ↓
Program End
```

---

# Improved Version

Instead of storing grade variable:

```java
public static char gradeCalculator(int marks) {

    if(marks > 90 && marks <= 100)
        return 'S';

    if(marks > 80 && marks <= 90)
        return 'A';

    if(marks > 70 && marks <= 80)
        return 'B';

    return 'F';
}
```

Cleaner and more efficient.

---

# Real-World Analogy

Think of a university system.

```text
Student Marks
       ↓
Evaluation Department
       ↓
Grade Generated
       ↓
Report Card Department
       ↓
Final Result Displayed
```

Each department performs one job.

Similarly:

```text
gradeCalculator()
       ↓
displayDetails()
```

Each method performs a specific task.

---

# Challenge Variations

## Challenge 1

Create a method that returns:

```text
Pass
Fail
```

instead of grades.

---

## Challenge 2

Create a method that calculates:

```text
Percentage
```

and returns it.

---

## Challenge 3

Create a method that determines:

```text
Distinction
First Class
Second Class
Fail
```

---

## Challenge 4

Create a method that calculates GPA.

---

## Challenge 5

Create a method that prints:

```text
Topper
Average
Needs Improvement
```

based on marks.

---

# Common Mistakes

## Returning Wrong Type

Wrong:

```java
return "A";
```

Method expects:

```java
char
```

Correct:

```java
return 'A';
```

---

## Missing Return Statement

Wrong:

```java
public static char gradeCalculator(int marks){

}
```

Compiler Error.

---

## Using = Instead of ==

Wrong:

```java
if(marks = 90)
```

Correct:

```java
if(marks == 90)
```

---

# Interview Questions

## Why use methods?

To improve:
- Reusability
- Readability
- Maintainability

---

## Difference Between void and char Return Type?

```java
void
```

Returns nothing.

```java
char
```

Returns a character value.

---

## What happens after return?

Method execution immediately stops and control goes back to the caller.

---

## Can one method call another method?

Yes.

Example:

```java
main()
    ↓
gradeCalculator()
    ↓
displayDetails()
```

---

# Key Takeaways

- Methods help solve complex problems in smaller steps.
- One method should perform one responsibility.
- Return values allow data reuse.
- Method calls create stack frames.
- Modular programs are easier to maintain.
- Real-world applications heavily rely on method decomposition.

---

# Conclusion

Method-based problem solving is a crucial programming skill. Instead of writing all logic inside `main()`, professional developers divide programs into small reusable methods. This approach improves readability, debugging, testing, and scalability. Understanding how methods communicate through parameters and return values is essential before learning method overloading, recursion, and object-oriented programming.
