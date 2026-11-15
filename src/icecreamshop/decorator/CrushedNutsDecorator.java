package icecreamshop.decorator;

import icecreamshop.model.IceCream;

public class CrushedNutsDecorator extends ToppingDecorator {
    public CrushedNutsDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Crushed Nuts";
    }

    @Override
    public double getCost() {
        return super.getCost() + 250.0;
    }
}
