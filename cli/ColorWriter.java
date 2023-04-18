package cli;

import comic.*;

public class ColorWriter {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLINK = "\u001B[5m";

    public static void out(String text, String color) {
        if (text.endsWith("\n")) {
            System.out.println(color + text.substring(0, text.length() - 1) + ANSI_RESET);
        } else {
            System.out.print(color + text + ANSI_RESET);
        }
    }

    public static void printComic(Comic comic) {
        if (comic instanceof comic.ComicDec) {
            ComicDec comicDec = (comic.ComicDec) comic;

            if (comicDec.isSlabbed()) {
                ColorWriter.out("[SLABBED] ", ColorWriter.ANSI_YELLOW);
            }

            if (comicDec.isGraded()) {
                ColorWriter.out("Grade " + comic.getGrade() + " ", ColorWriter.ANSI_YELLOW);
            }

            if (comicDec.isSigned()) {
                ColorWriter.out("[SIGNED] ", ColorWriter.ANSI_GREEN);
            }
            
        }
        String title = comic.getFullTitle();
        if (title.length() > 22) {
            title = String.format("%-19s...", title);
        }
        String creator = String.join(", ", comic.getCreator());
        if (creator.length() > 20) {
            creator = String.format("%-17s...", creator);
        }
        ColorWriter.out(title, ColorWriter.ANSI_CYAN);
        ColorWriter.out(" by " + creator, ColorWriter.ANSI_WHITE);
        ColorWriter.out(" Published by " + comic.getPublisher(), ColorWriter.ANSI_PURPLE);
        ColorWriter.out(" $" + comic.getValue() + "\n", ColorWriter.ANSI_YELLOW);
    }

}
