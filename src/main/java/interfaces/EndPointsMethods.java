package interfaces;

import types.User;

/**
 * EndPointsMethods
 */
public interface EndPointsMethods {

    public String addUser(User user);

    public String listUsers();

    public String singleUser(int _id);

    public String listResources();

    public String singleResource(int _id);

    public String authenticate(String email, String password);

    public String register(String email, String password);

}