package comic;

import java.util.List;

public interface Comic {

    public String getName();
    
    public String getPublisher();

    public int getVolumeNumber();

    public int getIssueNumber();

    public String getPublicationDate();

    public List<String> getCreators();

    public List<String> getPrincipleCharacters();

    public String getDescription();

    public int getValue();

    public void setValue(int value);
    
}