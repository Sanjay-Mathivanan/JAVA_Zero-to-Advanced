# Basics of Collections in Java (Part 1 - B)

> **Chapter 10 - Collection Framework in Java**

---

# Iterator in Java

After sorting the collection, we need to access each element one by one.

Java provides an interface called **Iterator** for traversing collection elements.

Instead of accessing elements manually, Iterator moves from one element to the next until all elements are visited.

---

# Why Do We Need an Iterator?

Suppose we have a list.

```
10

20

30

40
```

To print every element,

we need to visit them one by one.

Iterator performs this task automatically.

```
Iterator

↓

10

↓

20

↓

30

↓

40
```

---

# Syntax

```java
Iterator<Integer> iterator = list.iterator();
```

Here,

- `Iterator<Integer>` → Iterator object for Integer values.
- `list.iterator()` → Returns an iterator for the list.

---

# Important Methods of Iterator

| Method | Description |
|----------|-------------|
| hasNext() | Checks whether another element exists |
| next() | Returns the next element |
| remove() | Removes the current element |

---

# hasNext()

The `hasNext()` method checks whether another element is available.

### Syntax

```java
iterator.hasNext();
```

Returns

```
true
```

or

```
false
```

---

# next()

Returns the next element.

### Syntax

```java
iterator.next();
```

---

# Example

```java
ArrayList<String> names = new ArrayList<>();

names.add("Rahul");
names.add("Arun");
names.add("Priya");

Iterator<String> iterator = names.iterator();

while(iterator.hasNext()){

    System.out.println(iterator.next());

}
```

---

# Output

```
Rahul
Arun
Priya
```

---

# Step-by-Step Execution

### Step 1

Create an iterator.

```
Iterator

↓

Points to First Element
```

---

### Step 2

Check

```java
hasNext()
```

Returns

```
true
```

---

### Step 3

Print

```java
next()
```

Returns

```
Rahul
```

---

### Step 4

Iterator moves to

```
Arun
```

The same process repeats until

```
false
```

is returned.

---

# Program Flow

```
Iterator Created

      │

      ▼

hasNext()

      │

      ▼

true

      │

      ▼

next()

      │

      ▼

Print Element

      │

      ▼

Move to Next

      │

      ▼

Repeat

      │

      ▼

false

      │

      ▼

Stop
```

---

# binarySearch()

The `binarySearch()` method searches for an element in a **sorted collection**.

---

# Why Must the Collection Be Sorted?

Binary Search repeatedly divides the collection into two halves.

```
10

20

30

40

50

60

70
```

Searching for

```
50
```

Instead of checking every element,

Binary Search checks the middle element first.

This makes searching much faster.

---

# Syntax

```java
Collections.binarySearch(list, element);
```

---

# Example

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);
numbers.add(40);

Collections.sort(numbers);

int index = Collections.binarySearch(numbers,30);

System.out.println(index);
```

---

# Output

```
2
```

---

# If the Element Does Not Exist

```java
Collections.binarySearch(numbers,100);
```

Output

```
Negative Value
```

A negative value means the element is not present.

---

# reverseOrder()

The `reverseOrder()` method sorts elements in descending order.

---

# Syntax

```java
Collections.sort(list, Collections.reverseOrder());
```

---

# Example

```java
ArrayList<Integer> marks = new ArrayList<>();

marks.add(60);
marks.add(90);
marks.add(75);
marks.add(45);

Collections.sort(marks, Collections.reverseOrder());

System.out.println(marks);
```

---

# Output

```
[90, 75, 60, 45]
```

---

# How reverseOrder() Works

Before

```
45

60

75

90
```

After

```
90

75

60

45
```

---

# Complete Flow of Your Program

```
Create List

        │

        ▼

Add Elements

        │

        ▼

Sort

        │

        ▼

Iterator

        │

        ▼

Print Values

        │

        ▼

Binary Search

        │

        ▼

Reverse Sort

        │

        ▼

Iterator

        │

        ▼

Print Reverse Order

        │

        ▼

End
```

---

# Memory Representation

```
Stack Memory

+----------------------+
| newList              |
| iterator             |
| search               |
+----------|-----------+
           |
           ▼

Heap Memory

+----------------------+
| ArrayList            |
|----------------------|
| 23                   |
| 3                    |
| 2                    |
| 1                    |
+----------------------+
```

---

# Additional Example 1

## Finding Maximum Value

```java
ArrayList<Integer> marks = new ArrayList<>();

