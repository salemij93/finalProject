package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ShapeList {

    private static final ShapeList instance = new ShapeList();
    private ShapeList(){};
    public static ShapeList getInstance(){
        return instance;
    }

    ArrayList<IShape> shapes = new ArrayList<>();
    ArrayList<IShape> copied = new ArrayList<>();


    public void addShape(IShape newshapes) {
        shapes.add(newshapes);
    }

    public void removeShape(IShape shape) {
        shapes.remove(shape);
    }

    public void drawAll() {


        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            shape.draw();
        }

    }

    public void undrawAll() {
        for (int i = 0; i < this.shapeListsize(); i++) {
            IShape shape = this.getShape(i);
            shape.undraw();
        }
    }

    public int shapeListsize() {
        return shapes.size();
    }

    public int[] shapeLocations(int i) {

        IShape shape = shapes.get(i);
        int[] rectB = new int[4];
        switch (shape.getshapeName()){
            case "RECTANGLE", "ELLIPSE" ->{

                rectB[0] = shape.getX1();
                rectB[1] = shape.getY1();
                rectB[2] = shape.getX2();
                rectB[3] = shape.getY2();
            }

            case "TRIANGLE" ->{
                int x1 = shape.getX1();
                int y1 = shape.getY1();
                int x2 = shape.getX2();
                int y2 = shape.getY2();
                int x3 = shape.getX3();
                int y3 = shape.getY3();

                Integer[] xValues = {x1,x2,x3};
                Integer[] yValues = {y1,y2,y3};
                int minX = Collections.min(Arrays.asList(xValues));
                int minY = Collections.min(Arrays.asList(yValues));
                int maxX = Collections.max(Arrays.asList(xValues));
                int maxY = Collections.max(Arrays.asList(yValues));
                rectB[0] = minX;
                rectB[1] = minY;
                rectB[2] = maxX-minX;
                rectB[3] = maxY-minY;


            }
        }



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
            shape.selectedShape();
            System.out.println(shapes.size());


        }
    }

    public void moveSelected(int deltaX, int deltaY) {
        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            if (shape.getState() || shape.getMoved()) {
                shape.updateMoved(true);
                switch (shape.getshapeName()) {
                    case "RECTANGLE", "ELLIPSE" -> {
                        shape.setX1(shape.getX1() + deltaX);
                        shape.setY1(shape.getY1() + deltaY);
                    }
                    case "TRIANGLE" -> {
                        shape.setX1(shape.getX1() + deltaX);
                        shape.setY1(shape.getY1() + deltaY);
                        shape.setY2(shape.getY2() + deltaY);
                        shape.setY3(shape.getY3() + deltaY);
                        shape.setX2(shape.getX2() + deltaX);
                        shape.setX3(shape.getX3() + deltaX);

                    }
                }
            }
        }
    }



    public ArrayList<IShape> removeSelected(){
        ArrayList<IShape> deleted = new ArrayList<>();
        for (int i = 0; i < this.shapeListsize(); i++){
            IShape shape = this.getShape(i);
            if (shape.getState()){
                shape.undraw();
                this.removeShape(shape);
                deleted.add(shape);


            }
        }
        return deleted;
    }

    public void copySelected(){

        for (int i = 0; i < this.shapeListsize(); i++){
            IShape shape = this.getShape(i);
            if (shape.getState()){
                shape.updateSate(true);
                copied.add(shape);
            }
        }

    }

    public IShape getShape(int i){
        IShape shape = shapes.get(i);
        return shape;
    }

    public void addNewShape(ArrayList<IShape> shapeList){
        for (int i = 0; i < shapeList.size(); i++) {
            IShape shape = shapeList.get(i);
            switch (shape.getshapeName()) {
                case "RECTANGLE", "ELLIPSE" -> {
                    shape.setX1(shape.getX1() + 100);
                    shape.setY1(shape.getY1() + 100);
                }
                case "TRIANGLE" -> {
                    shape.setX1(shape.getX1() + 100);
                    shape.setY1(shape.getY1() + 100);
                    shape.setY2(shape.getY2() + 100);
                    shape.setY3(shape.getY3() + 100);
                    shape.setX2(shape.getX2() + 100);
                    shape.setX3(shape.getX3() + 100);

                }
            }

            this.addShape(shape);
        }
    }

    public void removeCopied(ArrayList<IShape> shapeList){
        for (int i = 0; i < shapeList.size(); i++) {
            this.removeShape(shapeList.get(i));
        }
    }

}