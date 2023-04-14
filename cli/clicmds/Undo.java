package cli.clicmds;
import cli.CommandHandler;

public class Undo implements ICliCmd {
    public static final String COMMAND = "undo";
    private CommandHandler handler;

    public Undo(CommandHandler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Usage: " + COMMAND + "\n");
        }
        if (handler.getUndoStack().isEmpty()) {
            throw new Exception("Nothing to undo\n");
        }
        UndoableCmd cmd = (UndoableCmd) handler.getUndoStack().pop();
        cmd.undo();
    }
}