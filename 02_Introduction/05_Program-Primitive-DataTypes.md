# Programs on Primitive Data Types

---

## Program 1: Finding Range of Data Types

This program prints the minimum and maximum values of different primitive data types.

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

---

### Explanation

* Java provides wrapper classes (Integer, Byte, etc.)
* MAX_VALUE → largest possible value
* MIN_VALUE → smallest possible value
* Useful to understand limits of memory

---

## Program 2: Overflow and Underflow

This program demonstrates what happens when values exceed limits.

```java
public class OverflowDemo {
    public static void main(String[] args) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println("Original Max: " + max);
        System.out.println("After Overflow: " + (max + 1));

        System.out.println("Original Min: " + min);
        System.out.println("After Underflow: " + (min - 1));
    }
}
```

---

### Explanation

* Overflow: when value exceeds maximum limit
* Underflow: when value goes below minimum limit

#### Important Behavior

```text
Max + 1 → becomes Min
Min - 1 → becomes Max
```

This happens due to fixed memory size.

---

## Program 3: Type Casting and Conversion

This program shows how Java handles type conversion.

```java
public class TypeCastingDemo {
    public static void main(String[] args) {

        byte b = 100;

        // Implicit casting (automatic)
        int intValue = b;
        System.out.println("Byte to Int: " + intValue);

        // Explicit casting (manual)
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

---

### Explanation

#### Implicit Casting

* Smaller → larger type
* Happens automatically

Example:

```java
byte → int
```

---

#### Explicit Casting

* Larger → smaller type
* Must be done manually

Example:

```java
int → byte
```

---

#### Why Casting is Needed

When performing operations:

```java
byte result = (byte) (value / 2);
```

* Java converts result to int by default
* So we must convert back to byte manually

---

## Concept Diagram

```text
Small → Large  (Automatic)
byte → short → int → long → float → double

Large → Small  (Manual Casting Required)
```

---

## Common Mistakes

* Forgetting 'L' for long values
* Forgetting casting in operations
* Assuming no overflow
* Using wrong data type for large numbers

---

## Practice Challenges

### Challenge 1

Print range of float and double.

---

### Challenge 2

Create overflow using byte data type.

---

### Challenge 3

Convert int to byte and observe value changes.

---

### Challenge 4

Store a large number in long and print it.

---

## Key Takeaways

* Every data type has a fixed range
* Overflow occurs when limit exceeds
* Java automatically promotes smaller types
* Casting is required when reducing size
* Wrapper classes help access limits

---

## Conclusion

Understanding primitive data types through programs helps you see how Java behaves internally.

This knowledge is very important for debugging and writing efficient code.
