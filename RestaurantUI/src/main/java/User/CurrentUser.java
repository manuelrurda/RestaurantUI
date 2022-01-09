package User;

/**
 * Clase Singleton para poder acceder al usuario en toda la aplicacion.
 */
public class CurrentUser {
    private User currentUser;
    private final static CurrentUser INSTANCE = new CurrentUser();

    private CurrentUser(){}

    public static CurrentUser getInstance(){
        return INSTANCE;
    }

    public void setCurrentUser(User u){
        this.currentUser = u;
    }

    public User getCurrentUser(){
        return this.currentUser;
    }
}
