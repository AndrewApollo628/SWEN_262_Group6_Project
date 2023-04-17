package collection;

import java.io.IOException;

import comic.Comic;
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
    public void execute() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        old.addComic(new GradedComic(grade, comic), position);
        usersDAO.updateCollection(username, old);
    }

    public void undo() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        old.addComic(((comic.ComicDec)comic).getComic(), position);
        usersDAO.updateCollection(username, old);
    }
        
}
