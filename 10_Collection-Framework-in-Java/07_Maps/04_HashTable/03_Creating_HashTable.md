# Creating a Hashtable in Java

## Step 1: Import the Class

Import the class from `java.util`:

```java
import java.util.Hashtable;
import java.util.Map;
```

---

## Step 2: Declaration Syntax

```java
Map<KeyType, ValueType> mapName = new Hashtable<>();
```

### Example: Creating a Thread-Safe Balance Directory:
```java
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Key is String (Name), Value is Integer (Balance)
        Map<String, Integer> balances = new Hashtable<>();
        
        System.out.println("Initialized Hashtable: " + balances); // Output: {}
    }
}
```

---

## Null Value Restriction Warning

> [!WARNING]
> **Hashtable does not allow null keys OR null values.**
> Attempting to insert a null key or null value throws a `NullPointerException` instantly.

```java
// These will throw NullPointerException!
balances.put(null, 500); 
balances.put("Rahul", null);
```

---

**Back to HashTable Home:** [HashTable Index](README.md)
