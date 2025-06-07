package Application;

class SundaeDecorator extends IceCreamOrderDecorator{
    public SundaeDecorator(IceCreamDeco icecreamdeco) {
        super(icecreamdeco);
    }

    @Override
    public String getDecoDescription() {
        return super.getDecoDescription() + " Sundae";
    }

    @Override
    public double getDecoPrice() {
        return super.getDecoPrice() + 1200.0;
    }
}
