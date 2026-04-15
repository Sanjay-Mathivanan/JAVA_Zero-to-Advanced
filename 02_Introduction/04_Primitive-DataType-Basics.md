# Primitive Data Types in Java

---

## Introduction

In Java, data types define the type of data a variable can store.
Primitive data types are the most basic building blocks used to store simple values.

Java provides 8 primitive data types.

---

## List of Primitive Data Types

* byte
* short
* int
* long
* float
* double
* char
* boolean

---

## Why Data Types Matter

* Define memory size
* Control range of values
* Improve performance
* Prevent invalid data usage

---

## Detailed Breakdown

### 1. int

Used to store integer values.

```java
int num = 100;
```

* Size: 4 bytes (32 bits)
* Range: -2^31 to 2^31 - 1

---

### 2. long

Used for large integer values.

```java
long bigNum = 100000L;
```

* Size: 8 bytes
* Must use 'L' at the end

---

### 3. float

Used for decimal numbers (less precision).

```java
float price = 10.5f;
```

* Size: 4 bytes
* Must use 'f' suffix

---

### 4. double

Used for high precision decimal values.

```java
double value = 99.999;
```

* Size: 8 bytes
* Default for decimals

---

### 5. char

Stores a single character.

```java
char grade = 'A';
```

* Size: 2 bytes
* Uses Unicode

---

### 6. boolean

Stores true or false.

```java
boolean isValid = true;
```

---

### 7. byte

Small integer type.

```java
byte b = 100;
```

* Size: 1 byte
* Range: -128 to 127

---

### 8. short

Used for medium range integers.

```java
short s = 5000;
```

* Size: 2 bytes

---

## Memory Representation

```text
int x = 10

Memory:
[ x ] → 00000000 00000000 00000000 00001010
```

---

## Range Concept (Important)

Example for int:

```java
int max = Integer.MAX_VALUE;
int min = Integer.MIN_VALUE;

System.out.println(max);
System.out.println(min);
```

---

## Overflow and Underflow

### Overflow

When value exceeds maximum limit.

```java
int x = Integer.MAX_VALUE;
x = x + 1;
System.out.println(x);
```

Output becomes negative due to overflow.

---

### Underflow

When value goes below minimum limit.

```java
int x = Integer.MIN_VALUE;
x = x - 1;
System.out.println(x);
```

Output becomes positive due to wrap-around.

---

## Why Overflow Happens

Because memory size is fixed.

```text
Max limit reached → next value wraps to minimum
```

---

## Type Conversion (Basic Idea)

Java automatically converts smaller types to larger types.

```java
int x = 10;
double y = x;  // automatic conversion
```

---

## Analogy

Think of data types like containers:

* byte → small cup
* int → bucket
* long → tank

You cannot store large water in a small cup.

---

## Common Mistakes

* Forgetting 'L' in long
* Forgetting 'f' in float
* Using int for large values
* Ignoring overflow

---

## Practice Challenges

### Challenge 1

Print maximum and minimum values of all primitive types.

---

### Challenge 2

Create variables of all 8 data types and print them.

---

### Challenge 3

Demonstrate overflow using int.

---

### Challenge 4

Store a character and print its ASCII value.

---

## Concept Map

```text
Primitive Types
   ↓
Numbers → byte, short, int, long
   ↓
Decimals → float, double
   ↓
Others → char, boolean
```

---

## Key Takeaways

* Java has 8 primitive data types
* Each type has fixed memory size
* Overflow happens due to memory limits
* Choosing correct type is important
* int is most commonly used

---

## Conclusion

Primitive data types are the foundation of data handling in Java.
Understanding memory, range, and behavior will help in writing efficient and error-free programs.
