package main;

public class RedoCommand implements ICommand{
    @Override
    public void runCommand() {
        CommandHistory.redo();
    }
}
