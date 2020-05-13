package stubs;

import interfaces.RestApiMethods;

import types.Resource;
import types.User;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("unchecked")
public class UsersStub implements RestApiMethods {
    private ArrayList<User> users = new ArrayList<User>();

    public UsersStub() {
        this.defaultUsers();
    }

    private void defaultUsers() {
        // Classes instances
        final User user0 = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        final User user1 = new User(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MariaLealFanboyXxX6969");
        final User user2 = new User(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "MinecraftGajasEAlcoolXxX6969");

        // Adding the users
        users.add(user0);
        users.add(user1);
        users.add(user2);
    }

    @Override
    public boolean addUser(User user) {
        // Checking if it already exists
        for(User userTemp : this.users)
            if(userTemp.getId() == user.getId())
                return false;

        // Adding user
        this.users.add(user);

        // Verify if it was added
        if(this.users.contains(user) == false)
            return false;

        return true;
    }

    @Override
    public Collection<User> listUsers() {
        return this.users;
    }

    @Override
    public User singleUser(Integer id) {
        for(User user : this.users)
            if(user.getId() == id)
                return user;

        return null;
    }

    @Override
    public Collection<Resource> listResources() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Resource singleResource(Integer id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean authenticate(String email, String password) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean register(String email, String password) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeUser(Integer id) throws UnsupportedOperationException {
        for(User user : this.users) {
            if(user.getId() == id) {
                this.users.remove(user);
                return true;
            }
        }
        return false;
    }

}