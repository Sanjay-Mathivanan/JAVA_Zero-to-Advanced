# Scope Example in Java

## Introduction

In this chapter, we will learn how Java handles variables in different scopes using a practical example.

This program demonstrates:

- Class Scope
- Local Scope
- Block Scope
- Variable Shadowing
- `this` Keyword
- Inner Classes
- `OuterClass.this`

Understanding this example is important because many Java interview questions are based on scope resolution and variable shadowing.

---

# Problem Statement

Create a program that demonstrates how Java resolves variables when the same variable name exists in multiple scopes.

The program should show:

- A variable inside the `main()` method.
- A variable inside the outer class.
- A variable inside an inner class.
- A variable inside a method.

The program should also demonstrate:

- How local variables hide class variables.
- How `this` accesses the current object's variable.
- How `OuterClass.this` accesses the outer class variable.

---

# Full Code

## Main.java

```java
public class Main {

    public static void main(String[] args) {

        int privateVariable = 10;

        ScopeOfVariable scopeCheck =
                new ScopeOfVariable();

        ScopeOfVariable.InnerClass innerClass =
                scopeCheck.new InnerClass();

        innerClass.multiplier();
    }
}
```

---

## ScopeOfVariable.java

```java
public class ScopeOfVariable {

    public int publicVariable = 1;

    private int privateVariable = 1;

    public void checkingScope() {

        System.out.println(
                "The Private Variable is "
                + privateVariable
                + " and the public Variable is "
                + publicVariable);
    }

    public int getPrivateVariable() {

        return privateVariable;
    }

    public void multiplier() {

        int privateVariable = 3;

        for(int i = 0; i < 5; i++) {

            System.out.println(
                    i +
                    " multiplied by "
                    + this.privateVariable
                    + " is : "
                    + (i * this.privateVariable));
        }
    }

    public class InnerClass {

        int privateVariable = 4;

        public InnerClass() {

            System.out.println(
                    "This is from InnerClass, and the value for privateVar : "
                    + privateVariable);
        }

        public void multiplier() {

            int privateVariable = 2;

            for(int i = 0; i < 5; i++) {

                System.out.println(
                        i +
                        " multiplied by "
                        + ScopeOfVariable.this.privateVariable
                        + " is : "
                        + (i * ScopeOfVariable.this.privateVariable));
            }
        }
    }
}
```

---

# Output

```text
This is from InnerClass, and the value for privateVar : 4

0 multiplied by 1 is : 0
1 multiplied by 1 is : 1
2 multiplied by 1 is : 2
3 multiplied by 1 is : 3
4 multiplied by 1 is : 4
```

---

# Understanding the Problem

This program contains four different variables with the same name:

```java
privateVariable
```

---

## Variable 1

Inside `main()`

```java
int privateVariable = 10;
```

Scope:

```text
Only inside main()
```

---

## Variable 2

Inside `ScopeOfVariable`

```java
private int privateVariable = 1;
```

Scope:

```text
Entire ScopeOfVariable class
```

---

## Variable 3

Inside `multiplier()`

```java
int privateVariable = 3;
```

Scope:

```text
Only inside multiplier()
```

---

## Variable 4

Inside `InnerClass`

```java
int privateVariable = 4;
```

Scope:

```text
Entire InnerClass
```

---

# Scope Hierarchy

```text
Main Method
│
├── privateVariable = 10
│
▼

ScopeOfVariable
│
├── privateVariable = 1
│
▼

InnerClass
│
├── privateVariable = 4
│
▼

multiplier()
│
└── privateVariable = 2
```

---

# Program Flow

```text
main()
    │
    ▼

Create ScopeOfVariable Object
    │
    ▼

Create InnerClass Object
    │
    ▼

InnerClass Constructor Executes
    │
    ▼

Call multiplier()
    │
    ▼

Print Multiplication Table
```

---

# Step-by-Step Execution

## Step 1

Program starts.

```java
public static void main(String[] args)
```

---

## Step 2

Create local variable.

```java
int privateVariable = 10;
```

This variable belongs only to:

```text
main()
```

---

## Step 3

Create outer class object.

```java
ScopeOfVariable scopeCheck =
        new ScopeOfVariable();
```

Memory:

