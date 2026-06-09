# Advanced Polymorphism Program in Java

# E-Commerce Notification System

---

# Problem Statement

An e-commerce company wants to send notifications to customers through multiple communication channels.

Currently supported channels:

```text
Email
SMS
Push Notification
```

Future channels may include:

```text
WhatsApp
Slack
Telegram
Microsoft Teams
```

The company wants a system where:

```text
New notification channels
can be added

WITHOUT

changing the existing
notification delivery engine.
```

This is one of the most common real-world uses of:

```text
Runtime Polymorphism
```

---

# Real-World Scenario

When a customer places an order:

```text
Order Placed
      │
      ▼
Notification System
      │
      ├── Email
      ├── SMS
      └── Push Notification
```

The delivery engine should not care about:

```text
Which notification channel
is being used.
```

It should simply call:

```java
sendNotification()
```

and let Java decide which implementation to execute.

---

# OOP Concepts Used

This project demonstrates:

```text
Inheritance
       +
Method Overriding
       +
Runtime Polymorphism
       +
Loose Coupling
```

---

# System Design

## Class Diagram

```text
                    Notification
            --------------------------
            + sendNotification()
            --------------------------

                     ▲
                     │

      ┌──────────────┼──────────────┐
      │              │              │
      ▼              ▼              ▼

 EmailNotification  SMSNotification  PushNotification
```

---

# Why Use Polymorphism?

Without polymorphism:

```java
if(type.equals("EMAIL")) {
   ...
}

else if(type.equals("SMS")) {
   ...
}

else if(type.equals("PUSH")) {
   ...
}
```

Problem:

Whenever a new channel is added:

```text
Modify Existing Code
```

This violates:

```text
Open Closed Principle
```

---

# Solution

Use Runtime Polymorphism.

The delivery engine works with:

```java
Notification
```

reference only.

---

# Step 1: Parent Class

```java
class Notification {

    public void sendNotification() {

        System.out.println(
                "Sending Notification");
    }
}
```

---

# Step 2: Email Notification

```java
class EmailNotification
        extends Notification {

    @Override
    public void sendNotification() {

        System.out.println(
                "Sending Email Notification");
    }
}
```

---

# Step 3: SMS Notification

```java
class SMSNotification
        extends Notification {

    @Override
    public void sendNotification() {

        System.out.println(
                "Sending SMS Notification");
    }
}
```

---

# Step 4: Push Notification

```java
class PushNotification
        extends Notification {

    @Override
    public void sendNotification() {

        System.out.println(
                "Sending Push Notification");
    }
}
```

---

# Step 5: Notification Engine

This is the most important class.

```java
class NotificationEngine {

    public void deliver(
            Notification notification) {

        notification.sendNotification();
    }
}
```

Notice:

```text
Engine knows only Notification
```

It doesn't know:

```text
Email

SMS

Push
```

---

# Step 6: Main Class

```java
public class Main {

    public static void main(String[] args) {

        NotificationEngine engine =
                new NotificationEngine();

        Notification email =
                new EmailNotification();

        Notification sms =
                new SMSNotification();

        Notification push =
                new PushNotification();

        engine.deliver(email);

        engine.deliver(sms);

        engine.deliver(push);
    }
}
```

---

# Output

```text
Sending Email Notification

Sending SMS Notification

Sending Push Notification
```

---

# Understanding Runtime Polymorphism

Consider:

```java
Notification email =
        new EmailNotification();
```

Reference Type:

```text
Notification
```

Actual Object:

```text
EmailNotification
```

---

When:

```java
email.sendNotification();
```

Java checks:

```text
Actual Object Type
```

and executes:

```java
EmailNotification.sendNotification()
```

---

# Internal Working

```text
Notification Reference
           │
           ▼

 EmailNotification Object

           │
           ▼

sendNotification()

           │
           ▼

EmailNotification Method Executes
```

---

# Memory Representation

```text
Notification email
        │
        ▼

EmailNotification Object
-----------------------

sendNotification()

-----------------------
```

