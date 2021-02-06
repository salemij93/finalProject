package main;

public class MoveShapeCommand implements ICommand, IUndoRedo{


    @Override
    public void runCommand() {
        System.out.println("moved");
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo move");
    }

    @Override
    public void redoCommand() {
        System.out.println("redo move");
    }
}
