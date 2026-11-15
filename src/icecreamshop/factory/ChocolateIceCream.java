package icecreamshop.factory;
import icecreamshop.model.IceCream;

public class ChocolateIceCream implements IceCream {
    @Override
    public String getDescription() {
        return "Chocolate Ice Cream";
    }

    @Override
    public double getCost() {
        return 850.0;
    }
}