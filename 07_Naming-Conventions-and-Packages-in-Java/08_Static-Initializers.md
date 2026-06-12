# Static Initializers (Static Blocks) in Java

## Introduction

In Java, sometimes we need to perform some initialization **before the `main()` method executes**.

For example:

- Load configuration values
- Connect to a database
- Initialize static variables
- Print startup messages
- Load drivers

Instead of writing this code inside the `main()` method, Java provides **Static Initializers**, also known as **Static Blocks**.

A static block is executed **only once**, when the class is loaded into memory.

---

# What is a Static Initializer?

A **Static Initializer** is a block of code that is executed automatically **when the class is loaded**.

Syntax:

```java
static {

    // Initialization Code
}
```

It runs before:

- Constructors
- Objects
- main() method

---

# Why Do We Need Static Initializers?

Suppose a program needs to initialize a company name before creating any objects.

Without a static block:

```java
public static void main(String[] args) {

    companyName = "OpenAI";
}
```

Every programmer has to remember to initialize it.

Instead, use a static block.

```java
static {

    companyName = "OpenAI";
}
```

Now Java initializes it automatically.

---

# Execution Order

```text
Class Loads
      │
      ▼

Static Variables
      │
      ▼

Static Initializer Block
      │
      ▼

main() Method
      │
      ▼

Object Creation
      │
      ▼

Constructor
```

---

# First Static Block Program

```java
public class Main {

    static {

        System.out.println("Static Block Executed");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

---

# Output

```text
Static Block Executed

Main Method
```

---

# Understanding the Output

When Java starts:

```text
Load Class
```

↓

Execute

```java
static {

}
```

↓

Call

```java
main()
```

---

# Program Flow

```text
Program Starts
      │
      ▼

Class Loaded
      │
      ▼

Static Block Executes
      │
      ▼

main() Executes
```

---

# Static Variable Initialization

Example

```java
public class Student {

    static String college;

    static {

        college = "KGiSL";
    }

    public static void main(String[] args) {

        System.out.println(college);
    }
}
```

---

# Output

```text
KGiSL
```

---

# Multiple Static Blocks

A class can contain multiple static blocks.

Example

```java
public class Main {

    static {

        System.out.println("First Static Block");
    }

    static {

        System.out.println("Second Static Block");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

---

# Output

```text
First Static Block

Second Static Block

Main Method
```

---

# Execution Order

Java executes static blocks **from top to bottom**.

```text
Static Block 1

↓

Static Block 2

↓

Static Block 3

↓

main()
```

---

# Static Variable + Static Block

```java
public class Employee {

    static String companyName;

    static {

        companyName = "Google";

        System.out.println("Company Initialized");
    }

    public static void main(String[] args) {

        System.out.println(companyName);
    }
}
```

---

# Output

```text
Company Initialized

Google
```

---

# Static Block and Object Creation

```java
public class Main {

    static {

        System.out.println("Static Block");
    }

    public Main() {

        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        Main obj = new Main();
    }
}
```

---

# Output

```text
Static Block

Constructor
```

---

# Why?

Execution order:

```text
Class Loads

↓

Static Block

↓

Object Created

↓

Constructor
```

---

# Multiple Objects

```java
public class Main {

    static {

        System.out.println("Static Block");
    }

    public Main() {

        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        Main obj1 = new Main();

        Main obj2 = new Main();
    }
}
```

---

# Output

```text
Static Block

Constructor

Constructor
```

Notice:

```text
Static Block
```

runs only once.

Constructors run for every object.

---

# Static Block with Static Variable

```java
public class Counter {

    static int count;

    static {

        count = 100;
    }

    public static void main(String[] args) {

        System.out.println(count);
    }
}
```

---

# Output

```text
100
```

---

# Static Block Cannot Access Instance Variables

Wrong

```java
public class Student {

    int age = 20;

    static {

        System.out.println(age);
    }
}
```

---

# Output

```text
Compilation Error
```

Reason:

Static block belongs to:

```text
Class
```

Instance variables belong to:

```text
Object
```

Objects don't exist yet.

---

# Static Block Can Access Static Variables

```java
public class Student {

    static int count = 10;

    static {

        System.out.println(count);
    }

    public static void main(String[] args) {

    }
}
```

---

# Output

```text
10
```

---

# Real-World Example

Loading Database Driver

```java
class Database {

    static {

        System.out.println("Database Driver Loaded");
    }
}
```

The driver loads only once.

---

# Memory Representation

```text
Class Loaded

-------------------

Static Variables

Static Block

-------------------

Objects

Object 1

Object 2

Object 3
```

Static block is stored once.

---

# Internal Working

```text
Java Starts
      │
      ▼

Class Loader Loads Class
      │
      ▼

Execute Static Variables
      │
      ▼

Execute Static Block
      │
      ▼

Call main()
      │
      ▼

Create Objects
      │
      ▼

Call Constructor
```

---

# Difference Between Static Block and Constructor

| Static Block | Constructor |
|---------------|-------------|
| Executes once | Executes every object |
| Runs before main() | Runs after object creation |
| Belongs to Class | Belongs to Object |
| Used for class initialization | Used for object initialization |

---

# Difference Between Static Variable and Static Block

| Static Variable | Static Block |
|-----------------|--------------|
| Stores data | Executes code |
| Declared with `static` | Declared using `static {}` |
| Initialized automatically | Runs automatically once |

---

# Common Mistakes

## Accessing Instance Variables

Wrong

```java
int age = 20;

static {

    System.out.println(age);
}
```

---

## Expecting Static Block to Run Every Object

Wrong assumption.

Static block executes only once.

---

## Using Constructor Instead of Static Block

If initialization is common to all objects,

use:

```java
static {

}
```

---

# Interview Questions

## What is a Static Initializer?

A block that executes when the class is loaded.

---

## When is a Static Block Executed?

Before the `main()` method.

---

## How Many Times Does a Static Block Execute?

Only once.

---

## Can a Class Have Multiple Static Blocks?

Yes.

They execute in order.

---

## Can Static Blocks Access Instance Variables?

No.

---

## Can Static Blocks Access Static Variables?

Yes.

---

# Practice Challenges

## Challenge 1

Create two static blocks.

Print different messages.

---

## Challenge 2

Initialize a static variable using a static block.

---

## Challenge 3

Create three objects.

Observe how many times the static block executes.

---

## Challenge 4

Create a constructor and compare its execution with the static block.

---

## Challenge 5

Create a database class that loads configuration using a static block.

---

# Concept Map

```text
Class Loads
      │
      ▼

Static Variables
      │
      ▼

Static Initializer
      │
      ▼

main()
      │
      ▼

Objects
      │
      ▼

Constructors
```

---

# Key Takeaways

- Static Initializers are also called Static Blocks.
- Static blocks execute automatically when the class loads.
- They run before the `main()` method.
- Static blocks execute only once.
- Multiple static blocks execute from top to bottom.
- Static blocks can access static members but not instance members.
- They are mainly used for one-time initialization.

---

# Conclusion

Static Initializers provide a powerful way to initialize class-level resources before the program begins execution. They are commonly used in enterprise applications for loading configurations, initializing static variables, registering drivers, and preparing resources that are shared across all objects. Understanding static blocks helps you write cleaner, more efficient, and professional Java applications.
