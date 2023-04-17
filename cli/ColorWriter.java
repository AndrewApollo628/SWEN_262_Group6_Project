package cli;

import collection.GradeComic;
import comic.Comic;
import comic.GradedComic;

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
            if (comic instanceof comic.SlabbedComic || ((comic.ComicDec) comic).getComic() instanceof comic.SlabbedComic) {
                ColorWriter.out("[SLABBED] ", ColorWriter.ANSI_YELLOW);
            }

            if (comic instanceof comic.GradedComic) {
                ColorWriter.out("Grade " + ((comic.GradedComic) comic).getGrade() + " ", ColorWriter.ANSI_YELLOW);
            }

            if (((comic.ComicDec) comic).getComic() instanceof GradedComic) {
                ColorWriter.out("Grade " + ((GradedComic) ((comic.ComicDec) comic).getComic()).getGrade() + " ", ColorWriter.ANSI_YELLOW);
            }
            
        }
        
        ColorWriter.out(comic.getFullTitle(), ColorWriter.ANSI_CYAN);
        ColorWriter.out(" by " + comic.getCreators(), ColorWriter.ANSI_WHITE);
        ColorWriter.out(" Published by " + comic.getPublisher() + "\n", ColorWriter.ANSI_WHITE);
    }

}
