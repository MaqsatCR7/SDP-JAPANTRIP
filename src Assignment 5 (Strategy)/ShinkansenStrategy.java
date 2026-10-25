//Bullet train: expensive, very fast, comfortable.
public class ShinkansenStrategy implements TransportStrategy {
    private static final double PRICE_PER_KM_YEN = 22;
    private static final double AVERAGE_SPEED_KMH = 220;

    @Override
    public String getName() { return "Shinkansen (bullet train)"; }

    @Override
    public double calculateCost(Route route) {
        return route.getDistanceKm() * PRICE_PER_KM_YEN;
    }

    @Override
    public double calculateDurationHours(Route route) {
        return route.getDistanceKm() / AVERAGE_SPEED_KMH;
    }
}