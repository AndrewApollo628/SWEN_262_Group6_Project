package cli.clicmds;
import cli.ColorWriter;
import cli.CommandHandler;

public class Undo implements ICliCmd {
        public static final String COMMAND = "undo";
        private CommandHandler handler;
    
        public Undo(CommandHandler handler) {
            this.handler = handler;
        }
    
        @Override
        public void execute(String[] args) {
            if (handler.getUndoStack().isEmpty()) {
                ColorWriter.out("Nothing to undo\n", ColorWriter.ANSI_RED);
                return;
            }
            UndoableCmd cmd = (UndoableCmd) handler.getUndoStack().pop();
            cmd.undo();
        }

}