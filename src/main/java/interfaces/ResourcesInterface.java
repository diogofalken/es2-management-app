package interfaces;

import types.Resource;

import java.util.ArrayList;

public interface ResourcesInterface {
    ArrayList<Resource> getResources();

    Resource getResource(Integer id);
}
