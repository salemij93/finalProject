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
        shapeList.drawAll();
        CommandHistory.add(this);

    }

    @Override
    public void undoCommand() {
        shapeList.removeShape();
        shapeList.drawAll();
    }

    @Override
    public void redoCommand() {
    shapeList.addShape(newshape);
    shapeList.drawAll();
    }
}
