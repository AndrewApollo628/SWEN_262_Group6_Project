package cli.clicmds;

import java.util.ArrayList;

import api.IComix;
import cli.ColorWriter;
import comic.Comic;

public class MyCollection implements ICliCmd {

    private IComix api;
    public static final String COMMAND = "collection";

    public MyCollection(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) throws Exception {
        // arguments = [ collection, view | add [comic] | remove [comic] ]
        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: collection <view | add [comic] | remove [comic]>\n");
        }
        if (args[1].equals("view")) {
            ArrayList<Comic> out = api.getUserCollection();
            if (out != null) {
                System.out.println("Viewing collection for user " + api.getCurrentUser());
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
