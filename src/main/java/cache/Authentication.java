package cache;

import interfaces.RestApiMethods;
import types.RegisteredUser;

import java.util.HashMap;

public class Authentication {

    // fields
    private HashMap<Integer, RegisteredUser> registeredUsers = new HashMap<Integer, RegisteredUser>();
    private HashMap<Integer, RegisteredUser> authenticatedUsers = new HashMap<Integer, RegisteredUser>();
    RestApiMethods restApiMethods;

    public Authentication(RestApiMethods restApiMethods) {
        this.restApiMethods = restApiMethods;
    }

    // add user to registered
    public void registerUser(String email, String password) throws Exception {
        try {
            this.restApiMethods.register(email,password);

            RegisteredUser registeredUser = new RegisteredUser(email,password);

            this.registeredUsers.put(registeredUsers.size() + 1, registeredUser);
        } catch (Exception error) {
            throw new Exception(error);
        }
    }

    // login a user
    public void authenticateUser(String email, String password) throws Exception {
        try {
            this.restApiMethods.authenticate(email,password);

            RegisteredUser registeredUser = new RegisteredUser(email,password);

            this.authenticatedUsers.put(authenticatedUsers.size() + 1, registeredUser);
        } catch (Exception error) {
            throw new Exception(error);
        }
    }
}
