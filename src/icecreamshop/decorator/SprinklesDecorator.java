package icecreamshop.decorator;

import icecreamshop.model.IceCream;

public class SprinklesDecorator extends ToppingDecorator{
    public SprinklesDecorator(IceCream wrappedIceCream){
        super(wrappedIceCream);
    }

    @Override
    public String getDescription(){
        return super.getDescription() + ", Rainbow Sprinkles";
    }

    @Override
    public double getCost() {
        return super.getCost() + 150.0;
    }
}
