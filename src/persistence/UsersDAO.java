package persistence;
import java.io.IOException;
import java.util.ArrayList;

import comic.Comic;
import user.User;

/**
 * Defines the Data Access Object interface for {@linkplain User} data persistence
 * 
 * @author aditya
 */
public interface UsersDAO {

    User[] getUsers() throws IOException;

    User getUser(int userid) throws IOException;

    User createUser(User user) throws IOException;

    ArrayList<Comic> getCollection(int userid) throws IOException;

    Boolean addToCollection(int userid, int productid) throws IOException;

    Boolean removeFromCollection(int userid, int productid) throws IOException;

    boolean deleteUser(int userid) throws IOException;

    Boolean checkout(int userid) throws IOException;

    int getUserID(String username) throws IOException;

}
