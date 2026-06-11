# Scope Example in Java

## Introduction

In the previous chapter, we learned about:

```text
Class Scope
Method Scope
Block Scope
Variable Shadowing
```

This chapter demonstrates all these concepts using a practical Java program.

We will learn:

- Public vs Private Variables
- Local Variables
- Variable Shadowing
- this Keyword
- Inner Classes
- Accessing Outer Class Variables

---

# Problem Statement

Consider the following class:

```java
public class ScopeOfVariable {

    public int publicVariable = 1;
    private int privateVariable = 1;

}
```

We have:

```text
publicVariable = 1

privateVariable = 1
```

Both belong to:

```text
Class Scope
```

because they are declared directly inside the class.

---

# Understanding Class Scope

```java
public class ScopeOfVariable {

    public int publicVariable = 1;
    private int privateVariable = 1;
}
```

Memory View:

```text
ScopeOfVariable Object
---------------------

publicVariable  = 1

privateVariable = 1

---------------------
```

These variables exist as long as the object exists.

---

# Example 1: Accessing Class Variables

## Code

```java
public void checkingScope(){

    System.out.println(
            "The Private Variable is "
            + privateVariable
            + " and the public Variable is "
            + publicVariable);
}
```

---

## Output

```text
The Private Variable is 1 and the public Variable is 1
```

---

# Why Does This Work?

Because:

```text
checkingScope()
```

belongs to the same class.

Therefore it can access:

```java
privateVariable
```

and

```java
publicVariable
```

directly.

---

# Example 2: Accessing Private Variable Using Getter

## Code

```java
public int getPrivateVariable() {

    return privateVariable;
}
```

---

## Main

```java
ScopeOfVariable scopeCheck =
        new ScopeOfVariable();

System.out.println(
        scopeCheck.getPrivateVariable());
```

---

## Output

```text
1
```

---

# Why Use Getter?

Direct access:

```java
scopeCheck.privateVariable
```

is not allowed because:

```java
privateVariable
```

is private.

So we use:

```java
getPrivateVariable()
```

---

# Example 3: Variable Shadowing

## Code

```java
public void multiplier(){

    int privateVariable = 3;

    for(int i = 0; i < 5; i++) {

        System.out.println(
                i +
                " multiplied by 3 is : "
                + (i * privateVariable));
    }
}
```

---

# Important Observation

Inside the method:

```java
int privateVariable = 3;
```

A new variable is created.

---

Class Variable:

```java
private int privateVariable = 1;
```

Method Variable:

```java
int privateVariable = 3;
```

---

# Variable Shadowing

```text
Class Variable
      │
      ▼

privateVariable = 1

      ▲

Hidden By

      │

Method Variable

privateVariable = 3
```

The local variable hides the class variable.

---

# Output

```text
0 multiplied by 3 is : 0

1 multiplied by 3 is : 3

2 multiplied by 3 is : 6

3 multiplied by 3 is : 9

4 multiplied by 3 is : 12
```

---

# Example 4: Using this Keyword

Modified Code:

```java
public void multiplier(){

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
```

---

# What is this.privateVariable?

```java
this.privateVariable
```

means:

```text
Use the Class Variable
```

instead of the local variable.

---

# Visualization

```text
Class Variable

this.privateVariable = 1


Local Variable

privateVariable = 3
```

---

# Output

```text
0 multiplied by 1 is : 0

1 multiplied by 1 is : 1

2 multiplied by 1 is : 2

3 multiplied by 1 is : 3

4 multiplied by 1 is : 4
```

---

# Understanding Inner Class

## Code

```java
public class InnerClass {

    int privateVariable = 4;
}
```

This creates another scope.

---

# Scope Hierarchy

```text
Main Class
     │
     ▼

ScopeOfVariable
     │
     ▼

InnerClass
```

---

# Inner Class Constructor

```java
public InnerClass(){

    System.out.println(
            "This is from innerClass, and the value for privateVar : "
            + privateVariable);
}
```

