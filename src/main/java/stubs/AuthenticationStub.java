package stubs;

import interfaces.RestApiMethods;
import types.RegisteredUser;
import types.Resource;
import types.User;

import java.util.Collection;
import java.util.HashMap;

public class AuthenticationStub implements RestApiMethods {

    // fields
    private HashMap<Integer, RegisteredUser> registeredUsers = new HashMap<Integer, RegisteredUser>();
    private HashMap<Integer, RegisteredUser> authenticatedUsers = new HashMap<Integer, RegisteredUser>();

    public AuthenticationStub() {
        this.defaultRegisteredUsers();
        this.defaultAuthenticateUsers();
    }

    private void defaultRegisteredUsers() {
        final RegisteredUser registeredUser = new RegisteredUser("diogo@hotmail.com", "A123");
        this.registeredUsers.put(1,registeredUser);
    }

    private void defaultAuthenticateUsers() {
        final RegisteredUser registeredUser = new RegisteredUser("diogo@hotmail.com", "A123");
        this.authenticatedUsers.put(1,registeredUser);
    }

    @Override
    public boolean addUser(User user) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<User> listUsers() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User singleUser(Integer id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Resource> listResources() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Resource singleResource(Integer id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean authenticate(String email, String password) throws Exception {
        if(email.isEmpty() == true)
            throw new Exception("Missing Email");

        if(password.isEmpty() == true)
            throw new Exception("Missing Password");

        // Already Registered
        for(RegisteredUser registeredUser : this.registeredUsers.values()) {
            if (registeredUser.getEmail().equals(email))
                throw new Exception("Email already registered");
        }

        return true;
    }

    @Override
    public boolean register(String email, String password) throws Exception {
        if(email.isEmpty() == true)
            throw new Exception("Missing Email");

        if(password.isEmpty() == true)
            throw new Exception("Missing Password");

        // Already Connected
        for(RegisteredUser authenticatedUsers : this.authenticatedUsers.values()) {
            if (authenticatedUsers.getEmail().equals(email))
                throw new Exception("Email already connected");
        }

        return true;
    }

    @Override
    public boolean removeUser(Integer id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
