package main;

public class PasteShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private ShapeList copied;

    public void setCopied(){
        copied = shapelist.copySelected();
    }

    @Override
    public void runCommand() {
        System.out.println("pasted");

        shapelist.undrawAll();
        copied.moveSelected(100,100);
        shapelist.addNewShape(copied);
        System.out.println(shapelist.shapeListsize());

        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo pasted");
        copied.undrawAll();
        shapelist.removeCopied(copied);


    }

    @Override
    public void redoCommand() {
        System.out.println("redo pasted");
        copied.drawAll();
        shapelist.addNewShape(copied);

    }
}
