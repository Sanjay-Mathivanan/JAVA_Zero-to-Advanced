# Operators and Operands in Java

This guide details the specifications of Java's operator system, addressing evaluation rules, relational logic, short-circuit execution, unary increments, bitwise operations, and precedence order.

---

## Introduction

In Java, programming logic is constructed using operators and operands:
* **Operator**: A symbol that represents a specific computation or manipulation (e.g., `+`, `*`, `&&`).
* **Operand**: The target values or variables on which the operation is performed.

```java
int sum = 10 + 20;
```
* `10` and `20` are **operands**.
* `+` is the **operator**.

---

## Category of Operators in Java

Java divides operators into categories based on their functionality and the number of operands they manipulate (Unary, Binary, or Ternary).

---

## 1. Arithmetic Operators

Used to perform basic mathematical operations on numeric types:

| Operator | Operation | Example (`a = 10`, `b = 3`) | Result |
| :--- | :--- | :--- | :--- |
| **`+`** | Addition | `a + b` | `13` |
| **`-`** | Subtraction | `a - b` | `7` |
| **`*`** | Multiplication | `a * b` | `30` |
| **`/`** | Division | `a / b` | `3` (Integer division discards fractional remainder) |
| **`%`** | Modulus (Remainder) | `a % b` | `1` (10 divided by 3 leaves a remainder of 1) |

---

## 2. Assignment Operators

Used to write values to variables. Java provides compound assignment operators to shorten common arithmetic expressions:

```java
int x = 10;

x += 5; // Equivalent to: x = x + 5 (x becomes 15)
x -= 2; // Equivalent to: x = x - 2 (x becomes 13)
x *= 2; // Equivalent to: x = x * 2 (x becomes 26)
x /= 2; // Equivalent to: x = x / 2 (x becomes 13)
x %= 5; // Equivalent to: x = x % 5 (x becomes 3)
```

---

## 3. Relational (Comparison) Operators

Compare two operands and return a boolean result (`true` or `false`):

| Operator | Comparison | Example (`a = 10`, `b = 20`) | Result |
| :--- | :--- | :--- | :--- |
| **`==`** | Equal to | `a == b` | `false` |
| **`!=`** | Not equal to | `a != b` | `true` |
| **`>`** | Greater than | `a > b` | `false` |
| **`<`** | Less than | `a < b` | `true` |
| **`>=`** | Greater than or equal to | `a >= b` | `false` |
| **`<=`** | Less than or equal to | `a <= b` | `true` |

---

## 4. Logical Operators

Used to construct compound boolean expressions:

| Operator | Logical Operation | Rule |
| :--- | :--- | :--- |
| **`&&`** | Conditional-AND (Short-circuit) | Returns `true` only if both operands are true. |
| **`\|\|`** | Conditional-OR (Short-circuit) | Returns `true` if at least one operand is true. |
| **`!`** | Logical-NOT (Unary negation) | Inverts the boolean state (true becomes false). |

### Short-Circuit Evaluation
Logical operators `&&` and `||` employ short-circuit logic for performance:
* **For `&&`**: If the first operand evaluates to `false`, the JVM skips evaluating the second operand because the overall result is guaranteed to be false.
* **For `||`**: If the first operand evaluates to `true`, the JVM skips evaluating the second operand because the overall result is guaranteed to be true.

```java
// If obj is null, the program does not throw a NullPointerException 
// because standard evaluation short-circuits on the first false condition.
if (obj != null && obj.isValid()) {
    // Safe execution block
}
```

---

## 5. Unary Operators (Increment/Decrement)

Unary operators require only a single operand. The increment (`++`) and decrement (`--`) operators behave differently based on their position relative to the variable:

### Post-Increment (`x++`)
Uses the current value of the variable in the active expression first, and then increments the variable value by `1` in memory.
```java
int x = 5;
System.out.println(x++); // Prints 5 (value used first)
System.out.println(x);   // Prints 6 (value updated in memory)
```

### Pre-Increment (`++x`)
Increments the variable value by `1` in memory first, and then uses the new updated value in the active expression.
```java
int x = 5;
System.out.println(++x); // Prints 6 (value incremented first)
```

---

## 6. Ternary Operator

The ternary operator (`? :`) is a shorthand alternative to basic `if-else` blocks. It consists of three operands:
```java
variable = (condition) ? valueIfTrue : valueIfFalse;
```

For example:
```java
int age = 18;
String status = (age >= 18) ? "Eligible" : "Not Eligible";
```

---

## 7. Bitwise Operators

Operate on the binary digit representation (bits) of integer types:

* **`&` (Bitwise AND)**: Compares matching bits; returns `1` if both bits are 1.
* **`|` (Bitwise OR)**: Compares matching bits; returns `1` if at least one bit is 1.
* **`^` (Bitwise XOR)**: Returns `1` if the matching bits are different.
* **`~` (Bitwise Complement)**: Inverts all bits (0 becomes 1, and vice versa).
* **`<<` (Left Shift)**: Shifts bits to the left, filling empty spaces on the right with zeros.
* **`>>` (Signed Right Shift)**: Shifts bits to the right, preserving the sign bit (leftmost bit).

---

## Operator Precedence Hierarchy

When multiple operators appear in a single expression, they are evaluated according to their precedence ranking. Operators with higher precedence are evaluated first:

| Precedence Rank | Operator Type | Symbols |
| :--- | :--- | :--- |
| 1 (Highest) | Postfix | `expr++` `expr--` |
| 2 | Unary | `++expr` `--expr` `+` `-` `!` `~` |
| 3 | Multiplicative | `*` `/` `%` |
| 4 | Additive | `+` `-` |
| 5 | Shift | `<<` `>>` `>>>` |
| 6 | Relational | `<` `>` `<=` `>=` `instanceof` |
| 7 | Equality | `==` `!=` |
| 8 | Bitwise AND | `&` |
| 9 | Bitwise XOR | `^` |
| 10 | Bitwise OR | `\|` |
| 11 | Logical AND | `&&` |
| 12 | Logical OR | `\|\|` |
| 13 | Ternary | `? :` |
| 14 (Lowest) | Assignment | `=` `+=` `-=` `*=` `/=` `%=` |

---

## Practice Challenges

### Challenge 1: Increments Evaluation
Predict the console values printed by this program:
```java
public class IncrementChallenge {
    public static void main(String[] args) {
        int a = 5;
        int b = a++ + ++a;
        System.out.println("a: " + a + ", b: " + b);
    }
}
```

### Challenge 2: Leap Year Check
Write a program that takes a year as integer input and uses logical operators to check if it is a leap year. A year is a leap year if it is divisible by 4, but not divisible by 100, unless it is also divisible by 400.

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
