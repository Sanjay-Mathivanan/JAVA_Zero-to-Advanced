# For Loop Challenge 2: Sum of Even Numbers

## Introduction

In real-world applications, we often need to process a range of numbers and perform calculations only on numbers that satisfy specific conditions.

Examples:

- Sum of even transaction IDs
- Sum of even sensor readings
- Filtering data before calculations
- Mathematical computations

This challenge demonstrates how methods can work together with loops to solve such problems.

---

# Problem Statement

Create:

## Method 1

```java
isEven(int number)
```

This method should:

- Return `true` if the number is even
- Return `false` if the number is odd
- Return `false` if the number is less than or equal to 0

---

## Method 2

```java
sumEven(int start, int end)
```

This method should:

- Sum all even numbers in the range
- Use a for loop
- Call `isEven()` for validation
- Return the final sum

---

# Understanding Even Numbers

An even number is divisible by:

```text
2
```

without any remainder.

Examples:

```text
2
4
6
8
10
```

---

# Checking Even Numbers

Java uses the modulo operator:

```java
%
```

Example:

```java
8 % 2
```

Result:

```text
0
```

Even Number.

---

Example:

```java
7 % 2
```

Result:

```text
1
```

Odd Number.

---

# Method 1: isEven()

## Syntax

```java
public static boolean isEven(int number)
```

---

## Logic

```text
number <= 0
       ↓
Return false

Otherwise
       ↓
Check number % 2
       ↓
Even ?
       ↓
Return true
```

---

## Implementation

```java
public static boolean isEven(int number) {

    if(number <= 0) {

        return false;

    }

    return number % 2 == 0;
}
```

---

# Testing isEven()

```java
System.out.println(isEven(10));
```

Output:

```text
true
```

---

```java
System.out.println(isEven(7));
```

Output:

```text
false
```

---

```java
System.out.println(isEven(-4));
```

Output:

```text
false
```

---

# Method 2: sumEven()

## Syntax

```java
public static int sumEven(
        int start,
        int end)
```

---

# Validation Rules

The range is valid only if:

```text
start > 0
end > 0
end >= start
```

---

## Invalid Input

Example:

```java
sumEven(-1,100)
```

Output:

```text
-1
```

---

# Logic Flow

```text
Validate Input
       ↓
Create sum variable
       ↓
Loop from start to end
       ↓
Call isEven()
       ↓
Add even numbers
       ↓
Return sum
```

---

# Complete Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                sumEven(1,100));

        System.out.println(
                sumEven(-1,100));

        System.out.println(
                sumEven(10,10));

    }

    public static boolean isEven(int number) {

        if(number <= 0) {

            return false;

        }

        return number % 2 == 0;
    }

    public static int sumEven(
            int start,
            int end) {

        if(start <= 0 ||
           end <= 0 ||
           end < start) {

            return -1;
        }

        int sum = 0;

        for(int i = start;
            i <= end;
            i++) {

            if(isEven(i)) {

                sum += i;

            }
        }

        return sum;
    }
}
```

---

# Output

```text
2550
-1
10
```

---

# Example 1

## Input

```java
sumEven(1,10)
```

Even Numbers:

```text
2
4
6
8
10
```

Calculation:

```text
2 + 4 + 6 + 8 + 10
```

Result:

```text
30
```

---

# Example 2

## Input

```java
sumEven(10,10)
```

Only Number:

```text
10
```

Even?

```text
Yes
```

Result:

```text
10
```

---

# Example 3

## Input

```java
sumEven(-1,100)
```

Validation:

```text
start <= 0
```

Result:

```text
-1
```

---

# Internal Working

Consider:

```java
sumEven(1,10)
```

---

## Step 1

Validation succeeds.

---

## Step 2

```java
sum = 0
```

---

## Step 3

Loop Starts

```java
i = 1
```

---

## Step 4

Method Call

```java
isEven(1)
```

Returns:

```text
false
```

No addition.

---

## Step 5

```java
i = 2
```

Method Call:

```java
isEven(2)
```

Returns:

```text
true
```

Calculation:

```text
sum = 2
```

---

Process continues until:

```java
i = 10
```

Final:

```text
sum = 30
```

---

# Method Interaction Diagram

```text
main()
   ↓
sumEven()
   ↓
Loop
   ↓
isEven()
   ↓
true / false
   ↓
Add Number
   ↓
Return Sum
```

---

# Memory Representation

For:

```java
sumEven(1,10)
```

Stack:

```text
sumEven()
start → 1
end → 10
sum → 0
```

Loop:

```text
i → 1
i → 2
i → 3
...
i → 10
```

After completion:

```text
return 30
```

---

# Time Complexity

Loop:

```text
n
```

Iterations:

```text
end - start + 1
```

Complexity:

```text
O(n)
```

Efficient solution.

---

# Real-World Applications

This pattern appears in:

- Data filtering
- Transaction processing
- Statistical calculations
- Payroll systems
- Inventory analysis

---

# Common Mistakes

## Mistake 1

Ignoring Validation

Wrong:

```java
sumEven(-10,100)
```

May produce incorrect results.

---

## Mistake 2

Returning true for negative numbers

Wrong:

```java
-4 is even
```

Challenge requirements specify:

```java
number > 0
```

---

## Mistake 3

Forgetting to call isEven()

The challenge specifically requires:

```java
isEven()
```

to be used inside:

```java
sumEven()
```

---

# Challenge Extensions

## Challenge 1

Count total even numbers.

---

## Challenge 2

Count total odd numbers.

---

## Challenge 3

Find average of even numbers.

---

## Challenge 4

Find largest even number in a range.

---

# Interview Questions

## What does isEven() return?

A boolean value.

---

## Why use a separate method?

Improves reusability and readability.

---

## What is the time complexity?

```text
O(n)
```

---

## Why return -1?

Used as a sentinel value to indicate invalid input.

---

## Which operator checks even numbers?

```java
%
```

Modulo Operator.

---

# Key Takeaways

- Methods can work together to solve problems.
- Boolean methods are useful for validation.
- For loops efficiently process ranges.
- Input validation improves program reliability.
- Modulo operator is commonly used for even/odd checking.
- This challenge demonstrates method decomposition.

---

# Conclusion

This challenge shows how small reusable methods can be combined with loops to solve larger problems. By separating the logic into `isEven()` and `sumEven()`, the program becomes cleaner, easier to maintain, and more reusable. This design approach is commonly used in professional Java applications and technical interviews.
