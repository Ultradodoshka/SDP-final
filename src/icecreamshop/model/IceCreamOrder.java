package icecreamshop.model;

import java.util.Locale;

public class IceCreamOrder {
    private static int nextOrderNumber = 1001;

    private final String orderId;
    private final String customerName;
    private final IceCream iceCream;
    private final String servingStyle;
    private final boolean takeaway;
    private final boolean includeSpoon;

    public IceCreamOrder(String customerName,
                         IceCream iceCream,
                         String servingStyle,
                         boolean takeaway,
                         boolean includeSpoon) {
        if (iceCream == null) {
            throw new IllegalArgumentException("IceCream cannot be null.");
        }
        this.orderId = "ORD-" + (nextOrderNumber++);
        this.customerName = (customerName == null || customerName.trim().isEmpty())
                ? "Guest"
                : customerName.trim();
        this.iceCream = iceCream;
        this.servingStyle = (servingStyle == null || servingStyle.trim().isEmpty())
                ? "Cup"
                : servingStyle.trim();
        this.takeaway = takeaway;
        this.includeSpoon = includeSpoon;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public IceCream getIceCream() {
        return iceCream;
    }

    public String getServingStyle() {
        return servingStyle;
    }

    public boolean isTakeaway() {
        return takeaway;
    }

    public boolean isIncludeSpoon() {
        return includeSpoon;
    }

    public double getTotalCost() {
        return iceCream.getCost();
    }

    public String formatSummary() {
        return String.format(Locale.US,
                "Order ID: %s%n"
                        + "Customer: %s%n"
                        + "Item: %s%n"
                        + "Serving Style: %s%n"
                        + "Takeaway: %s%n"
                        + "Include Spoon: %s%n"
                        + "Total Cost: %.2f KZT",
                orderId,
                customerName,
                iceCream.getDescription(),
                servingStyle,
                takeaway ? "Yes" : "No",
                includeSpoon ? "Yes" : "No",
                getTotalCost());
    }

    @Override
    public String toString() {
        return "========================================\n" +
                "Order ID:      " + orderId + "\n" +
                "Customer:      " + customerName + "\n" +
                "Item:          " + (iceCream != null ? iceCream.getDescription() : "None") + "\n" +
                "Serving Style: " + servingStyle + "\n" +
                "Takeaway:      " + (takeaway ? "Yes" : "No") + "\n" +
                "Spoon:         " + (includeSpoon ? "Included" : "No") + "\n" +
                "----------------------------------------\n" +
                "TOTAL:         " + String.format("%.2f KZT", getTotalCost()) + "\n" +
                "========================================";
    }
}
