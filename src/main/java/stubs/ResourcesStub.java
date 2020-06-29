package stubs;

import interfaces.ResourcesInterface;
import types.Resource;

import java.util.ArrayList;

public class ResourcesStub implements ResourcesInterface {

    @Override
    public ArrayList<Resource> getResources() {
        // Creating ArrayList
        final ArrayList<Resource> resources = new ArrayList<Resource>();

        // Creating Resources
        final Resource resource0 = new Resource(1, "Apple", 1997, "Yellow", "00-0001");
        final Resource resource1 = new Resource(2, "Orange", 1997, "Yellow", "00-0002");

        // Adding Resource
        resources.add(resource0);
        resources.add(resource1);

        // Checking Resources Size
        if (resources.size() == 0) {
            return null;
        }

        return resources;
    }

    @Override
    public Resource getResource(Integer id) {
        // Creating Resource
        Resource resource = new Resource(1, "Apple", 1997, "Yellow", "00-0001");

        if (resource.getId() != id) {
            return null;
        }

        return resource;
    }
}
