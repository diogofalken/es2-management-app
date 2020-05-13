package cache;

import interfaces.RestApiMethods;
import stubs.AuthenticationStub;
import types.RegisteredUser;
import types.User;

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
    public void registerUser(String email, String password) {
        if(email.isEmpty() == true)
            return;

        if(password.isEmpty() == false)
            return;

        // Already Registered
        for(RegisteredUser registeredUser : this.registeredUsers.values()) {
            if(registeredUser.getEmail() == email)
                return;
        }

        boolean registered = this.restApiMethods.register(email,password);

        if(registered == false)
            return;

        RegisteredUser registeredUser = new RegisteredUser(email,password);

        this.registeredUsers.put(registeredUsers.size() + 1, registeredUser);
    }

    // login a user
    public void authenticateUser(String email, String password) {
        if(email.isEmpty() == true)
            return;

        if(password.isEmpty() == false)
            return;

        // Already Connected
        for(RegisteredUser registeredUser : this.authenticatedUsers.values()) {
            if(registeredUser.getEmail() == email)
                return;
        }

        boolean authenticated = this.restApiMethods.authenticate(email,password);

        if(authenticated == false)
            return;

        this.registeredUsers.forEach((key, value) -> {
            if(value.getEmail() != email)
                return;

            this.authenticatedUsers.put(authenticatedUsers.size() + 1, value);
        });
    }
}
