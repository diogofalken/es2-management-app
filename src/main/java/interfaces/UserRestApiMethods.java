package interfaces;

import types.User;

import java.util.Collection;

public interface UserRestApiMethods {

    User postUser(User user);

    Collection<User> getUsers();

    User getUser(Integer id);

    boolean deleteUser(Integer id);
}