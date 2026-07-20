# Throw vs. Throws in Java

## Comparison Table

While the keywords `throw` and `throws` are related, they serve distinct purposes in exception handling:

| Feature | `throw` | `throws` |
| :--- | :--- | :--- |
| **Purpose** | Used to explicitly throw a single exception instance. | Used to declare exceptions a method might throw in its signature. |
| **Syntax Location**| Inside method bodies. | In the method signature declaration. |
| **Count** | Followed by exactly one exception object instance. | Followed by a comma-separated list of exception classes. |
| **Type Support** | Can throw both checked and unchecked exceptions. | Primarily used to warn callers about checked exceptions. |

---

## The `throw` Keyword

Use `throw` to explicitly instantiate and throw an exception object. This is useful for validating parameters:

```java
public class Validator {
    public static void validateAge(int age) {
        if (age < 18) {
            // Explicitly throwing an unchecked exception
            throw new IllegalArgumentException("Age must be at least 18.");
        }
        System.out.println("Access granted.");
    }
}
```

---

## The `throws` Keyword

If a method can cause a checked exception to be thrown, but does not handle it with a `try-catch` block, it must declare that exception in its method signature using `throws`. This informs callers of the method that they must handle or declare the exception.

```java
import java.io.FileReader;
import java.io.IOException;

public class FileReadDemo {
    // Declaring that this method propagates IOException
    public static void readFile(String path) throws IOException {
        FileReader reader = new FileReader(path);
        reader.read();
        reader.close();
    }
}
```

---

## Designing Custom Exception Classes

If Java's built-in exceptions do not represent your business logic constraints, you can create custom exceptions:

* **Checked Custom Exception**: Extend **`java.lang.Exception`**. Callers must handle or declare it.
* **Unchecked Custom Exception**: Extend **`java.lang.RuntimeException`**.

```java
// Checked Custom Exception
class InsufficientFundsException extends Exception {
    private final double amountNeeded;

    public InsufficientFundsException(double amountNeeded) {
        super("Transaction failed. You need " + amountNeeded + " more in balance.");
        this.amountNeeded = amountNeeded;
    }

    public double getAmountNeeded() {
        return amountNeeded;
    }
}

// Demo usage
public class BankAccount {
    private double balance = 100.0;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double deficiency = amount - balance;
            throw new InsufficientFundsException(deficiency);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Balance: " + balance);
    }
}
```

---

## Key Takeaways

* Use `throw` inside methods to launch a specific exception instance.
* Use `throws` on method signatures to declare checked exceptions that propagate to callers.
* Custom exceptions are created by extending `Exception` (checked) or `RuntimeException` (unchecked).

---

**Back to Module Home:** [Module Index](README.md)
