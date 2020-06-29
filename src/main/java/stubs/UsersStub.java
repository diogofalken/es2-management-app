package stubs;

import interfaces.UsersInterface;
import types.User;

import java.util.ArrayList;

public class UsersStub implements UsersInterface {

    @Override
    public boolean postUser(User user) throws Exception {
        // Creating User ArrayList
        ArrayList<User> users = new ArrayList<User>();

        // Creating Users
        final User user0 = new User("FirstUser@gmail.com", "FirstUser", "FirstFinal", "Avatar1");
        final User user1 = new User("SecondUser@gmail.com", "SecondUser", "SecondFinal", "Avatar2");
        final User user2 = new User("ThirdUser@gmail.com", "ThirdUser", "ThirdFinal", "Avatar3");

        // Adding Id to Users
        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        // Checking if it already exists
        for (User userTemp : users) {
            if (userTemp.getEmail().equals(user.getEmail())) {
                return false;
            }
        }

        user.setId(users.size() + 1);

        return users.add(user);
    }

    @Override
    public ArrayList<User> getUsers() {
        // Creating ArrayList
        ArrayList<User> users = new ArrayList<User>();

        // Creating Users
        final User user0 = new User("FirstUser@gmail.com", "FirstUser", "FirstFinal", "Avatar1");
        final User user1 = new User("SecondUser@gmail.com", "SecondUser", "SecondFinal", "Avatar2");
        final User user2 = new User("ThirdUser@gmail.com", "ThirdUser", "ThirdFinal", "Avatar3");

        // Adding Id to Users
        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        // Checking if ArrayList contains Users
        if(users.size() == 0) {
            return null;
        }

        // Returning users
        return users;
    }

    @Override
    public User getUser(Integer id) {
        // Creating Users
        final User user = new User("FirstUser@gmail.com", "FirstUser", "FirstFinal", "Avatar1");
        user.setId(1);

        if (user.getId() != id)
            return null;

        return user;
    }

    @Override
    public boolean deleteUser(Integer id) {
        // Creating User ArrayList
        ArrayList<User> users = new ArrayList<User>();

        // Creating Users
        final User user0 = new User("FirstUser@gmail.com", "FirstUser", "FirstFinal", "Avatar1");
        final User user1 = new User("SecondUser@gmail.com", "SecondUser", "SecondFinal", "Avatar2");
        final User user2 = new User("ThirdUser@gmail.com", "ThirdUser", "ThirdFinal", "Avatar3");

        // Adding Id to Users
        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        // Checking remove User
        for (User user : users) {
            if (user.getId() == id) {
                return users.remove(user) ? true : false;
            }
        }

        return false;
    }
}
