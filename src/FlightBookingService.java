public class FlightBookingService {
    public boolean searchAndBookFlight(String passportNumber, String destinationCity) {
        System.out.println("[FlightService] Searching flights to " + destinationCity + "...");
        System.out.println("[FlightService] Flight booked successfully for passport: " + passportNumber);
        return true;
    }
}