public class JRPassService {
    public boolean issueJRPass(String passengerName, int days) {
        System.out.println("[JRPassService] Issuing " + days + "-day Japan Rail Pass for " + passengerName + "...");
        System.out.println("[JRPassService] JR Pass order completed!");
        return true;
    }
}