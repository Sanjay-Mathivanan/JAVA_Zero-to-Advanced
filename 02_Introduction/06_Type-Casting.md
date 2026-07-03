# Type Casting in Java

This guide details the mechanisms of type casting in Java, including implicit widening, explicit narrowing, arithmetic promotion, and the technical implications of data truncation.

---

## What is Type Casting?

Type casting is the process of converting a value of one primitive data type into another. Because Java is strongly typed, variables must be compatible, or explicit conversion syntax must be applied.

Type casting is required when:
* Storing a value of one type into a variable of another type.
* Performing arithmetic calculations between variables of mismatched types.
* Optimizing memory allocations.

---

## Classifications of Type Casting

Type casting is divided into two primary categories depending on the sizes and capacities of the source and target types:

```text
Widening Casting (Implicit)
byte -> short -> char -> int -> long -> float -> double

Narrowing Casting (Explicit)
double -> float -> long -> int -> char -> short -> byte
```

---

## 1. Widening Casting (Implicit Conversion)

* **Definition**: Converting a smaller data type to a larger data type.
* **Safety**: Safe and automatic. No data truncation or precision loss occurs because the destination type has a larger storage size than the source type.
* **Mechanism**: Handled automatically by the JVM compiler.

### Code Example
```java
public class ImplicitCasting {
    public static void main(String[] args) {
        int intValue = 10;
        double doubleValue = intValue; // Automatic widening (int promoted to double)

        System.out.println("Integer value: " + intValue);
        System.out.println("Double value:  " + doubleValue);
    }
}
```

### Output
```text
Integer value: 10
Double value:  10.0
```

---

## 2. Narrowing Casting (Explicit Conversion)

* **Definition**: Converting a larger data type to a smaller data type.
* **Safety**: Unsafe. Can result in data truncation, precision loss, or sign-bit wrapping.
* **Mechanism**: Must be written explicitly using the casting operator syntax: `(targetType) value`.

### Code Example
```java
public class ExplicitCasting {
    public static void main(String[] args) {
        double pi = 3.14159;
        int truncatedPi = (int) pi; // Explicit narrowing cast

        System.out.println("Double value:  " + pi);
        System.out.println("Truncated Int: " + truncatedPi);
    }
}
```

### Output
```text
Double value:  3.14159
Truncated Int: 3
```

> [!WARNING]
> When casting floating-point decimals (`double` or `float`) to integers (`int` or `long`), the decimal portion is completely truncated (chopped off) rather than rounded to the nearest integer.

---

## Type Promotion in Expressions

When evaluating arithmetic expressions, Java automatically promotes operands to prevent overflow during calculations.

### Rules of Numeric Promotion
1. If any operand in the expression is `double`, the entire expression is promoted to `double`.
2. Otherwise, if any operand is `float`, the expression is promoted to `float`.
3. Otherwise, if any operand is `long`, the expression is promoted to `long`.
4. Otherwise, all operands (including `byte`, `short`, and `char`) are promoted to `int` before evaluation.

### Promotion Example
```java
public class PromotionDemo {
    public static void main(String[] args) {
        byte a = 40;
        byte b = 50;
        
        // a and b are automatically promoted to int for the addition operation
        int result = a + b; 
        System.out.println("Result: " + result);
    }
}
```

### Truncation Hazard: Explicit Return Promotion
Because of rule 4, if you try to assign the result of an arithmetic operation on small types back to a small type, you will get a compilation error unless you explicitly cast it:

```java
byte x = 50;
byte y = 20;

// Compilation error if written as: byte result = x + y;
byte result = (byte) (x + y); 
```

---

## Practice Challenges

### Challenge 1: Float to Long Precision
Declare a `float` variable with `123.456f`. Explicitly cast it to a `long` and print the output. Note whether the decimal values are preserved.

### Challenge 2: Integer Overflow Casting
Initialize a `long` variable with a value larger than `2,147,483,647` (such as `3000000000L`). Explicitly cast it to an `int` and explain why the resulting output value is negative.

### Challenge 3: Byte Promotion
Write a block of code to multiply two `byte` variables containing `10` and `20`. Try saving the output in a `byte` variable with and without casting and observe compiler exceptions.

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
