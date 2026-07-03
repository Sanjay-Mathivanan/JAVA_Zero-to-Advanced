# Operators and Operands in Java

---

# Introduction

Operators are symbols used to perform operations on values and variables.

Operands are the values on which operators perform operations.

---

## Example

```java id="onkhx4"
int sum = 10 + 20;
```

Here:

```text id="x7i89x"
10 and 20 → Operands
+         → Operator
```

---

# Types of Operators in Java

Java provides several types of operators:

* Arithmetic Operators
* Assignment Operators
* Relational Operators
* Logical Operators
* Unary Operators
* Ternary Operator
* Bitwise Operators

---

# 1. Arithmetic Operators

Used for mathematical calculations.

| Operator | Meaning        |
| -------- | -------------- |
| +        | Addition       |
| -        | Subtraction    |
| *        | Multiplication |
| /        | Division       |
| %        | Modulus        |

---

## Example Program

```java id="nm2r8j"
public class Main {

    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        System.out.println("Addition: " + (a + b));
        System.out.println("Subtraction: " + (a - b));
        System.out.println("Multiplication: " + (a * b));
        System.out.println("Division: " + (a / b));
        System.out.println("Modulus: " + (a % b));
    }
}
```

---

## Output

```text id="2g2r3k"
Addition: 13
Subtraction: 7
Multiplication: 30
Division: 3
Modulus: 1
```

---

## Important Concept

```java id="hq5plq"
5 / 2 = 2
```

Because:

* int division removes decimal part.

---

# 2. Assignment Operators

Used to assign values.

| Operator | Example |
| -------- | ------- |
| =        | x = 10  |
| +=       | x += 5  |
| -=       | x -= 5  |
| *=       | x *= 2  |
| /=       | x /= 2  |

---

## Example

```java id="ew4a4o"
int x = 10;

x += 5;

System.out.println(x);
```

---

## Output

```text id="fqvvzd"
15
```

---

# 3. Relational Operators

Used to compare values.

| Operator | Meaning          |
| -------- | ---------------- |
| ==       | Equal            |
| !=       | Not Equal        |
| >        | Greater Than     |
| <        | Less Than        |
| >=       | Greater or Equal |
| <=       | Less or Equal    |

---

## Example

```java id="m20n0u"
int a = 10;
int b = 20;

System.out.println(a < b);
System.out.println(a == b);
```

---

## Output

```text id="sjlwmj"
true
false
```

---

# 4. Logical Operators

Used with boolean expressions.

| Operator | Meaning |
| -------- | ------- |
| &&       | AND     |
| ||       | OR      |
| !        | NOT     |

---

## Example

```java id="f34px4"
boolean x = true;
boolean y = false;

System.out.println(x && y);
System.out.println(x || y);
System.out.println(!x);
```

---

## Output

```text id="nyy6xt"
false
true
false
```

---

# 5. Unary Operators

Operate on single operand.

| Operator | Meaning   |
| -------- | --------- |
| ++       | Increment |
| --       | Decrement |
| +        | Positive  |
| -        | Negative  |

---

# Pre Increment vs Post Increment

---

## Post Increment

```java id="kizld2"
int x = 5;

System.out.println(x++);
System.out.println(x);
```

---

## Output

```text id="k4v9hk"
5
6
```

---

## Explanation

```text id="9mhwtq"
Use value first
Then increment
```

---

## Pre Increment

```java id="j4ls6v"
int x = 5;

System.out.println(++x);
```

---

## Output

```text id="t3ujeb"
6
```

---

## Explanation

```text id="tyof73"
Increment first
Then use value
```

---

# 6. Ternary Operator

Short form of if-else.

---

## Syntax

```java id="mtrzy0"
condition ? value1 : value2;
```

---

## Example

```java id="pqmyx2"
int age = 18;

String result = (age >= 18) ? "Eligible" : "Not Eligible";

System.out.println(result);
```

---

## Output

```text id="1wz6j0"
Eligible
```

---

# 7. Bitwise Operators (Basic Intro)

Operate on binary bits.

| Operator | Meaning     |
| -------- | ----------- |
| &        | Bitwise AND |
| |        | Bitwise OR  |
| ^        | XOR         |
| ~        | Complement  |

---

## Example

```java id="89r9z8"
int a = 5;
int b = 3;

System.out.println(a & b);
```

---

## Binary Explanation

```text id="n2vks8"
5 → 101
3 → 011
---------
    001 → 1
```

---

# Operator Precedence

Some operators execute before others.

Example:

```java id="w5okaj"
int result = 10 + 5 * 2;
```

Output:

```text id="br53qt"
20
```

Because:

* Multiplication executes first.

---

# Memory Perspective

Operators manipulate:

* Values
* References
* Memory data

Operations happen inside CPU registers.

---

# Real-World Analogy

Operators are like tools:

```text id="9x00wo"
+  → calculator addition
== → comparison checker
&& → decision maker
```

Operands are the materials being processed.

---

# Common Mistakes

* Confusing = and ==
* Forgetting integer division behavior
* Misunderstanding ++ operator
* Wrong operator precedence

---

# Practice Challenges

### Challenge 1

Perform all arithmetic operations on two numbers.

---

### Challenge 2

Check if a number is even using modulus operator.

---

### Challenge 3

Use ternary operator to find largest number.

---

### Challenge 4

Predict outputs of pre and post increment.

---

# Concept Map

```text id="4u8kdo"
Operators
   ↓
Arithmetic
Relational
Logical
Unary
Ternary
Bitwise
```

---

# Key Takeaways

* Operators perform operations
* Operands are values being operated on
* Different operators serve different purposes
* Increment operators are important in loops
* Operator precedence affects results

---

# Conclusion

Operators are fundamental to all programming logic.

Every calculation, comparison, and condition in Java depends on operators and operands.

Mastering them improves problem-solving and debugging skills.
