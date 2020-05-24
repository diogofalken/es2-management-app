package integration;

import cache.Resources;
import middlewares.ResourcesMiddleware;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResourceIntegrationTesting {

    @Test
    public void testShowResource_ResourceFoundAtCache_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(1, new Resources(new ResourcesMiddleware()).showResource(1).getId());
    }

    @Test
    public void testShowResource_ResourceFoundAtMiddleware_MustReturnResource() throws Exception {
        // Asserting Answer
        assertEquals(5, new Resources(new ResourcesMiddleware()).showResource(5).getId());
    }

    @Test
    public void testShowResource_ResourceNotFound_MustReturnException() throws Exception {
        // Asserting Answer
        assertThrows(Exception.class,() -> {
            new Resources(new ResourcesMiddleware()).showResource(100);
        });
    }

    @Test
    public void testShowResources_ListOfResources_MustNotReturnException() throws Exception {
        // Asserting Answer
        assertDoesNotThrow(() -> {
            new Resources(new ResourcesMiddleware()).showResources();
        });
    }
}
