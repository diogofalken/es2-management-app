package cache;

import interfaces.RestApiMethods;
import types.Resource;


import java.util.Collection;
import java.util.HashMap;

public class Resources {

    //fields
    private HashMap<Integer, Resource> resources = new HashMap<Integer, Resource>();
    RestApiMethods restApiMethods;

    public Resources(RestApiMethods restApiMethods) {this.restApiMethods = restApiMethods;}

    /**
     * Will add a new Resource to the Resources HashMap
     * @param resource
     */
    public void addResource(Resource resource) {
        this.resources.forEach((key, value) -> {
            // Verifying if it already exists on the HashMap
            if(value.getId() == resource.getId())
                return;
            // Adding new Resource
            this.resources.put(this.resources.size() + 1, resource);
        });
    }

    /**
     * Will list all the resources
     */
    public Collection<Resource> showResources() throws Exception {

        Collection<Resource> resources = this.restApiMethods.listResources();

        if(resources == null)
            throw new Exception("No resources found");

        return resources;
    }

    /**
     * Will list a Resource depending on its ID
     * @param id
     */
    public Resource showResource(Integer id) throws Exception {
        for (Resource resource : this.resources.values()) {
            if(resource.getId() == id)
                return resource;
        }

        Resource resource = this.restApiMethods.singleResource(id);

        if(resource == null)
            throw new Exception("No resource with that ID found");

        return resource;
    }
}
