package collection;

import java.io.IOException;

import comic.Comic;
import comic.ComicDec;
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
    public void execute() throws Exception {
        Collection old = usersDAO.getCollection(username);
        if (comic instanceof ComicDec) {
            if (((ComicDec) comic).isSlabbed()) {
                throw new Exception("Comic is already graded");
            }
        }
        old.removeComic(comic);
        SlabbedComic slabbedComic = new SlabbedComic(comic);
        slabbedComic.setValue(calculateNewValue());
        old.addComic(slabbedComic,index);
        usersDAO.updateCollection(username, old);
    }
    
    public void undo() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        Comic oldComic = ((comic.ComicDec)comic).getComic();
        oldComic.setValue(calculateOldValue());
        old.addComic(oldComic, index);
        usersDAO.updateCollection(username, old);
    }

    private int calculateNewValue() {
        return comic.getValue() * 2;
    }

    private int calculateOldValue() {
        return comic.getValue() / 2;
    }

}