marks.add(70);
marks.add(95);
marks.add(88);

System.out.println(Collections.max(marks));
```

### Output

```
95
```

---

# Additional Example 2

## Finding Minimum Value

```java
System.out.println(Collections.min(marks));
```

### Output

```
70
```

---

# Additional Example 3

## Reversing Elements

```java
ArrayList<String> names = new ArrayList<>();

names.add("A");
names.add("B");
names.add("C");

Collections.reverse(names);

System.out.println(names);
```

### Output

```
[C, B, A]
```

---

# Additional Example 4

## Shuffle Elements

```java
Collections.shuffle(names);

System.out.println(names);
```

### Output

```
[B, A, C]
```

(Output may differ because shuffle generates a random order.)

---

# Additional Example 5

## Swap Two Elements

```java
ArrayList<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);

Collections.swap(list,0,2);

System.out.println(list);
```

### Output

```
[30, 20, 10]
```

---

# Additional Example 6

## Count Frequency

```java
ArrayList<Integer> numbers = new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);
numbers.add(30);

System.out.println(Collections.frequency(numbers,10));
```

### Output

```
2
```

---

# Time Complexity

| Method | Time Complexity |
|----------|-----------------|
| add() | O(1) (Average) |
| sort() | O(n log n) |
| binarySearch() | O(log n) |
| reverse() | O(n) |
| shuffle() | O(n) |
| swap() | O(1) |
| frequency() | O(n) |

---

# Collection vs Collections

| Collection | Collections |
|------------|-------------|
| Interface | Utility Class |
| Stores Objects | Performs Operations |
| Parent of List, Queue, Set | Contains Static Methods |
| Example: List | Example: sort() |

---

# Common Mistakes

## Mistake 1

Searching without sorting.

```java
Collections.binarySearch(list,20);
```

Always sort before using Binary Search.

---

## Mistake 2

Calling

```java
next()
```

without checking

```java
hasNext()
```

This causes

```
NoSuchElementException
```

---

## Mistake 3

Using raw collections.

Wrong

```java
List list = new ArrayList();
```

Correct

```java
List<Integer> list = new ArrayList<>();
```

---

# Best Practices

- Always use Generics.
- Use `Iterator` for safe traversal.
- Sort before Binary Search.
- Use the `Collections` utility methods instead of writing custom algorithms.
- Choose the correct collection based on your requirement.

---

# Interview Questions

## Beginner

1. What is the difference between Collection and Collections?
2. What is an Iterator?
3. What does `hasNext()` return?
4. What is the purpose of `next()`?

---

## Intermediate

5. Why must Binary Search be used only on sorted collections?
6. Explain `reverseOrder()`.
7. Difference between `Iterator` and `ListIterator`.

---

## Advanced

8. What sorting algorithm is used internally by `Collections.sort()`?
9. What is the time complexity of Binary Search?
10. Why are Generics recommended?

---

# Practice Programs

### Easy

- Sort an ArrayList of integers.
- Reverse an ArrayList.
- Find the maximum number.

### Medium

- Count the frequency of an element.
- Search an element using Binary Search.
- Sort strings alphabetically.

### Hard

- Sort Employee objects using Collections.
- Reverse a list of Student objects.
- Search objects using Comparator.

---

# Concept Map

```
Collections Utility Class

        │

        ├── sort()

        ├── binarySearch()

        ├── reverse()

        ├── reverseOrder()

        ├── shuffle()

        ├── swap()

        ├── max()

        ├── min()

        └── frequency()
```

---

# Key Takeaways

- `Iterator` is used to traverse collection elements.
- `hasNext()` checks for the next element.
- `next()` returns the next element.
- `Collections.sort()` sorts in ascending order.
- `Collections.reverseOrder()` sorts in descending order.
- `Collections.binarySearch()` works only on sorted collections.
- The `Collections` utility class provides many ready-made methods to simplify collection operations.

---

# Summary

In this chapter, you learned how to use the **Collections Utility Class** to perform common operations such as sorting, searching, reversing, and traversing collections. You also explored the use of `Iterator`, understood important methods like `sort()`, `binarySearch()`, and `reverseOrder()`, and practiced additional utility methods such as `max()`, `min()`, `shuffle()`, `swap()`, and `frequency()`.

These concepts form the foundation for working efficiently with Java Collections and prepare you for learning individual collection classes such as **ArrayList**, **LinkedList**, **Vector**, **HashSet**, and **HashMap** in the upcoming chapters.
