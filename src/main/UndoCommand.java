package main;

public class UndoCommand implements ICommand{
    @Override
    public void runCommand() {
        CommandHistory.undo();
    }
}
