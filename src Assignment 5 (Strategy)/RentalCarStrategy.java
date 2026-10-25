
// Rental car: daily rent + fuel + expressway tolls (Japanese tolls are high).
public class RentalCarStrategy implements TransportStrategy {
    private static final double DAILY_RENT_YEN = 7000;
    private static final double FUEL_PER_KM_YEN = 15;
    private static final double TOLL_PER_KM_YEN = 25;
    private static final double AVERAGE_SPEED_KMH = 75;
    private static final double HOURS_PER_RENTAL_DAY = 10;

    @Override
    public String getName() { return "Rental car"; }

    @Override
    public double calculateCost(Route route) {
        double rentalDays = Math.ceil(calculateDurationHours(route) / HOURS_PER_RENTAL_DAY);
        double runningCosts = route.getDistanceKm() * (FUEL_PER_KM_YEN + TOLL_PER_KM_YEN);
        return rentalDays * DAILY_RENT_YEN + runningCosts;
    }

    @Override
    public double calculateDurationHours(Route route) {
        return route.getDistanceKm() / AVERAGE_SPEED_KMH;
    }
}