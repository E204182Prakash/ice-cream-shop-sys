package customerfeedback;

import java.io.BufferedReader;

public class CustomerFeedbackActivator implements BundleActivator {

    private BundleContext context;
    private ServiceRegistration feedback;
    private ServiceReference feedbackServiceReference;
    private CustomerFeedbackService feedbackService;

    static BundleContext getContext() {
        return context;
    }

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        CustomerFeedbackActivator.context = bundleContext;

        feedbackServiceReference = context.getServiceReference(CustomerFeedbackService.class.getName());
        feedbackService = (CustomerFeedbackService) context.getService(feedbackServiceReference);

        feedback = context.registerService(this.getClass().getName(), this, null);
        System.out.println("Customer Feedback Started");
        displaySubMenu();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        CustomerFeedbackActivator.context = null;
        System.out.println("Customer Feedback Stopped");
        CustomerFeedbackActivator.context = null;
    }

    public void displaySubMenu() throws IOException {

        String name = "";
        String email = "";
        String contactNo = "";
        String message = "";

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String choice = "0", input = "0";

        while (true) {
            System.out.println("\n---------");
            System.out.println("1. Name");
            System.out.println("2. Email");
            System.out.println("3. ContactNo");
            System.out.println("4. Give any Comment");
            System.out.println("5. All Feedback Details");
            System.out.println("6. Edit And Submit Feedback");
            System.out.println("0. Exit\n");

            try {
                System.out.println("\nPlease Select One Of the Option : ");
                choice = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (choice.equals("0")) {
                System.out.print("I am exiting");
                break;
            }
            if (choice.equals("1")) {
                //String name = "";
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Enter your name : ");
                    try {
                        name = in.readLine();
                    } catch (IOException e) {
                        // TODO Auto-generated catch bloc
                        e.printStackTrace();
                    }
                    System.out.println(feedbackService.CustomerName(name));
                } else {
                    System.out.println("\nInvalid Input\n");
                    continue;
                }

            } else if (choice.equals("2")) {
                //String email = "";
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Enter your email : ");
                    try {
                        email = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(feedbackService.CustomerEmail(email));

                } else {
                    System.out.println("\nInvalid Input\n");
                    continue;
                }
            } else if (choice.equals("3")) {
                //String contactNo = "";
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Enter your contactNo : ");
                    try {
                        contactNo = in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(feedbackService.ContactNo(contactNo));

                } else {
                    System.out.println("\nInvalid Input\n");
                    continue;
                }
            } else if (choice.equals("4")) {
                //String message = "";
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Enter your message : ");
                    try {
                        message = in.readLine();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(feedbackService.Message(message));
                } else {
                    System.out.printlin("\nInvalid Input\n");
                    continue;
                }
            } else if (choice.equals("5")) {
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Display Feedback Details");
                    feedbackService.DisplayAllDetails(name, email, contactNo, message);
                } else {
                    System.out.println("\nInvalid Input\n");
                    continue;
                }
            } else if (choice.equals("6")) {

                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    System.out.println("Enter your new name : ");
                    String changeName = in.readLine();
                    System.out.println("Enter your new email : ");
                    String changeEmail = in.readLine();
                    System.out.println("Enter your new contactNo : ");
                    String changeContactNo = in.readLine();
                    System.out.println("Enter your new Message : ");
                    String changeMessage = in.readLine();
                    feedbackService.EditSubmitDetails(changeName, changeEmail, changeContactNo, changeMessage);

                } else {
                    System.out.println("\nInvalid Input\n");
                    continue;
                }
            }

        }
    }
}