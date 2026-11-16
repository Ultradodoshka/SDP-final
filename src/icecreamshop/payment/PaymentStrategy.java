package icecreamshop.payment;

public interface PaymentStrategy {
    boolean pay(double amount);
    String getMethodName();
}
