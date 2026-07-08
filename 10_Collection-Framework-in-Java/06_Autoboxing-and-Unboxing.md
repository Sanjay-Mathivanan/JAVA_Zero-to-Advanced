# Autoboxing and Unboxing in Java 

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

Java provides two categories of data types:

1. Primitive Data Types
2. Reference Data Types (Objects)

Primitive data types are fast and memory efficient, but they cannot be used directly with the Java Collection Framework.

Collections such as **ArrayList**, **LinkedList**, **HashSet**, and **HashMap** can store **objects only**, not primitive values.

To solve this problem, Java introduced **Wrapper Classes**, **Autoboxing**, and **Unboxing**.

These concepts allow Java to automatically convert primitive values into objects and objects back into primitive values.

---

# Learning Objectives

After completing this chapter, you will understand:

- Primitive Data Types
- Wrapper Classes
- What is Boxing?
- What is Autoboxing?
- Why Autoboxing is Needed?
- Internal Working
- Wrapper Class Methods
- Collections with Wrapper Classes
- Multiple Example Programs

---

# Problem Statement

Suppose we want to store integers inside an ArrayList.

We may try the following code.

```java
ArrayList<int> numbers = new ArrayList<>();
```

Unfortunately,

this produces a compilation error.

### Why?

Because **ArrayList stores only objects**.

Primitive types such as

```
int

double

char

boolean
```

are **not objects**.

---

# Solution

Java provides Wrapper Classes.

Instead of

```
int
```

we use

```
Integer
```

Instead of

```
double
```

we use

```
Double
```

Now the code becomes

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

Java automatically converts

```
int

↓

Integer
```

This automatic conversion is called

## Autoboxing

---

# Primitive Data Types

Java has eight primitive data types.

| Primitive | Size |
|------------|------|
| byte | 1 Byte |
| short | 2 Bytes |
| int | 4 Bytes |
| long | 8 Bytes |
| float | 4 Bytes |
| double | 8 Bytes |
| char | 2 Bytes |
| boolean | JVM Dependent |

Primitive values are stored directly in memory.

Example

```java
int age = 25;
```

---

# Wrapper Classes

Each primitive type has a corresponding Wrapper Class.

| Primitive | Wrapper Class |
|------------|---------------|
| byte | Byte |
| short | Short |
| int | Integer |
| long | Long |
| float | Float |
| double | Double |
| char | Character |
| boolean | Boolean |

Wrapper classes belong to

```java
java.lang
```

package.

---

# Primitive vs Wrapper Class

| Primitive | Wrapper |
|------------|----------|
| int | Integer |
| double | Double |
| char | Character |
| boolean | Boolean |
| Fast | Slightly Slower |
| Value | Object |
| Cannot store in Collection | Can store in Collection |

---

# Why Wrapper Classes?

Suppose we create an ArrayList.

```java
ArrayList<Integer> marks = new ArrayList<>();
```

We can store

```
10

20

30
```

Internally,

Java actually stores

```
Integer Objects
```

instead of primitive integers.

---

# What is Boxing?

Boxing means converting

```
Primitive

↓

Wrapper Object
```

Example

```java
int number = 10;

Integer value = Integer.valueOf(number);
```

Output

```
10
```

---

# Manual Boxing

Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 22;

        Integer obj = Integer.valueOf(age);

        System.out.println(obj);

    }

}
```

### Output

```
22
```

---

# What is Autoboxing?

Autoboxing is the automatic conversion of a primitive value into its corresponding Wrapper object.

Instead of writing

```java
Integer.valueOf()
```

Java automatically performs the conversion.

---

# Syntax

```java
Integer number = 100;
```

Java internally converts it into

```java
Integer number = Integer.valueOf(100);
```

---

# Internal Working

When we write

```java
Integer number = 50;
```

Java compiler changes it into

```java
Integer number = Integer.valueOf(50);
```

The conversion happens automatically during compilation.

---

# Flow Diagram

```
Primitive Value

      │

      ▼

Compiler

      │

      ▼

Integer.valueOf()

      │

      ▼

Wrapper Object
```

---

# Example 1

```java
public class Main {

    public static void main(String[] args) {

        Integer number = 100;

        System.out.println(number);

    }

}
```

### Output

```
100
```

---

# Example 2

```java
Integer a = 10;
Integer b = 20;

System.out.println(a + b);
```

### Output

```
30
```

Although `a` and `b` are objects, Java automatically handles the conversion.

---

# Example 3

Using Autoboxing with ArrayList

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);

        numbers.add(20);

        numbers.add(30);

        System.out.println(numbers);

    }

}
```

### Output

```
[10, 20, 30]
```

---

# How add() Works

