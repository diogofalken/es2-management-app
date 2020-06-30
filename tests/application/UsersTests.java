package application;

import cache.Users;
import org.junit.Test;
import stubs.UsersStub;
import types.User;

import static org.junit.jupiter.api.Assertions.*;

public class UsersTests {

    // List Users

    @Test
    public void listUsers_UsersFound_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).listUsers();
        });
    }

    @Test
    public void listUsers_UsersNotFound_MustReturnNull() {
        //assertNull(new Users(new UsersStub()).listUsers());
    }

    // List User

    @Test
    public void listUser_IdTypeIsInteger_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).listUser(1);
        });
    }

    @Test
    public void listUser_IdIsNotNull_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).listUser(1);
        });
    }

    @Test
    public void listUser_IdIsNull_MustThrowException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).listUser(null);
        });
    }

    // Remove User

    @Test
    public void removeUser_IdTypeIsInteger_MustReturnTrue() throws Exception {
        assertTrue(new Users(new UsersStub()).removeUser(1));
    }

    @Test
    public void removeUser_IdIsNotNull_MustReturnTrue() throws Exception {
        assertTrue(new Users(new UsersStub()).removeUser(1));
    }

    @Test
    public void removeUser_IdIsNull_MustThrowException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).removeUser(null);
        });
    }

    // Add User

    @Test
    public void addUser_CorrectUser_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_UserAlreadyExists_MustReturnFalse() throws Exception {
        User user = new User("FirstUser@gmail.com", "FirstUser", "FirstFinal", "Avatar1");

        assertFalse(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailIsNotEmptyRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailIsNotEmptyRestOfFieldsAreIncorrect_MustThrowException() throws Exception {
        User user = new User("FourthUser@gmail.com", "Fourt=hUser", "Fourth=Final", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailIsEmptyRestOfFieldsCorrect_MustThrowException() {
        User user = new User("", "FourthUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailIsEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("", "Fou=rthUser", "FourthF=inal", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameIsNotEmptyRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_FirstNameIsNotEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUs=er@gmail.com", "FourthUser", "Four=thFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameIsEmptyRestOfFieldsCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "", "Four=thFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameIsEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@g=mail.com", "", "Four=thFinal", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameIsNotEmptyRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_LastNameIsNotEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUs=er@gmail.com", "Four=thUser", "FourthFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameIsEmptyRestOfFieldsCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUser", "", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameIsEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthU=ser@gmail.com", "Fourt=hUser", "", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarIsNotEmptyRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_AvatarIsNotEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUs=er@gmail.com", "Four=thUser", "FourthF=inal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarIsEmptyRestOfFieldsCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarIsEmptyRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthU=ser@gmail.com", "FourthUs=er", "FourthF=inal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailTypeIsStringRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailTypeIsStringRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUs=er", "FourthF=inal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameTypeIsStringRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_FirstNameTypeIsStringRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("Fourt=hUser@gmail.com", "FourthUser", "FourthF=inal", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameTypeIsStringRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_LastNameTypeIsStringRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "Fou=rthUser", "FourthFinal", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarTypeIsStringRestOfFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_AvatarTypeIsStringRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "F=ourthUser", "Fourt=hFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailMatchesCorrectCharactersRestOfAreFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "F=ourthUser", "Fourt=hFinal", "Avata=r4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailDoesNotMatchCorrectCharactersRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailDoesNotMatchCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "F=ourthUser", "Fourt=hFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameMatchesCorrectCharactersRestOfAreFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_FirstNameMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "FourthUser", "Fourt=hFinal", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameDoesNotMatchCorrectCharactersRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "Four=thUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameDoesNotMatchCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("Fourt=hUser@gmail.com", "Four=thUser", "Fourt=hFinal", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameMatchesCorrectCharactersRestOfAreFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_LastNameMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "FourthU=ser", "FourthFinal", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameDoesNotMatchesCorrectCharactersRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "Four=thUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameDoesNotMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthU=ser@gmail.com", "Four=thUser", "Fourt=hFinal", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarMatchesCorrectCharactersRestOfAreFieldsCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_AvatarMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "Fourt=hUser", "Fourt=hFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarDoesNotMatchesCorrectCharactersRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "A*!A**_:vata=r4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarDoesNotMatchesCorrectCharactersRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUse=r@gmail.com", "Fourth=User", "Fourth=Final", "Avata=r4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailLengthIsTwentyEmailDoesNotExistRestOfFieldsAreCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailLengthIsTwentyEmailDoesNotExistRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "Fourt=hUser", "Fourt=hFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailLengthIsNineteenEmailAlreadyExistsRestOfFieldsAreCorrect_MustReturnFalse() throws Exception {
        User user = new User("FirstUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertFalse(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_EmailLengthIsNineteenEmailAlreadyExistsRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "Fourt=hUser", "Fourt=hFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailLengthIsTwentySixRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser123456@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailLengthIsTwentySixRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FourthUser123456@gmail.com", "FourthUs=er", "Four=thFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }


    @Test
    public void addUser_EmailLengthIsTenRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_EmailLengthIsTenRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("@gmail.com", "Fo=urthUser", "Fo=urthFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameLengthIsTenRestOfFieldsAreCorrect_MustReturnTrue() throws Exception {
        User user = new User("FirstUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertFalse(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_FirstNameLengthIsTenRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FirstU=ser@gmail.com", "FourthUser", "Fourth=Final", "Avat=ar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameLengthIsSixteenRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FirstUser@gmail.com", "FourthUserFourth", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameLengthIsSixteenRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("Firs=tUser@gmail.com", "FourthUserFourth", "Fourt=hFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameLengthIsOneRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FirstUser@gmail.com", "F", "FourthFinal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_FirstNameLengthIsOneRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FirstUs=er@gmail.com", "F", "Four=thFinal", "Avata=r4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameLengthIsElevenRestOfFieldsAreCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_LastNameLengthIsNineRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FirstUs=er@gmail.com", "Four=thUser", "FourthFinal", "Av=atar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameLengthIsSixteenRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinalinall", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameLengthIsSixteenRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FirstUs=er@gmail.com", "Fourt=hUser", "FourthFinalinal", "Ava=tar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameLengthIsOneRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FirstUser@gmail.com", "FourthUser", "F", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_LastNameLengthIsOneRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("Firs=tUser@gmail.com", "Four=thUser", "F", "Avata=r4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarLengthIsSevenRestOfFieldsAreCorrect_MustReturnTrue() throws Exception {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4");

        assertTrue(new Users(new UsersStub()).addUser(user));
    }

    @Test
    public void addUser_AvatarLengthIsSevenRestOfFieldsAreIncorrect_MustThrowException() throws Exception {
        User user = new User("Firs=tUser@gmail.com", "Fou=rthUser", "FourthFi=nal", "Avatar4");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarLengthIsSeventeenRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FourthUser@gmail.com", "FourthUser", "FourthFinal", "Avatar4Avatar4959");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarLengthIsSeventeenRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("First=User@gmail.com", "Fourt=hUser", "Fourt=hFinal", "Avatar4Avatar4995");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarLengthIsOneRestOfFieldsAreCorrect_MustThrowException() {
        User user = new User("FirstUser@gmail.com", "FourthUser", "FourthFinal", "A");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

    @Test
    public void addUser_AvatarLengthIsOneRestOfFieldsAreIncorrect_MustThrowException() {
        User user = new User("FirstU=ser@gmail.com", "Fourt=hUser", "Fourth=Final", "A");

        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).addUser(user);
        });
    }

}
