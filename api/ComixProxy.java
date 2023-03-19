package api;

public class ComixProxy implements IComix {
    private ComixAPI api = null;

    public ComixProxy() {
        System.out.println("  -COMIX Proxy v0.1");
    }

    public boolean login(String username, String password) {
        api = new ComixAPI(); // only create the API if we need it
        boolean resp = api.login(username, password);
        if (resp) {
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed");
            api = null;
        }
        return resp;
    }

    // TODO: Add more methods, and remove this one
    public void doSomething() {
        if (api == null) {
            System.out.println("Not logged in");
        } else {
            api.doSomething();
        }
    }

}