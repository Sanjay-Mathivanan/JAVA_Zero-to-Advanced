# Static vs Instance Members in Java

## Introduction

While learning Java classes and objects, you will frequently encounter two important concepts:

```java
static
```

and

```java
instance
```

Understanding the difference between them is essential because they determine:

- How memory is allocated
- How variables are shared
- How methods are called
- Object behavior

Many interview questions are based on this topic.

---

# The Big Picture

```text
Class Members
      │
      ├── Static Members
      │      ↓
      │   Belong To Class
      │
      └── Instance Members
             ↓
         Belong To Object
```

---

# What is an Instance Member?

## Definition

Instance members belong to an object.

Every object gets its own copy.

---

# Example

```java
class Student {

    String name;

}
```

Here:

```java
name
```

is an instance variable.

---

# Object Creation

```java
Student s1 = new Student();
Student s2 = new Student();
```

Assign values:

```java
s1.name = "Sanjay";

s2.name = "Rahul";
```

---

# Output

```java
System.out.println(s1.name);
System.out.println(s2.name);
```

```text
Sanjay
Rahul
```

---

# Memory Representation

```text
Heap Memory

Object 1
-----------
name = Sanjay
-----------

Object 2
-----------
name = Rahul
-----------
```

Each object has its own copy.

---

# What is a Static Member?

## Definition

Static members belong to the class itself.

Only one copy exists regardless of how many objects are created.

---

# Example

```java
class Student {

    static String college =
            "KIT";

}
```

---

# Object Creation

```java
Student s1 = new Student();
Student s2 = new Student();
```

---

# Access

```java
System.out.println(
        Student.college);
```

Output:

```text
KIT
```

---

# Memory Representation

```text
Method Area

college = KIT


Heap

Student Object 1

Student Object 2

Student Object 3
```

Only one copy exists.

---

# Real-World Analogy

## Instance Variable

```text
Student Name
```

Every student has a different name.

---

## Static Variable

```text
College Name
```

All students belong to the same college.

---

# Instance Variable Example

```java
class Student {

    String name;

}

public class Main {

    public static void main(String[] args) {

        Student s1 =
                new Student();

        Student s2 =
                new Student();

        s1.name = "Sanjay";
        s2.name = "Arun";

        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
```

---

# Output

```text
Sanjay
Arun
```

---

# Static Variable Example

```java
class Student {

    static String college =
            "KIT";

}

public class Main {

    public static void main(String[] args) {

        Student s1 =
                new Student();

        Student s2 =
                new Student();

        System.out.println(
                s1.college);

        System.out.println(
                s2.college);
    }
}
```

---

# Output

```text
KIT
KIT
```

---

# Why Use Static Variables?

Suppose:

```text
1000 Students
```

and every object stores:

```java
college = "KIT"
```

Memory waste.

Static stores only one copy.

---

# Static Variable Example (Counter)

```java
class Student {

    static int count = 0;

    public Student() {

        count++;

    }
}
```

---

# Main Program

```java
public class Main {

    public static void main(String[] args) {

        new Student();
        new Student();
        new Student();

        System.out.println(
                Student.count);
    }
}
```

---

# Output

```text
3
```

---

# Why?

Every constructor execution increases:

```java
count++
```

Since count is static:

```text
One Shared Copy
```

tracks all objects.

---

# What is an Instance Method?

Instance methods belong to objects.

---

# Example

```java
class Student {

    String name;

    public void display() {

        System.out.println(name);

    }
}
```

---

# Calling Instance Method

```java
Student s1 =
        new Student();

s1.display();
```

Requires object creation.

---

# What is a Static Method?

Static methods belong to the class.

No object required.

---

# Example

```java
class Calculator {

    public static int add(
            int a,
            int b) {

        return a + b;
    }
}
```

---

# Calling Static Method

```java
System.out.println(
        Calculator.add(10,20));
```

Output:

```text
30
```

---

# Why is main() Static?

Java starts execution before any object exists.

Therefore:

