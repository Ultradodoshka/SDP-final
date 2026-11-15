package icecreamshop.factory;

import icecreamshop.model.IceCream;

public abstract class IceCreamCreator{
    public abstract IceCream createIceCream();

    public IceCream orderBaseIceCream(){
        IceCream iceCream = createIceCream();
        System.out.println("[Factory Method] Prepared base scoop: " + iceCream.getDescription() + " (" + iceCream.getCost() + " KZT)");
        return iceCream;
    }
}