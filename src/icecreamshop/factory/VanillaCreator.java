package icecreamshop.factory;

import icecreamshop.model.IceCream;

public class VanillaCreator extends IceCreamCreator{
    @Override
    public IceCream createIceCream() {
        return new VanillaIceCream();
    }
}
