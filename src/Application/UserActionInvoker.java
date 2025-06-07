package Application;
import java.util.List;
import java.util.ArrayList;
public class UserActionInvoker {
    private List<Command> commandQueue;

    public UserActionInvoker() {
        this.commandQueue = new ArrayList<>();
    }

    public void addToQueue(Command command) {
        // Add command to the queue
        commandQueue.add(command);
    }

    public void executeCommands() {
        // Execute all commands
        for (Command command : commandQueue) {
            command.execute();
        }
        commandQueue.clear();
    }
}
