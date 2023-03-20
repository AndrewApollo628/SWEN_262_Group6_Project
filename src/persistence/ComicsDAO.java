package persistence;

import java.io.IOException;
import java.util.ArrayList;

import comic.Comic;

/**
 * Defines the Data Access Object interface for {@linkplain Comic} data persistence
 * 
 * @author aditya
 */
public interface ComicsDAO {

    Comic[] getComics() throws IOException;

    Comic getComic(int comicID) throws IOException;

    Comic updateComic(Comic comic) throws IOException;

}
