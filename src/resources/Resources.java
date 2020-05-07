package resources;

import java.util.HashMap;

public class Resources {
    //fields
    private static Resources instance = null;
    private HashMap<Integer, Resource> resources = new HashMap<Integer, Resource>();

    private Resources() {
    }

    // instance
    public static Resources getInstance() {
        if(instance == null)
            instance = new Resources();

        return instance;
    }

    // show resources
    public void showResources() {
        this.resources.forEach((key, resource) -> {
            System.out.println(
                    "Id: " + resource.getId() + " " +
                    "Name: " + resource.getName() + " " +
                    "Year: " + resource.getYear() + " " +
                    "Color: " + resource.getColor() + " " +
                    "PantoneValue: " + resource.getPantoneValue());
        });
    }

    // show resource
    public void showResource(Integer id) {
        this.resources.forEach((key, resource) -> {
            if(resource.getId() == id) {
                System.out.println(
                    "Id: " + resource.getId() + " " +
                    "Name: " + resource.getName() + " " +
                    "Year: " + resource.getYear() + " " +
                    "Color: " + resource.getColor() + " " +
                    "PantoneValue: " + resource.getPantoneValue()
                );
            }
        });
    }
}
