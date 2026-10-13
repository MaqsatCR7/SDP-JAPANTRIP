public class PaymentGateway {
    public boolean processPayment(String creditCardNumber, double amountJPY) {
        System.out.println("[PaymentGateway] Processing payment of ¥" + amountJPY + "...");
        System.out.println("[PaymentGateway] Payment successfully processed!");
        return true;
    }
}