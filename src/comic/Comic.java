package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * Defines the Comic Interface 
 * 
 * @author Andrew Apollo 
 */


 @JsonDeserialize(using = ComicDeserializer.class)
public interface Comic {

    public String getFullTitle();
    
    public String getPublisher();

    // public int getVolumeNumber();

    public int getIssue();

    public String getPublicationDate();

    public List<String> getCreators();

    public String getDescription();

}