package main;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;



public class ShapeList {

    private static final ShapeList instance = new ShapeList();
    private ShapeList(){


    }
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
        for (int i = 0; i < copied.size(); i++) {
            IShape shape = copied.get(i);
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
            case "RECTANGLE", "ELLIPSE", "Group"->{

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
            rectB[0]=0;
            rectB[1]=0;
            rectB[2]=0;
            rectB[3]=0;

        }
    }

    public void moveSelected(int deltaX, int deltaY) {
        for (int i = 0; i < shapes.size(); i++) {
            IShape shape = shapes.get(i);
            if (shape.getState() || shape.getMoved()) {
                shape.updateMoved(true);
                switch (shape.getshapeName()) {
                    case "RECTANGLE", "ELLIPSE", "Group"-> {
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
        int j = this.shapeListsize();
        for (int i = 0; i < j; i++){
            IShape shape = this.getShape(i);
            if (shape.getState()){
                shape.undraw();
                deleted.add(shape);
            }
        }
        for (int i = 0; i < deleted.size(); i++) {
            shapes.remove(deleted.get(i));
        }

        return deleted;
    }

    public void copySelected(){

        for (int i = 0; i < this.shapeListsize(); i++){
            IShape shape = this.getShape(i);
            if(shape.getshapeName().equals("Group")) {
                GroupShape clone2 = new GroupShape(shape);
                clone2 = GroupShape.newInstance(shape);
                copied.add(clone2);
            }else {
                Shape clone = new Shape(shape);
                clone = Shape.newInstance(shape);
                if (shape.getState()) {
                    shape.updateSate(true);

                    copied.add(clone);
                }
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
                case "RECTANGLE", "ELLIPSE", "Group"-> {
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
        this.copied.clear();
    }

    public void addDeletedShape(ArrayList<IShape> shapeList){
        for (int i = 0; i < shapeList.size(); i++) {
            IShape shape = shapeList.get(i);
            switch (shape.getshapeName()) {
                case "RECTANGLE", "ELLIPSE", "Group" -> {
                    shape.setX1(shape.getX1());
                    shape.setY1(shape.getY1() );
                }
                case "TRIANGLE" -> {
                    shape.setX1(shape.getX1() );
                    shape.setY1(shape.getY1() );
                    shape.setY2(shape.getY2() );
                    shape.setY3(shape.getY3() );
                    shape.setX2(shape.getX2() );
                    shape.setX3(shape.getX3() );

                }
            }

            this.addShape(shape);
        }
        this.copied.clear();
    }

    public void removeCopied(ArrayList<IShape> shapeList){
        for (int i = 0; i < shapeList.size(); i++) {
            this.removeShape(shapeList.get(i));
        }
    }

    public void groupShapes(){
        if(shapes.size() >0) {
            GroupShape newGroup = new GroupShape(shapes.get(0).getPaintCanvasBase());
            int minX = shapes.get(0).getX1();
            int minY = shapes.get(0).getY1();
            int maxX = shapes.get(0).getX2()+minX;
            int maxY = shapes.get(0).getY2() + minY;
            for (int i = 0; i < shapes.size(); i++) {
                IShape shape = shapes.get(i);
                if(shape.getX1() < minX){
                    minX = shape.getX1();
                }
                if(shape.getX2() + shape.getX1() > maxX){
                    maxX = shape.getX2()+shape.getX1();
                }
                if(shape.getY1() < minY){
                    minY = shape.getY1();
                }
                if(shape.getY2() + shape.getY1()> maxY) {
                    maxY = shape.getY2()+ shape.getY1();
                }
                if (shape.getState()){
                    newGroup.addShapeToGroup(shape);
                }
            }
            newGroup.setX1(minX);
            newGroup.setX2(maxX-minX);
            newGroup.setY1(minY);
            newGroup.setY2(maxY-minY);
            this.addShape(newGroup);
        }
        this.drawAll();


        System.out.println("grouped");

    }

    public void ungroupShapes(){
        int count = 0;
        for (int i = 0; i < shapes.size(); ++i) {
            IShape shape = shapes.get(i);

            if (shape.getshapeName().equals("Group")){
                count=i;
            }

        }
        if (count > 0) {
        IShape lastGroup = shapes.get(count);
        if (lastGroup.getshapeName().equals("Group")){
        lastGroup.undraw();
        shapes.remove(count);
        }
        }
        this.undrawAll();
        this.drawAll();
        System.out.println("ungrouped");
    }

}

