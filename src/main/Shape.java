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
    private String outlineColor;
    private String shadingType;
        private Graphics2D graphics2d;
    private IState currentState;
    private final IState selectedState = new SelectedState();
    private final IState notSelectedState = new NotSelectedState();

    Shape(Graphics2D graphics2D){
        this.graphics2d = graphics2D;
        currentState = notSelectedState;
    }


    public String getShapeColor() {
        return shapeColor;
    }

    public void setShapeColor(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getoutlineColor() {  return outlineColor;   }

    public void setoutlineColor(String outlineColor) {
        this.outlineColor = outlineColor;
    }

    public void setshapeName(String shapeName) {
        this.shapeName = shapeName;
    }
    public String getshapeName(){
        return shapeName;
    }

    public void setshadingType(String  shadingType){this.shadingType = shadingType;}
    public String getshadingType(){return shadingType;}

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

        switch (getShapeColor()){
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
        switch (getshadingType()) {
            case "FILLED_IN" -> {
                switch (getshapeName()) {
                    case "RECTANGLE" -> graphics2d.fillRect(x1,y1,x2,y2);

                    case "ELLIPSE" -> graphics2d.fillOval(x1, y1, x2, y2);

                    case "TRIANGLE" -> graphics2d.fillPolygon(new int[]{x1,x2,x3},new int[]{y1,y2,y3},3);

                }
            }
            case "OUTLINE" -> {
                graphics2d.setStroke(new BasicStroke(2));
                switch (getshapeName()) {
                    case "RECTANGLE" -> graphics2d.drawRect(x1,y1,x2,y2);

                    case "ELLIPSE" -> graphics2d.drawOval(x1, y1, x2, y2);

                    case "TRIANGLE" -> graphics2d.drawPolygon(new int[]{x1,x2,x3},new int[]{y1,y2,y3},3);

                }
            }
            case "OUTLINE_AND_FILLED_IN" -> {
                graphics2d.setStroke(new BasicStroke(2));
                switch (getshapeName()) {
                    case "RECTANGLE" -> {
                        graphics2d.fillRect(x1,y1,x2,y2);

                        switch (getoutlineColor()){
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
                        graphics2d.drawRect(x1,y1,x2,y2);}

                    case "ELLIPSE" -> {graphics2d.fillOval(x1, y1, x2, y2);
                        switch (getoutlineColor()){
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
                        graphics2d.drawOval(x1,y1,x2,y2);}

                    case "TRIANGLE" -> {
                        graphics2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
                        switch (getoutlineColor()){
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
                        graphics2d.drawPolygon(new int[]{x1,x2,x3},new int[]{y1,y2,y3},3);
                    }

                }
            }
        }



    }

    public void undraw() {
        graphics2d.setColor(Color.WHITE);
        graphics2d.setStroke(new BasicStroke(2));
        switch (getshapeName()) {
            case "RECTANGLE" -> {
                graphics2d.fillRect(x1, y1, x2, y2);
                graphics2d.drawRect(x1, y1, x2, y2);
            }

            case "ELLIPSE" -> {
                graphics2d.fillOval(x1, y1, x2, y2);
                graphics2d.drawOval(x1, y1, x2, y2);
            }

            case "TRIANGLE" -> {
                graphics2d.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
                graphics2d.drawPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
            }

        }
    }

    public void updateSate(boolean selected){
        if (selected){
            currentState = selectedState;
        }else {
            currentState = notSelectedState;
        }
    }

    public boolean getState(){
        return currentState.selected();
    }
}
