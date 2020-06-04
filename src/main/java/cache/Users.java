package cache;

import interfaces.UserRestApiMethods;
import types.User;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class Users {
    private HashMap<Integer, User> users = new HashMap<Integer, User>();
    private UserRestApiMethods userRestApiMethods;

    public Users(UserRestApiMethods userRestApiMethods) {
        this.userRestApiMethods = userRestApiMethods;
    }

    public User addUser(User user) throws Exception {

        if (user.getEmail().length() > 50)
            throw new IOException("Email length can't exceed 50 characters");

        if (user.getEmail().isEmpty() == true)
            throw new IOException("Missing Email");

        if (user.getFirstName().length() > 25)
            throw new IOException("First Name length can't exceed 25 characters");

        if (user.getFirstName().isEmpty() == true)
            throw new IOException("Missing First Name");

        if (user.getFirstName().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$") == false)
            throw new IOException("First Name must only contain letters");

        if (user.getLastName().length() > 50)
            throw new IOException("Last Name length can't exceed than 50 characters");

        if (user.getLastName().isEmpty() == true)
            throw new IOException("Missing Last Name");

        if (user.getLastName().matches("^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$") == false)
            throw new IOException("First Name must only contain letters");

        if (user.getAvatar().length() > 100)
            throw new IOException("Avatar length can't exceed than 30 characters");

        if (user.getAvatar().isEmpty() == true)
            throw new IOException("Missing Avatar");

        for (User userTemp : this.users.values())
            if (userTemp.getEmail().equals(user.getEmail()))
                throw new Exception("User already exists");

        User responseStub = this.userRestApiMethods.postUser(user);

        if (responseStub == null)
            throw new Exception("User not added in Stub");

        // Adding new User
        this.users.put(this.users.size() + 1, responseStub);

        return responseStub;
    }

    public User showUser(Integer id) throws Exception {

        if (id == null)
            throw new IOException("Id Missing");

        // Getting user from the Cache Users List
        for (User user : this.users.values())
            if (user.getId() == id)
                return user;

        User responseUser = this.userRestApiMethods.getUser(id);

        if (responseUser == null)
            throw new Exception("User with that Id was not found");

        return responseUser;
    }

    public Collection<User> showUsers() {
        return this.userRestApiMethods.getUsers();
    }

    public void removeUser(Integer id) throws Exception {

        if (id == null)
            throw new IOException("Id Missing");

        boolean responseUser = this.userRestApiMethods.deleteUser(id);
        
        if (responseUser == false)
            throw new Exception("User with that Id was not found");

        for(Integer key : this.users.keySet()) {
            if(this.users.get(key).getId() == id) {
                this.users.remove(key);
            }
        }
    }
}
