package api;


import persistence.UsersDAO;
import persistence.UsersJsonDAO;

public class ComixAPI implements IComix {
    private UsersDAO usersDAO;

    private String currentUser;
    public String getCurrentUser() { return currentUser; }

    public ComixAPI() {
        System.out.println("  - loaded COMIX API v0.1");
        usersDAO = new UsersJsonDAO("db/users.json");
    }

    public boolean login(String username, String password) {
        try {
            if (usersDAO.check(username, password)) {
                currentUser = username;
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void logout() { currentUser = null; }
    
    // TODO: Add more methods, and remove this one
    public String doSomething() {
        return "The API just did something";
    }
}
