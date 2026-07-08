# Student Record Management System

## Introduction

The **Student Record Management System** is a simple Java console application that demonstrates how to use a **HashMap** to manage student records efficiently.

Each student is identified by a unique **Student ID**, which acts as the key in the `HashMap`, while the corresponding `Student` object is stored as the value.

This project shows why `HashMap` is the preferred collection when data needs to be searched quickly using a unique key.

---

# Problem Statement

Develop a menu-driven application to manage student records.

The application should allow users to:

* Add a new student
* Search a student using Student ID
* Update student details
* Delete a student
* Display all students
* Count the total number of students
* Check whether a student exists

---

# Solution

The project uses:

* **HashMap<Integer, Student>** to store records.
* **Student ID** as the unique key.
* **Student object** as the value.

```text
HashMap

101 ─────► Student Object

102 ─────► Student Object

103 ─────► Student Object
```

Searching, updating, and deleting records become very fast because the Student ID is used as the key.

---

# Project Features

* Menu-driven application
* Add student
* Search student
* Update student
* Delete student
* Display all students
* Count total students
* Check student existence
* Uses OOP principles
* Demonstrates practical use of HashMap

---

# Project Structure

```text
01_Student_Record_Management_System/

├── Student.java
├── StudentManager.java
├── Main.java
└── README.md
```

---

# Java Files

## Student.java

Represents a single student.

Stores:

* Student ID
* Name
* Age
* Department
* Marks

---

## StudentManager.java

Contains the business logic.

Responsible for:

* Managing the `HashMap`
* Adding students
* Searching students
* Updating records
* Removing records
* Displaying records

---

## Main.java

Acts as the entry point.

Responsible for:

* Displaying the menu
* Reading user input
* Calling methods from `StudentManager`

---

# HashMap Methods Used

| Method          | Purpose                        |
| --------------- | ------------------------------ |
| `put()`         | Add a student                  |
| `get()`         | Search a student               |
| `containsKey()` | Check whether a student exists |
| `remove()`      | Delete a student               |
| `entrySet()`    | Display all students           |
| `size()`        | Count total students           |
| `isEmpty()`     | Check if records exist         |

---

# Program Flow

```text
Start
   │
   ▼
Create StudentManager
   │
   ▼
Create HashMap
   │
   ▼
Display Menu
   │
   ▼
Read User Choice
   │
   ▼
Perform Operation
   │
   ▼
Repeat Until Exit
```

---

# Sample Input

```text
Choice : 1

Student ID : 101

Name : Sanjay

Age : 20

Department : AI & DS

Marks : 91.5
```

---

# Sample Output

```text
Student added successfully.
```

---

Display Student

```text
Student ID : 101
Name       : Sanjay
Age        : 20
Department : AI & DS
Marks      : 91.5
```

---

Search Student

```text
Enter Student ID : 101

Student Found
```

---

Delete Student

```text
Student deleted successfully.
```

---

# Method Explanation

## addStudent()

Adds a new student to the `HashMap`.

---

## searchStudent()

Searches for a student using the Student ID.

---

## updateStudent()

Updates the details of an existing student.

---

## deleteStudent()

Removes a student from the `HashMap`.

---

## displayStudents()

Displays every student using `entrySet()`.

---

## totalStudents()

Displays the total number of students using `size()`.

---

## checkStudent()

Checks whether a Student ID exists using `containsKey()`.

---

# Java Concepts Used

* Classes and Objects
* Encapsulation
* Constructors
* Method Overloading (if extended)
* HashMap
* Map Interface
* Generics
* Collections Framework
* Enhanced For Loop
* `Map.Entry`
* Menu-Driven Programming

---

# Challenges Faced

* Preventing duplicate Student IDs.
* Organizing the code using OOP.
* Separating user interface and business logic.
* Choosing the correct HashMap methods.
* Displaying records in a readable format.

---

# Possible Improvements

* Store data in a file or database.
* Add input validation.
* Sort students by name or marks.
* Search by department.
* Add GPA calculation.
* Export records to CSV.
* Build a JavaFX or Swing GUI.
* Develop a REST API version using Spring Boot.

---

# Interview Questions

1. Why is HashMap used in this project?
2. Why is Student ID chosen as the key?
3. Why is searching faster in a HashMap than in a List?
4. Which HashMap methods are used?
5. Why is `entrySet()` preferred for displaying all records?
6. What happens if the same Student ID is added again?
7. Why is the `Map` interface used instead of the `HashMap` class?
8. How would you make this application persistent?
9. How can this project be improved for large datasets?
10. Which collection would you choose if insertion order needed to be preserved?

---

# Learning Outcomes

After completing this project, you will understand how to:

* Use a `HashMap` in a real-world application.
* Store objects as values in a `HashMap`.
* Perform CRUD operations efficiently.
* Organize code using OOP principles.
* Build a menu-driven Java application.
* Apply the `Map` interface effectively.

---

# Conclusion

This project demonstrates the practical use of a **HashMap** for managing student records. By using the Student ID as the key and a `Student` object as the value, the application performs fast search, update, and delete operations while keeping the code modular and easy to maintain. It provides a solid foundation for building larger Java applications that require efficient key-based data management.
