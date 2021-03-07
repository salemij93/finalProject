package main;

import java.awt.*;
import java.util.ArrayList;

public class GroupShape implements IShape{

    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;


    private Graphics2D graphics2d;
    private IState currentState;
    private IState wasMoved;
    private final IState selectedState = new SelectedState();
    private final IState notSelectedState = new NotSelectedState();
    private ArrayList<IShape> items= new ArrayList<IShape>();

    GroupShape(Graphics2D graphics2D){
        this.graphics2d = graphics2D;
        this.currentState = selectedState;
        this.wasMoved = notSelectedState;
    }
    @Override
    public int getX1() {
        return x1;
    }

    @Override
    public int getX2() {
        return x2;
    }

    @Override
    public int getX3() {
        return x3;
    }

    @Override
    public int getY1() {
        return y1;
    }

    @Override
    public int getY2() {
        return y2;
    }

    @Override
    public int getY3() {
        return y3;
    }

    @Override
    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public void setY2(int y2) {
        this.y2 = y2;
    }

    @Override
    public void setY3(int y3) {
        this.y3 = 0;
    }

    @Override
    public void setX1(int x1) {
        this.x1=x1;
    }

    @Override
    public void setX2(int x2) {
        this.x2=x2;
    }

    @Override
    public void setX3(int x3) {
        this.x3 = 0;
    }

    @Override
    public void draw() {
        graphics2d.setColor(Color.BLACK);
        Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
        graphics2d.setStroke(stroke);
        graphics2d.drawRect(x1+2, y1+2, x2-4, y2-4);

    }

    @Override
    public void undraw() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.setStroke(new BasicStroke(2));
        graphics2d.drawRect(x1+2, y1+2, x2-4, y2-4);


    }

    @Override
    public void updateSate(boolean selected) {
        if (selected){
            currentState = selectedState;
        }else {
            currentState = notSelectedState;
        }
    }

    @Override
    public boolean getState() {
        return currentState.selected();
    }

    @Override
    public String getshapeName() {
        return "Group";
    }

    @Override
    public void selectedShape() {
        if(this.getState()){
            graphics2d.setColor(Color.BLACK);
            Stroke stroke = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
            graphics2d.setStroke(stroke);
            graphics2d.drawRect(x1+2, y1+2, x2-4, y2-4);
        }else if(!this.getState()){
            graphics2d.setColor(Color.WHITE);
            graphics2d.setStroke(new BasicStroke(2));
            graphics2d.drawRect(x1+2, y1+2, x2-4, y2-4);

        }


    }

    @Override
    public boolean getMoved() {
        return wasMoved.selected();
    }

    @Override
    public void updateMoved(boolean moved) {
        if (moved){
            wasMoved = selectedState;
        }else{
            wasMoved = notSelectedState;
        }
    }

    @Override
    public String getShapeColor() {
        return "BLACK";
    }

    @Override
    public String getoutlineColor() {
        return "BLACK";
    }

    @Override
    public String getshadingType() {
        return "OUTLINE";
    }

    @Override
    public Graphics2D getGraphics2d() {
        return this.graphics2d;
    }

    public void addShapeToGroup(IShape newShape){
        items.add(newShape);
    }
}