When we write

```java
numbers.add(10);
```

Java converts it internally into

```java
numbers.add(Integer.valueOf(10));
```

Therefore,

```
10

↓

Integer Object

↓

Stored inside ArrayList
```

---

# Memory Representation

```
Stack Memory

numbers

     │

     ▼

Heap Memory

ArrayList

     │

     ▼

Integer Object

10

Integer Object

20

Integer Object

30
```

---

# Program Flow

```
Create ArrayList

      │

      ▼

Add Primitive Value

      │

      ▼

Autoboxing

      │

      ▼

Wrapper Object Created

      │

      ▼

Store Inside ArrayList

      │

      ▼

Display Elements
```

---



# Advantages of Autoboxing

- Reduces code complexity.
- No need to call `valueOf()` manually.
- Makes Collections easy to use.
- Improves code readability.
- Automatic conversion performed by the compiler.

---

# Common Mistakes

### Mistake 1

Trying to store primitive types directly.

Wrong

```java
ArrayList<int> list = new ArrayList<>();
```

Correct

```java
ArrayList<Integer> list = new ArrayList<>();
```

---

### Mistake 2

Confusing primitive types with Wrapper classes.

```
int

≠

Integer
```

---

### Mistake 3

Assuming Wrapper objects are primitive values.

Wrapper classes are **objects**, not primitive data types.

---

# Best Practices

- Use Wrapper classes with Collections.
- Prefer Autoboxing instead of manual boxing.
- Use primitive types when object functionality is not required.
- Understand that Wrapper classes consume more memory than primitives.

---

# Key Takeaways

- Java Collections store objects, not primitive values.
- Wrapper classes solve this limitation.
- Boxing converts primitives into Wrapper objects.
- Autoboxing performs this conversion automatically.
- The compiler internally uses `valueOf()` for autoboxing.

---
# What is Unboxing?

Unboxing is the **reverse process of Autoboxing**.

It converts a **Wrapper Object** into its corresponding **Primitive Data Type** automatically.

### Definition

> **Unboxing** is the automatic conversion of a Wrapper class object into its corresponding primitive data type.

---

# Manual Unboxing

Before Java 5, programmers had to manually convert Wrapper objects.

### Example

```java
public class Main {

    public static void main(String[] args) {

        Integer number = Integer.valueOf(100);

        int value = number.intValue();

        System.out.println(value);

    }

}
```

### Output

```
100
```

---

# Automatic Unboxing

From Java 5 onwards, Java automatically performs this conversion.

### Example

```java
public class Main {

    public static void main(String[] args) {

        Integer number = 250;

        int value = number;

        System.out.println(value);

    }

}
```

### Output

```
250
```

---

# Internal Working

When we write

```java
Integer number = 50;

int value = number;
```

The compiler converts it internally into

```java
Integer number = Integer.valueOf(50);

int value = number.intValue();
```

---

# Flow Diagram

```
Wrapper Object

      │

      ▼

Compiler

      │

      ▼

intValue()

      │

      ▼

Primitive Value
```

---

# Example 1

```java
Integer marks = 95;

int result = marks;

System.out.println(result);
```

### Output

```
95
```

---

# Example 2

```java
Double price = 499.99;

double amount = price;

System.out.println(amount);
```

### Output

```
499.99
```

---

# Example 3

Using ArrayList

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(100);
        numbers.add(200);
        numbers.add(300);

        int value = numbers.get(1);

        System.out.println(value);

    }

}
```

### Output

```
200
```

---

# Internal Working of get()

When we write

```java
int value = numbers.get(1);
```

Java internally performs

```java
Integer temp = numbers.get(1);

int value = temp.intValue();
```

This automatic conversion is called **Unboxing**.

---

# Autoboxing and Unboxing Together

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(10);
        list.add(20);
        list.add(30);

        int sum = 0;

        for(Integer number : list){

            sum += number;

        }

        System.out.println(sum);

    }

}
```

### Output

```
60
```

### Explanation

- `list.add(10)` → Autoboxing
- `sum += number` → Unboxing

Both operations happen automatically.

---

# Memory Representation

```
Stack Memory

list

sum

        │

        ▼

Heap Memory

ArrayList

      │

      ▼

Integer

10

Integer

20

Integer

30
```

When retrieving,

```
Integer Object

↓

Primitive int

↓

Used in Calculation
```

---

# Wrapper Class Methods

| Method | Description |
|----------|-------------|
| valueOf() | Converts Primitive to Object |
| intValue() | Converts Integer to int |
| doubleValue() | Converts Double to double |
| floatValue() | Converts Float to float |
| longValue() | Converts Long to long |
| booleanValue() | Converts Boolean to boolean |
| charValue() | Converts Character to char |

