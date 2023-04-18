package api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import comic.Comic;

public interface IComix {

    boolean login(String username, String password);

    void logout();
    
    String getCurrentUser();

    ArrayList<Comic> getUserCollection() throws Exception;

    void addToCollection(int comic) throws Exception;

    void addToCollection(Comic comic) throws Exception;

    Comic removeFromCollection(int comic) throws Exception;

    List<Comic> searchComic(String query, String Context, String sort, String reverse) throws IOException, Exception;
    ArrayList<Comic> getAllComics() throws Exception;

    void gradeComic(int comic, int grade) throws Exception;

    void slabComic(int comic) throws Exception;

    void unGradeComic(int comic) throws Exception;

    void unSlabComic(int comic) throws Exception;

    void signComic(int comic) throws Exception;

    void unSignComic(int comic) throws Exception;

    boolean signup(String username, String password) throws Exception;

}
