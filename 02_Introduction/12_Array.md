# Arrays in Java

---

## Introduction

An array is a collection of elements of the same data type stored in a contiguous memory location.

It allows you to store multiple values in a single variable instead of creating separate variables.

---

## Why Arrays are Needed

Without arrays:

```java
int a = 10;
int b = 20;
int c = 30;
```

With arrays:

```java
int[] arr = {10, 20, 30};
```

---

## Array Declaration

```java
int[] arr;
```

---

## Array Initialization

```java
arr = new int[5];
```

---

## Combined Declaration + Initialization

```java
int[] arr = new int[5];
```

---

## Direct Initialization

```java
int[] arr = {10, 20, 30, 40};
```

---

## Accessing Elements

```java
System.out.println(arr[0]); // first element
```

---

## Index Concept (Very Important)

```text
Index:   0   1   2   3
Value:  10  20  30  40
```

* Index starts from 0
* Last index = size - 1

---

## Example Program

```java
public class ArrayDemo {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};

        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
        System.out.println(arr[3]);
    }
}
```

---

## Loop Through Array

```java
for (int i = 0; i < arr.length; i++) {
    System.out.println(arr[i]);
}
```

---

## Enhanced For Loop

```java
for (int value : arr) {
    System.out.println(value);
}
```

---

## Memory Representation

```text
arr → [10 | 20 | 30 | 40]
        0    1    2    3
```

---

## Default Values

When array is created:

```text
int → 0
float → 0.0
boolean → false
char → '\u0000'
```

---

## Array Length

```java
System.out.println(arr.length);
```

---

## Common Errors

### ArrayIndexOutOfBoundsException

```java
System.out.println(arr[5]); // error
```

---

## Multidimensional Array (Intro)

```java
int[][] matrix = {
    {1, 2},
    {3, 4}
};
```

---

## Real Example

```java
public class SumArray {
    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40};
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        System.out.println("Sum: " + sum);
    }
}
```

---

## Analogy

Think of array like a row of boxes:

* Each box has an index
* Each box stores one value
* All boxes are of same type

---

## Common Mistakes

* Accessing invalid index
* Forgetting array size
* Confusing index and value
* Not using loop for traversal

---

## Practice Challenges

### Challenge 1

Print all elements of an array.

### Challenge 2

Find sum of elements.

### Challenge 3

Find maximum value in array.

### Challenge 4

Reverse an array.

---

## Concept Map

```text
Array
 ↓
Collection of Same Type
 ↓
Index-Based Access
 ↓
Loop Traversal
 ↓
Memory Efficiency
```

---

## Key Takeaways

* Arrays store multiple values in one variable
* Index starts from 0
* All elements must be same type
* Arrays have fixed size
* Loops are used to traverse arrays

---

## Additional Program: User Input and Sum of Array

## Program

```java
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        int[] userArray = getUserArray(6);
        int userSum = userSum(userArray);

        System.out.println("The sum is : " + userSum);

        sc.close();
    }

    public static int[] getUserArray(int number){

        System.out.println("Enter " + number + " integers");

        int[] userValues = new int[number];

        for(int i = 0; i < userValues.length; i++){
            userValues[i] = sc.nextInt();
        }

        return userValues;
    }

    public static int userSum(int[] array){

        int sum = 0;

        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }

        return sum;
    }
}
```

---

## Explanation

This program demonstrates how to:

* Take input from the user
* Store values in an array
* Process the array using a method
* Return and print the result

### Flow

User Input → Array Creation → Sum Calculation → Output

### Key Concepts Used

* Arrays
* Methods
* Loops
* Scanner
* Return values

### Key Insight

The logic is divided into methods:

* getUserArray() → handles input
* userSum() → handles processing

This makes the code clean and reusable.

---

## Conclusion

Arrays are the foundation of data structures. This file combines both theory and real implementation for strong understanding.
