# For Loop in Java

## Introduction

In programming, there are situations where the same task must be performed repeatedly.

Examples:

- Printing numbers from 1 to 100
- Displaying multiplication tables
- Processing student records
- Iterating through arrays
- Generating reports

Writing the same statement multiple times is inefficient.

Java solves this problem using:

```java
for
```

loops.

A `for` loop allows a block of code to execute repeatedly for a specified number of times.

---

# What is a For Loop?

## Definition

A for loop is a control flow statement used to repeatedly execute a block of code until a specified condition becomes false.

---

# Real-World Analogy

Imagine a teacher taking attendance.

```text
Student 1
Student 2
Student 3
...
Student 50
```

Instead of manually repeating the process 50 times, the teacher follows a repetitive procedure.

Similarly, a for loop automates repetitive tasks.

---

# Why Do We Need Loops?

Without loops:

```java
System.out.println(1);
System.out.println(2);
System.out.println(3);
System.out.println(4);
System.out.println(5);
```

This becomes impractical for large numbers.

With a loop:

```java
for(int i = 1; i <= 5; i++) {

    System.out.println(i);

}
```

Cleaner and more efficient.

---

# Syntax of For Loop

```java
for(initialization; condition; update) {

    // code block

}
```

---

# Components of a For Loop

```java
for(int i = 1; i <= 5; i++)
```

| Part | Purpose |
|--------|----------|
| int i = 1 | Initialization |
| i <= 5 | Condition |
| i++ | Update |
| { } | Loop Body |

---

# How a For Loop Works

```text
Initialization
      ↓
Check Condition
      ↓
Condition True?
      ↓
Execute Body
      ↓
Update Variable
      ↓
Repeat
```

---

# Flow Diagram

```text
Initialization
      ↓
Condition
      ↓
 ┌────┴────┐
 │         │
True     False
 │         │
Body     Exit
 │
Update
 │
 └─────────┘
```

---

# First For Loop Program

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1; i <= 5; i++) {

            System.out.println(i);

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

## Iteration 1

Initialization:

```java
i = 1
```

Condition:

```java
1 <= 5
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

New value:

```java
i = 2
```

---

## Iteration 2

Condition:

```java
2 <= 5
```

Print:

```text
2
```

Update:

```java
i = 3
```

---

The process continues until:

```java
i = 6
```

Condition:

```java
6 <= 5
```

Result:

```text
false
```

Loop terminates.

---

# Memory Representation

During execution:

```java
for(int i = 1; i <= 5; i++)
```

Stack Memory:

```text
Stack Memory
----------------
i → 1
----------------
```

After first iteration:

```text
Stack Memory
----------------
i → 2
----------------
```

This continues until:

```text
i → 6
```

Loop ends.

---

# Printing Numbers from 1 to 10

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {

            System.out.println(i);

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
6
7
8
9
10
```

---

# Printing Numbers in Reverse

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 10; i >= 1; i--) {

            System.out.println(i);

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

# Printing Even Numbers

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 2; i <= 20; i += 2) {

            System.out.println(i);

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

# Printing Odd Numbers

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1; i <= 20; i += 2) {

            System.out.println(i);

        }
    }
}
```

---

# Output

```text
1
3
5
7
9
11
13
15
17
19
```

---

# Multiplication Table Example

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1; i <= 10; i++) {

            System.out.println(
                    "5 x " + i +
                    " = " + (5 * i));

        }
    }
}
```

---

# Output

```text
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
...
5 x 10 = 50
```

---

# Sum of First 10 Numbers

```java
public class Main {

    public static void main(String[] args) {

        int sum = 0;

        for(int i = 1; i <= 10; i++) {

            sum += i;

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

# Nested For Loop

A loop inside another loop is called a nested loop.

---

# Example

```java
public class Main {

    public static void main(String[] args) {

        for(int row = 1; row <= 3; row++) {

            for(int col = 1; col <= 3; col++) {

                System.out.print("* ");

            }

            System.out.println();

        }
    }
}
```

---

# Output

```text
* * *
* * *
* * *
```

---

# Nested Loop Visualization

```text
Row 1
 ├── Column 1
 ├── Column 2
 └── Column 3

Row 2
 ├── Column 1
 ├── Column 2
 └── Column 3

Row 3
 ├── Column 1
 ├── Column 2
 └── Column 3
```

---

# Infinite For Loop

A loop without a terminating condition.

Example:

```java
for(;;) {

    System.out.println("Running");

}
```

---

# Why Dangerous?

```text
Never Ends
Consumes CPU
May Freeze Program
```

---

# Common Mistakes

## Missing Update

Wrong:

```java
for(int i = 1; i <= 5;) {

    System.out.println(i);

}
```

Result:

```text
Infinite Loop
```

---

## Wrong Condition

Wrong:

```java
for(int i = 1; i >= 5; i++)
```

Output:

```text
Nothing
```

Condition is false initially.

---

## Using Semicolon

Wrong:

```java
for(int i = 1; i <= 5; i++);
{
    System.out.println("Hello");
}
```

Loop ends at semicolon.

---

# Real-World Applications

## Attendance System

```java
Process 50 Students
```

---

## Billing Software

```java
Process All Items
```

---

## Report Generation

```java
Generate Monthly Data
```

---

## Array Traversal

```java
Visit Every Element
```

---

# For Loop vs While Loop

| Feature | For Loop | While Loop |
|----------|----------|----------|
| Known Iterations | Best Choice | Possible |
| Unknown Iterations | Less Suitable | Best Choice |
| Compact Syntax | Yes | No |
| Readability | High | Moderate |

---

# Concept Map

```text
Loops
 │
 ├── For Loop
 │      │
 │      ├── Initialization
 │      ├── Condition
 │      ├── Update
 │      └── Body
 │
 └── Repetition
```

---

# Interview Questions

## What is a for loop?

A loop used to repeatedly execute code for a fixed number of iterations.

---

## What are the three parts of a for loop?

- Initialization
- Condition
- Update

---

## When does a for loop stop?

When the condition becomes false.

---

## Can a for loop be infinite?

Yes.

Example:

```java
for(;;)
```

---

## What is a nested loop?

A loop inside another loop.

---

# Practice Challenges

## Challenge 1

Print numbers from 1 to 50.

---

## Challenge 2

Print numbers from 50 to 1.

---

## Challenge 3

Print all even numbers between 1 and 100.

---

## Challenge 4

Generate multiplication table for 7.

---

## Challenge 5

Find sum of numbers from 1 to 100.

---

## Challenge 6

Print a square pattern using nested loops.

---

# Key Takeaways

- For loops automate repetitive tasks.
- A loop contains initialization, condition, and update.
- The loop continues while the condition remains true.
- Nested loops are used for patterns and multidimensional operations.
- Infinite loops occur when conditions never become false.
- For loops improve efficiency and reduce code duplication.

---

# Conclusion

The for loop is one of the most commonly used control flow structures in Java. It allows repetitive tasks to be performed efficiently and is essential for working with arrays, collections, reports, mathematical calculations, and pattern generation. Mastering the for loop is a fundamental step toward becoming proficient in Java programming.
