
// Domestic flight: fastest in the air, but airport procedures add fixed time.
public class DomesticFlightStrategy implements TransportStrategy {
    private static final double BASE_FARE_YEN = 9000;
    private static final double PRICE_PER_KM_YEN = 12;
    private static final double CRUISE_SPEED_KMH = 700;
    private static final double AIRPORT_OVERHEAD_HOURS = 3;
    private static final double MIN_FLIGHT_DISTANCE_KM = 300;

    @Override
    public String getName() { return "Domestic flight"; }

    @Override
    public double calculateCost(Route route) {
        requireFlightWorthDistance(route);
        return BASE_FARE_YEN + route.getDistanceKm() * PRICE_PER_KM_YEN;
    }

    @Override
    public double calculateDurationHours(Route route) {
        requireFlightWorthDistance(route);
        return route.getDistanceKm() / CRUISE_SPEED_KMH + AIRPORT_OVERHEAD_HOURS;
    }

    private void requireFlightWorthDistance(Route route) {
        if (route.getDistanceKm() < MIN_FLIGHT_DISTANCE_KM) {
            throw new IllegalArgumentException("No flights for distances shorter than "
                    + (int) MIN_FLIGHT_DISTANCE_KM + " km");
        }
    }
}