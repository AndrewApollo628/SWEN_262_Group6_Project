package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Comicdecorator implements Comic{
    
    @JsonProperty("Full Title") private String fullTitle;
    @JsonProperty("publisher") private String publisher;
    @JsonProperty("Series") private String series;
    private int volumeNumber;
    @JsonProperty("Issue") private int issue;
    @JsonProperty("Release Date") private String publicationDate; 
    @JsonProperty("creators") private List<String> creators; 
    @JsonProperty("description") private String description;
    //@JsonProperty("value") private int value;

    public Comicdecorator(@JsonProperty("Full Title") String fullTitle, 
                        @JsonProperty("publisher") String publisher, 
                        int volumeNumber, 
                        @JsonProperty("Issue") int issue, 
                        @JsonProperty("publicationDate") String publicationDate, 
                        @JsonProperty("creators") List<String> creators, 
                        @JsonProperty("description") String description, 
                        @JsonProperty("value") int value, 
                        @JsonProperty("Series")  String series)
        {
            this.fullTitle = fullTitle;
            this.publisher = publisher;

            if(fullTitle.contains("vol. ")){
                String splitString[] = fullTitle.split("vol. ");
                this.volumeNumber = Integer.valueOf(splitString[1]);
            } else {
                this.volumeNumber = -1;
            }

            this.issue = issue;
            this.publicationDate = publicationDate;
            this.creators = creators;
            this.description = description;
            //this.value = value;
    }

    @Override
    public String getFullTitle() {
        return fullTitle;
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
    public int getIssue() {
        return issue;
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
    public String getDescription() {
        return description;
    }

    // @Override
    // public int getValue() {
    //     return value;
    // }

    // @Override
    // public void setValue(int value) {
    //     this.value = value;
    // }
}
