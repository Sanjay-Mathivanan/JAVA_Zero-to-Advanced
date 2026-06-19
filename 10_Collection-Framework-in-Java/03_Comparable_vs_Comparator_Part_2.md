# Comparable vs Comparator in Java (Part 2)

> **Chapter 10 - Collection Framework in Java**

---

# What is Comparator?

A **Comparator** is an interface present in the **java.util** package.

Unlike Comparable, Comparator is **external** to the class.

It allows us to define **multiple sorting logics** without modifying the original class.

---

# Definition

> Comparator is an interface used to compare two different objects and define custom sorting logic.

---

# Why Do We Need Comparator?

Suppose we have the following Student objects.

```
Student

ID : 101

Name : Rahul

Age : 20

--------------------

Student

ID : 103

Name : Arun

Age : 18

--------------------

Student

ID : 102

Name : Priya

Age : 19
```

Sometimes we want to sort

- By Age
- By Name
- By ID

Comparable supports only **one default sorting order**.

Comparator allows **multiple sorting orders**.

---

# Comparator Hierarchy

```
Object

   ▲

   │

Comparator

   ▲

   │

AgeComparator

NameComparator

IdComparator
```

---

# Syntax

```java
class AgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1, Student s2){

    }

}
```

---

# compare() Method

```java
public int compare(T obj1, T obj2)
```

This method compares **two objects**.

---

# Return Values

| Return Value | Meaning |
|--------------|---------|
| Negative | First object is smaller |
| Zero | Objects are equal |
| Positive | First object is greater |

---

# Example Program

## Sorting Students by Age

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Student{

    int id;
    String name;
    int age;

    Student(int id,String name,int age){

        this.id=id;
        this.name=name;
        this.age=age;

    }

    public String toString(){

        return id+" "+name+" "+age;

    }

}

class AgeComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1,Student s2){

        return s1.age-s2.age;

    }

}

public class Main{

    public static void main(String[] args){

        ArrayList<Student> list=new ArrayList<>();

        list.add(new Student(101,"Rahul",20));
        list.add(new Student(103,"Arun",18));
        list.add(new Student(102,"Priya",19));

        Collections.sort(list,new AgeComparator());

        System.out.println(list);

    }

}
```

---

# Output

```
103 Arun 18
102 Priya 19
101 Rahul 20
```

---

# Program Explanation

### Step 1

Create Student class.

---

### Step 2

Create AgeComparator.

```
implements Comparator<Student>
```

---

### Step 3

Override

```java
compare()
```

---

### Step 4

Compare ages.

```java
return s1.age-s2.age;
```

---

### Step 5

Collections.sort()

uses

```
compare()
```

to arrange objects.

---

# Example 2

## Sorting by Name

```java
class NameComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1,Student s2){

        return s1.name.compareTo(s2.name);

    }

}
```

Result

```
Arun

Priya

Rahul
```

---

# Example 3

## Sorting by ID

```java
class IdComparator implements Comparator<Student>{

    @Override
    public int compare(Student s1,Student s2){

        return s1.id-s2.id;

    }

}
```

Output

```
101 Rahul

102 Priya

103 Arun
```

---

# Anonymous Comparator

Instead of creating a separate class,

we can use an anonymous class.

```java
Collections.sort(list,new Comparator<Student>(){

    @Override
    public int compare(Student s1,Student s2){

        return s1.age-s2.age;

    }

});
```

---

# Lambda Expression (Java 8)

Java 8 makes Comparator much shorter.

```java
Collections.sort(list,
(s1,s2)->s1.age-s2.age);
```

Output

```
Sorted by Age
```

---

# Internal Working

```
Collections.sort()

        │

        ▼

Comparator.compare()

        │

        ▼

Compare Two Objects

        │

        ▼

Swap if Needed

        │

        ▼

Sorted List
```

---

# Comparable vs Comparator

| Feature | Comparable | Comparator |
|----------|------------|------------|
| Package | java.lang | java.util |
| Method | compareTo() | compare() |
| Sorting | Natural Ordering | Custom Ordering |
| Location | Inside Class | Outside Class |
| Number of Sorting Rules | One | Multiple |
| Modification | Modify Original Class | No Need |
| Interface Type | Functional Interface | Functional Interface |
| Used By | Collections.sort(list) | Collections.sort(list, comparator) |

---

# Real-World Example

Suppose an E-Commerce application has Products.

```
Product

