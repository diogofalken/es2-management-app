import users.User;
import users.Users;

public class Main {
    public static void main(String[] args) {
        Users users = Users.getInstance();
        User user = new User(1, "xX69TiagoGamerZinho69Xx", "Tiago", "Couceiro", "A2V");
        users.addUser(user);
        User user2 = new User(2, "xX69JoãoGamerZinho69Xx", "João", "Couceiro", "AV2");
        users.addUser(user2);
        users.showUser(1);
        users.showUsers();
    }
}
