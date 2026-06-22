# ArrayList in Java 

> **Chapter 10 - Collection Framework in Java**

---

# Introduction

In **Part 2-A**, we learned about:

- remove()
- clear()
- clone()
- toArray()
- ensureCapacity()
- trimToSize()

In this chapter, we will learn how to traverse an ArrayList, sort it, search elements, and use utility methods from the `Collections` class.

---

# Traversing an ArrayList

Traversal means **visiting every element** of the ArrayList.

Java provides multiple ways to traverse an ArrayList.

- for Loop
- Enhanced for Loop
- Iterator
- ListIterator
- forEach()

---

# Method 1 - Using for Loop

## Syntax

```java
for(int i=0;i<list.size();i++){

    System.out.println(list.get(i));

}
```

---

## Example

```java
import java.util.ArrayList;

public class Main{

    public static void main(String[] args){

        ArrayList<String> fruits=new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        for(int i=0;i<fruits.size();i++){

            System.out.println(fruits.get(i));

        }

    }

}
```

---

## Output

```
Apple

Banana

Orange
```

---

# Method 2 - Enhanced for Loop

Enhanced for loop is simpler.

---

## Syntax

```java
for(String value:list){

    System.out.println(value);

}
```

---

## Example

```java
ArrayList<Integer> numbers=new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(30);

for(Integer num:numbers){

    System.out.println(num);

}
```

---

## Output

```
10

20

30
```

---

# Method 3 - Iterator

Iterator moves through elements one by one.

---

## Syntax

```java
Iterator<String> iterator=list.iterator();
```

---

## Example

```java
import java.util.*;

public class Main{

    public static void main(String[] args){

        ArrayList<String> names=new ArrayList<>();

        names.add("Rahul");
        names.add("Arun");
        names.add("Priya");

        Iterator<String> iterator=names.iterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

    }

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

# Iterator Flow

```
Iterator

     │

     ▼

Rahul

     │

     ▼

Arun

     │

     ▼

Priya

     │

     ▼

End
```

---

# Iterator Methods

| Method | Description |
|----------|-------------|
| hasNext() | Checks next element |
| next() | Returns next element |
| remove() | Removes current element |

---

# Method 4 - ListIterator

ListIterator is more powerful than Iterator.

It can

- Move Forward
- Move Backward
- Add Elements
- Remove Elements
- Replace Elements

---

## Syntax

```java
ListIterator<String> iterator=list.listIterator();
```

---

## Example

```java
import java.util.*;

public class Main{

    public static void main(String[] args){

        ArrayList<String> list=new ArrayList<>();

        list.add("Java");
        list.add("Python");
        list.add("C++");

        ListIterator<String> iterator=list.listIterator();

        while(iterator.hasNext()){

            System.out.println(iterator.next());

        }

    }

}
```

---

## Output

```
Java

Python

C++
```

---

# Moving Backward

```java
while(iterator.hasPrevious()){

    System.out.println(iterator.previous());

}
```

---

## Output

```
C++

Python

Java
```

---

# Iterator vs ListIterator

| Iterator | ListIterator |
|-----------|--------------|
| Forward Only | Forward & Backward |
| Remove Supported | Add, Remove, Set Supported |
| Works on Collection | Works on List |

---

# Method 5 - forEach()

Introduced in Java 8.

---

## Example

```java
ArrayList<String> languages=new ArrayList<>();

languages.add("Java");
languages.add("Python");
languages.add("C");

languages.forEach(System.out::println);
```

---

## Output

```
Java

Python

C
```

---

# Sorting an ArrayList

Collections class provides sorting.

---

## Ascending Order

```java
Collections.sort(list);
```

---

## Example

```java
ArrayList<Integer> marks=new ArrayList<>();

marks.add(60);
marks.add(90);
marks.add(75);
marks.add(45);

Collections.sort(marks);

System.out.println(marks);
```

---

## Output

```
[45, 60, 75, 90]
```

---

# Descending Order

```java
Collections.sort(list,
Collections.reverseOrder());
```

---

## Output

```
[90, 75, 60, 45]
```

---

# Searching

Searching is performed using

```java
Collections.binarySearch()
```

---

## Example

```java
ArrayList<Integer> list=new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);
list.add(40);

Collections.sort(list);

System.out.println(
Collections.binarySearch(list,30));
```

---

## Output

```
2
```

---

# Important Collections Methods

| Method | Purpose |
|----------|----------|
| sort() | Sort elements |
| reverse() | Reverse list |
| shuffle() | Random order |
| swap() | Exchange elements |
| max() | Maximum value |
| min() | Minimum value |
| binarySearch() | Search element |
| frequency() | Count occurrences |

---

# Example - Reverse

```java
Collections.reverse(list);
```

---

## Output

```
[40,30,20,10]
```

---

# Example - Shuffle

```java
Collections.shuffle(list);
```

---

## Example Output

```
[20,40,10,30]
```

(Random order)

---

# Example - Maximum

```java
System.out.println(
Collections.max(list));
```

Output

```
40
```

---

# Example - Minimum

```java
System.out.println(
Collections.min(list));
```

Output

```
10
```

---

# Example - Swap

```java
Collections.swap(list,0,2);

