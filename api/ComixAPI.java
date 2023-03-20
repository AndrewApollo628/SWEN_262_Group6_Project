package api;

public class ComixAPI implements IComix {

    private String currentUser;

    public ComixAPI() {
        System.out.println("  -COMIX API v0.1");
    }

    public boolean login(String username, String password) {
        currentUser = username;
        return true;
    }

    public void logout() { currentUser = null; }
    
    // TODO: Add more methods, and remove this one
    public String doSomething() {
        return "The API just did something";
    }
}
