package icecreamshop.builder;

import icecreamshop.model.IceCream;
import icecreamshop.model.IceCreamOrder;

public class IceCreamOrderBuilder {
    private String customerName = "Guest";
    private IceCream iceCream;
    private String servingStyle = "Cup";
    private boolean takeaway = false;
    private boolean includeSpoon = true;

    public IceCreamOrderBuilder setCustomerName(String customerName) {
        if (customerName != null && !customerName.trim().isEmpty()) {
            this.customerName = customerName.trim();
        }
        return this;
    }

    public IceCreamOrderBuilder setIceCream(IceCream iceCream) {
        this.iceCream = iceCream;
        return this;
    }

    public IceCreamOrderBuilder setServingStyle(String servingStyle) {
        if (servingStyle == null) {
            return this;
        }
        String normalized = servingStyle.trim();
        if (normalized.equalsIgnoreCase("Cone")) {
            this.servingStyle = "Cone";
        } else if (normalized.equalsIgnoreCase("Cup")) {
            this.servingStyle = "Cup";
        } else {
            throw new IllegalArgumentException(
                    "Invalid serving style: " + servingStyle + ". Choose Cup or Cone.");
        }
        return this;
    }

    public IceCreamOrderBuilder setTakeaway(boolean takeaway) {
        this.takeaway = takeaway;
        return this;
    }

    public IceCreamOrderBuilder addSpoon(boolean includeSpoon) {
        this.includeSpoon = includeSpoon;
        return this;
    }

    public IceCreamOrder build() {
        if (iceCream == null) {
            throw new IllegalStateException("Cannot build IceCreamOrder without an IceCream item.");
        }
        return new IceCreamOrder(customerName, iceCream, servingStyle, takeaway, includeSpoon);
    }
}