package main;


public class CreateShapeCommand implements ICommand, IUndoRedo{

    private ShapeList shapeList;
    private Shape newshape;
    CreateShapeCommand(ShapeList shapeList, Shape newshape){
        this.shapeList = shapeList;
        this.newshape = newshape;
    }


    @Override
    public void runCommand() {
        shapeList.addShape(newshape);
        CommandHistory.add(this);
        shapeList.drawAll();
    }

    @Override
    public void undoCommand() {
        UndoCommand undo = new UndoCommand();
        undo.runCommand();
        shapeList.removeShape();
    }

    @Override
    public void redoCommand() {
    RedoCommand redo = new RedoCommand();
    redo.runCommand();
    shapeList.addShape(newshape);
    }
}
