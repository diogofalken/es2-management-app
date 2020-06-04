package stubs;

import interfaces.ResourceRestApiMethods;
import types.Resource;

import java.util.ArrayList;
import java.util.Collection;

public class ResourcesStub implements ResourceRestApiMethods {
    public ResourcesStub() {}

    @Override
    public Collection<Resource> getResources() {
        final Resource resource1 = new Resource(1, "Apple", 1997, "Yellow", "lol123");
        final Resource resource2 = new Resource(2, "Orange", 1997, "Yellow", "lol123");

        final ArrayList<Resource> resources = new ArrayList<Resource>();

        resources.add(resource1);
        resources.add(resource2);

        return resources.size() > 0 ? resources : null;
    }

    @Override
    public Resource getResource(Integer id) {
        Resource resource = new Resource(1, "Apple", 1997, "Yellow", "lol123");

        if (resource.getId() == id)
            return resource;

        return null;
    }
}
