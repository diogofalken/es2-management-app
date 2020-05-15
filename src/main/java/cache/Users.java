package cache;

import interfaces.RestApiMethods;
import types.User;

import java.util.Collection;
import java.util.HashMap;

public class Users {
    private HashMap<Integer, User> users = new HashMap<Integer, User>();
    RestApiMethods restApiMethods;

    public Users(RestApiMethods restApiMethods) {
        this.restApiMethods = restApiMethods;
    }

    /**
     * Will add a new User to the Users HashMap
     * @param user
     */
    public void addUser(User user) {
        boolean endpointResponse = this.restApiMethods.addUser(user);

        if(endpointResponse == false)
            return;

        this.users.forEach((key, value) -> {
            // Verifying if it already exists on the HashMap
            if(value.getId() == user.getId())
                return;
            // Adding new User
            this.users.put(this.users.size() + 1, user);
        });
    }

    /**
     * Will list a single User depending on its Id
     * @param id
     */
    public User showUser(Integer id) throws Exception {
        for (User user : this.users.values()) {
            if(user.getId() == id)
                return user;
        }

        User user = this.restApiMethods.singleUser(id);

        if(user == null)
            throw new Exception("No user with that ID found");

        return user;
    }

    /**
     * Will list all users
     * @return collection of users
     */
    public Collection<User> showUsers() throws Exception {
       Collection<User> users = this.restApiMethods.listUsers();
       return users;
    }

    /**
     *
     * @param id
     */
    public void removeUser(Integer id) throws Exception {
        boolean endpointResponse = this.restApiMethods.removeUser(id);

        if(endpointResponse == false)
            throw new Exception("User with that Id was not found");

        this.users.forEach((key, value) -> {
            if(value.getId() == id)
                this.users.remove(key);
        });
    }
}
