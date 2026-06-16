# Anonymous Inner Classes in Java

> **Chapter 09 - Advanced Java Class Concepts**

---

# Introduction

In the previous chapter, we learned about **Local Inner Classes**, where we create a class inside a method.

But what if we need a class **only once**?

Creating a separate class or even a local inner class may be unnecessary.

Java provides a solution called the **Anonymous Inner Class**.

An Anonymous Inner Class allows us to create **an object and define its implementation at the same time**, **without giving the class a name**.

This feature is commonly used in:

- Event Handling
- GUI Programming (Swing/JavaFX)
- Threads
- Callbacks
- Collections
- Comparator
- Runnable
- Frameworks like Spring and Android

---

# Problem Statement

Suppose we have an interface:

```java
interface Animal {

    void sound();

}
```

Normally, we create a class.

```
Animal

      ▲

      │

Dog
```

Example

```java
class Dog implements Animal {

    public void sound() {

        System.out.println("Dog Barks");

    }

}
```

But if we need this implementation **only once**, creating an entire class is unnecessary.

Anonymous Inner Classes solve this problem.

---

# Why Do We Need Anonymous Inner Classes?

Imagine a school function.

A teacher needs **one student** to make an announcement.

Instead of creating a permanent committee,

the teacher simply asks one student to come forward.

After the announcement,

the job is finished.

Similarly,

Anonymous Inner Classes are used for **one-time implementations**.

---

# Definition

An **Anonymous Inner Class** is a class **without a name** that is declared and instantiated at the same time.

It is used when an object is needed only once.

---

# Syntax

## Using a Class

```java
ClassName obj = new ClassName() {

    // Override methods

};
```

---

## Using an Interface

```java
InterfaceName obj = new InterfaceName() {

    @Override
    public void method() {

    }

};
```

---

## Using an Abstract Class

```java
AbstractClass obj = new AbstractClass() {

    @Override
    public void method() {

    }

};
```

---

# Basic Structure

```
          Interface

               ▲

               │

Anonymous Class

               │

               ▼

          Object Created
```

---

# Example 1

Using Interface

```java
interface Animal {

    void sound();

}

public class Main {

    public static void main(String[] args) {

        Animal obj = new Animal() {

            @Override
            public void sound() {

                System.out.println("Dog Barks");

            }

        };

        obj.sound();

    }

}
```

---

# Output

```
Dog Barks
```

---

# Explanation

Instead of writing

```
Animal

      ▲

      │

Dog
```

Java creates

```
Animal

      ▲

      │

Anonymous Class

(No Name)
```

---

# Step-by-Step Execution

### Step 1

Create interface.

```java
Animal
```

---

### Step 2

Create anonymous object.

```java
new Animal() {

}
```

---

### Step 3

Override method.

```java
sound()
```

---

### Step 4

Store object reference.

```java
Animal obj
```

---

### Step 5

Call method.

```java
obj.sound();
```

---

# Program Flow

```
main()

   │

   ▼

Create Anonymous Object

   │

   ▼

Override Method

   │

   ▼

Call sound()

   │

   ▼

Print Output

   │

   ▼

End
```

---

# Memory Representation

```
Stack Memory

+----------------------+
| obj                  |
+----------|-----------+
           |
           ▼

Heap Memory

+----------------------+
| Anonymous Object     |
| sound()              |
+----------------------+
```

---

# Example 2

Using an Abstract Class

```java
abstract class Animal {

    abstract void sound();

}

public class Main {

    public static void main(String[] args) {

        Animal obj = new Animal() {

            @Override
            void sound() {

                System.out.println("Lion Roars");

            }

        };

        obj.sound();

    }

}
```

---

# Output

```
Lion Roars
```

---

# Example 3

Using a Normal Class

```java
class Student {

    void display() {

        System.out.println("Student");

    }

}

public class Main {

    public static void main(String[] args) {

        Student obj = new Student() {

            @Override
            void display() {

                System.out.println("Anonymous Student");

            }

        };

        obj.display();

    }

}
```

---

# Output

```
Anonymous Student
```

---

# Internal Working

Suppose we write

```java
new Animal() {

}
```

Compiler internally generates something similar to

```
Main$1.class
```

If another anonymous class exists,

```
Main$2.class

Main$3.class
```

and so on.

---

# Anonymous Class Diagram

```
Animal Interface

       ▲

       │

Anonymous Class

       │

       ▼

Object
```

---

# Can Anonymous Classes Have Variables?

Yes.

```java
interface Demo {

    void show();

}

public class Main {

    public static void main(String[] args) {

        Demo obj = new Demo() {

            int number = 100;

            @Override
            public void show() {

                System.out.println(number);

            }

        };

        obj.show();

    }

}
```

