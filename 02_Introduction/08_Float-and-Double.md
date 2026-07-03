# Float and Double in Java

This guide details the specifications, formatting, precision differences, and binary division characteristics of floating-point representations (`float` and `double`) in Java.

---

## Introduction

In Java, decimal fractional values are represented using floating-point data types. The JVM implements these based on the IEEE 754 standard for binary floating-point arithmetic.

Java provides two primitive types for decimals:
* `float`: Single-precision 32-bit floating-point type.
* `double`: Double-precision 64-bit floating-point type.

---

## Technical Specifications and Limits

This program demonstrates how to fetch the exact limit values of floating-point variables:

```java
public class FloatingLimits {
    public static void main(String[] args) {
        float floatMax = Float.MAX_VALUE;
        float floatMin = Float.MIN_VALUE; // Smallest positive non-zero value

        double doubleMax = Double.MAX_VALUE;
        double doubleMin = Double.MIN_VALUE; // Smallest positive non-zero value

        System.out.println("Float Max:  " + floatMax);
        System.out.println("Float Min:  " + floatMin);
        System.out.println("Double Max: " + doubleMax);
        System.out.println("Double Min: " + doubleMin);
    }
}
```

### Output
```text
Float Max:  3.4028235E38
Float Min:  1.4E-45
Double Max: 1.7976931348623157E308
Double Min: 4.9E-324
```

### Scientific Notation
The character `E` represents a power of ten. For example:
* `3.4028235E38` means $3.4028235 \times 10^{38}$.
* `1.4E-45` means $1.4 \times 10^{-45}$.

---

## Comparison of Properties

| Property | float | double |
| :--- | :--- | :--- |
| **Size** | 4 Bytes (32 bits) | 8 Bytes (64 bits) |
| **IEEE Standard** | Single Precision (32-bit) | Double Precision (64-bit) |
| **Significant Digits** | ~6 to 7 decimal digits | ~15 to 16 decimal digits |
| **Literal Suffix** | Requires `f` or `F` (e.g., `1.5f`) | Optional `d` or `D` (default type) |
| **Performance** | Faster on older 32-bit CPUs | Standard on modern 64-bit CPUs |

---

## Precision Loss Demonstration

Because floating-point numbers represent fractions in base-2 (binary) memory, they cannot represent certain base-10 fractions (like `0.1`) exactly. This causes rounding errors.

```java
public class PrecisionDemo {
    public static void main(String[] args) {
        float fValue = 5.123456789f;
        double dValue = 5.123456789;

        System.out.println("Float value:  " + fValue);
        System.out.println("Double value: " + dValue);
    }
}
```

### Output
```text
Float value:  5.123457
Double value: 5.123456789
```
* **Explanation**: The `float` variable truncates or rounds the value after the 7th digit due to its 32-bit limit, while the `double` variable preserves the full string.

---

## Floating-Point Arithmetic Division Behaviors

Be careful not to mix integer and floating-point division rules:

```java
public class DivisionDemo {
    public static void main(String[] args) {
        int intDiv = 5 / 2;
        float floatDiv = 5f / 2f;
        double mixedDiv = 5 / 2.0;

        System.out.println("Integer Division (5 / 2):     " + intDiv);
        System.out.println("Float Division (5f / 2f):     " + floatDiv);
        System.out.println("Double Division (5 / 2.0):    " + mixedDiv);
    }
}
```

### Output
```text
Integer Division (5 / 2):     2
Float Division (5f / 2f):     2.5
Double Division (5 / 2.0):    2.5
```
* **Integer Division**: Discards the remainder (fractional part) and returns an integer.
* **Mixed Division**: If at least one operand is a decimal, the other is promoted to a decimal, resulting in fractional division.

---

## Best Practices

* **Default to double**: For standard mathematical calculations, use `double` to minimize precision loss.
* **Do not use for currency**: Never use `float` or `double` to represent money, as rounding errors accumulate quickly. Use `java.math.BigDecimal` or store values as integer cents instead.
* **Avoid direct comparisons**: Do not use the equality operator `==` to compare floating-point values. Instead, check if the difference is smaller than a tiny tolerance value (epsilon).
  ```java
  double a = 0.3;
  double b = 0.1 + 0.2;
  double epsilon = 0.00001;
  boolean isEqual = Math.abs(a - b) < epsilon;
  ```

---

**Back to Module Home:** [Introduction to Java Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/02_Introduction/README.md)
