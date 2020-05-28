package mocks;

import cache.Resources;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceMockTesting {

    @Test
    public void testShowResource_ResourceFoundAtCache_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(1, new Resources(new ResourcesMock()).showResource(1).getId());
    }

    @Test
    public void testShowResource_ResourceFoundAtMock_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(2, new Resources(new ResourcesMock()).showResource(2).getId());
    }

    @Test
    public void testShowResource_ResourceNotFound_MustReturnAnException() {
        // Asserting Answer
        assertThrows(Exception.class,() -> {
            new Resources(new ResourcesMock()).showResource(3);
        });
    }

    @Test
    public void testShowResources_ListOfResources_MustNotReturnAnException() {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Resources(new ResourcesMock()).showResources();
        });
    }
}
