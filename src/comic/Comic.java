package comic;

import java.util.List;

/**
 * Defines the Comic Interface 
 * 
 * @author Andrew Apollo 
 */

public interface Comic {

    public String getFullTitle();
    
    public String getPublisher();

    public int getVolumeNumber();

    public int getIssue();

    public String getPublicationDate();

    public List<String> getCreators();

    public String getDescription();

    //public int getValue();

    //public void setValue(int value);

}