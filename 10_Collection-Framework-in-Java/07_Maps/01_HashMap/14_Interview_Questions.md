# HashMap Interview Questions and Answers

## Beginner Questions

### Q1: What is the default initial capacity of a HashMap?
**Answer:**
The default initial capacity is **16**. The default load factor is **0.75**.

### Q2: What happens if you put a duplicate key in a HashMap?
**Answer:**
The HashMap will replace the old value associated with that key with the new value. It does not throw an error.

---

## Intermediate Questions

### Q3: What is a Hash Collision and how does HashMap solve it?
**Answer:**
A hash collision occurs when two different keys calculate to the same bucket index. HashMap resolves this using **Chaining**: colliding elements are stored in a Singly Linked List at that bucket index.

### Q4: Why is `get()` fast in a HashMap?
**Answer:**
Because it hashes the key to calculate the exact bucket index slot directly, instead of searching elements one by one. This runs in $\mathcal{O}(1)$ constant time.

---

## Advanced Questions

### Q5: What is the Java 8 Treeifying threshold?
**Answer:**
If a bucket's linked list size exceeds **8** and the overall map capacity is at least **64**, the Singly Linked List is converted into a **Red-Black Tree** to keep search speeds fast ($\mathcal{O}(\log N)$ instead of $\mathcal{O}(N)$).

---

**Back to HashMap Home:** [HashMap Index](README.md)
