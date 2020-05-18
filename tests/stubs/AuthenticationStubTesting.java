package stubs;

import cache.Authentication;
import interfaces.AuthenticationRestApiMethods;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AuthenticationStubTesting {

    // Application Testing

    @Test
    public void testRegisterAccount_CorrectEmailAndPassword_MustNotReturnException() throws Exception {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertDoesNotThrow(() -> {
            // Register
            authentication.registerAccount("diogoxd97@hotmail.com", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_AlreadyRegistered_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.registerAccount("diogo@hotmail.com", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailAndPassword_MustNotReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertDoesNotThrow(() -> {
            // Register
            authentication.authenticateAccount("didogo@hotmail.com", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_AlreadyConnected_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.authenticateAccount("diogo@hotmail.com", "A12S");
        });
    }

    // Blackbox Testing

    @Test
    public void testRegisterAccount_MissingEmail_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.registerAccount("", "A12S");
        });
    }

    @Test
    public void testRegisterAccount_MissingPassword_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.registerAccount("diogo@hotmail.com", "");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingEmail_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.authenticateAccount("", "A12S");
        });
    }

    @Test
    public void testAuthenticateAccount_MissingPassword_MustReturnException() {
        // Account Stub
        AuthenticationRestApiMethods authenticationRestApiMethods = new AuthenticationStub();

        // Authentication
        Authentication authentication = new Authentication(authenticationRestApiMethods);

        assertThrows(Exception.class, () -> {
            // Register
            authentication.authenticateAccount("diogo@hotmail.com", "");
        });
    }
}
