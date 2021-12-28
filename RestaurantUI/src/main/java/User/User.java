package User;

import java.util.HashMap;

/**
 *
 */
public class User {

    private String name;
    private String username;
    private String password;
    private Boolean admin;

    static HashMap<String, User> USERS = new HashMap<String, User>();

    public User(String name, String username, String password, Boolean admin) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.admin = admin;
        USERS.put(username, this);
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public static HashMap<String, User> getUSERS() {
        return USERS;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                '}';
    }
}
