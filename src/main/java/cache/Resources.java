package cache;

import interfaces.ResourcesInterface;
import types.Resource;

import java.util.ArrayList;

public class Resources {
    private final ResourcesInterface resourcesInterface;

    public Resources(ResourcesInterface resourcesInterface) {
        this.resourcesInterface = resourcesInterface;
    }

    public Resource listResource(Integer id) throws Exception {
        if((id instanceof Integer) == false) {
            throw new Exception("Id must be integer!");
        }

        if(id == null) {
            throw new Exception("Id can't be null!");
        }

        return this.resourcesInterface.getResource(id);
    }

    public ArrayList<Resource> listResources() {
        return this.resourcesInterface.getResources();
    }
}
