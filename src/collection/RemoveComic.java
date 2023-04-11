package collection;

import comic.Comic;

public class RemoveComic implements CollectionCommand{

    private testComic comic;
    private Collection collection;

    public RemoveComic(testComic comic, Collection collection){
        this.comic = comic;
        this.collection = collection;
    }
    @Override
    public void execute() {
        this.collection.removeComic(this.comic);
    }
}
