# Character Streams in Java

## `FileReader` and `FileWriter`

Character Streams process data **16 bits (2 bytes) at a time** using Java's internal Unicode character encoding. They are designed specifically for plain text files (e.g. `.txt`, `.csv`, `.json`).

The core character stream classes are:
* **`FileReader`**: Reads characters from a text file.
* **`FileWriter`**: Writes characters to a text file.

---

## Character Encoding Considerations

Different Operating Systems historically defaulted to different character encodings (e.g. Windows-1252 vs. UTF-8). 

Starting in Java 11, you can explicitly specify the character encoding (such as **`StandardCharsets.UTF_8`**) in the `FileReader` and `FileWriter` constructors to prevent cross-platform encoding bugs:

```java
import java.nio.charset.StandardCharsets;
import java.io.FileReader;
import java.io.FileWriter;

// Explicitly specifying UTF-8 encoding
FileReader reader = new FileReader("data.txt", StandardCharsets.UTF_8);
FileWriter writer = new FileWriter("output.txt", StandardCharsets.UTF_8);
```

---

## Complete Code Example

```java
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TextFileReadWriteDemo {
    public static void main(String[] args) {
        String filePath = "sample.txt";

        // 1. Writing text to a file
        try (FileWriter writer = new FileWriter(filePath, StandardCharsets.UTF_8)) {
            writer.write("Java Zero to Advanced\n");
            writer.write("Character Streams in Java!\n");
            System.out.println("Text written successfully.");
        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        // 2. Reading text from a file
        try (FileReader reader = new FileReader(filePath, StandardCharsets.UTF_8)) {
            char[] buffer = new char[1024]; // 1K char buffer
            int charsRead;
            
            System.out.println("\n--- Reading File Contents ---");
            while ((charsRead = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, charsRead));
            }
        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}
```

---

## Key Takeaways

* Use `FileReader` and `FileWriter` for text data.
* Specify `StandardCharsets.UTF_8` explicitly to ensure cross-platform consistency.
* Use character array buffers (`char[]`) to read chunks of text efficiently.

---

**Back to Module Home:** [Module Index](README.md)
