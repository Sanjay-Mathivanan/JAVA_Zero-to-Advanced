# Method References in Java

## What is a Method Reference?

A **Method Reference** is a concise shorthand notation for a lambda expression that does nothing but call an existing, named method. It uses the **double colon syntax (`::`)**.

```java
// Equivalent implementations:
Consumer<String> lambdaPrinter = s -> System.out.println(s);
Consumer<String> refPrinter    = System.out::println;
```

---

## Four Kinds of Method References

There are four distinct types of method references:

| Type | Syntax | Lambda Equivalent |
| :--- | :--- | :--- |
| **1. Reference to a Static Method** | `ContainingClass::staticMethodName` | `(args) -> ContainingClass.staticMethodName(args)` |
| **2. Reference to a Specific Instance Method** | `containingObject::instanceMethodName` | `(args) -> containingObject.instanceMethodName(args)` |
| **3. Reference to an Arbitrary Instance Method**| `ContainingType::methodName` | `(obj, args) -> obj.methodName(args)` |
| **4. Reference to a Constructor** | `ClassName::new` | `(args) -> new ClassName(args)` |

---

## 1. Reference to a Static Method

Refers to a static method defined in a utility class or helper:

```java
// Lambda:
Function<Double, Double> sqrtLambda = value -> Math.sqrt(value);

// Method Reference:
Function<Double, Double> sqrtRef = Math::sqrt;
```

---

## 2. Reference to a Specific Object's Instance Method

Refers to a method belonging to an object instance initialized in the current scope:

```java
String suffix = "!";
Function<String, String> appendSuffix = text -> text.concat(suffix);

// Method Reference:
Function<String, String> appendSuffixRef = suffix::concat;
```

---

## 3. Reference to an Arbitrary Object's Instance Method

Refers to an instance method that is executed on the first parameter passed to the lambda (e.g. comparing, trimming, or extracting properties):

```java
// Lambda:
Function<String, String> trimLambda = str -> str.trim();

// Method Reference:
Function<String, String> trimRef = String::trim; 
// Explanation: The compiler executes .trim() on the String object passed at execution time.
```

---

## 4. Reference to a Constructor

Refers to class instantiation. This is useful for factory patterns or streams mapping:

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ConstructorRefDemo {
    public static void main(String[] args) {
        // Lambda:
        Supplier<List<String>> listLambda = () -> new ArrayList<>();

        // Method Reference:
        Supplier<List<String>> listRef = ArrayList::new;

        List<String> list = listRef.get();
        System.out.println("List instance created: " + list.getClass().getName());
    }
}
```

---

## Key Takeaways

* Method references (`::`) provide a clean shorthand for lambdas that only call an existing method.
* The compiler resolves the method reference type by mapping arguments to the target functional interface.
* Types include Static, Specific Instance, Arbitrary Instance, and Constructor (`::new`) references.

---

**Back to Module Home:** [Module Index](README.md)
