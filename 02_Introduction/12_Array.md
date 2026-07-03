# Arrays in Java

This guide details the specifications of arrays in Java, covering declarations, dynamic memory allocation, access patterns, multi-dimensional structures, and common exceptions.

---

## Introduction

An array is an object in Java that contains a fixed number of elements of a single data type. The elements of an array are stored in a contiguous block of memory and are accessed using integer indices.

---

## Technical Characteristics of Java Arrays

* **Fixed Size**: Once an array is instantiated, its length cannot be changed. If dynamic resizing is needed, use collection classes like `ArrayList`.
* **Object Type**: Arrays are treated as objects in Java, residing on the Heap. The array variable itself stores a reference address.
* **Type Homogeneity**: All elements stored in the array must be of the same declared data type (or subtypes of that type).
* **Length Property**: Every array object has a built-in public read-only field called `length` (e.g., `myArray.length`) representing its size.

---

## Array Lifecycle: Declaration to Initialization

Creating an array involves two primary steps: declaration (creating the reference) and instantiation/initialization (allocating the actual memory space).

### 1. Declaration
Declares the name and data type of the array variable. No memory is allocated on the heap yet.
```java
int[] numbers; // Recommended syntax
int numbers[]; // Alternate syntax (valid but discouraged)
```

### 2. Instantiation (Dynamic Allocation)
Uses the `new` keyword to specify the size and allocate heap memory. All elements receive default values (e.g., `0` for numbers, `false` for booleans, `null` for references).
```java
numbers = new int[5]; // Allocates space for 5 integers
```

### 3. Direct Initialization (Array Literals)
Declares, allocates, and initializes values in a single statement.
```java
int[] scores = {90, 85, 78, 92, 88};
```

---

## Indexing and Element Access

Array indexing is 0-based. The first element is at index `0`, and the last element is at index `length - 1`.

```text
Array containing {10, 20, 30, 40}

Index:      0      1      2      3
Value:   [ 10 ] [ 20 ] [ 30 ] [ 40 ]
```

### Accessing Values
```java
int[] items = {10, 20, 30, 40};
System.out.println("First element: " + items[0]); // Prints 10
items[1] = 99; // Modifies the second element
```

---

## Traversing Arrays

There are two primary methods for looping through array elements:

### 1. Standard For Loop
Use when index tracking or modification is required.
```java
int[] data = {10, 20, 30, 40};
for (int i = 0; i < data.length; i++) {
    System.out.println("Index " + i + ": " + data[i]);
}
```

### 2. Enhanced For Loop (For-Each)
Use for clean, read-only iteration when tracking index numbers is not required.
```java
for (int val : data) {
    System.out.println("Value: " + val);
}
```

---

## Multidimensional Arrays

A multidimensional array in Java is an **array of arrays**. A two-dimensional array represents a grid structure:

```java
public class MatrixDemo {
    public static void main(String[] args) {
        // Declaring a 2x3 matrix (2 rows, 3 columns)
        int[][] grid = {
            {1, 2, 3},
            {4, 5, 6}
        };

        // Traversing a 2D array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
```

### Output
```text
1 2 3 
4 5 6 
```

---

## Common Exceptions

> [!WARNING]
> ### ArrayIndexOutOfBoundsException
> * **Cause**: Occurs when trying to access an index that is negative, or greater than or equal to the array length (e.g., trying to access index `5` on an array of length `5`).
> * **Example**:
>   ```java
>   int[] arr = new int[5]; // Valid indices are 0 to 4
>   System.out.println(arr[5]); // Throws ArrayIndexOutOfBoundsException at runtime
>   ```

---

## Complete Example Program

This program requests integers from the user, stores them in an array, and calculates their mathematical sum:

```java
import java.util.Scanner;

public class ArrayProcess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 5;

        int[] data = readValues(input, size);
        int total = calculateSum(data);

        System.out.println("Sum of array elements: " + total);
        input.close();
    }

    public static int[] readValues(Scanner sc, int count) {
        System.out.println("Enter " + count + " integers:");
        int[] values = new int[count];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        return values;
    }

    public static int calculateSum(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
```

---

## Practice Challenges

### Challenge 1: Find Maximum Value
Write a static method `findMax(int[] array)` that returns the largest integer value in a given array.

### Challenge 2: Array Reversal
Write a method that takes an array of strings and reverses the order of its elements in-place (without creating a second array).

### Challenge 3: Linear Search
Write a program that searches an array for a target value and returns the index where it is located. If not found, return `-1`.

---

**Back to Module Home:** [Introduction to Java Programming](README.md)
