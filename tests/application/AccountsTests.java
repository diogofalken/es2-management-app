package application;

import cache.Accounts;
import org.junit.Test;
import stubs.AccountsStub;
import types.Account;

import static org.junit.jupiter.api.Assertions.*;

public class AccountsTests {

    // Authenticate Method

    @Test
    public void testAuthenticateAccount_CorrectEmailCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailCorrectPassword_MustReturnFalse() throws Exception {
        Account account = new Account("InvalidEmail@gmail.com", "FirstUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "InvalidPassword");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("InvalidEmail@gmail.com", "InvalidPassword");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmptyEmailFilledPassword_MustReturnAnException() throws Exception {
        Account account = new Account("", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_FilledEmailEmptyPassword_MustReturnAnException() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmptyEmailEmptyPassword_MustReturnAnException() {
        Account account = new Account("", "");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsNineteenCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsNineteenInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "InvalidPassword");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTenCorrectPassword_MustReturnAnException() {
        Account account = new Account("@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTenInvalidPassword_MustReturnAnException() {
        Account account = new Account("@gmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTwentySixCorrectPassword_MustReturnAnException() {
        Account account = new Account("FirstUserFirstUs@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTwentySixInvalidPassword_MustReturnAnException() {
        Account account = new Account("FirstUserFirstUs@gmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailTypeIsStringCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailTypeIsStringInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "InvalidPassword");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailContainsEmailServiceCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailContainsEmailServiceInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "InvalidUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotContainEmailServiceCorrectPassword_MustReturnAnException() {
        Account account = new Account("FirstUser@hotmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotContainEmailServiceInvalidPassword_MustReturnAnException() {
        Account account = new Account("FirstUser@hotmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailMatchesCorrectCharactersCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailMatchesCorrectCharactersInvalidPassword_MustReturnFalse() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "InvalidUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotMatchCorrectCharactersCorrectPassword_MustReturnAnException() throws Exception {
        Account account = new Account("First=_Us.er@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotMatchCorrectCharactersInvalidPassword_MustReturnAnException() {
        Account account = new Account("Fir_=stUs.er@gmail.com", "InvalidUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsNine_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsNine_MustReturnFalse() throws Exception {
        Account account = new Account("InvalidUser@gmail.com", "FirstUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsSeven_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "Invalid");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsSeven_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "Invalid");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsSixteen_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "InvalidUserInval");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsSixteen_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "InvalidUserInval");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordTypeIsString_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordTypeIsString_MustReturnFalse() throws Exception {
        Account account = new Account("InvalidUser@gmail.com", "FirstUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordMatchesCorrectCharacters_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordMatchesCorrectCharacters_MustReturnFalse() throws Exception {
        Account account = new Account("InvalidUser@gmail.com", "FirstUser");

        assertFalse(new Accounts(new AccountsStub()).authenticateAccount(account));
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "Firs.tUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "Firs.tUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).authenticateAccount(account);
        });
    }

    // Register Method

    @Test
    public void testRegisterAccount_CorrectEmailCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_EmptyEmailFilledPassword_MustReturnAnException() throws Exception {
        Account account = new Account("", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_FilledEmailEmptyPassword_MustReturnAnException() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmptyEmailEmptyPassword_MustReturnAnException() {
        Account account = new Account("", "");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailLengthIsNineteenCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTenCorrectPassword_MustReturnAnException() {
        Account account = new Account("@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTenInvalidPassword_MustReturnAnException() {
        Account account = new Account("@gmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTwentySixCorrectPassword_MustReturnAnException() {
        Account account = new Account("FirstUserFirstUs@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTwentySixInvalidPassword_MustReturnAnException() {
        Account account = new Account("FirstUserFirstUs@gmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailTypeIsStringCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_EmailContainsEmailServiceCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_EmailDoesNotContainEmailServiceCorrectPassword_MustReturnAnException() {
        Account account = new Account("FirstUser@hotmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void ttestRegisterAccount_EmailDoesNotContainEmailServiceInvalidPassword_MustReturnAnException() {
        Account account = new Account("FirstUser@hotmail.com", "InvalidPassword");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailMatchesCorrectCharactersCorrectPassword_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_EmailDoesNotMatchCorrectCharactersCorrectPassword_MustReturnAnException() throws Exception {
        Account account = new Account("First=_Us.er@gmail.com", "FirstUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_EmailDoesNotMatchCorrectCharactersInvalidPassword_MustReturnAnException() {
        Account account = new Account("Fir_=stUs.er@gmail.com", "InvalidUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsNine_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsSeven_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "Invalid");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordLengthIsSeven_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "Invalid");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsSixteen_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "InvalidUserInval");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordLengthIsSixteen_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "InvalidUserInval");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordTypeIsString_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordMatchesCorrectCharacters_MustReturnTrue() throws Exception {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertTrue(new Accounts(new AccountsStub()).registerAccount(account));
    }
    
    @Test
    public void testRegisterAccount_CorrectEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
        Account account = new Account("FirstUser@gmail.com", "Firs.tUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
        Account account = new Account("InvalidUser@gmail.com", "Firs.tUser");

        assertThrows(Exception.class, () -> {
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }
}