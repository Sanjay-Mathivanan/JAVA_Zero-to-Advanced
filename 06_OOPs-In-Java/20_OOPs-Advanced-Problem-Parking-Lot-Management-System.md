# OOPs Advanced Problem

# Multi-Level Parking Lot Management System

---

# Problem Statement

You are tasked with building the backend of a Multi-Level Parking Lot Management System.

The parking lot must support different vehicle types:

```text
Car
Motorcycle
Truck
```

Each vehicle requires a specific parking space:

```text
Small Spot
Medium Spot
Large Spot
```

Business Rules:

```text
Motorcycle
→ Small, Medium, Large

Car
→ Medium, Large

Truck
→ Large Only
```

The system must:

- Park vehicles.
- Validate parking rules.
- Calculate parking fees.
- Support future vehicle types.
- Prevent invalid parking allocations.

This project combines:

```text
Encapsulation
+
Inheritance
+
Polymorphism
+
Abstraction
```

---

# Real World Example

Applications:

```text
Airport Parking

Shopping Mall Parking

Railway Station Parking

Smart City Parking
```

---

# System Requirements

## Vehicle Types

```text
Motorcycle

Car

Truck
```

---

## Parking Spot Types

```text
Small

Medium

Large
```

---

## Parking Fees

```text
Motorcycle
₹10/hour

Car
₹20/hour

Truck
₹50/hour
```

---

# OOP Concepts Used

## Encapsulation

Protect:

```text
Vehicle Number

Parking Duration

Parking Fee
```

using private variables.

---

## Inheritance

All vehicles inherit from:

```text
Vehicle
```

---

## Runtime Polymorphism

Parking system calculates fees differently for each vehicle.

---

## Abstraction

Every vehicle must implement:

```java
calculateFee()
```

---

# Understanding the Design

## Class Diagram

```text
                   Vehicle
          ------------------------
          vehicleNumber
          calculateFee()
          canPark()
          ------------------------
                    ▲
                    │

     ┌──────────────┼──────────────┐
     │              │              │
     ▼              ▼              ▼

 Motorcycle       Car           Truck
```

---

## Parking Spot

```text
ParkingSpot
--------------------

spotId

spotSize

isOccupied

--------------------
```

---

# Step 1

## Spot Size Enum

Enums make code readable.

```java
enum SpotSize {

    SMALL,
    MEDIUM,
    LARGE
}
```

---

# Why Enum?

Instead of:

```java
"small"
"medium"
"large"
```

Use:

```java
SpotSize.SMALL
```

Safer and professional.

---

# Step 2

## Abstract Vehicle Class

```java
abstract class Vehicle {

    private String vehicleNumber;

    public Vehicle(
            String vehicleNumber) {

        this.vehicleNumber =
                vehicleNumber;
    }

    public String getVehicleNumber() {

        return vehicleNumber;
    }

    public abstract boolean canPark(
            SpotSize size);

    public abstract double calculateFee(
            int hours);
}
```

---

# Why Abstract?

Every vehicle:

```text
Can Park

Can Calculate Fee
```

but implementation differs.

---

# Step 3

## Motorcycle

```java
class Motorcycle
        extends Vehicle {

    public Motorcycle(
            String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return true;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 10;
    }
}
```

---

# Step 4

## Car

```java
class Car
        extends Vehicle {

    public Car(
            String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return size ==
                SpotSize.MEDIUM
                ||
                size ==
                SpotSize.LARGE;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 20;
    }
}
```

---

# Step 5

## Truck

```java
class Truck
        extends Vehicle {

    public Truck(
            String vehicleNumber) {

        super(vehicleNumber);
    }

    @Override
    public boolean canPark(
            SpotSize size) {

        return size ==
                SpotSize.LARGE;
    }

    @Override
    public double calculateFee(
            int hours) {

        return hours * 50;
    }
}
```

---

# Step 6

## Parking Spot Class

```java
class ParkingSpot {

    private int spotId;

    private SpotSize spotSize;

    private boolean occupied;

    public ParkingSpot(
            int spotId,
            SpotSize spotSize) {

        this.spotId = spotId;
        this.spotSize = spotSize;
    }

    public SpotSize getSpotSize() {

        return spotSize;
    }

    public boolean isOccupied() {

        return occupied;
    }

    public void parkVehicle() {

        occupied = true;
    }
}
```

---

# Step 7

## Parking Manager

```java
class ParkingManager {

    public void parkVehicle(
            Vehicle vehicle,
            ParkingSpot spot) {

        if(spot.isOccupied()) {

            System.out.println(
                    "Spot Already Occupied");

            return;
        }

        if(vehicle.canPark(
                spot.getSpotSize())) {

            spot.parkVehicle();

            System.out.println(
                    vehicle.getVehicleNumber()
                    +
                    " Parked Successfully");

        }
        else {

            System.out.println(
                    "Parking Not Allowed");
        }
    }

    public void calculateBill(
            Vehicle vehicle,
            int hours) {

        System.out.println(
                "Fee : ₹"
                +
                vehicle.calculateFee(
                        hours));
    }
}
```

