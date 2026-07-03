# Variables in Java

---

## What is a Variable?

A variable is a named memory location used to store data.

Instead of directly working with raw memory, we use variables to store and manipulate values in a readable way.

---

## Basic Syntax

```java
dataType variableName = value;
```

Example:

```java
int age = 20;
```

* int → data type
* age → variable name
* 20 → value stored

---

## Why Variables are Important

* Store data temporarily
* Reuse values
* Perform calculations
* Make programs dynamic

---

## Types of Variables (Based on Scope)

### 1. Local Variables

Declared inside a method.

```java
public class Demo {
    public static void main(String[] args) {
        int x = 10;
        System.out.println(x);
    }
}
```

Only accessible within that method.

---

### 2. Instance Variables

Declared inside a class but outside methods.

```java
class Student {
    int age;
}
```

Each object gets its own copy.

---

### 3. Static Variables

Shared across all objects.

```java
class Student {
    static String college = "ABC";
}
```

Only one copy exists.

---

## Data Types in Variables

### Primitive Types

* int → integer
* float → decimal
* double → high precision decimal
* char → single character
* boolean → true/false

Example:

```java
int a = 10;
double price = 99.99;
char grade = 'A';
boolean isValid = true;
```

---

### Non-Primitive Types

* String
* Arrays
* Objects

Example:

```java
String name = "Sanjay";
```

---

## Variable Declaration vs Initialization

### Declaration

```java
int x;
```

### Initialization

```java
x = 10;
```

### Combined

```java
int x = 10;
```

---

## Memory Representation

```text
Variable: age
Value: 20

Memory:
[ age ] → 20
```

---

## Rules for Naming Variables

* Must start with letter, _ or $
* Cannot start with number
* No spaces allowed
* Cannot use keywords (int, class, etc.)

Valid:

```java
int totalMarks;
int _count;
```

Invalid:

```java
int 1value;   // starts with number
int class;    // keyword
```

---

## Real Example

```java
public class Student {
    public static void main(String[] args) {
        String name = "Sanjay";
        int age = 20;
        double marks = 85.5;

        System.out.println(name);
        System.out.println(age);
        System.out.println(marks);
    }
}
```

---

## Variable Flow Diagram

```text
Declare → Allocate Memory → Assign Value → Use Value
```

---

## Analogy

Think of variables like labeled boxes:

* Box name = variable name
* Content inside = value
* Box type = data type

---

## Common Mistakes

* Using variable without initialization
* Wrong data type assignment
* Naming conflicts
* Forgetting semicolon

---

## Practice Challenges

### Challenge 1

Store your name, age, and percentage in variables and print them.

### Challenge 2

Swap two numbers using a third variable.

### Challenge 3

Store two numbers and print their sum, difference, and product.

---

## Advanced Insight

Variables are stored in memory (RAM).
Primitive types store actual values, while non-primitive types store references (addresses).

---

## Concept Map

```text
Variable
   ↓
Data Type + Name + Value
   ↓
Memory Storage
   ↓
Usage in Program
```

---

## Key Takeaways

* Variables store data in memory
* Every variable has a type, name, and value
* Scope defines where a variable can be used
* Correct naming improves readability
* Understanding variables is essential for all programming concepts

---

## Conclusion

Variables are the building blocks of any program.
Mastering them will make future topics like loops, arrays, and OOP much easier.
