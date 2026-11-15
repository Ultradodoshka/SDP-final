package icecreamshop.factory;

import icecreamshop.model.IceCream;

public class StrawberryCreator extends IceCreamCreator{
    @Override
    public IceCream createIceCream() {
        return new StrawberryIceCream();
    }
}