//Strategy interface: common contract for every way of travelling between cities.

public interface TransportStrategy {

    String getName();

    //Total cost of the route in Japanese yen.
    double calculateCost(Route route);

    //Total travel time of the route in hours.
    double calculateDurationHours(Route route);
}