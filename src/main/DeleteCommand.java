package main;

import java.util.ArrayList;

public class DeleteCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private ArrayList<IShape> deleted = new ArrayList<>();


    @Override
    public void runCommand() {
        deleted = shapelist.removeSelected();
        System.out.println("delete");
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        shapelist.addDeletedShape(deleted);
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
