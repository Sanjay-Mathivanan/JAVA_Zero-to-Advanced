# String to Primitive Conversion in Java

## Introduction

In Java, user input, file data, web responses, and database values are often received as Strings.

However, mathematical operations cannot be directly performed on Strings.

To use numeric operations, Java provides conversion techniques that transform String data into primitive datatypes such as:
- int
- double
- float
- long
- boolean
- char

This process is called:

```text
String to Primitive Conversion
```

It is also commonly known as:
- Parsing
- Type Conversion
- String Parsing

---

# Why String Conversion is Important

Most external data enters a Java program as text.

Examples:
- Keyboard input
- Scanner input
- API responses
- File reading
- Database values

Even numbers typed by users are initially treated as Strings.

To perform calculations, Java must convert them into primitive datatypes.

---

# Real-World Analogy

Imagine a calculator application.

When a user presses:
```text
5
```

The button sends:
```text
"5"
```

which is a String.

Before addition happens, the calculator internally converts:
```text
"5" → 5
```

Only then can arithmetic operations be performed.

---

# What Happens Without Conversion

## Example

```java
String a = "10";
String b = "20";

System.out.println(a + b);
```

---

# Output

```text
1020
```

---

# Why?

Because both values are Strings.

Java performs:
```text
Concatenation
```

instead of:
```text
Addition
```

---

# Correct Conversion

```java
int a = Integer.parseInt("10");
int b = Integer.parseInt("20");

System.out.println(a + b);
```

---

# Output

```text
30
```

---

# What is Parsing?

## Definition

Parsing means:
```text
Converting readable text data into another usable datatype.
```

Example:

```text
"100" → 100
```

---

# Internal Working of Parsing

## Step-by-Step Process

Consider:

```java
int number = Integer.parseInt("25");
```

---

# Internal Flow

```text
String Object
     ↓
Characters '2' and '5'
     ↓
Integer.parseInt()
     ↓
Converts text into binary integer
     ↓
Stores value in memory
```

---

# Memory Representation

```text
Before Conversion

Heap Memory
----------------
"25"
----------------

After Conversion

Stack Memory
----------------
number → 25
----------------
```

---

# Common Parsing Methods in Java

| Method | Converts To |
|---|---|
| Integer.parseInt() | int |
| Double.parseDouble() | double |
| Float.parseFloat() | float |
| Long.parseLong() | long |
| Boolean.parseBoolean() | boolean |
| Short.parseShort() | short |
| Byte.parseByte() | byte |

---

# 1. Converting String to int

## Syntax

```java
int variable = Integer.parseInt(stringValue);
```

---

# Example Program

```java
public class StringToInt {

    public static void main(String[] args) {

        String number = "150";

        int value = Integer.parseInt(number);

        System.out.println(value);

    }
}
```

---

# Output

```text
150
```

---

# Step-by-Step Explanation

## Step 1

```java
String number = "150";
```

Stores numeric text.

---

## Step 2

```java
Integer.parseInt(number)
```

Converts String into integer.

---

## Step 3

```java
int value
```

Stores converted primitive value.

---

# 2. Converting String to double

## Example

```java
public class StringToDouble {

    public static void main(String[] args) {

        String price = "99.99";

        double value = Double.parseDouble(price);

        System.out.println(value);

    }
}
```

---

# Output

```text
99.99
```

---

# 3. Converting String to float

## Example

```java
public class StringToFloat {

    public static void main(String[] args) {

        String marks = "85.5";

        float value = Float.parseFloat(marks);

        System.out.println(value);

    }
}
```

---

# Output

```text
85.5
```

---

# 4. Converting String to long

## Example

```java
public class StringToLong {

    public static void main(String[] args) {

        String population = "9000000";

        long value = Long.parseLong(population);

        System.out.println(value);

    }
}
```

---

# Output

```text
9000000
```

---

# 5. Converting String to boolean

## Example

```java
public class StringToBoolean {

    public static void main(String[] args) {

        String status = "true";

        boolean value = Boolean.parseBoolean(status);

        System.out.println(value);

    }
}
```

---

# Output

```text
true
```

---

# Parsing User Input

## Example Program

