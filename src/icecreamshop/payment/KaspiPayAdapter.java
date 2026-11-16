package icecreamshop.payment;

public class KaspiPayAdapter implements PaymentStrategy{
    private final ExternalKaspiPayService externalKaspiPay;
    private final String merchantId;

    public KaspiPayAdapter(ExternalKaspiPayService externalKaspiPay){
        this(externalKaspiPay, "DEAFULT-MERCHANT");
    }

    public KaspiPayAdapter(ExternalKaspiPayService externalKaspiPay, String merchantId){
        this.externalKaspiPay = externalKaspiPay;
        this.merchantId=merchantId;
    }

    @Override
    public boolean pay(double amount) {
        int amountInt = (int) Math.round(amount);
        return externalKaspiPay.processTengeTransaction(amountInt,merchantId);
    }

    @Override
    public String getMethodName() {
        return "Kaspi Pay ("+merchantId+")";
    }
}
