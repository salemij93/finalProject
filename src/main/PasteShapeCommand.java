package main;

public class PasteShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private ShapeList copied;

    public void setCopied(){
        copied = shapelist.copySelected();
    }
    public ShapeList getCopied(){
        return copied;
    }

    @Override
    public void runCommand() {
        System.out.println("pasted");
        ShapeList currentcopied = getCopied();
        shapelist.undrawAll();
        currentcopied.moveSelected(100,100);
        shapelist.addNewShape(currentcopied);
        System.out.println(shapelist.shapeListsize());

        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        ShapeList currentcopied = getCopied();
        System.out.println("undo pasted");
        currentcopied.undrawAll();
        shapelist.removeCopied(currentcopied);


    }

    @Override
    public void redoCommand() {
        ShapeList currentcopied = getCopied();
        System.out.println("redo pasted");
        currentcopied.drawAll();
        shapelist.addNewShape(currentcopied);

    }
}
