package persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import collection.Collection;
import user.User;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Defines the Data Access Object interface for {@linkplain User} data persistence
 * 
 * @author aditya
 */
public class UsersJsonDAO implements UsersDAO {
    private String filename;
    private ArrayList<User> users;
    private ObjectMapper mapper;

    public UsersJsonDAO(String filename) {
        this.filename = filename;
        this.users = new ArrayList<User>();
        this.mapper = new ObjectMapper();
        try {
            load();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void load() throws Exception {
        User[] usersArray = mapper.readValue(new File(filename), User[].class);
        for (User user : usersArray) {
            users.add(user);
        }
        
    }

    @Override
    public ArrayList<User> getUsers() throws IOException {
        return users;
    }

    @Override
    public User getUser(String username) throws IOException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User createUser(User user) throws IOException {
        users.add(user);
        mapper.writeValue(new File(filename), users);
        return user;
    }

    @Override
    public Collection getCollection(String username) throws IOException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user.getCollection();
            }
        }
        return null;
    }

    @Override
    public Boolean updateCollection(String username, Collection collection) throws IOException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                user.setCollection(collection);
                mapper.writeValue(new File(filename), users);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) throws IOException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                mapper.writeValue(new File(filename), users);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean check(String username, String password) throws IOException {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
}
