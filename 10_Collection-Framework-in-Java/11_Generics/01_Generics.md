# Generics in Java

## Introduction

In Java, we often write classes, interfaces, and methods that perform operations on different types of objects. For example, a list can store integers, strings, or custom employee objects.

Before Java 5, collections stored everything as `Object` references, requiring programmers to manually cast elements back to their original type. This was error-prone and often caused runtime errors.

**Generics** (introduced in Java 5) add a way to specify the type of objects a collection can hold as a compile-time parameter.

---

## Why Generics? (Problems Without Generics)

Without Generics, code is not type-safe. Consider this example:

```java
import java.util.ArrayList;
import java.util.List;

public class WithoutGenerics {
    public static void main(String[] args) {
        List names = new ArrayList(); // Raw Type
        names.add("Alice");
        names.add("Bob");
        names.add(100); // No compile error! We mistakenly added an Integer

        // Manual casting is required:
        for (Object name : names) {
            String str = (String) name; // Throws ClassCastException at runtime for 100!
            System.out.println(str);
        }
    }
}
```

### The Generics Solution:
With Generics, type checks happen at compile time, eliminating runtime casting errors:

```java
List<String> names = new ArrayList<>();
names.add("Alice");
// names.add(100); // Compile-time error! Prevents bad insertions.

for (String name : names) {
    System.out.println(name); // No manual casting required!
}
```

---

## Creating Generic Classes

A generic class is declared with a **type parameter** enclosed in angle brackets (`<>`):

```java
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

### Instantiating:
```java
Box<Integer> integerBox = new Box<>();
integerBox.set(123);

Box<String> stringBox = new Box<>();
stringBox.set("Hello");
```

Commonly used type parameter naming conventions:
* `T` - Type
* `E` - Element (used extensively in Collections)
* `K` - Key
* `V` - Value

---

## Generic Methods

You can make a single method generic, even if the class is not:

```java
public class ArrayPrinter {
    public static <E> void printArray(E[] array) {
        for (E element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
```

The type parameter `<E>` is placed before the return type.

---

## Generic Interfaces

Interfaces can also define type parameters:

```java
public interface KeyValuePair<K, V> {
    K getKey();
    V getValue();
}
```

---

## Bounded Types

You can restrict the types that can be passed to a type parameter using **Bounded Types**:

```java
// T must be Number or a subclass of Number (e.g. Integer, Double)
public class Stats<T extends Number> {
    T[] nums;

    public Stats(T[] nums) {
        this.nums = nums;
    }

    public double getAverage() {
        double sum = 0.0;
        for (T num : nums) {
            sum += num.doubleValue(); // doubleValue() is available because T extends Number
        }
        return sum / nums.length;
    }
}
```

---

## Wildcards in Generics

The wildcard operator **`?`** represents an unknown type.

### 1. Unbounded Wildcard (`?`)
Used when you want to read elements from a collection without caring about its specific type:
```java
public static void printList(List<?> list) {
    for (Object elem : list) {
        System.out.println(elem);
    }
}
```

### 2. Upper Bounded Wildcard (`? extends T`)
Restricts the unknown type to be `T` or a subclass of `T` (Read-only / Producer):
```java
public static double sumOfList(List<? extends Number> list) {
    double sum = 0.0;
    for (Number n : list) {
        sum += n.doubleValue();
    }
    return sum;
}
```

### 3. Lower Bounded Wildcard (`? super T`)
Restricts the unknown type to be `T` or a superclass of `T` (Write-only / Consumer):
```java
public static void addNumbers(List<? super Integer> list) {
    list.add(1);
    list.add(2);
}
```

---

## Type Erasure (Basic)

Java implements Generics using **Type Erasure**. 

The compiler uses type parameters to verify type safety at compile time, and then **erases** them in the compiled bytecode, replacing them with raw `Object` types (or their bounded limits). This ensures backward compatibility with older Java versions.

---

## Complete Example Programs

### Example: Custom Generic Repository
```java
import java.util.ArrayList;
import java.util.List;

class Repository<T> {
    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public List<T> getAll() {
        return items;
    }
}

public class GenericsDemo {
    public static void main(String[] args) {
        Repository<String> repo = new Repository<>();
        repo.add("First Entry");
        repo.add("Second Entry");

        System.out.println("Repo Items: " + repo.getAll()); // [First Entry, Second Entry]
    }
}
```

---

## Best Practices

* **Avoid Raw Types**: Always declare collections with their generic types (e.g. `List<String> list` instead of `List list`). Using raw types bypasses compile-time checks.
* **Use PECS Rule**: Remember **P**roducer **E**xtends, **C**onsumer **S**uper:
  * Use `? extends T` if you only read elements from a collection (Producer).
  * Use `? super T` if you only write elements into a collection (Consumer).

---

## Common Mistakes

* **Generics are Not Covariant**: In Java, arrays are covariant (`String[]` is a subclass of `Object[]`), but generics are invariant: `List<String>` is **not** a subclass of `List<Object>`.
* **Cannot Instantiate Type Parameters**: You cannot write `new T()` inside a generic class because the type parameter `T` is erased at runtime, so the JVM does not know what constructor to call.

---

## Key Takeaways

* Generics provide compile-time type safety.
* Bounded types restrict parameters using `extends`.
* Wildcards (`?`) allow flexible collections parameters matching.

---

## Conclusion

Generics are a powerful tool in Java, providing type safety and code reusability. By moving type check errors from runtime to compile time, they help prevent bugs and eliminate the need for manual casting.

---

**Back to Collection Framework Home:** [JCF Index](README.md)
