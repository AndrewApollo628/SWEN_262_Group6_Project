package comic;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import persistence.ComicDeserializer;
import persistence.ComicSerializer;

/**
 * Defines the Comic Interface 
 * 
 * @author Andrew Apollo 
 */
@JsonDeserialize(using = ComicDeserializer.class)
@JsonSerialize(using = ComicSerializer.class)
public interface Comic {

    public String getFullTitle();
    
    public String getPublisher();

    public int getIssue();

    public String getPublicationDate();

    public List<String> getCreator();

    public int getValue();

    public String getSeries();

    public String getVariantDescription();

    public String getFormat();

    public String getAddedDate();

    public String getSignature();

    public int getGrade();

    public void setValue(int value);

}