package api;

import java.io.IOException;
import java.util.ArrayList;

import comic.Comic;
import persistence.ComicsJsonDAO;

public class ComixProxy implements IComix {
    private ComixAPI api = new ComixAPI();
    private boolean loggedIn = false;

    public String getCurrentUser() {
        if (loggedIn) { return null; }
        else { return api.getCurrentUser(); }
    }

    public boolean login(String username, String password) {
        loggedIn = api.login(username, password);
        return loggedIn;
    }

    public void logout() {
        if (!loggedIn) {
            api.logout();
            loggedIn=false;
            System.out.println("  - unloaded COMIX API");
        }
    }

    // TODO: Add more methods, and remove this one
    public String doSomething() {
        if (loggedIn) {
            return null;
        } else {
            return api.doSomething();
        }
    }

    @Override
    public ArrayList<Comic> getUserCollection() throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in\n");
        } else {
            return api.getUserCollection();
        }
    }

    @Override
    public void addToCollection(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.addToCollection(comic);
        }
    }

    @Override
    public void addToCollection(Comic comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            api.addToCollection(comic);
        }
    }

    @Override
    public Comic removeFromCollection(int comic) throws Exception {
        if (!loggedIn) {
            throw new UnsupportedOperationException("User not logged in");
        } else {
            return api.removeFromCollection(comic);
        }
    }

    @Override
    public String getComic(String comic) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getComic'");
    }

    @Override
    public ArrayList<Comic> searchComic(String query, String filter, String sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchComic'");
    }

    @Override
    public ArrayList<Comic> getAllComics() throws IOException {
        if (!loggedIn) {
            System.out.println("<<GUEST MODE>>");
        }
        return api.getAllComics();
    }

}