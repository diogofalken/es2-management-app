package cache;

import interfaces.UsersInterface;
import types.User;

import java.util.ArrayList;

public class Users {
    private final UsersInterface usersInterface;

    public Users(UsersInterface usersInterface) {
        this.usersInterface = usersInterface;
    }

    public boolean addUser(User user) throws Exception {
        if ((user.getEmail().isEmpty()) == true) {
            throw new Exception("Email must not be empty!");
        }

        if ((user.getFirstName().isEmpty()) == true) {
            throw new Exception("FirstName must not be empty!");
        }

        if ((user.getLastName().isEmpty()) == true) {
            throw new Exception("LastName must not be empty!");
        }

        if ((user.getAvatar().isEmpty()) == true) {
            throw new Exception("Avatar must not be empty!");
        }

        if ((user.getEmail() instanceof String) == false) {
            throw new Exception("Email must be a string!");
        }

        if ((user.getFirstName() instanceof String) == false) {
            throw new Exception("FirstName must be a string!");
        }

        if ((user.getLastName() instanceof String) == false) {
            throw new Exception("LastName must be a string!");
        }

        if ((user.getAvatar() instanceof String) == false) {
            throw new Exception("Avatar must be a string!");
        }

        if ((user.getEmail().matches("(.*)[$&+,:;=?#|](.*)")) == true) {
            throw new Exception("Email must not contain invalid characters!");
        }

        if ((user.getFirstName().matches("(.*)[$&+,:;=?@.#|](.*)")) == true) {
            throw new Exception("FirstName must not contain invalid characters!");
        }

        if ((user.getLastName().matches("(.*)[$&+,:;=?@.#|](.*)")) == true) {
            throw new Exception("LastName must not contain invalid characters!");
        }

        if ((user.getAvatar().matches("(.*)[$&+,:;=?@.#|](.*)")) == true) {
            throw new Exception("Avatar must not contain invalid characters!");
        }

        if ((user.getEmail().length() > 25) == true) {
            throw new Exception("Email length must be lower than 25!");
        }

        if ((user.getFirstName().length() > 15) == true) {
            throw new Exception("FirstName length must be lower than 15!");
        }

        if ((user.getLastName().length() > 15) == true) {
            throw new Exception("LastName length must be lower than 15!");
        }

        if ((user.getAvatar().length() > 16) == true) {
            throw new Exception("Avatar length must be lower than 16!");
        }

        if ((user.getEmail().length()) < 11) {
            throw new Exception("Email length must be higher than 11!");
        }

        if ((user.getFirstName().length()) < 2) {
            throw new Exception("FirstName length must be at least 2 length!");
        }

        if ((user.getLastName().length()) < 2) {
            throw new Exception("LastName length must be at least 2 length!");
        }

        if ((user.getAvatar().length()) < 2) {
            throw new Exception("Avatar length must be at least 2 length!");
        }

        return this.usersInterface.postUser(user);
    }

    public User listUser(Integer id) throws Exception {
        if((id instanceof Integer) == false) {
            throw new Exception("Id must be integer!");
        }

        if(id == null) {
            throw new Exception("Id can't be null!");
        }

        return this.usersInterface.getUser(id);
    }

    public ArrayList<User> listUsers() {
        return this.usersInterface.getUsers();
    }

    public boolean removeUser(Integer id) throws Exception {
        if((id instanceof Integer) == false) {
            throw new Exception("Id must be integer!");
        }

        if(id == null) {
            throw new Exception("Id can't be null!");
        }

        return this.usersInterface.deleteUser(id);
    }

}
