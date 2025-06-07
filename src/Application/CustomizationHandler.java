package Application;

public interface CustomizationHandler {
    void setNextHandler(CustomizationHandler nextHandler);
    void handleRequest(Order order, String customization);
}
