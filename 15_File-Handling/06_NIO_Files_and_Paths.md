# Java NIO.2: Files and Paths

## Why Modern Java Prefers NIO.2

Java 7 introduced **NIO.2** (New I/O) in the **`java.nio.file`** package to replace the legacy `java.io.File` API.

| Feature | Legacy `java.io.File` | Modern `java.nio.file` (NIO.2) |
| :--- | :--- | :--- |
| **Path Representation**| `java.io.File` | `java.nio.file.Path` |
| **Error Handling** | Boolean returns (`false` on failure, no details). | Detailed I/O exceptions (`NoSuchFileException`, `AccessDeniedException`). |
| **Performance** | Synchronous, blocking. | High-performance, supports atomic file operations. |
| **Simplicity** | Requires manually managing stream loops. | Single-line helper methods in `java.nio.file.Files`. |

---

## 1. `Path` and `Paths`

A **`Path`** represents a hierarchical location of a file or directory on a file system:

```java
import java.nio.file.Path;
import java.nio.file.Paths;

// Creating Path references
Path path1 = Paths.get("logs", "app.log");
Path path2 = Path.of("workspace", "config.json"); // Java 11+ syntax
```

---

## 2. High-Performance Utility Methods (`Files`)

The **`java.nio.file.Files`** class contains static utility methods that perform operations on files and directories:

### Reading and Writing Text Files
```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class NioReadWriteDemo {
    public static void main(String[] args) throws Exception {
        Path path = Path.of("nio_test.txt");

        // 1. Write string directly to file (Java 11+)
        Files.writeString(path, "Java NIO.2 file operations!");

        // 2. Read entire file as String (Java 11+)
        String content = Files.readString(path);
        System.out.println("File Content: " + content);

        // 3. Read lines into a List
        List<String> lines = Files.readAllLines(path);
        System.out.println("Line count: " + lines.size());
    }
}
```

---

## Copying, Moving, and Deleting Files

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class NioFileOpsDemo {
    public static void main(String[] args) throws Exception {
        Path source = Path.of("source.txt");
        Path dest   = Path.of("backup/source_copy.txt");

        // Ensure target directory exists
        Files.createDirectories(dest.getParent());

        // Copy file with overwrite option
        Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Copied successfully.");

        // Move file
        Path movedDest = Path.of("backup/renamed.txt");
        Files.move(dest, movedDest, StandardCopyOption.REPLACE_EXISTING);

        // Delete file if it exists
        Files.deleteIfExists(movedDest);
    }
}
```

---

## Walking Directory Trees (`Files.walk()`)

NIO.2 provides stream-based recursive directory traversal using `Files.walk()`:

```java
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class DirectoryWalkDemo {
    public static void main(String[] args) throws Exception {
        Path rootDir = Path.of(".");

        // Recursively find all .java files in the project workspace
        try (Stream<Path> stream = Files.walk(rootDir)) {
            stream.filter(Files::isRegularFile)
                  .filter(p -> p.toString().endsWith(".java"))
                  .forEach(System.out::println);
        }
    }
}
```

---

## Key Takeaways

* Use `Path` and `Files` (`java.nio.file`) instead of legacy `java.io.File` for modern Java applications.
* Use `Files.writeString()` and `Files.readString()` for concise text I/O.
* Use `Files.walk()` to traverse directory trees using Java Streams.

---

**Back to Module Home:** [Module Index](README.md)
