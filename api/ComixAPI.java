package api;


import java.io.IOException;
import java.util.ArrayList;

import collection.AddComic;
import collection.RemoveComic;
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
        return usersDAO.getCollection(currentUser).getContents();
    }

    @Override
    public void addToCollection(int comic) throws Exception {
        Comic comicToAdd = comicsDAO.getComics().get(comic);
        AddComic addComic = new AddComic(comicToAdd, usersDAO, currentUser);
        addComic.execute();
    }

    @Override
    public void addToCollection(Comic comic) throws Exception {
        AddComic addComic = new AddComic(comic, usersDAO, currentUser);
        addComic.execute();
    }

    @Override
    public Comic removeFromCollection(int comic) throws Exception {
        Comic comicToRemove = usersDAO.getCollection(currentUser).getContents().get(comic);
        RemoveComic removeComic = new RemoveComic(comicToRemove, usersDAO, currentUser);
        removeComic.execute();
        return comicToRemove;
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
