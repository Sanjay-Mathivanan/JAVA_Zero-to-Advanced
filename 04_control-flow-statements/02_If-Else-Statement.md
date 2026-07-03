# If-Else Statement in Java

## Introduction

In the previous chapter, we learned that the `if` statement executes code only when a condition is true.

However, real-world applications often require two possible outcomes:

- One action when the condition is true
- Another action when the condition is false

This is where the `if-else` statement becomes useful.

The `if-else` statement allows a program to choose between two different execution paths.

---

# What is an If-Else Statement?

## Definition

An `if-else` statement executes one block of code when the condition is true and another block of code when the condition is false.

---

# Real-World Analogy

Imagine a security guard checking your age.

```text
Age >= 18 ?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
Entry     Entry
Allowed   Denied
```

Unlike a simple `if` statement, both outcomes are handled.

---

# Syntax

```java
if(condition) {

    // Executes if condition is true

}
else {

    // Executes if condition is false

}
```

---

# Flow Diagram

```text
Condition
    ↓
True or False
    ↓
 ┌──┴──┐
 │     │
True  False
 │     │
If    Else
Block Block
```

---

# First Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 20;

        if(age >= 18) {

            System.out.println(
                    "Eligible to Vote");

        } else {

            System.out.println(
                    "Not Eligible to Vote");

        }
    }
}
```

---

# Output

```text
Eligible to Vote
```

---

# Step-by-Step Execution

## Step 1

Variable:

```java
age = 20
```

---

## Step 2

Condition:

```java
age >= 18
```

Evaluation:

```text
20 >= 18

true
```

---

## Step 3

Since condition is true:

```java
if block
```

executes.

---

## Step 4

The else block is skipped.

---

# Example Using Boolean Variable

```java
public class Main {

    public static void main(String[] args) {

        boolean isLoggedIn = false;

        if(isLoggedIn) {

            System.out.println(
                    "Welcome User");

        } else {

            System.out.println(
                    "Please Login");

        }
    }
}
```

---

# Output

```text
Please Login
```

---

# Internal Working

Variable:

```java
isLoggedIn = false
```

Condition:

```java
if(isLoggedIn)
```

Result:

```text
false
```

Therefore:

```java
else
```

executes.

---

# Memory Representation

```java
boolean isLoggedIn = false;
```

Stack Memory:

```text
Stack Memory
------------------------
isLoggedIn → false
------------------------
```

Condition:

```java
if(isLoggedIn)
```

Java reads:

```text
false
```

and executes the else block.

---

# Example: Positive or Negative Number

```java
public class Main {

    public static void main(String[] args) {

        int number = -10;

        if(number > 0) {

            System.out.println(
                    "Positive Number");

        } else {

            System.out.println(
                    "Negative Number");

        }
    }
}
```

---

# Output

```text
Negative Number
```

---

# Example: Even or Odd Number

```java
public class Main {

    public static void main(String[] args) {

        int number = 7;

        if(number % 2 == 0) {

            System.out.println("Even");

        } else {

            System.out.println("Odd");

        }
    }
}
```

---

# Output

```text
Odd
```

---

# Example: Pass or Fail

```java
public class Main {

    public static void main(String[] args) {

        int marks = 45;

        if(marks >= 50) {

            System.out.println("Pass");

        } else {

            System.out.println("Fail");

        }
    }
}
```

---

# Output

```text
Fail
```

---

# Example: Password Validation

```java
public class Main {

    public static void main(String[] args) {

        boolean passwordCorrect = true;

        if(passwordCorrect) {

            System.out.println(
                    "Login Successful");

        } else {

            System.out.println(
                    "Invalid Password");

        }
    }
}
```

---

# Output

```text
Login Successful
```

---

# Internal Execution Flow

```text
Program Starts
       ↓
Condition Checked
       ↓
 ┌─────┴─────┐
 │           │
True       False
 │           │
If Block  Else Block
 │           │
 └─────┬─────┘
       ↓
Continue Program
```

---

# Difference Between If and If-Else

| Feature | If | If-Else |
|----------|----------|----------|
| True Condition | Executes | Executes |
| False Condition | Skipped | Executes Else Block |
| Number of Outcomes | One | Two |

---

# Nested If-Else Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 20;
        boolean hasId = true;

        if(age >= 18) {

            if(hasId) {

                System.out.println(
                        "Entry Allowed");

            } else {

                System.out.println(
                        "ID Required");

            }

        } else {

            System.out.println(
                    "Under Age");

        }
    }
}
```

---

# Output

```text
Entry Allowed
```

---

# Real-Life Applications

## ATM Machine

```java
if(balance >= withdrawalAmount)
```

Withdraw money.

Else:

```java
Insufficient Balance
```

---

## Login System

```java
if(passwordCorrect)
```

Allow login.

Else:

```java
Show error
```

---

## Shopping Website

```java
if(totalAmount >= 5000)
```

Apply discount.

Else:

```java
No discount
```

---

# Common Beginner Mistakes

## Mistake 1

Wrong:

```java
if(age = 18)
```

Correct:

```java
if(age == 18)
```

---

## Mistake 2

Wrong:

```java
if(number > 0);
{
    System.out.println("Positive");
}
```

The semicolon ends the if statement.

---

## Mistake 3

Wrong:

```java
if(number)
```

Java requires:

```java
boolean expression
```

Correct:

```java
if(number > 0)
```

---

# Concept Map

```text
Control Flow Statements
          │
          ▼
      If-Else
          │
          ▼
      Condition
          │
   ┌──────┴──────┐
   │             │
 True         False
   │             │
 If Block    Else Block
```

---

# Interview Questions

## What is an if-else statement?

A decision-making statement that executes one block for true conditions and another block for false conditions.

---

## Can else exist without if?

No.

---

## How many blocks execute in an if-else statement?

Only one block executes.

---

## What datatype is required for conditions?

```java
boolean
```

---

## Can we nest if-else statements?

Yes.

---

# Practice Challenges

## Challenge 1

Check whether a person can vote.

---

## Challenge 2

Check whether a number is even or odd.

---

## Challenge 3

Check whether a student passed or failed.

---

## Challenge 4

Create a login validation program.

---

## Challenge 5

Check whether a number is positive or negative.

---

# Key Takeaways

- The `if-else` statement provides two execution paths.
- Only one block executes at a time.
- Conditions must evaluate to true or false.
- Used heavily in real-world applications.
- Forms the foundation for advanced decision-making structures.

---

# Conclusion

The `if-else` statement extends the power of the `if` statement by handling both possible outcomes of a condition. It allows programs to make intelligent decisions and respond differently based on user input, calculations, or business rules. Mastering `if-else` is essential before learning nested conditions, else-if ladders, switch statements, and advanced control flow techniques.
