# Programs on Primitive Data Types

This guide provides practical code examples demonstrating data type ranges, overflow/underflow anomalies, and basic type-casting scenarios.

---

## Program 1: Printing Data Type Ranges

This program demonstrates how to fetch the exact mathematical value ranges for the signed integer data types using Java wrapper class constants.

### Code
```java
public class DataTypeRange {
    public static void main(String[] args) {
        int maxInt = Integer.MAX_VALUE;
        int minInt = Integer.MIN_VALUE;

        byte maxByte = Byte.MAX_VALUE;
        byte minByte = Byte.MIN_VALUE;

        short maxShort = Short.MAX_VALUE;
        short minShort = Short.MIN_VALUE;

        long maxLong = Long.MAX_VALUE;
        long minLong = Long.MIN_VALUE;

        System.out.println("Int Range: " + minInt + " to " + maxInt);
        System.out.println("Byte Range: " + minByte + " to " + maxByte);
        System.out.println("Short Range: " + minShort + " to " + maxShort);
        System.out.println("Long Range: " + minLong + " to " + maxLong);
    }
}
```

### Output
```text
Int Range: -2147483648 to 2147483647
Byte Range: -128 to 127
Short Range: -32768 to 32767
Long Range: -9223372036854775808 to 9223372036854775807
```

### Explanation
* Java provides object wrappers (such as `Integer`, `Byte`, `Short`, `Long`) corresponding to each primitive.
* The static constants `MAX_VALUE` and `MIN_VALUE` represent the absolute boundaries of the data type according to their bit-depth structures.

---

## Program 2: Overflow and Underflow Behavior

This program illustrates how Java variables behave when their capacity limits are exceeded.

### Code
```java
public class OverflowDemo {
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE; // 2147483647
        int min = Integer.MIN_VALUE; // -2147483648

        System.out.println("Original Max: " + max);
        System.out.println("After Overflow: " + (max + 1));

        System.out.println("Original Min: " + min);
        System.out.println("After Underflow: " + (min - 1));
    }
}
```

### Output
```text
Original Max: 2147483647
After Overflow: -2147483648
Original Min: -2147483648
After Underflow: 2147483647
```

### Explanation
* Because Java representation of signed numbers uses two's complement, adding `1` to the binary representation of the maximum positive integer shifts the sign bit, resulting in the minimum possible negative value.
* Similarly, subtracting `1` from the minimum negative value wraps around to the maximum positive value.

---

## Program 3: Arithmetic Promotion and Casting

This program demonstrates how Java handles assignments and basic arithmetic operations involving small integer types (`byte` and `short`).

### Code
```java
public class TypeCastingDemo {
    public static void main(String[] args) {
        byte b = 100;

        // Implicit casting (automatic promotion)
        int intValue = b;
        System.out.println("Byte to Int: " + intValue);

        // Explicit casting required for division
        byte newByte = (byte) (b / 2);
        System.out.println("After Division: " + newByte);

        short s = 32000;
        short result = (short) (s / 2);
        System.out.println("Short Division: " + result);

        long bigValue = 21474836471234L;
        System.out.println("Long Value: " + bigValue);
    }
}
```

### Output
```text
Byte to Int: 100
After Division: 50
Short Division: 16000
Long Value: 21474836471234
```

### Explanation
* **Implicit Casting**: Safe conversions (such as assigning a `byte` variable to an `int`) happen automatically because `int` is wider (4 bytes) than `byte` (1 byte).
* **Arithmetic Promotion**: When performing binary arithmetic operations (like `/ 2`) on `byte` or `short` values, Java automatically promotes the operands to `int` first. Therefore, the result of `b / 2` is of type `int`. If you wish to save it back into a `byte`, you must write an explicit cast `(byte)` to confirm you accept potential precision loss.

---

## Practice Challenges

### Challenge 1: Float and Double Limits
Modify Program 1 to print the minimum and maximum boundaries of `Float` and `Double`.

### Challenge 2: Byte Overflow
Write a short block of code that initializes a `byte` to `127` and increments it by `1`. Print the result and explain the output.

### Challenge 3: Value Truncation
Initialize an `int` variable with `200`. Explicitly cast it to a `byte` and print the outcome. (Hint: The value will wrap around based on the 8-bit unsigned scale).

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