Laptop

Price

50000

Rating

4.8
```

Sorting can be done by

- Price
- Rating
- Name

Comparator makes this possible.

---

# Memory Representation

```
Stack Memory

list

Comparator

        │

        ▼

Heap Memory

Student Object

Student Object

Student Object
```

---

# Program Flow

```
Create List

      │

      ▼

Create Comparator

      │

      ▼

Collections.sort()

      │

      ▼

compare()

      │

      ▼

Swap Objects

      │

      ▼

Sorted List
```

---

# Advantages of Comparator

- Multiple sorting orders
- No modification to original class
- Flexible
- Reusable
- Better for large applications

---

# Limitations

- Slightly more code
- Separate Comparator classes may be needed

---

# When to Use Comparable?

Use Comparable when

- One default sorting order exists.
- The class naturally knows how it should be sorted.

Example

```
Integer

String

Date
```

---

# When to Use Comparator?

Use Comparator when

- Multiple sorting orders are needed.
- Original class cannot be modified.
- Sorting changes frequently.

---

# Comparable vs Comparator Decision Tree

```
Need Default Sorting?

        │

       YES

        │

        ▼

Comparable

------------------------

Need Multiple Sorting?

        │

       YES

        │

        ▼

Comparator
```

---

# Common Mistakes

## Mistake 1

Using Comparable for multiple sorting.

Better choice

```
Comparator
```

---

## Mistake 2

Returning incorrect values.

Wrong

```java
return 1;
```

Correct

```java
return s1.age-s2.age;
```

---

## Mistake 3

Forgetting to override

```java
compare()
```

Compilation Error.

---

# Best Practices

- Use Comparable for natural ordering.
- Use Comparator for custom ordering.
- Keep comparison logic simple.
- Prefer Lambda expressions in Java 8+.
- Avoid duplicate comparison code.

---

# Interview Questions

## Beginner

1. What is Comparator?
2. Which package contains Comparator?
3. Difference between compare() and compareTo()?

---

## Intermediate

4. Why is Comparator more flexible?
5. Can Comparator support multiple sorting?
6. Difference between anonymous Comparator and Lambda Comparator?

---

## Advanced

7. Explain Collections.sort() internal working.
8. Why is Comparator called a Functional Interface?
9. Explain Comparable vs Comparator with examples.
10. Which one is used in enterprise applications?

---

# Practice Programs

### Easy

- Sort students by age.
- Sort employees by salary.

### Medium

- Sort products by price.
- Sort books by title.

### Hard

- Sort employees by department, then salary.
- Create multiple Comparator classes for a Banking System.

---

# Concept Map

```
                Object Sorting

                      │

          ┌───────────┴───────────┐

          ▼                       ▼

     Comparable              Comparator

          │                       │

   compareTo()              compare()

          │                       │

 Natural Sorting         Custom Sorting

          │                       │

 One Rule             Multiple Rules
```

---

# Summary

| Comparable | Comparator |
|------------|------------|
| Natural Sorting | Custom Sorting |
| One Sorting Rule | Multiple Sorting Rules |
| Inside Class | Outside Class |
| compareTo() | compare() |
| java.lang | java.util |

---

# Key Takeaways

- Comparable is used for **natural ordering**.
- Comparator is used for **custom ordering**.
- Comparable uses `compareTo()`.
- Comparator uses `compare()`.
- Comparator supports multiple sorting rules.
- Java 8 introduced Lambda expressions for Comparator.
- Collections Framework heavily uses both interfaces for sorting objects.

---

# Conclusion

Both **Comparable** and **Comparator** are essential interfaces for sorting objects in Java. Use **Comparable** when your class has a single natural ordering, such as sorting students by roll number. Use **Comparator** when you need multiple sorting criteria, such as sorting students by name, age, or marks. Choosing the right interface results in cleaner, more maintainable, and flexible code, making these concepts fundamental for Java development and technical interviews.
