# Bank Management System using ArrayList

## Introduction

The **Bank Management System** is a console-based Java application developed using the **ArrayList** class. It demonstrates how multiple classes can work together to manage bank branches, customers, and their transactions using Object-Oriented Programming concepts.

This project is an excellent example of using **nested ArrayLists**, where:

- A Bank contains multiple Branches.
- Each Branch contains multiple Customers.
- Each Customer maintains multiple Transactions.

---

# Problem Statement

Design a Bank Management System that allows users to:

- Create new bank branches.
- Add customers to a branch.
- Record customer transactions.
- Display all customers in a branch.
- Display transaction history of customers.

The application should use **ArrayList** for dynamic data storage.

---

# Solution

The project is divided into four classes.

### Customer.java

Stores customer information and transaction history.

### Branch.java

Stores customers belonging to a particular branch.

### Bank.java

Stores all bank branches and manages banking operations.

### Main.java

Creates objects and demonstrates the working of the application.

---

# Project Features

- Add Bank Branch
- Add Customer
- Record Customer Transactions
- Search Customer
- Display Customer List
- Display Transaction History
- Dynamic Data Storage using ArrayList
- Object-Oriented Design

---

# Project Structure

```
Bank
│
├── Branch
│      │
│      ├── Customer
│      │      │
│      │      └── Transactions
│      │
│      └── Customer
│
└── Main
```

---

# Java Files

## Customer.java

Responsible for:

- Storing customer name
- Storing transaction history
- Adding new transactions

---

## Branch.java

Responsible for:

- Creating new customers
- Searching customers
- Adding customer transactions
- Returning customer list

---

## Bank.java

Responsible for:

- Creating branches
- Searching branches
- Adding customers
- Recording transactions
- Displaying customer details

---

## Main.java

Responsible for:

- Creating Bank object
- Creating Branches
- Adding Customers
- Recording Transactions
- Displaying Output

---

# ArrayList Methods Used

| Method | Purpose |
|---------|---------|
| add() | Add Branch, Customer, Transaction |
| get() | Retrieve Transaction |
| size() | Count Customers/Transactions |
| contains() | Check Existing Data (conceptually) |
| isEmpty() | Check Empty List |
| indexOf() | Search Elements |
| for-each Loop | Traverse ArrayList |

---

# Program Flow

```
Start

↓

Create Bank

↓

Add Branch

↓

Add Customer

↓

Add Transaction

↓

Display Customer Details

↓

Display Transactions

↓

End
```

---

# Sample Output

```
Customers of Coimbatore

Sanjay

Transactions:

1000.0

500.0

700.0

Arun

Transactions:

2000.0

1000.0
```

---

# Class Relationship

```
Bank

│

├── Branch 1

│      ├── Customer 1

│      │       ├── Transaction

│      │       ├── Transaction

│      │       └── Transaction

│      │

│      └── Customer 2

│

└── Branch 2
```

---

# Method Explanation

## Customer Class

### addTransaction()

Adds a new transaction amount to the customer's transaction history.

---

### getTransactions()

Returns all transaction records of a customer.

---

### getName()

Returns the customer name.

---

## Branch Class

### newCustomer()

Creates a new customer if the customer does not already exist.

---

### addCustomerTransaction()

Adds a transaction to an existing customer.

---

### findCustomer()

Searches for a customer using the customer name.

---

## Bank Class

### addBranch()

Creates a new branch.

---

### addCustomer()

Adds a customer to a branch.

---

### addCustomerTransaction()

Records a transaction for a customer.

---

### listCustomers()

Displays customer details.

If

```java
true
```

is passed,

transaction history is also displayed.

---

# Java Concepts Used

- Classes and Objects
- Encapsulation
- Constructors
- Methods
- ArrayList
- Nested ArrayLists
- Composition
- Object References
- Loops
- Conditional Statements
- for-each Loop

---

# Challenges Faced

- Managing multiple ArrayLists.
- Connecting Bank, Branch, and Customer classes.
- Preventing duplicate branches.
- Preventing duplicate customers.
- Managing transaction history.
- Traversing nested collections.

---

# Possible Improvements

- Deposit and Withdrawal operations.
- Customer Account Number.
- Balance Calculation.
- Interest Calculation.
- Delete Customer.
- Delete Branch.
- Search Branch.
- File Handling.
- Database Connectivity using MySQL.
- GUI using Java Swing or JavaFX.

---

# Interview Questions

## Beginner

1. Why is ArrayList used in this project?
2. Why are multiple classes created?
3. Which class stores transactions?
4. What is the purpose of the Customer class?

---

## Intermediate

5. Why is an ArrayList used inside another ArrayList?
6. Explain the relationship between Bank, Branch, and Customer.
7. Why is the `findCustomer()` method needed?
8. What happens if a branch is not found?

---

## Advanced

9. Which OOP principle is used in this project?
10. Explain Composition with this project.
11. How would you store account numbers?
12. How would you connect this project to MySQL?
13. How would you calculate account balance automatically?
14. How would you improve the performance if there are one million customers?

---

# Learning Outcomes

After completing this project, you will be able to:

- Build a multi-class Java application.
- Use nested ArrayLists effectively.
- Apply Object-Oriented Programming concepts.
- Manage relationships between classes.
- Implement real-world banking operations.
- Traverse complex data structures.

---

# Conclusion

The **Bank Management System** demonstrates the practical use of **ArrayList** in a real-world application. It combines Object-Oriented Programming concepts such as **Encapsulation**, **Composition**, and **Object Interaction** with Java Collections to manage branches, customers, and transactions efficiently. This project provides a strong foundation for developing advanced banking applications, financial systems, and enterprise-level Java applications.