```text
publicVariable = 1

privateVariable = 1
```

---

## Step 4

Create InnerClass object.

```java
ScopeOfVariable.InnerClass innerClass =
        scopeCheck.new InnerClass();
```

Constructor executes automatically.

```java
public InnerClass()
```

Output:

```text
This is from InnerClass, and the value for privateVar : 4
```

---

## Step 5

Call:

```java
innerClass.multiplier();
```

---

# Understanding Variable Shadowing

Inside:

```java
public void multiplier()
```

we create:

```java
int privateVariable = 2;
```

But we already have:

```java
privateVariable = 4
```

inside InnerClass.

And:

```java
privateVariable = 1
```

inside ScopeOfVariable.

Now three variables have the same name.

---

# Variable Resolution Order

Java searches variables in this order:

```text
Current Block
      ↓
Current Method
      ↓
Current Class
      ↓
Outer Class
      ↓
Parent Class
```

The nearest variable is used.

---

# Understanding this Keyword

Example:

```java
this.privateVariable
```

Meaning:

```text
Use the current object's variable.
```

For InnerClass:

```java
this.privateVariable
```

refers to:

```java
privateVariable = 4
```

---

# Understanding OuterClass.this

Example:

```java
ScopeOfVariable.this.privateVariable
```

Meaning:

```text
Go to ScopeOfVariable

Use its privateVariable
```

Value:

```java
privateVariable = 1
```

Therefore:

```java
ScopeOfVariable.this.privateVariable
```

returns:

```text
1
```

---

# Iteration Breakdown

## i = 0

```java
0 * 1
```

Output:

```text
0 multiplied by 1 is : 0
```

---

## i = 1

```java
1 * 1
```

Output:

```text
1 multiplied by 1 is : 1
```

---

## i = 2

```java
2 * 1
```

Output:

```text
2 multiplied by 1 is : 2
```

---

## i = 3

```java
3 * 1
```

Output:

```text
3 multiplied by 1 is : 3
```

---

## i = 4

```java
4 * 1
```

Output:

```text
4 multiplied by 1 is : 4
```

---

# Memory Representation

```text
Main Method
│
├── privateVariable = 10
│
▼

ScopeOfVariable Object
│
├── publicVariable = 1
├── privateVariable = 1
│
▼

InnerClass Object
│
├── privateVariable = 4
│
▼

multiplier()
│
├── privateVariable = 2
│
└── i = 0 → 4
```

---

# Code Line Explanation

## Outer Class Variable

```java
private int privateVariable = 1;
```

Class-level variable.

Accessible throughout the outer class.

---

## Local Variable

```java
int privateVariable = 3;
```

Method-level variable.

Hides the class variable.

---

## Current Object Reference

```java
this.privateVariable
```

Accesses the current object's variable.

---

## Outer Class Reference

```java
ScopeOfVariable.this.privateVariable
```

Accesses the outer class variable.

---

## Inner Class Object Creation

```java
ScopeOfVariable.InnerClass innerClass =
        scopeCheck.new InnerClass();
```

Creates an object of the inner class.

---

# Key Concepts Learned

## Class Scope

Variables declared directly inside a class.

---

## Local Scope

Variables declared inside methods.

---

## Variable Shadowing

Local variables hide outer variables with the same name.

---

## this Keyword

Refers to the current object.

---

## Inner Class

A class defined inside another class.

---

## OuterClass.this

Accesses members of the outer class from an inner class.

---

# Interview Questions

### What is Scope?

The region where a variable can be accessed.

### What is Variable Shadowing?

When a local variable hides another variable with the same name.

### What does `this` refer to?

The current object.

### What does `OuterClass.this` refer to?

The outer class object.

### Can an Inner Class access Outer Class variables?

Yes.

---

# Key Takeaways

- Scope determines variable visibility.
- Local variables have higher priority than class variables.
- Variable shadowing occurs when names are duplicated.
- `this` accesses the current object's members.
- `OuterClass.this` accesses the outer object's members.
- Inner classes create an additional level of scope.

---

# Conclusion

This example provides a complete understanding of Java scope resolution. It demonstrates how Java handles variables declared in different locations, how variable shadowing works, and how `this` and `OuterClass.this` help resolve ambiguity when multiple variables share the same name.