---

# Step 8

## Main Class

```java
public class Main {

    public static void main(String[] args) {

        Vehicle car =
                new Car("TN38AB1234");

        Vehicle bike =
                new Motorcycle(
                        "TN38BIKE01");

        Vehicle truck =
                new Truck(
                        "TN38TRUCK99");

        ParkingSpot small =
                new ParkingSpot(
                        1,
                        SpotSize.SMALL);

        ParkingSpot medium =
                new ParkingSpot(
                        2,
                        SpotSize.MEDIUM);

        ParkingSpot large =
                new ParkingSpot(
                        3,
                        SpotSize.LARGE);

        ParkingManager manager =
                new ParkingManager();

        manager.parkVehicle(
                bike,
                small);

        manager.parkVehicle(
                car,
                medium);

        manager.parkVehicle(
                truck,
                large);

        manager.calculateBill(
                bike,
                5);

        manager.calculateBill(
                car,
                5);

        manager.calculateBill(
                truck,
                5);
    }
}
```

---

# Output

```text
TN38BIKE01 Parked Successfully

TN38AB1234 Parked Successfully

TN38TRUCK99 Parked Successfully

Fee : ₹50.0

Fee : ₹100.0

Fee : ₹250.0
```

---

# Business Rule Validation

Suppose:

```java
Truck truck =
        new Truck("TN99");

manager.parkVehicle(
        truck,
        mediumSpot);
```

---

Truck Rule:

```java
return size ==
        SpotSize.LARGE;
```

Result:

```text
Parking Not Allowed
```

---

# Runtime Polymorphism

Look at:

```java
Vehicle vehicle =
        new Truck(...);
```

Reference:

```text
Vehicle
```

Object:

```text
Truck
```

---

When:

```java
vehicle.calculateFee()
```

Java executes:

```java
Truck.calculateFee()
```

at runtime.

---

# Internal Execution Flow

```text
Vehicle Arrives
        │
        ▼

Parking Manager
        │
        ▼

Check Spot Size
        │
        ▼

Vehicle.canPark()
        │
        ▼

Allowed ?
   │         │
  YES       NO
   │         │
   ▼         ▼

Parked    Rejected
```

---

# Memory Representation

```text
Vehicle Reference
        │
        ▼

Car Object

----------------

vehicleNumber

calculateFee()

canPark()

----------------
```

---

# Advanced Challenge

Add:

```text
Electric Car
```

Rules:

```text
Requires Charging Spot

₹25/hour
```

---

Add:

```text
VIP Parking
```

Rules:

```text
Higher Charges

Reserved Spots
```

---

Add:

```text
Multi-Level Floors

Level 1

Level 2

Level 3
```

---

# Where Each OOP Concept Is Used?

## Encapsulation

```java
private String vehicleNumber;
```

Protects vehicle data.

---

## Inheritance

```java
Car extends Vehicle

Truck extends Vehicle

Motorcycle extends Vehicle
```

---

## Abstraction

```java
abstract calculateFee()

abstract canPark()
```

---

## Runtime Polymorphism

```java
Vehicle vehicle =
        new Car();
```

Different fee calculation at runtime.

---

# Interview Questions

## Why use an Abstract Class?

To enforce common behavior for all vehicles.

---

## Why use Runtime Polymorphism?

To support multiple vehicle types through a single reference.

---

## Why use Encapsulation?

To protect internal vehicle and parking data.

---

## Why use Enum?

To avoid invalid spot size values.

---

## Which OOP concepts are demonstrated?

```text
Encapsulation

Inheritance

Polymorphism

Abstraction
```

---

# Practice Challenges

## Challenge 1

Add:

```text
ElectricCar
```

with charging station support.

---

## Challenge 2

Add:

```text
Bus
```

which requires two large spots.

---

## Challenge 3

Track:

```text
Entry Time

Exit Time
```

Automatically calculate duration.

---

## Challenge 4

Add:

```text
VIP Parking Spots
```

---

## Challenge 5

Create:

```text
Multi-Level Parking
```

with floor management.

---

# Concept Map

```text
Vehicle
     │
     ▼
Abstraction
     │
     ▼
Car Truck Motorcycle
     │
     ▼
Inheritance
     │
     ▼
calculateFee()
canPark()
     │
     ▼
Runtime Polymorphism
     │
     ▼
Parking Manager
     │
     ▼
Spot Allocation
     │
     ▼
Fee Calculation
```

---

# Key Takeaways

- Abstract classes define common vehicle behavior.
- Inheritance removes duplicate code.
- Runtime polymorphism enables dynamic fee calculation.
- Encapsulation protects parking and vehicle data.
- Enums improve type safety.
- The design is extensible and supports future vehicle types.
- This architecture resembles real-world smart parking systems.

---

# Conclusion

The Multi-Level Parking Lot Management System is a practical enterprise-style OOP project that combines Encapsulation, Inheritance, Abstraction, and Polymorphism. The design allows new vehicle types, parking rules, and billing strategies to be added with minimal changes, making it scalable, maintainable, and suitable for real-world software development.
