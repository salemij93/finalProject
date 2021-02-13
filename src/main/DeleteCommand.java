package main;

public class DeleteCommand implements ICommand, IUndoRedo{

    private ShapeList shapeList;
    private ShapeList deleted;

    public DeleteCommand(ShapeList shapeList){
        this.shapeList = shapeList;
    }
    @Override
    public void runCommand() {
        deleted = shapeList.removeSelected();
        System.out.println("delete");
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        shapeList.addNewShape(deleted);
        shapeList.undrawAll();
        shapeList.drawAll();
        System.out.println("undo delete");
    }

    @Override
    public void redoCommand() {
        deleted = shapeList.removeSelected();
        System.out.println("redo delete");
    }
}
