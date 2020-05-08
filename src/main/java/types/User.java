package types;

public class User {

    private final Integer id;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final Object avatar;

    public User(final Integer id, final String email, final String firstName, final String lastName,
            final String avatar) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the avatar
     */
    public Object getAvatar() {
        return avatar;
    }
}