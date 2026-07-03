# Type Casting in Java

---

## What is Type Casting?

Type casting is the process of converting one data type into another.

It is required when we want to:

* Store a value in a different data type
* Perform operations between different types
* Control memory usage

---

## Types of Type Casting

### 1. Implicit Casting (Widening)

* Smaller data type → larger data type
* Happens automatically
* No data loss

```java
public class ImplicitCasting {
    public static void main(String[] args) {
        int a = 10;
        double b = a;

        System.out.println(b);
    }
}
```

---

### Output

```text
10.0
```

---

### How It Works

* int is converted to double automatically
* JVM handles conversion safely

---

## 2. Explicit Casting (Narrowing)

* Larger data type → smaller data type
* Must be done manually
* May cause data loss

```java
public class ExplicitCasting {
    public static void main(String[] args) {
        double value = 10.75;
        int result = (int) value;

        System.out.println(result);
    }
}
```

---

### Output

```text
10
```

---

### Important Behavior

* Decimal part is removed (not rounded)
* Data loss occurs

---

## Type Promotion in Expressions

When performing operations:

```java
byte a = 10;
byte b = 20;
int result = a + b;
```

---

### Why Result is int?

* Java automatically promotes:

  * byte → int
  * short → int

This avoids overflow during calculations.

---

## Example: Why Casting is Needed

```java
byte x = 50;
byte y = 20;

byte result = (byte) (x + y);
```

Without casting → compilation error
Because (x + y) becomes int

---

## Conversion Flow

```text
byte → short → int → long → float → double
```

Reverse requires casting.

---

## Memory Perspective

```text
int (4 bytes) → double (8 bytes)  → safe

double (8 bytes) → int (4 bytes) → data loss possible
```

---

## Real Example

```java
public class CastingExample {
    public static void main(String[] args) {

        int a = 100;
        long b = a; // implicit

        long big = 100000;
        int small = (int) big; // explicit

        System.out.println(b);
        System.out.println(small);
    }
}
```

---

## Common Mistakes

* Forgetting casting in expressions
* Expecting rounding instead of truncation
* Using wrong data types in calculations
* Ignoring data loss

---

## Practice Challenges

### Challenge 1

Convert double to int and observe output.

---

### Challenge 2

Add two byte values and store result in byte.

---

### Challenge 3

Convert int to float and print result.

---

### Challenge 4

Try casting large long value into int and observe change.

---

## Concept Map

```text
Type Casting
   ↓
Implicit (Automatic)
   ↓
Explicit (Manual)
   ↓
Type Promotion
```

---

## Key Takeaways

* Type casting converts one data type to another
* Implicit casting is safe and automatic
* Explicit casting may cause data loss
* Java promotes smaller types during operations
* Understanding casting prevents runtime errors

---

## Conclusion

Type casting is essential when working with different data types.

Mastering it helps avoid errors, improves performance, and gives better control over memory and calculations.
