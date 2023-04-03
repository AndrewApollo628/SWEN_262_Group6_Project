package comic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlabbedComic extends ConcreteComic {
    
    @JsonProperty("grade") private boolean Slabbed;
   
    public SlabbedComic(boolean Slabbed, Comic comic){
        super(comic);
        this.Slabbed = Slabbed;
    }

    public void addSlab(boolean slab){
        this.Slabbed = slab;
    }

    public boolean getSlab(){
        return Slabbed;
    }
}
