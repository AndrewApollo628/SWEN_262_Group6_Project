package comic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConcreteComic {
    
    @JsonProperty("comic") private Comic comic;

    public ConcreteComic(Comic comic){
        this.comic = comic;
    }
}
