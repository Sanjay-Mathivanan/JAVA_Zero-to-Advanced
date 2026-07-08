# Common Methods in Hashtable

## Basic CRUD Operations

`Hashtable` uses the standard map methods defined in the `Map` interface:

* **`put(key, value)`**: Adds a key-value entry, or updates it if the key exists.
* **`get(key)`**: Retrieves the mapped value.
* **`remove(key)`**: Deletes the key-value entry.

```java
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> servers = new Hashtable<>();

        // 1. Insertion
        servers.put("ServerA", "192.168.1.100");
        servers.put("ServerB", "192.168.1.101");

        // 2. Retrieval
        System.out.println("ServerA IP: " + servers.get("ServerA")); // 192.168.1.100

        // 3. Removal
        servers.remove("ServerB");
        System.out.println(servers); // Output: {ServerA=192.168.1.100}
    }
}
```

---

## Size and Queries

* **`size()`**: Returns the total entry count.
* **`containsKey(key)`**: Checks if a key exists in the table.
* **`contains(value)`**: Legacy method unique to Hashtable to check if a value exists (equivalent to `containsValue`).

---

**Back to HashTable Home:** [HashTable Index](README.md)
