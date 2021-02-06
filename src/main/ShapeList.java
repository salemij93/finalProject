package main;

import java.util.ArrayList;

public class ShapeList {

    ArrayList<IShape> shapes = new ArrayList<>();

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

    public int[] shapeLocations(int i){

            IShape shape = shapes.get(i);

            int[] rectB = new int[4];
            rectB[0] = shape.getX1();
            rectB[1] = shape.getY1();
            rectB[2] = shape.getX2() + shape.getX1();
            rectB[3] = shape.getY2() + shape.getY1();

        return rectB;
    }


    public void updateAll(int[] rectA){
        for (int i = 0; i < shapes.size(); i++) {
            int[] rectB = shapeLocations(i);

            if (!(rectA[0] < rectB[2] && rectA[2] > rectB[0] &&
                    rectA[1] < rectB[3] && rectA[3] > rectB[1])) {
                System.out.println("selected shape " + i);
            }

        }
    }

}
