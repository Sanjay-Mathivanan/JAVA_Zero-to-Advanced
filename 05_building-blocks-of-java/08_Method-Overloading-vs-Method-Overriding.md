# Method Overloading vs Method Overriding in Java

## Introduction

As Java applications grow larger, we often encounter situations where:

- Multiple methods perform similar tasks with different inputs.
- Child classes need to modify the behavior of parent classes.

Java provides two important concepts to solve these problems:

```text
Method Overloading
Method Overriding
```

These concepts are fundamental to:

- Code Reusability
- Readability
- Maintainability
- Polymorphism

---

# The Big Picture

```text
Polymorphism
      │
      ├── Method Overloading
      │       ↓
      │   Same Class
      │   Different Parameters
      │
      └── Method Overriding
              ↓
         Parent & Child Class
         Same Method Signature
```

---

# What is Method Overloading?

## Definition

Method Overloading means creating multiple methods with:

```text
Same Method Name
Different Parameter List
```

inside the same class.

---

## Why Use Method Overloading?

Suppose we want an `add()` method.

Possible use cases:

```text
add(5, 10)

add(5, 10, 15)

add(5.5, 6.2)
```

Instead of creating:

```java
addTwoNumbers()
addThreeNumbers()
addDoubleNumbers()
```

we can use:

```java
add()
```

multiple times.

---

# Method Overloading Example

```java
public class Main {

    static int add(int a, int b) {

        return a + b;

    }

    static int add(
            int a,
            int b,
            int c) {

        return a + b + c;

    }

    public static void main(String[] args) {

        System.out.println(
                add(10, 5));

        System.out.println(
                add(5, 10, 15));
    }
}
```

---

# Output

```text
15
30
```

---

# How Java Decides Which Method to Call?

```java
add(10,5);
```

Java searches:

```java
add(int,int)
```

Found.

Execute it.

---

```java
add(5,10,15);
```

Java searches:

```java
add(int,int,int)
```

Found.

Execute it.

---

# Valid Ways to Overload

## Different Number of Parameters

```java
add(int a, int b)

add(int a, int b, int c)
```

---

## Different Data Types

```java
add(int a, int b)

add(double a, double b)
```

---

## Different Parameter Order

```java
display(int age, String name)

display(String name, int age)
```

---

# Invalid Method Overloading

## Only Return Type Different

Wrong:

```java
int add(int a, int b)

double add(int a, int b)
```

Compiler Error.

---

# Why?

Java identifies overloaded methods using:

```text
Method Name
+
Parameter List
```

Return type is ignored.

---

# Important Points About Method Overloading

Based on the screenshot notes:

### We Cannot Overload Only by Return Type

Wrong:

```java
int add(int a, int b)

double add(int a, int b)
```

---

### Static Methods Can Be Overloaded

```java
static void display()

static void display(String name)
```

Valid.

---

### main() Can Be Overloaded

```java
public static void main(String[] args)

public static void main(int x)
```

Valid.

Only the standard version is executed automatically.

---

# What is Method Overriding?

## Definition

Method Overriding occurs when:

```text
Parent Class
and
Child Class
```

have methods with:

```text
Same Name
Same Parameters
Same Return Type
```

but different implementations.

---

# Why Use Method Overriding?

A child class may need specialized behavior.

Example:

```text
Animal → Sound

Dog → Bark

Cat → Meow
```

All are sounds, but implementation differs.

---

# Real-World Analogy

```text
Vehicle
   ↓
Start Engine
```

Different vehicles start differently.

```text
Car
Bike
Truck
```

Each overrides the behavior.

---

# Method Overriding Example

## Parent Class

```java
class Animal {

    public void sound() {

        System.out.println(
                "Animal Sound");

    }
}
```

---

## Child Class

```java
class Dog extends Animal {

    @Override
    public void sound() {

        System.out.println(
                "Dog Barks");

    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.sound();
    }
}
```

---

# Output

```text
Dog Barks
```

---

# Why Parent Method Didn't Execute?

Because:

```java
dog.sound();
```

calls the overridden version inside:

```java
Dog
```

