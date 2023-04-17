package collection;

import comic.Comic;
import comic.GradedComic;

public class GradeComic implements CollectionCommand{

    private Collection collection;
    private Comic comic;
    private int grade;

    public GradeComic(Comic comic, Collection collection, int grade){
        this.comic = comic;
        this.collection = collection;
        this.grade = grade;
    }

    @Override
    public void execute() {
        Comic graded = new GradedComic(this.grade, this.comic);
        this.collection.removeComic(this.comic);
        this.collection.addComic(graded);
    }
}
