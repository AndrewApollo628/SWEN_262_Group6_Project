package cli;

import api.ComixProxy;
import cli.clicmds.ICliCmd;

import java.util.Scanner;

public class ComixCli {
    static ComixProxy proxy = new ComixProxy();
    private static Scanner scanner = new Scanner(System.in);
    private static CommandMap cmdMap = new CommandMap(proxy);

    public static String[] readLine() {
        String line = scanner.nextLine();
        return line.split(" ");
    }

    public static void handle(String[] commands) throws Exception {
        if (commands.length == 0) { return; }
        if (commands[0].equals("exit")) {
            scanner.close();
            System.exit(0);
        } 

        ICliCmd cmd = cmdMap.get(commands[0]);
        if (cmd != null) {
            cmd.execute(commands);
            return;
        }

        // else if (command.equals("logout")) {
        //     proxy.logout();
        //     ColorWriter.out("Logged out\n", ColorWriter.ANSI_GREEN);
        // }
        // else if (command.equals("doSomething")) {
        //     String out = proxy.doSomething();
        //     if (out != null) {
        //         ColorWriter.out(out+"\n", ColorWriter.ANSI_WHITE); return;
        //     }
        //     ColorWriter.out("Not logged in\n", ColorWriter.ANSI_RED);
        // } 
        // else if (command.equals("help")) {
        //     printHelp();
        // } 
        // else if (command.equals("exit")) {
        //     scanner.close();
        //     System.exit(0);
        // } 
        throw new IllegalArgumentException("Unknown command \"" + commands[0] + "\"\n");
    }

    public static void main(String[] args) {
        System.out.println("COMIX CLI v0.1");
        
        while (true) {
            ColorWriter.out("comix> ", ColorWriter.ANSI_BLUE);
            String[] commands = null;
            
            try { commands = readLine(); }
            catch (Exception e) {
                e.printStackTrace();
                scanner.close();
                System.exit(1);
            }

            try { handle(commands); } 
            catch (Exception e) {
                ColorWriter.out(e.getMessage(), ColorWriter.ANSI_RED+ColorWriter.ANSI_BLINK);
            }
        }
    }

}
