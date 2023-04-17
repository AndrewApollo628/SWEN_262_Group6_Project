package cli.clicmds;

import java.util.ArrayList;
import java.util.Stack;

import api.IComix;
import cli.ColorWriter;
import comic.Comic;

public class MyCollection extends UndoableCmd {

    private IComix api;
    public static final String COMMAND = "collection";

    private Stack<Comic> deletedComicStack = new Stack<Comic>();

    public MyCollection(IComix api) { this.api = api; }

    @Override
    public void execute(String[] args) throws Exception {

        if (args.length < 2) {
            throw new IllegalArgumentException("Usage: collection <view | add [comic] | remove [comic] | grade [comic] | slab [comic] >\n");
        }

        argumentStack.push(args);

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
        if (args[1].equals("add")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Usage: collection add [comic]\n");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            api.addToCollection(comic);
            System.out.println("Added comic " + comic+1 + " to collection");
            return;
        }
        if (args[1].equals("remove")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Usage: collection remove [comic]\n");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            deletedComicStack.push(api.removeFromCollection(comic));
            System.out.println("Removed comic " + comic+1 + " from collection");
            return;
        }

    }

    @Override
    public void undo() throws Exception {
        String[] latest = argumentStack.pop();

        if (latest[1].equals("add")) {
            int comic = api.getUserCollection().size() - 1;
            api.removeFromCollection(comic);
        } else if (latest[1].equals("remove")) {
            Comic comic = deletedComicStack.pop();
            api.addToCollection(comic);
        }

        System.out.println("Undone last action");
    }
    
}
