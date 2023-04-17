package collection;

import comic.Comic;
import persistence.UsersDAO;
import persistence.UsersJsonDAO;

import java.io.IOException;
import java.util.ArrayList;

public class Collection {

    private ArrayList<Comic> collection;

    public Collection(){
        this.collection = new ArrayList<>();
    }

    /**
     * Alternative constructor for importing a collection
     * @param collection Arraylist of comics
     */
    public Collection(ArrayList<Comic> collection){
        this.collection = collection;
    }

    public void addComic(Comic comic){
        this.collection.add(comic);
    }

    public void addComic(Comic comic, int position) {
        this.collection.add(position, comic);
    }

    public void removeComic(Comic comic){
        this.collection.remove(comic);
    }

    public ArrayList<Comic> getContents(){
        return collection;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "collection=" + collection +
                '}';
    }

}
