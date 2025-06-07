package customerfeedbackservice;

import org.osgi.framework.BundleActivator;
public class CustomerFeedbackServiceActivator implements BundleActivator {

    private static BundleContext context;
    private ServiceRegistration feedback;

    static BundleContext getContext()
    {
        return context;
    }

    @Override
    public void start (BundleContext bundlecontext) throws Exception {
        CustomerFeedbackServiceActivator.context = bundlecontext;

        /*
        * Feedback service registration
         */

        CustomerFeedbackService feedbackService = (CustomerFeedbackService) new CustomerFeedbackServiceImpl();
        feedback = context.registerService(CustomerFeedbackService.class.getName(), feedbackService, null);
        System.out.println("Customer Feedback Started");
        System.out.println("\n---------------------------");
    }

    @Override
    public void stop (BundleContext bundlecontext) throws Exception{
        feedback.unregister();
        System.out.println("Customer Feedback Stopped");
        System.out.println("\n---------------------------");
        CustomerFeedbackServiceActivator.context = null;
    }

}
