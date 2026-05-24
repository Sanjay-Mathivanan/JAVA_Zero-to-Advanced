Keywords and Expressions in Java
Introduction

Java programs are built using predefined rules and structured syntax.
Two important building blocks of Java syntax are:

Keywords
Expressions

Keywords define the language structure itself, while expressions are used to perform operations and produce values.

Understanding these concepts is essential because every Java program internally depends on them.

This topic forms the foundation for:

Conditions
Loops
Methods
Object creation
Calculations
Decision making
Program execution flow
What are Keywords in Java?
Definition

Keywords are reserved words that already have predefined meanings in Java.

These words are part of the Java language syntax and cannot be used as:

Variable names
Method names
Class names
Object names
Why Keywords Exist

Java needs fixed words to identify:

Data types
Access rules
Conditions
Loops
Object-oriented features
Exception handling
Memory behavior

Without keywords, the compiler would not understand program structure.

Real-World Analogy

Think of Java keywords like traffic signals.

Signal	Meaning
Red	Stop
Green	Go
Yellow	Wait

Similarly, Java keywords tell the compiler what action should happen.

Example:

class → define a class
if → make a decision
return → send value back
static → belongs to class
Common Java Keywords
Keyword	Purpose
class	Defines a class
public	Access modifier
static	Shared among objects
void	No return value
int	Integer datatype
double	Decimal datatype
if	Conditional statement
else	Alternative condition
return	Sends value back
new	Creates object
this	Refers current object
extends	Inheritance
final	Constant/restricted modification
try	Exception handling block
catch	Handles exception
for	Looping
while	Repetition loop
Example Program Using Keywords
public class Demo {

    public static void main(String[] args) {

        int number = 10;

        if(number > 5) {
            System.out.println("Number is greater than 5");
        }

    }
}
Output
Number is greater than 5
Step-by-Step Explanation
Step 1
public class Demo
Keywords Used
public
class
Meaning
public → accessible everywhere
class → defines blueprint
Step 2
public static void main
Keywords Used
public
static
void
Meaning
public → JVM can access it
static → method belongs to class
void → returns nothing
Step 3
int number = 10;
Keywords Used
int
Meaning

Creates integer variable.

Step 4
if(number > 5)
Keywords Used
if
Meaning

Checks condition.

Internal Working of Keywords
Compilation Stage

When Java compiler reads code:

int age = 20;

The compiler immediately recognizes:

int as datatype keyword
age as variable
= as assignment operator
20 as literal value
Text Diagram — Keyword Recognition
Java Source Code
       ↓
Lexical Analysis
       ↓
Compiler Identifies Keywords
       ↓
Syntax Validation
       ↓
Bytecode Generation
What are Expressions in Java?
Definition

An expression is a combination of:

Variables
Values
Operators
Method calls

that produces a final result.

Simple Expression Example
10 + 20

Result:

30
Expression Components
Operand + Operator = Expression

Example:

a + b
Part	Meaning
a	Operand
+	Operator
b	Operand
Types of Expressions in Java
1. Arithmetic Expressions

Used for calculations.

Example
int result = 10 + 5 * 2;
Output
20
Internal Working

According to precedence:

Multiplication happens first
Addition happens second
5 * 2 = 10
10 + 10 = 20
Example Program
public class ArithmeticExpression {

    public static void main(String[] args) {

        int result = 10 + 5 * 2;

        System.out.println(result);

    }
}
2. Relational Expressions

Used for comparisons.

Example
int a = 10;
int b = 20;

System.out.println(a < b);
Output
true
3. Logical Expressions

Used for multiple conditions.

Example
int age = 22;

System.out.println(age > 18 && age < 30);
Output
true
4. Assignment Expressions

Assigns values.

Example
int x = 50;
5. Unary Expressions

Works with single operand.

Example
int x = 5;
x++;
Output
6
Expression Evaluation Flow
Example
int result = (10 + 5) * 2;
Internal Execution
(10 + 5)
     ↓
15 * 2
     ↓
30
Memory Representation of Expressions

Consider:

int a = 10;
int b = 20;
int c = a + b;
Memory Diagram
Stack Memory
----------------
a → 10
b → 20
c → 30
----------------
Expression Evaluation Internally
Read a value
     ↓
Read b value
     ↓
CPU performs addition
     ↓
Store result in c
Keywords vs Expressions

| Feature | Keywords | Expressions |
|---|---|
| Purpose | Language structure | Produces value |
| Defined by | Java language | Programmer |
| Modifiable | No | Yes |
| Example | class, int, if | a + b |

Common Beginner Mistakes
1. Using Keyword as Variable Name

Wrong:

int class = 10;

Reason:
class is reserved.

2. Confusing Expression with Statement

Expression:

a + b

Statement:

int c = a + b;
3. Ignoring Operator Precedence

Wrong assumption:

10 + 5 * 2 = 30

Correct:

10 + (5 * 2)
= 20
Concept Map
Java Syntax
│
├── Keywords
│     ├── int
│     ├── class
│     ├── static
│     ├── if
│     └── return
│
└── Expressions
      ├── Arithmetic
      ├── Logical
      ├── Relational
      ├── Unary
      └── Assignment
Interview Questions
1. What is a keyword in Java?

A reserved word with predefined meaning in Java.

2. Can keywords be used as identifiers?

No.

3. What is an expression?

A combination of operands and operators that produces a value.

4. Difference between expression and statement?

Expression produces value.
Statement performs complete action.

5. What is operator precedence?

The order in which operations are evaluated.

Practice Challenges
Challenge 1

Identify keywords:

public static int sum
Challenge 2

Predict output:

int x = 10 + 2 * 5;
System.out.println(x);
Challenge 3

Create expressions using:

Arithmetic operators
Logical operators
Relational operators
Key Takeaways
Keywords are reserved words in Java.
Expressions produce values.
Keywords define program structure.
Expressions perform calculations and logic.
Operator precedence affects evaluation.
Expressions are evaluated internally by CPU operations.
Understanding expressions improves programming logic.
Conclusion

Keywords and expressions form the backbone of Java programming.

Keywords allow Java to understand:

structure
rules
execution flow

Expressions allow programs to:

calculate
compare
decide
manipulate data

Mastering these concepts helps in writing:

efficient programs
readable code
interview-ready logic
scalable applications

A strong understanding of keywords and expressions makes advanced Java topics much easier to learn later.
