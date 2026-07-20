# Try-with-Resources in Java

## Introduction

Before Java 7, closing resources (such as files, databases, or sockets) required writing verbose cleanup logic in a `finally` block. This approach was error-prone and often resulted in resources leaking if an exception occurred during the closing process:

```java
// Legacy Java 6 approach: Verbose and leak-prone
BufferedReader reader = null;
try {
    reader = new BufferedReader(new FileReader("file.txt"));
    System.out.println(reader.readLine());
} catch (IOException e) {
    e.printStackTrace();
} finally {
    try {
        if (reader != null) {
            reader.close(); // Can throw IOException, shadowing original exceptions!
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

Java 7 introduced **Try-with-Resources**, which automatically closes any resources declared inside the `try` block parameters when the block exits.

---

## The `AutoCloseable` Interface

For a class to be used as a resource in a try-with-resources statement, it must implement either **`java.lang.AutoCloseable`** or its sub-interface **`java.io.Closeable`**:

```java
// Conceptual interface definition:
public interface AutoCloseable {
    void close() throws Exception;
}
```

---

## Using Try-with-Resources

Resources are declared and instantiated inside parenthesis directly after the `try` keyword:

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResourcesDemo {
    public static void main(String[] args) {
        // Resource is automatically closed when try block exits
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(reader.readLine());
        } catch (IOException e) {
            System.out.println("Exception handled: " + e.getMessage());
        }
    }
}
```

---

## Managing Multiple Resources

You can declare multiple resources inside the try-with-resources statement by separating them with a semicolon. **Resources are closed in the reverse order of their declaration.**

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) {
        try (
            FileInputStream in = new FileInputStream("input.txt");
            FileOutputStream out = new FileOutputStream("output.txt")
        ) {
            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        } catch (IOException e) {
            System.out.println("I/O Exception: " + e.getMessage());
        }
    }
}
```

---

## Suppressed Exceptions

In the legacy Java 6 approach, if an exception occurred in the `try` block, and another exception occurred in the `finally` block while closing the resource, the second exception shadowed (hid) the original exception.

In try-with-resources, the original exception is preserved, and any exception thrown during the automatic closing process is added as a **suppressed exception**. You can retrieve them using the `getSuppressed()` method:

```java
try (CustomResource r = new CustomResource()) {
    r.doWork(); // Throws Exception A
} catch (Exception e) {
    System.out.println("Caught: " + e.getMessage()); // Exception A
    for (Throwable t : e.getSuppressed()) {
        System.out.println("Suppressed: " + t.getMessage()); // Exception B (from close())
    }
}
```

---

## Key Takeaways

* Try-with-resources handles resource cleanup automatically, reducing boilerplate code.
* Any resource declared inside `try()` must implement `AutoCloseable` or `Closeable`.
* Multiple resources are closed in the reverse order of their declaration.
* Exceptions thrown during automatic closing are added as suppressed exceptions rather than shadowing the original exception.

---

**Back to Module Home:** [Module Index](README.md)
