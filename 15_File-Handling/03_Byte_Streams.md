# Byte Streams in Java

## `FileInputStream` and `FileOutputStream`

Byte Streams read and write data **8 bits (1 byte) at a time**. They are used for binary files such as images, audio clips, videos, and executable files.

The core byte stream classes are:
* **`FileInputStream`**: Reads raw bytes from a file.
* **`FileOutputStream`**: Writes raw bytes to a file.

---

## Single Byte vs. Array Buffer Operations

Reading a file byte-by-byte using `read()` performs poorly for large files. Instead, use a **byte array buffer** (`byte[]`) to read chunks of bytes simultaneously:

```java
// Low Performance: Single byte reads
int data = fis.read();

// High Performance: Buffer array reads (e.g. 4KB chunks)
byte[] buffer = new byte[4096];
int bytesRead = fis.read(buffer);
```

---

## Complete Example: Binary File Copy

```java
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileCopyDemo {
    public static void main(String[] args) {
        String sourcePath = "image.png";
        String destPath   = "image_copy.png";

        // Declare streams inside try-with-resources for automatic closure
        try (
            FileInputStream fis = new FileInputStream(sourcePath);
            FileOutputStream fos = new FileOutputStream(destPath)
        ) {
            byte[] buffer = new byte[4096]; // 4KB buffer
            int bytesRead;

            // fis.read(buffer) returns the number of bytes read, or -1 at EOF
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead); // Write only actual bytes read
            }

            System.out.println("Binary file copied successfully!");
        } catch (IOException e) {
            System.out.println("I/O Error during copying: " + e.getMessage());
        }
    }
}
```

---

## Appending Data to Files

By default, instantiating `FileOutputStream("file.txt")` **overwrites** existing file content. To **append** data to an existing file, set the second parameter to `true`:

```java
// Append mode enabled: new data will be added to the end of the file
FileOutputStream fos = new FileOutputStream("log.bin", true);
```

---

## Key Takeaways

* Use `FileInputStream` and `FileOutputStream` for binary data (images, media, bytecode).
* Use byte array buffers (`byte[]`) to read chunks of bytes efficiently.
* Pass `true` as the second constructor argument to `FileOutputStream` to enable append mode.

---

**Back to Module Home:** [Module Index](README.md)
