package comic;

import java.util.List;

public abstract class ComicDec implements Comic {
    protected Comic comic;

    public ComicDec(Comic comic) {
        this.comic = comic;
    }

    @Override
    public String getFullTitle() {
        return comic.getFullTitle();
    }

    @Override
    public String getPublisher() {
        return comic.getPublisher();
    }

    @Override
    public int getIssue() {
        return comic.getIssue();
    }

    @Override
    public String getPublicationDate() {
        return comic.getPublicationDate();
    }

    @Override
    public List<String> getCreators() {
        return comic.getCreators();
    }

    @Override
    public String getDescription() {
        return comic.getDescription();
    }

    @Override
    public String toString() {
        return "<<" + comic + ">>";
    }

}