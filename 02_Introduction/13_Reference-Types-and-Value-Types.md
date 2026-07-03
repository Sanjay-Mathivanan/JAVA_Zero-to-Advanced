# Reference Types and Value Types in Java

This guide details the structural differences between value types (primitives) and reference types (objects) in Java, exploring stack/heap allocations, reference copying, and method parameters.

---

## Core Comparison

The primary operational difference between value types and reference types is how their values are stored in memory:

* **Value Types (Primitives)**: The variable stores the **actual data value** directly.
* **Reference Types (Objects/Arrays)**: The variable stores a **memory address (reference)** pointing to the location where the actual data resides.

---

## 1. Value Types (Primitives)

All eight primitive data types (`byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean`) are value types.

### Code Example: Copying Values
When you assign one value type to another, Java copies the raw value directly. The two variables remain completely independent.

```java
public class ValueTypeDemo {
    public static void main(String[] args) {
        int firstInt = 9;
        int secondInt = firstInt; // Value of '9' is copied directly

        System.out.println("Before modification:");
        System.out.println("firstInt:  " + firstInt);   // Prints 9
        System.out.println("secondInt: " + secondInt);  // Prints 9

        secondInt = secondInt + 1; // Modifying secondInt

        System.out.println("\nAfter modification of secondInt:");
        System.out.println("firstInt:  " + firstInt);   // Prints 9 (unaffected)
        System.out.println("secondInt: " + secondInt);  // Prints 10
    }
}
```

### Memory Allocation
Both variables occupy separate memory cells on the Stack. Modifying one does not overwrite the other:

```text
Stack Memory:
[ firstInt  ] -> 9
[ secondInt ] -> 10  (Independent allocation)
```

---

## 2. Reference Types (Objects & Arrays)

Classes, interfaces, arrays, and strings are reference types.

### Code Example: Copying References
When you assign one reference variable to another, the JVM copies the **memory address pointer**, not the actual object data. Both variables end up pointing to the exact same object on the Heap.

```java
import java.util.Arrays;

public class ReferenceTypeDemo {
    public static void main(String[] args) {
        int[] firstArray = new int[5]; // Allocates array on Heap
        int[] secondArray = firstArray; // Copies the memory reference address

        System.out.println("Before modification:");
        System.out.println("firstArray:  " + Arrays.toString(firstArray));
        System.out.println("secondArray: " + Arrays.toString(secondArray));

        secondArray[2] = 99; // Modify an element via secondArray reference

        System.out.println("\nAfter modifying secondArray[2]:");
        System.out.println("firstArray:  " + Arrays.toString(firstArray));  // Show changes
        System.out.println("secondArray: " + Arrays.toString(secondArray)); // Show changes
    }
}
```

### Output
```text
Before modification:
firstArray:  [0, 0, 0, 0, 0]
secondArray: [0, 0, 0, 0, 0]

After modifying secondArray[2]:
firstArray:  [0, 0, 99, 0, 0]
secondArray: [0, 0, 99, 0, 0]
```

### Memory Allocation
Both reference variables reside on the Stack but contain the same heap address pointer `0x7b2f`:

```text
Stack Frame (Local Refs)            Heap Memory (Actual Array Object)
┌──────────────────────┐            ┌────────────────────────────────┐
│ firstArray  = 0x7b2f ├───────────►│                                │
├──────────────────────┤            │   [ 0 ] [ 0 ] [ 99 ] [ 0 ] [ 0 ]
│ secondArray = 0x7b2f ├───────────►│                                │
└──────────────────────┘            └────────────────────────────────┘
```

---

## Passing Parameters to Methods

Java uses **Pass-by-Value** exclusively. However, what is passed depends on the variable type:

* **For Primitives**: A copy of the actual value is passed. Changes made inside the method do not affect the caller's original variable.
* **For References**: A copy of the reference address is passed. Since the copied address points to the same object on the Heap, modifications to the object's contents inside the method will affect the original object.

### Method Passing Example
```java
import java.util.Arrays;

public class MethodPassDemo {
    public static void main(String[] args) {
        int val = 10;
        int[] arr = {1, 2, 3};

        modifyPrimitives(val);
        modifyObjects(arr);

        System.out.println("Primitive variable val: " + val); // Prints 10 (unaffected)
        System.out.println("Array contents arr:     " + Arrays.toString(arr)); // Prints [99, 2, 3] (modified)
    }

    public static void modifyPrimitives(int x) {
        x = 55; // Modifies local parameter copy only
    }

    public static void modifyObjects(int[] targetArray) {
        targetArray[0] = 99; // Modifies object on the shared heap address
    }
}
```

---

## Creating Independent Object Copies

To copy a reference type's contents without sharing a memory address, you must allocate a new object on the heap:

### Array Cloning
```java
int[] original = {1, 2, 3};
int[] copy = original.clone(); // Allocates a separate array object on the heap

copy[0] = 99; // Modifying copy does not affect original
```

---

## Comparison Summary Table

| Feature | Value Types (Primitives) | Reference Types (Objects/Arrays) |
| :--- | :--- | :--- |
| **Stores** | Actual literal value | Memory address pointer |
| **Memory Zone** | Stack Frame | Reference on Stack, Object on Heap |
| **Copy behavior** | Creates a separate independent copy | Copies the address (shares same object) |
| **Default state** | Cannot be null | Defaults to `null` if unassigned |
| **Examples** | `int`, `double`, `boolean`, `char` | `String`, `int[]`, custom class instances |

---

## Practice Challenges

### Challenge 1: Reference Re-assignment
Predict the output of the following code and write a program to verify:
```java
int[] listA = {1, 2, 3};
int[] listB = listA;
listB = new int[]{4, 5, 6}; // Re-assigning listB to a new object
System.out.println(listA[0]);
```

### Challenge 2: String Parameter Behavior
Predict the output of the following code. (Hint: Remember String immutability rules!)
```java
public class StringPass {
    public static void main(String[] args) {
        String name = "Alex";
        changeName(name);
        System.out.println(name);
    }
    public static void changeName(String s) {
        s = "Bob";
    }
}
```

---

**Back to Module Home:** [Introduction to Java Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/02_Introduction/README.md)
