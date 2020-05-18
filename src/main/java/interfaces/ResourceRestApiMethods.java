package interfaces;

import types.Resource;

import java.util.Collection;

public interface ResourceRestApiMethods {
    Collection<Resource> getResources();

    Resource getResource(Integer id);
}
