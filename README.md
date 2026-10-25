# JapanTrip Transport Planner: Strategy Pattern Assignment 5 

**Course:** Software Design Patterns
**Assignment #5:** Strategy behavioral design pattern

## 1. Project idea
When travelling around Japan, a tourist can go from one city to another in many ways:
Shinkansen, local train, highway bus, rental car, domestic flight or night bus.
Each way has its own algorithm for calculating **cost (JPY)** and **travel time (hours)**.
The traveller chooses the transport at runtime, so the algorithm must be interchangeable.
This is exactly the problem the **Strategy** pattern solves.

## 2. Pattern components
| Component | Class | Role |
|---|---|---|
| Strategy interface | `TransportStrategy` | Declares `getName()`, `calculateCost(Route)`, `calculateDurationHours(Route)` |
| Concrete strategies | `ShinkansenStrategy`, `LocalTrainStrategy`, `HighwayBusStrategy`, `RentalCarStrategy`, `DomesticFlightStrategy`, `NightBusStrategy` | Each encapsulates one algorithm variant |
| Context | `TripPlanner` | Holds a `TransportStrategy`, delegates to it, supports `setTransport()` for runtime switching |
| Client | `Main` | Creates strategies, puts them in a `Map`, selects and switches them |
| Data object | `Route` | Immutable: from, to, distance in km |

## 3. UML diagram
```
+------------------+   uses   +-----------------------------+
|   TripPlanner    |--------->|   <<interface>>             |
|   (Context)      |          |   TransportStrategy         |
|------------------|          |-----------------------------|
| - transport      |          | + getName()                 |
| + setTransport() |          | + calculateCost(Route)      |
| + cost(Route)    |          | + calculateDurationHours()  |
| + durationHours()|          +--------------^--------------+
+------------------+                         |
        +---------------+---------------+----+----------+---------------+--------------+
        |               |               |               |               |              |
 ShinkansenStrategy LocalTrain   HighwayBus     RentalCar     DomesticFlight    NightBus
                    Strategy     Strategy       Strategy      Strategy          Strategy
```

## 4. How to run
**IntelliJ IDEA:** open the project, open `Main.java`, press Run.

**Command line** (from the folder with the `.java` files):
```
mkdir out
javac -d out *.java
java -cp out Main
```
Requires JDK 17 or newer (developed on JDK 21).

## 5. Example output
```
=== Tokyo -> Kyoto (450 km) ===
Shinkansen (bullet train)              9900 JPY    2.0 h
Local train                            5400 JPY    7.5 h
Highway bus                            3600 JPY    6.4 h
Rental car                            25000 JPY    6.0 h
Domestic flight                       14400 JPY    3.6 h
Night bus                              2700 JPY    6.9 h

=== Kyoto -> Osaka (45 km) ===
Shinkansen (bullet train)               990 JPY    0.2 h
Local train                             540 JPY    0.8 h
Highway bus                             360 JPY    0.6 h
Rental car                             8800 JPY    0.6 h
Domestic flight                    not available: No flights for distances shorter than 300 km
Night bus                               270 JPY    0.7 h
```

## 6. Clean Code principles applied
1. **Polymorphism instead of conditional logic.**
   `TripPlanner` never checks which transport is used. It simply calls
   `transport.calculateCost(route)`. The client selects strategies through a `Map`, so there is
   no `if`/`switch` on the strategy type anywhere in the project.
2. **Meaningful, intention-revealing names.**
   Classes are named after what they do (`ShinkansenStrategy`, `RentalCarStrategy`), constants
   explain themselves (`HOURS_PER_RENTAL_DAY`, `AIRPORT_OVERHEAD_HOURS`), and helper methods
   state intent (`requireFlightWorthDistance`).
3. **Single Responsibility Principle.**
   Each strategy performs exactly one algorithm. `Route` only stores data, `TripPlanner` only
   delegates, `Main` only wires objects together and prints results.
4. **Context is algorithm-agnostic (Dependency Inversion).**
   `TripPlanner` depends only on the `TransportStrategy` abstraction and knows nothing about
   the internals of concrete strategies.
5. **Open/Closed Principle, easy extensibility.**
   `NightBusStrategy` was added after the other strategies. It required one new class and one
   line in `Main`. The interface, the Context and the existing strategies were **not modified**.
6. **No magic numbers.**
   All prices, speeds and limits are `private static final` constants with descriptive names.
7. **Fail fast and input validation.**
   `Route` rejects empty city names and non-positive distances, `TripPlanner` rejects a `null`
   strategy, and `DomesticFlightStrategy` explicitly refuses routes where flights make no sense.
8. **Small, focused methods and immutability.**
   Every method does one thing and is short. `Route` is immutable, so strategies cannot corrupt
   shared data.

## 7. How to add a new strategy
1. Create a class that implements `TransportStrategy`, for example `FerryStrategy`.
2. Implement `getName()`, `calculateCost()` and `calculateDurationHours()`.
3. Register it in `Main`: `transports.put("ferry", new FerryStrategy());`

No other class has to change.
