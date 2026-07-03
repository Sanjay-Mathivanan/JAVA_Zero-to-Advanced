# Hello World and Main Method in Java

---

## Introduction

Every Java program begins execution from a specific method called the **main method**.
It acts as the entry point that the Java Virtual Machine (JVM) looks for when running a program.

---

## Basic Program

```java
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
```

---

## Understanding Each Part

### class

Defines the structure of the program.
Java programs must be inside a class.

### public

Makes the method accessible from anywhere.
JVM must access it, so it must be public.

### static

Allows the method to run without creating an object.
JVM can directly call it.

### void

Indicates that the method does not return any value.

### main

Special method name recognized by JVM as the starting point.

### String[] args

Used to receive input from the command line.

---

## Execution Flow

```text
Write Code (.java)
      ↓
Compile (javac)
      ↓
Bytecode (.class)
      ↓
JVM Loads Class
      ↓
Find main()
      ↓
Execute Program
```

---

## Why main() is static

If main() was not static:

* JVM would need to create an object first
* But JVM does not know how to create objects initially

So it is made static to allow direct execution.

---

## Why main() returns void

In some languages like C/C++:

* main() returns an integer (exit status)

But in Java:

* Program runs inside JVM
* Not directly controlled by OS

So no need to return a value.

---

## Exit Status in Java

If needed, Java provides:

```java
System.exit(0); // successful termination
System.exit(1); // error
```

---

## Concept Map

```text
Java Program
   ↓
Class
   ↓
main()
   ↓
JVM Execution
   ↓
Output
```

---

## Common Mistakes

* Missing static keyword
* Wrong method signature
* Class name not matching file name
* Using int instead of void

---

## Key Takeaways

* main() is the entry point of Java
* JVM directly executes main()
* static avoids object creation
* Java does not require return value from main()

---

## Conclusion

Understanding the structure of a basic Java program is the first step toward mastering the language.
Focus on why each keyword exists instead of memorizing it.
