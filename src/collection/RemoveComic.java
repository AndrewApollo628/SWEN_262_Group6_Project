package collection;

import comic.Comic;

public class RemoveComic implements CollectionCommand{

    private Comic comic;
    private Collection collection;

    public RemoveComic(Comic comic, Collection collection){
        this.comic = comic;
        this.collection = collection;
    }
    @Override
    public void execute() {
        this.collection.removeComic(this.comic);
    }
}
