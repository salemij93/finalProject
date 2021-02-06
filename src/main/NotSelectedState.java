package main;

public class NotSelectedState implements IState{
    @Override
    public boolean selected() {
        return false;
    }
}
