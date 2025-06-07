package Application;

class GiftWrappingDecorator extends IceCreamOrderDecorator{
    public GiftWrappingDecorator(IceCreamDeco icecreamdeco) {
        super(icecreamdeco);
    }

    @Override
    public String getDecoDescription() {
        return super.getDecoDescription() + " GiftWrappingDecorator";
    }

    @Override
    public double getDecoPrice() {
        return super.getDecoPrice() + 550.0;
    }

}
