# Method Practice Challenges

## Introduction

The best way to master methods is through practice.

In this chapter, you will solve real-world problems using:

- Method creation
- Parameters
- Return values
- Conditional logic
- Mathematical calculations

Each challenge focuses on designing reusable methods and applying problem-solving skills.

---

# Challenge 1: Weight Converter

## Problem Statement

Create a method that converts pounds into kilograms.

Formula:

```text
Kilograms = Pounds × 0.45359237
```

---

## Method Signature

```java
public static double toKilograms(double pounds)
```

---

## Example

### Input

```text
10 pounds
```

### Output

```text
4.5359237 kg
```

---

# Challenge 2: MegaBytes Converter

## Problem Statement

Create a method that converts kilobytes into:

- Megabytes
- Remaining Kilobytes

Formula:

```text
1 MB = 1024 KB
```

---

## Example

### Input

```text
2500 KB
```

### Output

```text
2 MB and 452 KB
```

---

## Hint

Use:

```java
/
```

and

```java
%
```

operators.

---

# Challenge 3: Barking Dog

## Problem Statement

A dog is barking.

You wake up if:

- The dog is barking
- The hour is before 8 AM
- The hour is after 10 PM

Create a method that returns:

```java
true
```

if you should wake up.

---

## Method Signature

```java
public static boolean shouldWakeUp(
        boolean barking,
        int hourOfDay)
```

---

## Example

### Input

```java
shouldWakeUp(true, 2)
```

### Output

```text
true
```

---

### Input

```java
shouldWakeUp(true, 12)
```

### Output

```text
false
```

---

# Challenge 4: Pythagorean Triplet

## Problem Statement

Check whether three numbers form a Pythagorean Triplet.

Formula:

```text
a² + b² = c²
```

---

## Example

### Input

```text
3 4 5
```

### Output

```text
true
```

Because:

```text
3² + 4² = 5²

9 + 16 = 25
```

---

## Method Signature

```java
public static boolean isPythagoreanTriplet(
        int a,
        int b,
        int c)
```

---

# Challenge 5: Decimal Comparator

## Problem Statement

Compare two decimal numbers up to three decimal places.

---

## Example

### Input

```text
3.1756
3.175
```

### Output

```text
true
```

Reason:

```text
3.175 == 3.175
```

up to three decimal places.

---

## Method Signature

```java
public static boolean areEqualByThreeDecimalPlaces(
        double first,
        double second)
```

---

# Challenge 6: Equal Product Checker

## Problem Statement

Check whether:

```text
a × b = c
```

---

## Example

### Input

```text
2 3 6
```

### Output

```text
true
```

---

### Input

```text
4 5 10
```

### Output

```text
false
```

---

## Method Signature

```java
public static boolean hasEqualProduct(
        int a,
        int b,
        int c)
```

---

# Challenge 7: Teen Number Checker

## Problem Statement

A number is considered a teen if it lies between:

```text
13 and 19
```

inclusive.

Create a method that checks whether at least one number is a teen.

---

## Example

### Input

```text
9 13 20
```

### Output

```text
true
```

---

### Input

```text
22 25 30
```

### Output

```text
false
```

---

## Method Signature

```java
public static boolean hasTeen(
        int a,
        int b,
        int c)
```

---

# Learning Goals

After completing these challenges, you should be able to:

- Design methods independently
- Pass parameters correctly
- Return values from methods
- Use conditional statements
- Build reusable logic
- Solve interview-style problems

---

# Challenge Difficulty Progression

```text
Weight Converter
        ↓
MegaBytes Converter
        ↓
Barking Dog
        ↓
Pythagorean Triplet
        ↓
Decimal Comparator
        ↓
Equal Product Checker
        ↓
Teen Number Checker
```

---

# Key Takeaways

- Methods simplify problem solving.
- Small methods are easier to test and debug.
- Return values allow reusable logic.
- Real-world applications are built using many small methods.
- Consistent practice develops strong programming skills.
