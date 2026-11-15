package icecreamshop.payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" KZT in cash");
    }
}
