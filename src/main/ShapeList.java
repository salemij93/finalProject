package main;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class ShapeList {
    private Graphics2D graphics2d;

    ShapeList(Graphics2D graphics2D){
        this.graphics2d = graphics2D;
    }
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape newshapes) {
        shapes.add(newshapes);
    }

    public void removeShape() {
        shapes.remove(shapes.size()-1);
    }

    public void drawAll() {

        graphics2d.drawRect(0,0,Integer.MAX_VALUE,Integer.MAX_VALUE);

        for (int i = 0; i < shapes.size(); i++) {
        IShape shape = shapes.get(i);
        shape.draw();
        }

    }

    public int shapeListsize(){
        return shapes.size();
    }
}
