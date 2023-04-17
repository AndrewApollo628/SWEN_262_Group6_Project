package comic;

public class SignedComic extends ComicDec{

    private String signature;

    public SignedComic(Comic comic, String signature){
        super(comic);
    }

    @Override
    public String toString(){
        return "SIGNED " + super.toString();
    }

    public String getSignature(){
        return signature;
    }
}
