# Char and Unicode in Java

---

## Introduction

In Java, the `char` data type is used to store a single character.

Unlike some languages, Java uses **Unicode**, which allows it to support characters from almost all languages.

---

## Basic Example

```java id="d4m9sx"
public class Main {
    public static void main(String[] args) {

        char myChar = 'A';
        System.out.println(myChar);

        char myChar1 = '1';
        System.out.println(myChar1);

        char myUniChar = '\u0015';
        System.out.println(myUniChar);
    }
}
```

---

## Output

```text id="5l6b2g"
A
1
(non-printable character)
```

---

## Understanding char

* char stores a single character
* It uses **2 bytes (16 bits)** of memory
* It stores values using Unicode encoding

---

## Unicode Concept (Important)

Unicode assigns a unique number (code) to every character.

Example:

```text id="qk1g7x"
'A' → 65
'1' → 49
```

---

## Unicode Example

```java id="4b5z1n"
char letter = '\u0041';
System.out.println(letter);
```

---

### Output

```text id="y8v7hk"
A
```

---

## Why Unicode?

* Supports multiple languages
* Works globally
* Not limited like ASCII (only 128 characters)

---

## Character vs Number (Important Concept)

```java id="z6g1nx"
char c = 'A';
int x = c;

System.out.println(x);
```

---

### Output

```text id="t7n4ks"
65
```

---

### Explanation

* Characters are internally stored as numbers
* 'A' → 65 → printed as integer

---

## Arithmetic with char

```java id="9k2sjd"
char c = 'A';
c++;

System.out.println(c);
```

---

### Output

```text id="v4m8qe"
B
```

---

### Explanation

* 'A' → 65
* After increment → 66 → 'B'

---

## Memory Representation

```text id="h1p4xm"
char c = 'A'

Memory:
[ c ] → 65 → 'A'
```

---

## Escape Sequences

Used to represent special characters.

```java id="r7x0zp"
System.out.println("Hello\nWorld");
System.out.println("Tab\tSpace");
```

---

### Output

```text id="8b5n6r"
Hello
World
Tab    Space
```

---

## Common Mistakes

* Using double quotes instead of single quotes

  ```java
  char c = "A"; // wrong
  ```

* Using more than one character

  ```java
  char c = 'AB'; // wrong
  ```

* Not understanding Unicode values

---

## Practice Challenges

### Challenge 1

Print Unicode value of 'Z'.

---

### Challenge 2

Increment a character and print next letter.

---

### Challenge 3

Convert char to int and print value.

---

### Challenge 4

Print a character using Unicode escape.

---

## Concept Map

```text id="t2v9qo"
char
 ↓
Unicode
 ↓
Numeric Value
 ↓
Character Representation
```

---

## Key Takeaways

* char stores a single character
* Java uses Unicode (not ASCII only)
* Characters are internally numbers
* Arithmetic operations are possible on char
* Unicode enables global support

---

## Conclusion

Understanding char and Unicode gives deeper insight into how Java handles characters internally.

This concept becomes important in strings, encoding, and advanced programming.
