package main;


public class CreateShapeCommand implements ICommand, IUndoRedo{


    @Override
    public void runCommand() {

        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {

    }

    @Override
    public void redoCommand() {

    }
}
