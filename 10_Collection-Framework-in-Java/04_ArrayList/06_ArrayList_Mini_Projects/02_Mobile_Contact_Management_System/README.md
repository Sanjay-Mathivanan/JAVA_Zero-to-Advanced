# Mobile Contact Management System using ArrayList

## Introduction

The **Mobile Contact Management System** is a simple console-based Java application that demonstrates the practical use of the **ArrayList** class. It allows users to store and manage contact names using a menu-driven interface.

This project helps beginners understand how **ArrayList** can be used to perform CRUD (Create, Read, Update, Delete) operations in a real-world application.

---

# Problem Statement

Develop a console-based Mobile Contact Management System that allows users to:

- Add a new contact
- Display all contacts
- Modify an existing contact
- Remove a contact
- Search for a contact
- Exit the application

The application should use **ArrayList** to store contact names dynamically.

---

# Solution

The project is divided into two Java classes.

### MobilePhone.java

Contains all the business logic for managing contacts using an ArrayList.

### Main.java

Displays the menu, accepts user input, and calls the appropriate methods from the MobilePhone class.

---

# Project Features

- Add Contact
- Display Contact List
- Modify Contact
- Remove Contact
- Search Contact
- Menu Driven Application
- Dynamic Data Storage using ArrayList

---

# Project Structure

```
Collections
│
└── ArrayList
      │
      ├── MobilePhone.java
      └── Main.java
```

---

# Java Files

## MobilePhone.java

Responsible for:

- Storing contact names
- Adding contacts
- Displaying contacts
- Updating contacts
- Removing contacts
- Searching contacts

---

## Main.java

Responsible for:

- Displaying the menu
- Reading user input
- Calling methods from MobilePhone
- Running the application

---

# ArrayList Methods Used

| Method | Purpose |
|----------|----------|
| add() | Add a new contact |
| get() | Retrieve a contact |
| set() | Modify a contact |
| remove() | Delete a contact |
| indexOf() | Search a contact |
| size() | Count total contacts |
| isEmpty() | Check whether the contact list is empty |

---

# Program Flow

```
Start

↓

Display Menu

↓

Read User Choice

↓

Perform Selected Operation

↓

Display Result

↓

Repeat Until Exit

↓

End
```

---

# Sample Input

```
===== MOBILE CONTACT MENU =====

2

Rahul

2

Arun

2

Priya

1

5

Arun

3

2

Karthik

1

4

1

1

6
```

---

# Sample Output

```
Rahul added successfully.

Arun added successfully.

Priya added successfully.

----- Contact List -----

1. Rahul
2. Arun
3. Priya

Arun found in contacts.

Arun updated to Karthik

----- Contact List -----

1. Rahul
2. Karthik
3. Priya

Rahul removed successfully.

----- Contact List -----

1. Karthik
2. Priya

Exiting Mobile Contact Management System...
```

---

# Method Explanation

### addName()

Adds a new contact to the ArrayList using the `add()` method.

---

### printName()

Displays all contacts stored in the ArrayList. If the list is empty, an appropriate message is displayed.

---

### modifyItem()

Updates an existing contact using the `set()` method.

---

### removeItem()

Deletes a contact from the ArrayList using the `remove()` method.

---

### searchItem()

Searches for a contact using the `indexOf()` method. If the contact exists, it is returned; otherwise, `null` is returned.

---

# Java Concepts Used

- Classes and Objects
- Encapsulation
- Methods
- ArrayList
- List Interface
- Loops
- Switch Statement
- Conditional Statements
- Scanner Class
- User Input Handling

---

# Challenges Faced

- Validating contact positions before updating or removing.
- Handling an empty contact list.
- Accepting user input correctly using the Scanner class.
- Displaying meaningful messages for invalid operations.

---

# Possible Improvements

- Store contact numbers along with names.
- Store email addresses.
- Prevent duplicate contacts.
- Sort contacts alphabetically.
- Save contacts to a file.
- Connect the application to a MySQL database.
- Build a graphical user interface using Java Swing or JavaFX.

---

# Interview Questions

### Beginner

1. Why is ArrayList used in this project?
2. Which ArrayList methods are used?
3. What is the purpose of the `size()` method?
4. Why is `indexOf()` used?

### Intermediate

5. What is the difference between `remove(index)` and `remove(Object)`?
6. Why is ArrayList preferred over an array?
7. How does the `set()` method work?

### Advanced

8. How would you prevent duplicate contacts?
9. How can this project be connected to a database?
10. Which OOP concepts are used in this project?
11. How would you sort contacts alphabetically?
12. How would you modify this project to store both contact names and phone numbers?

---

# Learning Outcomes

After completing this project, you will be able to:

- Create a menu-driven Java application.
- Perform CRUD operations using ArrayList.
- Apply Object-Oriented Programming concepts.
- Handle user input using the Scanner class.
- Organize a Java project into multiple classes.
- Build simple real-world console applications.

---

# Conclusion

The **Mobile Contact Management System** is a beginner-friendly Java project that demonstrates the practical use of the **ArrayList** class for managing dynamic data. It combines Java Collections, Object-Oriented Programming, loops, methods, and user interaction to create a simple contact management application. This project provides a strong foundation for developing advanced applications such as phone books, employee directories, customer management systems, and database-driven contact applications.
