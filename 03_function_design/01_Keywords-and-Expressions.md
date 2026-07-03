# Keywords and Expressions in Java

This guide introduces the two primary building blocks of Java syntax: keywords and expressions, highlighting compiler processing, operator precedence, and memory execution rules.

---

## Introduction

Java programs are constructed using a predefined set of syntax rules. Two essential components of this grammar are:
* **Keywords**: Reserved identifiers defined by the language specifications that dictate program structure and logic.
* **Expressions**: Syntactic constructs comprising variables, values, operators, and method calls that are evaluated to produce a single value.

---

## Keywords in Java

Keywords are reserved words that have a predefined meaning in the compiler's parser. 

Because keywords are reserved for defining class boundaries, logic branching, loops, and data types, they **cannot** be used as identifiers (e.g., you cannot name variables, classes, or methods using these words).

### Common Java Keywords and Their Roles

| Category | Keywords | Predefined Purpose |
| :--- | :--- | :--- |
| **Class &amp; Access** | `class`, `interface`, `public`, `private`, `protected` | Define scopes, class structures, and member visibilities. |
| **Control Flow** | `if`, `else`, `switch`, `case`, `for`, `while`, `do` | Set conditional forks and code execution loops. |
| **Primitives** | `byte`, `short`, `int`, `long`, `float`, `double`, `char`, `boolean` | Specify data type storage dimensions in memory. |
| **Method Modifiers** | `void`, `return`, `static`, `final`, `abstract` | Restrict inheritance, define returns, and manage static memory scope. |
| **Object Mechanics** | `new`, `this`, `super`, `instanceof` | Handle object instantiation, hierarchy access, and class casting checks. |
| **Exceptions** | `try`, `catch`, `finally`, `throw`, `throws` | Structure blocks to isolate and handle runtime errors safely. |

### Lexical Analyzer Stage
When you compile a Java file, the compiler's lexical analyzer parses text tokens. For example, in the statement `int score = 95;`:
1. The compiler identifies the token `int` as a reserved primitive data type keyword.
2. It registers `score` as a user-defined identifier.
3. It identifies `=` as the assignment operator token.
4. It reads `95` as a numeric integer literal.

---

## Expressions in Java

An expression is a combination of variables, values, operators, and method calls that evaluates to a single output value.

### Elements of a Basic Expression
```text
operand1  +  operand2  ==  expression
  (10)   (+)   (20)    ==   (evaluates to 30)
```

---

## Classifications of Expressions

### 1. Arithmetic Expressions
Perform mathematical calculations and return numeric results:
```java
int result = 10 + 5 * 2; // Evaluates to 20 based on multiplication precedence
```

### 2. Relational Expressions
Compare values and return a boolean output:
```java
int a = 10;
int b = 20;
boolean isSmaller = (a < b); // Evaluates to true
```

### 3. Logical Expressions
Combine multiple boolean parameters using logical operators:
```java
int age = 22;
boolean check = (age > 18 && age < 30); // Evaluates to true
```

### 4. Assignment Expressions
Assign value statements to target memory addresses:
```java
int x = 50; // Evaluates the literal 50 and assigns it to x
```

### 5. Unary Expressions
Operate on a single operand to modify value or state:
```java
int count = 5;
count++; // Evaluates to 6
```

---

## Expression Evaluation Flow

Java evaluates expressions based on parenthesis groupings first, followed by standard operator precedence:

```java
int result = (10 + 5) * 2;
```

### Step-by-Step Resolution Steps
1. The compiler evaluates parentheses first: `10 + 5` evaluates to `15`.
2. The compiler multiplies the intermediate result: `15 * 2` evaluates to `30`.
3. The assignment expression writes the value `30` to the memory address allocated for `result`.

---

## Summary of Differences: Keywords vs. Expressions

| Parameter | Keywords | Expressions |
| :--- | :--- | :--- |
| **Functional Role** | Defines structural language syntax rules. | Executes data manipulations to compute values. |
| **Modifier Rights** | Defined by Java; cannot be edited or renamed. | Declared and defined dynamically by developers. |
| **Compiler Parsing** | Decoded as syntax identifiers. | Executed as math or logic processing statements. |
| **Examples** | `class`, `int`, `static`, `if`, `return` | `a + b`, `10 * c`, `x == y` |

---

## Practice Challenges

### Challenge 1: Keyword Detection
Identify all reserved Java keywords in the following method signature:
```java
public static final double calculateInterest(int principal, double rate)
```

### Challenge 2: Precedence Output
Predict the output value of the expression `100 - 25 * 3 + 12 / 4` and write a Java program to verify.

### Challenge 3: Expression Evaluation Stack
In the expression `boolean result = (5 > 3) && (10 <= 20)`, explain the step-by-step logic evaluations performed by the CPU, including any short-circuit behaviors.

---

**Back to Module Home:** [Function Design &amp; Modular Programming](file:///d:/New%20folder/PROJECTS/JAVA_Zero-to-Advanced/03_function_design/README.md)
