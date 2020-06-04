package stubs;

import cache.Resources;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceStubTesting {

    @Test
    public void testShowResource_ResourceFoundAtCache_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(1, new Resources(new ResourcesStub()).showResource(1).getId());
    }

    @Test
    public void testShowResource_ResourceFoundAtMock_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(1, new Resources(new ResourcesStub()).showResource(1).getId());
    }

    @Test
    public void testShowResource_ResourceNotFound_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class,() -> {
            new Resources(new ResourcesStub()).showResource(3);
        });
    }

    @Test
    public void testShowResources_ListOfResources_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Resources(new ResourcesStub()).showResources();
        });
    }
}
