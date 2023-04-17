package api;

import java.util.ArrayList;

import comic.Comic;

public interface IComix {

    boolean login(String username, String password);

    void logout();
    
    String getCurrentUser();

    ArrayList<Comic> getUserCollection() throws Exception;

    void addToCollection(int comic) throws Exception;

    void addToCollection(Comic comic) throws Exception;

    Comic removeFromCollection(int comic) throws Exception;

    String getComic(String comic);

    ArrayList<Comic> searchComic(String query, String filter, String sort);

    ArrayList<Comic> getAllComics() throws Exception;

    void gradeComic(int comic, int grade) throws Exception;

    void slabComic(int comic) throws Exception;

    void unGradeComic(int comic) throws Exception;

    void unSlabComic(int comic) throws Exception;

}
