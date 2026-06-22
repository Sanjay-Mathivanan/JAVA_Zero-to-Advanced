# ArrayList in Java 

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

In **Part 1-A**, we learned:

- What is ArrayList?
- Why ArrayList?
- Features
- Characteristics
- Constructors
- Internal Working
- Creating an ArrayList

In this chapter, we will learn the most commonly used **ArrayList methods** with detailed examples.

---

# Commonly Used Methods

| Method | Purpose |
|----------|----------|
| add() | Add an element |
| add(index, element) | Insert an element at a specific index |
| get() | Retrieve an element |
| set() | Update an element |
| size() | Find the total number of elements |
| contains() | Check whether an element exists |
| isEmpty() | Check whether the list is empty |
| indexOf() | Find the first occurrence |
| lastIndexOf() | Find the last occurrence |

---

# add()

## Definition

The **add()** method inserts an element at the end of the ArrayList.

---

## Syntax

```java
list.add(element);
```

---

## Example 1

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        System.out.println(fruits);

    }

}
```

---

## Output

```
[Apple, Banana, Orange]
```

---

## Internal Working

Initially

```
Empty ArrayList

[]

↓

Add Apple

[Apple]

↓

Add Banana

[Apple, Banana]

↓

Add Orange

[Apple, Banana, Orange]
```

---

# Example 2

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

System.out.println(numbers);
```

### Output

```
[10, 20, 30]
```

---

# add(index, element)

## Definition

Inserts an element at a specified index.

Existing elements are shifted to the right.

---

## Syntax

```java
list.add(index, element);
```

---

## Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Priya");
names.add("John");

names.add(1, "Arun");

System.out.println(names);
```

---

## Output

```
[Rahul, Arun, Priya, John]
```

---

## Internal Working

Before

```
Index

0

1

2

↓

Rahul

Priya

John
```

Insert

```
Arun
```

at index

```
1
```

After

```
Rahul

Arun

Priya

John
```

---

# get()

## Definition

Returns the element stored at a specified index.

---

## Syntax

```java
list.get(index);
```

---

## Example

```java
ArrayList<String> cities = new ArrayList<>();

cities.add("Chennai");
cities.add("Coimbatore");
cities.add("Madurai");

System.out.println(cities.get(1));
```

---

## Output

```
Coimbatore
```

---

## Memory Representation

```
Index

0

1

2

↓

Chennai

Coimbatore

Madurai

get(1)

↓

Coimbatore
```

---

# set()

## Definition

Replaces an existing element.

---

## Syntax

```java
list.set(index, element);
```

---

## Example

```java
ArrayList<String> colors = new ArrayList<>();

colors.add("Red");
colors.add("Blue");
colors.add("Green");

colors.set(1,"Black");

System.out.println(colors);
```

---

## Output

```
[Red, Black, Green]
```

---

## Internal Working

Before

```
Red

Blue

Green
```

Replace

```
Blue
```

with

```
Black
```

After

```
Red

Black

Green
```

---

# size()

## Definition

Returns the total number of elements.

---

## Syntax

```java
list.size();
```

---

## Example

```java
ArrayList<Integer> marks = new ArrayList<>();

marks.add(90);
marks.add(85);
marks.add(75);

System.out.println(marks.size());
```

---

## Output

```
3
```

---

# contains()

## Definition

Checks whether an element exists.

Returns

```
true

or

false
```

---

## Syntax

```java
list.contains(element);
```

---

## Example

```java
ArrayList<String> languages = new ArrayList<>();

languages.add("Java");
languages.add("Python");

System.out.println(languages.contains("Java"));
```

---

## Output

```
true
```

---

# Example

```java
System.out.println(languages.contains("C"));
```

---

## Output

```
false
```

---

# isEmpty()

## Definition

Checks whether the ArrayList is empty.

---

## Syntax

```java
list.isEmpty();
```

---

## Example

```java
ArrayList<String> list = new ArrayList<>();

System.out.println(list.isEmpty());
```

---

## Output

```
true
```

---

# Example

```java
list.add("Java");

System.out.println(list.isEmpty());
```

---

## Output

```
false
```

---

# indexOf()

## Definition

Returns the index of the first occurrence.

---

## Syntax

```java
list.indexOf(element);
```

---

## Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("A");
names.add("B");
names.add("A");
names.add("C");

System.out.println(names.indexOf("A"));
```

