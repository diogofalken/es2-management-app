package users;
import java.util.HashMap;

public class Users {
    // singleton instance
    private static Users instance = null;
    private HashMap<Integer, User> users = new HashMap<Integer, User>();

    private Users() {
    }

    // creating new Instance
    public static Users getInstance() {
        if(instance == null)
            instance = new Users();

        return instance;
    }

    // adding a new user
    public void addUser(User user) {
        this.users.put(this.users.size() + 1, user);
    }

    // Show a single user
    public void showUser(Integer id) {
        this.users.forEach((key, user) -> {
            if(user.getId() == id)
                System.out.println(
                    "Id: " + user.getId() + " " +
                    "Email: " + user.getEmail() + " " +
                    "First name: " + user.getFirstName() + " " +
                    "Last name: " + user.getLastName() + " " +
                    "Avatar: " + user.getAvatar()
                );
        });
    }

    // Show all users
    public void showUsers() {
        this.users.forEach((key, user) -> {
            System.out.println(
                "Id: " + user.getId() + " " +
                "Email: " + user.getEmail() + " " +
                "First name: " + user.getFirstName() + " " +
                "Last name: " + user.getLastName() + " " +
                "Avatar: " + user.getAvatar()
            );
        });
    }

}
