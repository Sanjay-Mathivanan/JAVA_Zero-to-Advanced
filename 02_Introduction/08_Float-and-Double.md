# Float and Double in Java

---

## Introduction

In Java, float and double are used to store decimal (floating-point) numbers.

They differ mainly in:

* Precision
* Memory usage
* Range

---

## Basic Example

```java
public class Main {
    public static void main(String[] args) {

        float floatMaxValue = Float.MAX_VALUE;
        float floatMinValue = Float.MIN_VALUE;

        System.out.println(floatMaxValue);
        System.out.println(floatMinValue);

        double doubleMaxValue = Double.MAX_VALUE;
        double doubleMinValue = Double.MIN_VALUE;

        System.out.println(doubleMaxValue);
        System.out.println(doubleMinValue);
    }
}
```

---

## Output (Approximate)

```text
3.4028235E38
1.4E-45
1.7976931348623157E308
4.9E-324
```

---

## Understanding the Output

The values are printed in scientific notation.

Example:

```text
3.4E38 = 3.4 × 10^38
```

---

## Key Differences

| Feature      | float   | double  |
| ------------ | ------- | ------- |
| Size         | 4 bytes | 8 bytes |
| Precision    | Less    | High    |
| Default type | No      | Yes     |
| Range        | Smaller | Larger  |

---

## Important Rules

### Float Requires 'f'

```java
float x = 10.5f;
```

Without 'f' → error (Java treats decimal as double)

---

### Double is Default

```java
double y = 10.5;
```

No suffix needed.

---

## Precision Example

```java
public class PrecisionDemo {
    public static void main(String[] args) {

        float f = 5.123456789f;
        double d = 5.123456789;

        System.out.println(f);
        System.out.println(d);
    }
}
```

---

### Output

```text
5.123457
5.123456789
```

---

### Explanation

* float loses precision after some digits
* double maintains higher accuracy

---

## Division Behavior

```java
public class DivisionDemo {
    public static void main(String[] args) {

        int a = 5 / 2;
        float b = 5f / 2f;
        double c = 5 / 2.0;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
```

---

### Output

```text
2
2.5
2.5
```

---

### Explanation

* int → integer division
* float/double → decimal division

---

## Memory Representation Concept

```text
float  → 32 bits
double → 64 bits
```

More bits → more precision and range.

---

## When to Use What

### Use float:

* Memory optimization needed
* Large arrays of decimals

### Use double:

* Most calculations
* Financial / precise operations

---

## Analogy

Think of:

* float → small measuring scale
* double → high precision measuring instrument

---

## Common Mistakes

* Forgetting 'f' in float
* Expecting float to be highly precise
* Using int division instead of decimal
* Ignoring scientific notation

---

## Practice Challenges

### Challenge 1

Print max and min values of float and double.

---

### Challenge 2

Compare precision between float and double.

---

### Challenge 3

Perform division using int, float, and double.

---

### Challenge 4

Store a large decimal number and observe output.

---

## Concept Map

```text
Decimal Types
   ↓
float (low precision)
   ↓
double (high precision)
   ↓
Scientific Notation
```

---

## Key Takeaways

* float and double store decimal values
* double is more precise and commonly used
* float requires 'f' suffix
* Scientific notation is used for large/small values
* Precision matters in real applications

---

## Conclusion

Understanding float and double is important for handling decimal values correctly.

Always choose the right type based on precision and memory needs.
