package model;

import java.util.Objects;

public class Vegetable {

    private String name;
    private int caloriesIn100g;
    private String type;

    public Vegetable() {
    }

    public Vegetable(String name, int caloriesIn100g, String type) {
        this.name = name;
        this.caloriesIn100g = caloriesIn100g;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getCaloriesIn100g() {
        return caloriesIn100g;
    }

    public String getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vegetable vegetable = (Vegetable) o;
        return caloriesIn100g == vegetable.caloriesIn100g &&
                Objects.equals(name, vegetable.name) &&
                Objects.equals(type, vegetable.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, caloriesIn100g, type);
    }
}
