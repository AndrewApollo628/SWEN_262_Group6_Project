package cli;

import api.ComixProxy;
import java.util.Scanner;

public class ComixCli {
    static ComixProxy proxy = new ComixProxy();
    private static Scanner scanner = new Scanner(System.in);

    public static String[] readLine() {
        String line = scanner.nextLine();
        return line.split(" ");
    }

    public static void printHelp() {
        System.out.println("Available commands:");
        System.out.println("  -login <username> <password>");
        System.out.println("  -doSomething");
        System.out.println("  -help");
        System.out.println("  -exit");
    }

    public static void handle(String[] commands) throws Exception {
        if (commands.length == 0) { return; }

        String command = commands[0];
        if (command.equals("login")) {
            if (commands.length != 3) {
                throw new IllegalArgumentException("Usage: login <username> <password>\n");
            }
           if (proxy.login(commands[1], commands[2])) {
                ColorWriter.out("Logged in as ", ColorWriter.ANSI_GREEN);
                ColorWriter.out(commands[1]+"\n", ColorWriter.ANSI_CYAN);
           } else {
                ColorWriter.out("Login failed\n", ColorWriter.ANSI_RED);
           }
        } 
        else if (command.equals("doSomething")) {
            System.out.println(proxy.doSomething());
        } 
        else if (command.equals("help")) {
            printHelp();
        } 
        else if (command.equals("exit")) {
            scanner.close();
            System.exit(0);
        } 
        else {
            throw new IllegalArgumentException("Unknown command \"" + command + "\"\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("COMIX CLI v0.1");
        printHelp();
        while (true) {
            System.out.print("> ");
            String[] commands = null;
            try {
                commands = readLine();
            } catch (Exception e) {
                e.printStackTrace();
                scanner.close();
                System.exit(1);
            }
            try {
                handle(commands);
            } catch (Exception e) {
                ColorWriter.out(e.getMessage(), ColorWriter.ANSI_RED+ColorWriter.ANSI_BLINK);
            }
        }
    }

    private class ColorWriter {
        static final String ANSI_RESET = "\u001B[0m";
        static final String ANSI_BLACK = "\u001B[30m";
        static final String ANSI_RED = "\u001B[31m";
        static final String ANSI_GREEN = "\u001B[32m";
        static final String ANSI_YELLOW = "\u001B[33m";
        static final String ANSI_BLUE = "\u001B[34m";
        static final String ANSI_PURPLE = "\u001B[35m";
        static final String ANSI_CYAN = "\u001B[36m";
        static final String ANSI_WHITE = "\u001B[37m";
        static final String ANSI_BLINK = "\u001B[5m";

        public static void out(String text, String color) {
            if (text.endsWith("\n")) {
                System.out.println(color + text.substring(0, text.length() - 1) + ANSI_RESET);
            } else {
                System.out.print(color + text + ANSI_RESET);
            }
        }
    }
}
