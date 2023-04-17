package api;


import java.io.IOException;
import java.util.ArrayList;

import comic.Comic;
import persistence.ComicsDAO;
import persistence.ComicsJsonDAO;
import persistence.UsersDAO;
import persistence.UsersJsonDAO;

public class ComixAPI implements IComix {
    private UsersDAO usersDAO;
    private ComicsDAO comicsDAO;

    private String currentUser;
    public String getCurrentUser() { return currentUser; }

    public ComixAPI() {
        usersDAO = new UsersJsonDAO("db/users.json");
        comicsDAO = new ComicsJsonDAO("db/testData.json");
        // comicsDAO = new ComicsJsonDAO("db/comics.json");
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

    @Override
    public ArrayList<Comic> getAllComics() throws IOException {
        return comicsDAO.getComics();
    }

    @Override
    public ArrayList<Comic> getUserCollection() throws Exception {
        return usersDAO.getCollection(currentUser);
    }

    @Override
    public String addToCollection(String comic) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCollection'");
    }

    @Override
    public String removeFromCollection(String comic) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFromCollection'");
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
}
