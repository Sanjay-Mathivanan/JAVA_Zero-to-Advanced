# Static Nested Classes in Java

> **Chapter 09 - Advanced Java Class Concepts**

---

# Introduction

A **Static Nested Class** is a nested class that is declared using the `static` keyword.

Unlike a Member Inner Class, a Static Nested Class **does not belong to an object of the outer class**. Instead, it belongs to the outer class itself.

Because of this, we can create an object of a Static Nested Class **without creating an object of the outer class**.

Static Nested Classes are useful when the nested class is logically related to the outer class but does not need to access its instance (non-static) members.

---

# Problem Statement

Suppose we are developing software for a **Bank**.

A bank has:

- Bank Name
- Branch
- IFSC Code

The **Branch** information belongs to the Bank, but it does not need access to a specific Bank object's data.

Instead of writing:

```
Bank
    └── Branch
```

where `Branch` depends on a Bank object, we can make it independent by declaring it as a **Static Nested Class**.

---

# Why Do We Need Static Nested Classes?

Consider a company.

```
Company

├── HR Rules
├── Employee Rules
├── Branch Information
```

The branch information belongs to the company but does not depend on a specific company object.

Similarly,

```
Outer Class

    │

    ▼

Static Nested Class
```

belongs to the class rather than an object.

---

# Definition

A **Static Nested Class** is a class declared inside another class using the `static` keyword.

It behaves like a static member of the outer class.

---

# Syntax

```java
class Outer {

    static class Inner {

    }

}
```

---

# Basic Structure

```
Outer Class

+------------------------+
| Company                |
|                        |
| +-------------------+  |
| | static Branch     |  |
| +-------------------+  |
+------------------------+
```

---

# Characteristics

- Declared using the `static` keyword.
- Does not require an outer class object.
- Can access only static members of the outer class directly.
- Can contain constructors, methods, and variables.
- Behaves like a normal class inside another class.

---

# First Example

```java
class Company {

    static class Employee {

        void display() {

            System.out.println("Employee Details");

        }

    }

}

public class Main {

    public static void main(String[] args) {

        Company.Employee emp = new Company.Employee();

        emp.display();

    }

}
```

---

# Output

```
Employee Details
```

---

# Step-by-Step Explanation

### Step 1

Create the outer class.

```java
class Company
```

---

### Step 2

Create a static nested class.

```java
static class Employee
```

---

### Step 3

Create its object.

```java
Company.Employee emp = new Company.Employee();
```

Notice that no `Company` object is created.

---

### Step 4

Call the method.

```java
emp.display();
```

---

# Memory Representation

```
Stack Memory

+-----------------------+
| emp                   |
+-----------|-----------+
            |
            ▼

Heap Memory

+-----------------------+
| Employee Object       |
+-----------------------+
```

No `Company` object exists.

---

# Program Flow

```
Start

   │

   ▼

Create Employee Object

   │

   ▼

Call display()

   │

   ▼

Print Message

   │

   ▼

End
```

---

# Accessing Static Members of Outer Class

A Static Nested Class can directly access static members.

---

## Example

```java
class Company {

    static String companyName = "OpenAI";

    static class Employee {

        void show() {

            System.out.println(companyName);

        }

    }

}

public class Main {

    public static void main(String[] args) {

        Company.Employee emp = new Company.Employee();

        emp.show();

    }

}
```

---

# Output

```
OpenAI
```

---

# Accessing Instance Members

A Static Nested Class **cannot** directly access non-static members.

---

## Example

```java
class Company {

    String city = "Chennai";

    static class Employee {

        void show() {

            System.out.println(city);

        }

    }

}
```

---

# Output

```
Compilation Error
```

Reason:

```
Non-static member

cannot be referenced

from a static context.
```

---

# Accessing Instance Members Correctly

```java
class Company {

    String city = "Chennai";

    static class Employee {

        void show() {

            Company obj = new Company();

            System.out.println(obj.city);

        }

    }

}

public class Main {

    public static void main(String[] args) {

        Company.Employee emp = new Company.Employee();

        emp.show();

    }

}
```

---

# Output

```
Chennai
```

---

