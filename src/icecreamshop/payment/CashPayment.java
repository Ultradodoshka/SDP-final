package icecreamshop.payment;

public class CashPayment implements PaymentStrategy{
    @Override
    public boolean pay(double amount) {
        if (amount<=0) return false;
        System.out.println("Paid "+amount+" KZT in cash");
        return true;
    }

    @Override
    public String getMethodName() {
        return "Cash";
    }
}
