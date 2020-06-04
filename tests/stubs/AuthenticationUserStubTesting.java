package stubs;

import cache.Authentication;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticationUserStubTesting {

    // Testing Register Account

    @Test
    public void testRegisterAccount_CorrectEmailAndPassword_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationStub()).registerAccount("diogoxd97@hotmail.com", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingEmail_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationStub()).registerAccount("", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingPassword_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationStub()).registerAccount("diogo@hotmail.com", "");
        });
    }

    // Testing Authenticate Account

    @Test
    public void testAuthenticateAccount_CorrectEmailAndPassword_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationStub()).authenticateAccount("didogo@hotmail.com", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingEmail_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationStub()).authenticateAccount("", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingPassword_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationStub()).authenticateAccount("diogo@hotmail.com", "");
        });
    }
}
