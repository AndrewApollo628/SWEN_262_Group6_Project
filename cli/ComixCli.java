package cli;

import api.ComixProxy;
import java.util.Scanner;

public class ComixCli {
    static ComixProxy proxy = new ComixProxy();
    private static Scanner scanner = new Scanner(System.in);
    private static CommandHandler cmdMap = new CommandHandler(proxy);

    public static String[] readLine() {
        String line = scanner.nextLine();
        return line.split(" ");
    }

    public static void handle(String[] commands) throws Exception {
        // handle empty or exit command
        if (commands.length == 0) { return; }
        if (commands[0].equals("exit")) { scanner.close(); System.exit(0); } 

        // handle command
        cmdMap.exec(commands);
    }

    public static void main(String[] args) throws Exception {
        
        System.out.println("COMIX CLI v0.1 ( help, exit... )");
        
        while (true) {
            ColorWriter.out("comix> ", ColorWriter.ANSI_YELLOW);
            String[] commands = null;
            
            try { commands = readLine(); }
            catch (Exception e) {
                e.printStackTrace();
                scanner.close();
                System.exit(1);
            }

            try { handle(commands); } 
            catch (Exception e) {
                ColorWriter.out(e.getMessage()+"\n", ColorWriter.ANSI_RED+ColorWriter.ANSI_BLINK);
            }
        }
    }

}
