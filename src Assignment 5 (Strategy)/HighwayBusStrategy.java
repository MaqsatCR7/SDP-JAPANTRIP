// Highway bus: the budget option.
public class HighwayBusStrategy implements TransportStrategy {
    private static final double PRICE_PER_KM_YEN = 8;
    private static final double AVERAGE_SPEED_KMH = 70;

    @Override
    public String getName() { return "Highway bus"; }

    @Override
    public double calculateCost(Route route) {
        return route.getDistanceKm() * PRICE_PER_KM_YEN;
    }

    @Override
    public double calculateDurationHours(Route route) {
        return route.getDistanceKm() / AVERAGE_SPEED_KMH;
    }
}