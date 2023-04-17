package cli;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import api.IComix;
import cli.clicmds.ICliCmd;
import cli.clicmds.*;

public class CommandHandler {

    private Map<String, ICliCmd> commands = new HashMap<>();
    private Stack<ICliCmd> undoStack = new Stack<>();

    CommandHandler(IComix api) {
        commands.put(Login.COMMAND, new Login(api));
        commands.put(Logout.COMMAND, new Logout(api));
        commands.put(Help.COMMAND, new Help(commands));
        commands.put(Example.COMMAND, new Example(api));
        commands.put(ExampleUndoable.COMMAND, new ExampleUndoable(api));
        commands.put(Undo.COMMAND, new Undo(this));
        commands.put(GetComics.COMMAND, new GetComics(api));
        commands.put(MyCollection.COMMAND, new MyCollection(api));
        // commands.put("exit", new Exit());
    }

    public void exec(String[] cmds) throws Exception {
        String cmd = cmds[0];
        ICliCmd command = commands.get(cmd);
        if (command == null) {
            throw new Exception("Unknown command \"" + cmds[0] + "\"\n");
        }
        if (command instanceof UndoableCmd) {
            undoStack.push(command);
        }
        command.execute(cmds);
    }

    public Stack<ICliCmd> getUndoStack() {
        return undoStack;
    }
    
}
