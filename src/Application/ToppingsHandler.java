package Application;

public class ToppingsHandler implements CustomizationHandler{
    private CustomizationHandler nextHandler;

    @Override
    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(Order order, String customization) {
        System.out.println("Handling toppings customization: " + customization);
        if (nextHandler != null) {
            nextHandler.handleRequest(order, customization);
        }
    }
}
