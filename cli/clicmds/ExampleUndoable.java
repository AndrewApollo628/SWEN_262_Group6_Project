package cli.clicmds;
import api.IComix;
import cli.ColorWriter;

public class ExampleUndoable extends UndoableCmd {

    private IComix api;
    public static final String COMMAND = "undoable";

    public ExampleUndoable(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) {
        String out = api.doSomething();
        if (out != null) {
            ColorWriter.out(out+"\n", ColorWriter.ANSI_WHITE); return;
        }
        ColorWriter.out("Not logged in\n", ColorWriter.ANSI_RED);
        
    }

    @Override
    public void undo() {
        ColorWriter.out("Undoing ExampleUndoable\n", ColorWriter.ANSI_WHITE);
    }
    
}
