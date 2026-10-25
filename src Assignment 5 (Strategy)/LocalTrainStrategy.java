// Regular local trains: cheaper than Shinkansen but much slower.
public class LocalTrainStrategy implements TransportStrategy {
    private static final double PRICE_PER_KM_YEN = 12;
    private static final double AVERAGE_SPEED_KMH = 60;

    @Override
    public String getName() { return "Local train"; }

    @Override
    public double calculateCost(Route route) {
        return route.getDistanceKm() * PRICE_PER_KM_YEN;
    }

    @Override
    public double calculateDurationHours(Route route) {
        return route.getDistanceKm() / AVERAGE_SPEED_KMH;
    }
}