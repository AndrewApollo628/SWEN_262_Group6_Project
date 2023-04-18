package cli.clicmds;

import api.IComix;
import cli.ColorWriter;

public class Signup implements ICliCmd {

    private IComix api;
    public static final String COMMAND = "signup";
    
    public Signup(IComix api) {
        this.api = api;
    }


    @Override
    public void execute(String[] args) throws Exception {
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: signup <username> <password>");
        }
        if (api.signup(args[1], args[2])) {
            ColorWriter.out("User " + args[1] + " created\n", ColorWriter.ANSI_GREEN);
        } else {
            throw new Exception("User " + args[1] + " already exists");
        }
    }

    
}
