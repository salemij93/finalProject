package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args){
        PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        IJPaintController controller = new JPaintController(uiModule, appState);
        controller.setup();
        ShapeList shapeslist = new ShapeList();

        // For example purposes only; remove all lines below from your final project.

//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Filled in rectangle
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
//        graphics2d.setColor(Color.GREEN);
//        graphics2d.fillRect(12, 13, 200, 400);
//
//        // Outlined rectangle
//        graphics2d.setStroke(new BasicStroke(5));
//        graphics2d.setColor(Color.BLUE);
//        graphics2d.drawRect(12, 13, 200, 400);
//
//        // Selected Shape
//        Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
//        graphics2d.setStroke(stroke);
//        graphics2d.setColor(Color.BLACK);
//        graphics2d.drawRect(7, 8, 210, 410);

        paintCanvas.addMouseListener(new MouseAdapter(){

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
                    case "SELECT" -> System.out.println("Mouse Released Select: ("
                            + e.getX() + ", " + e.getY() + ")");
                    case "MOVE" -> System.out.println("Mouse Released Move: ("
                            + e.getX() + ", " + e.getY() + ")");
                }



            }
            Shape newshape = new Shape(graphics2d);
            public void drawShape(String shapeType, int x, int y){


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

                CreateShapeCommand createShape = new CreateShapeCommand(shapeslist,newshape);
                createShape.runCommand();
                graphics2d.setColor(Color.WHITE);
                graphics2d.drawRect(0,0,paintCanvas.getWidth(), paintCanvas.getHeight());

            }



        });
    }
}
