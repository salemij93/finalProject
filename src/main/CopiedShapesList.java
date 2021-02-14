package main;

import java.util.ArrayList;

public class CopiedShapesList {
    ShapeList shapelist =  ShapeList.getInstance();
    private ArrayList<IShape> copied = new ArrayList<>();

    public void setCopied(){
        this.copied = shapelist.copySelected();
        System.out.println("copied");
    }
    public ArrayList<IShape> getCopied(){
        return copied;
    }

}
