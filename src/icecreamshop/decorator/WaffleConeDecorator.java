package icecreamshop.decorator;

import icecreamshop.model.IceCream;

public class WaffleConeDecorator extends ToppingDecorator {
    public WaffleConeDecorator(IceCream wrappedIceCream) {
        super(wrappedIceCream);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Waffle Cone";
    }

    @Override
    public double getCost() {
        return super.getCost() + 300.0;
    }
}
