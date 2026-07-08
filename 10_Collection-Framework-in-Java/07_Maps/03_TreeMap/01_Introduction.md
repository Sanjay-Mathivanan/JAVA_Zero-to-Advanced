# Introduction to TreeMap in Java

## What is a TreeMap?

A **TreeMap** is a class in Java that stores key-value pairs in **sorted order**.

Whenever you add a key-value entry into a `TreeMap`, it compares the key with existing keys and automatically places it in the correct sorted position (either numerically or alphabetically):

```text
HashMap (Random Order):    [Banana]  [Orange]  [Apple]
TreeMap (Sorted Order):     [Apple] ──> [Banana] ──> [Orange] (Alphabetically sorted keys)
```

---

## Key Rules

* **Sorted Keys**: Keys are kept in natural sorted order, or in custom order using a Comparator.
* **Red-Black Tree backing**: Under the hood, it is a binary tree, providing guaranteed logarithmic $\mathcal{O}(\log N)$ speeds.
* **No Null Keys**: **You cannot have null keys** in a TreeMap because it needs to compare them to sort. (Null values are allowed).

---

**Back to TreeMap Home:** [TreeMap Index](README.md)
