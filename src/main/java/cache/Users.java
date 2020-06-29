package cache;

import interfaces.UsersInterface;
import types.User;

import java.util.ArrayList;

public class Users {
    private ArrayList<User> users = new ArrayList<User>();
    private final UsersInterface usersInterface;

    public Users(UsersInterface usersInterface) {
        this.usersInterface = usersInterface;
    }

    public boolean addUser(User user) {
        return false;
    }

    public User listUser(Integer id) {
        return null;
    }

    public ArrayList<User> listUsers() {
        return null;
    }

    public boolean removeUser(Integer id) {
        return false;
    }

}
