package stubs;

import cache.Resources;
import interfaces.ResourceRestApiMethods;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ResourceStubTesting {

    // Application Testing

    @Test
    public void testShowResource_ResourceFoundAtCache_MustReturnResource() throws Exception {
        // Resource Stub
        ResourceRestApiMethods resourceRestApiMethods = new ResourcesStub();

        // Adding the Resource
        Resources resources = new Resources(resourceRestApiMethods);

        // Asserting Answer
        assertEquals(resources.showResource(1).getId(), 1);
    }

    @Test
    public void testShowResource_ResourceFoundAtStub_MustReturnResource() throws Exception {
        // Resource Stub
        ResourceRestApiMethods resourceRestApiMethods = new ResourcesStub();

        // Adding the Resource
        Resources resources = new Resources(resourceRestApiMethods);

        // Asserting Answer
        assertEquals(resources.showResource(2).getId(), 2);
    }

    @Test
    public void testShowResource_ResourceNotFoundAtStub_MustReturnException() throws Exception {
        // Resource Stub
        ResourceRestApiMethods resourceRestApiMethods = new ResourcesStub();

        // Adding the Resource
        Resources resources = new Resources(resourceRestApiMethods);

        // Asserting Answer
        assertThrows(Exception.class,() -> {
            resources.showResource(3);
        });
    }

    @Test
    public void testShowResources_ListOfResources_MustReturnAllResources() throws Exception {
        // Resource Stub
        ResourceRestApiMethods resourceRestApiMethods = new ResourcesStub();

        // Adding the Resource
        Resources resources = new Resources(resourceRestApiMethods);

        // Asserting Answer
        assertDoesNotThrow(() -> {
            resources.showResources();
        });
    }
}
