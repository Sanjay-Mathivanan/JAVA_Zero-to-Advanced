# Visibility and Access Control in Java

## Introduction

When developing Java applications, it is important to control **who can access your variables, methods, constructors, and classes**.

Imagine you have a bank account. You don't want everyone to directly modify your account balance. Instead, you allow users to deposit or withdraw money through specific methods.

Java provides **Access Modifiers** to control the visibility of class members.

Visibility determines **where a member can be accessed**.

---

# What is Visibility?

Visibility defines:

```text
Who can access a class,
variable, method,
or constructor.
```

Java provides four access levels:

- Public
- Protected
- Default (Package-Private)
- Private

These are collectively known as:

```text
Access Modifiers
```

---

# Why Do We Need Access Control?

Suppose we have:

```java
class BankAccount {

    double balance = 50000;
}
```

Anyone can modify:

```java
account.balance = -100000;
```

This is dangerous.

Instead, we make it:

```java
private double balance;
```

Now the balance can only be modified using controlled methods.

---

# Access Modifiers Overview

| Modifier | Same Class | Same Package | Subclass | Different Package |
|------------|:----------:|:------------:|:---------:|:-----------------:|
| public | Yes | Yes | Yes | Yes |
| protected | Yes | Yes | Yes | No* |
| default | Yes | Yes | No | No |
| private | Yes | No | No | No |

> *Protected members are accessible in subclasses even if they are in different packages.

---

# 1. Public Access Modifier

A public member can be accessed from anywhere.

Syntax:

```java
public int age;
```

Example:

```java
public class Student {

    public String name = "Sanjay";
}
```

Main Class

```java
public class Main {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.name);
    }
}
```

Output

```text
Sanjay
```

---

# When to Use Public?

Use `public` when the member should be accessible from anywhere.

Examples:

- Utility methods
- API methods
- Main classes

---

# 2. Private Access Modifier

Private members are accessible **only inside the same class**.

Syntax:

```java
private int age;
```

Example

```java
public class Student {

    private int age = 20;

    public void display() {

        System.out.println(age);
    }
}
```

Output

```text
20
```

---

# Invalid Example

```java
Student s = new Student();

System.out.println(s.age);
```

Output

```text
Compilation Error
```

Reason:

```text
age is private
```

---

# Accessing Private Variables

Private variables are usually accessed using:

```java
Getter

Setter
```

Example

```java
public class Student {

    private int age = 20;

    public int getAge() {

        return age;
    }
}
```

Main

```java
Student s = new Student();

System.out.println(s.getAge());
```

Output

```text
20
```

---

# When to Use Private?

Use private for:

- Passwords
- Bank Balance
- Salary
- PIN
- Internal Data

---

# 3. Default Access Modifier

If no modifier is specified, Java uses:

```text
Default Access
```

Also called:

```text
Package-Private
```

Example

```java
class Student {

    String name = "Sanjay";
}
```

The variable can be accessed only within the same package.

---

# Same Package Example

Package:

```text
student
```

Student.java

```java
package student;

public class Student {

    String name = "Sanjay";
}
```

Main.java

```java
package student;

public class Main {

    public static void main(String[] args) {

        Student s = new Student();

        System.out.println(s.name);
    }
}
```

Output

```text
Sanjay
```

---

# Different Package

Package:

```text
teacher
```

Trying to access:

```java
s.name;
```

Output

```text
Compilation Error
```

---

# 4. Protected Access Modifier

Protected members are accessible:

- Inside the same class
- Inside the same package
- In subclasses

Example

```java
class Animal {

    protected void sound() {

        System.out.println("Animal Sound");
    }
}
```

Child Class

```java
class Dog extends Animal {

    public void bark() {

        sound();
    }
}
```

Output

```text
Animal Sound
```

---

# Understanding Access Levels

```text
private
    │
    ▼

Same Class

----------------

default
    │
    ▼

Same Package

----------------

protected
    │
    ▼

Package + Child Class

----------------

public
    │
    ▼

Everywhere
```

---

# Real-World Analogy

Imagine a house.

```text
Private Room
    │
    ▼
Owner Only

Living Room
    │
    ▼
Family Members

Garden
    │
    ▼
Neighbours

Road
    │
    ▼
Everyone
```

Similarly:

```text
private

↓

default

↓

protected

↓

public
```

---

# Memory Representation

```text
Student Object

----------------------

private age

public name

protected marks

default city

----------------------
```

Access depends on where the code is executed.

---

# Which Modifier Should You Choose?

| Situation | Modifier |
|------------|----------|
| Everyone can access | public |
| Only current class | private |
| Same package | default |
| Same package + subclass | protected |

---

# Best Practices

## Prefer Private

Make variables private.

Expose only required methods.

Example:

```java
private double balance;
```

---

## Avoid Public Variables

Bad

```java
public double balance;
```

Good

```java
private double balance;
```

Use getters and setters.

---

# Common Mistakes

## Using Public for Everything

Bad practice.

Encapsulation is broken.

---

## Forgetting Getter

Private variables cannot be accessed directly.

---

## Confusing Default and Protected

Default:

```text
Same Package Only
```

Protected:

```text
Same Package

+

Child Classes
```

---

# Interview Questions

### What are the four access modifiers?

- public
- protected
- default
- private

---

### Which modifier provides maximum visibility?

```text
public
```

---

### Which modifier provides minimum visibility?

```text
private
```

---

### What is Default Access?

Package-private access.

---

### Why should variables usually be private?

To achieve encapsulation and protect data.

---

# Practice Challenges

## Challenge 1

Create a Student class with:

```java
private int age;
```

Access it using a getter.

---

## Challenge 2

Create a public method.

Call it from another class.

---

## Challenge 3

Create two packages.

Try accessing a default variable.

Observe the error.

---

## Challenge 4

Create a protected method.

Access it using inheritance.

---

## Challenge 5

Convert a class with public variables into a properly encapsulated class using private variables and getters/setters.

---

# Concept Map

```text
Access Modifiers
        │
        ▼

Public
        │
        ▼
Accessible Everywhere

----------------------

Protected
        │
        ▼
Package + Subclasses

----------------------

Default
        │
        ▼
Same Package

----------------------

Private
        │
        ▼
Same Class Only
```

---

# Key Takeaways

- Visibility controls access to class members.
- Java provides four access modifiers.
- Private is the most secure modifier.
- Public is the most accessible modifier.
- Default works only within the same package.
- Protected supports inheritance.
- Proper use of access modifiers improves encapsulation and security.

---

# Conclusion

Visibility and Access Control are fundamental concepts in Java that help developers protect data, enforce encapsulation, and build secure, maintainable applications. Choosing the correct access modifier is an important design decision in every Java project.
