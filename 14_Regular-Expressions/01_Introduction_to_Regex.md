# Introduction to Regular Expressions in Java

## What is a Regular Expression?

A **Regular Expression** (commonly abbreviated as **Regex**) is a domain-specific sequence of characters that defines a search pattern. 

In Java, regex patterns are used for three main software engineering tasks:
1. **Validation**: Checking if an input string conforms to a expected format (e.g. validating email addresses, passwords, phone numbers).
2. **Search and Extraction**: Locating specific sub-strings or text groups within large documents.
3. **Transformation**: Replacing or reformatting text patterns (e.g. masking sensitive credit card numbers).

---

## Basic Matching Concepts

Regex patterns can range from simple literal character matches to complex wildcard sequences:

* **Literal Matching**: A pattern like `"Java"` matches the exact literal sequence of characters `J-a-v-a`.
* **Pattern Matching**: A pattern like `"Java \\d+"` matches `"Java"` followed by a space and one or more numerical digits (e.g. `"Java 8"`, `"Java 21"`).

```java
public class RegexBasicsDemo {
    public static void main(String[] args) {
        String input = "Java 21";
        
        // Checks if the entire input matches the pattern
        boolean isMatch = input.matches("Java \\d+");
        System.out.println("Does input match? " + isMatch); // true
    }
}
```

---

## Critical Java Syntax Rule: Double Backslashes (`\\`)

In standard regex syntax, a backslash `\` is used to escape special metacharacters (e.g. `\d` means a digit, `\w` means a word character).

However, in Java source code, the backslash `\` is **also** an escape character for Java String literals (e.g. `\n` for newline, `\t` for tab).

Therefore, to represent a single backslash in a Java Regex string, you **must write a double backslash (`\\`)**:

| Target Regex | Standard Regex Notation | Java String Literal Requirement |
| :--- | :--- | :--- |
| Any Digit | `\d` | `"\\d"` |
| Word Character | `\w` | `"\\w"` |
| Literal Backslash | `\` | `"\\\\"` |

---

## Key Takeaways

* A Regular Expression defines a search pattern for text validation, extraction, and editing.
* In Java String literals, regex escape sequences require double backslashes (`\\`).

---

**Back to Module Home:** [Module Index](README.md)
