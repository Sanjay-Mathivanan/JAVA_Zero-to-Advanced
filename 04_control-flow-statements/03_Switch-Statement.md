# Switch Statement in Java

## Introduction

In the previous chapters, we used:

- if
- if-else

to make decisions.

These statements work well when there are only a few conditions.

However, when a program needs to compare one variable against many possible values, using multiple `if-else` statements becomes difficult to read and maintain.

Java provides the:

```java
switch
```

statement to simplify such situations.

The switch statement is a multi-way decision-making structure that selects one block of code from many possible options.

---

# What is a Switch Statement?

## Definition

A switch statement allows a program to execute different code blocks based on the value of a variable or expression.

Instead of checking multiple conditions using `if-else-if`, Java directly jumps to the matching case.

---

# Real-World Analogy

Think of an elevator.

```text
Press Floor Number
        ↓
   Elevator Checks
        ↓
 ┌───────────────┐
 │ 1 → Ground    │
 │ 2 → Office    │
 │ 3 → Cafeteria │
 │ 4 → Parking   │
 └───────────────┘
```

The elevator chooses one destination based on the selected floor.

Similarly, a switch statement selects one block based on a value.

---

# Why Use Switch?

Consider:

```java
int day = 3;
```

Using if-else:

```java
if(day == 1)
{
    System.out.println("Monday");
}
else if(day == 2)
{
    System.out.println("Tuesday");
}
else if(day == 3)
{
    System.out.println("Wednesday");
}
```

As options increase, the code becomes lengthy.

Switch provides a cleaner solution.

---

# Syntax

```java
switch(expression)
{
    case value1:
        // code
        break;

    case value2:
        // code
        break;

    default:
        // code
}
```

---

# Components of Switch Statement

```java
switch(day)
```

| Part | Purpose |
|--------|----------|
| switch | Decision keyword |
| day | Expression |
| case | Possible value |
| break | Exit switch |
| default | Executes if no match found |

---

# First Example

```java
public class Main {

    public static void main(String[] args) {

        int day = 3;

        switch(day) {

            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Wednesday");
                break;

            default:
                System.out.println("Invalid Day");

        }
    }
}
```

---

# Output

```text
Wednesday
```

---

# Step-by-Step Execution

## Step 1

Variable:

```java
day = 3
```

---

## Step 2

Switch checks:

```java
case 1
```

No match.

---

## Step 3

Checks:

```java
case 2
```

No match.

---

## Step 4

Checks:

```java
case 3
```

Match found.

---

## Step 5

Executes:

```java
System.out.println("Wednesday");
```

---

## Step 6

```java
break;
```

exits the switch block.

---

# Internal Working

```text
Switch Expression
        ↓
Compare with Cases
        ↓
Matching Case Found
        ↓
Execute Code
        ↓
Break Statement
        ↓
Exit Switch
```

---

# Flow Diagram

```text
Switch Expression
        ↓
 ┌─────────────┐
 │ Compare     │
 │ Each Case   │
 └──────┬──────┘
        ↓
 Match Found?
        ↓
     Yes
        ↓
 Execute Case
        ↓
 Break
        ↓
 Exit
```

---

# Example: Month Names

```java
public class Main {

    public static void main(String[] args) {

        int month = 5;

        switch(month) {

            case 1:
                System.out.println("January");
                break;

            case 2:
                System.out.println("February");
                break;

            case 3:
                System.out.println("March");
                break;

            case 4:
                System.out.println("April");
                break;

            case 5:
                System.out.println("May");
                break;

            default:
                System.out.println("Invalid Month");
        }
    }
}
```

---

# Output

```text
May
```

---

# Example: Character Switch

```java
public class Main {

    public static void main(String[] args) {

        char grade = 'A';

        switch(grade) {

            case 'A':
                System.out.println("Excellent");
                break;

            case 'B':
                System.out.println("Good");
                break;

            case 'C':
                System.out.println("Average");
                break;

            default:
                System.out.println("Unknown Grade");
        }
    }
}
```

