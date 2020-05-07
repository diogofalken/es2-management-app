package authentication;
import java.util.HashMap;

public class Authentication {
    // fields
    private static Authentication instance = null;
    private HashMap<Integer, RegisteredUser> registeredUsers = new HashMap<Integer, RegisteredUser>();
    private HashMap<Integer, RegisteredUser> authenticatedUsers = new HashMap<Integer, RegisteredUser>();

    private Authentication() {
    }

    // instance
    public Authentication getInstance() {
        if(instance == null)
            instance = new Authentication();

        return instance;
    }

    // add user to registered
    public void registerUser(RegisteredUser registeredUser) {
        this.registeredUsers.put(this.registeredUsers.size(), registeredUser);
    }

    // login a user
    public void authenticateUser(String email, String password) {
        this.registeredUsers.forEach((key, user) -> {
            if(this.authenticatedUsers.containsValue(user) == false)
                return;

            if(user.getEmail().equals(email) == false)
                return;

            if(user.getPassword().equals(password) == false)
                return;

            this.authenticatedUsers.put(this.authenticatedUsers.size(), user);
        });
    }

}
