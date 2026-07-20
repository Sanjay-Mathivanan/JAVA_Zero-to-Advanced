# Creating Threads in Java

## Two Core Approaches

Java provides two primary ways to define and run a thread:
1. **Extending the `Thread` class**.
2. **Implementing the `Runnable` interface**.

---

## 1. Extending the `Thread` Class

To create a thread using this approach, define a subclass of `Thread` and override its `run()` method:

```java
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
        }
    }
}

public class ThreadExtensionDemo {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start(); // Spawns t1 thread execution
        t2.start(); // Spawns t2 thread execution
    }
}
```

---

## 2. Implementing the `Runnable` Interface

The `Runnable` interface represents a task to be executed. To run this task, pass an instance of `Runnable` to a `Thread` constructor:

```java
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Task step: " + i);
        }
    }
}

public class RunnableInterfaceDemo {
    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();

        Thread t1 = new Thread(task, "Thread-Alpha");
        Thread t2 = new Thread(task, "Thread-Beta");

        t1.start();
        t2.start();
    }
}
```

---

## Thread Class vs. Runnable Interface

| Feature | Extending `Thread` | Implementing `Runnable` |
| :--- | :--- | :--- |
| **Inheritance limit** | **Restricted**: Since Java supports single inheritance, extending `Thread` prevents your class from extending any other class. | **Flexible**: Your class can implement multiple interfaces and still extend another class. |
| **Object Sharing** | Each thread object has its own unique class instance. | Multiple threads can share the same `Runnable` target instance, making it ideal for shared tasks. |
| **Separation of Concerns** | Task logic and execution control are coupled in the same class. | **Clean Separation**: Decouples the task logic (`Runnable`) from the thread execution controller (`Thread`). |
| **ThreadPool Compatibility** | Not compatible with thread pools. | Compatible with modern concurrency pools (e.g. `ExecutorService`). |

---

## Modern Lambda Syntax (Java 8+)

Since `Runnable` is a functional interface (having only one abstract method: `run()`), you can define threads concisely using Lambda expressions, eliminating anonymous inner classes:

```java
public class LambdaThreadDemo {
    public static void main(String[] args) {
        // Defining thread tasks using lambda expressions
        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is running a Lambda task.");
        };

        Thread thread = new Thread(task, "LambdaThread");
        thread.start();
    }
}
```

---

## Key Takeaways

* Extending `Thread` is simple but limits inheritance flexibility.
* Implementing `Runnable` is the industry-standard approach because it decouples tasks from execution and supports multiple inheritance.
* Java 8+ allows defining `Runnable` instances using concise Lambda syntax.

---

**Back to Module Index:** [Module Index](README.md)
