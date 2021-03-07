package main;

import java.awt.*;

public interface IShape {
    int getX1();
    int getX2();
    int getX3();
    int getY1();
    int getY2();
    int getY3();
    int getSize();
    IShape getShape(int i);
    void setY1(int y1);
    void setY2(int y2);
    void setY3(int y3);
    void setX1(int x1);
    void setX2(int x2);
    void setX3(int x3);
    void draw();
    void undraw();
    void updateSate(boolean selected);
    boolean getState();
    String getshapeName();
    void selectedShape();
    boolean getMoved();
    void updateMoved(boolean moved);


    String getShapeColor();

    String getoutlineColor();

    String getshadingType();
    Graphics2D getGraphics2d();

}
