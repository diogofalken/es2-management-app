package users;

public class User {
    private final Integer id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String avatar;

    public User(Integer id, String email,String firstName, String lastName, String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public Integer getId() { return id; }

    public String getEmail() { return email; }

    public String getFirstName() { return firstName;}

    public String getLastName() { return lastName; }

    public String getAvatar() { return avatar; }
}