---

# Autoboxing vs Unboxing

| Autoboxing | Unboxing |
|-------------|----------|
| Primitive → Object | Object → Primitive |
| Automatic | Automatic |
| Uses valueOf() | Uses intValue(), doubleValue(), etc. |
| Stores objects in Collections | Retrieves primitive values |

---

# Primitive vs Wrapper Class

| Primitive | Wrapper |
|------------|----------|
| int | Integer |
| double | Double |
| float | Float |
| long | Long |
| char | Character |
| boolean | Boolean |
| byte | Byte |
| short | Short |

---

# Performance Considerations

Primitive data types are faster because they are stored directly.

Wrapper objects require

- Object creation
- Memory allocation
- Garbage Collection

Therefore,

```
Primitive

↓

Faster

----------------

Wrapper

↓

Slightly Slower
```

---

# When Should We Use Wrapper Classes?

Use Wrapper Classes when

- Working with Collections
- Working with Generics
- Using Frameworks
- Storing null values
- Using utility methods

---

# When Should We Use Primitive Types?

Use Primitive types when

- High performance is required
- Mathematical calculations
- Loops
- Counters
- Variables that don't need to be objects

---

# Real-World Example

Suppose an application stores student marks.

```java
ArrayList<Integer> marks = new ArrayList<>();
```

When adding marks,

```
95

↓

Integer Object

↓

Stored
```

When calculating average,

```
Integer Object

↓

Primitive int

↓

Calculation
```

Autoboxing and Unboxing happen automatically.

---

# Common Mistakes

### Mistake 1

Trying to store primitive values directly in Collections.

Wrong

```java
ArrayList<int> list;
```

Correct

```java
ArrayList<Integer> list;
```

---

### Mistake 2

Using Wrapper classes unnecessarily.

Wrong

```java
Integer count = 10;

for(Integer i=0;i<count;i++){}
```

Better

```java
int count = 10;

for(int i=0;i<count;i++){}
```

---

### Mistake 3

Ignoring NullPointerException.

```java
Integer value = null;

int number = value;
```

Output

```
NullPointerException
```

Because Java cannot unbox a null object.

---

# Best Practices

- Use primitive types for calculations.
- Use Wrapper classes with Collections.
- Avoid unnecessary boxing and unboxing inside loops.
- Check for null before unboxing.
- Use Autoboxing instead of manual conversion whenever possible.

---

# Interview Questions

## Beginner

1. What is Autoboxing?
2. What is Unboxing?
3. Why do Collections use Wrapper classes?
4. Difference between primitive and Wrapper class?

---

## Intermediate

5. What is Boxing?
6. Explain `valueOf()` and `intValue()`.
7. What happens internally during Autoboxing?
8. What happens internally during Unboxing?

---

## Advanced

9. Why are Wrapper classes slower than primitive types?
10. Explain the memory difference between primitive and Wrapper objects.
11. Can Wrapper classes store null values?
12. What exception occurs while unboxing a null object?
13. Explain Autoboxing with ArrayList.
14. Explain Unboxing with `get()`.

---

# Practice Programs

### Easy

- Store integers inside an ArrayList.
- Demonstrate Autoboxing.
- Demonstrate Unboxing.

### Medium

- Calculate the average of marks stored in an ArrayList.
- Find the maximum element.
- Find the minimum element.

### Hard

- Create a Student Marks Management System using ArrayList<Integer>.
- Create a Banking Transaction application using Wrapper classes.
- Compare performance of primitive and Wrapper types.

---

# Concept Map

```
               Primitive Types

                      │

          ┌───────────┴───────────┐

          ▼                       ▼

    Autoboxing              Unboxing

          │                       │

          ▼                       ▼

   Wrapper Object         Primitive Value

          │

          ▼

     Java Collections
```

---

# Key Takeaways

- Wrapper classes represent primitive data types as objects.
- Autoboxing converts primitive values into Wrapper objects automatically.
- Unboxing converts Wrapper objects back into primitive values.
- Collections store only objects.
- Wrapper classes make Collections and Generics possible.
- Primitive types are faster than Wrapper classes.
- Avoid unnecessary boxing and unboxing in performance-critical code.

---

# Conclusion

Autoboxing and Unboxing are powerful Java features that simplify the conversion between primitive data types and Wrapper classes. They eliminate the need for manual conversion methods like `valueOf()` and `intValue()`, making Java code cleaner and easier to read. These concepts are essential when working with the **Java Collection Framework**, as collections can store only objects. Understanding when to use primitive types and when to use Wrapper classes is important for writing efficient, maintainable, and interview-ready Java applications.
