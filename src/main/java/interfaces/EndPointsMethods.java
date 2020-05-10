package interfaces;

import types.User;

/**
 * EndPointsMethods
 */
public interface EndPointsMethods {

    String addUser(User user);

    String listUsers();

    String singleUser(int _id);

    String listResources();

    String singleResource(int _id);

    String authenticate(String email, String password);

    String register(String email, String password);

    String updateUser(User user);

    String patchUser(User user);

    String deleteUser(int _id);

    String listUsersDelayed() throws InterruptedException;

}