package mocks;

import interfaces.ResourceRestApiMethods;
import types.Resource;

import java.util.ArrayList;
import java.util.Collection;

public class ResourcesMock implements ResourceRestApiMethods {

    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public ResourcesMock() {
        this.defaultResources();
    }

    private void defaultResources() {
        final Resource resource1 = new Resource(1, "Apple", 1997, "Yellow", "lol123");
        final Resource resource2 = new Resource(2, "Orange", 1997, "Yellow", "lol123");

        this.resources.add(resource1);
        this.resources.add(resource2);
    }

    @Override
    public Collection<Resource> getResources() {
        return this.resources.size() > 0 ? this.resources : null;
    }

    @Override
    public Resource getResource(Integer id) {
        for (Resource resource : this.resources)
            if (resource.getId() == id)
                return resource;

        return null;
    }
}
