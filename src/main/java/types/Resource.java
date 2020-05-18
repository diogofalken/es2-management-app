package types;

public class Resource {

    private Integer id;
    private final String name;
    private final Integer year;
    private final String color;
    private final String pantoneValue;

    public Resource(final Integer id, final String name, final Integer year, final String color, final String pantoneValue) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.color = color;
        this.pantoneValue = pantoneValue;
    }

    public String getPantoneValue() {
        return pantoneValue;
    }

    public String getColor() {
        return color;
    }

    public Integer getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

}