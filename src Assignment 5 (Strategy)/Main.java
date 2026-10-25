import java.util.LinkedHashMap;
import java.util.Map;
 //Client. Chooses and configures strategies. Selection is done via a Map,
 // so there is no if/switch on the strategy type anywhere.

public class Main {

    public static void main(String[] args) {
        Map<String, TransportStrategy> transports = new LinkedHashMap<>();
        transports.put("shinkansen", new ShinkansenStrategy());
        transports.put("train", new LocalTrainStrategy());
        transports.put("bus", new HighwayBusStrategy());
        transports.put("car", new RentalCarStrategy());
        transports.put("flight", new DomesticFlightStrategy());
        transports.put("nightbus", new NightBusStrategy()); // added later

        Route tokyoKyoto = new Route("Tokyo", "Kyoto", 450);
        Route kyotoOsaka = new Route("Kyoto", "Osaka", 45);

        TripPlanner planner = new TripPlanner(transports.get("shinkansen"));

        compareAll(planner, transports, tokyoKyoto);
        compareAll(planner, transports, kyotoOsaka);
    }

    private static void compareAll(TripPlanner planner,
                                   Map<String, TransportStrategy> transports,
                                   Route route) {
        System.out.println("=== " + route + " ===");
        for (TransportStrategy transport : transports.values()) {
            planner.setTransport(transport); // switching at runtime
            System.out.printf("%-34s %s%n", planner.transportName(), describe(planner, route));
        }
        System.out.println();
    }

    private static String describe(TripPlanner planner, Route route) {
        try {
            return String.format("%8.0f JPY  %5.1f h", planner.cost(route), planner.durationHours(route));
        } catch (IllegalArgumentException e) {
            return "not available: " + e.getMessage();
        }
    }
}