package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlabbedComic extends ComicDec {
    
    public SlabbedComic(Comic comic){
        super(comic);
    }

    @Override
    public String toString() {
        return "SLABBED" + super.toString();
    }

}
