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
public class UsersJsonDAO implements UsersDAO {

    @Override
    public User[] getUsers() throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUsers'");
    }

    @Override
    public User getUser(int userid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUser'");
    }

    @Override
    public User createUser(User user) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createUser'");
    }

    @Override
    public ArrayList<Comic> getCollection(int userid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCollection'");
    }

    @Override
    public Boolean addToCollection(int userid, int productid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addToCollection'");
    }

    @Override
    public Boolean removeFromCollection(int userid, int productid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFromCollection'");
    }

    @Override
    public boolean deleteUser(int userid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public Boolean checkout(int userid) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkout'");
    }

    @Override
    public int getUserID(String username) throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserID'");
    }
    
}
