package collection;

import java.io.IOException;

import comic.Comic;
import comic.ComicDec;
import comic.GradedComic;
import persistence.UsersDAO;

public class GradeComic implements CollectionCommand{

    private UsersDAO usersDAO;
    private String username;
    private Comic comic;
    private int grade;
    private int position;

    public GradeComic(Comic comic, UsersDAO userDAO, String username, int grade, int position) {
        this.comic = comic;
        this.usersDAO = userDAO;
        this.username = username;
        this.grade = grade;
        this.position = position;
    }

    @Override
    public void execute() throws Exception {
        Collection old = usersDAO.getCollection(username);
        if (comic instanceof ComicDec) {
            if (((ComicDec) comic).isGraded()) {
                throw new Exception("Comic is already graded");
            }
        }
        old.removeComic(comic);
        GradedComic gradedComic = new GradedComic(grade, comic);
        gradedComic.setValue(calculateNewValue());
        old.addComic(gradedComic, position);
        usersDAO.updateCollection(username, old);
    }

    public void undo() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        Comic oldComic = ((comic.ComicDec)comic).getComic();
        oldComic.setValue(calculateOldValue());
        old.addComic(oldComic, position);
        usersDAO.updateCollection(username, old);
    }

    private int calculateNewValue() {
        if (grade == 1) {
            return (int) (comic.getValue() * 0.10);
        } else {
            return (int) (Math.log10(grade) * comic.getValue());
        }
    }

    private int calculateOldValue() {
        if (grade == 1) {
            return (int) (comic.getValue() / 0.10);
        } else {
            return (int) (comic.getValue() / Math.log10(grade));
        }
    }
        
}
