# Boolean in Java

---

## Introduction

In Java, the `boolean` data type is used to represent logical values.

It can store only two values:

* true
* false

This type is mainly used in decision-making and control flow.

---

## Basic Example

```java
public class Main {
    public static void main(String[] args) {

        boolean isJavaEasy = true;
        boolean isRainy = false;

        System.out.println(isJavaEasy);
        System.out.println(isRainy);
    }
}
```

---

## Output

```text
true
false
```

---

## Where Boolean is Used

Boolean is mainly used in:

* Conditions (if, else)
* Loops (while, for)
* Comparisons
* Logical operations

---

## Example with Condition

```java
public class BooleanExample {
    public static void main(String[] args) {

        int age = 20;
        boolean isAdult = age >= 18;

        System.out.println(isAdult);
    }
}
```

---

### Output

```text
true
```

---

### Explanation

* age >= 18 → condition
* Result is true or false
* Stored in boolean variable

---

## Boolean in If Statement

```java
public class CheckNumber {
    public static void main(String[] args) {

        int number = 10;

        if (number > 0) {
            System.out.println("Positive");
        }
    }
}
```

---

## Logical Operators with Boolean

| Operator | Meaning |   |    |
| -------- | ------- | - | -- |
| &&       | AND     |   |    |
|          |         |   | OR |
| !        | NOT     |   |    |

---

## Example

```java
public class LogicalDemo {
    public static void main(String[] args) {

        int age = 20;
        boolean hasID = true;

        if (age >= 18 && hasID) {
            System.out.println("Allowed");
        }
    }
}
```

---

## Output

```text
Allowed
```

---

## Boolean Flow Diagram

```text
Condition → Evaluation → true/false → Action
```

---

## Important Points

* Boolean does not store numbers (0 or 1)
* Only true or false values allowed
* Used in decision making
* Helps control program flow

---

## Common Mistakes

* Writing True or False (must be lowercase)
* Using 0 or 1 instead of boolean
* Confusing assignment (=) with comparison (==)

---

## Practice Challenges

### Challenge 1

Check if a number is even using boolean.

---

### Challenge 2

Check if a person is eligible to vote.

---

### Challenge 3

Use logical operators to combine conditions.

---

### Challenge 4

Create a program that checks login condition using boolean.

---

## Concept Map

```text
Boolean
   ↓
true / false
   ↓
Conditions
   ↓
Decision Making
```

---

## Key Takeaways

* Boolean stores only true or false
* Used in conditions and control flow
* Logical operators work with boolean
* Essential for decision-making programs

---

## Conclusion

Boolean is one of the most important data types in programming because it controls how decisions are made in a program.

Understanding boolean properly will make control statements much easier.
