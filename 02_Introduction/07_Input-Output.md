# Input and Output in Java

This guide details the mechanisms of handling user input and console output in Java, covering stream layouts, the Scanner class, formatting, and buffer clearing strategies.

---

## Introduction

Java handles input and output (I/O) using streams. The standard system streams are encapsulated in the `System` class:
* `System.in`: The standard input stream (typically mapped to the keyboard).
* `System.out`: The standard output stream (typically mapped to the console).
* `System.err`: The standard error output stream (used to output error logs).

---

## Console Output Mechanisms

Java provides three primary print methods inside the `PrintStream` class (`System.out`):

### 1. print()
Outputs text to the console without appending a newline character. Subsequent prints continue on the same line.
```java
System.out.print("Hello ");
System.out.print("World");
```
* **Output**: `Hello World`

### 2. println()
Outputs text to the console and appends a newline character (`\n`) at the end. Subsequent prints begin on the next line.
```java
System.out.println("Hello");
System.out.println("World");
```
* **Output**:
  ```text
  Hello
  World
  ```

### 3. printf()
Used for formatted output, matching the C-language style specifiers.
```java
String item = "Apple";
int qty = 5;
double price = 1.25;

System.out.printf("Item: %s, Qty: %d, Total: $%.2f%n", item, qty, (qty * price));
```
* **Output**: `Item: Apple, Qty: 5, Total: $6.25`

#### Common Format Specifiers
* `%s`: String
* `%d`: Decimal Integer (byte, short, int, long)
* `%f`: Floating-point number (float, double)
* `%c`: Character
* `%b`: Boolean
* `%n` or `\n`: Platform-independent newline

---

## Interactive Console Input using Scanner

The `java.util.Scanner` class is the standard class used to parse text input from the console stream (`System.in`).

### Step 1: Import the Class
```java
import java.util.Scanner;
```

### Step 2: Instantiate the Scanner Object
```java
Scanner scanner = new Scanner(System.in);
```

### Step 3: Read Specific Data Types
```java
System.out.print("Enter an integer: ");
int num = scanner.nextInt();

System.out.print("Enter a decimal: ");
double decimal = scanner.nextDouble();

System.out.print("Enter a single word: ");
String word = scanner.next();

scanner.nextLine(); // Clear the buffer newline

System.out.print("Enter a full sentence: ");
String sentence = scanner.nextLine();
```

---

## Technical Gotcha: The Scanner Buffer Issue

A frequent source of bugs for beginners is mixing numeric readers (`nextInt()`, `nextDouble()`, `next()`) with line readers (`nextLine()`).

### The Problem
* Numeric readers like `nextInt()` consume only the numeric characters and stop reading once they hit a delimiter (like a space or the newline `\n` generated when the user presses Enter).
* This leaves the trailing newline character (`\n`) hanging in the input stream buffer.
* When you call `nextLine()` immediately after, it reads that remaining `\n` as an empty line and returns immediately, skipping user input.

```java
// Bug Scenario
System.out.print("Enter age: ");
int age = scanner.nextInt(); // User types '20' and hits Enter. Buffer has '20\n'. '20' is consumed. '\n' remains.

System.out.print("Enter name: ");
String name = scanner.nextLine(); // Immediately reads the remaining '\n' as an empty string. Skips input!
```

### The Solution
Consume the leftover newline character by calling `scanner.nextLine()` once after any numeric reader, before calling the actual text-reading `nextLine()`.

```java
System.out.print("Enter age: ");
int age = scanner.nextInt(); 

scanner.nextLine(); // Consumes the '\n' from the buffer

System.out.print("Enter name: ");
String name = scanner.nextLine(); // Correctly prompts the user for text input
```

---

## Complete Example Program

This program requests personal details and prints them back in a formatted summary:

```java
import java.util.Scanner;

public class ConsoleIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your full name: ");
        String name = input.nextLine();

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        System.out.print("Enter your annual salary: ");
        double salary = input.nextDouble();

        System.out.println("\n--- Profile Summary ---");
        System.out.printf("Name:   %s%n", name);
        System.out.printf("Age:    %d years%n", age);
        System.out.printf("Salary: $%,.2f per year%n", salary);

        // Close the scanner resource to prevent memory leaks
        input.close();
    }
}
```

---

## Best Practices

* **Always close the Scanner**: When you are finished reading input, call `scanner.close()` to release the system resource. Note: Closing a Scanner wrapping `System.in` will also close `System.in`, so do this at the very end of your program lifecycle.
* **Handle input exceptions**: If the user inputs text when `nextInt()` is expected, a runtime `InputMismatchException` will occur. Real-world code should wrap input logic in validation loops.

---

**Back to Module Home:** [Introduction to Java Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/02_Introduction/README.md)
