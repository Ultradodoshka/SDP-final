package icecreamshop.factory;

import icecreamshop.model.IceCream;

public class ChocolateCreator extends IceCreamCreator{
    @Override
    public IceCream createIceCream() {
        return new ChocolateIceCream();
    }
}
