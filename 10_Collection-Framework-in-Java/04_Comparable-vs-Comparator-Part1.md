# Comparable vs Comparator in Java (Part 1)

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

Sorting is one of the most common operations performed in Java applications.

Suppose we have a list of numbers.

```
50

20

80

10

40
```

After sorting,

```
10

20

40

50

80
```

Sorting makes data easier to understand, search, and analyze.

Java provides two interfaces for sorting objects:

- **Comparable**
- **Comparator**

Both are used to sort objects, but they work differently.

Understanding the difference between these two interfaces is an important Java interview topic.

---

# Learning Objectives

After completing this chapter, you will learn:

- What is Comparable?
- What is Comparator?
- Why are they needed?
- Difference between Comparable and Comparator
- Sorting Custom Objects
- compareTo() Method
- compare() Method
- Internal Working
- Best Practices

---

# Problem Statement

Suppose we have student objects.

```
Student

ID : 101

Name : Rahul

Age : 20
```

```
Student

ID : 103

Name : Arun

Age : 18
```

```
Student

ID : 102

Name : Priya

Age : 19
```

How do we sort them?

By

- ID
- Name
- Age

Java does not know.

We must tell Java

**how to compare two Student objects.**

---

# Why Do We Need Comparable and Comparator?

For primitive values,

Java already knows how to compare.

Example

```
10

20

30
```

But for custom objects,

Java cannot compare automatically.

Example

```
Student

Rahul

Age = 20

---------------

Student

Arun

Age = 18
```

Should Java compare

- Name?
- Age?
- ID?

Java doesn't know.

Therefore,

Comparable and Comparator were introduced.

---

# Real-World Analogy

Imagine a school.

Students can be arranged

- Alphabetically
- By Roll Number
- By Age
- By Marks

The same students can be sorted in different ways.

Comparable and Comparator define these sorting rules.

---

# What is Comparable?

Comparable is an interface present in

```java
java.lang
```

It is used to define the **natural ordering** of objects.

A class implements Comparable when it knows how its own objects should be sorted.

---

# Definition

> Comparable is an interface that defines the natural ordering of objects using the `compareTo()` method.

---

# Comparable Hierarchy

```
Object

   ▲

   │

Comparable

   ▲

   │

Student
```

---

# Syntax

```java
class Student implements Comparable<Student> {

    @Override
    public int compareTo(Student s) {

    }

}
```

---

# compareTo() Method

```java
public int compareTo(T object)
```

This method compares

```
Current Object

with

Another Object
```

---

# Return Values

| Return Value | Meaning |
|--------------|---------|
| Negative | Current object is smaller |
| Zero | Objects are equal |
| Positive | Current object is greater |

---

# Example

Suppose

```
10.compareTo(20)
```

Result

```
Negative
```

Because

```
10 < 20
```

---

```
20.compareTo(10)
```

Result

```
Positive
```

---

```
20.compareTo(20)
```

Result

```
0
```

---

# First Comparable Program

```java
import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {

    int age;

    Student(int age) {

        this.age = age;

    }

    @Override
    public int compareTo(Student s) {

        return this.age - s.age;

    }

    @Override
    public String toString() {

        return String.valueOf(age);

    }

}

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student(20));
        list.add(new Student(18));
        list.add(new Student(25));
        list.add(new Student(19));

        Collections.sort(list);

        System.out.println(list);

    }

}
```

---

# Output

```
[18, 19, 20, 25]
```

---

# Program Explanation

### Step 1

Create Student class.

```java
class Student
```

---

### Step 2

Implement Comparable.

```java
implements Comparable<Student>
```

---

### Step 3

Override

```java
compareTo()
```

---

### Step 4

Compare ages.

```java
return this.age - s.age;
```

---

### Step 5

Collections.sort()

calls

```
compareTo()

again

and

again
```

until the list becomes sorted.

---

# Internal Working

```
Collections.sort()

        │

        ▼

compareTo()

        │

        ▼

Compare Objects

        │

        ▼

Swap if Needed

        │

        ▼

Sorted List
```

---

# Memory Representation

```
Stack Memory

list

       │

       ▼

Heap Memory

+---------------------------+

Student

Age = 20

----------------------------

Student

Age = 18

----------------------------

Student

Age = 25

----------------------------

Student

Age = 19

+---------------------------+
```

---

# Example 2

Sorting Strings

```java
ArrayList<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Arun");
names.add("Priya");

Collections.sort(names);

System.out.println(names);
```

---

# Output

```
[Arun, Priya, Rahul]
```

---

# Example 3

Sorting Integers

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(40);
numbers.add(10);
numbers.add(30);
numbers.add(20);

Collections.sort(numbers);

System.out.println(numbers);
```

---

# Output

```
[10, 20, 30, 40]
```

---

# Advantages of Comparable

- Easy to use
- Defines natural ordering
- Built into the class
- Requires less code
- Supported directly by Collections.sort()

---

# Limitations of Comparable

- Only one sorting order.
- Cannot define multiple sorting criteria.
- Modifying sorting requires changing the class.

---

# Common Mistakes

## Mistake 1

Forgetting to implement Comparable.

```java
Collections.sort(studentList);
```

Compilation Error.

---

## Mistake 2

Returning wrong comparison value.

Wrong

```java
return 1;
```

Correct

```java
return this.age - s.age;
```

---

## Mistake 3

Not overriding compareTo().

Compilation Error occurs.

---

# Best Practices

- Use Comparable for the default sorting order.
- Keep compareTo() simple.
- Compare only one field in Comparable.
- Use Comparator for additional sorting criteria.

---

# Interview Questions

### Beginner

1. What is Comparable?
2. Which package contains Comparable?
3. What is compareTo()?

### Intermediate

4. What are the return values of compareTo()?
5. Why do we implement Comparable?
6. How does Collections.sort() use compareTo()?

### Advanced

7. Can Comparable support multiple sorting orders?
8. Explain natural ordering.
9. Difference between Comparable and Comparator?

---

# Key Takeaways

- Comparable is present in `java.lang`.
- It defines the natural ordering of objects.
- It uses the `compareTo()` method.
- `Collections.sort()` automatically calls `compareTo()`.
- Comparable is suitable when only one default sorting order is required.

---

# What's Next?

In **Part 2**, we will learn:

- Comparator Interface
- compare() Method
- Sorting by Multiple Fields
- Anonymous Comparator
- Lambda Comparator (Java 8)
- Comparable vs Comparator (Complete Comparison)
- Internal Working
- Real-world Examples
- Interview Questions
- Best Practices
- Practice Programs
