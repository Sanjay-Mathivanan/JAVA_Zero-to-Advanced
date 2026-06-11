# Scope in Java

## Introduction

When writing Java programs, variables are not accessible everywhere in the program.

Every variable has a specific region where it can be accessed.

This region is called:

```text
Scope
```

Understanding scope is important because it helps:

- Prevent accidental data modification
- Improve code readability
- Reduce bugs
- Manage memory efficiently

---

# What is Scope?

Scope defines:

```text
Where a variable,
method, or object
can be accessed
inside a program.
```

Example:

```java
public class Main {

    public static void main(String[] args) {

        int age = 21;

        System.out.println(age);
    }
}
```

Output:

```text
21
```

Here:

```text
age
```

can only be used inside:

```java
main()
```

This is its scope.

---

# Real World Analogy

Imagine a classroom.

```text
Principal Office
      │
      ▼
Entire School Access

Class Teacher
      │
      ▼
Classroom Access

Student
      │
      ▼
Own Desk Access
```

Similarly:

```text
Class Variables
      ↓
Whole Class

Method Variables
      ↓
Only Inside Method

Block Variables
      ↓
Only Inside Block
```

---

# Types of Scope in Java

Java mainly provides:

```text
1. Local Scope

2. Method Scope

3. Block Scope

4. Class Scope

5. Package Scope
```

For beginners, the most important are:

```text
Local Scope
Block Scope
Class Scope
```

---

# Local Scope

A variable declared inside a method belongs to local scope.

It can only be used inside that method.

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 21;

        System.out.println(age);
    }
}
```

Output:

```text
21
```

---

## Invalid Example

```java
public class Main {

    public static void main(String[] args) {

        int age = 21;
    }

    public static void display() {

        System.out.println(age);
    }
}
```

Output:

```text
Compilation Error
```

Reason:

```text
age belongs to main()
```

and cannot be accessed outside it.

---

# Memory View

```text
main()
 │
 ├── age = 21
 │
 └── method ends

Variable Destroyed
```

Local variables exist only while the method executes.

---

# Block Scope

Variables declared inside:

```java
if

for

while

switch

{}
```

belong to block scope.

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        if(true) {

            int marks = 95;

            System.out.println(marks);
        }
    }
}
```

Output:

```text
95
```

---

## Invalid Example

```java
public class Main {

    public static void main(String[] args) {

        if(true) {

            int marks = 95;
        }

        System.out.println(marks);
    }
}
```

Output:

```text
Compilation Error
```

Reason:

```text
marks exists only
inside the if block
```

---

# Block Scope Diagram

```text
main()
 │
 ├── if block
 │      │
 │      └── marks
 │
 └── marks destroyed
```

---

# For Loop Scope

Variables declared inside a loop only exist within that loop.

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1;
            i <= 5;
            i++) {

            System.out.println(i);
        }
    }
}
```

Output:

```text
1
2
3
4
5
```

---

## Invalid Example

```java
public class Main {

    public static void main(String[] args) {

        for(int i = 1;
            i <= 5;
            i++) {

        }

        System.out.println(i);
    }
}
```

Output:

```text
Compilation Error
```

---

# Class Scope

Variables declared inside a class but outside methods are called:

```text
Instance Variables

or

Class Members
```

These variables can be accessed by all methods of the class.

---

## Example

```java
public class Student {

    String name = "Sanjay";

    public void display() {

        System.out.println(name);
    }

    public void print() {

        System.out.println(name);
    }
}
```

Here:

```text
name
```

can be accessed by both methods.

---

# Diagram

```text
Student Class
 │
 ├── name
 │
 ├── display()
 │
 └── print()
```

All methods can access:

```text
name
```

---

# Example Program

```java
public class Student {

    String name = "Sanjay";

    public void display() {

        System.out.println(name);
    }

    public static void main(String[] args) {

        Student s =
                new Student();

        s.display();
    }
}
```

Output:

```text
Sanjay
```

---

# Scope and Nested Blocks

Inner blocks can access outer variables.

Outer blocks cannot access inner variables.

---

## Example

```java
public class Main {

