package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

import comic.Comic;

/**
 * Defines the Data Access Object interface for {@linkplain Comic} data persistence
 * 
 * @author aditya
 */
public class ComicsJsonDAO implements ComicsDAO {
    private String filename;
    private ArrayList<Comic> comics;
    private ObjectMapper mapper;

    public ComicsJsonDAO(String filename) {
        this.filename = filename;
        this.comics = new ArrayList<Comic>();
        this.mapper = new ObjectMapper();
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    public ComicsJsonDAO(String filename, ObjectMapper mapper) {
        this.filename = filename;
        this.comics = new ArrayList<Comic>();
        this.mapper = mapper;
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    private void load() throws Exception {
        Comic[] comicArray = mapper.readValue(new File(filename), Comic[].class);
        comics = new ArrayList<Comic>(Arrays.asList(comicArray));
    }

    @Override
    public ArrayList<Comic> getComics() throws IOException {
        return comics;
    }

    public static void main(String[] args) throws Exception {
        ComicsJsonDAO dao = new ComicsJsonDAO("db/testData.json");
        for (Comic comic : dao.getComics()) {
            System.out.println(comic);
        }
    }
    
}
