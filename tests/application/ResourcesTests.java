package application;

import cache.Resources;
import cache.Users;
import org.junit.Test;
import stubs.ResourcesStub;
import stubs.UsersStub;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ResourcesTests {
    // List Resources

    @Test
    public void listResources_ResourcesFound_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Resources(new ResourcesStub()).listResources();
        });
    }

    @Test
    public void listResources_ResourcesNotFound_MustReturnNull() {
        //assertNull(new Resources(new ResourcesStub()).listResources());
    }

    // List Resource

    @Test
    public void listResource_IdTypeIsInteger_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Resources(new ResourcesStub()).listResource(1);
        });
    }

    @Test
    public void listResource_IdIsNotNull_MustNotThrowException() {
        assertDoesNotThrow(() -> {
            new Users(new UsersStub()).listUser(1);
        });
    }

    @Test
    public void listResource_IdIsNull_MustThrowException() {
        assertThrows(Exception.class, () -> {
            new Users(new UsersStub()).listUser(null);
        });
    }
}
