# Internal Working of HashMap

## Introduction

Under the hood, a `HashMap` stores elements in an internal array of nodes:
```java
transient Node<K,V>[] table;
```

Each index in this table is called a **bucket**. A bucket is either `null`, points to a single node, or points to a linked list chain (or a Red-Black Tree).

```mermaid
graph TD
    subgraph Table Array (Capacity: 16)
        B0["[0]: Node A"]
        B1["[1]: null"]
        B2["[2]: Node C"]
        B3["[3]: null"]
    end
    
    NodeA["Node A (Key: Rahul)"]
    NodeB["Node B (Key: Arun)"]
    NodeC["Node C (Key: Priya)"]
    
    B0 --> NodeA
    NodeA --> NodeB
    B2 --> NodeC
```

### The Node Class Structure:
```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash; // perturbation hash
    final K key;
    V value;
    Node<K,V> next; // pointer to next colliding node
}
```

---

## 1. Hash Code Generation and Key Perturbation

When you insert a key-value entry using `put(key, value)`:
1. The JVM calls the key's `hashCode()` method to get its integer fingerprint.
2. It then applies a **perturbation hash function** to mix high bits down, reducing collisions:
   ```java
   static final int hash(Object key) {
       int h;
       return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
   }
   ```

---

## 2. Bucket Index Calculation

To place the key into the internal table array, the JVM calculates the bucket index using a bitwise AND operation (which is much faster than modulo `%` arithmetic):

$$\text{Index} = \text{hash} \ \& \ (n - 1)$$
*(where $n$ is the current table capacity, always a power of 2, like 16).*

---

## 3. Resolving Hash Collisions

When two different keys calculate to the same bucket index:
* **Chaining**: HashMap appends the new node to the end of the Singly Linked List at that bucket index.
* **JDK 8 Treeification**: If the linked list length at a single bucket exceeds **8** and the overall table capacity is at least **64**, the list is converted (treeified) into a balanced **Red-Black Tree**. This keeps search speeds fast ($\mathcal{O}(\log N)$ instead of $\mathcal{O}(N)$).

---

## 4. Load Factor and Rehashing

* **Default Load Factor**: `0.75` (75% full).
* **Threshold**: $\text{Capacity} \times \text{Load Factor} = 16 \times 0.75 = 12$.

When the map size exceeds the threshold, the table capacity is doubled (e.g. $16 \rightarrow 32$), and all keys are **rehashed** to their new bucket indexes.

---

**Back to HashMap Home:** [HashMap Index](README.md)
