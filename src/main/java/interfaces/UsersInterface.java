package interfaces;

import types.User;

import java.util.ArrayList;

public interface UsersInterface {
    boolean postUser(User user) throws Exception;

    ArrayList<User> getUsers();

    User getUser(Integer id);

    boolean deleteUser(Integer id);
}