```java
public static void main(String[] args)
```

must be static.

---

# Instance Method Example

```java
class Student {

    String name;

    public void display() {

        System.out.println(name);

    }
}
```

---

# Static Method Example

```java
class Calculator {

    public static int square(
            int number) {

        return number * number;
    }
}
```

---

# Output

```java
System.out.println(
        Calculator.square(5));
```

```text
25
```

---

# Static Block

A static block executes once when the class loads.

---

# Example

```java
class Test {

    static {

        System.out.println(
                "Static Block Executed");

    }
}
```

---

# Output

```text
Static Block Executed
```

---

# Static vs Instance Variables

| Static Variable | Instance Variable |
|----------------|------------------|
| Belongs to Class | Belongs to Object |
| One Copy | Multiple Copies |
| Shared | Individual |
| Access Using Class Name | Access Using Object |

---

# Static vs Instance Methods

| Static Method | Instance Method |
|--------------|----------------|
| Belongs to Class | Belongs to Object |
| No Object Required | Object Required |
| Can Access Static Members Directly | Can Access Both |
| Cannot Use this | Can Use this |

---

# Important Rule

Inside a static method:

```java
public static void display() {

}
```

You cannot directly access:

```java
name
```

because:

```text
No Object Exists
```

---

# Example

Wrong:

```java
class Student {

    String name;

    public static void show() {

        System.out.println(name);

    }
}
```

Compiler Error.

---

# Correct

```java
class Student {

    String name;

    public static void show() {

        System.out.println(
                "Static Method");

    }
}
```

---

# Interview Example

```java
class Test {

    static int x = 10;

    int y = 20;
}
```

Identify:

```text
x → Static Variable

y → Instance Variable
```

---

# Memory Diagram

```text
Class Area

x = 10


Heap

Object 1
y = 20

Object 2
y = 20
```

---

# Real-World Applications

## Static

```text
Math Utility Methods

Counters

Configuration Values

Constants

Company Name
```

---

## Instance

```text
Student Name

Employee Salary

Car Color

Bank Balance
```

---

# Common Mistakes

## Access Instance Variable Inside Static Method

Wrong:

```java
System.out.println(name);
```

---

## Calling Static Method Through Object

Allowed:

```java
obj.display();
```

But preferred:

```java
ClassName.display();
```

---

## Assuming Static Variables Create New Copies

Wrong.

Only one copy exists.

---

# Interview Questions

## What is a Static Variable?

A variable shared by all objects of a class.

---

## What is an Instance Variable?

A variable that belongs to an object.

---

## Can Static Methods Access Instance Variables?

No.

Directly they cannot.

---

## Can Instance Methods Access Static Variables?

Yes.

---

## Why is main() Static?

Because Java needs to execute it before creating objects.

---

## How Many Copies of Static Variables Exist?

One.

---

## How Many Copies of Instance Variables Exist?

One per object.

---

# Practice Challenges

## Challenge 1

Create a Student counter using static variables.

---

## Challenge 2

Create a Calculator class using static methods.

---

## Challenge 3

Create Employee objects with instance variables.

---

## Challenge 4

Track total employees using a static counter.

---

## Challenge 5

Create a Company class with:

```java
static companyName

instance employeeName
```

---

# Concept Map

```text
Class Members
      │
      ├── Static
      │      │
      │      ├── Variables
      │      ├── Methods
      │      └── Blocks
      │
      └── Instance
             │
             ├── Variables
             └── Methods
```

---

# Key Takeaways

- Static members belong to the class.
- Instance members belong to objects.
- Static variables have one shared copy.
- Instance variables have separate copies.
- Static methods can be called without objects.
- Instance methods require objects.
- main() is static because execution starts before object creation.
- Static members help save memory and share data.

---

# Conclusion

Static and Instance members are fundamental concepts in Java. Static members belong to the class and are shared among all objects, while instance members belong to individual objects. Understanding when to use each is essential for writing efficient, scalable, and interview-ready Java applications.
