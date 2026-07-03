# this vs super in Java

## Introduction

In Java, two special keywords are frequently used in Object-Oriented Programming:

```java
this
super
```

Both are reference keywords, but they point to different objects.

Understanding the difference between them is important because they are heavily used in:

- Constructors
- Inheritance
- Method Overriding
- Constructor Chaining
- Object Initialization

---

# The Big Picture

```text
this
  ↓
Current Class Object

super
  ↓
Parent Class Object
```

---

# What is this?

## Definition

The `this` keyword refers to the current object of the current class.

---

# Example

```java
class Student {

    String name;

    public Student(String name) {

        this.name = name;

    }
}
```

---

# Why Use this?

Consider:

```java
class Student {

    String name;

    public Student(String name) {

        name = name;

    }
}
```

Problem:

```text
Parameter name hides Instance Variable name
```

Java becomes confused.

---

# Solution

```java
this.name = name;
```

Meaning:

```text
Current Object's name
      =
Parameter name
```

---

# Visualization

```text
Parameter
---------
name = Sanjay

Current Object
--------------
this.name = null
```

Assignment:

```text
this.name = name
```

Result:

```text
this.name = Sanjay
```

---

# Simple Example

```java
class Student {

    private String name;

    public Student(String name) {

        this.name = name;

    }

    public void display() {

        System.out.println(this.name);

    }
}

public class Main {

    public static void main(String[] args) {

        Student student =
                new Student("Sanjay");

        student.display();
    }
}
```

---

# Output

```text
Sanjay
```

---

# Common Uses of this

## Access Current Object Variables

```java
this.name
```

---

## Call Current Class Method

```java
this.display();
```

---

## Call Another Constructor

```java
this("Sanjay");
```

---

# Constructor Chaining Using this

```java
class Student {

    String name;
    int age;

    public Student() {

        this("Unknown", 0);

    }

    public Student(
            String name,
            int age) {

        this.name = name;
        this.age = age;
    }
}
```

---

# What is super?

## Definition

The `super` keyword refers to the immediate parent class object.

---

# Why Do We Need super?

Suppose:

```java
class Animal {

    String color = "White";

}
```

Child Class:

```java
class Dog extends Animal {

    String color = "Black";

}
```

Now there are two variables:

```text
Dog.color
Animal.color
```

Which one should Java use?

---

# Solution

Use:

```java
this.color
```

for Child Class.

Use:

```java
super.color
```

for Parent Class.

---

# Example

```java
class Animal {

    String color = "White";

}

class Dog extends Animal {

    String color = "Black";

    public void display() {

        System.out.println(
                this.color);

        System.out.println(
                super.color);
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.display();
    }
}
```

---

# Output

```text
Black
White
```

---

# Visualization

```text
Dog Object

color = Black
      ↑
    this.color


Animal Part

color = White
      ↑
   super.color
```

---

# Using super to Call Parent Method

## Parent Class

```java
class Animal {

    public void sound() {

        System.out.println("Animal Sound");

    }
}
```

---

## Child Class

```java
class Dog extends Animal {

    public void sound() {

        System.out.println("Dog Bark");

    }

    public void display() {

        super.sound();
    }
}
```

---

# Output

```text
Animal Sound
```

---

# Why?

Because:

```java
super.sound();
```

calls the parent version.

---

# Using super in Constructors

Parent:

```java
class Animal {

    public Animal() {

        System.out.println(
                "Animal Constructor");

    }
}
```

Child:

```java
class Dog extends Animal {

    public Dog() {

        super();

        System.out.println(
                "Dog Constructor");

    }
}
```

---

# Output

```text
Animal Constructor
Dog Constructor
```

---

# Internal Working

```text
Create Dog Object
        ↓
Call Parent Constructor
        ↓
Call Child Constructor
        ↓
Object Ready
```

---

# Constructor Call Hierarchy

```text
Dog()
  ↓
super()
  ↓
Animal()
```

---

# this vs super

| this | super |
|--------|--------|
| Current Class Object | Parent Class Object |
| Access Current Variables | Access Parent Variables |
| Access Current Methods | Access Parent Methods |
| Constructor Chaining | Parent Constructor Call |
| Used Within Same Class | Used In Child Class |

---

# Complete Example

```java
class Animal {

    String color = "White";

    public Animal() {

        System.out.println(
                "Animal Constructor");

    }
}

class Dog extends Animal {

    String color = "Black";

    public Dog() {

        super();

        System.out.println(
                "Dog Constructor");

    }

    public void display() {

        System.out.println(
                this.color);

        System.out.println(
                super.color);
    }
}

public class Main {

    public static void main(String[] args) {

        Dog dog = new Dog();

        dog.display();
    }
}
```

---

# Output

```text
Animal Constructor
Dog Constructor
Black
White
```

---

# Memory Representation

```text
Dog Object
-----------------

Dog Part
color = Black

Animal Part
color = White

-----------------
```

---

# Common Mistakes

## Using super Without Inheritance

Wrong:

```java
super.name;
```

No parent class exists.

---

## Calling this() and super() Together

Wrong:

```java
public Dog() {

    this();
    super();

}
```

Compiler Error.

Only one constructor call can appear first.

---

## Using super in Non-Child Class

Not Allowed.

---

# Interview Questions

## What does this refer to?

Current object of the current class.

---

## What does super refer to?

Immediate parent class object.

---

## Can this call a constructor?

Yes.

Using:

```java
this(...)
```

---

## Can super call a constructor?

Yes.

Using:

```java
super(...)
```

---

## Which constructor executes first?

Parent constructor.

---

## Can we access parent variables using super?

Yes.

Example:

```java
super.color
```

---

# Concept Map

```text
Object Creation
      │
      ├── this
      │      │
      │      ├── Current Variable
      │      ├── Current Method
      │      └── Constructor Chaining
      │
      └── super
             │
             ├── Parent Variable
             ├── Parent Method
             └── Parent Constructor
```

---

# Practice Challenges

## Challenge 1

Create:

```text
Person
Employee
```

Use:

```java
super()
```

---

## Challenge 2

Create:

```text
Vehicle
Car
```

Use:

```java
super.speed
```

---

## Challenge 3

Create constructor chaining using:

```java
this()
```

---

## Challenge 4

Override a method and call parent version using:

```java
super.method()
```

---

# Key Takeaways

- `this` refers to the current object.
- `super` refers to the parent object.
- `this()` calls another constructor in the same class.
- `super()` calls a parent constructor.
- `this.variable` accesses current class variables.
- `super.variable` accesses parent class variables.
- Parent constructors execute before child constructors.

---

# Conclusion

The `this` and `super` keywords are fundamental tools in Java's Object-Oriented Programming model. `this` helps work with the current object, while `super` provides access to parent class members. Mastering these keywords is essential before moving to inheritance, polymorphism, and advanced OOP design patterns.
