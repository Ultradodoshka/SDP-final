package icecreamshop.payment;

public class CardPayment implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" KZT via card");
    }
}
