# Method Practice Challenges

This document lists practical coding challenges to master writing methods, handling parameter variables, executing logic returns, and resolving mathematical problems.

---

## Challenge Progression List

To build logic step-by-step, solve the challenges in the following sequence:

1. **Weight Converter**: Basic calculations and return mappings.
2. **MegaBytes Converter**: Arithmetic division and modulus operations.
3. **Barking Dog**: Compound boolean evaluation.
4. **Pythagorean Triplet**: Algebraic equations verification.
5. **Decimal Comparator**: Precision-sensitive type-casting constraints.
6. **Equal Product Checker**: Multi-operand arithmetic logic.
7. **Teen Number Checker**: Range validation checks.

---

## Challenge 1: Weight Converter

### Problem Statement
Write a method that converts weight values in pounds into kilograms and returns the output as a double.

### Formula
```text
Kilograms = Pounds * 0.45359237
```

### Method Signature
```java
public static double toKilograms(double pounds)
```

### Test Case Example
* **Input**: `10.0`
* **Output**: `4.5359237`

---

## Challenge 2: MegaBytes Converter

### Problem Statement
Write a method that accepts an integer parameter representing kilobytes (`KB`) and prints a formatted console message mapping it to Megabytes (`MB`) and the remaining kilobytes (`KB`).
* If the input is negative, print `"Invalid Value"`.

### Formula
```text
1 MB = 1024 KB
```

### Method Signature
```java
public static void printMegaBytesAndKiloBytes(int kiloBytes)
```

### Test Case Example
* **Input**: `2500`
* **Output**: `"2500 KB = 2 MB and 452 KB"`

---

## Challenge 3: Barking Dog

### Problem Statement
We have a loud barking dog. We need to wake up if the dog is barking and the time is before 8:00 AM (`8`) or after 10:00 PM (`22`).
Write a method that returns `true` if we need to wake up, and `false` otherwise.
* The hour parameter must be in the range `0` to `23`. If it falls outside this range, return `false`.

### Method Signature
```java
public static boolean shouldWakeUp(boolean barking, int hourOfDay)
```

### Test Case Examples
* `shouldWakeUp(true, 1)`  -> Returns `true`
* `shouldWakeUp(true, 8)`  -> Returns `false` (not before 8 AM)
* `shouldWakeUp(false, 2)` -> Returns `false` (dog is not barking)

---

## Challenge 4: Pythagorean Triplet

### Problem Statement
Write a method that accepts three positive integers (`a`, `b`, `c`) and evaluates if they form a Pythagorean Triplet ($a^2 + b^2 = c^2$). Return `true` if they match the equation, and `false` otherwise.

### Method Signature
```java
public static boolean isPythagoreanTriplet(int a, int b, int c)
```

### Test Case Example
* `isPythagoreanTriplet(3, 4, 5)` -> Returns `true` ($3^2 + 4^2 = 5^2$)

---

## Challenge 5: Decimal Comparator

### Problem Statement
Write a method that accepts two double-precision decimal numbers and checks if they are equal up to three decimal places. Return `true` if they match, and `false` otherwise.
* **Hint**: You can multiply by `1000` and cast to `int` to drop the remaining decimals before comparing.

### Method Signature
```java
public static boolean areEqualByThreeDecimalPlaces(double first, double second)
```

### Test Case Examples
* `areEqualByThreeDecimalPlaces(3.1756, 3.175)`  -> Returns `true` (both match `3.175` up to 3 places)
* `areEqualByThreeDecimalPlaces(3.176, 3.175)`   -> Returns `false`

---

## Challenge 6: Equal Product Checker

### Problem Statement
Write a method that accepts three integer parameters and checks if the product of the first two numbers equals the third number. Return `true` if it does, and `false` otherwise.

### Method Signature
```java
public static boolean hasEqualProduct(int a, int b, int c)
```

### Test Case Examples
* `hasEqualProduct(2, 3, 6)`  -> Returns `true` ($2 \times 3 = 6$)
* `hasEqualProduct(4, 5, 10)` -> Returns `false`

---

## Challenge 7: Teen Number Checker

### Problem Statement
A number is considered a "teen" if it lies in the range `13` to `19` (inclusive).
Write a method that accepts three integer parameters and returns `true` if at least one of the parameters is in the teen range, and `false` otherwise.

### Method Signature
```java
public static boolean hasTeen(int a, int b, int c)
```

### Test Case Examples
* `hasTeen(9, 13, 20)`  -> Returns `true` (since `13` is in range)
* `hasTeen(22, 25, 30)` -> Returns `false`

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
