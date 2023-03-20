package user;
import java.util.ArrayList;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the User class
 * 
 * @author aditya
 */
public class User {

    static final String strFormat = "User [username=%s, password=%s, collection=%s]";

    @JsonProperty("username") private String username;
    @JsonProperty("password") private String password;
    @JsonProperty("collection") private ArrayList<Integer> collection;

    User(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("collection") ArrayList<Integer> collection) {
        this.username = username;
        this.password = password;
        this.collection = collection;
    }

    User(@JsonProperty("username") String username, @JsonProperty("password") String password) {
        this.username = username;
        this.password = password;
        this.collection = new ArrayList<Integer>();
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

    public ArrayList<Integer> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public String toString() {
        return String.format(strFormat, username, password, collection);
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
