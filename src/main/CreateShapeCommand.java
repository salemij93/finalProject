package main;


public class CreateShapeCommand implements ICommand, IUndoRedo{

    ShapeList shapelist =  ShapeList.getInstance();
    private Shape newshape;
    CreateShapeCommand(Shape newshape){
        this.newshape = newshape;

    }



    @Override
    public void runCommand() {
        shapelist.addShape(newshape);
        shapelist.drawAll();
        CommandHistory.add(this);

    }

    @Override
    public void undoCommand() {
        System.out.println("undo create");
        shapelist.undrawAll();
        System.out.println(shapelist.shapeListsize() + "before undraw");
        shapelist.removeShape(newshape);
        System.out.println(shapelist.shapeListsize()+ "after undraw");
        shapelist.drawAll();

    }

    @Override
    public void redoCommand() {
        System.out.println("redo create");
        shapelist.addShape(newshape);
        shapelist.drawAll();
        System.out.println(shapelist.shapeListsize());


    }
}
