package types;

public class RegisteredUser {
    private final String email;
    private final String password;

    public RegisteredUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }

    public String getPassword() { return password; }
}
