package integration;

import cache.Authentication;
import middlewares.AuthenticationMiddleware;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticationIntegrationTesting {

    @Test
    public void testRegisterAccount_CorrectEmailAndPassword_MustNotReturnException() throws Exception {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).registerAccount("diogoxd97@hotmail.com", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailAndPassword_MustNotReturnException() {
        assertDoesNotThrow(() -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).authenticateAccount("didogo@hotmail.com", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingEmail_MustReturnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).registerAccount("", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingPassword_MustReturnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).registerAccount("diogo@hotmail.com", "");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingEmail_MustReturnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).authenticateAccount("", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingPassword_MustReturnException() {
        assertThrows(Exception.class, () -> {
            // Register
            new Authentication(new AuthenticationMiddleware()).authenticateAccount("diogo@hotmail.com", "");
        });
    }
}
