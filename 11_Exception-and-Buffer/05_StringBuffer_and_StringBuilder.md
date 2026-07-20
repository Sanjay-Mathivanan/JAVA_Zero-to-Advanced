# StringBuffer and StringBuilder in Java

## The Need for Mutability

In Java, **`String`** objects are **immutable**. Every time you modify a string (e.g. using concatenation), Java creates a completely new string object on the heap:

```java
String s = "Hello";
s += " World"; // Creates a new String object; "Hello" is orphaned.
```

If you concatenate strings inside a loop, this creates many short-lived string objects on the heap, polluting memory and triggering garbage collection.

To solve this, Java provides **`StringBuffer`** and **`StringBuilder`**, which are **mutable** sequences of characters. They modify their internal buffers in-place without creating new objects.

---

## StringBuffer vs. StringBuilder

| Feature | `StringBuffer` | `StringBuilder` |
| :--- | :--- | :--- |
| **Introduced** | JDK 1.0 | JDK 1.5 |
| **Thread Safety** | **Thread-Safe**: All public methods are synchronized. | **Not Thread-Safe**: Methods are not synchronized. |
| **Performance** | Slower (due to synchronization lock overhead). | Faster (no lock acquisition overhead). |
| **Use Case** | Multi-threaded environments (shared mutable state). | Single-threaded environments (default choice). |

---

## Internal Workings and Capacity Growth

Both classes wrap a mutable character array buffer:

```java
char[] value;
int count;
```

### 1. Initial Capacity
* Default constructor instantiates the array with a capacity of **16**.
* If you pass a String to the constructor, the capacity is initialized to `16 + string.length()`.

### 2. Growth Math
When the character array becomes full, the buffer expands dynamically using this formula:

$$\text{New Capacity} = (\text{Old Capacity} \times 2) + 2$$

```java
// Conceptual capacity resizing steps
int newCapacity = (value.length << 1) + 2;
value = Arrays.copyOf(value, newCapacity);
```

---

## Complete Examples

### Example: Basic Modification Methods
```java
public class StringBuildersDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Java");

        // 1. Append
        sb.append(" Programming");
        System.out.println(sb); // "Java Programming"

        // 2. Insert
        sb.insert(4, " Standard");
        System.out.println(sb); // "Java Standard Programming"

        // 3. Delete
        sb.delete(4, 13);
        System.out.println(sb); // "Java Programming"

        // 4. Reverse
        sb.reverse();
        System.out.println(sb); // "gnimmargorP avaJ"
    }
}
```

---

## Best Practices

* **Prefer StringBuilder by default**: In modern single-threaded contexts (such as local variables in methods), always use `StringBuilder` rather than `StringBuffer` to avoid synchronization overhead.
* **Pre-size the Builder**: If you know you will build a large string, specify the initial capacity in the constructor to avoid repeated array resizing and memory copy operations:
  ```java
  StringBuilder sb = new StringBuilder(1024); // Start with 1024 character slots
  ```

---

## Common Mistakes

* **Creating Builders in Concatenation Statements**: Avoid writing:
  ```java
  String name = new StringBuilder().append(first).append(last).toString();
  ```
  Simple string concatenations (e.g. `first + last`) are automatically optimized by the compiler to use `StringBuilder` under the hood. Only instantiate `StringBuilder` explicitly for loops or complex string construction.

---

## Key Takeaways

* `String` is immutable; `StringBuffer` and `StringBuilder` are mutable character buffers.
* `StringBuffer` is synchronized and thread-safe. `StringBuilder` is unsynchronized and faster.
* Resizing capacity follows the math rule: `(Old Capacity * 2) + 2`.

---

**Back to Module Home:** [Module Index](README.md)
