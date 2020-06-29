package cache;

import interfaces.ResourcesInterface;
import types.Resource;

import java.util.ArrayList;

public class Resources {
    private ArrayList<Resource> resources = new ArrayList<Resource>();
    private final ResourcesInterface resourcesInterface;

    public Resources(ResourcesInterface resourcesInterface) {
        this.resourcesInterface = resourcesInterface;
    }

    public Resource listResource(Integer id) {
        return null;
    }

    public ArrayList<Resource> listResources() {
        return null;
    }
}
