# Introduction to HashMap in Java

## What is a HashMap?

A **HashMap** is a tool in Java used to store data in **Key-Value pairs**. 

Think of a dictionary:
* You search for a **Word** (this is the **Key**).
* You find its **Meaning** (this is the **Value**).

```text
  Key (Word)        Value (Meaning)
┌──────────────┐   ┌─────────────────────────────┐
│ "Java"       │ ──> "A popular programming lang" │
│ "Compiler"   │ ──> "A tool that translates code"│
└──────────────┘   └─────────────────────────────┘
```

---

## HashMap Core Rules

To use a HashMap, you only need to remember three basic rules:

1. **Keys must be unique**: You cannot have two identical keys. If you add a key that already exists, the new value will replace the old one.
2. **Values can be duplicate**: Two different keys can have the exact same value. (e.g., both "Rahul" and "Arun" can have the same age `20`).
3. **No guaranteed order**: HashMap does not remember the order in which you added items. If you print it, the items may appear in random order.

---

## How does it differ from a List?

* In a **List** (`ArrayList` or `LinkedList`), you find elements using their position index numbers (`0, 1, 2...`).
* In a **HashMap**, you find elements using a custom Key (which can be a Name, an ID, or any object).

---

**Back to HashMap Home:** [HashMap Index](README.md)
