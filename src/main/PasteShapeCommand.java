package main;


import java.util.ArrayList;

public class PasteShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    ArrayList<IShape> copied = new ArrayList<>();



    @Override
    public void runCommand() {
        System.out.println("pasted");
        for (int i = 0; i < shapelist.copied.size(); i++) {
            this.copied.add(shapelist.copied.get(i));
        }

        shapelist.addNewShape(shapelist.copied);

        System.out.println(shapelist.shapeListsize());
        shapelist.undrawAll();
        shapelist.drawAll();
        CommandHistory.add(this);
    }

    @Override
    public void undoCommand() {
        System.out.println("undo pasted");
        shapelist.removeCopied(this.copied);
        shapelist.undrawAll();
        shapelist.drawAll();

    }

    @Override
    public void redoCommand() {
        for (int i = 0; i < this.copied.size(); i++) {
            shapelist.addShape(copied.get(i));
        }
        shapelist.undrawAll();
        shapelist.drawAll();
        System.out.println("redo pasted");

    }
}
