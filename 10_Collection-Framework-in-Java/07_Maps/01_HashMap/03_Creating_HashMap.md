# Creating a HashMap in Java

## Step 1: Import the Class

Since the HashMap class is part of Java's utility package, you must import it at the top of your Java file:

```java
import java.util.HashMap;
import java.util.Map;
```

---

## Step 2: Declare the Map

You must specify the type of the **Key** and the type of the **Value** inside angle brackets `<KeyType, ValueType>`. 

```java
Map<String, Integer> mapName = new HashMap<>();
```

### Example: Creating a Map of Student Names and Roll Numbers:
```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Key is String (Student Name), Value is Integer (Roll Number)
        Map<String, Integer> studentRolls = new HashMap<>();
        
        System.out.println("Initialized Map: " + studentRolls); // Output: {}
    }
}
```

---

## Important Rules for Declaring Types

* **Use Wrapper Classes for Primitives**: HashMap cannot store primitive types directly (like `int`, `double`, `char`). You must use their wrapper class equivalents (`Integer`, `Double`, `Character`).
  * ❌ `Map<String, int> map = new HashMap<>();` (Compilation Error)
  * ✅ `Map<String, Integer> map = new HashMap<>();` (Correct)

---

**Back to HashMap Home:** [HashMap Index](README.md)
