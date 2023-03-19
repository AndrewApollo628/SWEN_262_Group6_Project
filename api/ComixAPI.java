package api;

public class ComixAPI implements IComix {

    public ComixAPI() {
        System.out.println("  -COMIX API v0.1");
    }

    public boolean login(String username, String password) {
        System.out.println("Logging in as " + username);
        return true;
    }
    
    // TODO: Add more methods, and remove this one
    public void doSomething() {
        System.out.println("Doing something");
    }
}
