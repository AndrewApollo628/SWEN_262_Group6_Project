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

    ArrayList<Comic> getComics() throws IOException;

}