---

# Output

```text
Excellent
```

---

# Example: String Switch

Java supports Strings inside switch statements.

```java
public class Main {

    public static void main(String[] args) {

        String role = "Admin";

        switch(role) {

            case "Admin":
                System.out.println("Full Access");
                break;

            case "User":
                System.out.println("Limited Access");
                break;

            default:
                System.out.println("Guest Access");
        }
    }
}
```

---

# Output

```text
Full Access
```

---

# What is Break?

The break statement immediately exits the switch block.

Example:

```java
case 1:
    System.out.println("Monday");
    break;
```

Without break:

Java continues executing the next cases.

---

# Fall Through Example

```java
public class Main {

    public static void main(String[] args) {

        int day = 1;

        switch(day) {

            case 1:
                System.out.println("Monday");

            case 2:
                System.out.println("Tuesday");

            case 3:
                System.out.println("Wednesday");
        }
    }
}
```

---

# Output

```text
Monday
Tuesday
Wednesday
```

---

# Why?

Because there is no:

```java
break;
```

statement.

This behavior is called:

```text
Fall Through
```

---

# Default Case

The default block executes when no case matches.

Example:

```java
int day = 10;
```

```java
default:
    System.out.println("Invalid Day");
```

---

# Output

```text
Invalid Day
```

---

# Memory Representation

```java
int day = 2;
```

Stack Memory:

```text
Stack Memory
-------------------
day → 2
-------------------
```

Switch reads:

```text
2
```

and jumps directly to:

```java
case 2
```

---

# Switch vs If-Else

| Feature | Switch | If-Else |
|----------|----------|----------|
| Multiple Fixed Values | Excellent | Good |
| Range Checking | No | Yes |
| Readability | Better | Moderate |
| Complex Conditions | Limited | Excellent |

---

# When to Use Switch

Use switch when:

- Comparing fixed values
- Menu-driven programs
- Day selection
- Month selection
- User role management
- Calculator operations

---

# Common Mistakes

## Missing Break

Wrong:

```java
case 1:
    System.out.println("One");
```

May cause unwanted fall-through.

---

## Duplicate Cases

Wrong:

```java
case 1:
case 1:
```

Compiler Error.

---

## Using Unsupported Types

Wrong:

```java
double number = 10.5;

switch(number)
```

Switch does not support double.

---

# Supported Types in Switch

```java
byte
short
int
char
String
enum
```

---

# Concept Map

```text
Switch Statement
        │
        ▼
   Expression
        │
        ▼
      Cases
        │
 ┌──────┼──────┐
 │      │      │
Case1 Case2 Case3
 │      │      │
Break Break Break
        │
        ▼
      Default
```

---

# Interview Questions

## What is a switch statement?

A control flow statement used to select one block of code from multiple options.

---

## Why is break used?

To exit the switch block.

---

## What happens if break is omitted?

Fall-through occurs.

---

## What is the default case?

A block that executes when no case matches.

---

## Can switch work with Strings?

Yes.

---

# Practice Challenges

## Challenge 1

Create a program that displays month names using switch.

---

## Challenge 2

Create a simple calculator using switch.

---

## Challenge 3

Display grade descriptions:

```text
A → Excellent
B → Good
C → Average
```

---

## Challenge 4

Create a menu-driven food ordering system.

---

## Challenge 5

Display the day of the week using switch.

---

# Key Takeaways

- Switch simplifies multiple-value decision making.
- It is cleaner than long if-else chains.
- Break prevents fall-through.
- Default handles unmatched values.
- Switch improves readability and maintainability.
- Best suited for fixed-value comparisons.

---

# Conclusion

The switch statement is an efficient decision-making structure used when a variable can have multiple predefined values. It provides cleaner and more readable code than long if-else chains and is widely used in menus, calculators, role management systems, and many real-world Java applications.
