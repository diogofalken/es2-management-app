package stubs;

import interfaces.UserRestApiMethods;
import types.User;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class UserStub implements UserRestApiMethods {

    public UserStub() {};

    @Override
    public User postUser(User user) {
        ArrayList<User> users = new ArrayList<User>();

        final User user0 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        // Checking if it already exists
        for (User userTemp : users)
            if (userTemp.getEmail().equals(user.getEmail()))
                return null;

        user.setId(users.size() + 1);

        return users.add(user) ? user : null;
    }

    @Override
    public Collection<User> getUsers() {
        ArrayList<User> users = new ArrayList<User>();

        final User user0 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        return users;
    }

    @Override
    public User getUser(Integer id) {
        final User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        user.setId(1);

        if (user.getId() == id)
            return user;

        return null;
    }

    @Override
    public boolean deleteUser(Integer id) {
        ArrayList<User> users = new ArrayList<User>();

        final User user0 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");
        final User user3 = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        user0.setId(users.size() + 1);
        users.add(user0);

        user1.setId(users.size() + 1);
        users.add(user1);

        user2.setId(users.size() + 1);
        users.add(user2);

        user3.setId(users.size() + 1);
        users.add(user3);

        for (User user : users) {
            if (user.getId() == id)
                return users.remove(user) ? true : false;
        }

        return false;
    }

}