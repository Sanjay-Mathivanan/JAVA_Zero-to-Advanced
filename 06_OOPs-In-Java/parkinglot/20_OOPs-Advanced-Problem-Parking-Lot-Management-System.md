# Multi-Level Parking Lot Management System

## Problem Statement

Design and implement a backend system for a Multi-Level Parking Lot using Object-Oriented Programming principles.

The parking lot must support multiple vehicle types:

* Motorcycle
* Car
* Truck

Each vehicle requires different parking spot sizes:

| Vehicle Type | Allowed Parking Spots |
| ------------ | --------------------- |
| Motorcycle   | Small, Medium, Large  |
| Car          | Medium, Large         |
| Truck        | Large Only            |

The system should:

* Allow vehicles to enter and park.
* Validate parking rules.
* Prevent invalid parking allocations.
* Calculate parking fees dynamically.
* Support future vehicle types without modifying existing code.
* Demonstrate real-world usage of OOP concepts.

---

# Business Rules

## Motorcycle

Can park in:

```text
Small Spot
Medium Spot
Large Spot
```

Parking Fee:

```text
₹10 per hour
```

---

## Car

Can park in:

```text
Medium Spot
Large Spot
```

Parking Fee:

```text
₹20 per hour
```

---

## Truck

Can park only in:

```text
Large Spot
```

Parking Fee:

```text
₹50 per hour
```

---

# Objectives

The goal of this project is to demonstrate:

* Encapsulation
* Inheritance
* Abstraction
* Runtime Polymorphism
* Business Rule Enforcement

while building a real-world parking management application.

---

# OOP Concepts Used

## Encapsulation

Sensitive data such as:

```java
vehicleNumber
spotId
occupiedStatus
```

are protected using private variables.

---

## Inheritance

All vehicle types inherit from:

```java
Vehicle
```

Example:

```java
Car extends Vehicle

Truck extends Vehicle

Motorcycle extends Vehicle
```

---

## Abstraction

Every vehicle must define:

```java
canPark()

calculateFee()
```

using abstract methods.

---

## Runtime Polymorphism

The Parking Manager works with:

```java
Vehicle reference
```

and dynamically executes the correct implementation.

Example:

```java
Vehicle vehicle = new Car("TN38AB1234");
```

At runtime Java decides:

```java
calculateFee()

canPark()
```

based on the actual object type.

---

# Program Flow

```text
Vehicle Arrives
       │
       ▼

Parking Manager
       │
       ▼

Check Spot Availability
       │
       ▼

Validate Parking Rules
       │
       ▼

Park Vehicle
       │
       ▼

Calculate Fee
       │
       ▼

Generate Bill
```

---

# Example Execution

## Vehicle Entry

```text
Motorcycle → Small Spot

Car → Medium Spot

Truck → Large Spot
```

---

## Fee Calculation

Parking Duration:

```text
5 Hours
```

Charges:

```text
Motorcycle = 5 × 10 = ₹50

Car = 5 × 20 = ₹100

Truck = 5 × 50 = ₹250
```

---

# Expected Output

```text
TN38BIKE01 Parked Successfully

TN38CAR01 Parked Successfully

TN38TRUCK01 Parked Successfully

TN38BIKE01 Parking Fee : ₹50.0

TN38CAR01 Parking Fee : ₹100.0

TN38TRUCK01 Parking Fee : ₹250.0
```

---

# Business Rule Validation Example

Input:

```text
Truck → Medium Spot
```

Output:

```text
Parking Not Allowed
```

Reason:

```text
Trucks can only park in Large Spots.
```

---

# Project Structure

```text
parkinglot/
│
├── Main.java
├── ParkingManager.java
│
├── vehicles/
│   ├── Vehicle.java
│   ├── Car.java
│   ├── Motorcycle.java
│   └── Truck.java
│
├── parking/
│   ├── ParkingSpot.java
│   └── SpotSize.java
```

---

# Learning Outcomes

After completing this project, you will understand:

* How abstraction simplifies system design.
* How inheritance reduces code duplication.
* How runtime polymorphism enables flexibility.
* How encapsulation protects internal state.
* How real-world systems enforce business rules.
* How to design scalable OOP applications.

---

# Future Enhancements

Possible improvements:

* Multi-Level Parking Floors
* Electric Vehicle Charging Stations
* VIP Parking
* Entry and Exit Time Tracking
* Automatic Billing System
* Online Slot Reservation
* Parking History Management

---

# Key Takeaways

* Abstract classes define common behavior.
* Inheritance promotes code reuse.
* Runtime polymorphism enables dynamic decision making.
* Encapsulation protects important data.
* OOP principles help build maintainable systems.
* The design is extensible and follows industry practices.

---

# Conclusion

The Multi-Level Parking Lot Management System is a practical application of Object-Oriented Programming concepts. By combining Encapsulation, Inheritance, Abstraction, and Runtime Polymorphism, the system becomes scalable, maintainable, and easy to extend. This project closely resembles real-world parking and smart-city management applications and serves as an excellent advanced OOP learning exercise.
