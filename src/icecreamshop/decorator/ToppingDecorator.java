package icecreamshop.decorator;

import icecreamshop.model.IceCream;

public abstract class ToppingDecorator implements IceCream{
    protected final IceCream wrappedIceCream;

    public ToppingDecorator(IceCream wrappedIceCream){
        if (wrappedIceCream == null){
            throw new IllegalArgumentException("Wrapped ice cream cannot be null.");
        }
        this.wrappedIceCream = wrappedIceCream;
    }

    @Override
    public String getDescription(){
        return wrappedIceCream.getDescription();
    }

    @Override
    public double getCost(){
        return wrappedIceCream.getCost();
    }
}