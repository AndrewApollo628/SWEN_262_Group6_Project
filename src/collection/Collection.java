package collection;

import comic.Comic;

import java.util.ArrayList;

public class Collection {

    private ArrayList<Comic> collection;

    public Collection(){
        this.collection = new ArrayList<>();
    }

    public void addComic(Comic comic){
        this.collection.add(comic);
    }

    public void removeComic(Comic comic){
        this.collection.remove(comic);
    }

    public ArrayList<Comic> getContents(){
        return collection;
    }
}
