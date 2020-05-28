package mocks;

import cache.Authentication;
import interfaces.AuthenticationRestApiMethods;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticationUserMockTesting {

    // Testing Register Account

    @Test
    public void testRegisterAccount_CorrectEmailAndPassword_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationMock()).registerAccount("diogoxd97@hotmail.com", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingEmail_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMock()).registerAccount("", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingPassword_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMock()).registerAccount("diogo@hotmail.com", "");
        });
    }

    // Testing Authenticate Account

    @Test
    public void testAuthenticateAccount_CorrectEmailAndPassword_MustNotReturnAnException() {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationMock()).authenticateAccount("didogo@hotmail.com", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingEmail_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMock()).authenticateAccount("", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingPassword_MustReturnAnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMock()).authenticateAccount("diogo@hotmail.com", "");
        });
    }
}
