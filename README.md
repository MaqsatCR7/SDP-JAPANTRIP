# SDP Assignment #4 — Facade Pattern

## Project Overview
This repository contains a Java implementation of the **Facade Structural Design Pattern** applied to a **Japan Trip Booking System (`japantrip`)**.

Planning a trip to Japan involves coordinating multiple independent services such as booking flights to Tokyo, reserving accommodation (hotels/ryokans), issuing a Japan Rail (JR) Pass for transportation, and processing international multi-currency payments. Executing these operations directly from a client application introduces high coupling and complex orchestration logic.

The **Facade Pattern** hides this complexity behind a single simplified interface (`JapanTripFacade`), allowing clients to book an entire trip with a single method call while keeping all underlying subsystem classes decoupled and independently reusable.

---

## Subsystem & Facade Architecture

### Components
1. **Client (`Main`)**: Interacts exclusively with the `JapanTripFacade` without instantiating or invoking any subsystem classes directly.
2. **Facade (`JapanTripFacade`)**: Offers a unified `bookFullJapanTrip(...)` method that orchestrates the execution order and status validation across all underlying services.
3. **Complex Subsystem**:
   - `FlightBookingService`: Searches for available flights to Japan and handles ticket reservations.
   - `HotelBookingService`: Reserves hotel/ryokan rooms for specified durations.
   - `JRPassService`: Issues official Japan Rail passes for regional train transit.
   - `PaymentGateway`: Validates card details and processes transactions in Japanese Yen (JPY).

---

## Clean Code Principles Applied

1. **Meaningful & Self-Explanatory Names**:
   - Class and method names explicitly convey their intent (e.g., `bookFullJapanTrip()`, `searchAndBookFlight()`, `issueJRPass()`). The client code reads clearly without requiring additional documentation.

2. **Single Responsibility Principle (SRP)**:
   - `JapanTripFacade` is solely responsible for workflow orchestration. It does not perform actual booking or payment calculations itself, delegating domain logic entirely to the individual subsystem classes.

3. **Encapsulation / No Leaking of Subsystem Implementation**:
   - The Facade hides internal subsystem implementation details, exception flows, and order dependencies behind a simplified parameter set.

4. **Small, Focused Classes**:
   - Each subsystem class (`FlightBookingService`, `HotelBookingService`, `JRPassService`, `PaymentGateway`) maintains a strictly defined scope and single responsibility.

5. **Proper Error Handling & Coordination**:
   - The Facade tracks execution status across all subsystem calls and ensures gracefully reported outcomes if any step fails during the booking workflow.
