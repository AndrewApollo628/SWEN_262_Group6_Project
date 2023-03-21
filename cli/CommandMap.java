package cli;

import java.util.HashMap;
import java.util.Map;

import api.IComix;
import cli.clicmds.ICliCmd;
import cli.clicmds.*;

public class CommandMap {

    private Map<String, ICliCmd> commands = new HashMap<>();

    CommandMap(IComix api) {
        commands.put(Login.COMMAND, new Login(api));
        commands.put(Help.COMMAND, new Help(commands));
        // commands.put("logout", new Logout(api));
        // commands.put("doSomething", new DoSomething(api));
        // commands.put("help", new Help());
        // commands.put("exit", new Exit());
    }

    public ICliCmd get(String cmd) throws IllegalArgumentException {
        try {
            return commands.get(cmd);
        } catch (Exception e) {
            return null;
        }
    }
    
}
