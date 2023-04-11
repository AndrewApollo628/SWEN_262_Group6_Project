package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConcreteComic implements Comic {

    // {
    //     "Series": "Series1",
    //     "Issue": "1",
    //     "Full Title": "Title1 vol. 1",
    //     "Variant Description": "",
    //     "Publisher": "Publisher1",
    //     "Release Date": "January 1, 2001",
    //     "Format": "Comic",
    //     "Added Date": "January 1, 2001",
    //     "Creators": "Creator1 | Creator2"
    //   },
    
    @JsonProperty("Series") private String series;
    @JsonProperty("Issue") private int issue;
    @JsonProperty("Full Title") private String fullTitle;
    @JsonProperty("Variant Description") private String variantDescription;
    @JsonProperty("Publisher") private String publisher;
    @JsonProperty("Release Date") private String publicationDate;
    @JsonProperty("Format") private String format;
    @JsonProperty("Added Date") private String addedDate;
    @JsonProperty("Creators") private String creators;
    @JsonProperty("Description") private String description;

    public ConcreteComic(@JsonProperty("Series") String series, @JsonProperty("Issue") int issue, @JsonProperty("Full Title") String fullTitle, @JsonProperty("Variant Description") String variantDescription, @JsonProperty("Publisher") String publisher, @JsonProperty("Release Date") String publicationDate, @JsonProperty("Format") String format, @JsonProperty("Added Date") String addedDate, @JsonProperty("Creators") String creators, @JsonProperty("Description") String description) {
            // this.fullTitle = fullTitle;
            // this.publisher = publisher;

            // // if(fullTitle.contains("vol. ")){
            // //     String splitString[] = fullTitle.split("vol. ");
            // //     this.volumeNumber = Integer.valueOf(splitString[1]);
            // // } else {
            // //     this.volumeNumber = -1;
            // // }

            // this.issue = issue;
            // this.publicationDate = publicationDate;
            // this.creators = creators;
            // this.description = description;

            this.series = series;
            this.issue = issue;
            this.fullTitle = fullTitle;
            this.variantDescription = variantDescription;
            this.publisher = publisher;
            this.publicationDate = publicationDate;
            this.format = format;
            this.addedDate = addedDate;
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

    // @Override
    // public int getVolumeNumber() {
    //     return volumeNumber;
    // }

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
        return null;
    }

    // @Override
    // public List<String> getPrincipleCharacters() {
    //     return principleCharacters;
    // }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getVolumeNumber() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVolumeNumber'");
    }

    // @Override
    // public int getValue() {
    //     return value;
    // }

    // @Override
    // public void setValue(int value) {
    //     this.value = value;
    // }

    @Override
    public String toString() {
        return String.format("%s by %s, %s", fullTitle, creators, publicationDate);
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if(!(o instanceof Comic)){
            return false;
        }

        Comic c = (Comic) o;
        return fullTitle.equals(c.getFullTitle()) && publisher.equals(c.getPublisher()) && issue == c.getIssue()
                && publicationDate.equals(c.getPublicationDate()) && description.equals(c.getDescription());
    }
}
