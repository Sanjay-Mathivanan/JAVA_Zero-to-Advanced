# If Statement in Java

## Introduction

Programs become powerful when they can make decisions.

Imagine:

- A voting system checking age
- An ATM checking balance
- A login system validating credentials
- An e-commerce website applying discounts

All these systems need decision-making capabilities.

In Java, decision-making begins with the:

```java
if
```

statement.

The `if` statement allows a program to execute a block of code only when a specified condition evaluates to `true`.

---

# What is an If Statement?

## Definition

An `if` statement is a control flow statement that executes a block of code only when a condition is true.

---

# Real-World Analogy

Consider a voting booth.

```text
Age >= 18 ?
      │
 ┌────┴────┐
 │         │
Yes       No
 │         │
Vote    Cannot Vote
```

The voting officer makes a decision based on a condition.

Similarly, Java uses the `if` statement to make decisions.

---

# Why Do We Need If Statements?

Without conditions:

```java
System.out.println("Eligible to Vote");
```

This message will always print.

Even for someone who is 10 years old.

Using `if`:

```java
if(age >= 18) {
    System.out.println("Eligible to Vote");
}
```

The message prints only when the condition is satisfied.

---

# Syntax of If Statement

```java
if(condition) {

    // code to execute

}
```

---

# Components of an If Statement

```java
if(age >= 18)
```

| Part | Meaning |
|--------|----------|
| if | Decision keyword |
| age >= 18 | Condition |
| { } | Block of code |

---

# How If Works Internally

```text
Condition Evaluated
        ↓
   True or False
        ↓
      True
        ↓
 Execute Block
```

If the condition becomes:

```text
False
```

the block is skipped.

---

# First Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 20;

        if(age >= 18) {

            System.out.println(
                    "Eligible to Vote");

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

### Step 1

```java
age = 20
```

---

### Step 2

Condition:

```java
age >= 18
```

becomes:

```text
20 >= 18

true
```

---

### Step 3

Since condition is true:

```java
System.out.println()
```

executes.

---

# Example Using Boolean Variables

This example is adapted from the provided code.

```java
public class Main {

    public static void main(String[] args) {

        boolean amIAbove18 = false;

        if(amIAbove18 == true) {

            System.out.println(
                    "You are eligible to vote");

        }

        if(amIAbove18 == false) {

            System.out.println(
                    "You can't vote");

        }

    }
}
```

---

# Output

```text
You can't vote
```

---

# Internal Evaluation

Variable:

```java
amIAbove18 = false
```

Condition:

```java
amIAbove18 == true
```

Result:

```text
false
```

Block skipped.

---

Second Condition:

```java
amIAbove18 == false
```

Result:

```text
true
```

Block executes.

---

# Simplified Boolean Check

Instead of:

```java
if(a == true)
```

Java allows:

```java
if(a)
```

because `a` already contains a boolean value.

---

# Example

```java
public class Main {

    public static void main(String[] args) {

        boolean a = true;

        if(a) {

            System.out.println("A is true");

            System.out.println("This is a test");

        }
    }
}
```

---

# Output

```text
A is true
This is a test
```

---

# Why Does This Work?

Internally Java evaluates:

```java
if(a)
```

as:

```java
if(a == true)
```

---

# Memory Representation

Consider:

```java
boolean a = true;
```

Stack Memory:

```text
Stack Memory
-------------------
a → true
-------------------
```

Condition:

```java
if(a)
```

Java reads:

```text
a → true
```

and executes the block.

---

# Flow Diagram

```text
Program Starts
       ↓
Read Condition
       ↓
Condition True?
       ↓
   ┌───┴───┐
   │       │
  Yes      No
   │       │
Execute   Skip
 Block    Block
```

---

# Example: Marks Checker

```java
public class Main {

    public static void main(String[] args) {

        int marks = 85;

        if(marks >= 50) {

            System.out.println("Pass");

        }
    }
}
```

---

# Output

```text
Pass
```

---

# Example: Positive Number Checker

```java
public class Main {

    public static void main(String[] args) {

        int number = 15;

        if(number > 0) {

            System.out.println(
                    "Positive Number");

        }
    }
}
```

---

# Output

```text
Positive Number
```

---

# Example: Discount Eligibility

```java
public class Main {

    public static void main(String[] args) {

        double purchaseAmount = 5000;

        if(purchaseAmount >= 3000) {

            System.out.println(
                    "Discount Applied");

        }
    }
}
```

---

# Output

```text
Discount Applied
```

---

# Nested If Statement

An `if` statement can exist inside another `if`.

```java
int age = 20;
boolean hasId = true;

if(age >= 18) {

    if(hasId) {

        System.out.println(
                "Entry Allowed");

    }
}
```

---

# Output

```text
Entry Allowed
```

---

# Common Mistakes

## Mistake 1

Wrong:

```java
if(age = 18)
```

Error:

```text
Assignment instead of comparison
```

Correct:

```java
if(age == 18)
```

---

## Mistake 2

Wrong:

```java
if(true);
{
    System.out.println("Hello");
}
```

Semicolon ends the if statement.

---

## Mistake 3

Wrong:

```java
if(10)
```

Java requires:

```java
boolean expression
```

Correct:

```java
if(number == 10)
```

---

# If Statement vs Real Life

| Real Life | Java |
|------------|------|
| Age Check | if(age >= 18) |
| ATM Balance | if(balance > amount) |
| Login Check | if(passwordCorrect) |
| Discount Check | if(total > 3000) |

---

# Concept Map

```text
Control Flow Statements
          │
          ▼
      If Statement
          │
          ▼
      Condition
          │
   ┌──────┴──────┐
   │             │
 True         False
   │             │
Execute       Skip
 Block        Block
```

---

# Interview Questions

## What is an if statement?

A decision-making statement that executes code only when a condition is true.

---

## What datatype does an if statement require?

```java
boolean
```

---

## Can we use a boolean variable directly inside if?

Yes.

Example:

```java
if(isLoggedIn)
```

---

## What happens when the condition is false?

The block is skipped.

---

## Can an if statement exist inside another if statement?

Yes. This is called a Nested If Statement.

---

# Practice Challenges

## Challenge 1

Check whether a number is positive.

---

## Challenge 2

Check whether a person is eligible to vote.

---

## Challenge 3

Check whether marks are above 50.

---

## Challenge 4

Check whether a number is divisible by 5.

---

## Challenge 5

Create a login validation using a boolean variable.

---

# Key Takeaways

- The `if` statement is used for decision making.
- Code executes only when the condition is true.
- Conditions must produce a boolean value.
- Boolean variables can be used directly inside `if`.
- Nested if statements allow multiple levels of decisions.
- If statements are the foundation of program logic.

---

# Conclusion

The `if` statement is one of the most important control flow structures in Java. It allows programs to make intelligent decisions based on conditions. From simple checks like voting eligibility to complex business rules in enterprise applications, the `if` statement forms the foundation of decision-making logic in programming.
