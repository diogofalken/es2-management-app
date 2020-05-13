package stubs;

import interfaces.RestApiMethods;
import types.Resource;
import types.User;

import java.util.ArrayList;
import java.util.Collection;

public class ResourcesStub implements RestApiMethods {

    private ArrayList<Resource> resources = new ArrayList<Resource>();

    public ResourcesStub() {
        this.defaultResources();
    }

    private void defaultResources() {
        final Resource resource1 = new Resource(1, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource2 = new Resource(2, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");
        final Resource resource3 = new Resource(3, "xX69FalcaoZinhoGamer69Xx@outlook.pt",  1997, "Yellow", "lol123");

        this.resources.add(resource1);
        this.resources.add(resource2);
        this.resources.add(resource3);
    }

    @Override
    public boolean addUser(User user) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<User> listUsers() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public User singleUser(Integer id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Resource> listResources() {
        if(this.resources.size() > 0)
            return this.resources;

        return null;
    }

    @Override
    public Resource singleResource(Integer id) {
        for(Resource resource : this.resources)
            if(resource.getId() == id)
                return resource;

        return null;
    }

    @Override
    public boolean authenticate(String email, String password) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean register(String email, String password) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
