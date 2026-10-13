public class HotelBookingService {
    public boolean reserveHotel(String cityName, int nights) {
        System.out.println("[HotelService] Reserving hotel in " + cityName + " for " + nights + " nights...");
        System.out.println("[HotelService] Hotel reservation confirmed!");
        return true;
    }
}