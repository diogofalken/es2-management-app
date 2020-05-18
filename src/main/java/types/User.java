package types;

public class User {

    private Integer id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String avatar;

    public User(final String email, final String firstName, final String lastName, final String avatar) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}