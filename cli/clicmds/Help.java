package cli.clicmds;

import java.util.Map;

public class Help implements ICliCmd {

    private Map<String, ICliCmd> commands;
    public static final String COMMAND = "help";

    public Help(Map<String, ICliCmd> commands) {
        this.commands = commands;
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Available commands:");
        for (String cmd : commands.keySet()) {
            System.out.println("  -" + cmd);
        }
    }
    
}
