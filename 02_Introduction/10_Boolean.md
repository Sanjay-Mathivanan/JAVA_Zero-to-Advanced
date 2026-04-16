# Boolean Data Type in Java

---

## Introduction

The `boolean` data type is used to store logical values.

It can have only two possible values:

* true
* false

---

## Basic Example

```java
public class BooleanDemo {
    public static void main(String[] args) {

        boolean isJavaFun = true;
        boolean isFishFlying = false;

        System.out.println(isJavaFun);
        System.out.println(isFishFlying);
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

## Why Boolean is Important

* Used in decision making
* Controls program flow
* Used in conditions (if, loops)

---

## Boolean in Conditions

```java
public class ConditionDemo {
    public static void main(String[] args) {

        int age = 18;

        boolean isEligible = age >= 18;

        System.out.println(isEligible);
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
* Result → true or false
* Stored in boolean variable

---

## Boolean with If Statement

```java
public class IfExample {
    public static void main(String[] args) {

        boolean isRaining = true;

        if (isRaining) {
            System.out.println("Take umbrella");
        }
    }
}
```

---

## Boolean Expressions

```java
boolean result = (10 > 5);
System.out.println(result);
```

---

### Output

```text
true
```

---

## Important Note

In Java:

* boolean is not a number
* You cannot use 0 or 1

Wrong:

```java
boolean x = 1; // error
```

Correct:

```java
boolean x = true;
```

---

## Memory Concept

```text
boolean → stores only true or false
```

(Java internally handles storage, not exactly 1 bit in practice)

---

## Real-World Example

```java
public class LoginCheck {
    public static void main(String[] args) {

        String password = "admin123";
        boolean isCorrect = password.equals("admin123");

        System.out.println(isCorrect);
    }
}
```

---

## Common Mistakes

* Using 0/1 instead of true/false
* Confusing assignment (=) with comparison (==)
* Not understanding boolean expressions

---

## Practice Challenges

### Challenge 1

Check if a number is greater than 100.

---

### Challenge 2

Store result of (5 < 3) and print it.

---

### Challenge 3

Check if a number is even using boolean.

---

### Challenge 4

Create a login check using boolean condition.

---

## Concept Map

```text
Boolean
 ↓
true / false
 ↓
Conditions
 ↓
Program Flow Control
```

---

## Key Takeaways

* boolean stores true or false
* Used in conditions and decision making
* Cannot use numbers like 0 or 1
* Essential for control flow

---

## Conclusion

Boolean is the foundation of decision-making in programming.

Without boolean logic, programs cannot make choices or react dynamically.
