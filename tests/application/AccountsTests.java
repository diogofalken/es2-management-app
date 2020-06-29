package application;

import cache.Accounts;
import org.junit.Test;
import stubs.AccountsStub;
import types.Account;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class AccountsTests {

    // Authenticate Method

    @Test
    public void testAuthenticateAccount_CorrectEmailCorrectPassword_MustReturnTrue() {
        Account account = new Account("FirstUser@gmail.com", "FirstUser");

        assertDoesNotThrow(() -> {
            // Register
            new Accounts(new AccountsStub()).registerAccount(account);
        });
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailCorrectPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_EmptyEmailFilledPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_FilledEmailEmptyPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmptyEmailEmptyPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsElevenCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsElevenInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTenCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTenInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTwentySixCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailLengthIsTwentySixInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailTypeIsStringCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_EmailTypeIsStringInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_EmailContainsEmailServiceCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_EmailContainsEmailServiceInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotContainEmailServiceCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotContainEmailServiceInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailMatchesCorrectCharactersCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_EmailMatchesCorrectCharactersInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotMatchCorrectCharactersCorrectPassword_MustNotReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_EmailDoesNotMatchCorrectCharactersInvalidPassword_MustNotReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsEight_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsEight_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsSeven_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsSeven_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordLengthIsSixteen_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordLengthIsSixteen_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordTypeIsString_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordTypeIsString_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordMatchesCorrectCharacters_MustReturnTrue() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordMatchesCorrectCharacters_MustReturnFalse() {
    }

    @Test
    public void testAuthenticateAccount_CorrectEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
    }

    @Test
    public void testAuthenticateAccount_InvalidEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
    }

    // Register Method

    @Test
    public void testRegisterAccount_CorrectEmailCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailCorrectPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_EmptyEmailFilledPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_FilledEmailEmptyPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmptyEmailEmptyPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsElevenCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsElevenInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTenCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTenInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTwentySixCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailLengthIsTwentySixInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailTypeIsStringCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_EmailTypeIsStringInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_EmailContainsEmailServiceCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_EmailContainsEmailServiceInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_EmailDoesNotContainEmailServiceCorrectPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailDoesNotContainEmailServiceInvalidPassword_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailMatchesCorrectCharactersCorrectPassword_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_EmailMatchesCorrectCharactersInvalidPassword_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_EmailDoesNotMatchCorrectCharactersCorrectPassword_MustNotReturnAnException() {
    }

    @Test
    public void testRegisterAccount_EmailDoesNotMatchCorrectCharactersInvalidPassword_MustNotReturnAnException() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsEight_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordLengthIsEight_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsSeven_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordLengthIsSeven_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordLengthIsSixteen_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordLengthIsSixteen_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordTypeIsString_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordTypeIsString_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordMatchesCorrectCharacters_MustReturnTrue() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordMatchesCorrectCharacters_MustReturnFalse() {
    }

    @Test
    public void testRegisterAccount_CorrectEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
    }

    @Test
    public void testRegisterAccount_InvalidEmailPasswordDoesNotMatchCorrectCharacters_MustReturnAnException() {
    }
}
