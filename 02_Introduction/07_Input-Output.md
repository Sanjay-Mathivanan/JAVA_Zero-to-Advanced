# Input and Output in Java

---

## Introduction

In Java, input and output operations allow a program to interact with users.

* Input → Taking data from user
* Output → Displaying data to user

---

## Output in Java

Java provides built-in methods to print output.

### 1. print()

Prints output without a new line.

```java
System.out.print("Hello ");
System.out.print("World");
```

### Output

```text
Hello World
```

---

### 2. println()

Prints output with a new line.

```java
System.out.println("Hello");
System.out.println("World");
```

### Output

```text
Hello
World
```

---

### 3. printf()

Used for formatted output.

```java
System.out.printf("Age: %d", 20);
```

---

## Input in Java (Scanner Class)

To take input, Java uses the Scanner class.

---

## Step 1: Import Scanner

```java
import java.util.Scanner;
```

---

## Step 2: Create Scanner Object

```java
Scanner sc = new Scanner(System.in);
```

---

## Step 3: Take Input

```java
int age = sc.nextInt();
String name = sc.next();
```

---

## Example Program

```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.next();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
```

---

## Output (Sample)

```text
Enter your name: Sanjay
Enter your age: 20
Name: Sanjay
Age: 20
```

---

## Important Scanner Methods

* nextInt() → integer input
* nextDouble() → decimal input
* next() → single word
* nextLine() → full line input

---

## Common Problem (Very Important)

```java
int age = sc.nextInt();
String name = sc.nextLine();
```

Issue:

* nextInt() leaves a newline in buffer
* nextLine() reads empty value

---

## Solution

```java
sc.nextLine(); // clear buffer
String name = sc.nextLine();
```

---

## Input Flow Diagram

```text
User Input → Scanner → Variable → Program Logic → Output
```

---

## Analogy

Think of Scanner as a bridge:

* User → gives input
* Scanner → captures it
* Program → processes it

---

## Common Mistakes

* Forgetting import statement
* Not creating Scanner object
* Mixing nextInt() and nextLine()
* Not closing Scanner

---

## Practice Challenges

### Challenge 1

Take two numbers and print their sum.

---

### Challenge 2

Take name and age, print formatted output.

---

### Challenge 3

Take a full sentence using nextLine().

---

### Challenge 4

Take two numbers and print largest number.

---

## Key Takeaways

* System.out is used for output
* Scanner is used for input
* Different methods handle different data types
* Buffer issues must be handled carefully

---

## Conclusion

Input and Output are essential for making programs interactive.

Mastering Scanner and printing methods is important for solving real-world problems and coding challenges.
