---

# Default Methods in Interfaces (Java 8)

Before Java 8, every method inside an interface had to be **abstract**.

This created a problem.

Suppose an interface is used by thousands of classes.

```
Interface
   │
   ├── Class A
   ├── Class B
   ├── Class C
   ├── Class D
   └── ...
```

If we add one new abstract method to the interface,

every implementing class must implement it.

Otherwise,

```
Compilation Error
```

Updating hundreds or thousands of classes becomes difficult.

To solve this problem, **Java 8 introduced Default Methods.**

---

# What is a Default Method?

A **default method** is a method inside an interface that already contains a body.

The implementing class **may use it directly** or **override** it.

---

# Syntax

```java
interface InterfaceName {

    default void methodName() {

        // implementation

    }

}
```

---

# Example 1

```java
interface Animal {

    default void sleep() {

        System.out.println("Animal is Sleeping");

    }

}

class Dog implements Animal {

}

public class Main {

    public static void main(String[] args) {

        Dog obj = new Dog();

        obj.sleep();

    }

}
```

---

# Output

```
Animal is Sleeping
```

---

# Explanation

The Dog class did not implement

```java
sleep()
```

because the interface already provides its implementation.

```
Interface

sleep()

      ▲

      │

Dog

uses directly
```

---

# Memory Representation

```
Stack

+--------------------+
| obj                |
+---------|----------+
          |
          ▼

Heap

+----------------------+
| Dog Object           |
+----------------------+

Method Resolution

Dog
 │
 │
 ▼
Animal Interface
 │
 ▼
default sleep()
```

---

# Overriding Default Methods

An implementing class can provide its own implementation.

---

## Example

```java
interface Animal {

    default void sound() {

        System.out.println("Animal Sound");

    }

}

class Dog implements Animal {

    @Override
    public void sound() {

        System.out.println("Dog Barks");

    }

}

public class Main {

    public static void main(String[] args) {

        Dog obj = new Dog();

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

# Method Resolution

```
Dog.sound()

Exists?

     │

 Yes ▼

Execute Dog Method

No

↓

Execute Interface Default Method
```

---

# Why Default Methods?

Imagine a mobile application.

Version 1

```
Login
Register
Logout
```

Thousands of developers implement it.

Later,

Version 2

adds

```
Forgot Password
```

Without default methods,

every implementation breaks.

With default methods,

```
Forgot Password

already implemented

↓

No code breaks.
```

---

# Static Methods in Interfaces

Java 8 also introduced

```
static methods
```

inside interfaces.

---

# Why?

Sometimes a method belongs to the interface itself,

not to the implementing object.

Example

```
Math.max()

Collections.sort()

Objects.requireNonNull()
```

These methods belong to the class,

not objects.

Similarly,

interfaces can also contain static methods.

---

# Syntax

```java
interface Vehicle {

    static void rules() {

        System.out.println("Follow Traffic Rules");

    }

}
```

---

# Example

```java
interface Vehicle {

    static void rules() {

        System.out.println("Follow Traffic Rules");

    }

}

public class Main {

    public static void main(String[] args) {

        Vehicle.rules();

    }

}
```

---

# Output

```
Follow Traffic Rules
```

---

# Important Rule

Static interface methods

cannot be inherited.

Wrong

```java
Car.rules();
```

Correct

```java
Vehicle.rules();
```

---

# Internal Working

```
Vehicle Interface

     │

Static Method

     │

Called using

Vehicle.rules()

Not

Object.rules()
```

---

# Can We Override Static Methods?

No.

Static methods belong to

the interface,

not objects.

---

# Private Methods in Interfaces (Java 9)

Java 9 introduced

```
private methods
```

inside interfaces.

---

# Why?

Suppose multiple default methods contain duplicate code.

Example

```
login()

logout()

register()
```

All of them

print

```
Checking Database...

Checking User...

Checking Permission...
```

Instead of writing the same code repeatedly,

we can create one private method.

---

# Syntax

```java
interface Demo {

    private void message(){

    }

}
```

---

# Example

```java
interface Mobile {

    default void call() {

        common();

        System.out.println("Calling");

    }

    default void message() {

        common();

        System.out.println("Messaging");

    }

    private void common() {

        System.out.println("Checking Network");

    }

}

