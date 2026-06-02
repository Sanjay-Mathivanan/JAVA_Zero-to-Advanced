# While Loop in Java

## Introduction

In programming, many tasks require repetition.

Examples:

- Reading user input until a valid value is entered
- Processing data from a file
- Running a game loop
- Repeating calculations

Java provides several looping structures:

```text
for Loop
while Loop
do-while Loop
```

The **while loop** is commonly used when the number of iterations is unknown before execution.

---

# What is a While Loop?

## Definition

A while loop repeatedly executes a block of code as long as a specified condition remains true.

Unlike a for loop, a while loop focuses primarily on the condition.

---

# Real-World Analogy

Imagine filling a water tank.

```text
Tank Full?
    ↓
   No
    ↓
Continue Filling
    ↓
Check Again
```

The process continues until:

```text
Tank Full = Yes
```

Similarly, a while loop continues until its condition becomes false.

---

# Why Use a While Loop?

Suppose we want to print numbers from:

```text
1 to 5
```

Using repeated statements:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

This is inefficient.

A while loop performs the repetition automatically.

---

# Syntax

```java
while(condition) {

    // code block

}
```

---

# Components of While Loop

```java
while(i <= 5)
```

| Part | Purpose |
|--------|----------|
| while | Loop keyword |
| i <= 5 | Condition |
| { } | Loop body |

---

# How While Loop Works

```text
Check Condition
       ↓
Condition True?
       ↓
Execute Body
       ↓
Update Variable
       ↓
Check Condition Again
```

---

# Flow Diagram

```text
Condition
    ↓
 ┌──┴──┐
 │     │
True False
 │     │
Body  Exit
 │
Update
 │
 └─────┘
```

---

# First While Loop Program

```java
public class Main {

    public static void main(String[] args) {

        int i = 1;

        while(i <= 5) {

            System.out.println(i);

            i++;
        }
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

Condition:

```java
i <= 5
```

Result:

```text
true
```

Print:

```text
1
```

Update:

```java
i++
```

---

## Step 2

```java
i = 2
```

Condition:

```text
2 <= 5
```

True.

Print:

```text
2
```

---

Process continues until:

```java
i = 6
```

Condition:

```text
6 <= 5
```

False.

Loop terminates.

---

# Memory Representation

Initial:

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

After each iteration:

```text
i → 2
i → 3
i → 4
i → 5
i → 6
```

Loop exits when condition becomes false.

---

# Example: Print Numbers from 10 to 1

```java
public class Main {

    public static void main(String[] args) {

        int i = 10;

        while(i >= 1) {

            System.out.println(i);

            i--;
        }
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

# Example: Print Even Numbers

```java
public class Main {

    public static void main(String[] args) {

        int i = 2;

        while(i <= 20) {

            System.out.println(i);

            i += 2;
        }
    }
}
```

---

# Output

```text
2
4
6
8
10
12
14
16
18
20
```

---

# Example: Sum of First 10 Numbers

```java
public class Main {

    public static void main(String[] args) {

        int i = 1;
        int sum = 0;

        while(i <= 10) {

            sum += i;

            i++;
        }

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

# Example: User Login Attempts

```java
public class Main {

    public static void main(String[] args) {

        int attempts = 1;

        while(attempts <= 3) {

            System.out.println(
                    "Login Attempt "
                    + attempts);

            attempts++;
        }
    }
}
```

---

# Output

```text
Login Attempt 1
Login Attempt 2
Login Attempt 3
```

---

# Infinite While Loop

```java
while(true) {

    System.out.println("Running");

}
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

# Why Infinite Loops Occur

Missing update:

```java
int i = 1;

while(i <= 5) {

    System.out.println(i);

}
```

Problem:

```java
i never changes
```

Condition always remains true.

---

# Comparison: For Loop vs While Loop

## For Loop

```java
for(int i = 1; i <= 5; i++)
```

Everything in one line.

Best when iterations are known.

---

## While Loop

```java
int i = 1;

while(i <= 5)
```

Best when iterations are unknown.

---

# Example: Prime Number Search Using While

```java
public class Main {

    public static void main(String[] args) {

        int number = 2;

        while(number <= 20) {

            System.out.println(number);

            number++;
        }
    }
}
```

---

# Output

```text
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20
```

---

# Real-World Applications

## ATM Machine

```text
Keep Asking PIN
Until Correct PIN Entered
```

---

## Online Forms

```text
Keep Asking
Until Valid Input Provided
```

---

## Games

```text
Run Game
Until User Quits
```

---

## File Reading

```text
Read Data
Until End of File
```

---

# Common Mistakes

## Forgetting Update Statement

Wrong:

```java
while(i <= 5) {

}
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

Loop never executes.

---

## Semicolon Mistake

Wrong:

```java
while(i <= 5);
{
    System.out.println(i);
}
```

Creates unintended behavior.

---

# Concept Map

```text
Loops
 │
 ├── For Loop
 │
 ├── While Loop
 │      │
 │      ├── Condition
 │      ├── Body
 │      └── Update
 │
 └── Do While Loop
```

---

# Interview Questions

## What is a while loop?

A loop that executes while a condition remains true.

---

## When should you use a while loop?

When the number of iterations is unknown.

---

## Can a while loop execute zero times?

Yes.

If the condition is false initially.

---

## Can a while loop become infinite?

Yes.

If the condition never becomes false.

---

## Difference between for and while?

For loops are best for known iterations.

While loops are best for unknown iterations.

---

# Practice Challenges

## Challenge 1

Print numbers from 1 to 50.

---

## Challenge 2

Print even numbers between 1 and 100.

---

## Challenge 3

Find the sum of numbers from 1 to 100.

---

## Challenge 4

Print multiplication table of 9 using while.

---

## Challenge 5

Count numbers from 100 to 1.

---

# Key Takeaways

- While loops execute as long as a condition is true.
- The condition is checked before execution.
- The loop may execute zero times.
- Updates are essential to avoid infinite loops.
- Best used when the number of iterations is unknown.
- Widely used in input validation and real-world applications.

---

# Conclusion

The while loop is a fundamental control flow structure in Java that enables repeated execution based on a condition. Unlike the for loop, it is ideal when the number of repetitions is not known beforehand. Mastering while loops is essential for handling user input, file processing, validation systems, and many real-world programming tasks.
