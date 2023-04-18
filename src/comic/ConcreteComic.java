package comic;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConcreteComic implements Comic {
    
    @JsonProperty("Series") private String series;
    @JsonProperty("Issue") private int issue;
    @JsonProperty("Full Title") private String fullTitle;
    @JsonProperty("Variant Description") private String variantDescription;
    @JsonProperty("Publisher") private String publisher;
    @JsonProperty("Release Date") private String publicationDate;
    @JsonProperty("Format") private String format;
    @JsonProperty("Added Date") private String addedDate;
    @JsonProperty("Creator") private List<String> creator;
    @JsonProperty("Value") private int value;

    public ConcreteComic(@JsonProperty("Series") String series, @JsonProperty("Issue") int issue, @JsonProperty("Full Title") String fullTitle, @JsonProperty("Variant Description") String variantDescription, @JsonProperty("Publisher") String publisher, @JsonProperty("Release Date") String publicationDate, @JsonProperty("Format") String format, @JsonProperty("Added Date") String addedDate, @JsonProperty("Creator") String creators, @JsonProperty("Value") int value) {
            this.series = series;
            this.issue = issue;
            this.fullTitle = fullTitle;
            this.variantDescription = variantDescription;
            this.publisher = publisher;
            this.publicationDate = publicationDate;
            this.format = format;
            this.addedDate = addedDate;
            this.creator = List.of(creators.split("\\s\\|\\s"));
            this.value = value;
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
    public List<String> getCreator() {
        return creator;
    }

    @Override
    public String toString() {
        return String.format("%s by %s, %s", fullTitle, creator, publicationDate);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public String getVariantDescription() {
        return variantDescription;
    }

    @Override
    public String getSeries() {
        return series;
    }

    @Override
    public String getFormat() {
        return format;
    }

    @Override
    public String getAddedDate() {
        return addedDate;
    }

    public static void main(String[] args) {
        ConcreteComic comic = new ConcreteComic("Batman", 1, "Batman #1", "Variant", "DC", "2019-01-01", "Comic", "2019-01-01", "Bob Kane", 100);
        System.out.println(comic);

        GradedComic gradedComic = new GradedComic(9, comic);
        System.out.println(gradedComic);
        System.out.println(gradedComic.isGraded());

        SignedComic signedComic = new SignedComic(gradedComic, "aditya"); 
        System.out.println(signedComic);
        System.out.println(signedComic.isSigned());

        SlabbedComic slabbedComic = new SlabbedComic(signedComic);
        System.out.println(slabbedComic);
        System.out.println(slabbedComic.isSlabbed());
        System.out.println(slabbedComic.isSigned());
        System.out.println(slabbedComic.isGraded());
    }

    public String getSignature() {
        return null;
    }

    public int getGrade() {
        return 0;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
