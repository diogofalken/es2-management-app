package interfaces;

import types.Resource;
import types.User;

import java.util.Collection;

/**
 * EndPointsMethods
 */
public interface RestApiMethods {

    boolean addUser(User user);

    Collection<User> listUsers();

    User singleUser(Integer id);

    Collection<Resource> listResources();

    Resource singleResource(Integer id);

    boolean authenticate(String email, String password) throws Exception;

    boolean register(String email, String password) throws Exception;

    boolean removeUser(Integer id);
}