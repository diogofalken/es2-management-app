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
        assertEquals(1, resources.showResource(1).getId());
    }

    @Test
    public void testShowResource_ResourceFoundAtStub_MustReturnResource() throws Exception {
        // Resource Stub
        ResourceRestApiMethods resourceRestApiMethods = new ResourcesStub();

        // Adding the Resource
        Resources resources = new Resources(resourceRestApiMethods);

        // Asserting Answer
        assertEquals(2, resources.showResource(2).getId());
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
    public void testShowResources_ListOfResources_MustNotReturnException() throws Exception {
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
