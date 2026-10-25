import java.util.Objects;

 //Context. Holds a reference to a TransportStrategy and delegates all work to it.
 //It contains no if/switch on strategy type and knows nothing about concrete strategies.

public class TripPlanner {
    private TransportStrategy transport;

    public TripPlanner(TransportStrategy transport) {
        setTransport(transport);
    }

    /** Runtime strategy switching. */
    public void setTransport(TransportStrategy transport) {
        this.transport = Objects.requireNonNull(transport, "Transport strategy must not be null");
    }

    public String transportName() { return transport.getName(); }

    public double cost(Route route) { return transport.calculateCost(route); }

    public double durationHours(Route route) { return transport.calculateDurationHours(route); }
}