# Functional Interfaces in Java

## The SAM Rule

A lambda expression in Java cannot exist in isolation; it must target a reference type. In Java, this target type must be a **Functional Interface**.

A **Functional Interface** is an interface that contains **exactly one abstract method**. This is known as the **Single Abstract Method (SAM)** rule.

```java
public interface MathOperation {
    int operate(int a, int b); // Single abstract method (SAM)
}
```

---

## The `@FunctionalInterface` Annotation

Java 8 introduced the **`@FunctionalInterface`** annotation. While optional, it is recommended to apply this to all functional interfaces:

```java
@FunctionalInterface
public interface SpeedChecker {
    boolean isTooFast(int speed);
    
    // Compiler error if uncommented:
    // void resetSpeedLimit(); 
}
```

* **Purpose**: It directs the compiler to verify that the interface complies with the SAM rule. If you add a second abstract method to the interface, the compiler will throw a compilation error: *Unexpected @FunctionalInterface annotation*.

---

## Default and Static Methods

Functional interfaces can contain any number of **`default`** and **`static`** methods. These do not count against the SAM rule because they provide concrete implementations:

```java
@FunctionalInterface
public interface StringFormatter {
    // The single abstract method
    String format(String input);

    // Default method (does not affect SAM)
    default void printFormatted(String input) {
        System.out.println(format(input));
    }

    // Static method (does not affect SAM)
    static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
```

---

## Complete Custom Interface Example

Here is a complete program demonstrating a custom functional interface used with lambdas:

```java
@FunctionalInterface
interface Encryptor {
    String encrypt(String data, int key);
}

public class EncryptionDemo {
    public static void main(String[] args) {
        // Implementing the interface using a Lambda Expression
        Encryptor caesarCipher = (data, key) -> {
            StringBuilder result = new StringBuilder();
            for (char character : data.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    result.append((char) ((character - base + key) % 26 + base));
                } else {
                    result.append(character);
                }
            }
            return result.toString();
        };

        String secret = caesarCipher.encrypt("Hello World", 3);
        System.out.println("Encrypted Text: " + secret); // "Khoor Zruog"
    }
}
```

---

## Key Takeaways

* A functional interface contains exactly one abstract method (SAM).
* `@FunctionalInterface` checks at compile time that the interface has exactly one abstract method.
* Default and static methods can be added without violating the SAM rule.

---

**Back to Module Home:** [Module Index](README.md)
