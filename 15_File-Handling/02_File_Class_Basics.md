# File Class Basics in Java

## The `java.io.File` Class

The **`java.io.File`** class is an abstract representation of file and directory pathnames. 

> **Important**: A `File` object represents the **pathname** of a file or directory, not its actual content. Creating a `File` instance in Java does **not** create a physical file on your hard drive.

```java
// Represents a path reference; does NOT create a file on disk yet!
File file = new File("config/app.txt");
```

---

## Key File Operations

| Method | Return Type | Description |
| :--- | :--- | :--- |
| **`createNewFile()`** | `boolean` | Atomically creates a new, empty physical file if it does not exist. |
| **`mkdir()`** | `boolean` | Creates the directory named by this pathname. |
| **`mkdirs()`** | `boolean` | Creates the directory and any necessary non-existent parent directories. |
| **`exists()`** | `boolean` | Tests whether the file or directory exists. |
| **`isFile()`** | `boolean` | Tests whether the target is a normal file. |
| **`isDirectory()`** | `boolean` | Tests whether the target is a directory. |
| **`delete()`** | `boolean` | Deletes the physical file or empty directory. |
| **`length()`** | `long` | Returns the file size in bytes (0 for directories). |
| **`getAbsolutePath()`**| `String` | Returns the absolute path string. |

---

## Complete Code Examples

### Example 1: Creating Files and Directories
```java
import java.io.File;
import java.io.IOException;

public class FileCreationDemo {
    public static void main(String[] args) {
        try {
            // 1. Create directory structure
            File dir = new File("workspace/logs");
            if (dir.mkdirs()) {
                System.out.println("Directory created: " + dir.getAbsolutePath());
            }

            // 2. Create physical file inside directory
            File logFile = new File(dir, "system.log");
            if (logFile.createNewFile()) {
                System.out.println("File created successfully: " + logFile.getName());
            } else {
                System.out.println("File already exists.");
            }

            // 3. Inspect metadata
            System.out.println("Is File? " + logFile.isFile());
            System.out.println("File Size: " + logFile.length() + " bytes");

        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
```

### Example 2: Listing Directory Contents
```java
import java.io.File;

public class DirectoryListDemo {
    public static void main(String[] args) {
        File currentDir = new File(".");
        
        // List all files and subdirectories in current directory
        String[] contents = currentDir.list();
        if (contents != null) {
            for (String item : contents) {
                System.out.println("Item: " + item);
            }
        }
    }
}
```

---

## Key Takeaways

* `java.io.File` represents file and directory paths, not file contents.
* Use `createNewFile()` to instantiate empty physical files.
* Use `mkdirs()` instead of `mkdir()` to create nested directory trees safely.

---

**Back to Module Home:** [Module Index](README.md)
