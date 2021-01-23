package main;

import java.awt.*;

public class Shape implements IShape{

    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private String shapeName;
    private String shapeColor;
    private Graphics2D graphics2d;

    Shape(Graphics2D graphics2d){
        this.graphics2d = graphics2d;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public void setshapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getshapeName(){
        return shapeName;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getX2() {
        return x2;
    }

    public void setX3(int x3) {
        this.x3 = x3;
    }

    public int getX1() {
        return x1;
    }

    public int getX3() {
        return x3;
    }

    public int getY1() {
        return y1;
    }

    public int getY2() {
        return y2;
    }

    public int getY3() {
        return y3;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public void setY3(int y3) {
        this.y3 = y3;
    }

    public  void draw(){

        switch (shapeName) {
            case "RECTANGLE" -> graphics2d.fillRect(x1,y1,x2,y2);

            case "ELLIPSE" -> graphics2d.fillOval(x1, y1, x2, y2);

            case "TRIANGLE" -> graphics2d.fillPolygon(new int[]{x1,x2,x3},new int[]{y1,y2,y3},3);

        }
    }
}
