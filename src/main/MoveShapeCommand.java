package main;

public class MoveShapeCommand implements ICommand, IUndoRedo{

    private ShapeList shapeList;
    private int deltaX;
    private int deltaY;
    MoveShapeCommand(ShapeList shapeList,int deltaX, int deltaY){
        this.shapeList = shapeList;
        this.deltaX = deltaX;
        this.deltaY = deltaY;

    }
    @Override
    public void runCommand() {
        shapeList.undrawAll();
        shapeList.moveSelected(deltaX, deltaY);
        System.out.println("moved");
        shapeList.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        shapeList.undrawAll();
        shapeList.moveSelected(-deltaX, -deltaY);
        System.out.println("undo move");
        shapeList.drawAll();
    }

    @Override
    public void redoCommand() {
        shapeList.undrawAll();
        shapeList.moveSelected(deltaX, deltaY);
        System.out.println("redo move");
        shapeList.drawAll();
    }
}
