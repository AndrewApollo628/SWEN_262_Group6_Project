package cli.clicmds;

import java.util.ArrayList;
import java.util.List;
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
            throw new IllegalArgumentException("Usage: collection <view | add | remove | grade | slab | sign | search>");
        }

        argumentStack.push(args);

        if (args[1].equals("view")) {
            ArrayList<Comic> out = api.getUserCollection();
            argumentStack.pop();
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
                throw new IllegalArgumentException("Usage: collection add [comic]");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            api.addToCollection(comic);
            System.out.println("Added comic " + (comic+1) + " to collection");
            return;
        }
        if (args[1].equals("remove")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Usage: collection remove [comic]");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            deletedComicStack.push(api.removeFromCollection(comic));
            System.out.println("Removed comic " + (comic+1) + " from collection");
            return;
        }
        if (args[1].equals("grade")) {
            if (args.length < 4) {
                throw new IllegalArgumentException("Usage: collection grade [comic] [grade]");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            int grade = Integer.parseInt(args[3]);
            api.gradeComic(comic, grade);
            System.out.println("Graded comic " + (comic+1) + " with grade " + grade);
            return;
        }
        if (args[1].equals("slab")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Usage: collection slab [comic]");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            api.slabComic(comic);
            System.out.println("Slabbed comic " + (comic+1));
            return;
        }
        if (args[1].equals("sign")) {
            if (args.length < 3) {
                throw new IllegalArgumentException("Usage: collection sign [comic]");
            }
            int comic = Integer.parseInt(args[2]) - 1;
            api.signComic(comic);
            System.out.println("Signed comic " + (comic+1));
            return;
        }

        if (args[1].equals("search")) {
            if (args.length < 5) {
                throw new IllegalArgumentException("Usage: collection search [search] [sort] [reverse]");
            }
            String search = args[2];
            String sort = args[3];
            String reverse = args[4];
            List<Comic> out = api.searchComic(search, "collection", sort, reverse);
            argumentStack.pop();

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

        throw new IllegalArgumentException("Usage: collection <view | add | remove | grade | slab | sign | search>");

    }

    @Override
    public void undo() throws Exception {
        String[] lastArg = argumentStack.pop();
        if (lastArg == null) {
            throw new Exception("Nothing to undo\n");
        }
        if (lastArg[1].equals("add")) {
            int comic = api.getUserCollection().size() - 1;
            System.out.println("Undo adding comic " + (comic+1) + " to collection");
            api.removeFromCollection(comic);
            return;
        } 
        if (lastArg[1].equals("remove")) {
            Comic comic = deletedComicStack.pop();
            System.out.println("Undo removing comic from collection");
            api.addToCollection(comic);
            return;
        }
        if (lastArg[1].equals("grade")) {
            int comic = Integer.parseInt(lastArg[2]) - 1;
            int grade = Integer.parseInt(lastArg[3]);
            System.out.println("Undo grading comic " + (comic+1) + " with grade " + grade);
            api.gradeComic(comic, 0);
            return;
        }
        if (lastArg[1].equals("slab")) {
            int comic = Integer.parseInt(lastArg[2]) - 1;
            System.out.println("Undo slabbing comic " + (comic+1));
            api.unSlabComic(comic);
            return;
        }
        if (lastArg[1].equals("sign")) {
            int comic = Integer.parseInt(lastArg[2]) - 1;
            System.out.println("Undo signing comic " + (comic+1));
            api.unSignComic(comic);
            return;
        }
    }
    
}
