# Regex Syntax and Metacharacters

## Character Classes

Character classes define a set of characters enclosed in square brackets `[]`. A match succeeds if any single character in the input matches a character inside the set:

| Class | Description | Example |
| :--- | :--- | :--- |
| **`[abc]`** | Matches `a`, `b`, or `c`. | `"cat"` matches `c` and `a`. |
| **`[^abc]`** | **Negation**: Matches any character *except* `a`, `b`, or `c`. | `"dog"` matches `d`, `o`, and `g`. |
| **`[a-z]`** | Range: Matches any lowercase letter from `a` to `z`. | `"java"` matches all 4 characters. |
| **`[a-zA-Z]`** | Union: Matches any uppercase or lowercase letter. | `"Java"` matches all 4 characters. |
| **`[0-9]`** | Range: Matches any single digit from `0` to `9`. | `"App2"` matches `2`. |

---

## Predefined Character Classes

Java supports shorthand symbols for common character sets. Remember to double the backslash (`\\`) in Java source code:

| Symbol | Equivalent | Description |
| :--- | :--- | :--- |
| **`.`** | Any character | Matches any single character (except newline by default). |
| **`\d`** | `[0-9]` | Matches any digit. |
| **`\D`** | `[^0-9]` | Matches any non-digit character. |
| **`\w`** | `[a-zA-Z_0-9]` | Matches any word character (letters, digits, underscore). |
| **`\W`** | `[^a-zA-Z_0-9]`| Matches any non-word character (e.g. punctuation, spaces). |
| **`\s`** | `[\t\n\x0B\f\r]`| Matches any whitespace character (space, tab, newline). |
| **`\S`** | `[^\s]` | Matches any non-whitespace character. |

---

## Boundary Matchers

Boundary matchers match locations rather than actual characters:

| Symbol | Description | Example |
| :--- | :--- | :--- |
| **`^`** | Beginning of a line/string. | `"^Java"` matches `"Java"` only at the start of input. |
| **`$`** | End of a line/string. | `"Code$"` matches `"Code"` only at the end of input. |
| **`\b`** | **Word boundary**: Boundary between a word char `\w` and non-word char `\W`. | `"\\bcat\\b"` matches `"the cat sat"` but NOT `"category"`. |
| **`\B`** | Non-word boundary. | `"\\Bcat\\B"` matches `"scatter"` but NOT `"cat"`. |

```java
public class BoundaryDemo {
    public static void main(String[] args) {
        String sentence = "The category is clear";
        
        // \bcat\b looks for 'cat' as a standalone word
        boolean standalone = sentence.matches(".*\\bcat\\b.*");
        System.out.println("Contains standalone 'cat'? " + standalone); // false (because of 'category')
    }
}
```

---

## Quantifiers Overview

Quantifiers specify how many times a character or group must occur:

| Quantifier | Meaning |
| :--- | :--- |
| **`X?`** | `X` occurs **0 or 1** time (optional). |
| **`X*`** | `X` occurs **0 or more** times. |
| **`X+`** | `X` occurs **1 or more** times. |
| **`X{n}`** | `X` occurs **exactly $n$** times. |
| **`X{n,}`** | `X` occurs **at least $n$** times. |
| **`X{n,m}`** | `X` occurs **at least $n$ but no more than $m$** times. |

---

## Key Takeaways

* Character classes `[]` match specific sets or ranges of characters.
* Predefined classes (`\d`, `\w`, `\s`) provide shorthands for common character sets.
* Boundary matchers (`^`, `$`, `\b`) enforce structural locations in input strings.

---

**Back to Module Home:** [Module Index](README.md)
