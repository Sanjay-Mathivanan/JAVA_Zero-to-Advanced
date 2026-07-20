# Quantifiers: Greedy, Lazy, and Possessive

Quantifiers control how many times a character or group can be repeated. In Java, quantifiers operate in three distinct evaluation modes: **Greedy**, **Reluctant (Lazy)**, and **Possessive**.

---

## Evaluation Modes Comparison

| Mode | Syntax Example | Behavior | Backtracking? |
| :--- | :--- | :--- | :--- |
| **Greedy (Default)** | `.*`, `.+`, `.?` | Consumes as much input as possible first, then **backtracks** backward one character at a time. | **Yes** |
| **Reluctant (Lazy)** | `.*?`, `.+?`, `.??` | Consumes as little input as possible first, then expands forward one character at a time. | **Yes** |
| **Possessive** | `.*+`, `.++`, `.?+` | Consumes as much input as possible first and **NEVER backtracks**. | **No** |

---

## 1. Greedy Quantifiers (Default)

Greedy quantifiers read the entire input string at once. If the initial match attempt fails, the engine steps backward (backtracks) one character at a time, trying to find a match.

### HTML Tag Example:
Given the input: `<div>Header</div><div>Footer</div>`
* Pattern: `<div>.*</div>`
* **Greedy Match Result**: `<div>Header</div><div>Footer</div>`
* **Why**: The `.*` greedily consumes everything up to the very last `</div>` in the string.

---

## 2. Reluctant / Lazy Quantifiers (`?`)

Adding a `?` after a quantifier makes it **Reluctant**. It starts by matching as few characters as possible, expanding forward only when necessary to satisfy the rest of the pattern.

### HTML Tag Example:
Given the input: `<div>Header</div><div>Footer</div>`
* Pattern: `<div>.*?</div>`
* **Reluctant Match Result**: Matches `<div>Header</div>` first, and `<div>Footer</div>` second.
* **Why**: The `.*?` stops as soon as it encounters the first closing `</div>`.

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuantifierComparisonDemo {
    public static void main(String[] args) {
        String html = "<div>Header</div><div>Footer</div>";

        System.out.println("--- GREEDY (.*) ---");
        Matcher greedy = Pattern.compile("<div>.*</div>").matcher(html);
        while (greedy.find()) {
            System.out.println("Match: " + greedy.group());
        }

        System.out.println("\n--- RELUCTANT (.*?) ---");
        Matcher reluctant = Pattern.compile("<div>.*?</div>").matcher(html);
        while (reluctant.find()) {
            System.out.println("Match: " + reluctant.group());
        }
    }
}
```

**Output:**
```text
--- GREEDY (.*) ---
Match: <div>Header</div><div>Footer</div>

--- RELUCTANT (.*?) ---
Match: <div>Header</div>
Match: <div>Footer</div>
```

---

## 3. Possessive Quantifiers (`+`)

Adding a `+` after a quantifier makes it **Possessive**. Like greedy quantifiers, it consumes as much input as possible. However, **it never backtracks**.

If a possessive match fails to complete the pattern, it fails immediately without stepping backward.

### Preventing Catastrophic Backtracking
When matching complex nested patterns, greedy and lazy quantifiers can cause **Catastrophic Backtracking**, where the regex engine attempts millions of combinations, causing high CPU usage or freezing application threads.

Possessive quantifiers prevent catastrophic backtracking because they disable the backtracking engine completely:

```java
// Possessive quantifier disables backtracking
Pattern possessivePattern = Pattern.compile("\"[^\"]*+\"");
```

---

## Key Takeaways

* **Greedy** (default) matches maximum input and backtracks backward.
* **Reluctant** (`?`) matches minimum input and expands forward.
* **Possessive** (`+`) matches maximum input without backtracking, preventing performance issues.

---

**Back to Module Home:** [Module Index](README.md)
