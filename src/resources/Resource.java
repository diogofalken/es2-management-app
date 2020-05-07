package resources;

public class Resource {
    private final Integer id;
    private final String name;
    private final Integer year;
    private final String color;
    private final String pantoneValue;

    public Resource(Integer id, String name, Integer year, String color, String pantoneValue) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantoneValue;
    }

    public Integer getId() { return id; }

    public String getName() { return name; }

    public Integer getYear() { return year; }

    public String getColor() { return color; }

    public String getPantoneValue() { return pantoneValue; }
}
