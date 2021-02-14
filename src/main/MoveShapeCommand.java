package main;

public class MoveShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private int deltaX;
    private int deltaY;

    MoveShapeCommand(int deltaX, int deltaY){
        this.deltaX = deltaX;
        this.deltaY = deltaY;


    }
    @Override
    public void runCommand() {
        shapelist.undrawAll();
        shapelist.moveSelected(deltaX, deltaY);

        System.out.println("moved");
        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        shapelist.undrawAll();
        shapelist.moveSelected(-deltaX, -deltaY);
        System.out.println("undo move");
        shapelist.drawAll();
    }

    @Override
    public void redoCommand() {
        shapelist.undrawAll();
        shapelist.moveSelected(deltaX, deltaY);
        System.out.println("redo move");
        shapelist.drawAll();
    }
}
