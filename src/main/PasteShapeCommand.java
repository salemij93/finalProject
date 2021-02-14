package main;



public class PasteShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();



    @Override
    public void runCommand() {
        System.out.println("pasted");
        shapelist.addNewShape(shapelist.copied);
        System.out.println(shapelist.shapeListsize());
        shapelist.undrawAll();
        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo pasted");
        shapelist.undrawAll();
        shapelist.drawAll();

    }

    @Override
    public void redoCommand() {
        System.out.println("redo pasted");

    }
}
