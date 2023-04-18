package collection;

import comic.Comic;
import comic.ComicDec;
import comic.SignedComic;
import persistence.UsersDAO;

public class SignComic implements CollectionCommand{

    private UsersDAO usersDAO;
    private String username;
    private Comic comic;
    private int position;

    public SignComic(Comic comic, UsersDAO userDAO, String username, int position){
        this.comic = comic;
        this.usersDAO = userDAO;
        this.username = username;
    }

    @Override
    public void execute() throws Exception {
        Collection old = usersDAO.getCollection(username);
        if (comic instanceof ComicDec) {
            if (((ComicDec) comic).isSigned()) {
                throw new Exception("Comic is already graded");
            }
        }
        old.removeComic(comic);
        SignedComic signedComic = new SignedComic(comic, username);
        old.addComic(signedComic, position);
        usersDAO.updateCollection(username, old);
    }

    public void undo() throws Exception {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        old.addComic(comic, position);
        usersDAO.updateCollection(username, old);
    }
}
