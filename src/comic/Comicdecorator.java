package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Comicdecorator implements Comic{
    
    @JsonProperty("name") private String name;
    @JsonProperty("publisher") private String publisher;
    @JsonProperty("volumeNumber") private int volumeNumber;
    @JsonProperty("issueNumber") private int issueNumber;
    @JsonProperty("publicationDate") private String publicationDate; 
    @JsonProperty("creators") private List<String> creators; 
    @JsonProperty("principleCharacters") private List<String> principleCharacters;
    @JsonProperty("description") private String description;
    @JsonProperty("value") private int value;

    public Comicdecorator(@JsonProperty("name") String name, @JsonProperty("publisher") String publisher, @JsonProperty("volumeNumber") int volumeNumber,
                          @JsonProperty("issueNumber") int issueNumber, @JsonProperty("publicationDate") String publicationDate, @JsonProperty("creators") List<String> creators, 
                          @JsonProperty("principleCharacters") List<String> principleCharacters, @JsonProperty("description") String description, @JsonProperty("value") int value  ) 
        {
            this.name = name;
            this.publisher = publisher;
            this.volumeNumber = volumeNumber;
            this.issueNumber = issueNumber;
            this.publicationDate = publicationDate;
            this.creators = creators;
            this.principleCharacters = principleCharacters;
            this.description = description;
            this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPublisher() {
        return publisher;
    }

    @Override
    public int getVolumeNumber() {
        return volumeNumber;
    }

    @Override
    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public String getPublicationDate() {
        return publicationDate;
    }

    @Override
    public List<String> getCreators() {
        return creators;
    }

    @Override
    public List<String> getPrincipleCharacters() {
        return principleCharacters;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int value) {
        this.value = value;
    }
}
