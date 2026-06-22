# ArrayList in Java 

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

In **02_ArrayList**, we learned:

- Creating an ArrayList
- add()
- add(index, element)
- get()
- set()
- size()
- contains()
- indexOf()
- lastIndexOf()

In this chapter, we will learn advanced operations of the ArrayList.

---

# Topics Covered

- remove()
- remove(index)
- clear()
- clone()
- toArray()
- ensureCapacity()
- trimToSize()
- Multiple Example Programs
- Internal Working
- Memory Representation

---

# remove()

## Definition

The **remove()** method removes an element from the ArrayList.

There are two versions.

```
remove(index)

remove(object)
```

---

# remove(index)

Removes the element present at the specified index.

---

## Syntax

```java
list.remove(index);
```

---

## Example

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        fruits.remove(1);

        System.out.println(fruits);

    }

}
```

---

## Output

```
[Apple, Orange]
```

---

# Internal Working

Before

```
Index

0

1

2

↓

Apple

Banana

Orange
```

Remove

```
Index 1
```

After

```
Apple

Orange
```

Java automatically shifts the remaining elements.

---

# remove(Object)

Removes the specified object.

---

## Syntax

```java
list.remove("Apple");
```

---

## Example

```java
ArrayList<String> fruits = new ArrayList<>();

fruits.add("Apple");
fruits.add("Banana");
fruits.add("Orange");

fruits.remove("Banana");

System.out.println(fruits);
```

---

## Output

```
[Apple, Orange]
```

---

# Difference

| remove(index) | remove(object) |
|---------------|----------------|
| Removes by index | Removes by value |
| Uses integer index | Uses object |
| Shifts elements | Searches then removes |

---

# Example

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

numbers.remove(0);

System.out.println(numbers);
```

Output

```
[20, 30]
```

---

# clear()

## Definition

Removes all elements from the ArrayList.

---

## Syntax

```java
list.clear();
```

---

## Example

```java
ArrayList<String> cities = new ArrayList<>();

cities.add("Chennai");
cities.add("Madurai");
cities.add("Coimbatore");

cities.clear();

System.out.println(cities);
```

---

## Output

```
[]
```

---

# Internal Working

Before

```
Chennai

Madurai

Coimbatore
```

After

```
Empty
```

---

# clone()

## Definition

Creates a shallow copy of the ArrayList.

---

## Syntax

```java
ArrayList<String> copy =
(ArrayList<String>) list.clone();
```

---

## Example

```java
ArrayList<String> list = new ArrayList<>();

list.add("Java");
list.add("Python");

ArrayList<String> copy =
(ArrayList<String>) list.clone();

System.out.println(copy);
```

---

## Output

```
[Java, Python]
```

---

# Internal Working

```
Original List

↓

Java

Python

↓

Clone

↓

Java

Python
```

Both lists are different objects.

---

# toArray()

## Definition

Converts an ArrayList into an array.

---

## Syntax

```java
Object[] array = list.toArray();
```

---

## Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Arun");
names.add("Priya");

Object[] array = names.toArray();

for(Object value : array){

    System.out.println(value);

}
```

---

## Output

```
Rahul

Arun

Priya
```

---

# ensureCapacity()

## Definition

Increases the capacity of an ArrayList before adding many elements.

This helps improve performance by reducing the number of internal resizing operations.

---

## Syntax

```java
list.ensureCapacity(100);
```

---

## Example

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.ensureCapacity(50);

numbers.add(10);

numbers.add(20);

System.out.println(numbers);
```

---

## Output

```
[10, 20]
```

---

# Why Use ensureCapacity()?

Without

```
ensureCapacity()
```

Java resizes the internal array multiple times.

With

```
ensureCapacity()
```

Java allocates enough memory initially.

This improves performance.

---

# trimToSize()

## Definition

Removes unused capacity.

Capacity becomes equal to the current size.

---

## Syntax

```java
list.trimToSize();
```

---

## Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("A");

names.add("B");

names.trimToSize();

System.out.println(names);
```

---

## Output

```
[A, B]
```

---

# Why Use trimToSize()?

Suppose

Capacity

```
100
```

Current Size

```
5
```

Unused memory exists.

```
trimToSize()
```

removes the extra unused capacity.

---

# Complete Example Program

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        list.remove("Python");

        System.out.println(list);

        list.add("JavaScript");

        System.out.println(list);

        list.ensureCapacity(20);

        list.trimToSize();

        Object[] array = list.toArray();

        for(Object obj : array){

            System.out.println(obj);

        }

    }

}
```

---

# Output

```
[Java, C++]

[Java, C++, JavaScript]

Java

C++

JavaScript
```

---

# Program Flow

```
Start

   │

   ▼

Create ArrayList

   │

   ▼

Add Elements

   │

   ▼

Remove Element

   │

   ▼

Convert to Array

   │

   ▼

Print Elements

   │

   ▼

End
```

---

# Memory Representation

```
Stack

list

 │

 ▼

Heap

+-------------------------+

Java

C++

JavaScript

+-------------------------+
```

---

# Time Complexity

| Method | Complexity |
|----------|------------|
| remove(index) | O(n) |
| remove(object) | O(n) |
| clear() | O(n) |
| clone() | O(n) |
| toArray() | O(n) |
| ensureCapacity() | O(n) (only when resizing) |
| trimToSize() | O(n) |

---

# Common Mistakes

### Mistake 1

Removing an invalid index.

```java
list.remove(10);
```

Throws

```
IndexOutOfBoundsException
```

---

### Mistake 2

Confusing

```java
remove(1)
```

with

```java
remove(Integer.valueOf(1))
```

The first removes by **index**.

The second removes by **object**.

---

### Mistake 3

Expecting

```java
clone()
```

to perform a deep copy.

It creates only a **shallow copy**.

---

# Best Practices

- Use `remove(object)` when removing by value.
- Use `remove(index)` when removing by position.
- Use `ensureCapacity()` for large datasets.
- Use `trimToSize()` to reduce memory usage.
- Use `toArray()` when interacting with APIs that require arrays.

---

# Key Takeaways

- `remove()` deletes elements by index or value.
- `clear()` removes all elements.
- `clone()` creates a shallow copy.
- `toArray()` converts an ArrayList to an array.
- `ensureCapacity()` improves performance.
- `trimToSize()` optimizes memory usage.

---

# What's Next?

In **04_ArrayList**, we will learn:

- Iterator
- ListIterator
- Enhanced for loop
- forEach()
- Sorting ArrayList
- Searching
- Collections Utility Methods
- Internal Working
- Interview Questions
- Practice Programs