---

# Output

```text
This is from innerClass,
and the value for privateVar : 4
```

---

# Why 4?

Because:

```java
int privateVariable = 4;
```

belongs to:

```java
InnerClass
```

---

# Creating Inner Class Object

## Main Class

```java
ScopeOfVariable scopeCheck =
        new ScopeOfVariable();

ScopeOfVariable.InnerClass innerClass =
        scopeCheck.new InnerClass();
```

---

# Visualization

```text
ScopeOfVariable Object
          │
          ▼

     InnerClass Object
```

---

# Example 5: Accessing Outer Class Variable

## Code

```java
public void multiplier(){

    int privateVariable = 2;

    for(int i = 0; i < 5; i++) {

        System.out.println(
                i +
                " multiplied by "
                + ScopeOfVariable.this.privateVariable
                + " is : "
                + (i *
                ScopeOfVariable.this.privateVariable));
    }
}
```

---

# Why Not Use privateVariable?

Inside InnerClass we have:

```java
int privateVariable = 4;
```

Inside method:

```java
int privateVariable = 2;
```

Inside outer class:

```java
privateVariable = 1;
```

Now there are:

```text
3 Different Variables
```

with the same name.

---

# Scope Resolution

```text
Method Variable
privateVariable = 2

      │

      ▼

Inner Class Variable
privateVariable = 4

      │

      ▼

Outer Class Variable
privateVariable = 1
```

---

# Accessing Outer Variable

```java
ScopeOfVariable.this.privateVariable
```

means:

```text
Use the variable
from ScopeOfVariable class
```

---

# Output

```text
0 multiplied by 1 is : 0

1 multiplied by 1 is : 1

2 multiplied by 1 is : 2

3 multiplied by 1 is : 3

4 multiplied by 1 is : 4
```

---

# Complete Scope Diagram

```text
ScopeOfVariable

privateVariable = 1
        │
        ▼

InnerClass

privateVariable = 4
        │
        ▼

multiplier()

privateVariable = 2
```

---

# Variable Lookup Order

When Java sees:

```java
privateVariable
```

it searches:

```text
1. Current Block

2. Current Method

3. Current Class

4. Outer Class

5. Parent Classes
```

First match wins.

---

# Memory Representation

```text
ScopeOfVariable Object

--------------------------------

publicVariable  = 1

privateVariable = 1

--------------------------------

        │

        ▼

InnerClass Object

--------------------------------

privateVariable = 4

--------------------------------
```

---

# Key Concepts Learned

## Class Scope

```java
private int privateVariable = 1;
```

---

## Local Scope

```java
int privateVariable = 3;
```

---

## Variable Shadowing

```java
Local variable hides
Class variable
```

---

## this Keyword

```java
this.privateVariable
```

Access class variable.

---

## Inner Class

```java
class InnerClass
```

Creates a nested scope.

---

## Outer Class Access

```java
ScopeOfVariable.this.privateVariable
```

Access outer class variable.

---

# Interview Questions

### What is Variable Shadowing?

A local variable hides a class variable with the same name.

---

### What does this.variable mean?

Access the current object's variable.

---

### What does OuterClass.this.variable mean?

Access the outer class variable from an inner class.

---

### Can an Inner Class access Outer Class variables?

Yes.

---

### Which variable has higher priority?

```text
Local Variable

↓

Class Variable

↓

Outer Class Variable
```

---

# Key Takeaways

- Scope determines variable visibility.
- Local variables can hide class variables.
- `this` refers to the current object.
- Inner classes create additional scopes.
- `OuterClass.this.variable` accesses outer class members.
- Java searches from the nearest scope outward.

---

# Conclusion

This example demonstrates how Java handles scope, variable shadowing, inner classes, and the `this` keyword. Understanding these concepts is essential for writing clean, maintainable, and bug-free Java programs, especially in large applications where multiple variables may share the same name across different scopes.
