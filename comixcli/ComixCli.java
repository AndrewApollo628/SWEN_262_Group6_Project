package comixcli;

import api.ComixProxy;

public class ComixCli {

    public static void main(String[] args) {
        System.out.println("COMIX CLI v0.1");
        ComixProxy proxy = new ComixProxy();
        proxy.login("user", "pass");
        proxy.doSomething();
        
    }
}
