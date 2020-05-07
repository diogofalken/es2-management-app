package authentication;

import users.User;

public class RegisteredUser {

    private final String email;
    private final String password;
    private final User user;

    public RegisteredUser(String email, String password, User user) {
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public String getEmail() { return email; }

    public String getPassword() { return password; }

    public User getUser() { return user; }
}
