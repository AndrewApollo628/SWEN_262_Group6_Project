package cli.clicmds;
import java.util.Stack;

public abstract class UndoableCmd implements ICliCmd {

    protected Stack<String[]> argumentStack = new Stack<String[]>();

    public abstract void execute(String[] args) throws Exception;

    public abstract void undo() throws Exception;
    
}
