package icecreamshop.factory;
import icecreamshop.model.IceCream;

public class StrawberryIceCream implements IceCream{
    @Override
    public String getDescription(){
        return "Strawberry Ice Cream";
    }

    @Override
    public double getCost(){
        return 800.0;
    }
}