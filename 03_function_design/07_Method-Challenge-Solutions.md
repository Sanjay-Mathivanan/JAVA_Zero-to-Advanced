# Method Challenge Solutions

This document contains reference implementations for the method practice challenges. Use these solutions to verify your work or research reference algorithms.

---

## Solution 1: Weight Converter

Converts pounds into kilograms using static arithmetic operations.

```java
public class WeightConverter {
    public static void main(String[] args) {
        double result = toKilograms(10.0);
        System.out.println("10 lbs in kg: " + result);
    }

    public static double toKilograms(double pounds) {
        if (pounds < 0) {
            return -1.0; // Return invalid marker for negative inputs
        }
        return pounds * 0.45359237;
    }
}
```

### Output
```text
10 lbs in kg: 4.5359237
```

---

## Solution 2: MegaBytes Converter

Demonstrates integer division (`/`) to find full Megabytes and remainder modulus (`%`) to retrieve leftover Kilobytes.

```java
public class MegaBytesConverter {
    public static void main(String[] args) {
        printMegaBytesAndKiloBytes(2500);
        printMegaBytesAndKiloBytes(-1024);
    }

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        if (kiloBytes < 0) {
            System.out.println("Invalid Value");
            return;
        }

        int megaBytes = kiloBytes / 1024;
        int remainingKB = kiloBytes % 1024;

        System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " + remainingKB + " KB");
    }
}
```

### Output
```text
2500 KB = 2 MB and 452 KB
Invalid Value
```

---

## Solution 3: Barking Dog

Evaluates time ranges using compound logical conditional operators (`&&`, `||`).

```java
public class BarkingDog {
    public static void main(String[] args) {
        System.out.println("Wake up? " + shouldWakeUp(true, 2));   // true
        System.out.println("Wake up? " + shouldWakeUp(true, 8));   // false
        System.out.println("Wake up? " + shouldWakeUp(false, 6));  // false
    }

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        // Range validation
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }

        // Logical evaluation
        return barking && (hourOfDay < 8 || hourOfDay > 22);
    }
}
```

### Output
```text
Wake up? true
Wake up? false
Wake up? false
```

---

## Solution 4: Pythagorean Triplet

Validates algebraic values using squaring logic.

```java
public class PythagoreanTriplet {
    public static void main(String[] args) {
        System.out.println("Is triplet? " + isPythagoreanTriplet(3, 4, 5));  // true
        System.out.println("Is triplet? " + isPythagoreanTriplet(5, 12, 13)); // true
        System.out.println("Is triplet? " + isPythagoreanTriplet(4, 5, 6));   // false
    }

    public static boolean isPythagoreanTriplet(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        return (a * a) + (b * b) == (c * c);
    }
}
```

### Output
```text
Is triplet? true
Is triplet? true
Is triplet? false
```

---

## Solution 5: Decimal Comparator

Multiplies deca-scales and applies integer type-casting truncation to check for partial equality matches.

```java
public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println("Equal? " + areEqualByThreeDecimalPlaces(3.1756, 3.175)); // true
        System.out.println("Equal? " + areEqualByThreeDecimalPlaces(3.176, 3.175));  // false
    }

    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {
        // Multiply by 1000 and cast to int to truncate decimals beyond the 3rd place
        int firstScaled = (int) (first * 1000);
        int secondScaled = (int) (second * 1000);

        return firstScaled == secondScaled;
    }
}
```

### Output
```text
Equal? true
Equal? false
```

---

## Solution 6: Equal Product Checker

Simple arithmetic verification.

```java
public class EqualProduct {
    public static void main(String[] args) {
        System.out.println("Product match? " + hasEqualProduct(2, 3, 6));  // true
        System.out.println("Product match? " + hasEqualProduct(4, 5, 10)); // false
    }

    public static boolean hasEqualProduct(int a, int b, int c) {
        return a * b == c;
    }
}
```

---

## Solution 7: Teen Number Checker

Validates boundaries against a defined range sequence.

```java
public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println("Has teen? " + hasTeen(9, 13, 20));  // true
        System.out.println("Has teen? " + hasTeen(22, 25, 30)); // false
    }

    public static boolean hasTeen(int a, int b, int c) {
        return isTeen(a) || isTeen(b) || isTeen(c);
    }

    // Helper method to keep logic DRY (Don't Repeat Yourself)
    public static boolean isTeen(int value) {
        return value >= 13 && value <= 19;
    }
}
```

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
