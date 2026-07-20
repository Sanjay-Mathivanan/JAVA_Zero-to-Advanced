# Regex Utility Methods in String Class

The Java `String` class provides convenient shorthand methods for performing common regex operations. Under the hood, these methods delegate execution to the `Pattern` and `Matcher` classes.

---

## 1. `matches(String regex)`

Checks if the entire string matches the given regular expression pattern.

```java
public class StringMatchesDemo {
    public static void main(String[] args) {
        String email = "support@company.com";
        
        // Verifies if the full string conforms to the pattern
        boolean isValid = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,6}$");
        System.out.println("Is email valid? " + isValid); // true
    }
}
```

---

## 2. `split(String regex)`

Splits the string into an array of substrings around matches of the regular expression pattern.

```java
public class StringSplitDemo {
    public static void main(String[] args) {
        String data = "apple, banana; cherry | orange";
        
        // Split using a regex matching commas, semicolons, or pipes with optional spaces
        String[] fruits = data.split("[,;|]\\s*");
        
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
```

---

## 3. `replaceAll()` and `replaceFirst()`

* **`replaceAll(regex, replacement)`**: Replaces every substring matching the pattern with the specified replacement string.
* **`replaceFirst(regex, replacement)`**: Replaces only the first matched substring.

```java
public class StringReplaceDemo {
    public static void main(String[] args) {
        String invoiceText = "Paid amount: $120.00. Fee: $5.00.";

        // 1. replaceFirst: Replace only the first occurrence
        String firstChange = invoiceText.replaceFirst("\\$\\d+(\\.\\d{2})?", "[PRICE]");
        System.out.println("replaceFirst: " + firstChange);
        // Output: "Paid amount: [PRICE]. Fee: $5.00."

        // 2. replaceAll: Replace all occurrences
        String allChanges = invoiceText.replaceAll("\\$\\d+(\\.\\d{2})?", "[PRICE]");
        System.out.println("replaceAll:   " + allChanges);
        // Output: "Paid amount: [PRICE]. Fee: [PRICE]."
    }
}
```

---

## Performance Overhead Warning

While convenient, using `String.matches()`, `String.split()`, or `String.replaceAll()` inside loops can cause performance issues.

```java
// Performance Anti-Pattern:
for (String line : lines) {
    if (line.matches("\\d{3}-\\d{2}-\\d{4}")) { // Re-compiles pattern on every iteration!
        // process
    }
}
```

Every time you call a regex method on a `String`, Java **re-compiles** the regular expression pattern from scratch. For high-frequency or loop-based operations, compile the pattern once and reuse it:

```java
// High-Performance Pattern:
Pattern pattern = Pattern.compile("\\d{3}-\\d{2}-\\d{4}");
for (String line : lines) {
    if (pattern.matcher(line).matches()) { // Reuses the compiled pattern
        // process
    }
}
```

---

## Key Takeaways

* Shorthand methods (`matches`, `split`, `replaceAll`) are built directly into `String`.
* These methods re-compile patterns on every invocation.
* For loops and high-frequency calls, pre-compile patterns using `Pattern.compile()` to avoid performance overhead.

---

**Back to Module Home:** [Module Index](README.md)
