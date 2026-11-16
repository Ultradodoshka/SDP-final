package icecreamshop.payment;

public class ExternalKaspiPayService {
     public boolean processTengeTransaction(int amount,String merchantId){
         if (amount<=0) return false;
         System.out.println("[Kaspi API | Merchant: " + merchantId + "] Paid: " + amount + " KZT by Kaspi bank");
         return true;
     }
}
