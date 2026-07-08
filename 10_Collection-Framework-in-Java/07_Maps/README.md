# Maps in Java

A **Map** represents an object that maps unique keys to values. A Map cannot contain duplicate keys; each key can map to at most one value. Unlike the other collection interfaces (`List`, `Set`, `Queue`), `Map` does not inherit from `Collection` or `Iterable`.

---

## Implementing Classes Map

### 1. [HashMap](01_HashMap/README.md) (Unordered, Default Choice)
* [HashMap Basics and Creation](01_HashMap/01_HashMap-Basics-and-Creation.md): Characteristics, constructors, and syntax.
* [HashMap Basic Operations](01_HashMap/02_HashMap-Basic-Operations.md): Appending, modifying, removing, and iterating over keys/values.
* [HashMap Internal Workings](01_HashMap/03_HashMap-Internal-Workings.md): Hashing calculation, bucket linked lists, collisions, load factors, and treeifying threshold of 8.
* [HashMap Comparisons and Q&As](01_HashMap/04_HashMap-Comparisons-and-Interview-Questions.md): Detailed comparison tables and interview Q&As.

### 2. [LinkedHashMap](02_LinkedHashMap/README.md) (Preserves Insertion/Access Order)
* [LinkedHashMap Basics and Operations](02_LinkedHashMap/01_LinkedHashMap-Basics-and-Operations.md): Preserving ordering and access-ordering mode.
* [LinkedHashMap Internal Workings](02_LinkedHashMap/02_LinkedHashMap-Internal-Workings-and-Comparison.md): Doubly-linked bucket nodes, LRU caching implementation (`removeEldestEntry()`), and comparison tables.

### 3. [TreeMap](03_TreeMap/README.md) (Sorted Key Ordering)
* [TreeMap Basics and Operations](03_TreeMap/01_TreeMap-Basics-and-Operations.md): NavigableMap range query APIs.
* [TreeMap Internal Workings](03_TreeMap/02_TreeMap-Internal-Workings-and-Comparison.md): Red-Black self-balancing BST model, rotations, color flips, and comparisons.

### 4. [Hashtable](04_HashTable/01_HashTable-Basics-and-Operations.md) (Thread-safe monitor lock, Obsolete)
* [Hashtable Basics and Operations](04_HashTable/01_HashTable-Basics-and-Operations.md): Synchronized operations, null key restrictions, why it is obsolete, and ConcurrentHashMap alternatives.

---

## Map Implementations Summary

```mermaid
graph TD
    Map["Map Interface"]
    HashMap["HashMap (Hashing, Unordered)"]
    LinkedHashMap["LinkedHashMap (Doubly Linked, Insertion/Access Order)"]
    SortedMap["SortedMap Interface"]
    TreeMap["TreeMap (Red-Black Tree, Sorted Keys)"]
    Hashtable["Hashtable (Synchronized, Legacy)"]
    
    Map --> HashMap
    HashMap --> LinkedHashMap
    Map --> SortedMap
    SortedMap --> TreeMap
    Map --> Hashtable
```

---

**Back to Module Home:** [Collection Framework Index](../README.md)
