package tests;

import org.junit.platform.commons.annotation.Testable;

import user.User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

@Testable
public class UserTest {

    @Test
    public void testCreateUser() throws Exception {
        User john = new User("john", "password", null);
        assertEquals(john.getUsername(), "john");
        assertEquals(john.getPassword(), "password");
        assertNotEquals(john.getCollection(), null);
    }

    @Test
    public void testEquals() throws Exception {
        User user = new User("john", "password", null);
        User user2 = new User("john", "password", null);

        assertEquals(user, user2);
    }

    @Test
    public void testNotEquals() throws Exception {
        User user = new User("john", "password", null);
        User user2 = new User("johnny", "password", null);

        assertNotEquals(user, user2);
    }

    @Test
    public void testToString() throws Exception {
        User user = new User("john", "password", null);
        assertEquals(user.toString(), "User [username=john, password=password, collection=[]]");
    }
    
}