# Internal Working

Compiler creates

```
Company.class

Company$Employee.class
```

Even though it is static, it is still stored as a nested class.

---

# Static Nested Class Object

```
Company

      │

      ▼

Employee Class

      │

      ▼

Employee Object
```

No outer object is involved.

---

# Real-World Example

```java
class University {

    static class Rules {

        void display() {

            System.out.println("Follow University Rules");

        }

    }

}

public class Main {

    public static void main(String[] args) {

        University.Rules rules = new University.Rules();

        rules.display();

    }

}
```

---

# Output

```
Follow University Rules
```

---

# Advantages

- Does not require an outer object.
- Better memory usage.
- Cleaner organization.
- Useful for helper classes.
- Faster object creation compared to Member Inner Classes.

---

# Disadvantages

- Cannot directly access instance variables.
- Less flexible when object-specific data is required.

---

# Member Inner Class vs Static Nested Class

| Feature | Member Inner Class | Static Nested Class |
|----------|-------------------|---------------------|
| Uses `static` | ❌ No | ✅ Yes |
| Needs Outer Object | ✅ Yes | ❌ No |
| Access Instance Members | ✅ Yes | ❌ No |
| Access Static Members | ✅ Yes | ✅ Yes |
| Memory Usage | Slightly Higher | Lower |

---

# Static Nested Class vs Normal Class

| Feature | Static Nested Class | Normal Class |
|----------|---------------------|--------------|
| Declared Inside Another Class | ✅ Yes | ❌ No |
| Access Outer Static Members | ✅ Yes | ❌ Directly |
| Requires Outer Object | ❌ No | ❌ No |

---

# Common Mistakes

## Mistake 1

Trying to access instance variables directly.

❌ Wrong

```java
System.out.println(city);
```

✔ Correct

```java
Company obj = new Company();

System.out.println(obj.city);
```

---

## Mistake 2

Creating an unnecessary outer object.

❌ Wrong

```java
Company company = new Company();

Company.Employee emp = company.new Employee();
```

This syntax is only for Member Inner Classes.

✔ Correct

```java
Company.Employee emp = new Company.Employee();
```

---

# Best Practices

- Use Static Nested Classes when access to outer instance members is unnecessary.
- Use them for utility or helper classes.
- Keep them small and focused.
- Avoid unnecessary dependencies on the outer class.

---

# Interview Questions

## Beginner

1. What is a Static Nested Class?
2. Why does it not require an outer object?
3. Can it access static members?
4. Can it access instance members directly?
5. How do you create its object?

## Intermediate

6. What class files does the compiler generate?
7. How is a Static Nested Class different from a Member Inner Class?
8. Why is memory usage lower?

## Advanced

9. How does the JVM load a Static Nested Class?
10. When should you choose a Static Nested Class over a top-level class?
11. How does bytecode represent static nested classes?

---

# Practice Programs

### Easy

- Create a `School` class with a static nested `Rules` class.
- Create a `Car` class with a static nested `EngineSpecification` class.

### Medium

- Create a `Hospital` class with a static nested `Department` class.
- Create a `Library` class with a static nested `BookCategory` class.

### Difficult

- Design a shopping application using Static Nested Classes.
- Build a university management system using Static Nested Classes.

---

# Concept Map

```
Static Nested Class

        │

        ├── Declared using static

        ├── No Outer Object Needed

        ├── Access Static Members

        ├── Cannot Directly Access Instance Members

        ├── Better Memory Usage

        └── Cleaner Organization
```

---

# Key Takeaways

- A Static Nested Class belongs to the outer class, not its objects.
- It can be instantiated without creating an outer class object.
- It can directly access only static members of the outer class.
- It improves memory usage and code organization.
- The compiler generates separate `.class` files using `$`.
- It is suitable for helper classes and logically grouped components.

---

# Conclusion

Static Nested Classes are an efficient way to organize related classes while avoiding unnecessary dependencies on outer class objects. They are lightweight, easy to instantiate, and commonly used in utility classes, helper classes, builders, and framework development.

In the next chapter, we will study **Local Inner Classes**, which are declared inside methods and have their own scope and lifetime.
