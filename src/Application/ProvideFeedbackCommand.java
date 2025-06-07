package Application;

public class ProvideFeedbackCommand implements Command{
    private Feedback feedback;

    public ProvideFeedbackCommand(Feedback feedback) {
        this.feedback = feedback;
    }

    @Override
    public void execute() {
        feedback.provideFeedback();
    }
}
