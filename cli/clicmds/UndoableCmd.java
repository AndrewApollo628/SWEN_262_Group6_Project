package cli.clicmds;

public abstract class UndoableCmd implements ICliCmd {

    public abstract void execute(String[] args);

    public abstract void undo();
    
}
