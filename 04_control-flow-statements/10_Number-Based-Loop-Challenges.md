# Number-Based Loop Challenges in Java

## Introduction

This chapter focuses on solving practical number-based problems using:

- Methods
- While Loops
- For Loops
- Conditional Statements
- Modulo Operator (`%`)
- Integer Division (`/`)

These challenges are frequently asked in Java interviews because they test logical thinking, loop control, and problem-solving skills.

---

# Concepts Covered

```text
Methods
   │
   ├── Input Validation
   │
   ├── Number Manipulation
   │
   ├── Digit Extraction
   │
   ├── Loop Traversal
   │
   └── Mathematical Computations
```

---

# Challenge 1: Sum of First and Last Digit

## Problem Statement

Write a method that returns the sum of the first and last digit of a number.

### Example

Input:

```text
257
```

Output:

```text
9
```

Explanation:

```text
First Digit = 2
Last Digit = 7

2 + 7 = 9
```

---

## Solution

```java
public static int sumFirstAndLastDigit(int number) {

    if(number < 0) {
        return -1;
    }

    int lastDigit = number % 10;
    int firstDigit = number;

    while(firstDigit >= 10) {

        firstDigit /= 10;

    }

    return firstDigit + lastDigit;
}
```

---

## Internal Working

```text
257

Last Digit:
257 % 10 = 7

First Digit:
257 / 10 = 25
25 / 10 = 2

Result:
2 + 7 = 9
```

---

# Challenge 2: Sum of Odd Digits

## Problem Statement

Find the sum of all odd digits in a number.

### Example

Input:

```text
123456789
```

Output:

```text
25
```

Explanation:

```text
1 + 3 + 5 + 7 + 9 = 25
```

---

## Solution

```java
public static int oddSum(int number) {

    if(number < 0) {
        return -1;
    }

    int sum = 0;

    while(number != 0) {

        int digit = number % 10;

        if(digit % 2 != 0) {

            sum += digit;

        }

        number /= 10;
    }

    return sum;
}
```

---

## Internal Working

```text
12345

Digit 5 → Odd → Add
Digit 4 → Ignore
Digit 3 → Add
Digit 2 → Ignore
Digit 1 → Add

Total = 9
```

---

# Challenge 3: Shared Digit Checker

## Problem Statement

Given two two-digit numbers, determine whether they share at least one digit.

### Example

Input:

```text
12 23
```

Output:

```text
true
```

Because:

```text
12 → 1 | 2
23 → 2 | 3

Shared Digit = 2
```

---

## Solution

```java
public static boolean sharedDigit(
        int n1,
        int n2) {

    int left1 = n1 / 10;
    int right1 = n1 % 10;

    int left2 = n2 / 10;
    int right2 = n2 % 10;

    return left1 == left2 ||
           left1 == right2 ||
           right1 == left2 ||
           right1 == right2;
}
```

---

## Visualization

```text
12

1 | 2


23

2 | 3

Shared Digit Found
```

---

# Challenge 4: Greatest Common Divisor (GCD)

## Problem Statement

Find the Greatest Common Divisor of two numbers greater than 10.

---

## What is GCD?

The largest number that divides both numbers exactly.

### Example

Input:

```text
12 30
```

Factors of 12:

```text
1 2 3 4 6 12
```

Factors of 30:

```text
1 2 3 5 6 10 15 30
```

Common Factors:

```text
1 2 3 6
```

Greatest Common Divisor:

```text
6
```

---

## Solution

```java
public static int getGreatestCommonDivisor(
        int first,
        int second) {

    if(first < 10 || second < 10) {

        return -1;

    }

    int gcd = 1;

    for(int i = 1;
        i <= first && i <= second;
        i++) {

        if(first % i == 0 &&
           second % i == 0) {

            gcd = i;

        }
    }

    return gcd;
}
```

---

## Internal Working

```text
12 and 30

1 → Common
2 → Common
3 → Common
6 → Common

Largest = 6
```

---

# Complete Program

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                sumFirstAndLastDigit(257));

        System.out.println(
                oddSum(123456789));

        System.out.println(
                sharedDigit(12,23));

        System.out.println(
                getGreatestCommonDivisor(
                        12,
                        30));
    }

    public static int sumFirstAndLastDigit(int number) {

        if(number < 0)
            return -1;

        int lastDigit = number % 10;
        int firstDigit = number;

        while(firstDigit >= 10) {

            firstDigit /= 10;

        }

        return firstDigit + lastDigit;
    }

    public static int oddSum(int number) {

        if(number < 0)
            return -1;

        int sum = 0;

        while(number != 0) {

            int digit = number % 10;

            if(digit % 2 != 0) {

                sum += digit;

            }

            number /= 10;
        }

        return sum;
    }

    public static boolean sharedDigit(
            int n1,
            int n2) {

        int left1 = n1 / 10;
        int right1 = n1 % 10;

        int left2 = n2 / 10;
        int right2 = n2 % 10;

        return left1 == left2 ||
               left1 == right2 ||
               right1 == left2 ||
               right1 == right2;
    }

    public static int getGreatestCommonDivisor(
            int first,
            int second) {

        if(first < 10 || second < 10)
            return -1;

        int gcd = 1;

        for(int i = 1;
            i <= first && i <= second;
            i++) {

            if(first % i == 0 &&
               second % i == 0) {

                gcd = i;
            }
        }

        return gcd;
    }
}
```

---

# Expected Output

```text
9
25
true
6
```

---

# Common Patterns Learned

## Extract Last Digit

```java
number % 10
```

---

## Remove Last Digit

```java
number / 10
```

---

## Check Even Number

```java
number % 2 == 0
```

---

## Check Factor

```java
number % divisor == 0
```

---

# Real-World Applications

These concepts are used in:

- Banking Systems
- Digital Calculators
- Data Validation
- Cryptography
- Mathematical Software
- Coding Interviews

---

# Practice Challenges

1. Reverse a number.
2. Check palindrome number.
3. Count digits.
4. Find largest digit.
5. Find smallest digit.
6. Sum of even digits.
7. Product of digits.
8. Armstrong number check.
9. Perfect number check.
10. Prime digit sum.

---

# Key Takeaways

- `% 10` extracts the last digit.
- `/ 10` removes the last digit.
- Loops help process numbers digit by digit.
- Methods improve code organization.
- Number manipulation is a common interview topic.
- Combining loops and methods leads to reusable solutions.

---

# Conclusion

These challenges demonstrate how loops and methods can be combined to solve real-world number manipulation problems. Understanding digit extraction, divisibility, factor checking, and iterative processing builds a strong foundation for advanced algorithms and technical interviews.