---

# Example Similar to Screenshot

```java
class Parent {

    public void add(int a, int b) {

        int sum = a + b;

        System.out.println(
                "Parent Method = "
                + sum);
    }
}

class Child extends Parent {

    @Override
    public void add(int a, int b) {

        int sum = a + b;

        System.out.println(
                "Child Method = "
                + sum);
    }
}

public class Main {

    public static void main(String[] args) {

        Child child = new Child();

        child.add(10,20);
    }
}
```

---

# Output

```text
Child Method = 30
```

---

# Rules for Method Overriding

## Inheritance is Mandatory

Must have:

```java
extends
```

---

## Method Signature Must Match

Parent:

```java
void display()
```

Child:

```java
void display()
```

---

## Return Type Must Be Compatible

Parent:

```java
String getName()
```

Child:

```java
String getName()
```

---

## Access Modifier Cannot Be More Restrictive

Valid:

```java
protected
→ public
```

Invalid:

```java
public
→ private
```

---

# Overloading vs Overriding

| Feature | Overloading | Overriding |
|----------|-------------|------------|
| Class Requirement | Same Class | Parent + Child |
| Method Name | Same | Same |
| Parameters | Different | Same |
| Return Type | Can differ | Must be compatible |
| Inheritance Needed | No | Yes |
| Polymorphism Type | Compile-Time | Runtime |
| Keyword | None | @Override |
| Purpose | Multiple Versions | Change Parent Behavior |

---

# Memory Representation

## Overloading

```text
Calculator Class

add(int,int)

add(int,int,int)

add(double,double)
```

Java chooses method during compilation.

---

## Overriding

```text
Animal
   │
   ▼
Dog
```

Method selection happens during runtime.

---

# Compile-Time vs Runtime Polymorphism

## Compile-Time

```java
add(10,20);
```

Decision made before execution.

```text
Method Overloading
```

---

## Runtime

```java
Animal animal =
        new Dog();

animal.sound();
```

Decision made during execution.

```text
Method Overriding
```

---

# Common Mistakes

## Overloading Only by Return Type

Wrong:

```java
int add(int a,int b)

double add(int a,int b)
```

---

## Forgetting Inheritance

Wrong:

```java
class A {}

class B {}
```

No overriding possible.

---

## Different Parameters in Overriding

Wrong:

```java
Parent:
display()

Child:
display(String name)
```

This becomes overloading.

---

# Interview Questions

## What is Method Overloading?

Creating multiple methods with the same name but different parameter lists.

---

## What is Method Overriding?

Redefining a parent class method inside a child class.

---

## Can Return Type Alone Overload a Method?

No.

---

## Can Static Methods Be Overloaded?

Yes.

---

## Can main() Be Overloaded?

Yes.

---

## Is Inheritance Required for Overloading?

No.

---

## Is Inheritance Required for Overriding?

Yes.

---

## Which Supports Runtime Polymorphism?

Method Overriding.

---

## Which Supports Compile-Time Polymorphism?

Method Overloading.

---

# Practice Challenges

## Challenge 1

Create:

```java
area(int side)

area(int length,int breadth)
```

using overloading.

---

## Challenge 2

Create:

```text
Animal
Dog
Cat
```

Override:

```java
sound()
```

---

## Challenge 3

Overload the main() method.

---

## Challenge 4

Create:

```text
Vehicle
Car
Bike
```

Override:

```java
start()
```

---

# Key Takeaways

- Method Overloading uses the same method name with different parameters.
- Method Overriding changes parent class behavior in a child class.
- Overloading provides compile-time polymorphism.
- Overriding provides runtime polymorphism.
- Inheritance is mandatory for overriding.
- Return type alone cannot overload a method.
- Overriding requires identical method signatures.

---

# Conclusion

Method Overloading and Method Overriding are two fundamental pillars of Java polymorphism. Overloading improves flexibility by allowing multiple versions of a method, while overriding allows child classes to provide specialized implementations of parent class behavior. Mastering these concepts is essential before moving to inheritance, abstraction, interfaces, and advanced object-oriented design.
