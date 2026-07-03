# For Loop Challenge 1: Prime Number Finder

## Introduction

Prime numbers are one of the most important concepts in mathematics and programming.

Many algorithms in:

- Cryptography
- Security Systems
- Data Structures
- Competitive Programming

rely heavily on prime numbers.

This challenge uses:

- For Loops
- Nested Loops
- Methods
- Conditional Statements

to identify prime numbers.

---

# Problem Statement

Write a program that prints all prime numbers from:

```text
1 to 100
```

using a method.

---

# What is a Prime Number?

A prime number is a number that has exactly:

```text
Two Factors
```

1. 1
2. Itself

---

## Examples

### Prime Numbers

```text
2
3
5
7
11
13
17
```

---

### Non-Prime Numbers

```text
4
6
8
9
10
12
```

Because they have more than two factors.

---

# Factor Example

Consider:

```text
7
```

Factors:

```text
1
7
```

Total:

```text
2 Factors
```

Prime Number.

---

Consider:

```text
8
```

Factors:

```text
1
2
4
8
```

Total:

```text
4 Factors
```

Not Prime.

---

# Challenge Program

```java
public class ForLoopChallenge {

    public static void main(String args[]) {

        int n = 100;

        for(int i = 1; i < n; i++) {

            isPrime(i);

        }
    }

    public static void isPrime(int n) {

        int count = 0;

        for(int j = 1; j <= n; j++) {

            if(n % j == 0)

                count = count + 1;

        }

        if(count == 2)

            System.out.println(
                    n +
                    " Is a prime number");

    }
}
```

---

# Output

```text
2 Is a prime number
3 Is a prime number
5 Is a prime number
7 Is a prime number
11 Is a prime number
13 Is a prime number
...
97 Is a prime number
```

---

# Understanding the Program

The program contains two loops.

```text
Outer Loop
      ↓
Checks Numbers
1 to 99

Inner Loop
      ↓
Counts Factors
```

---

# Program Flow

```text
main()
   ↓
for loop
   ↓
isPrime(i)
   ↓
factor counting
   ↓
prime check
   ↓
print result
```

---

# Step 1: Outer Loop

```java
for(int i = 1; i < 100; i++)
```

Purpose:

```text
Generate numbers from 1 to 99
```

Values:

```text
1
2
3
4
5
...
99
```

---

# Step 2: Method Call

For each number:

```java
isPrime(i);
```

Example:

```java
isPrime(7);
```

---

# Step 3: Factor Counter

```java
int count = 0;
```

Purpose:

```text
Count total factors
```

---

# Step 4: Inner Loop

```java
for(int j = 1; j <= n; j++)
```

Checks:

```text
1
2
3
...
n
```

against:

```java
n
```

---

# Example: n = 7

Loop:

```text
j = 1
j = 2
j = 3
j = 4
j = 5
j = 6
j = 7
```

---

# Divisibility Check

Condition:

```java
if(n % j == 0)
```

Means:

```text
Does j divide n perfectly?
```

---

For:

```text
7 % 1 = 0
```

Factor Found.

Count:

```text
1
```

---

For:

```text
7 % 2 ≠ 0
```

Not a factor.

---

For:

```text
7 % 7 = 0
```

Factor Found.

Count:

```text
2
```

---

# Prime Verification

Condition:

```java
if(count == 2)
```

Why?

Because prime numbers have exactly:

```text
Two Factors
```

---

For:

```text
7
```

Count:

```text
2
```

Prime.

---

For:

```text
8
```

Count:

```text
4
```

Not Prime.

---

# Internal Working Diagram

```text
Number = 7
      ↓
Check All Numbers
1 to 7
      ↓
Factors Found
1 and 7
      ↓
Count = 2
      ↓
Prime Number
```

---

# Memory Representation

Example:

```java
isPrime(5);
```

Stack Memory:

```text
Stack
------------------
isPrime()
n → 5
count → 0
------------------
main()
------------------
```

After execution:

```text
Stack
------------------
main()
------------------
```

Method frame removed.

---

# Dry Run Example

## Number = 5

Factor Count:

```text
5 % 1 = 0
Count = 1

5 % 2 ≠ 0

5 % 3 ≠ 0

5 % 4 ≠ 0

5 % 5 = 0
Count = 2
```

Result:

```text
5 Is a prime number
```

---

# Time Complexity

Outer Loop:

```text
n
```

Inner Loop:

```text
n
```

Total:

```text
O(n²)
```

For:

```text
100
```

works fine.

For:

```text
1,000,000
```

becomes slow.

---

# Optimized Version

Instead of checking all numbers:

```java
public static boolean isPrime(int n) {

    if(n <= 1)
        return false;

    for(int i = 2; i < n; i++) {

        if(n % i == 0)

            return false;

    }

    return true;
}
```

---

# More Optimized Version

Check only up to:

```text
√n
```

```java
public static boolean isPrime(int n) {

    if(n <= 1)
        return false;

    for(int i = 2; i <= Math.sqrt(n); i++) {

        if(n % i == 0)

            return false;

    }

    return true;
}
```

---

# Real-World Applications

Prime numbers are used in:

- RSA Encryption
- Cyber Security
- Cryptography
- Hashing Algorithms
- Competitive Programming

---

# Common Mistakes

## Mistake 1

Treating 1 as Prime.

Wrong:

```text
1 is prime
```

Correct:

```text
1 is NOT prime
```

---

## Mistake 2

Using:

```java
count >= 2
```

Correct:

```java
count == 2
```

---

## Mistake 3

Forgetting factor counter reset.

Wrong:

```java
count declared outside method
```

Can produce incorrect results.

---

# Challenge Extensions

## Challenge 1

Print prime numbers from:

```text
1 to 500
```

---

## Challenge 2

Count total prime numbers between:

```text
1 to 100
```

---

## Challenge 3

Find largest prime number below:

```text
1000
```

---

## Challenge 4

Calculate sum of all prime numbers from:

```text
1 to 100
```

---

# Interview Questions

## What is a prime number?

A number having exactly two factors:
1 and itself.

---

## Why is 1 not prime?

Because it has only one factor.

---

## What is the time complexity of this solution?

```text
O(n²)
```

---

## How can it be optimized?

Check divisibility only up to:

```text
√n
```

---

## Which operator is used for factor checking?

```java
%
```

Modulo Operator.

---

# Key Takeaways

- Prime numbers have exactly two factors.
- Nested loops can be used for factor counting.
- Modulo operator helps identify factors.
- This solution uses O(n²) complexity.
- Prime number problems are common in coding interviews.
- Optimized solutions use √n instead of n.

---

# Conclusion

This challenge demonstrates how nested loops and methods can work together to solve mathematical problems. By counting factors and checking divisibility, the program identifies prime numbers efficiently for small ranges. Understanding prime number logic is essential because it frequently appears in interviews, competitive programming, and real-world security applications.
