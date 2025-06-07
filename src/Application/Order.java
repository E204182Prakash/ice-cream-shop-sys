package Application;

import java.util.List;
import java.util.ArrayList;

public class Order {
    private int orderId;
    private Customer customer;
    private CustomIceCreamCombination customIceCream;
    private String orderType;
    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private List<CustomizationHandler> handlers;
    private OrderState currentState;
    private List<Promotion> appliedPromotions;
    private List<OrderObserver> observers = new ArrayList<>();
    private String orderStatus;
    private Double total;


   private Order(int orderId, Customer customer, CustomIceCreamCombination customIceCream,
          String orderType, String deliveryAddress) {
        this.orderId = orderId;
        this.customer = customer;
        this.customIceCream = customIceCream;
        this.orderType = orderType;
        this.deliveryAddress = deliveryAddress;
        this.currentState = new PlacedState(this);
        this.appliedPromotions = new ArrayList<>();
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCustomIceCream(CustomIceCreamCombination customIceCream) {
        this.customIceCream = customIceCream;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setHandlers(List<CustomizationHandler> handlers) {
        this.handlers = handlers;
    }

    public void setAppliedPromotions(List<Promotion> appliedPromotions) {
        this.appliedPromotions = appliedPromotions;
    }

    public void setObservers(List<OrderObserver> observers) {
        this.observers = observers;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    /*public void setOrder(Order order) {
        this.order = order;
    }*/

    public Double getTotal() {
        return total;
    }

    public Order getOrder(Order order) {
        return order;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    // Example Methods
    public int getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public CustomIceCreamCombination getCustomIceCream() {
        return customIceCream;
    }

    public String getOrderType() {
        return orderType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public List<CustomizationHandler> getHandlers() {
        return handlers;
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public List<OrderObserver> getObservers() {
        return observers;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void reviewOrder() {
        System.out.println("Review Order:");
        System.out.println("Order Type: " + orderType);
        System.out.println("Customer: " + customer.getName());
        System.out.println("Custom Ice Cream: " + customIceCream.getFlavor().getFlavorName() +
                " - " + customIceCream.getSize().getSizeName() +
                " - " + customIceCream.getCustomName());
        System.out.println("Toppings: " + customIceCream.getToppings());
        System.out.println("Syrups: " + customIceCream.getSyrups());

        if (orderType.equals("Delivery")) {
            System.out.println("Delivery Address: " + deliveryAddress);
        }

        // Additional order details can be displayed here
    }

    /*public void ProcessNewPayment() {
        if (paymentMethod != null) {
            paymentMethod.processPayment(this);
        } else {
            System.out.println("Payment method not specified for Order #" + orderId);
        }
    }*/

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public void applySeasonalSpecialDiscount(SeasonalSpecial seasonalSpecial) {
        seasonalSpecial.applyDiscount(this);
    }


    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void updateOrderStatus(String newStatus) {
        this.orderStatus = newStatus;
        // Notify observers
        notifyObservers();
    }

    public void processCustomization(String customization) {
        for (CustomizationHandler handler : handlers) {
            handler.handleRequest(this, customization);
        }
    }

    public void placeOrder() {
        currentState.placeOrder(this);
    }

    public void prepareOrder() {
        currentState.prepareOrder(this);
    }

    public void deliverOrder() {
        currentState.deliverOrder(this);
    }

    public void setCurrentState(OrderState currentState) {
        this.currentState = currentState;
    }

    public List<Promotion> getAppliedPromotions() {
        return appliedPromotions;
    }

    public void applyPromotion(Promotion promotion) {
        // Check if the promotion is applicable to this order, and then apply it
        // You may add additional logic based on your requirements

        // For example, let's assume all promotions are applicable to all orders
        appliedPromotions.add(promotion);
    }

    // Builder interface
    public interface OrderBuilder {
        OrderBuilder setCustomer(Customer customer);
        OrderBuilder setCustomIceCream(CustomIceCreamCombination customIceCream);
        OrderBuilder setOrderType(String orderType);
        OrderBuilder setDeliveryAddress(String deliveryAddress);
        Order build();
    }

    // Concrete builder implementation
    public static class OrderBuilderImpl implements OrderBuilder {
        private int orderId;
        private Customer customer;
        private CustomIceCreamCombination customIceCream;
        private String orderType;
        private String deliveryAddress;

        public OrderBuilderImpl(int orderId) {
            this.orderId = orderId;
        }

        @Override
        public OrderBuilder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        @Override
        public OrderBuilder setCustomIceCream(CustomIceCreamCombination customIceCream) {
            this.customIceCream = customIceCream;
            return this;
        }

        @Override
        public OrderBuilder setOrderType(String orderType) {
            this.orderType = orderType;
            return this;
        }

        @Override
        public OrderBuilder setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
            return this;
        }

        @Override
        public Order build() {
            return new Order(orderId, customer, customIceCream, orderType, deliveryAddress);
        }
    }

    // Example usage of the builder pattern
    /*Order order = new OrderBuilderImpl(1)
            .setCustomer(customer)
            .setCustomIceCream(customIceCream)
            .setOrderType(orderType)
            .setDeliveryAddress("Col-2")
            .build();*/

}
