package api;

public class ComixProxy implements IComix {
    private ComixAPI api = null;

    public ComixProxy() {
        System.out.println("  - loaded COMIX Proxy v0.1");
    }

    public String getCurrentUser() {
        if (api == null) { return null; }
        else { return api.getCurrentUser(); }
    }

    public boolean login(String username, String password) {
        api = new ComixAPI(); // only create the API if we need it
        boolean resp = api.login(username, password);
        if (!resp) { api = null; System.out.println("  - unloaded COMIX API"); }
        return resp;
    }

    public void logout() {
        if (api != null) {
            api.logout();
            api = null;
            System.out.println("  - unloaded COMIX API");
        }
    }

    // TODO: Add more methods, and remove this one
    public String doSomething() {
        if (api == null) {
            return null;
        } else {
            return api.doSomething();
        }
    }

}