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
        System.out.println("undo create");
        shapeList.undrawAll();
        System.out.println(shapeList.shapeListsize() + "before undraw");
        shapeList.removeShape(newshape);
        System.out.println(shapeList.shapeListsize()+ "after undraw");
        shapeList.drawAll();

    }

    @Override
    public void redoCommand() {
        System.out.println("redo create");
        shapeList.addShape(newshape);
        shapeList.drawAll();
        System.out.println(shapeList.shapeListsize());


    }
}
