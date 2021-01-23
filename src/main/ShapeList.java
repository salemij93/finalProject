package main;
import java.util.ArrayList;

public class ShapeList {
    ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addShape(Shape newshapes){
        shapes.add(newshapes);

    }

   public void removeShape(){
       shapes.remove(shapes.size()-1);
   }


}
