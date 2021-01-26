package main;

import java.util.ArrayList;

public class ShapeList {

    ArrayList<IShape> shapes = new ArrayList<IShape>();

    public void addShape(Shape newshapes) {
        shapes.add(newshapes);
    }

    public void removeShape() {
        shapes.remove(shapes.size()-1);
    }

    public void drawAll() {


        for (int i = 0; i < shapes.size(); i++) {
        IShape shape = shapes.get(i);
        shape.draw();
        }

    }

    public void undrawAll(){
        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            shape.undraw();
        }
    }

    public int shapeListsize(){
        return shapes.size();
    }
}
