package stubs;

import interfaces.RestApiMethods;
import types.Resource;
import types.User;

import java.util.Collection;

public class AuthenticationStub implements RestApiMethods {
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
    public boolean authenticate(String email, String password) {
        if(email.isEmpty() == true)
            return false;

        if(password.isEmpty() == true)
            return false;

        return true;
    }

    @Override
    public boolean register(String email, String password) {
        if(email.isEmpty() == true)
            return false;

        if(password.isEmpty() == true)
            return false;

        return true;
    }
}
