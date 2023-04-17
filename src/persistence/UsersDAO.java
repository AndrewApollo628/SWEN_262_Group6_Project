package persistence;
import java.io.IOException;
import java.util.ArrayList;

import collection.Collection;
import comic.Comic;
import user.User;

/**
 * Defines the Data Access Object interface for {@linkplain User} data persistence
 * 
 * @author aditya
 */
public interface UsersDAO {

    ArrayList<User> getUsers() throws IOException;

    User getUser(String username) throws IOException;

    User createUser(User user) throws IOException;

    ArrayList<Comic> getCollection(String username) throws IOException;

    Boolean updateCollection(String username, Collection collection) throws IOException;

    boolean deleteUser(String username) throws IOException;

    boolean check(String username, String password) throws IOException;

}
