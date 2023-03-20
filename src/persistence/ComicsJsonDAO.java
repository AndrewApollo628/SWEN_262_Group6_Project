package persistence;

import java.io.IOException;
import java.util.ArrayList;

import comic.Comic;

/**
 * Defines the Data Access Object interface for {@linkplain Comic} data persistence
 * 
 * @author aditya
 */
public class ComicsJsonDAO implements ComicsDAO {

    @Override
    public ArrayList<Comic> getComics() throws IOException {
        return null;
    }

    @Override
    public Comic getComic(int comicID) throws IOException {
        return null;
    }

    @Override
    public Comic updateComic(Comic comic) throws IOException {
        return null;
    }
    
}