System.out.println(list);
```

---

# Example Output

```
[30,20,10,40]
```

---

# Example - Frequency

```java
ArrayList<Integer> numbers=new ArrayList<>();

numbers.add(10);
numbers.add(20);
numbers.add(10);
numbers.add(30);

System.out.println(
Collections.frequency(numbers,10));
```

---

## Output

```
2
```

---

# Complete Program

```java
import java.util.*;

public class Main{

    public static void main(String[] args){

        ArrayList<Integer> list=new ArrayList<>();

        list.add(30);
        list.add(10);
        list.add(20);
        list.add(40);

        Collections.sort(list);

        for(Integer value:list){

            System.out.println(value);

        }

        System.out.println("Maximum : "+Collections.max(list));

        System.out.println("Minimum : "+Collections.min(list));

    }

}
```

---

# Output

```
10

20

30

40

Maximum : 40

Minimum : 10
```

---

# Internal Working

```
ArrayList

      │

      ▼

Collections.sort()

      │

      ▼

Sort Internal Array

      │

      ▼

Iterator

      │

      ▼

Print Elements
```

---

# Memory Representation

```
Stack Memory

list

iterator

      │

      ▼

Heap Memory

+-----------------------+

10

20

30

40

+-----------------------+
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

Sort

   │

   ▼

Traverse

   │

   ▼

Find Maximum

   │

   ▼

Find Minimum

   │

   ▼

End
```

---

# Time Complexity

| Operation | Complexity |
|------------|------------|
| for Loop | O(n) |
| Enhanced for | O(n) |
| Iterator | O(n) |
| ListIterator | O(n) |
| sort() | O(n log n) |
| binarySearch() | O(log n) |
| reverse() | O(n) |
| shuffle() | O(n) |
| max() | O(n) |
| min() | O(n) |
| frequency() | O(n) |

---

# Common Mistakes

## Mistake 1

Calling

```java
next()
```

without

```java
hasNext()
```

Results in

```
NoSuchElementException
```

---

## Mistake 2

Using Binary Search without sorting.

Wrong

```java
Collections.binarySearch(list,20);
```

Always sort first.

---

## Mistake 3

Using Iterator to move backward.

Iterator cannot move backward.

Use

```java
ListIterator
```

instead.

---

# Best Practices

- Use Enhanced for loop for simple traversal.
- Use Iterator when removing elements during traversal.
- Use ListIterator for bidirectional traversal.
- Always sort before Binary Search.
- Prefer Generics for type safety.

---

# Interview Questions

## Beginner

1. What is ArrayList?
2. Difference between Iterator and ListIterator?
3. What is Enhanced for loop?

---

## Intermediate

4. Explain Collections.sort().
5. Why must Binary Search be performed on sorted data?
6. Difference between Iterator and forEach()?

---

## Advanced

7. Explain the internal working of ArrayList traversal.
8. Which traversal method is the fastest?
9. Explain time complexity of ArrayList operations.
10. Why does ListIterator support backward traversal?

---

# Practice Programs

### Easy

- Print all elements using a for loop.
- Print all elements using Iterator.
- Find the maximum value.

### Medium

- Reverse an ArrayList.
- Shuffle an ArrayList.
- Search an element using Binary Search.

### Hard

- Traverse an ArrayList in reverse order using ListIterator.
- Sort Employee objects.
- Count duplicate elements using frequency().

---

# Concept Map

```
                    ArrayList

                        │

        ┌───────────────┼────────────────┐

        ▼               ▼                ▼

   Traversal        Searching         Sorting

        │               │                │

 Iterator       binarySearch()      sort()

 ListIterator                     reverseOrder()

 forEach()                        reverse()

 Enhanced for                     shuffle()

                                   swap()

                                   max()

                                   min()
```

---

# Key Takeaways

- ArrayList supports multiple traversal techniques.
- Iterator moves only forward.
- ListIterator moves both forward and backward.
- `Collections.sort()` sorts elements.
- `Collections.binarySearch()` searches sorted data efficiently.
- `Collections` provides many utility methods like `reverse()`, `shuffle()`, `swap()`, `max()`, and `min()`.

---

# What's Next?

In **05_ArrayList**, we will learn:

- Internal Dynamic Resizing
- Capacity vs Size
- Initial Capacity
- Growth Formula (1.5x Expansion)
- ArrayList vs LinkedList
- ArrayList vs Vector
- Real-World Applications
- Internal Memory Management
- 40+ Interview Questions
- Practice Programs
- Chapter Summary and Conclusion
