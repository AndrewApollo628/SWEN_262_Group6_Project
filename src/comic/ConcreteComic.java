package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class ConcreteComic implements Comic {
    
    @JsonProperty("Series") private String series;
    @JsonProperty("Issue") private int issue;
    @JsonProperty("Full Title") private String fullTitle;
    @JsonProperty("Variant Description") private String variantDescription;
    @JsonProperty("Publisher") private String publisher;
    @JsonProperty("Release Date") private String publicationDate;
    @JsonProperty("Format") private String format;
    @JsonProperty("Added Date") private String addedDate;
    @JsonProperty("Creators") private List<String> creators;

    public ConcreteComic(@JsonProperty("Series") String series, @JsonProperty("Issue") int issue, @JsonProperty("Full Title") String fullTitle, @JsonProperty("Variant Description") String variantDescription, @JsonProperty("Publisher") String publisher, @JsonProperty("Release Date") String publicationDate, @JsonProperty("Format") String format, @JsonProperty("Added Date") String addedDate, @JsonProperty("Creators") String creators) {
            this.series = series;
            this.issue = issue;
            this.fullTitle = fullTitle;
            this.variantDescription = variantDescription;
            this.publisher = publisher;
            this.publicationDate = publicationDate;
            this.format = format;
            this.addedDate = addedDate;
            this.creators = List.of(creators.split(" | "));
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

    @Override
    public String getDescription() {
        return variantDescription;
    }

    @Override
    public String toString() {
        return String.format("%s by %s, %s", fullTitle, creators, publicationDate);
    }

}
