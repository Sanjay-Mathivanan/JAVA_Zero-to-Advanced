# BufferedReader and BufferedWriter in Java

## The Bottleneck of Unbuffered I/O

When reading a file or network stream using classes like `FileReader`, every call to `read()` makes a direct request to the underlying operating system (a **System Call**) to retrieve a single character:

```text
Unbuffered I/O:
[ Java Program ] ───(System Call for 1 Char)───> [ OS / Disk Controller ]
```

System calls are slow and resource-intensive. If a file contains 1 million characters, doing 1 million system calls degrades application performance.

**`BufferedReader`** and **`BufferedWriter`** solve this bottleneck by adding an in-memory character buffer (default size: **8192 characters / 8KB**). 
* **BufferedReader**: Reads a large block of characters from the disk in a single system call and stores them in memory. Subsequent read operations pull characters directly from the memory buffer.
* **BufferedWriter**: Writes characters to an in-memory buffer. When the buffer is full (or flushed), it writes the entire block to the disk in a single system call.

```text
Buffered I/O:
[ Java Program ] ───(Read Char from Memory)───> [ 8KB Buffer ] ───(Single System Call)───> [ Disk ]
```

---

## BufferedReader vs. Scanner

While both can read inputs, they have key differences:

| Feature | `BufferedReader` | `Scanner` |
| :--- | :--- | :--- |
| **Buffering** | Large buffer size (**8KB**). | Small buffer size (**1KB**). |
| **Parsing** | Reads text as raw strings or characters only. | Parses inputs into tokens using regular expressions. |
| **Thread Safety** | Thread-safe (internal synchronization locks). | Not thread-safe. |
| **Performance** | **Very Fast** (direct buffer accesses). | **Slower** (due to regex parsing overhead). |

---

## Common Methods

### BufferedReader Methods:
* **`readLine()`**: Reads a line of text. Returns `null` if the end of the stream has been reached.
* **`read()`**: Reads a single character (returns `-1` if the end is reached).

### BufferedWriter Methods:
* **`write(String s)`**: Writes a string to the buffer.
* **`newLine()`**: Writes a line separator character (automatically adapts to the OS platform: `\n` on Unix, `\r\n` on Windows).
* **`flush()`**: Flushes the buffer, forcing any buffered characters to be written immediately to the output stream.

---

## Complete Examples

### Example: Reading and Writing a File Line-by-Line
```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedCopyDemo {
    public static void main(String[] args) {
        // Declaring streams using try-with-resources
        try (
            BufferedReader reader = new BufferedReader(new FileReader("source.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("destination.txt"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine(); // Add OS-specific line break
            }
            System.out.println("File copied successfully using buffers!");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }
}
```

---

## Best Practices

* **Always Flush or Close**: Close your streams using try-with-resources. If a `BufferedWriter` is not closed or flushed, the final characters stored in the buffer may never be written to the file.
* **Use for Large Inputs**: Use `BufferedReader` rather than `Scanner` when reading large files or high-throughput network streams.

---

## Key Takeaways

* Buffering prevents performance bottlenecks caused by excessive Operating System calls.
* `BufferedReader` uses an 8KB memory buffer to read chunks of characters.
* `BufferedReader` is faster than `Scanner` because it reads raw text without regex parsing overhead.
* Always flush or close `BufferedWriter` to commit the remaining characters in the buffer.

---

**Back to Module Home:** [Module Index](README.md)