    public static void main(String[] args) {

        int a = 10;

        if(true) {

            int b = 20;

            System.out.println(a);
            System.out.println(b);
        }
    }
}
```

Output:

```text
10
20
```

---

# Invalid Example

```java
public class Main {

    public static void main(String[] args) {

        if(true) {

            int b = 20;
        }

        System.out.println(b);
    }
}
```

Output:

```text
Compilation Error
```

---

# Variable Shadowing

Sometimes a local variable has the same name as a class variable.

This is called:

```text
Variable Shadowing
```

---

## Example

```java
public class Student {

    String name = "Sanjay";

    public void display() {

        String name = "Rahul";

        System.out.println(name);
    }
}
```

Output:

```text
Rahul
```

The local variable hides the class variable.

---

# Accessing Class Variable Using this

```java
public class Student {

    String name = "Sanjay";

    public void display() {

        String name = "Rahul";

        System.out.println(name);

        System.out.println(this.name);
    }
}
```

Output:

```text
Rahul
Sanjay
```

---

# Scope in Methods

Parameters also have scope.

---

## Example

```java
public class Main {

    public static void greet(
            String name) {

        System.out.println(name);
    }

    public static void main(String[] args) {

        greet("Sanjay");
    }
}
```

Output:

```text
Sanjay
```

Parameter:

```text
name
```

exists only inside:

```java
greet()
```

---

# Common Mistakes

## Using Local Variable Outside Method

Wrong:

```java
public static void main(String[] args) {

    int age = 21;
}

System.out.println(age);
```

Compilation Error.

---

## Using Block Variable Outside Block

Wrong:

```java
if(true) {

    int x = 10;
}

System.out.println(x);
```

Compilation Error.

---

## Redeclaring Variable in Same Scope

Wrong:

```java
int age = 20;

int age = 25;
```

Compilation Error.

---

# Scope Hierarchy

```text
Class Scope
     │
     ▼
Method Scope
     │
     ▼
Block Scope
```

Inner scopes can access outer variables.

Outer scopes cannot access inner variables.

---

# Internal Working

```text
Program Starts
      │
      ▼

Method Created
      │
      ▼

Local Variables Allocated
      │
      ▼

Method Executes
      │
      ▼

Method Ends
      │
      ▼

Local Variables Removed
```

---

# Interview Questions

## What is Scope?

The region where a variable can be accessed.

---

## What is Local Scope?

Variables declared inside a method.

---

## What is Block Scope?

Variables declared inside blocks such as:

```java
if
for
while
```

---

## Can Outer Blocks Access Inner Variables?

No.

---

## Can Inner Blocks Access Outer Variables?

Yes.

---

## What is Variable Shadowing?

When a local variable hides a class variable.

---

# Practice Challenges

## Challenge 1

Create a variable inside:

```java
main()
```

and try accessing it in another method.

Observe the error.

---

## Challenge 2

Create a variable inside:

```java
if block
```

and use it outside.

Observe the error.

---

## Challenge 3

Create a class variable and access it from multiple methods.

---

## Challenge 4

Demonstrate variable shadowing.

---

## Challenge 5

Use:

```java
this
```

to access a hidden class variable.

---

# Concept Map

```text
Scope
 │
 ├── Class Scope
 │
 ├── Method Scope
 │
 └── Block Scope
        │
        ├── if
        ├── for
        ├── while
        └── switch

Inner Scope
      │
      ▼
Can Access Outer Scope

Outer Scope
      │
      ▼
Cannot Access Inner Scope
```

---

# Key Takeaways

- Scope determines where variables can be accessed.
- Local variables exist only inside methods.
- Block variables exist only inside blocks.
- Class variables are accessible throughout the class.
- Inner blocks can access outer variables.
- Outer blocks cannot access inner variables.
- Variable shadowing occurs when a local variable hides a class variable.

---

# Conclusion

Scope is a fundamental concept in Java that controls the visibility and lifetime of variables. Understanding scope helps write cleaner, safer, and more maintainable programs while preventing accidental access or modification of data.
