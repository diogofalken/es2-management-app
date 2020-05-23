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
    public void testAddUser_CorrectNewUser_MustReturnAnException() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.showUser(user.getId());
        });
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
    public void testShowUsers_ListOfUsers_MustReturnUsers() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Users Ref
        Users users = new Users(userRestApiMethods);

        assertDoesNotThrow(() -> {
            users.showUsers();
        });
    }

    @Test
    public void testShowUser_UserFoundAtCache_MustReturnUserFromCache() throws Exception {
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
    public void testShowUser_UserFoundAtStub_MustReturnUserFromStub() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertEquals(1, users.showUser(1).getId());
    }

    @Test
    public void testShowUser_UserNotFound_MustReturnAnException() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.showUser(10);
        });
    }

    @Test
    public void testRemoveUser_UserFoundAtStub_MustNotBeFoundOnStub() throws Exception {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);
        users.addUser(user);

        // Removing the User
        users.removeUser(user.getId());

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.showUser(user.getId());
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
    public void testAddUser_MissingEmailUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_MissingFirstNameUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_MissingLastNameUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_MissingAvatarUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_Email50CharactersLengthUser_MustNotReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoXGamerFalcaoZinhoGamerXx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertDoesNotThrow(() -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_Email51CharactersLengthUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoXXGamerFalcaoZinhoGamerXx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_FirstName26CharactersLengthUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xxxx@outlook.pt", "DiogoDiogoDiogoDiogoDiogoD", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_FirstName25CharactersLengthUser_MustNotReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xxxx@outlook.pt", "DiogoDiogoDiogoDiogoDiogo", "Falcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertDoesNotThrow(() -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_LastName51CharactersLengthUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "FalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_LastName50CharactersLengthUser_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "FalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcao", "TiagovskiCoolXxX6969");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_Avatar100CharactersLengthUser_MustNotReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "FalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcao");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_Avatar101CharactersLengthUser_MustNotReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falcao", "XFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcaoFalcao");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_FirstNameMustContainOnlyLetters_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo123123", "Falcao", "TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX69691");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testAddUser_LastNameMustContainOnlyLetters_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // User that will be Added
        User user = new User("falcao@outlook.pt", "Diogo", "Falca13123o", "TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX6969TiagovskiCoolXxX69691");

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.addUser(user);
        });
    }

    @Test
    public void testShowUser_IdIsNull_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.showUser(null);
        });
    }

    @Test
    public void testRemoveUser_IdIsNull_MustReturnAnException() {
        // User Stub
        UserRestApiMethods userRestApiMethods = new UsersStub();

        // Adding the User
        Users users = new Users(userRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.removeUser(null);
        });
    }
}
