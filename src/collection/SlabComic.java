package collection;

import comic.Comic;
import comic.SlabbedComic;

public class SlabComic implements CollectionCommand{

    private Collection collection;
    private Comic comic;

    public SlabComic(Collection collection, Comic comic){
        this.collection = collection;
        this.comic = comic;
    }

    @Override
    public void execute() {
        Comic slabbed = new SlabbedComic(this.comic);
        this.collection.removeComic(this.comic);
        this.collection.addComic(slabbed);
    }
}
