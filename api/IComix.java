package api;

import java.util.ArrayList;

import comic.Comic;

public interface IComix {

    boolean login(String username, String password);

    void logout();

    // TODO: Add more methods, and remove this one
    String doSomething();
    
    String getCurrentUser();

    ArrayList<Comic> getUserCollection();

    String addToCollection(String comic);

    String removeFromCollection(String comic);

    String getComic(String comic);

    ArrayList<Comic> searchComic(String query, String filter, String sort);

    ArrayList<Comic> getAllComics() throws Exception;
}
