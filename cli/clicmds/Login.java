package cli.clicmds;

import api.IComix;
import cli.ColorWriter;

public class Login implements ICliCmd {

    private IComix api;

    public static final String COMMAND = "login";

    public Login(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: login <username> <password>\n");
        }
       if (api.login(args[1], args[2])) {
            ColorWriter.out("Logged in as ", ColorWriter.ANSI_GREEN);
            ColorWriter.out(args[1]+"\n", ColorWriter.ANSI_CYAN);
       } else {
            ColorWriter.out("Login failed\n", ColorWriter.ANSI_RED);
       }
    }
    
}
