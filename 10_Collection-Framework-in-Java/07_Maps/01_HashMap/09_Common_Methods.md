# Common Query Methods in HashMap

## 1. Checking If a Key Exists: `containsKey()`

To check if a key is stored in the Map, use **`containsKey(key)`**:

```java
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> contacts = new HashMap<>();
        contacts.put("Rahul", "9876543210");

        // Checking keys
        if (contacts.containsKey("Rahul")) {
            System.out.println("Rahul is in contacts."); // Prints
        }
    }
}
```

---

## 2. Checking If a Value Exists: `containsValue()`

To check if a value exists, use **`containsValue(value)`**:

```java
if (contacts.containsValue("9876543210")) {
    System.out.println("Phone number exists."); // Prints
}
```

> [!NOTE]
> `containsKey()` is very fast ($\mathcal{O}(1)$ complexity), whereas `containsValue()` is slower ($\mathcal{O}(N)$ complexity) because the JVM must search through all buckets to find the value.

---

## 3. Map Size and Emptiness: `size()` & `isEmpty()`

* **`size()`**: Returns the total number of entries in the map.
* **`isEmpty()`**: Returns `true` if the map contains 0 entries.

```java
System.out.println("Total contacts: " + contacts.size()); // 1
System.out.println("Is map empty? " + contacts.isEmpty()); // false
```

---

**Back to HashMap Home:** [HashMap Index](README.md)
