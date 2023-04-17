package collection;

import java.io.IOException;

import comic.Comic;
import persistence.UsersDAO;

public class RemoveComic implements CollectionCommand{

    private UsersDAO usersDAO;
    private String username;
    private Comic comic;

    public RemoveComic(Comic comic, UsersDAO userDAO, String username){
        this.comic = comic;
        this.usersDAO = userDAO;
        this.username = username;
    }

    @Override
    public void execute() throws IOException {
        Collection old = usersDAO.getCollection(username);
        old.removeComic(comic);
        usersDAO.updateCollection(username, old);
    }
}
