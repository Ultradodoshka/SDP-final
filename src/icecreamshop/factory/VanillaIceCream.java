package icecreamshop.factory;
import icecreamshop.model.IceCream;

public class VanillaIceCream implements IceCream{
    @Override
    public String getDescription(){
        return "Vanilla Ice Cream";
    }

    @Override
    public double getCost() {
        return 700.0;
    }
}