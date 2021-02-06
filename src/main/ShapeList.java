package main;

import java.util.ArrayList;

public class ShapeList {

    ArrayList<IShape> shapes = new ArrayList<>();

    public void addShape(Shape newshapes) {
        shapes.add(newshapes);
    }

    public void removeShape() {
        shapes.remove(shapes.size() - 1);
    }

    public void drawAll() {


        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            shape.draw();
        }

    }

    public void undrawAll() {
        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            shape.undraw();
        }
    }

    public int shapeListsize() {
        return shapes.size();
    }

    public int[] shapeLocations(int i) {

        IShape shape = shapes.get(i);

        int[] rectB = new int[4];
        rectB[0] = shape.getX1();
        rectB[1] = shape.getY1();
        rectB[2] = shape.getX2();
        rectB[3] = shape.getY2();

        return rectB;
    }


    public void updateAll(int[] rectA) {
        for (int i = 0; i < shapes.size(); i++) {
            int[] rectB = shapeLocations(i);
            IShape shape = shapes.get(i);
            if (
                    rectA[0] < rectB[0] + rectB[2] &&
                            rectA[0] + rectA[2] > rectB[0] &&
                            rectA[1] < rectB[1] + rectB[3] &&
                            rectA[1] + rectA[3] > rectB[1]
            ) {
                System.out.println("select shape " + i);

                shape.updateSate(true);
            } else {
                shape.updateSate(false);
            }


        }
    }

    public void moveSelected(int deltaX, int deltaY) {
        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            if (shape.getState()) {
                switch (shape.getshapeName()) {
                    case "RECTANGLE" -> {
                        shape.setX1(shape.getX1() + deltaX);
                        shape.setY1(shape.getY1() + deltaY);
                    }
                    case "ELLIPSE" -> {
                        shape.setX1(shape.getX1() + deltaX);
                        shape.setY1(shape.getY1() + deltaY);
                    }
                }
            }
        }
    }

}