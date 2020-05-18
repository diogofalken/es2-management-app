package cache;

import interfaces.ResourceRestApiMethods;
import types.Resource;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class Resources {

    //fields
    private HashMap<Integer, Resource> resources = new HashMap<Integer, Resource>();
    private ResourceRestApiMethods resourceRestApiMethods;

    public Resources(ResourceRestApiMethods resourceRestApiMethods) {
        this.resourceRestApiMethods = resourceRestApiMethods;
        this.defaultResources();
    }

    private void defaultResources() {
        final Resource resource1 = new Resource(1, "Apple", 1997, "Yellow", "lol123");
        this.resources.put(this.resources.size() + 1, resource1);
    }

    /**
     * Will list all the resources
     */
    public Collection<Resource> showResources() throws Exception {

        Collection<Resource> resources = this.resourceRestApiMethods.getResources();

        if(resources == null)
            throw new Exception("No resources found");

        return resources;
    }

    /**
     * Will list a Resource depending on its ID
     * @param id
     */
    public Resource showResource(Integer id) throws Exception {
        if (id == null)
            throw new Exception("Missing Id");

        for (Resource resource : this.resources.values()) {
            if (resource.getId() == id)
                return resource;
        }

        Resource resource = this.resourceRestApiMethods.getResource(id);

        if (resource == null)
            throw new Exception("Resource with that ID was not found");

        return resource;
    }
}
