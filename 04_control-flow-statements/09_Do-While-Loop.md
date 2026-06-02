# Do-While Loop in Java

## Introduction

In the previous chapter, we learned about the `while` loop.

A while loop checks its condition **before** executing the loop body.

This means:

```text
If the condition is false initially,
the loop will never execute.
```

However, there are situations where we want the loop body to execute **at least once**, regardless of the condition.

Java provides:

```java
do-while
```

for such scenarios.

---

# What is a Do-While Loop?

## Definition

A do-while loop executes the loop body first and then checks the condition.

This guarantees that the loop body runs at least one time.

---

# Real-World Analogy

Imagine an ATM machine.

```text
Insert Card
      ↓
Enter PIN
      ↓
Validate PIN
      ↓
Correct?
      ↓
Yes → Continue
No  → Ask Again
```

The user gets at least one chance to enter a PIN.

Similarly, a do-while loop executes once before checking the condition.

---

# Syntax

```java
do {

    // code block

} while(condition);
```

---

# Components of Do-While Loop

```java
do {

    System.out.println(i);

} while(i <= 5);
```

| Part | Purpose |
|--------|----------|
| do | Starts loop |
| { } | Loop body |
| while | Condition check |
| condition | Controls repetition |

---

# How Do-While Works

```text
Execute Body
      ↓
Check Condition
      ↓
Condition True?
      ↓
Repeat Body
```

---

# Flow Diagram

```text
Loop Body
    ↓
Condition
    ↓
 ┌──┴──┐
 │     │
True False
 │     │
Repeat Exit
```

---

# First Example

```java
public class Main {

    public static void main(String[] args) {

        int i = 1;

        do {

            System.out.println(i);

            i++;

        } while(i <= 5);

    }
}
```

---

# Output

```text
1
2
3
4
5
```

---

# Step-by-Step Execution

## Step 1

```java
i = 1
```

---

## Step 2

Loop body executes.

Output:

```text
1
```

---

## Step 3

Update:

```java
i = 2
```

---

## Step 4

Condition:

```java
i <= 5
```

Result:

```text
true
```

Loop repeats.

---

The process continues until:

```java
i = 6
```

Condition:

```text
6 <= 5
```

False.

Loop ends.

---

# Difference Between While and Do-While

## While Loop

```java
int i = 10;

while(i < 5) {

    System.out.println(i);

}
```

Output:

```text
No Output
```

Condition is false initially.

---

## Do-While Loop

```java
int i = 10;

do {

    System.out.println(i);

} while(i < 5);
```

Output:

```text
10
```

The loop executes once before checking.

---

# Important Rule

```text
Do-While Loop Executes At Least Once
```

This is the biggest difference from a while loop.

---

# Example: Print Numbers from 1 to 10

```java
public class Main {

    public static void main(String[] args) {

        int i = 1;

        do {

            System.out.println(i);

            i++;

        } while(i <= 10);

    }
}
```

---

# Output

```text
1
2
3
4
5
6
7
8
9
10
```

---

# Example: Reverse Counting

```java
public class Main {

    public static void main(String[] args) {

        int i = 10;

        do {

            System.out.println(i);

            i--;

        } while(i >= 1);

    }
}
```

---

# Output

```text
10
9
8
7
6
5
4
3
2
1
```

---

# Example: Sum of Numbers

```java
public class Main {

    public static void main(String[] args) {

        int i = 1;
        int sum = 0;

        do {

            sum += i;

            i++;

        } while(i <= 10);

        System.out.println(sum);

    }
}
```

---

# Output

```text
55
```

---

# Internal Working

```text
sum = 0

1 → sum = 1
2 → sum = 3
3 → sum = 6
4 → sum = 10
...
10 → sum = 55
```

---

# Example: Menu-Driven Program

```java
public class Main {

    public static void main(String[] args) {

        int choice = 1;

        do {

            System.out.println(
                    "Displaying Menu");

            choice--;

        } while(choice > 0);

    }
}
```

---

# Output

```text
Displaying Menu
```

---

# Why Do-While is Useful Here

Menus should display at least once.

Using do-while guarantees:

```text
Menu Appears
Before Condition Check
```

---

# Memory Representation

Example:

```java
int i = 1;
```

Stack Memory:

```text
Stack Memory
-------------------
i → 1
-------------------
```

Loop:

```text
i → 2
i → 3
i → 4
i → 5
i → 6
```

Condition becomes false.

Loop ends.

---

# Infinite Do-While Loop

```java
do {

    System.out.println("Running");

} while(true);
```

---

# Output

```text
Running
Running
Running
...
```

Never stops.

---

# Why Infinite Loop Happens

Condition:

```java
while(true)
```

always evaluates to:

```text
true
```

Loop never exits.

---

# Do-While vs While

| Feature | While | Do-While |
|----------|----------|----------|
| Condition Check | Before Execution | After Execution |
| Minimum Executions | 0 | 1 |
| Suitable For | General Repetition | Menu Systems |
| First Iteration Guaranteed | No | Yes |

---

# Real-World Applications

## ATM Machines

```text
Show Menu Once
Then Check User Choice
```

---

## Login Systems

```text
Allow First Attempt
Then Validate
```

---

## Game Menus

```text
Display Menu
Until User Exits
```

---

## User Input Validation

```text
Ask Input
Until Valid Input Entered
```

---

# Common Mistakes

## Missing Semicolon

Wrong:

```java
do {

} while(i <= 5)
```

Correct:

```java
do {

} while(i <= 5);
```

---

## Forgetting Update

Wrong:

```java
do {

    System.out.println(i);

} while(i <= 5);
```

Infinite Loop.

---

## Wrong Condition

Wrong:

```java
while(i >= 5)
```

when:

```java
i = 1
```

Loop executes only once.

---

# Concept Map

```text
Loops
 │
 ├── For Loop
 │
 ├── While Loop
 │
 └── Do-While Loop
        │
        ├── Execute First
        ├── Check Later
        └── Runs At Least Once
```

---

# Interview Questions

## What is a do-while loop?

A loop that executes the body first and checks the condition afterward.

---

## How many times does a do-while loop execute minimum?

```text
1 Time
```

---

## What is the main difference between while and do-while?

While checks first.

Do-while executes first.

---

## Can a do-while loop execute only once?

Yes.

If the condition becomes false after the first iteration.

---

## Can a do-while loop be infinite?

Yes.

Example:

```java
while(true)
```

---

# Practice Challenges

## Challenge 1

Print numbers from 1 to 20 using do-while.

---

## Challenge 2

Print even numbers between 2 and 50.

---

## Challenge 3

Calculate the sum of numbers from 1 to 100.

---

## Challenge 4

Create a menu system using do-while.

---

## Challenge 5

Create a simple login retry system.

---

# Key Takeaways

- Do-while executes before checking the condition.
- The loop body always runs at least once.
- Useful for menus and user interaction systems.
- Requires a semicolon after the condition.
- Infinite loops occur if the condition never becomes false.
- Ideal when first execution must be guaranteed.

---

# Conclusion

The do-while loop is a powerful looping structure used when a block of code must execute at least one time before condition checking. It is widely used in menu-driven applications, login systems, user input validation, and interactive programs. Understanding the difference between while and do-while is essential for choosing the correct looping structure in real-world Java applications.