---

## Output

```
0
```

---

# lastIndexOf()

## Definition

Returns the last occurrence of an element.

---

## Syntax

```java
list.lastIndexOf(element);
```

---

## Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("A");
names.add("B");
names.add("A");
names.add("C");

System.out.println(names.lastIndexOf("A"));
```

---

## Output

```
2
```

---

# Complete Example Program

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<>();

        students.add("Rahul");
        students.add("Arun");
        students.add("Priya");

        students.add(1,"John");

        System.out.println(students);

        System.out.println(students.get(2));

        students.set(2,"Kavin");

        System.out.println(students);

        System.out.println("Size : " + students.size());

        System.out.println("Contains Rahul : " + students.contains("Rahul"));

        System.out.println("Index of John : " + students.indexOf("John"));

        System.out.println("Last Index of Rahul : " + students.lastIndexOf("Rahul"));

    }

}
```

---

# Output

```
[Rahul, John, Arun, Priya]

Arun

[Rahul, John, Kavin, Priya]

Size : 4

Contains Rahul : true

Index of John : 1

Last Index of Rahul : 0
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

Insert Element

   │

   ▼

Get Element

   │

   ▼

Update Element

   │

   ▼

Find Size

   │

   ▼

Check contains()

   │

   ▼

Find indexOf()

   │

   ▼

Find lastIndexOf()

   │

   ▼

End
```

---

# Memory Representation

```
Stack Memory

+----------------------+
| students             |
+----------|-----------+
           |
           ▼

Heap Memory

+---------------------------+
| ArrayList Object          |
|---------------------------|
| Rahul                     |
| John                      |
| Kavin                     |
| Priya                     |
+---------------------------+
```

---

# Time Complexity

| Operation | Time Complexity |
|------------|-----------------|
| add() | O(1) Average |
| add(index) | O(n) |
| get() | O(1) |
| set() | O(1) |
| contains() | O(n) |
| size() | O(1) |
| indexOf() | O(n) |
| lastIndexOf() | O(n) |
| isEmpty() | O(1) |

---

# Real-World Applications

ArrayList is used in:

- Student Records
- Employee Database
- Shopping Cart
- Music Playlist
- Contact List
- Banking Transactions
- Product Catalog
- Online Booking Systems

---

# Common Mistakes

## Mistake 1

Accessing an invalid index.

```java
list.get(10);
```

Output

```
IndexOutOfBoundsException
```

---

## Mistake 2

Using primitive types.

Wrong

```java
ArrayList<int> list;
```

Correct

```java
ArrayList<Integer> list;
```

---

## Mistake 3

Confusing

```java
add()
```

and

```java
set()
```

- `add()` inserts a new element.
- `set()` replaces an existing element.

---

# Best Practices

- Always use Generics.
- Prefer `List` interface for declaration.
- Check the index before using `get()` or `set()`.
- Use `contains()` before searching manually.
- Use meaningful variable names.

---

# Interview Questions

### Beginner

1. What is ArrayList?
2. Difference between Array and ArrayList?
3. Which package contains ArrayList?
4. Can ArrayList store duplicate values?

---

### Intermediate

5. Difference between `add()` and `set()`?
6. Difference between `indexOf()` and `lastIndexOf()`?
7. What does `contains()` return?
8. Explain the time complexity of `get()`.

---

### Advanced

9. Why is `get()` O(1)?
10. Why is `add(index)` O(n)?
11. Explain the internal working of `ArrayList`.
12. Why is ArrayList faster than LinkedList for random access?

---

# Key Takeaways

- `add()` inserts elements.
- `add(index, element)` inserts at a specific position.
- `get()` retrieves elements by index.
- `set()` updates existing elements.
- `size()` returns the total number of elements.
- `contains()` checks for element existence.
- `indexOf()` returns the first occurrence.
- `lastIndexOf()` returns the last occurrence.
- ArrayList provides fast random access using indexes.

---

# What's Next?

In **03_ArrayList**, we will explore advanced ArrayList operations, including:

- `remove()`
- `clear()`
- `clone()`
- `toArray()`
- `ensureCapacity()`
- `trimToSize()`
- Iterator
- ListIterator
- Enhanced `for` loop
- `forEach()`
- Sorting and Searching
- Internal Working of Dynamic Resizing
- Multiple Real-World Examples
