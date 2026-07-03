# Final Keyword in Java

## Introduction

While developing Java applications, there are situations where we want to prevent changes to variables, methods, or classes.

For example:

- A student's Roll Number should never change.
- The value of PI should remain constant.
- A security class should not be inherited.
- A calculation method should not be overridden.

To achieve this, Java provides the **final** keyword.

The `final` keyword is used to restrict modifications in Java.

---

# What is the Final Keyword?

The `final` keyword is a non-access modifier used to restrict changes.

It can be applied to:

- Variables
- Methods
- Classes
- Parameters

---

# Why Do We Need Final?

Suppose we declare:

```java
double PI = 3.14159;
```

Later someone changes it.

```java
PI = 10;
```

Now every calculation becomes incorrect.

Instead, we write:

```java
final double PI = 3.14159;
```

Now Java prevents modification.

---

# Real-World Analogy

Imagine your Date of Birth.

```text
Name
↓

Can Change

------------------

Address
↓

Can Change

------------------

Date of Birth
↓

Cannot Change
```

Similarly,

```text
Normal Variable
↓

Can Change

------------------

Final Variable
↓

Cannot Change
```

---

# Types of Final

The `final` keyword can be used with:

```text
1. Variables

2. Methods

3. Classes

4. Parameters
```

---

# Final Variable

A final variable can be assigned only once.

Syntax:

```java
final datatype variableName;
```

Example:

```java
final int AGE = 20;
```

---

# Example Program

```java
public class Main {

    public static void main(String[] args) {

        final int AGE = 20;

        System.out.println(AGE);
    }
}
```

---

# Output

```text
20
```

---

# Trying to Modify a Final Variable

```java
public class Main {

    public static void main(String[] args) {

        final int AGE = 20;

        AGE = 30;

        System.out.println(AGE);
    }
}
```

---

# Output

```text
Compilation Error

Cannot assign a value to final variable AGE
```

---

# Final Variables with Objects

A final reference cannot point to another object.

However,

the object's data can still be modified.

Example

```java
class Student {

    String name = "Sanjay";
}
```

Main

```java
public class Main {

    public static void main(String[] args) {

        final Student s = new Student();

        s.name = "Rahul";

        System.out.println(s.name);
    }
}
```

---

# Output

```text
Rahul
```

---

# Why?

The reference is final.

The object itself is not.

Memory:

```text
Reference
↓

Student Object

name = Rahul
```

Reference cannot change.

Object data can.

---

# Final Method

A final method cannot be overridden.

Example

```java
class Animal {

    public final void sound() {

        System.out.println("Animal Sound");
    }
}
```

---

Child Class

```java
class Dog extends Animal {

}
```

Works correctly.

---

Trying to Override

```java
class Dog extends Animal {

    @Override
    public void sound() {

        System.out.println("Dog Barks");
    }
}
```

---

Output

```text
Compilation Error
```

Reason

```text
Cannot override final method.
```

---

# Why Use Final Methods?

Use final methods when:

- Security is important.
- Business rules should not change.
- Parent implementation must remain fixed.

Example:

```text
Bank Login

Password Encryption

OTP Validation
```

---

# Final Class

A final class cannot be inherited.

Example

```java
final class Animal {

}
```

---

Trying to Extend

```java
class Dog extends Animal {

}
```

---

Output

```text
Compilation Error

Cannot inherit from final class
```

---

# Why Use Final Classes?

To prevent inheritance.

Examples:

- Security classes
- Immutable classes
- Utility classes

---

# Real Example

Java's

```java
String
```

class is final.

Reason:

Nobody should change how String works.

---

# Final Parameter

Parameters can also be final.

Example

```java
public void display(final int number) {

    System.out.println(number);
}
```

---

Trying to Modify

```java
public void display(final int number) {

    number = 100;
}
```

---

Output

```text
Compilation Error
```

---

# Blank Final Variable

A final variable can be initialized later.

Example

```java
class Student {

    final int rollNo;

    Student(int rollNo) {

        this.rollNo = rollNo;
    }

    public void display() {

        System.out.println(rollNo);
    }
}
```

Main

```java
public class Main {

    public static void main(String[] args) {

        Student s = new Student(101);

        s.display();
    }
}
```

---

# Output

```text
101
```

---

# Final vs Static Final

Final

```java
final int age = 20;
```

Belongs to an object.

---

Static Final

```java
static final double PI = 3.14159;
```

Belongs to the class.

Only one copy exists.

Usually used for constants.

---

# Example

```java
class MathConstants {

    static final double PI = 3.14159;
}
```

Main

```java
public class Main {

    public static void main(String[] args) {

        System.out.println(MathConstants.PI);
    }
}
```

---

# Output

```text
3.14159
```

---

# Memory Representation

```text
MathConstants Class

-------------------

PI

-------------------

Student Object

name

age

-------------------
```

---

# Final and Constructors

Final variables can be initialized:

- At declaration
- Inside constructor

Example

```java
class Student {

    final int id;

    Student(int id) {

        this.id = id;
    }
}
```

---

# Common Mistakes

## Changing Final Variable

Wrong

```java
final int age = 20;

age = 30;
```

---

## Overriding Final Method

Wrong

```java
public final void display() {

}

@Override

public void display() {

}
```

---

## Extending Final Class

Wrong

```java
final class Animal {

}

class Dog extends Animal {

}
```

---

# Real-World Examples

## Constants

```java
static final double PI = 3.14159;
```

---

## Bank Account Number

```java
final int accountNumber;
```

---

## Company ID

```java
final int employeeId;
```

---

## Government ID

```java
final String aadhaarNumber;
```

---

# Interview Questions

## What is the final keyword?

It restricts modification.

---

## Can final variables be modified?

No.

---

## Can final methods be overridden?

No.

---

## Can final classes be inherited?

No.

---

## Can final objects change their data?

Yes.

The reference is final.

The object is mutable.

---

## Difference Between final and finally?

| final | finally |
|--------|----------|
| Keyword | Block |
| Restricts modification | Used in Exception Handling |

---

## Difference Between final and finalize()

| final | finalize() |
|--------|-------------|
| Keyword | Method |
| Prevents modification | Garbage Collection Method |

---

# Practice Challenges

## Challenge 1

Create a final variable.

Try changing it.

---

## Challenge 2

Create a final method.

Try overriding it.

---

## Challenge 3

Create a final class.

Try extending it.

---

## Challenge 4

Create a blank final variable initialized inside the constructor.

---

## Challenge 5

Create a class with:

```java
static final double PI = 3.14159;
```

Calculate the area of a circle.

---

# Concept Map

```text
Final Keyword
      │
      ▼

Final Variable
      │
      ▼
Cannot Change

----------------------

Final Method
      │
      ▼
Cannot Override

----------------------

Final Class
      │
      ▼
Cannot Extend

----------------------

Final Parameter
      │
      ▼
Cannot Modify
```

---

# Key Takeaways

- `final` restricts modification.
- Final variables can be assigned only once.
- Final methods cannot be overridden.
- Final classes cannot be inherited.
- Final parameters cannot be modified.
- `static final` is commonly used for constants.
- `String` is a famous example of a final class.

---

# Conclusion

The `final` keyword is one of the most important features in Java for creating secure and immutable code. It helps protect data, prevent unwanted inheritance or overriding, and define constants. Understanding `final` is essential for writing reliable, maintainable, and professional Java applications.
