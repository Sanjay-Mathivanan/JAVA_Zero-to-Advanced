# Char and Unicode in Java

This guide details the specifications of the `char` primitive data type in Java, character mapping concepts (ASCII vs. Unicode), Unicode escape sequences, and character arithmetic.

---

## Introduction

In Java, the `char` data type represents a single 16-bit Unicode character. Unlike languages that use 8-bit ASCII character mapping (like C or C++), Java was designed with internationalization in mind, employing the **Unicode** standard to represent characters from nearly all active global languages.

---

## Technical Specifications of char

* **Size**: 2 Bytes (16 bits).
* **Values**: Unsigned integer values ranging from `0` to `65,535`.
* **Internal Representation**: Encoded in UTF-16 (Unicode Transformation Format, 16-bit).
* **Syntax**: Literal values must be enclosed in **single quotes** (e.g., `'A'`). Double quotes (`"A"`) represent a `String` object.

```java
public class CharDemo {
    public static void main(String[] args) {
        char letter = 'A';
        char digit = '9';
        char unicodeChar = '\u0041'; // Hex representation of 'A'

        System.out.println("Letter:       " + letter);
        System.out.println("Digit:        " + digit);
        System.out.println("Unicode Char: " + unicodeChar);
    }
}
```

### Output
```text
Letter:       A
Digit:        9
Unicode Char: A
```

---

## How Character Mapping Works

Computers do not store actual shapes of letters. Instead, they store numeric codes that correspond to characters via mapping tables.

* **ASCII**: Represents 128 characters (English letters, digits, and control characters) using 7-8 bits.
* **Unicode**: A universal standard assigning a unique numeric identifier (code point) to every character, symbol, or glyph across multiple writing systems.

Java's `char` type maps directly to these code points. For example:
* The character `'A'` maps to the decimal code value `65`.
* The character `'a'` maps to the decimal code value `97`.
* The character `'0'` maps to the decimal code value `48`.

---

## Character to Integer Conversions

Because characters are stored internally as numeric values, you can implicitly promote a `char` to an `int` to view its underlying code point value:

```java
public class CharToInt {
    public static void main(String[] args) {
        char ch = 'Z';
        int code = ch; // Implicit widening promotion (char to int)

        System.out.println("Character:      " + ch);
        System.out.println("Unicode value: " + code);
    }
}
```

### Output
```text
Character:      Z
Unicode value: 90
```

---

## Character Arithmetic

Because characters behave like unsigned 16-bit integers, you can perform basic arithmetic operations on them:

```java
public class CharArithmetic {
    public static void main(String[] args) {
        char letter = 'A'; // Code point 65
        System.out.println("Original:  " + letter);

        letter++; // Increments code point to 66
        System.out.println("Increment: " + letter);

        // Add offset to character (requires explicit cast back to char)
        char target = (char) (letter + 3); // 66 + 3 = 69 ('E')
        System.out.println("Offset +3: " + target);
    }
}
```

### Output
```text
Original:  A
Increment: B
Offset +3: E
```

---

## Common Escape Sequences

Escape sequences are prefix codes used to represent special control characters within character or string literals:

| Escape Sequence | Description | Unicode Code Point |
| :--- | :--- | :--- |
| `\n` | Newline (Line feed) | `\u000a` |
| `\t` | Tab space | `\u0009` |
| `\b` | Backspace | `\u0008` |
| `\r` | Carriage Return | `\u000d` |
| `\'` | Single Quote literal | `\u0027` |
| `\"` | Double Quote literal | `\u0022` |
| `\\` | Backslash literal | `\u005c` |

---

## Practice Challenges

### Challenge 1: ASCII Code Reference
Write a loop that prints the character symbols representing code points `65` to `90` (A-Z) and `97` to `122` (a-z).

### Challenge 2: Offset Decoder
Create a program that takes a `char` input and shifts it by `5` places in the Unicode sequence (e.g., `'A'` becomes `'F'`). Print the decoded character.

### Challenge 3: Unicode Symbol Printing
Find the hex code for a foreign language character or symbol (e.g., Greek letter Pi `\u03c0`) and print it using the Unicode escape syntax.

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
