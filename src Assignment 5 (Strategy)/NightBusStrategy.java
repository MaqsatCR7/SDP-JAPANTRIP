
//EXTENSIBILITY DEMO: added after the other strategies.The interface, the Context and the existing strategies were NOT modified.
//Night bus is the cheapest option and you sleep on the way.

public class NightBusStrategy implements TransportStrategy {
    private static final double PRICE_PER_KM_YEN = 6;
    private static final double AVERAGE_SPEED_KMH = 65;

    @Override
    public String getName() { return "Night bus"; }

    @Override
    public double calculateCost(Route route) {
        return route.getDistanceKm() * PRICE_PER_KM_YEN;
    }

    @Override
    public double calculateDurationHours(Route route) {
        return route.getDistanceKm() / AVERAGE_SPEED_KMH;
    }
}