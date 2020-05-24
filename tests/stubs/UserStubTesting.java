package stubs;

import cache.Users;
import interfaces.UserRestApiMethods;
import org.junit.Test;
import types.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserStubTesting {

    // Application Testing

    @Test
    public void testAddUser_CorrectNewUser_UserMustBeOnTheHashMap() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);
        user = users.addUser(user);

        // Asserting Answer
        assertEquals(user.getId(), users.showUser(user.getId()).getId());

        // Removing new user
        users.removeUser(user.getId());
    }

    @Test
    public void testAddUser_UserAlreadyExistsAtStub_MustReturnAnException() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_UserAlreadyExistsAtApplication_MustReturnAnException() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");
        User user1 = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
            users.addUser(user1);
        });
    }

    @Test
    public void testShowUsers_ListOfUsers_MustNotReturnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Users Ref
        Users users = new Users(userRestApiMethods);

        assertDoesNotThrow(() -> {
            users.showUsers();
        });
    }

    @Test
    public void testShowUser_UserFoundAtCache_IdMustBeEqualToGiven()  throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);
        user = users.addUser(user);

        // Asserting Answer
        assertEquals(user.getId(), users.showUser(user.getId()).getId());

        // Removing new user
        users.removeUser(user.getId());
    }

    @Test
    public void testShowUser_UserFoundAtStub_IdMustBeEqualToGiven() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertEquals(1, users.showUser(1).getId());
    }

    @Test
    public void testShowUser_UserWasNotFound_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).showUser(100000);
        });
    }

    @Test
    public void testShowUser_IdIsNull_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).showUser(null);
        });
    }

    @Test
    public void testRemoveUser_IdIsNull_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).removeUser(null);
        });
    }

    @Test
    public void testRemoveUser_UserNotFound_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.removeUser(10);
        });
    }

    // Parameters Testing (Equivalence)

    @Test
    public void testAddUser_MissingEmail_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("", "Diogo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_MissingFirstName_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_MissingLastName_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_MissingAvatar_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", ""));
        });
    }

    @Test
    public void testAddUser_EmailWith50CharactersLength_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("diogodiogodiogodiogodiogodiogodiogodiog@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_EmailWith51CharactersLength_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("diogodiogodiogodiogodiogodiogodiogodiogo@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_FirstNameWith26CharactersLength_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("xxxx@outlook.pt", "DiogoDiogoDiogoDiogoDiogoD", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_FirstNameWith25CharactersLength_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("xxxx@outlook.pt", "DiogoDiogoDiogoDiogoDiogo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_LastNameWith51CharactersLength_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "DiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogo1", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_LastNameWith50CharactersLength_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("xX69FdalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "DiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogo", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_AvatarWith100CharactersLength_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("falcao@outlook.pt", "Diogo", "Falcao", "DiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogo"));
        });
    }

    @Test
    public void testAddUser_AvatarWith101CharactersLength_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("falcao@outlook.pt", "Diogo", "Falcao", "DiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogoDiogo1"));
        });
    }

    @Test
    public void testAddUser_FirstNameMustContainOnlyLetters_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("falcao@outlook.pt", "Diogo123123", "Falcao", "TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX69691"));
        });
    }

    @Test
    public void testAddUser_LastNameMustContainOnlyLetters_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("falcao@outlook.pt", "Diogo", "Falca13123o", "TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX69691"));
        });
    }

    @Test
    public void testAddUser_EmailIsNotEmpty_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diogo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_FirstNameIsNotEmpty_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diodgo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_LastNameIsNotEmpty_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diodgo", "Faldcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_AvatarIsNotEmpty_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diodgo", "Falcao", "TiagovdskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_EmailIsEmpty_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("", "Diodgo", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_FirstNameIsEmpty_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "", "Falcao", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_LastNameIsEmpty_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diodgo", "", "TiagovskiCoolXxX6969"));
        });
    }

    @Test
    public void testAddUser_AvatarIsEmpty_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(new User("geordge.bluth@reqres.in", "Diodgo", "Falcao", ""));
        });
    }

}
