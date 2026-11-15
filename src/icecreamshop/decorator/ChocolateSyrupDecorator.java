package icecreamshop.decorator;

import icecreamshop.model.IceCream;

public class ChocolateSyrupDecorator extends ToppingDecorator{
    public ChocolateSyrupDecorator(IceCream wrappedIceCream){
        super(wrappedIceCream);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Chocolate Syrup";
    }

    @Override
    public double getCost(){
        return super.getCost() + 200.0;
    }
}
