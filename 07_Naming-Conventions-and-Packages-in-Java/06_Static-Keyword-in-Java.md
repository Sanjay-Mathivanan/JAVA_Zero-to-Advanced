# Static Keyword in Java

## Introduction

So far, we have learned about:

- Classes
- Objects
- Constructors
- Inheritance
- Encapsulation
- Packages
- Scope
- Visibility

Every time we create an object, Java allocates memory for its instance variables.

Sometimes, we need a variable or method that should belong to the **class itself**, not to individual objects.

Java provides the **static** keyword for this purpose.

---

# What is the Static Keyword?

The `static` keyword is used to make a variable, method, block, or nested class belong to the **class** instead of an **object**.

In simple words,

```text
Instance Members
    ↓
Belong to Object

Static Members
    ↓
Belong to Class
```

---

# Why Do We Need Static?

Imagine a college has 10,000 students.

Every student belongs to the same college.

Without static:

```text
Student 1
College Name = KGiSL

Student 2
College Name = KGiSL

Student 3
College Name = KGiSL
```

The same data is stored thousands of times.

Instead, we use:

```java
static String collegeName = "KGiSL";
```

Now only one copy exists.

---

# Real-World Analogy

Consider a classroom.

Every student has:

```text
Name
Age
Roll Number
```

These are different for every student.

But every student belongs to:

```text
KGiSL Institute
```

The institute name is common.

Therefore,

```text
Student Name
→ Instance Variable

College Name
→ Static Variable
```

---

# Memory Representation

Without Static:

```text
Student Object 1

Name
Age
College

------------------

Student Object 2

Name
Age
College

------------------

Student Object 3

Name
Age
College
```

Three copies of College.

---

With Static:

```text
Student Object 1

Name
Age

------------------

Student Object 2

Name
Age

------------------

Student Object 3

Name
Age

------------------

Student Class

College Name
```

Only one copy exists.

---

# Static Variable

A static variable belongs to the class.

Syntax:

```java
static datatype variableName;
```

Example:

```java
public class Student {

    static String college = "KGiSL";
}
```

---

# Example Program

```java
public class Student {

    String name;

    static String college = "KGiSL";

    Student(String name) {

        this.name = name;
    }

    public void display() {

        System.out.println(name + " studies at " + college);
    }

    public static void main(String[] args) {

        Student s1 = new Student("Sanjay");
        Student s2 = new Student("Rahul");

        s1.display();
        s2.display();
    }
}
```

---

# Output

```text
Sanjay studies at KGiSL
Rahul studies at KGiSL
```

---

# Understanding the Output

Both students share the same:

```text
college
```

Only one copy exists.

---

# Instance Variable vs Static Variable

| Instance Variable | Static Variable |
|------------------|-----------------|
| Belongs to Object | Belongs to Class |
| Multiple Copies | Single Copy |
| Accessed using Object | Accessed using Class |
| Memory allocated for every object | Memory allocated once |

---

# Static Method

A method declared using:

```java
static
```

belongs to the class.

Syntax:

```java
public static void display()
```

---

# Example

```java
public class MathUtility {

    public static int square(int n) {

        return n * n;
    }

    public static void main(String[] args) {

        System.out.println(square(5));
    }
}
```

---

# Output

```text
25
```

---

# Calling Static Method

Using Class Name

```java
MathUtility.square(5);
```

No object required.

---

# Instance Method

Requires object.

```java
Student s = new Student();

s.display();
```

---

# Static Method Rules

Static methods:

✔ Can access static variables

✔ Can call static methods

Static methods:

❌ Cannot directly access instance variables

❌ Cannot use this keyword

---

# Example

Wrong

```java
public class Student {

    String name = "Sanjay";

    public static void display() {

        System.out.println(name);
    }
}
```

Output

```text
Compilation Error
```

---

Correct

```java
public class Student {

    static String college = "KGiSL";

    public static void display() {

        System.out.println(college);
    }
}
```

---

# Why Can't Static Methods Access Instance Variables?

Because:

```text
Static Members
```

are created before objects.

Instance variables exist only after object creation.

---

# Execution Order

```text
Class Loads

↓

Static Variables

↓

Static Blocks

↓

main()

↓

Objects Created

↓

Constructors
```

---

# Why is main() Static?

Entry point:

```java
public static void main(String[] args)
```

Reason:

Java should execute:

```text
main()
```

without creating an object.

If main were not static:

```java
Main obj = new Main();

obj.main();
```

Java would need an object before starting the program.

---

# Static Block

Static blocks execute once when the class loads.

Syntax

```java
static {

}
```

---

# Example

```java
public class Main {

    static {

        System.out.println("Static Block");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

---

# Output

```text
Static Block

Main Method
```

---

# Multiple Static Blocks

```java
public class Main {

    static {

        System.out.println("First");
    }

    static {

        System.out.println("Second");
    }

    public static void main(String[] args) {

        System.out.println("Main");
    }
}
```

Output

```text
First

Second

Main
```

---

# Static Nested Class

A nested class can also be static.

Example

```java
class Outer {

    static class Inner {

        void display() {

            System.out.println("Static Inner Class");
        }
    }
}
```

---

Using It

```java
Outer.Inner obj =
        new Outer.Inner();

obj.display();
```

---

Output

```text
Static Inner Class
```

---

# Static Import

Instead of

```java
Math.sqrt(25);
```

we can write

```java
import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {

        System.out.println(sqrt(25));
    }
}
```

Output

```text
5.0
```

---

# Real-World Example

Bank

```text
Account Number

↓

Instance

----------------

Bank Name

↓

Static
```

---

Employee

```text
Employee ID

↓

Instance

----------------

Company Name

↓

Static
```

---

# Memory Diagram

```text
Student Class

-------------------

college

-------------------

        ▲

        │

-------------------
Student Object 1

name

-------------------

Student Object 2

name

-------------------
```

---

# Common Mistakes

## Accessing Instance Variable

Wrong

```java
public static void display() {

    System.out.println(name);
}
```

---

## Using this

Wrong

```java
public static void show() {

    System.out.println(this.name);
}
```

Compilation Error.

---

## Creating Object for Static Members

Wrong

```java
Student s = new Student();

System.out.println(s.college);
```

Correct

```java
System.out.println(Student.college);
```

---

# Interview Questions

## What is static?

Belongs to the class instead of the object.

---

## Can static methods access instance variables?

No.

---

## Can instance methods access static variables?

Yes.

---

## Why is main() static?

Because Java executes it without creating an object.

---

## How many copies of a static variable exist?

Only one.

---

# Practice Challenges

## Challenge 1

Create:

```java
Student
```

with

```java
static collegeName
```

---

## Challenge 2

Count number of objects created using:

```java
static int count;
```

---

## Challenge 3

Create a utility class with:

```java
square()

cube()
```

as static methods.

---

## Challenge 4

Demonstrate execution order using static blocks.

---

## Challenge 5

Create a static nested class.

---

# Key Takeaways

- Static members belong to the class.
- Only one copy of a static variable exists.
- Static methods can be called without creating objects.
- Static methods cannot directly access instance variables.
- `main()` is static because Java starts execution without objects.
- Static blocks execute when the class loads.
- Static improves memory efficiency for common data.

---

# Conclusion

The `static` keyword is one of the most important features in Java. It allows members to belong to the class rather than individual objects, reducing memory usage and enabling utility methods, shared variables, and class-level initialization. Understanding `static` is essential for writing efficient, maintainable, and professional Java applications.
