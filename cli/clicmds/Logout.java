package cli.clicmds;
import api.IComix;
import cli.ColorWriter;

public class Logout implements ICliCmd {

    private IComix api;
    public static final String COMMAND = "logout";

    public Logout(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) {
        api.logout();
        ColorWriter.out("Logged out\n", ColorWriter.ANSI_GREEN);
    }
    
}