---

# Output

```
100
```

---

# Can Anonymous Classes Have Methods?

Yes.

```java
Demo obj = new Demo() {

    void message() {

        System.out.println("Hello");

    }

    @Override
    public void show() {

        message();

    }

};
```

---

# Can We Create Constructors?

No.

Anonymous classes do **not** have constructors because they have **no class name**.

Instead,

instance initialization blocks can be used.

---

# Example

```java
Demo obj = new Demo() {

    {

        System.out.println("Object Created");

    }

    @Override
    public void show() {

        System.out.println("Hello");

    }

};
```

---

# Output

```
Object Created

Hello
```

---

# Advantages

- No need to create separate classes.
- Cleaner code.
- Perfect for one-time implementations.
- Reduces boilerplate code.
- Commonly used with event handling and callbacks.

---

# Disadvantages

- Difficult to read when large.
- Cannot be reused.
- No constructors.
- Harder to debug.

---

# Real-World Applications

Anonymous Inner Classes are used in:

- Swing Button Click Events
- JavaFX Event Handling
- Android Click Listeners
- Runnable
- Comparator
- Timer Tasks
- Callbacks
- Framework Development

---

# Anonymous Inner Class vs Normal Class

| Feature | Anonymous Class | Normal Class |
|----------|----------------|--------------|
| Name | No | Yes |
| Reusable | No | Yes |
| Constructor | No | Yes |
| Object Creation | Immediate | Separate |
| Best For | One-time Use | Multiple Uses |

---

# Anonymous Inner Class vs Local Inner Class

| Feature | Anonymous | Local |
|----------|-----------|-------|
| Name | No | Yes |
| Constructor | No | Yes |
| Reusable | No | Yes (within method) |
| Object Creation | Immediate | Separate |

---

# Anonymous Inner Class vs Lambda Expression

| Anonymous Class | Lambda Expression |
|-----------------|-------------------|
| Java 1.1 | Java 8 |
| Can extend class | Cannot extend class |
| Can implement interface | Functional Interface only |
| More code | Less code |
| Supports multiple methods | Single abstract method |

---

# Common Mistakes

## Mistake 1

Trying to create multiple objects from the same anonymous class.

❌ Wrong

```java
AnonymousClass obj = new AnonymousClass();
```

There is no class name.

---

## Mistake 2

Writing constructors.

❌ Wrong

```java
Demo(){

}
```

Anonymous classes cannot have constructors.

---

## Mistake 3

Using anonymous classes for large implementations.

If the implementation becomes large,

create a separate class instead.

---

# Best Practices

- Use for one-time implementations.
- Keep the code short.
- Avoid complex business logic.
- Prefer Lambda Expressions for Functional Interfaces (Java 8+).
- Use meaningful formatting.

---

# Interview Questions

## Beginner

1. What is an Anonymous Inner Class?
2. Why is it called anonymous?
3. Can it implement interfaces?
4. Can it extend abstract classes?
5. Can it extend normal classes?

## Intermediate

6. Can an Anonymous Class have variables?
7. Can it have methods?
8. Why can't it have constructors?
9. What class files does the compiler generate?

## Advanced

10. How are Anonymous Classes represented in bytecode?
11. Anonymous Class vs Lambda Expression?
12. When should you use Anonymous Classes instead of Lambda Expressions?

---

# Practice Programs

### Easy

- Create an anonymous class implementing `Runnable`.
- Create an anonymous class implementing `Comparator`.

### Medium

- Create an anonymous class extending an abstract class.
- Override a method using an anonymous class.

### Difficult

- Build a GUI button click listener using an anonymous class.
- Create a custom sorting program using an anonymous `Comparator`.

---

# Concept Map

```
Anonymous Inner Class

        │

        ├── No Class Name

        ├── One-Time Use

        ├── Immediate Object Creation

        ├── Can Extend Class

        ├── Can Implement Interface

        ├── No Constructor

        └── Common in Event Handling
```

---

# Key Takeaways

- An Anonymous Inner Class has no name.
- It is declared and instantiated at the same time.
- It is ideal for one-time implementations.
- It can extend a class or implement an interface.
- It cannot have constructors.
- The compiler generates synthetic class files like `Main$1.class`.
- Since Java 8, Lambda Expressions are preferred for Functional Interfaces.

---

# Conclusion

Anonymous Inner Classes are a powerful Java feature that helps reduce the need for creating separate classes for one-time tasks. They are widely used in GUI programming, event handling, multithreading, and callback mechanisms. While Lambda Expressions have replaced many anonymous classes for functional interfaces, understanding Anonymous Inner Classes remains essential for interviews and working with legacy Java code.