---

# Adding a New Channel

Suppose management asks for:

```text
WhatsApp Notifications
```

---

# New Class

```java
class WhatsAppNotification
        extends Notification {

    @Override
    public void sendNotification() {

        System.out.println(
                "Sending WhatsApp Notification");
    }
}
```

---

# Main Method

```java
Notification whatsapp =
        new WhatsAppNotification();

engine.deliver(whatsapp);
```

---

# Output

```text
Sending WhatsApp Notification
```

---

# What Changed?

Only:

```text
Added New Class
```

No modification inside:

```java
NotificationEngine
```

This is the power of:

```text
Polymorphism
```

---

# Advanced Version

Let's include notification messages.

---

## Parent Class

```java
abstract class Notification {

    protected String message;

    public Notification(
            String message) {

        this.message = message;
    }

    public abstract void sendNotification();
}
```

---

## Email Class

```java
class EmailNotification
        extends Notification {

    public EmailNotification(
            String message) {

        super(message);
    }

    @Override
    public void sendNotification() {

        System.out.println(
                "[EMAIL] "
                + message);
    }
}
```

---

## SMS Class

```java
class SMSNotification
        extends Notification {

    public SMSNotification(
            String message) {

        super(message);
    }

    @Override
    public void sendNotification() {

        System.out.println(
                "[SMS] "
                + message);
    }
}
```

---

## Push Class

```java
class PushNotification
        extends Notification {

    public PushNotification(
            String message) {

        super(message);
    }

    @Override
    public void sendNotification() {

        System.out.println(
                "[PUSH] "
                + message);
    }
}
```

---

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Notification[] notifications = {

            new EmailNotification(
                    "Order Confirmed"),

            new SMSNotification(
                    "Payment Successful"),

            new PushNotification(
                    "Flash Sale Started")
        };

        for(Notification n :
                notifications) {

            n.sendNotification();
        }
    }
}
```

---

# Output

```text
[EMAIL] Order Confirmed

[SMS] Payment Successful

[PUSH] Flash Sale Started
```

---

# Why This Design Is Good?

## Loose Coupling

Notification Engine depends only on:

```java
Notification
```

not concrete classes.

---

## Extensible

Add:

```text
WhatsApp
Slack
Telegram
Teams
```

without changing existing code.

---

## Reusable

Same engine works for all channels.

---

## Maintainable

No large:

```java
if-else
switch
```

blocks.

---

# Interview Questions

## Why is this Runtime Polymorphism?

Because:

```java
Notification ref =
        new EmailNotification();
```

and method selection happens during execution.

---

## Which OOP Concept Makes This Possible?

```text
Method Overriding
```

---

## What Design Principle Is Followed?

```text
Open Closed Principle
```

Open for extension.

Closed for modification.

---

## Why Use Parent References?

To write generic code.

---

## What Happens When a New Channel Is Added?

Only a new child class is created.

No changes to the engine.

---

# Concept Map

```text
Notification
      │
      ▼
Runtime Polymorphism
      │
      ▼
Notification Engine
      │
 ┌────┼─────┬───────┐
 ▼    ▼     ▼       ▼

Email SMS Push WhatsApp
      │
      ▼
Method Overriding
      │
      ▼
Dynamic Method Dispatch
```

---

# Key Takeaways

- Runtime Polymorphism allows one interface to support many implementations.
- Parent references can hold child objects.
- Method execution is decided at runtime.
- Notification Engine remains unchanged when new channels are added.
- This approach creates scalable enterprise applications.
- Real-world systems such as payment gateways, notification systems, and logging frameworks heavily use runtime polymorphism.

---

# Conclusion

This E-Commerce Notification System is a practical example of Runtime Polymorphism in action. By using a common Notification parent class and multiple child implementations, the application remains flexible, maintainable, and extensible. New communication channels can be introduced without modifying the core delivery engine, making the design suitable for real-world enterprise software development.
