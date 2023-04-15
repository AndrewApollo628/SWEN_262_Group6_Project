package collection;

import comic.Comic;
import comic.SignedComic;

public class SignComic implements CollectionCommand{

    private Collection collection;
    private Comic comic;

    public SignComic(Collection collection, Comic comic){
        this.collection = collection;
        this.comic = comic;
    }

    @Override
    public void execute(){
        Comic signed = new SignedComic(this.comic);
        this.collection.removeComic(this.comic);
        this.collection.addComic(this.comic);
    }
}
