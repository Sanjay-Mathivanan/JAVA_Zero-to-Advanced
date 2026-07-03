# Advanced OOP Project

# Financial Order Matching System

---

# Problem Statement

A stock trading platform receives thousands of buy and sell orders every second.

Different order types require different execution strategies:

```text
Market Order
Limit Order
Stop Loss Order
```

The system must:

```text
1. Dynamically execute orders
2. Protect critical account balances
3. Support future order types
4. Avoid modifying existing engine code
```

This project combines:

```text
Encapsulation
+
Inheritance
+
Runtime Polymorphism
```

to create a scalable and secure financial execution engine.

---

# Real World Example

Trading Applications:

```text
NSE
BSE
Zerodha
Upstox
Groww
Robinhood
```

all process multiple order types.

Example:

```text
User Places Order
        │
        ▼

Execution Engine
        │
 ┌──────┼────────┐
 ▼      ▼        ▼

Market Limit StopLoss
```

The engine should not care about:

```text
Order Type
```

It should simply execute the order.

---

# OOP Concepts Used

## Encapsulation

Protect:

```text
Account Balance
Available Funds
```

from direct modification.

---

## Inheritance

All order types inherit:

```text
Order
```

---

## Runtime Polymorphism

Execution engine uses:

```java
Order reference
```

and dynamically executes the correct order strategy.

---

# System Design

## Class Diagram

```text
                    Order
        ---------------------------------
        - orderId
        - quantity
        - price
        ---------------------------------
        + execute()
        ---------------------------------

                    ▲
                    │

      ┌─────────────┼─────────────┐
      │             │             │
      ▼             ▼             ▼

 MarketOrder   LimitOrder   StopLossOrder
```

---

## Account System

```text
TradingAccount
--------------------------------

private balance

getBalance()

deposit()

withdraw()

--------------------------------
```

---

# Step 1

## Trading Account

This class demonstrates:

```text
Encapsulation
```

---

```java
class TradingAccount {

    private double balance;

    public TradingAccount(
            double balance) {

        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }

    public void deposit(
            double amount) {

        if(amount > 0) {

            balance += amount;
        }
    }

    public boolean withdraw(
            double amount) {

        if(amount <= balance) {

            balance -= amount;

            return true;
        }

        return false;
    }
}
```

---

# Why Encapsulation?

Without Encapsulation:

```java
account.balance = -500000;
```

Dangerous.

---

Now:

```java
private balance
```

cannot be modified directly.

Only:

```java
deposit()

withdraw()
```

can change balance.

---

# Step 2

## Parent Order Class

```java
abstract class Order {

    protected int orderId;
    protected int quantity;
    protected double price;

    public Order(
            int orderId,
            int quantity,
            double price) {

        this.orderId = orderId;
        this.quantity = quantity;
        this.price = price;
    }

    public abstract void execute(
            TradingAccount account);
}
```

---

# Why Abstract?

Every order must provide its own:

```java
execute()
```

logic.

---

# Step 3

## Market Order

```java
class MarketOrder
        extends Order {

    public MarketOrder(
            int id,
            int qty,
            double price) {

        super(id, qty, price);
    }

    @Override
    public void execute(
            TradingAccount account) {

        double total =
                quantity * price;

        if(account.withdraw(total)) {

            System.out.println(
                    "Market Order Executed");

        } else {

            System.out.println(
                    "Insufficient Funds");
        }
    }
}
```

---

# Step 4

## Limit Order

```java
class LimitOrder
        extends Order {

    public LimitOrder(
            int id,
            int qty,
            double price) {

        super(id, qty, price);
    }

    @Override
    public void execute(
            TradingAccount account) {

        double total =
                quantity * price;

        if(account.withdraw(total)) {

            System.out.println(
                    "Limit Order Executed");

        } else {

            System.out.println(
                    "Insufficient Funds");
        }
    }
}
```

---

# Step 5

## Stop Loss Order

```java
class StopLossOrder
        extends Order {

    public StopLossOrder(
            int id,
            int qty,
            double price) {

        super(id, qty, price);
    }

    @Override
    public void execute(
            TradingAccount account) {

        double total =
                quantity * price;

        if(account.withdraw(total)) {

            System.out.println(
                    "Stop Loss Triggered");

        } else {

            System.out.println(
                    "Insufficient Funds");
        }
    }
}
```

---

# Step 6

## Execution Engine

This is where Runtime Polymorphism happens.

```java
class ExecutionEngine {

    public void processOrder(
            Order order,
            TradingAccount account) {

        order.execute(account);
    }
}
```

Notice:

```text
Engine Knows Only Order
```

