package comic;

public class SignedComic extends ComicDec{

    public SignedComic(Comic comic){
        super(comic);
    }

    @Override
    public String toString(){
        return "Signed " + super.toString();
    }
}
