package cli.clicmds;
import java.util.ArrayList;

import api.IComix;
import cli.ColorWriter;
import comic.Comic;


public class Library implements ICliCmd {

    private IComix api;
    public static final String COMMAND = "library";

    public Library(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: get <show | search='' &| filter=''>\n");
        }
        if (args[1].equals("show")) {
            ArrayList<Comic> out = api.getAllComics();
            if (out != null) {
                int i = 0;
                for (Comic comic : out) {
                    ColorWriter.out((i+1) + " - ", ColorWriter.ANSI_CYAN);
                    ColorWriter.printComic(comic);
                    i++;
                }
            }
            return;
        }
        
    }
  
}


