package icecreamshop.payment;

public class KaspiPayAdapter implements PaymentStrategy{
    private final ExternalKaspiPayService externalKaspiPay;
    public KaspiPayAdapter(ExternalKaspiPayService externalKaspiPay){
        this.externalKaspiPay = externalKaspiPay;
    }

    @Override
    public void pay(double amount) {
        int amountInt = (int) Math.round(amount);
        externalKaspiPay.processTengeTransaction(amountInt);
    }
}
