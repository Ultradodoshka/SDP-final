package icecreamshop.payment;

public class CardPayment implements PaymentStrategy{
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber=cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        if (amount<=0) return false;
        System.out.println("Paid "+amount+" KZT via card");
        return true;
    }

    @Override
    public String getMethodName() {
        return "Card";
    }
}
