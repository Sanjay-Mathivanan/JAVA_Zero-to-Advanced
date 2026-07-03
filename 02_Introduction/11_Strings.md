# Strings in Java

This guide details the specifications of the `String` class in Java, addressing object allocation, memory pooling, immutability behaviors, standard method APIs, and reference vs. value comparisons.

---

## Introduction

A `String` in Java represents a sequence of characters. Unlike primitive types (like `int` or `char`), `String` is a **non-primitive reference type**. Under the hood, it is represented as an object of the pre-defined `java.lang.String` class.

```java
public class StringDemo {
    public static void main(String[] args) {
        String greeting = "Hello, Java!";
        System.out.println(greeting);
    }
}
```

---

## Character vs. String Literals

Understanding the compiler differentiation between char and String representations:

* **Character literal** (`char`): Enclosed in single quotes (e.g., `'A'`). Represents a single UTF-16 code point primitive value.
* **String literal** (`String`): Enclosed in double quotes (e.g., `"A"`). Allocates a full String object in memory, even if it contains only one character.

---

## Memory Architecture: The String Pool

To optimize memory usage and prevent duplicate allocations, the Java Virtual Machine contains a specialized storage zone inside the Heap called the **String Constant Pool (SCP)**.

### How it operates:
1. When you declare a string using a literal (e.g., `String s1 = "Java"`), the JVM searches the String Constant Pool.
2. If the value `"Java"` already exists in the pool, the JVM does not create a new object; it returns a reference pointing to the existing pool instance.
3. If it does not exist, a new String object is allocated in the pool.

However, if you instantiate a string using the `new` keyword:
```java
String s2 = new String("Java");
```
This bypasses standard pool lookups, forcing the JVM to allocate a new, distinct String object in the general heap memory space.

---

## String Immutability

In Java, String objects are **immutable**. Once a String object is instantiated in memory, its character sequence cannot be altered.

### Modification Under the Hood:
Consider the following operations:
```java
String str = "Hello";
str = str + " World";
```

1. Initially, `"Hello"` is allocated in the String Pool.
2. When concatenated with `" World"`, the JVM does **not** modify the original object.
3. Instead, it allocates a completely new String object containing `"Hello World"` and updates the variable `str` to point to this new memory address.
4. The original `"Hello"` remains unchanged in the pool.

> [!NOTE]
> If your application performs heavy, repetitive string manipulation (such as inside a loop), use **`StringBuilder`** or **`StringBuffer`** to perform modifications in-place, preventing excessive object allocations on the heap.

---

## String Comparison: `==` vs. `equals()`

A common programming pitfall is using incorrect comparison checks.

* **The `==` Operator**: Compares **memory reference addresses** (i.e., checks if two variables point to the exact same object location).
* **The `equals()` Method**: Compares **actual character content** (checks if the character sequences are identical, case-sensitive).

```java
public class ComparisonDemo {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");

        System.out.println("Literal vs Literal (s1 == s2):       " + (s1 == s2));      // true (same pool object)
        System.out.println("Literal vs New Object (s1 == s3):     " + (s1 == s3));      // false (different objects)
        System.out.println("Content Equality check (s1.equals(s3)): " + s1.equals(s3)); // true (same contents)
    }
}
```

---

## Common String API Methods

The `String` class provides a rich library of methods to query and manipulate character data:

### 1. length()
Returns the total number of characters in the string:
```java
String text = "Coding";
System.out.println(text.length()); // Outputs 6
```

### 2. charAt(int index)
Returns the character character located at the specified 0-indexed position:
```java
System.out.println(text.charAt(0)); // Outputs 'C'
```

### 3. toUpperCase() & toLowerCase()
Returns a new, modified version of the string representing case changes:
```java
System.out.println(text.toUpperCase()); // Outputs "CODING"
```

### 4. substring(int beginIndex, int endIndex)
Returns a subsegment of the string starting from `beginIndex` (inclusive) to `endIndex` (exclusive):
```java
System.out.println(text.substring(0, 4)); // Outputs "Codi"
```

---

## Practice Challenges

### Challenge 1: Case Comparison
Write a program that takes two strings, compares them using `equals()`, and then compares them ignoring case differences using `equalsIgnoreCase()`.

### Challenge 2: Character Printer
Write a program containing a string (e.g., `"Java"`). Print each character of the string on a new line using a loop and the `charAt()` method.

### Challenge 3: Path Parsing
Declare a string containing a file path (e.g., `/home/user/document.txt`). Write code that extracts the file extension from this path using string query methods.

---

**Back to Module Home:** [Introduction to Java Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/02_Introduction/README.md)
