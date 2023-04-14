package comic;

public class SlabbedComic extends ComicDec {
    
    public SlabbedComic(Comic comic){
        super(comic);
    }

    @Override
    public String toString() {
        return "SLABBED" + super.toString();
    }

}
