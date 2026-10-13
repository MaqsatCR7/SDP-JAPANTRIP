public class JapanTripFacade {
    private final FlightBookingService flightService;
    private final HotelBookingService hotelService;
    private final JRPassService jrPassService;
    private final PaymentGateway paymentGateway;

    public JapanTripFacade() {
        this.flightService = new FlightBookingService();
        this.hotelService = new HotelBookingService();
        this.jrPassService = new JRPassService();
        this.paymentGateway = new PaymentGateway();
    }

    // Жөнөкөйлөтүлгөн бирдиктүү интерфейс
    public boolean bookFullJapanTrip(String travelerName, String passport, String cardNum, double totalCostJPY) {
        System.out.println("=== STARTING JAPAN TRIP BOOKING PROCESS ===");

        boolean flightOk = flightService.searchAndBookFlight(passport, "Tokyo");
        boolean hotelOk = hotelService.reserveHotel("Tokyo", 7);
        boolean passOk = jrPassService.issueJRPass(travelerName, 7);
        boolean paymentOk = paymentGateway.processPayment(cardNum, totalCostJPY);

        if (flightOk && hotelOk && passOk && paymentOk) {
            System.out.println("=== JAPAN TRIP BOOKED SUCCESSFULLY! HAVE A SAFE JOURNEY! ===\n");
            return true;
        } else {
            System.out.println("=== TRIP BOOKING FAILED: One or more services failed. ===\n");
            return false;
        }
    }
}