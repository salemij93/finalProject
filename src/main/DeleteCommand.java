package main;

public class DeleteCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private ShapeList deleted;


    @Override
    public void runCommand() {
        deleted = shapelist.removeSelected();
        System.out.println("delete");
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        shapelist.addNewShape(deleted);
        shapelist.undrawAll();
        shapelist.drawAll();
        System.out.println("undo delete");
    }

    @Override
    public void redoCommand() {
        deleted = shapelist.removeSelected();
        System.out.println("redo delete");
    }
}
