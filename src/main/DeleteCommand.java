package main;

public class DeleteCommand implements ICommand, IUndoRedo{

    private ShapeList shapeList;

    public DeleteCommand(ShapeList shapeList){
        this.shapeList = shapeList;

    }
    @Override
    public void runCommand() {
        shapeList.removeSelected();
        System.out.println("delete");
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo delete");
    }

    @Override
    public void redoCommand() {
        System.out.println("redo delete");
    }
}
