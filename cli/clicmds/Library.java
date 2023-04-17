package cli.clicmds;
import java.util.ArrayList;
import java.util.List;

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
            throw new IllegalArgumentException("Usage: library <view [searchTerm] [sortBy] [reverse]>\n");
        }
        if (args[1].equals("view")) {
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

        if (args[1].equals("search")) {
            if (args.length < 5) {
                throw new IllegalArgumentException("Usage: library search [searchTerm] [sortBy] [reverse]\n");
            }
            String search = args[2];
            String sort = args[3];
            String reverse = args[4];

            List<Comic> out = api.searchComic(search, "library", sort, reverse);
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

        throw new IllegalArgumentException("Usage: library <view | [searchTerm] [sortBy] [reverse] >\n");
        
    }
  
}


