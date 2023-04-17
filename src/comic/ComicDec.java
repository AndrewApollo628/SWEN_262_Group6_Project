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
    public List<String> getCreator() {
        return comic.getCreator();
    }

    @Override
    public String getVariantDescription() {
        return comic.getVariantDescription();
    }

    @Override
    public String toString() {
        return "<" + comic + ">";
    }

    @Override
    public int getValue() {
        return comic.getValue();
    }

    public Comic getComic() {
        return comic;
    }

    @Override
    public String getSeries() {
        return comic.getSeries();
    }

    @Override
    public String getFormat() {
        return comic.getFormat();
    }

    @Override
    public String getAddedDate() {
        return comic.getAddedDate();
    }

    public boolean isGraded() {
        return comic instanceof GradedComic || (comic instanceof ComicDec && ((ComicDec) comic).isGraded());
    }

    public boolean isSlabbed() {
        return comic instanceof SlabbedComic || (comic instanceof ComicDec && ((ComicDec) comic).isSlabbed());
    }

    public boolean isSigned() {
        return comic instanceof SignedComic || (comic instanceof ComicDec && ((ComicDec) comic).isSigned());
    }

    public int getGrade() {
        if (comic instanceof GradedComic) {
            return ((GradedComic) comic).getGrade();
        } else if (comic instanceof ComicDec) {
            return ((ComicDec) comic).getComic().getGrade();
        } else {
            return 0;
        }
    }

    public String getSignature() {
        if (comic instanceof SignedComic) {
            return ((SignedComic) comic).getSignature();
        } else if (comic instanceof ComicDec) {
            return ((ComicDec) comic).getComic().getSignature();
        } else {
            return "";
        }
    }


}