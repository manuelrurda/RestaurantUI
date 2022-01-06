package User;

import java.util.HashMap;

/**
 *
 */
public abstract class User {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    static public HashMap<String, User> USERS = new HashMap<String, User>();

     User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        USERS.put(username, this);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + firstName + ' ' + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
