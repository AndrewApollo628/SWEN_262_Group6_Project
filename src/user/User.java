package user;
import java.util.ArrayList;

import collection.Collection;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import comic.Comic;

/**
 * Defines the User class
 * 
 * @author aditya
 */

 @JsonSerialize(using = persistence.UserSerializer.class)
public class User {

    @JsonProperty("username") private String username;
    @JsonProperty("password") private String password;
    @JsonProperty("collection") private ArrayList<Comic> collectionRaw;
    private Collection collection;

    public User(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("collection") ArrayList<Comic> collectionRaw) {
        this.username = username;
        this.password = password;
        if (collectionRaw == null) {
            this.collection = new Collection();
        } else {
            this.collection = new Collection(collectionRaw);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password + ", collection=" + collection + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) { return true; }

        User user = (User) obj;
        return user.username.equals(this.username);
    }
    
}
