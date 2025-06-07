package Application;

class WaffleConesDecorator extends IceCreamOrderDecorator{
    public WaffleConesDecorator(IceCreamDeco icecreamdeco) {
        super(icecreamdeco);
    }

    @Override
    public String getDecoDescription() {
        return super.getDecoDescription() + " in Waffle Cones";
    }

    @Override
    public double getDecoPrice() {
        return super.getDecoPrice() + 750.5; // Additional cost for waffle cones
    }
}
