// Immutable data object: a leg of the trip between two Japanese cities.

public final class Route {
    private final String from;
    private final String to;
    private final double distanceKm;

    public Route(String from, String to, double distanceKm) {
        if (from == null || from.isBlank() || to == null || to.isBlank()) {
            throw new IllegalArgumentException("City names must not be empty");
        }
        if (distanceKm <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }
        this.from = from;
        this.to = to;
        this.distanceKm = distanceKm;
    }

    public String getFrom() { return from; }
    public String getTo() { return to; }
    public double getDistanceKm() { return distanceKm; }

    @Override
    public String toString() {
        return from + " -> " + to + " (" + (int) distanceKm + " km)";
    }
}