class Samsung implements Mobile {

}

public class Main {

    public static void main(String[] args) {

        Samsung obj = new Samsung();

        obj.call();

        obj.message();

    }

}
```

---

# Output

```
Checking Network

Calling

Checking Network

Messaging
```

---

# Internal Working

```
call()

 │

 ▼

common()

 │

 ▼

Print

Checking Network

 │

 ▼

Calling
```

---

# Can Classes Access Private Interface Methods?

No.

Wrong

```java
obj.common();
```

Compilation Error.

Private methods

are visible

only inside the interface.

---

# Types of Methods Allowed in Interfaces

| Method Type | Java Version |
|-------------|--------------|
| Abstract | Java 1.0 |
| Default | Java 8 |
| Static | Java 8 |
| Private | Java 9 |
| Private Static | Java 9 |

---

# Functional Interface

One of the most important interview topics.

---

# Definition

A Functional Interface

contains

exactly

```
ONE

abstract method.
```

It may also contain

- default methods
- static methods
- private methods

But only

ONE abstract method.

---

# Examples

```
Runnable

Callable

Comparator

Predicate

Consumer

Supplier
```

All are functional interfaces.

---

# Syntax

```java
@FunctionalInterface

interface Calculator{

    int add(int a,int b);

}
```

---

# Why Functional Interface?

Because

Lambda Expressions

work only with

Functional Interfaces.

```
Functional Interface

        │

        ▼

Lambda Expression
```

---

# Example

```java
@FunctionalInterface
interface Greeting {

    void sayHello();

}

class Student implements Greeting {

    public void sayHello() {

        System.out.println("Hello");

    }

}

public class Main {

    public static void main(String[] args) {

        Student obj = new Student();

        obj.sayHello();

    }

}
```

---

# Output

```
Hello
```

---

# What is @FunctionalInterface?

It is an annotation.

It tells the compiler

"This interface should always have exactly one abstract method."

---

# Example

```java
@FunctionalInterface
interface Demo{

    void show();

}
```

Correct.

---

Wrong

```java
@FunctionalInterface

interface Demo{

    void show();

    void print();

}
```

Compiler Error

because

```
Two abstract methods
```

---

# Can Functional Interfaces Have Default Methods?

Yes.

Example

```java
@FunctionalInterface
interface Demo {

    void display();

    default void message() {

        System.out.println("Hello");

    }

}
```

Still valid.

Because

only

```
display()
```

is abstract.

---

# Lambda Expression Introduction

Without Lambda

```java
Greeting g = new Greeting() {

    @Override
    public void sayHello() {

        System.out.println("Hello");

    }

};
```

With Lambda

```java
Greeting g = () -> System.out.println("Hello");
```

Much shorter.

Much cleaner.

---

# Functional Interface Flow

```
Functional Interface

      │

One Abstract Method

      │

      ▼

Lambda Expression

      │

      ▼

Runtime Object

      │

      ▼

Method Execution
```

---

# Marker Interface

A Marker Interface

contains

```
NO METHODS
```

and

```
NO FIELDS
```

Its purpose is

to provide information

to the JVM or framework.

---

# Example

```java
interface Student{

}
```

---

# Popular Marker Interfaces

```
Serializable

Cloneable

Remote
```

---

# Why Marker Interfaces?

Example

```
Serializable
```

When JVM sees

```
implements Serializable
```

it knows

```
Object can be serialized.
```

---

# Diagram

```
Student Object

      │

implements

      │

Serializable

      │

JVM

knows object can be converted

↓

Bytes
```

---

# Difference Between Functional Interface and Marker Interface

| Functional Interface | Marker Interface |
|----------------------|------------------|
| One abstract method | No methods |
| Used for Lambda | Used to provide metadata |
| Has behavior | No behavior |
| Java 8 feature | Available since early Java |

---

# Key Takeaways (Part 2)

- Default methods allow interfaces to evolve without breaking existing implementations.
- Static methods belong to the interface and are called using the interface name.
- Private methods help eliminate duplicate code inside interfaces.
- Functional interfaces contain exactly one abstract method.
- `@FunctionalInterface` helps the compiler validate the interface.
- Lambda expressions work with functional interfaces.
- Marker interfaces contain no methods and provide metadata to the JVM or frameworks.
