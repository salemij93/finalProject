package main;
import java.awt.*;
import java.awt.event.*;

import model.persistence.ApplicationState;

import view.interfaces.PaintCanvasBase;


public class MyMouseListener extends MouseAdapter{

    private PaintCanvasBase paintCanvas;
    private ApplicationState appState;
    private Graphics2D graphics2d;
    ShapeList shapelist =  ShapeList.getInstance();


    MyMouseListener(PaintCanvasBase PaintCanvas,ApplicationState AppState){

        this.paintCanvas = PaintCanvas;
        this.appState = AppState;
        this.graphics2d = PaintCanvas.getGraphics2D();



    }


    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;




    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed: ("
                +e.getX()+", "+e.getY() +")");
        x1 = e.getX();
        y1 = e.getY();



    }

    public void mouseReleased(MouseEvent e) {
        switch (appState.getActiveMouseMode().toString()) {
            case "DRAW" -> {System.out.println("Mouse Released Draw: ("
                    + e.getX() + ", " + e.getY() + ")");
                drawShape(appState.getActiveShapeType().toString(),
                        e.getX(),e.getY());
            }
            case "SELECT" -> {
                System.out.println("Mouse Released Select: ("
                    + e.getX() + ", " + e.getY() + ")");
                selectShape(e.getX(),e.getY());
            }

            case "MOVE" -> {
                System.out.println("Mouse Released Move: ("
                        + e.getX() + ", " + e.getY() + ")");
                moveShape(e.getX(),e.getY());

            }
        }



    }

    public void drawShape(String shapeType, int x, int y){

        Shape newshape = new Shape(graphics2d);

        switch (appState.getActiveShapeShadingType().toString()){
            case "FILLED_IN" -> newshape.setshadingType("FILLED_IN");
            case "OUTLINE" -> newshape.setshadingType("OUTLINE");
            case "OUTLINE_AND_FILLED_IN" -> newshape.setshadingType("OUTLINE_AND_FILLED_IN");
        }


        switch (appState.getActivePrimaryColor().toString()){
            case "BLACK" -> {graphics2d.setColor(Color.BLACK);
                newshape.setShapeColor("BLACK");}
            case "RED" -> {graphics2d.setColor(Color.RED);
                newshape.setShapeColor("RED");}
            case "BLUE" -> {graphics2d.setColor(Color.BLUE);
                newshape.setShapeColor("BLUE");}
            case "CYAN" -> {graphics2d.setColor(Color.CYAN);
                newshape.setShapeColor("CYAN");}
            case "DARK_GRAY" -> {graphics2d.setColor(Color.DARK_GRAY);
                newshape.setShapeColor("DARK_GRAY");}
            case "GRAY" -> {graphics2d.setColor(Color.GRAY);
                newshape.setShapeColor("GRAY");}
            case "GREEN" -> {graphics2d.setColor(Color.GREEN);
                newshape.setShapeColor("GREEN");}
            case "LIGHT_GRAY" -> {graphics2d.setColor(Color.LIGHT_GRAY);
                newshape.setShapeColor("LIGHT_GRAY");}
            case "MAGENTA" -> {graphics2d.setColor(Color.MAGENTA);
                newshape.setShapeColor("MAGENTA");}
            case "ORANGE" -> {graphics2d.setColor(Color.ORANGE);
                newshape.setShapeColor("ORANGE");}
            case "PINK" -> {graphics2d.setColor(Color.PINK);
                newshape.setShapeColor("PINK");}
            case "WHITE" -> {graphics2d.setColor(Color.WHITE);
                newshape.setShapeColor("WHITE");}
            case "YELLOW" -> {graphics2d.setColor(Color.YELLOW);
                newshape.setShapeColor("YELLOW");}
        }
        switch (appState.getActiveSecondaryColor().toString()){
            case "BLACK" -> {graphics2d.setColor(Color.BLACK);
                newshape.setoutlineColor("BLACK");}
            case "RED" -> {graphics2d.setColor(Color.RED);
                newshape.setoutlineColor("RED");}
            case "BLUE" -> {graphics2d.setColor(Color.BLUE);
                newshape.setoutlineColor("BLUE");}
            case "CYAN" -> {graphics2d.setColor(Color.CYAN);
                newshape.setoutlineColor("CYAN");}
            case "DARK_GRAY" -> {graphics2d.setColor(Color.DARK_GRAY);
                newshape.setoutlineColor("DARK_GRAY");}
            case "GRAY" -> {graphics2d.setColor(Color.GRAY);
                newshape.setoutlineColor("GRAY");}
            case "GREEN" -> {graphics2d.setColor(Color.GREEN);
                newshape.setoutlineColor("GREEN");}
            case "LIGHT_GRAY" -> {graphics2d.setColor(Color.LIGHT_GRAY);
                newshape.setoutlineColor("LIGHT_GRAY");}
            case "MAGENTA" -> {graphics2d.setColor(Color.MAGENTA);
                newshape.setoutlineColor("MAGENTA");}
            case "ORANGE" -> {graphics2d.setColor(Color.ORANGE);
                newshape.setoutlineColor("ORANGE");}
            case "PINK" -> {graphics2d.setColor(Color.PINK);
                newshape.setoutlineColor("PINK");}
            case "WHITE" -> {graphics2d.setColor(Color.WHITE);
                newshape.setoutlineColor("WHITE");}
            case "YELLOW" -> {graphics2d.setColor(Color.YELLOW);
                newshape.setoutlineColor("YELLOW");}
        }

        if (shapeType == "TRIANGLE" ){
            newshape.setshapeName("TRIANGLE");
            if (x>x1 && y>y1){
                x3 = x1;
                y3 = y;
                newshape.setshapeName("TRIANGLE");
                newshape.setX1(x1);
                newshape.setX2(x);
                newshape.setY1(y1);
                newshape.setY2(y);
                newshape.setY3(y3);
                newshape.setX3(x3);

            }else if (x>x1 && y<y1){
                x3 = x1;
                y3 = y;
                newshape.setshapeName("TRIANGLE");
                newshape.setX1(x1);
                newshape.setX2(x);
                newshape.setY1(y1);
                newshape.setY2(y);
                newshape.setY3(y3);
                newshape.setX3(x3);

            }else if (x1>x && y1>y){
                x3 = x;
                y3 = y1;
                newshape.setshapeName("TRIANGLE");
                newshape.setX1(x1);
                newshape.setX2(x);
                newshape.setY1(y1);
                newshape.setY2(y);
                newshape.setY3(y3);
                newshape.setX3(x3);
            }else if (x1>x && y1<y){
                x3 = x;
                y3 = y1;
                newshape.setshapeName("TRIANGLE");
                newshape.setX1(x1);
                newshape.setX2(x);
                newshape.setY1(y1);
                newshape.setY2(y);
                newshape.setY3(y3);
                newshape.setX3(x3);
            }}else {
            if (x1>x){
                x2 = Math.abs(x-x1);
                x1 = x;

            }else if(x1<x) {
                x2 = Math.abs(x - x1);

            }
            if (y1> y){
                y2 = Math.abs(y-y1);
                y1 = y;

            } else if (y1<y) {
                y2 = Math.abs(y - y1);

            }
        }



        switch (shapeType) {
            case "RECTANGLE" -> {
                newshape.setshapeName("RECTANGLE");
                newshape.setX1(x1);
                newshape.setX2(x2);
                newshape.setY1(y1);
                newshape.setY2(y2);
                newshape.setY3(0);
                newshape.setX3(0);

            }
            case "ELLIPSE" -> {
                newshape.setshapeName("ELLIPSE");
                newshape.setX1(x1);
                newshape.setX2(x2);
                newshape.setY1(y1);
                newshape.setY2(y2);
                newshape.setY3(0);
                newshape.setX3(0);
            }

        }

        CreateShapeCommand createShape = new CreateShapeCommand(newshape);
        createShape.runCommand();



    }

    public void selectShape(int x, int y){
        if (x1>x){
            x2 = Math.abs(x-x1);
            x1 = x;

        }else if(x1<x) {
            x2 = Math.abs(x - x1);

        }else {
            x2 = 1;
        }
        if (y1> y){
            y2 = Math.abs(y-y1);
            y1 = y;

        } else if (y1<y) {
            y2 = Math.abs(y - y1);

        }else{
            y2 = 1;
        }
        int[] rectA = new int[]{x1,y1,x2,y2 };
        shapelist.updateAll(rectA);




        }



    public void moveShape(int x, int y){
        int deltaX = x-x1;
        int deltaY = y-y1;

        MoveShapeCommand moveShape = new MoveShapeCommand(deltaX,deltaY);
        moveShape.runCommand();
    }






}
