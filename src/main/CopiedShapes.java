package main;

import java.util.ArrayList;

public class CopiedShapes {

    ShapeList shapelist =  ShapeList.getInstance();
    ArrayList<IShape> copied = new ArrayList<>();

    public CopiedShapes(){
        this.copied = shapelist.copySelected();
    }

}
