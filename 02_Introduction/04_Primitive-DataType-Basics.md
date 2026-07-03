# Primitive Data Types in Java

This guide details the characteristics, memory specifications, ranges, and execution behaviors of Java's eight primitive data types.

---

## Introduction

In Java, data types define the classification and constraint bounds of data that can be stored in a variable. Primitive data types are pre-defined by the language specifications and represent basic values. They are not objects and do not have methods.

---

## Characteristics of the Eight Primitive Types

Java defines eight primitive data types:

### 1. byte
* **Category**: Integer
* **Size**: 1 Byte (8 bits)
* **Default Value**: `0`
* **Range**: `-128` to `127` ($-2^7$ to $2^7 - 1$)
* **Use Case**: Useful for saving memory in large arrays, primarily in raw binary file handling or network streams.
```java
byte flag = 100;
```

### 2. short
* **Category**: Integer
* **Size**: 2 Bytes (16 bits)
* **Default Value**: `0`
* **Range**: `-32,768` to `32,767` ($-2^{15}$ to $2^{15} - 1$)
* **Use Case**: Rarely used in modern software; was historically used to save memory in memory-constrained devices.
```java
short distance = 5000;
```

### 3. int
* **Category**: Integer
* **Size**: 4 Bytes (32 bits)
* **Default Value**: `0`
* **Range**: `-2,147,483,648` to `2,147,483,647` ($-2^{31}$ to $2^{31} - 1$)
* **Use Case**: The default choice for integer values in loops, counters, and general arithmetic.
```java
int population = 150000;
```

### 4. long
* **Category**: Integer
* **Size**: 8 Bytes (64 bits)
* **Default Value**: `0L`
* **Range**: $-2^{63}$ to $2^{63} - 1$
* **Use Case**: Used when values exceed the limits of `int` (e.g., timestamps in milliseconds, high-precision astronomical distance values).
* **Note**: Literals must be suffixed with an `L` or `l` (uppercase `L` is preferred to avoid confusion with the number `1`).
```java
long milliseconds = 1718291029192L;
```

### 5. float
* **Category**: Floating-point
* **Size**: 4 Bytes (32 bits)
* **Default Value**: `0.0f`
* **Precision**: Single-precision (accurate to about 6-7 decimal digits)
* **Use Case**: Used to save memory in large arrays of floating-point numbers.
* **Note**: Literals must be suffixed with an `f` or `F`.
```java
float temperature = 98.6f;
```

### 6. double
* **Category**: Floating-point
* **Size**: 8 Bytes (64 bits)
* **Default Value**: `0.0d`
* **Precision**: Double-precision (accurate to about 15-16 decimal digits)
* **Use Case**: The default type for decimal values in Java.
```java
double interestRate = 5.43290123;
```

### 7. char
* **Category**: Character
* **Size**: 2 Bytes (16 bits unsigned)
* **Default Value**: `\u0000` (null character)
* **Range**: `0` to `65,535`
* **Use Case**: Stores a single character literal in UTF-16 Unicode format. Enclosed in single quotes.
```java
char grade = 'A';
```

### 8. boolean
* **Category**: Logical
* **Size**: Virtual machine dependent (usually 1 byte or 1 bit in JVM implementation)
* **Default Value**: `false`
* **Values**: Only `true` or `false`
* **Use Case**: Conditional evaluation flags.
```java
boolean isEligible = true;
```

---

## Memory Allocation for Primitives

Because primitives have fixed sizes, they are stored directly on the stack memory frame of the executing thread.

For example, when `int x = 10` is executed:
```text
Stack Frame:
[ x ] -> 00000000 00000000 00000000 00001010  (32 bits in memory)
```

---

## Overflow and Underflow Behaviors

Since primitive variables are represented in memory using fixed binary bit depths (using two's complement for signed numbers), exceeding limits results in wrap-around behaviors.

### Overflow
Occurs when an operation causes a numeric type to exceed its maximum limit, wrapping around to the minimum value.

```java
public class OverflowDemo {
    public static void main(String[] args) {
        int val = Integer.MAX_VALUE; // 2147483647
        System.out.println("Max: " + val);
        System.out.println("Max + 1: " + (val + 1)); // Outputs -2147483648
    }
}
```

### Underflow
Occurs when an operation causes a numeric type to fall below its minimum limit, wrapping around to the maximum value.

```java
public class UnderflowDemo {
    public static void main(String[] args) {
        int val = Integer.MIN_VALUE; // -2147483648
        System.out.println("Min: " + val);
        System.out.println("Min - 1: " + (val - 1)); // Outputs 2147483647
    }
}
```

---

## Best Practices

* **Use double over float**: Unless you are memory-constrained or working on graphics algorithms requiring massive arrays of single-precision decimals, default to `double` for precision.
* **Choose the correct data type**: Do not use `long` if values will easily fit into an `int`, as it doubles memory usage per variable.
* **Use uppercase L for long literals**: Avoid lowercase `l` because `100l` looks like the number `1001` in many console fonts.

---

**Back to Module Home:** [Introduction to Java Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/02_Introduction/README.md)
