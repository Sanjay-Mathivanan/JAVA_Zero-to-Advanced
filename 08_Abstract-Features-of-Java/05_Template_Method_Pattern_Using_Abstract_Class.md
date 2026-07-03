# Template Method Pattern Using an Abstract Class

## Problem Statement

An enterprise analytics engine requires a system to:

- Ingest data from different sources (CSV files, Database streams, etc.)
- Validate the data
- Transform the data into a standardized JSON format
- Log execution metrics

The **processing steps should always occur in the same order**, but the way data is loaded and transformed depends on the data source.

This is a perfect use case for an **Abstract Class** using the **Template Method Pattern**.

---

# Why Use an Abstract Class?

Every data source follows the same workflow.

```
Start
   │
   ▼
Load Data
   │
   ▼
Validate Data
   │
   ▼
Transform Data
   │
   ▼
Log Metrics
   │
   ▼
Finish
```

Only two steps change:

- Loading data
- Transforming data

The remaining steps are common for every implementation.

---

# Solution

Create an abstract class that defines the complete processing algorithm.

```
                DataProcessor
                     ▲
         ┌───────────┴───────────┐
         │                       │
         ▼                       ▼
    CSVProcessor          DatabaseProcessor
```

---

# Java Program

```java
abstract class DataProcessor {

    // Template Method
    public final void process() {

        loadData();
        validateData();
        transformData();
        logMetrics();

    }

    protected abstract void loadData();

    protected abstract void transformData();

    protected void validateData() {

        System.out.println("Validating data...");

    }

    protected void logMetrics() {

        System.out.println("Logging execution metrics...");

    }

}

class CSVProcessor extends DataProcessor {

    @Override
    protected void loadData() {

        System.out.println("Loading data from CSV file...");

    }

    @Override
    protected void transformData() {

        System.out.println("Transforming CSV data into JSON...");

    }

}

class DatabaseProcessor extends DataProcessor {

    @Override
    protected void loadData() {

        System.out.println("Loading data from Database...");

    }

    @Override
    protected void transformData() {

        System.out.println("Transforming Database records into JSON...");

    }

}

public class Main {

    public static void main(String[] args) {

        DataProcessor csv = new CSVProcessor();

        System.out.println("----- CSV Processing -----");

        csv.process();

        System.out.println();

        DataProcessor database = new DatabaseProcessor();

        System.out.println("----- Database Processing -----");

        database.process();

    }

}
```

---

# Output

```
----- CSV Processing -----

Loading data from CSV file...
Validating data...
Transforming CSV data into JSON...
Logging execution metrics...

----- Database Processing -----

Loading data from Database...
Validating data...
Transforming Database records into JSON...
Logging execution metrics...
```

---

# Step-by-Step Explanation

### Step 1

Create an abstract class.

```java
abstract class DataProcessor
```

This acts as the common framework.

---

### Step 2

Define the template method.

```java
public final void process()
```

This controls the execution order.

---

### Step 3

Declare abstract methods.

```java
loadData();

transformData();
```

Each subclass provides its own implementation.

---

### Step 4

Provide common methods.

```java
validateData();

logMetrics();
```

These methods are shared by all subclasses.

---

### Step 5

Create subclasses.

- `CSVProcessor`
- `DatabaseProcessor`

Each one implements only the variable parts.

---

# Program Flow

```
process()

   │

   ▼

loadData()

   │

   ▼

validateData()

   │

   ▼

transformData()

   │

   ▼

logMetrics()

   │

   ▼

End
```

---

# Memory Representation

```
Stack

csv
 │
 ▼

Heap

+----------------------+
| CSVProcessor Object  |
+----------------------+

database
 │
 ▼

+---------------------------+
| DatabaseProcessor Object  |
+---------------------------+
```

---

# Why is `process()` Final?

```java
public final void process()
```

The `final` keyword prevents subclasses from changing the execution order.

Without `final`, a subclass could accidentally skip validation or logging.

---

# Advantages

- Promotes code reuse.
- Ensures a fixed processing sequence.
- Allows subclasses to customize only required steps.
- Reduces duplicate code.
- Easy to extend with new data sources.

---

# Real-World Applications

- ETL (Extract, Transform, Load) pipelines
- Report generation systems
- Payment processing
- File import/export frameworks
- Data analytics platforms
- Workflow engines

---

# Interview Questions

### Q1. Which design pattern is used here?

**Answer:** Template Method Pattern.

---

### Q2. Why is the `process()` method declared `final`?

**Answer:** To prevent subclasses from changing the processing sequence.

---

### Q3. Why use an abstract class instead of an interface?

**Answer:** Because the framework provides shared implementations (`validateData()` and `logMetrics()`) while allowing subclasses to customize only specific steps.

---

# Key Takeaways

- An abstract class is ideal when multiple classes share a common workflow.
- The **Template Method Pattern** defines the algorithm once and lets subclasses customize specific steps.
- Abstract methods represent variable behavior.
- Concrete methods represent common behavior.
- Using `final` on the template method preserves the execution order.
