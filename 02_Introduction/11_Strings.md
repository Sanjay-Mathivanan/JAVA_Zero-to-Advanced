# Strings in Java

---

## Introduction

A String in Java is used to store a sequence of characters.

Unlike primitive data types, String is a **non-primitive (reference) type** and is actually an object.

---

## Basic Example

```java
public class StringDemo {
    public static void main(String[] args) {

        String name = "Sanjay";
        System.out.println(name);
    }
}
```

---

## Output

```text
Sanjay
```

---

## String vs char (Important Difference)

```java
char c = 'A';      // single character
String s = "A";    // sequence of characters
```

* char → primitive
* String → object

---

## How Strings Work Internally

```text
String name = "Java";

Memory:
[ name ] → "Java"
```

Strings are stored in a special memory area called **String Pool**.

---

## String Immutability (Very Important)

Strings cannot be changed after creation.

```java
String str = "Hello";
str = str + " World";
```

---

### What Happens Internally?

```text
"Hello" → old object
"Hello World" → new object created
```

---

## String Concatenation

```java
String first = "Hello";
String second = "World";

String result = first + " " + second;
System.out.println(result);
```

---

### Output

```text
Hello World
```

---

## String Methods (Common)

### length()

```java
String name = "Java";
System.out.println(name.length());
```

---

### toUpperCase()

```java
System.out.println(name.toUpperCase());
```

---

### toLowerCase()

```java
System.out.println(name.toLowerCase());
```

---

### charAt()

```java
System.out.println(name.charAt(0));
```

---

### equals()

```java
String a = "Java";
String b = "Java";

System.out.println(a.equals(b));
```

---

## Important: == vs equals()

```java
String a = "Java";
String b = new String("Java");

System.out.println(a == b);        // false
System.out.println(a.equals(b));  // true
```

---

### Explanation

* == → compares memory address
* equals() → compares actual content

---

## String Input Example

```java
import java.util.Scanner;

public class InputString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        System.out.println(name);
    }
}
```

---

## Common Mistakes

* Using == instead of equals()
* Confusing char and String
* Expecting String to be mutable
* Using next() instead of nextLine() for full input

---

## Practice Challenges

### Challenge 1

Print length of a string.

---

### Challenge 2

Convert a string to uppercase.

---

### Challenge 3

Check if two strings are equal.

---

### Challenge 4

Print each character using charAt().

---

## Concept Map

```text
String
 ↓
Object (Non-Primitive)
 ↓
Immutable
 ↓
String Pool
 ↓
Methods
```

---

## Key Takeaways

* String is a non-primitive data type
* Strings are immutable
* Stored in String Pool
* equals() is used for comparison
* Many built-in methods available

---

## Conclusion

Strings are one of the most used data types in Java.

Understanding how they work internally is essential for writing efficient and correct programs.
