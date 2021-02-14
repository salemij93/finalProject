package main;



public class CopiedShapesList {
    ShapeList shapelist =  ShapeList.getInstance();


    public void setCopied(){
        shapelist.copySelected();
        System.out.println("copied");
    }


}
