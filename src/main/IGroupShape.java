package main;

import java.util.ArrayList;

public interface IGroupShape {
    ArrayList<IShape> grouped();
    ArrayList<IShape> ungrouped();
}
