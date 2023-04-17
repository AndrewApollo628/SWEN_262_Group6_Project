package collection;

import java.io.IOException;

import comic.Comic;
import comic.SlabbedComic;
import persistence.UsersDAO;

public class SlabComic implements CollectionCommand {

    private UsersDAO usersDAO;
    private String username;
    private Comic comic;
    private int index;

    public SlabComic(Comic comic, UsersDAO userDAO, String username, int index) {
        this.comic = comic;
        this.usersDAO = userDAO;
        this.username = username;
        this.index = index;
    }

    @Override
    public void execute() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        old.addComic(new SlabbedComic(comic),index);
        usersDAO.updateCollection(username, old);
    }
    
    public void undo() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        old.addComic(((comic.ComicDec)comic).getComic(), index);
        usersDAO.updateCollection(username, old);
    }

}

