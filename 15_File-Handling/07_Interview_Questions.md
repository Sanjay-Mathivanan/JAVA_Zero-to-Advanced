# File Handling Interview Questions

## Beginner Questions

### Q1: What is the main difference between Byte Streams and Character Streams?
**Answer:**
* **Byte Streams** (`InputStream`/`OutputStream`) process 8-bit bytes of raw data. They are used for binary files (images, audio, PDFs, `.class` files).
* **Character Streams** (`Reader`/`Writer`) process 16-bit Unicode characters. They automatically handle character encoding conversions (e.g. UTF-8) and are used for plain text files.

### Q2: What happens if you try to serialize an object that does not implement `Serializable`?
**Answer:**
The JVM throws a **`NotSerializableException`** at runtime when `ObjectOutputStream.writeObject()` attempts to serialize an un-marked object.

---

## Intermediate Questions

### Q3: What is the purpose of the `transient` keyword during serialization?
**Answer:**
The `transient` keyword is applied to field members to exclude them from the serialization process. When the object is deserialized, transient fields are assigned default values (`null` for objects, `0` for numbers). It is used to prevent saving sensitive data (like passwords) or non-serializable system handles (like socket or database references).

### Q4: Why is `serialVersionUID` important in Java Serialization?
**Answer:**
`serialVersionUID` is a unique version identifier assigned to a `Serializable` class. During deserialization, the JVM verifies that the `serialVersionUID` of the saved byte stream matches the `serialVersionUID` of the currently loaded class. If they do not match, the JVM throws an `InvalidClassException`. Explicitly defining `serialVersionUID` prevents version conflicts if fields are added or modified later.

---

## Advanced Questions

### Q5: How does `java.nio.file.Path` differ from `java.io.File`?
**Answer:**
1. **Error Handling**: `File` methods return boolean flags (e.g., returning `false` on failure without detailing why). `Path` methods in `Files` throw rich, explicit exceptions (e.g. `NoSuchFileException`, `AccessDeniedException`).
2. **Operations**: `Files` provides atomic file copy/move operations (`StandardCopyOption.ATOMIC_MOVE`) and stream-based directory walking (`Files.walk()`), which are unavailable in legacy `File`.
3. **Immutability**: `Path` instances are immutable and thread-safe.

### Q6: What happens if a parent class does NOT implement `Serializable`, but a child class DOES?
**Answer:**
The child class can still be serialized. However, during deserialization, the JVM invokes the **no-argument constructor of the non-serializable parent class** to initialize the parent's fields. Therefore, the non-serializable parent class **must have an accessible no-arg constructor**, otherwise a `InvalidClassException` will be thrown at runtime.

---

**Back to Module Home:** [Module Index](README.md)
