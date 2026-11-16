package icecreamshop.facade;

import icecreamshop.builder.IceCreamOrderBuilder;
import icecreamshop.decorator.ChocolateSyrupDecorator;
import icecreamshop.decorator.CrushedNutsDecorator;
import icecreamshop.decorator.SprinklesDecorator;
import icecreamshop.decorator.WaffleConeDecorator;
import icecreamshop.factory.ChocolateCreator;
import icecreamshop.factory.IceCreamCreator;
import icecreamshop.factory.StrawberryCreator;
import icecreamshop.factory.VanillaCreator;
import icecreamshop.model.IceCream;
import icecreamshop.model.IceCreamOrder;
import icecreamshop.payment.CardPayment;
import icecreamshop.payment.CashPayment;
import icecreamshop.payment.ExternalKaspiPayService;
import icecreamshop.payment.KaspiPayAdapter;
import icecreamshop.payment.PaymentStrategy;
import java.util.List;

public class IceCreamShopFacade {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public IceCream createCustomizedIceCream(String flavorChoice, List<String> toppingChoices) {
        IceCreamCreator creator = resolveCreator(flavorChoice);
        IceCream iceCream = creator.orderBaseIceCream();

        if (toppingChoices != null) {
            for (String topping : toppingChoices) {
                iceCream = applyTopping(iceCream, topping);
            }
        }
        return iceCream;
    }

    public IceCreamOrder buildOrder(String customerName,
                                    IceCream iceCream,
                                    String servingStyle,
                                    boolean takeaway,
                                    boolean includeSpoon) {
        return new IceCreamOrderBuilder()
                .setCustomerName(customerName)
                .setIceCream(iceCream)
                .setServingStyle(servingStyle)
                .setTakeaway(takeaway)
                .addSpoon(includeSpoon)
                .build();
    }

    public boolean processPayment(IceCreamOrder order, String paymentChoice) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null.");
        }
        PaymentStrategy strategy = resolvePaymentStrategy(paymentChoice);
        setPaymentStrategy(strategy);
        return executePayment(order.getTotalCost());
    }

    public boolean executePayment(double amount) {
        if (paymentStrategy == null) {
            System.out.println("[Strategy Context] No payment strategy selected.");
            return false;
        }
        System.out.println("[Strategy Context] Processing payment via: "
                + paymentStrategy.getClass().getSimpleName());
        paymentStrategy.pay(amount);
        return true;
    }

    public IceCreamOrder placeFullOrder(String customerName,
                                        String flavorChoice,
                                        List<String> toppingChoices,
                                        String servingStyle,
                                        boolean takeaway,
                                        boolean includeSpoon,
                                        String paymentChoice) {
        System.out.println("\n--- [Facade] Starting Order Workflow ---");
        IceCream customizedIceCream = createCustomizedIceCream(flavorChoice, toppingChoices);

        IceCreamOrder order = buildOrder(
                customerName, customizedIceCream, servingStyle, takeaway, includeSpoon);
        System.out.println("[Builder] Assembled order " + order.getOrderId()
                + " for " + order.getCustomerName());

        boolean paid = processPayment(order, paymentChoice);
        if (!paid) {
            System.out.println("[Facade] Order cancelled due to payment failure.");
            return null;
        }

        System.out.println("[Facade] Order " + order.getOrderId() + " completed successfully.");
        return order;
    }

    private IceCreamCreator resolveCreator(String flavorChoice) {
        if (flavorChoice == null) {
            throw new IllegalArgumentException("Flavor choice cannot be null.");
        }
        switch (flavorChoice.trim().toLowerCase()) {
            case "1":
            case "vanilla":
                return new VanillaCreator();
            case "2":
            case "chocolate":
                return new ChocolateCreator();
            case "3":
            case "strawberry":
                return new StrawberryCreator();
            default:
                throw new IllegalArgumentException("Unknown ice cream flavor: " + flavorChoice);
        }
    }

    private IceCream applyTopping(IceCream current, String toppingChoice) {
        if (toppingChoice == null || toppingChoice.trim().isEmpty()) {
            return current;
        }
        switch (toppingChoice.trim().toLowerCase()) {
            case "1":
            case "chocolate syrup":
                System.out.println("[Decorator] Adding Chocolate Syrup (+200.0 KZT)");
                return new ChocolateSyrupDecorator(current);
            case "2":
            case "sprinkles":
            case "rainbow sprinkles":
                System.out.println("[Decorator] Adding Rainbow Sprinkles (+150.0 KZT)");
                return new SprinklesDecorator(current);
            case "3":
            case "waffle cone":
                System.out.println("[Decorator] Adding Waffle Cone (+300.0 KZT)");
                return new WaffleConeDecorator(current);
            case "4":
            case "crushed nuts":
                System.out.println("[Decorator] Adding Crushed Nuts (+250.0 KZT)");
                return new CrushedNutsDecorator(current);
            default:
                System.out.println("[Facade] Skipping unknown topping: " + toppingChoice);
                return current;
        }
    }

    private PaymentStrategy resolvePaymentStrategy(String paymentChoice) {
        if (paymentChoice == null) {
            throw new IllegalArgumentException("Payment choice cannot be null.");
        }
        switch (paymentChoice.trim().toLowerCase()) {
            case "1":
            case "cash":
                return new CashPayment();
            case "2":
            case "card":
                return new CardPayment();
            case "3":
            case "kaspi":
            case "kaspi pay":
                return new KaspiPayAdapter(new ExternalKaspiPayService());
            default:
                throw new IllegalArgumentException("Unknown payment method: " + paymentChoice);
        }
    }
}