package Application;

public class SizeHandler implements CustomizationHandler{
    private CustomizationHandler nextHandler;

    @Override
    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order, String customization) {
        System.out.println("Handling size customization: " + customization);
        if (nextHandler != null) {
            nextHandler.handleRequest(order, customization);
        }
    }

}
