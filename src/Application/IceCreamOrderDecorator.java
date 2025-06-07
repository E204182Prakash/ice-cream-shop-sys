package Application;

abstract class IceCreamOrderDecorator implements IceCreamDeco{
    protected IceCreamDeco icecreamdeco;

    public IceCreamOrderDecorator(IceCreamDeco icecreamdeco) {
        this.icecreamdeco = icecreamdeco;
    }

    @Override
    public String getDecoDescription() {
        return icecreamdeco.getDecoDescription();
    }

    @Override
    public double getDecoPrice() {
        return icecreamdeco.getDecoPrice();
    }

}
