package main;

public class PasteShapeCommand implements ICommand, IUndoRedo{

    private ShapeList shapeList;
    private   ShapeList copied = CopiedShapes.copied;
    public PasteShapeCommand(ShapeList shapeList){
        this.shapeList=shapeList;

    }
    @Override
    public void runCommand() {
        System.out.println("pasted");

        copied.moveSelected(100,100);
        shapeList.addNewShape(copied);
        System.out.println(shapeList.shapeListsize());
        shapeList.undrawAll();
        shapeList.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo pasted");
        copied.undrawAll();
        shapeList.removeCopied(copied);

    }

    @Override
    public void redoCommand() {
        System.out.println("redo pasted");
        copied.drawAll();
        shapeList.addNewShape(copied);

    }
}
