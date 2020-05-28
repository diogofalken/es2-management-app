package mocks;

import interfaces.UserRestApiMethods;
import types.User;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class UserMock implements UserRestApiMethods {
    private ArrayList<User> users = new ArrayList<User>();

    public UserMock() {
        this.defaultUsers();
    }

    private void defaultUsers() {
        // Classes instances
        final User user0 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Id
        user0.setId(this.users.size() + 1);
        user1.setId(this.users.size() + 1);
        user2.setId(this.users.size() + 1);

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);
    }

    @Override
    public User postUser(User user) {
        // Checking if it already exists
        for (User userTemp : this.users)
            if (userTemp.getEmail().equals(user.getEmail()))
                return null;

        user.setId(this.users.size() + 1);

        return this.users.add(user) ? user : null;

    }

    @Override
    public Collection<User> getUsers() {
        return this.users.size() > 0 ? this.users : null;
    }

    @Override
    public User getUser(Integer id) {
        for (User user : this.users)
            if (user.getId() == id)
                return user;

        return null;
    }


    @Override
    public boolean deleteUser(Integer id) {
        for (User user : this.users)
            if (user.getId() == id)
                return this.users.remove(user) ? true : false;

        return false;
    }

}