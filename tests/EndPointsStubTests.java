// Test Imports
import cache.Authentication;
import cache.Users;
import interfaces.RestApiMethods;
import org.json.simple.JSONObject;

// Types/Classes imports
import org.junit.jupiter.api.Test;
import stubs.AuthenticationStub;
import stubs.UsersStub;
import types.User;

import static org.junit.jupiter.api.Assertions.*;

public class EndPointsStubTests {

    @Test
    public void addUser_NewUser() throws Exception {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // AddingUser
        Users users = new Users(endPointsMethods);
        users.addUser(user);

        // Asserting Answer
        assertEquals(users.showUser(user.getId()).getId(), user.getId());

        // Removing new user
        users.removeUser(user.getId());
    }

    @Test
    public void addUser_Exception() {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(10, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // AddingUser
        Users users = new Users(endPointsMethods);

        assertThrows(Exception.class, () -> {
            users.showUser(user.getId());
        });
    }

    @Test
    public void removeUser_UserRemoved() throws Exception {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // AddingUser
        Users users = new Users(endPointsMethods);
        users.addUser(user);

        // Asserting Answer
        assertDoesNotThrow(() -> {
            // Removing new user
            users.removeUser(user.getId());
        });
    }

    @Test
    public void removeUser_Exception() throws Exception {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // AddingUser
        Users users = new Users(endPointsMethods);
        users.addUser(user);

        // Removing new user
        users.removeUser(user.getId());

        // Asserting Answer
        assertThrows(Exception.class, () -> {
            users.showUser(user.getId());
        });
    }

    @Test
    public void showUser_SingleUser() throws Exception {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        // AddingUser
        Users users = new Users(endPointsMethods);
        users.addUser(user);

        // Asserting Answer
        assertEquals(users.showUser(user.getId()).getId(), user.getId());

        // Removing new user
        users.removeUser(user.getId());
    }

    @Test
    public void showUser_Exception() {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();

        // Creating User
        User user = new User(10, "xX69FalcaoZinhoGamer69Xx@outlook.pt", "Diogo", "Falcao", "TiagovskiCoolXxX6969");

        Users users = new Users(endPointsMethods);

        assertThrows(Exception.class, () -> {
            users.showUser(user.getId());
        });
    }

    @Test
    public void showUsers_AllUsers() {
        // Creating Stub
        RestApiMethods endPointsMethods = new UsersStub();
        Users users = new Users(endPointsMethods);

        // Asserting Answer
        assertDoesNotThrow(() -> {
            // Removing new user
            users.showUsers();
        });
    }

    @Test
    public void registerUser_EmptyEmail() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication registration = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            registration.registerUser("", "diogolol");
        });
    }

    @Test
    public void registerUser_EmptyPassword() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication registration = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            registration.registerUser("diogo@hotmail.com", "");
        });
    }

    @Test
    public void registerUser_AlreadyRegistered() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication registration = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            registration.registerUser("diogo@hotmail.com", "asdads");
        });
    }

    @Test
    public void registerUser_RegisteredUser() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication registration = new Authentication(endPointsMethods);

        assertDoesNotThrow(() -> {
            registration.registerUser("diogo1@hotmail.com", "asdads");
        });
    }

    @Test
    public void authenticateUser_EmptyEmail() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication authentication = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            authentication.authenticateUser("", "diogolol");
        });
    }

    @Test
    public void authenticateUser_EmptyPassword() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication authentication = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            authentication.authenticateUser("diogo@hotmail.com", "");
        });
    }

    @Test
    public void authenticateUser_AlreadyAuthenticated() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication authentication = new Authentication(endPointsMethods);

        assertThrows(Exception.class, () -> {
            authentication.registerUser("diogo@hotmail.com", "asdads");
        });
    }

    @Test
    public void authenticateUser_Authenticated() {
        // Creating Stub
        RestApiMethods endPointsMethods = new AuthenticationStub();
        Authentication authentication = new Authentication(endPointsMethods);

        assertDoesNotThrow(() -> {
            authentication.authenticateUser("diogo1@hotmail.com", "asdads");
        });
    }




}