Not:

```text
MarketOrder

LimitOrder

StopLossOrder
```

---

# Step 7

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        TradingAccount account =
                new TradingAccount(
                        100000);

        ExecutionEngine engine =
                new ExecutionEngine();

        Order market =
                new MarketOrder(
                        101,
                        10,
                        1000);

        Order limit =
                new LimitOrder(
                        102,
                        5,
                        2000);

        Order stop =
                new StopLossOrder(
                        103,
                        2,
                        5000);

        engine.processOrder(
                market,
                account);

        engine.processOrder(
                limit,
                account);

        engine.processOrder(
                stop,
                account);

        System.out.println(
                "Remaining Balance : "
                + account.getBalance());
    }
}
```

---

# Output

```text
Market Order Executed

Limit Order Executed

Stop Loss Triggered

Remaining Balance : 70000.0
```

---

# Step-by-Step Execution

Initial Balance:

```text
100000
```

---

## Market Order

```text
10 × 1000

= 10000
```

Balance:

```text
90000
```

---

## Limit Order

```text
5 × 2000

= 10000
```

Balance:

```text
80000
```

---

## Stop Loss

```text
2 × 5000

= 10000
```

Balance:

```text
70000
```

---

# Runtime Polymorphism

Look at:

```java
Order market =
        new MarketOrder(...);
```

Reference:

```text
Order
```

Object:

```text
MarketOrder
```

---

Engine:

```java
processOrder(order)
```

calls:

```java
order.execute()
```

Java decides at runtime:

```text
MarketOrder.execute()

LimitOrder.execute()

StopLossOrder.execute()
```

---

# Internal Flow

```text
Order Placed
      │
      ▼

Execution Engine
      │
      ▼

Order Reference
      │
      ▼

Actual Object Type
      │
      ▼

Execute Correct Strategy
```

---

# Memory Representation

```text
Order Reference
       │
       ▼

MarketOrder Object

----------------

execute()

----------------
```

---

# Adding New Order Type

Suppose tomorrow we add:

```text
Iceberg Order
```

Create:

```java
class IcebergOrder
        extends Order {

    @Override
    public void execute(
            TradingAccount account) {

        System.out.println(
                "Iceberg Executed");
    }
}
```

No changes needed inside:

```java
ExecutionEngine
```

This demonstrates:

```text
Open Closed Principle
```

---

# Where Each OOP Concept Is Used?

## Encapsulation

```java
private double balance;
```

Protects account balance.

---

## Inheritance

```java
MarketOrder
extends Order

LimitOrder
extends Order

StopLossOrder
extends Order
```

Reuses common order data.

---

## Runtime Polymorphism

```java
Order order =
        new MarketOrder();
```

Execution determined during runtime.

---

# Interview Questions

## Why is balance private?

To prevent unauthorized modifications.

---

## Why use an abstract Order class?

To enforce a common execution contract.

---

## Why does ExecutionEngine use Order reference?

To support all order types.

---

## What principle allows adding new order types without modifying the engine?

```text
Open Closed Principle
```

---

## Which OOP concepts are demonstrated?

```text
Encapsulation

Inheritance

Runtime Polymorphism
```

---

# Practice Challenges

## Challenge 1

Add:

```text
Iceberg Order
```

---

## Challenge 2

Add:

```text
Trailing Stop Order
```

---

## Challenge 3

Add:

```text
Trading Fee
```

for every execution.

---

## Challenge 4

Prevent execution if:

```text
Balance < Required Amount
```

---

## Challenge 5

Store execution history in an ArrayList.

---

# Concept Map

```text
Trading Account
       │
       ▼
Encapsulation
       │
       ▼
Private Balance

       │

       ▼

Order
       │
       ▼
Inheritance
       │
 ┌─────┼─────┐
 ▼     ▼     ▼

Market Limit StopLoss

       │
       ▼

Runtime Polymorphism

       │
       ▼

Execution Engine

       │
       ▼

Dynamic Method Dispatch
```

---

# Key Takeaways

- Encapsulation protects critical financial data.
- Inheritance removes duplicate order logic.
- Runtime Polymorphism allows dynamic order execution.
- The execution engine remains independent of order types.
- New order types can be added without changing existing code.
- This architecture resembles real-world trading systems.

---

# Conclusion

This Financial Order Matching System demonstrates how Encapsulation, Inheritance, and Runtime Polymorphism work together in enterprise software. Sensitive balance information is protected through encapsulation, common order behavior is shared through inheritance, and dynamic execution strategies are achieved through runtime polymorphism. This design is scalable, secure, and closely resembles the architecture used in professional trading and financial platforms.
