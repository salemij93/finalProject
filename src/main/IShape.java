package main;

public interface IShape {
    int getX1();
    int getX2();
    int getY1();
    int getY2();
    void draw();
    void undraw();
    void updateSate(boolean selected);
}
