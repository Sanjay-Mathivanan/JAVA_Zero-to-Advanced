# Shopping Cart Application using ArrayList

## Introduction

The **Shopping Cart Application** is a simple console-based Java project that demonstrates how to use the **ArrayList** class to manage a list of shopping items. Users can add, modify, remove, search, and display items through a menu-driven interface.

This project is designed to help beginners understand how **ArrayList** works in real-world applications.

---

# Problem Statement

Develop a menu-driven Shopping Cart application that allows users to:

- Add new items
- Display all items
- Modify existing items
- Remove items
- Search for an item
- Exit the application

The project should use **ArrayList** to store shopping cart items dynamically.

---

# Solution

The application is divided into two classes.

### 1. ShoppingCart

Contains all the business logic for managing the shopping cart.

### 2. Main

Displays the menu, accepts user input, and calls the appropriate methods from the ShoppingCart class.

---

# Project Features

- Add Items
- View Shopping Cart
- Modify Existing Items
- Remove Items
- Search Items
- Menu Driven Program
- Dynamic Storage using ArrayList

---

# Project Structure

```
Collections
│
└── ArrayList
      │
      ├── ShoppingCart.java
      └── Main.java
```

---

# Java Files

## ShoppingCart.java

Responsible for:

- Storing items
- Adding items
- Printing items
- Updating items
- Removing items
- Searching items

---

## Main.java

Responsible for:

- Displaying menu
- Reading user input
- Calling ShoppingCart methods
- Running the application

---

# ArrayList Methods Used

| Method | Purpose |
|----------|----------|
| add() | Add a new item |
| get() | Retrieve an item |
| set() | Update an item |
| remove() | Delete an item |
| indexOf() | Search an item |
| size() | Count total items |
| isEmpty() | Check whether the cart is empty |

---

# Program Flow

```
Start

↓

Display Menu

↓

Read User Choice

↓

Perform Operation

↓

Display Result

↓

Continue Until Exit

↓

End
```

---

# Sample Input

```
===== SHOPPING CART MENU =====

2

Laptop

2

Mouse

1

5

Laptop

4

2

1

6
```

---

# Sample Output

```
Laptop added successfully.

Mouse added successfully.

There are 2 items in your cart.

1. Laptop

2. Mouse

Laptop found in cart.

Mouse removed successfully.

There are 1 items in your cart.

1. Laptop

Exiting Shopping Cart...
```

---

# Explanation

### addItem()

Adds a new product into the shopping cart using the `add()` method of ArrayList.

---

### printItems()

Displays every item stored in the shopping cart. If the cart is empty, an appropriate message is displayed.

---

### modifyItem()

Updates an existing item using the `set()` method.

---

### removeItem()

Deletes an item from the shopping cart using the `remove()` method.

---

### searchItem()

Searches for an item using the `indexOf()` method. If found, the item is returned; otherwise, `null` is returned.

---

# Concepts Used

- Java Classes
- Objects
- Methods
- Encapsulation
- ArrayList
- List Interface
- Loops
- Conditional Statements
- Switch Statement
- Scanner Class
- Method Calling

---

# Challenges Faced

- Managing user input correctly.
- Validating item positions before updating or removing.
- Displaying meaningful error messages for invalid operations.
- Handling an empty shopping cart.

---

# Possible Improvements

- Store item quantity.
- Store item price.
- Calculate total bill.
- Save cart data into a file or database.
- Develop a GUI version using Java Swing or JavaFX.
- Connect the application with MySQL.

---

# Interview Questions

### Beginner

1. Why is ArrayList used in this project?
2. Which ArrayList methods are used?
3. What is the purpose of `size()`?
4. Why is `indexOf()` used?

### Intermediate

5. What is the difference between `remove(index)` and `remove(Object)`?
6. Why is `ArrayList` preferred over an array?
7. What happens if an invalid index is provided?

### Advanced

8. How can this project be converted into a database application?
9. Which OOP principles are used?
10. How would you implement this project using LinkedList instead of ArrayList?

---

# Learning Outcomes

After completing this project, you will be able to:

- Use ArrayList in a real-world application.
- Perform CRUD (Create, Read, Update, Delete) operations.
- Build a menu-driven Java application.
- Apply object-oriented programming concepts.
- Organize code into multiple classes.

---

# Conclusion

This Shopping Cart Application is a beginner-friendly project that demonstrates the practical use of the **ArrayList** class in Java. It combines Java collections, object-oriented programming, loops, methods, and user interaction to build a simple yet useful application. It also serves as a strong foundation for developing larger applications such as inventory systems, billing software, and e-commerce platforms.