```java
import java.util.Scanner;

public class UserInputConversion {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        String a = sc.nextLine();

        System.out.print("Enter second number: ");
        String b = sc.nextLine();

        int num1 = Integer.parseInt(a);
        int num2 = Integer.parseInt(b);

        int sum = num1 + num2;

        System.out.println("Sum = " + sum);

    }
}
```

---

# Sample Output

```text
Enter first number: 10
Enter second number: 20
Sum = 30
```

---

# Internal Working of User Input Conversion

```text
Keyboard Input
      ↓
Scanner reads text
      ↓
Stored as String
      ↓
parseInt() converts text
      ↓
Arithmetic operation performed
```

---

# What Happens if Conversion Fails?

## Example

```java
int value = Integer.parseInt("abc");
```

---

# Result

```text
NumberFormatException
```

---

# Why Exception Occurs

Java expects numeric text.

But:
```text
"abc"
```

cannot be converted into integer format.

---

# Exception Flow

```text
Invalid String
      ↓
parseInt()
      ↓
Conversion Fails
      ↓
JVM Throws Exception
```

---

# Handling Conversion Errors

## Example

```java
public class SafeParsing {

    public static void main(String[] args) {

        try {

            int value = Integer.parseInt("abc");

            System.out.println(value);

        } catch(NumberFormatException e) {

            System.out.println("Invalid Number");

        }

    }
}
```

---

# Output

```text
Invalid Number
```

---

# String Conversion vs Type Casting

| Feature | Parsing | Type Casting |
|---|---|
| Converts | String to primitive | Primitive to primitive |
| Example | `"10"` → 10 | `double` → `int` |
| Uses Methods | Yes | No |
| Class Used | Wrapper Classes | Compiler |

---

# Wrapper Classes in Java

Each primitive datatype has a corresponding wrapper class.

| Primitive | Wrapper Class |
|---|---|
| int | Integer |
| double | Double |
| float | Float |
| long | Long |
| char | Character |
| boolean | Boolean |

These wrapper classes provide parsing methods.

---

# Concept Map

```text
String Data
     ↓
Wrapper Classes
     ↓
Parsing Methods
     ↓
Primitive Values
     ↓
Calculations and Logic
```

---

# Common Beginner Mistakes

## 1. Forgetting Conversion

Wrong:

```java
String a = "10";
String b = "20";

System.out.println(a + b);
```

Output:
```text
1020
```

---

## 2. Invalid Numeric Format

Wrong:

```java
Integer.parseInt("12a");
```

Reason:
Contains alphabet.

---

## 3. Using Wrong Parsing Method

Wrong:

```java
Integer.parseInt("99.5");
```

Reason:
Decimal values require:
```java
Double.parseDouble()
```

---

# Best Practices

- Validate user input before conversion
- Use try-catch for safe parsing
- Choose correct parsing method
- Avoid unnecessary conversions
- Use meaningful variable names

---

# Interview Questions

## 1. What is parsing in Java?

Converting String data into primitive datatype.

---

## 2. Why is parsing needed?

Because most external data arrives as text.

---

## 3. Difference between parsing and type casting?

Parsing converts Strings.  
Type casting converts primitive datatypes.

---

## 4. Which class converts String to int?

```java
Integer
```

---

## 5. What exception occurs during invalid parsing?

```text
NumberFormatException
```

---

# Practice Challenges

## Challenge 1

Convert:
```text
"500"
```

into integer.

---

## Challenge 2

Take two String inputs and calculate multiplication.

---

## Challenge 3

Handle invalid numeric input safely.

---

## Challenge 4

Convert:
```text
"99.99"
```

into double.

---

# Key Takeaways

- External data usually enters programs as Strings.
- Parsing converts Strings into primitive values.
- Wrapper classes provide parsing methods.
- Integer.parseInt() converts text into int.
- Invalid conversion causes NumberFormatException.
- Parsing is essential for calculations and user input handling.

---

# Conclusion

String to Primitive Conversion is one of the most important concepts in Java programming.

It acts as a bridge between:
- textual input
- numeric computation

Without parsing:
- calculations cannot happen properly
- user input cannot be processed correctly
- real-world applications become impossible

Understanding parsing deeply helps in:
- input handling
- backend development
- API processing
- database operations
- interview problem solving

Mastering this topic builds a strong foundation for advanced Java programming.
