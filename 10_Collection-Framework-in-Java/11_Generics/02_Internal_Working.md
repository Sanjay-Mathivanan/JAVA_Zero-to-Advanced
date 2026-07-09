# Internal Working of Generics

## Type Erasure

Java implements Generics at the compiler level. Once the compiler verifies that your code is type-safe, it performs **Type Erasure**: it removes all generic type parameter information from the class files.

### 1. Replacing Type Parameters with Bounds
* If a type parameter is unbounded (e.g. `<T>`), it is replaced with `Object`.
* If a type parameter is bounded (e.g. `<T extends Number>`), it is replaced with the first bound class (`Number`).

```text
Source Code (T is replaced with Object):
class Box<T> {                          class Box {
    T val;             =======>             Object val;
    T get() { return val; }                 Object get() { return val; }
}                                       }
```

```text
Bounded Source Code (T is replaced with Number):
class MathBox<T extends Number> {       class MathBox {
    T val;             =======>             Number val;
    T get() { return val; }                 Number get() { return val; }
}                                       }
```

---

## 2. Automatic Cast Insertion

Because the compiled class files contain only raw types (`Object` or bounded types), the compiler automatically inserts manual type casts in the calling bytecode when you retrieve value references:

```java
// Source Code:
Box<String> box = new Box<>();
box.set("Hello");
String val = box.get();
```

Is translated by the compiler into:

```java
// Translated Bytecode equivalent:
Box box = new Box();
box.set("Hello");
String val = (String) box.get(); // Cast is added automatically by the compiler
```

---

## 3. Bridge Methods

To preserve polymorphism and inheritance contracts in compiled classes that extend generic interfaces or classes, the compiler generates synthetic **Bridge Methods**:

```java
// Generic Parent:
class Node<T> {
    public void setData(T data) { ... }
}

// Subclass:
class MyNode extends Node<Integer> {
    @Override
    public void setData(Integer data) { ... }
}
```

During type erasure, `Node.setData(T)` becomes `Node.setData(Object)`. To make sure `MyNode.setData(Integer)` override is resolved properly by the JVM at runtime, the compiler generates a hidden bridge method:

```java
// Generated hidden method inside MyNode.class:
public void setData(Object data) {
    setData((Integer) data); // Delegates to the specific Integer method
}
```

---

## Runtime Representation

At runtime, there is no difference between a `ArrayList<String>` and an `ArrayList<Integer>`. Both are represented by the same raw `ArrayList` class.

---

**Back to Stacks Home:** [JCF Index](../README.md)
