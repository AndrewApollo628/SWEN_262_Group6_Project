package api;

import java.util.ArrayList;

import comic.Comic;

public interface IComix {

    boolean login(String username, String password);

    void logout();

    // TODO: Add more methods, and remove this one
    String doSomething();
    
    String getCurrentUser();

    ArrayList<Comic> getUserCollection() throws Exception;

    void addToCollection(int comic) throws Exception;

    void addToCollection(Comic comic) throws Exception;

    Comic removeFromCollection(int comic) throws Exception;

    String getComic(String comic);

    ArrayList<Comic> searchComic(String query, String filter, String sort);

    ArrayList<Comic> getAllComics() throws Exception;
}
