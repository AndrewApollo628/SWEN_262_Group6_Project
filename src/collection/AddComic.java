package collection;

import comic.Comic;

public class AddComic implements CollectionCommand{

    private Collection collection;
    private Comic comic;

    public AddComic(Comic comic, Collection collection){
        this.comic = comic;
        this.collection = collection;
    }

    @Override
    public void execute(){
        this.collection.addComic(this.comic);
    }
}
