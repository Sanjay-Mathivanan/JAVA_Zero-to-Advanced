# Regular Expressions Interview Questions

## Beginner Questions

### Q1: Are Pattern and Matcher classes thread-safe in Java?
**Answer:**
* **`Pattern` is thread-safe**: `Pattern` instances are immutable. Once compiled, a `Pattern` object can be shared safely across multiple concurrent threads.
* **`Matcher` is NOT thread-safe**: A `Matcher` holds mutable state (such as match positions and capturing group offsets). Each thread must create its own `Matcher` instance.

### Q2: What is the difference between `matches()` and `find()` in Matcher?
**Answer:**
* `matches()` checks if the **entire input sequence** matches the pattern.
* `find()` scans the input sequence to find the **next sub-sequence** that matches the pattern.

---

## Intermediate Questions

### Q3: What is Catastrophic Backtracking and how can you avoid it?
**Answer:**
Catastrophic Backtracking occurs when a regex pattern contains nested quantifiers (e.g. `(a+)+$`) evaluated against an input that fails to match near the end. The regex engine tries millions of combinations via backtracking, freezing the thread and causing high CPU usage.

**Solutions**:
1. Avoid nested quantifiers on overlapping character sets.
2. Use **Possessive Quantifiers** (e.g. `(a++)+$`), which disable the backtracking engine completely.

### Q4: How do you write a regex pattern to validate a standard IPv4 address?
**Answer:**
An IPv4 address consists of 4 numbers (0-255) separated by dots.
```java
public class IPv4Validator {
    private static final String OCTET = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
    private static final Pattern IPV4_PATTERN = Pattern.compile("^" + OCTET + "(\\." + OCTET + "){3}$");

    public static boolean isValid(String ip) {
        return ip != null && IPV4_PATTERN.matcher(ip).matches();
    }
}
```

---

## Advanced Questions

### Q5: Explain Lookahead and Lookbehind assertions in Java Regex.
**Answer:**
Lookaround assertions match a position without consuming characters (zero-width assertions):

| Assertion | Syntax | Description |
| :--- | :--- | :--- |
| **Positive Lookahead** | `(?=X)` | Matches if `X` follows the current position. |
| **Negative Lookahead** | `(?!X)` | Matches if `X` does NOT follow the current position. |
| **Positive Lookbehind**| `(?<=X)`| Matches if `X` precedes the current position. |
| **Negative Lookbehind**| `(?<!X)`| Matches if `X` does NOT precede the current position. |

**Example (Password Validation)**: Require at least one digit and one uppercase letter:
```java
// Requires 1 digit (?=.*\\d) and 1 uppercase letter (?=.*[A-Z])
Pattern passwordPattern = Pattern.compile("^(?=.*\\d)(?=.*[A-Z]).{8,}$");
```

---

**Back to Module Home:** [Module Index](README.md)
