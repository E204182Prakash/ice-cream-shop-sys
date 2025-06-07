package Application;
import java.util.ArrayList;
import java.util.List;
public class MainApp {
    public static void main(String[] args) {

        // Display available options
        CustomIceCreamCombination.displayAvailableOptions();

        // Create a customer
        Customer customer = new Customer(1, "Prakash", "0777712123", "prakash@gmail.com");

        // Create an order for delivery
        Order order = new Order.OrderBuilderImpl(1)
                .setCustomer(customer)
                .setOrderType("Delivery")
                .setDeliveryAddress("Col-2")
                .build();

        CustomIceCreamCombination customIceCream = new CustomIceCreamCombination(order, new ArrayList<>());

        order.setCustomIceCream(customIceCream);

        // Create a custom ice cream combination
        IceCreamFlavor chosenFlavor = IceCreamFlavor.getFlavorById(1);
        List<Topping> chosenToppings = List.of(Topping.getToppingById(2), Topping.getToppingById(3));
        List<Syrup> chosenSyrups = List.of(Syrup.getSyrupById(1));
        ScoopSize chosenSize = ScoopSize.getSizeById(1);

        customIceCream.setFlavor(chosenFlavor);
        customIceCream.setToppings(chosenToppings);
        customIceCream.setSyrups(chosenSyrups);
        customIceCream.setSize(chosenSize);
        customIceCream.setCustomName("My sweet choice");

        customIceCream = new CustomIceCreamCombination(order, new ArrayList<>());

        // customize order with decorators
        IceCreamDeco decoratedIceCream1 = new GiftWrappingDecorator(customIceCream);
        IceCreamDeco decoratedIceCream2 = new SundaeDecorator(decoratedIceCream1);

        // Review the order
        order.reviewOrder();

        System.out.println("Order 1: " + decoratedIceCream2.getDecoDescription());
        System.out.println("Total Price: RS." + decoratedIceCream2.getDecoPrice());

        // Estimate delivery time
        DeliveryService.estimateDeliveryTime(order, order.getDeliveryAddress());

        // Simulate payment processing with Debit card
        PaymentProcessor.processPayment(order, PaymentMethod.DEBIT_CARD);

        order.addObserver(customer);
        order.updateOrderStatus("Your Order is still in pending Progress");

        order.placeOrder();
        // Prepare the order
        order.prepareOrder();
        // transition to DeliveryState
        order.deliverOrder();
        // Try to prepare the order (should not change state)
        order.prepareOrder();

        // Simulate order tracking updates with SMS notifications
        OrderTrackingSystem.sendOrderConfirmationNotification(order);
        OrderTrackingSystem.sendPreparationNotification(order);
        OrderTrackingSystem.sendOutForDeliveryNotification(order);

        // Simulate customer providing feedback and rating
        Feedback feedback = new Feedback(order.getOrderId(), "Great ice cream!", 5);
        // Create the invoker
        UserActionInvoker userActionInvoker = new UserActionInvoker();
        // Create commands and add to queue
        PlaceOrderCommand placeOrderCommand = new PlaceOrderCommand(order);
        ProvideFeedbackCommand provideFeedbackCommand = new ProvideFeedbackCommand(feedback);
        userActionInvoker.addToQueue(placeOrderCommand);
        userActionInvoker.addToQueue(provideFeedbackCommand);
        // Execute commands
        userActionInvoker.executeCommands();

        OrderTrackingSystem.sendDeliveryCompletedNotification(order);


        // Generate an invoice for the order
        Invoice invoice = new Invoice(order);
        invoice.generateInvoice();


        //User profile code and choose custom ice cream
        // Create a user profile
        UserProfile userProfile = new UserProfile(1, "Prakash","123");

        // Add a custom ice cream combination to favorites
        userProfile.addFavoriteCombination(customIceCream);

        // Remove a custom ice cream combination from favorites
        userProfile.removeFavoriteCombination(customIceCream);

        // Find a favorite combination by ID
        CustomIceCreamCombination foundCombination = userProfile.findFavoriteCombinationById(1);

        // Search for favorite combinations by keyword
        List<CustomIceCreamCombination> searchResults = userProfile.searchFavorites("chocolate");

        // Display search results
        System.out.println("Search Results:");
        for (CustomIceCreamCombination result : searchResults) {
            System.out.println(result.getCombinationId() + ". " + result.getCustomName());
        }



        // Simulate earning loyalty points with a purchase
        double purchaseAmount = 20.0; // Example purchase amount
        LoyaltyProgram.earnPoints(customer, purchaseAmount);

        // Simulate redeeming loyalty points
        int pointsToRedeem = 30; // Example points to redeem
        LoyaltyProgram.redeemPoints(customer, pointsToRedeem);



        // Create a seasonal special
        SeasonalSpecial summerSpecial = new SeasonalSpecial("Summer Special", "Discount on summer flavors", 15.0);
        summerSpecial.addDiscountedFlavor(IceCreamFlavor.getFlavorById(1));

        // Apply seasonal special discount to the order
        order.applySeasonalSpecialDiscount(summerSpecial);

        // Add feedback to the RatingManager
        RatingManager ratingManager = new RatingManager();
        ratingManager.addFeedback(feedback);

        // Simulate getting the average rating for the order
        double averageRating = ratingManager.getAverageRating(order.getOrderId());
        System.out.println("Average Rating for Order #" + order.getOrderId() + ": " + averageRating);

        // Simulate showcasing highly-rated combinations
        List<CustomIceCreamCombination> highlyRatedCombinations = ratingManager.getHighlyRatedCombinations();
        System.out.println("Highly Rated Combinations:");
        for (CustomIceCreamCombination combination : highlyRatedCombinations) {
            System.out.println(combination.getCustomName() + ": " + ratingManager.getAverageRating(combination.getOrder().getOrderId()));
        }

        // Create instances of the concrete handlers
        CustomizationHandler flavorHandler = new FlavorHandler();
        CustomizationHandler toppingsHandler = new ToppingsHandler();
        CustomizationHandler syrupsHandler = new SyrupsHandler();
        CustomizationHandler sizeHandler = new SizeHandler();

        // Set up the chain of responsibility
        flavorHandler.setNextHandler(toppingsHandler);
        toppingsHandler.setNextHandler(syrupsHandler);
        syrupsHandler.setNextHandler(sizeHandler);

        // Process the customization request through the chain
        flavorHandler.handleRequest(order, "Chocolate");
        toppingsHandler.handleRequest(order, "Choco Sticks");
        syrupsHandler.handleRequest(order, "Sweet pie");


        // Set the handlers in the order
        order.setHandlers(List.of(flavorHandler, toppingsHandler, syrupsHandler, sizeHandler));

        // Process the customization request through the chain
        order.processCustomization("Chocolate");


        // Create a custom ice cream combination with prices
        //CustomIceCreamCombination customIceCream1 = new CustomIceCreamCombination(List.of(3.0, 1.0, 2.0));

        // Create a visitor
        PriceCalculatorVisitor priceCalculator = new PriceCalculatorVisitor();

        // Accept the visitor on the custom ice cream combination
        customIceCream.accept(priceCalculator);

        // Get the total price calculated by the visitor
        double totalPrice = priceCalculator.getTotalPrice();

        // Display the result
        System.out.println("Total Price: RS." + totalPrice);

        // Choose a payment method (Strategy)
        PaymentOptions creditCardPayment = new CreditCardPayment();
        /*order.setPaymentMethod(creditCardPayment);
        // Process the payment
        order.processNewPayment();*/

        List<Order> orders = new ArrayList<>();

        SalesReportGenerator reportGenerator = new SalesReportGenerator(orders);
        reportGenerator.generateSalesReport();

    }
}
