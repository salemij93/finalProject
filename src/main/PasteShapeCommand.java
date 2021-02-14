package main;

import java.util.ArrayList;

public class PasteShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    ArrayList<IShape> copied = new ArrayList<>();

    public void setCopied(){
        ArrayList<IShape> copied = shapelist.copySelected();
    }
    public ArrayList<IShape> getCopied(){
        return copied;
    }

    @Override
    public void runCommand() {
        System.out.println("pasted");
        ArrayList<IShape> currentCopied = getCopied();
        shapelist.undrawAll();
//        currentCopied.moveSelected(100,100);
        shapelist.addNewShape(currentCopied);
        System.out.println(shapelist.shapeListsize());

        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        ArrayList<IShape> currentCopied = getCopied();
        System.out.println("undo pasted");
//        currentCopied.undrawAll();
        shapelist.removeCopied(currentCopied);


    }

    @Override
    public void redoCommand() {
        ArrayList<IShape> currentCopied = getCopied();
        System.out.println("redo pasted");
//        currentCopied.drawAll();
        shapelist.addNewShape(currentCopied);

    }
}
