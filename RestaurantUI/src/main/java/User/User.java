package User;

import java.util.HashMap;

/**
 * Clase de Usuario, sera abstracta porque no habran elementos tipo User, solo Admin o Waiter.
 */
public abstract class User{

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    // Se guardan todos los usuarios
    static public HashMap<String, User> USERS = new HashMap<String, User>();

     User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        USERS.put(username, this);
    }

    // Setters y Getters

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

    //Para debug
    @Override
    public String toString() {
        return "User{" +
                "name='" + firstName + ' ' + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
