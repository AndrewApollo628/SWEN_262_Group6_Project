package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConcreteComic extends Comicdecorator {

    public ConcreteComic(String fullTitle, String publisher, int volumeNumber, int issue, String publicationDate,
            List<String> creators, List<String> principleCharacters, String description, int value, String series) {
        super(fullTitle, publisher, volumeNumber, issue, publicationDate, creators, principleCharacters, description, value,
                series);
    }
    
}
