package icecreamshop.payment;

public class ExternalKaspiPayService {
     public void processTengeTransaction(int amount){
        System.out.println("[Kaspi API] Paid: "+amount+" KZT by Kaspi bank");
    }
}
