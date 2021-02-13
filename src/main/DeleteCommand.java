package main;

public class DeleteCommand implements ICommand{

    @Override
    public void runCommand() {
        System.out.println("delete");
    }
}
