# Method Challenge Solutions

## Introduction

This chapter contains reference solutions for the method practice challenges.

Try solving each challenge on your own before reviewing these solutions.

---

# Solution 1: Weight Converter

## Problem

Convert pounds into kilograms.

Formula:

```text
1 pound = 0.45359237 kilograms
```

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        double kilograms = toKilograms(10);

        System.out.println(kilograms);
    }

    public static double toKilograms(double pounds) {

        return pounds * 0.45359237;

    }
}
```

### Output

```text
4.5359237
```

---

# Solution 2: MegaBytes Converter

## Problem

Convert kilobytes into megabytes and remaining kilobytes.

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        printMegaBytesAndKiloBytes(2500);

    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {

        int megaBytes = kiloBytes / 1024;
        int remainingKB = kiloBytes % 1024;

        System.out.println(
                megaBytes +
                " MB and " +
                remainingKB +
                " KB");

    }
}
```

### Output

```text
2 MB and 452 KB
```

---

# Solution 3: Barking Dog

## Problem

Determine whether you should wake up.

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                shouldWakeUp(true, 2));

    }

    public static boolean shouldWakeUp(
            boolean barking,
            int hourOfDay) {

        if(hourOfDay < 0 || hourOfDay > 23) {

            return false;

        }

        return barking &&
                (hourOfDay < 8 ||
                 hourOfDay > 22);
    }
}
```

### Output

```text
true
```

---

# Solution 4: Pythagorean Triplet

## Problem

Check whether three numbers form a Pythagorean triplet.

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                isPythagoreanTriplet(3,4,5));

    }

    public static boolean isPythagoreanTriplet(
            int a,
            int b,
            int c) {

        return (a * a) +
               (b * b) ==
               (c * c);

    }
}
```

### Output

```text
true
```

---

# Solution 5: Decimal Comparator

## Problem

Compare two decimal values up to three decimal places.

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                areEqualByThreeDecimalPlaces(
                        3.1756,
                        3.175));

    }

    public static boolean
    areEqualByThreeDecimalPlaces(
            double first,
            double second) {

        int firstNumber =
                (int)(first * 1000);

        int secondNumber =
                (int)(second * 1000);

        return firstNumber ==
                secondNumber;

    }
}
```

### Output

```text
true
```

---

# Solution 6: Equal Product Checker

## Problem

Check whether:

```text
a × b = c
```

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                hasEqualProduct(
                        2,
                        3,
                        6));

    }

    public static boolean hasEqualProduct(
            int a,
            int b,
            int c) {

        return (a * b) == c;

    }
}
```

### Output

```text
true
```

---

# Solution 7: Teen Number Checker

## Problem

Check whether at least one number is a teen.

---

## Solution

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(
                hasTeen(
                        9,
                        13,
                        20));

    }

    public static boolean hasTeen(
            int a,
            int b,
            int c) {

        return isTeen(a) ||
               isTeen(b) ||
               isTeen(c);

    }

    public static boolean isTeen(int number) {

        return number >= 13 &&
               number <= 19;

    }
}
```

### Output

```text
true
```

---

# Concepts Practiced

These challenges cover:

- Method Creation
- Parameters
- Return Values
- Conditional Statements
- Mathematical Calculations
- Boolean Logic
- Method Reusability
- Problem Decomposition

---

# Key Takeaways

- Methods allow code reuse.
- Parameters make methods flexible.
- Return values provide results to callers.
- Boolean methods are commonly used for validations.
- Complex programs are built from many small methods.

---

# Conclusion

These exercises demonstrate how methods can be used to solve practical programming problems. Mastering method design, parameter passing, and return values is essential before moving to advanced topics such as method overloading, recursion, and object-oriented programming.
