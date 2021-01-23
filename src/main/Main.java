package main;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeType;
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

        // For example purposes only; remove all lines below from your final project.

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

            int x1;
            int x2;
            int x3;
            int y1;
            int y2;
            int y3;

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

            public void drawShape(String shapeType, int x, int y){
                switch (appState.getActivePrimaryColor().toString()){
                    case "BLACK" -> graphics2d.setColor(Color.BLACK);
                    case "RED" -> graphics2d.setColor(Color.RED);
                    case "BLUE" -> graphics2d.setColor(Color.BLUE);
                    case "CYAN" -> graphics2d.setColor(Color.CYAN);
                    case "DARK_GRAY" -> graphics2d.setColor(Color.DARK_GRAY);
                    case "GRAY" -> graphics2d.setColor(Color.GRAY);
                    case "GREEN" -> graphics2d.setColor(Color.GREEN);
                    case "LIGHT_GRAY" -> graphics2d.setColor(Color.LIGHT_GRAY);
                    case "MAGENTA" -> graphics2d.setColor(Color.MAGENTA);
                    case "ORANGE" -> graphics2d.setColor(Color.ORANGE);
                    case "PINK" -> graphics2d.setColor(Color.PINK);
                    case "WHITE" -> graphics2d.setColor(Color.WHITE);
                    case "YELLOW" -> graphics2d.setColor(Color.YELLOW);


                }
                if (shapeType == "TRIANGLE" ){
                    if (x>x1 && y>y1){
                        x3 = x1;
                        y3 = y;
                        graphics2d.fillPolygon(new int[]{x1,x,x3},new int[]{y1,y,y3},3);
                    }else if (x>x1 && y<y1){
                        x3 = x1;
                        y3 = y;
                        graphics2d.fillPolygon(new int[]{x1,x,x3},new int[]{y1,y,y3},3);

                    }else if (x1>x && y1>y){
                        x3 = x;
                        y3 = y1;
                        graphics2d.fillPolygon(new int[]{x1,x,x3},new int[]{y1,y,y3},3);
                    }else if (x1>x && y1<y){
                        x3 = x;
                        y3 = y1;
                        graphics2d.fillPolygon(new int[]{x1,x,x3},new int[]{y1,y,y3},3);
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
                    case "RECTANGLE" -> graphics2d.fillRect(x1,y1,x2,y2);
                    case "ELLIPSE" -> graphics2d.fillOval(x1,y1,x2,y2);

                }


            }


        });
    }
}
